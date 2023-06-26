# Variáveis de ambiente do Flyway (altere de acordo com suas configurações)
ENV FLYWAY_URL=postgresql://postgres:4GokgpPBxq8b1BPAXXYC@containers-us-west-209.railway.app:6539/railway
ENV FLYWAY_USER=containers-us-west-209.railway.app
ENV FLYWAY_PASSWORD=4GokgpPBxq8b1BPAXXYC

# Instalar o Flyway
RUN wget -qO- https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/8.0.2/flyway-commandline-8.0.2-linux-x64.tar.gz | tar xvz && \
    mv flyway-8.0.2 /flyway

# Executar as migrações do banco de dados
RUN /flyway/flyway -user=${FLYWAY_USER} -password=${FLYWAY_PASSWORD} -url=${FLYWAY_URL} migrate
