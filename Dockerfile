# Diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR da aplicação
COPY target/backend-1.1.0.jar app.jar

# Variáveis de ambiente do Flyway (altere de acordo com suas configurações)
ENV FLYWAY_URL=jdbc:postgresql://postgres:CxJi5RbllxhGkYXj9aFd@containers-us-west-210.railway.app:7338/railway
ENV FLYWAY_USER=containers-us-west-210.railway.app
ENV FLYWAY_PASSWORD=CxJi5RbllxhGkYXj9aFd

# Instalar o Flyway
RUN wget -qO- https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/8.0.2/flyway-commandline-8.0.2-linux-x64.tar.gz | tar xvz && \
    mv flyway-8.0.2 /flyway

# Executar as migrações do banco de dados
RUN /flyway/flyway -user=${FLYWAY_USER} -password=${FLYWAY_PASSWORD} -url=${FLYWAY_URL} migrate

# Comando para executar a aplicação Spring Boot
CMD ["java", "-jar", "app.jar"]