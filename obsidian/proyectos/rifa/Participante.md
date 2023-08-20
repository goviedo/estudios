Un participante es quien participa de la rifa. 

Para poder generar el contexto, las relaciones, la tabla, las vista, en definitiva el modelo CRUD, debemos usar algo como el siguiente comando:

```bash
mix phx.gen.live Catalog Product products name:string \
description:string unit_price:float sku:integer:unique
```

```
mix phx.gen.live Boleto Participante par  
ticipantes numero:integer nombre:string correo:string
```



## Modelo

Participantes
		- id
		- sorteo_id
		- numero
		- nombre
		- correo

# Codigo respaldo

```
<.table

id="participantes"

rows={@streams.participantes}

row_click={fn {_id, participante} -> JS.navigate(~p"/participantes/#{participante}") end}

>

<:col :let={{_id, participante}} label="Numero"><%= participante.numero %></:col>

<:col :let={{_id, participante}} label="Nombre"><%= participante.nombre %></:col>

<:col :let={{_id, participante}} label="Correo"><%= participante.correo %></:col>

<:action :let={{_id, participante}}>

<div class="sr-only">

<.link navigate={~p"/participantes/#{participante}"}>Show</.link>

</div>

<.link patch={~p"/participantes/#{participante}/edit"}>Edit</.link>

</:action>

<:action :let={{id, participante}}>

<.link

phx-click={JS.push("delete", value: %{id: participante.id}) |> hide("##{id}")}

data-confirm="Are you sure?"

>

Delete

</.link>

</:action>

</.table>

  

<.modal :if={@live_action in [:new, :edit]} id="participante-modal" show on_cancel={JS.patch(~p"/participantes")}>

<.live_component

module={RifaWeb.ParticipanteLive.FormComponent}

id={@participante.id || :new}

title={@page_title}

action={@live_action}

participante={@participante}

patch={~p"/participantes"}

/>

</.modal>
```

Este esta el mount de index.ex de partipante_live/

```
{:ok, stream(socket, :participantes, Boleto.list_participantes())}
```

Boton de accion de nuevo participante

```
<:actions>

<.link patch={~p"/participantes/new"}>

<.button>New Participante</.button>

</.link>

</:actions>
```

## show.html.heex completo

```elixir
<.header>

Participante <%= @participante.id %>

<:subtitle>This is a participante record from your database.</:subtitle>

<:actions>

<.link patch={~p"/participantes/#{@participante}/show/edit"} phx-click={JS.push_focus()}>

<.button>Edit participante</.button>

</.link>

</:actions>

</.header>

  

<.list>

<:item title="Numero"><%= @participante.numero %></:item>

<:item title="Nombre"><%= @participante.nombre %></:item>

<:item title="Correo"><%= @participante.correo %></:item>

</.list>

  

<.back navigate={~p"/participantes"}>Back to participantes</.back>

  

<.modal :if={@live_action == :edit} id="participante-modal" show on_cancel={JS.patch(~p"/participantes/#{@participante}")}>

<.live_component

module={RifaWeb.ParticipanteLive.FormComponent}

id={@participante.id}

title={@page_title}

action={@live_action}

participante={@participante}

patch={~p"/participantes/#{@participante}"}

/>

</.modal>
```

