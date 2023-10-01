https://www.youtube.com/watch?v=Bq8HDW3OJoI

```
npm create qwick@latest
pnpm create quick@latest
```

## Lazy Loading. component$

![[Pasted image 20231001024728.png]]

Cargara los eventos solamente cuando sea necesario

![[Pasted image 20231001024808.png]]

Esto unido con la serializacion, hara que la aplicacion cargue lo mas rapido posible.

## Layout.tsx

Es para el layout y la etiqueta de Slot para que se inyecte el componente

![[Pasted image 20231001025019.png]]

## Rutas, carpeta con su index.tsx

Cuando se crea una carpeta, esto es parecido a [[3.index.astro]] , esta define la ruta ya, no hay que definir rutas aparte, cuando dentro de la carpeta creo mi index.tsx este ya sabe que tiene que cargarlo.

## Singals. Para los estados globales.

![[Pasted image 20231001025246.png]]

## Signo de $. Lazy Loading

El signo de $ en las palabras reservadas nos indica lazy loading., en el caso de la imagen de mas arriba, el codigo se ejecutara cuando explicitamente se le de click al boton

## Route loaders

Es una combinacion de server side rendering con client side, es una combinacion que ejecuta al servidor y se la envia al cliente.

![[Pasted image 20231001025759.png]]

![[Pasted image 20231001025918.png]]

## Route Action, para los post o envio de datos de formulario.

