FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="meat_product"
LABEL org.opencontainers.image.authors="Michał (psysiu) Wójcik"
LABEL org.opencontainers.image.source="https://git.pg.edu.pl/platformy-technologiczne/simple-rpg"
LABEL org.opencontainers.image.url="https://git.pg.edu.pl/internet-services-architectures"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.description="Simple RPG game, character module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:meat_product
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/meat_product-${VERSION}.jar /opt/meat_product/meat_product.jar

CMD ["java", "-jar", "/opt/meat_product/meat_product.jar"]
