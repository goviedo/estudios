Se puede ver aqui:

https://gonzalooviedo.proto.io/editor/index.cfm?id=91d603f2-ba32-4d2a-a946-4319af46e49e

![[Pasted image 20230812102921.png]]
# Desarrollo

## Github

* https://github.com/goviedo/rifa
* git@github.com:goviedo/rifa.git

# Inicializacion o Creacion del Proyecto Phoenix Live View

## Instalacion de Phoenix y creacion del proyecto.

Referencia en mi trello para instalacion de elixir/erlang completo con asdf

* https://trello.com/c/B0cGqYCm/71-elixir-with-asdf-installation

```bash
wget https://github.com/phoenixframework/archives/raw/master/phoenix_new.ez
mix archive.install ./phoenix_new.ez
mix archive.install hex phx_new
```

```bash
mix phx.new rifa
```


## Base de datos

La base de datos se configura con docker con postgredb y los datos quedan en /op/datadrive/pgdatarifa

```docker
version: '3.3'

services:

 db:
     image: postgres:9.6
     container_name: rifa
     environment:
         POSTGRES_PASSWORD: postgres
         PGDATA: /opt/pgsql/data
     ports:
         - 5432:5432
     volumes:
         - /opt/datadrive/pgdatarifa:/opt/pgsql/data
     privileged: true
```

```bash
docker-compose up -d
```

**Inicializando la creacion en elixir de la base de datos**

```shell
mix ecto.create
```

# RUN del proyecto. 

Uno de estos 2 comandos

```bash
mix phx.server
iex -S mix phx.server
```

# Creacion de la autenticacion

```bash
mix phx.gen.auth Accounts User users
mix deps.get
mix ecto.migrate
mix test
```

# User / pass creados

* g@g.com / gonzalo.oviedo

