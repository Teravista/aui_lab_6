package proj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class AuiLab2Application {

	public static void main(String[] args) {
		SpringApplication.run(AuiLab2Application.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${rpg.character.url}") String meatProductUrl,
			@Value("${rpg.profession.url}") String meatTypeUrl,
			@Value("${rpg.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("meatTypes", route -> route
						.host(host)
						.and()
						.path(
								"/api/meatTypes/{uuid}",
								"/api/meatTypes"
						)
						.uri(meatTypeUrl)
				)
				.route("meatProducts", route -> route
						.host(host)
						.and()
						.path(
								"/api/meatProducts",
								"/api/meatProducts/**",
								"/api/meatTypes/{uuid}/meatProducts",
								"/api/meatTypes/{uuid}/meatProducts/**"
						)
						.uri(meatProductUrl)
				)
				.build();
	}
	@Bean
	public CorsWebFilter corsWebFilter() {

		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
		corsConfig.addAllowedHeader("*");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
}
