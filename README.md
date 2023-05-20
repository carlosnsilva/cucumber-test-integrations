###  Docker

Start
```shell
cd local && ./start.sh
```

Stop
```shell
cd local && ./stop.sh
```

### App
Start
```shell
./gradlew bootRun
```

###  Criar cliente
```shell
curl --request POST \
--url http://localhost:8080/v1/clientes \
--header 'Content-Type: application/json' \
--data '{
    "cpf": "980981200912",
    "nome": "Carlos",
    "email": "carlos@test.com",
    "conta": {
      "status": "ATIVA",
      "tipo": "CORRENTE"
    }
}'
```

###  Buscar cliente
```shell
curl --request GET \
  --url http://localhost:8080/v1/clientes/980981200912
```

## pgAdmin

http://localhost:5050/

```properties
admin@admin.com
password
```

Object Explorer > Servers > Register > Server ...

General
```properties
Name: stackspot
```
Connection
```properties
HostName: db
database: stackspot
username: postgres
password: password
```
and Save