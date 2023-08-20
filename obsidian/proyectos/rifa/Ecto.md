1. https://alchemist.camp/episodes/ecto-beginner-migrations
2. https://devhints.io/phoenix-migrations

Por lo que entiendo, se genera cambios en las tablas o creacion de nuevas tablas ejecutando
```bash
mix ecto.gen.migration update_post_table
```

Esto genera un archivo en

```
$PROYECTO/priv/repo/migrations
```

En el link 2 se pueden ver las operaciones que se pueden hacer dentro de estos migrations, como alter, create, etc.

Luego uno ejecuta 

```bash
mix ecto.migrate
```

Y estos se ejecutan