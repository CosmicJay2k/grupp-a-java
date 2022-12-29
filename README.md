## Spring Boot API with Keycloak and mySql in docker, React frontend, and CI on GitHub 

Prerequisites:
Docker

1. Clone repo.
    a. Create a .env in root folder containing:
        SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/test
        SPRING_DATASOURCE_USER=_user_
        SPRING_DATASOURCE_PASSWORD=_password_
        SQL_SERVER_NAME=_test_
        KEYCLOAK_ADMIN_NAME=_admin_
        KEYCLOAK_ADMIN_PASSWORD=_admin_
    b. Run _docker compose -f ./SetupCompose.yml up -d_.
2. Visit _localhost:3000_ 
