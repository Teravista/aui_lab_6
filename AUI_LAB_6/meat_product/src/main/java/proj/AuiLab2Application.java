package proj;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AuiLab2Application {

	public static void main(String[] args) {
		SpringApplication.run(AuiLab2Application.class, args);
	}

	/**
	 * @return managed bean for configured {@link ObjectWriter}
	 */
	@Bean
	public ObjectWriter objectWriter() {
		return new ObjectMapper()
				.enable(SerializationFeature.INDENT_OUTPUT)
				.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
				.writer(new DefaultPrettyPrinter()
						.withArrayIndenter(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE));
	}

}
