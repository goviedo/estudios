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