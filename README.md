# bookstore

## Swagger

Swagger local: http://localhost:8443/bookstore/v1/swagger-ui/index.html


## Actuator

Em relação ao actuator, apliquei algumas configurações recomendadas, porém nada muito "complicado" para este iníco.
As configurações podem ser vistas no rapplication.yaml também. Sobre a autenticação necessária, como está InMemoryUserDetailsManager configurado com spring security basic, pode ser visto no arquivo de configurações SecurityConfig.

Actuator local: http://localhost:1979/ad-management



Basic Auth

username: admin

password: password
