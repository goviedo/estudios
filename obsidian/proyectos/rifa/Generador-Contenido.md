Vamos a generar la estructura de la rifa.

```bash
mix phx.gen.live Boleto Sorteo sorteos nombre:string descripcion:string
```

``` 
* creating lib/rifa_web/live/sorteo_live/show.ex  
* creating lib/rifa_web/live/sorteo_live/index.ex  
* creating lib/rifa_web/live/sorteo_live/form_component.ex  
* creating lib/rifa_web/live/sorteo_live/index.html.heex  
* creating lib/rifa_web/live/sorteo_live/show.html.heex  
* creating test/rifa_web/live/sorteo_live_test.exs  
* creating lib/rifa/boleto/sorteo.ex  
* creating priv/repo/migrations/20230814220433_create_sorteos.exs  
* creating lib/rifa/boleto.ex  
* injecting lib/rifa/boleto.ex  
* creating test/rifa/boleto_test.exs  
* injecting test/rifa/boleto_test.exs  
* creating test/support/fixtures/boleto_fixtures.ex  
* injecting test/support/fixtures/boleto_fixtures.ex  
  
Add the live routes to your browser scope in lib/rifa_web/router.ex:  
  
   live "/sorteos", SorteoLive.Index, :index  
   live "/sorteos/new", SorteoLive.Index, :new  
   live "/sorteos/:id/edit", SorteoLive.Index, :edit  
  
   live "/sorteos/:id", SorteoLive.Show, :show  
   live "/sorteos/:id/show/edit", SorteoLive.Show, :edit
```

## Contexto Boleto

El boleto se va a referir a la rifa en si.

El Sorteo es el recurso generado para almacenar este sorteo, compuesto por un nombre del sorteo y su descripcion.



