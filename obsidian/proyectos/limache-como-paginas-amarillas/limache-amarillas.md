## Prototipo

https://www.figma.com/file/ozIt8GSKwlUMEk8EHL4eUW/Untitled?type=design&node-id=0-1&mode=design&t=LsrUOcJ17xs1dKHw-0


![[Pasted image 20231008124432.png]]
Es bastante simple, solo generar una busqueda y una especia de componente de CARD se despliega con todo esos datos.

# Disenio Informatico

## Tablas.

Tabla Negocio
--------------------------------------

Corresponde a la relacion del detalle del negocio con los tags relacionados. Los tags sirven para que cuando se busque, busque por estos tags y permita que aparezcan los resultados.

Si el Negocio que busco corresponde uno de estos id tags, entonces es factible de mostrarse

* id
* detalle_id -- not null
* tags_id_lists -- not null

Tabla Detalle
-----------------------------------

Es el detalle del negocio en si.

* id
* nombre --- not null
* direccion -- not null
* url  -- null
* descripcion -- null
* logo -- null es el path para el logo.
* celular -- null -- number

Tabla Tags
----------------------------

Son los tags, los podemos agrupar en categorias.

* id
* tag
* categoria_id

Tabla Categoria
------------------------------------------

Las categorias que envuelven a un grupo de tags.

* id
* nombre

## Tecnologia.

Voy a necesitar:

* Una CARD como componente.
* Idealmente no REST, sino algo integrado como un monolito.
* Sino REST - Java API para velocidad de desarrollo.
* Aprender [[Fundamentales-Qwick]] con Rest JAVA API.

# Configuraciones

https://vitejs.dev/config/server-options.html#server-hmr

Es un error que aparece al contactar al servidor API, con el overlay en false se evita.

```javascript
export default defineConfig(() => {
	return {
		server: {
			hmr: {
				overlay: false
			}
		},
		plugins: [qwikCity(), qwikVite(), tsconfigPaths()],
		preview: {
			headers: {
				"Cache-Control": "public, max-age=600",
			},
		},
	};
});
```

# useTask and useSignal

```javascript
const tag = useSignal("");
useTask$(
	( { track } ) => {
		track(
			() => tag.value
		);
		if(tag.value.length>3)
			console.log(tag.value);
	}
);

<input
type="text"
placeholder="Escribe tu búsqueda"
class="flex-grow px-4 py-2 rounded-l-lg focus:outline-none"
value={tag.value}
onKeyDown$={
	event => tag.value += event.key
}
<button onClick$={
		()=> tag.value="Panaderia"
	}
	class="menu-item"
>
```

## CSS para el dropdown menu con la flecha

```css
.menu-item {
	@apply block text-sm font-extralight py-1 px-1;
}
.menu-item:hover {
	@apply hover:text-amber-400
}
.dropdown-menu-item-arrow::before {
	content: "";
	position: absolute;
	top: -5px;
	right: calc(95% - 12px);
	border-width: 0 5px 5px 5px;
	border-style: dotted;
	border-color: transparent transparent yellowgreen transparent;
}
```

Todo es casi se explica solo,  es importante rescatar que el useTask$ por si solo define el track, no se define en ningun lado y hace seguimiento del valor tag.

