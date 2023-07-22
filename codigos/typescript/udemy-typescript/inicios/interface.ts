interface Persona {
  nombre: String
}

function hola(persona: Persona) {
  console.log(persona.nombre);
}

hola({ nombre: "Gonzalo" } );
hola({ apellido: "Oviedo" } );
