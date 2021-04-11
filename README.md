# ComparaJá - Code Challenge

- Persistence - PostgreSQL

- Backend service - Spring Boot application (Tomcat)

- Frontend web application - React single page application

## Persistence

This project uses a PostgreSQL relational database for data persistence. Docker was the appropriate choice to setup a local development environment. The latest version from docker hub was used:

`docker pull postgres`

To spin up the container run:

`docker run -d --name dev-postgres -e POSTGRES_PASSWORD={the_db_password} -v {the_db_file_path}/:/var/lib/postgresql/data -p {the_port_range}:{the_port_range} {the_db_name}`

![docker](/doc_images/docker.png)

Use these attributes to setup access on your DB editor of choice.

![SpringBoot](/doc_images/DBeaverPostgreSQL.png)

To create the tables run `/backend/sql/create_tables.sql` on your db editor of choice.

Import the *.csv files on your db editor of choice. Each .csv file has a direct corresponding table.

![SpringBoot](/doc_images/DBeaverImport.png)

To return a list of all active products for broadband run `/backend/sql/active_products_for_broadband.sql` on your db editor of choice.

## Backend service

This project uses Spring Boot for backend endpoint implementattion and data access and a local JVM installation is required. To build the backend application run `mvn install` on `/backend/products`.

To start the application run:

 `java -jar challenge-0.0.1.jar --spring.datasource.url=jdbc:postgresql://{the_db}:{the_db_port}/{the_db_name} --spring.datasource.username={the_db_username} --spring.datasource.password={the_db_password} --server.port={the_db_port} --apiKey={the_api_key}
 `

Once built, the .jar file can be found on `/backend/products/target`

![SpringBoot](/doc_images/SpringBoot.png)

## OpenAPI documentation

For a quick endpoint test environment, import `/openapi.yaml` on [Swagger Editor](https://editor.swagger.io/) and edit the server settings according to your local installation:

```
servers:
  - url: '{protocol}://api.comparaja.pt:{port}'
    variables:
      protocol:
        enum:
          - http
        default: http
      port:
        enum:
          - '8080'
        default: '8080'
```

To test the application use `the_api_key` to authenticate your requests.

![swagger](/doc_images/swagger_01.png)
![swagger](/doc_images/swagger_02.png)
![swagger](/doc_images/swagger_03.png)

## Frontend web application
This project uses React to build a single page web application and a local Node.js installation is required.

To install the local dependencies run `yarn install` on `/comparaja-ui`.

The application uses two environment variables. To provide them, create the `/comparaja-ui/.env` file and add the lines:

```
REACT_APP_SERVICE_ENPOINT={the_service_endpoint}
REACT_APP_API_KEY={the_api_key}
```

To start the app locally run `yarn start` on `/comparaja-ui`. Once finished the app is available on your local host machine on port `:3000`.

![WebApp](/doc_images/frontend.png)

The application loads a random `sunshine` background and displays a grid of cards, each displaying a product. Each card displays the provider logo (with a name tooltip) and lists the data attributes. Sponsored products are highlighted with special colors and animations. Material-UI provides the React components and utilities (based on Google's Material Design) to build the design system.