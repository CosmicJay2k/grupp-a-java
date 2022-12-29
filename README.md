## Spring Boot API with Keycloak and mySql in docker, React frontend, and CI on GitHub 

Prerequisites:<br>
Docker<br>

1. Clone repo.<br>
    a. Create a __.env__ in root folder containing:<br>
        SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/test<br>
        SPRING_DATASOURCE_USER=<em>user</em><br>
        SPRING_DATASOURCE_PASSWORD=<em>password</em><br>
        SQL_SERVER_NAME=<em>test</em><br>
        KEYCLOAK_ADMIN_NAME=<em>admin</em><br>
        KEYCLOAK_ADMIN_PASSWORD=<em>admin</em><br>
    b. Run __docker compose -f ./SetupCompose.yml up -d__.<br>
2. Visit __localhost:3000__ <br>
