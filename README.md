# bookstore

## Swagger

Swagger local: http://localhost:8080/bookstore/v1/swagger-ui/index.html


## Actuator

Em relação ao actuator, apliquei algumas configurações recomendadas, porém nada muito "complicado" para este início.
As configurações podem ser vistas no application.yaml também. Sobre a autenticação necessária, como está InMemoryUserDetailsManager configurado com spring security basic, pode ser visto no arquivo de configurações SecurityConfig.

Actuator local: http://localhost:1979/ad-management



Basic Auth

username: admin

password: password
