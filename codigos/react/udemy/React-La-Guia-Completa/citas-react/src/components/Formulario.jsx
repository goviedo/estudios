import { useState, useEffect } from 'react';
import Error from './Error';

const Formulario = ({ personas, setPersonas, paciente }) => {
  const [nombre, setNombre] = useState('');
  const [propietario, setPropietario] = useState('');
  const [email, setEmail] = useState('');
  const [fecha, setFecha] = useState('');
  const [sintomas, setSintomas] = useState('');
  const [error, setError] = useState(false);

  useEffect(() => {

    if(Object.keys(paciente).length>0) {
      setNombre(paciente.nombre);
      setPropietario(paciente.propietario);
      setEmail(paciente.email);
      setFecha(paciente.fecha);
      setSintomas(paciente.sintomas);
    }
  }, [paciente]);

  function random() {

    let a = Math.random().toString(36).substr(3);
    let b = Date.now().toString();

    return a + b;

  }

  const handleSubmit = (e) => {
    e.preventDefault();
    if ([nombre, propietario, email, fecha, sintomas].includes('')) {
      setError(true);
      setTimeout(() => {
        setError(false);
      }, 2000);
      return;
    }
    setError(false);

    const o = {
      id: random(),
      nombre,
      propietario,
      email,
      fecha,
      sintomas,
    };

    setPersonas([...personas, o]);

    setNombre('');
    setPropietario('');
    setEmail('');
    setSintomas('');
    setFecha('');
    setError(false);
  };

  return (
    <div className="md:w-1/2 lg:w-2/5 mx-1">
      <h2 className="font-black text-3xl text-center">Seguimiento de Pacientes</h2>
      <p className="text-lg mt-5 text-center mb-10">
        Añade pacientes y {''}
        <span className="text-indigo-600 font-bold">Admin&iacute;stralos</span>
      </p>

      {error && <Error> todos los campos son obligatorios</Error>}
      <form className="bg-white shadow-lg rounded-lg py-10 px-5" onSubmit={handleSubmit}>
        <div>
          <label htmlFor="mascota" className="block text-gray-700 uppercase font-bold">
            Nombre Mascota
          </label>
          <input
            id="mascota"
            className="border-2 mt-2 w-full placeholder-gray-400 rounded-md"
            type="text"
            placeholder="Cómo se llama tu mascota"
            value={nombre}
            onChange={(e) => setNombre(e.target.value)}
          ></input>
        </div>
        <div className="mt-5">
          <label htmlFor="propietario" className="block text-gray-700 uppercase font-bold">
            Propietario
          </label>
          <input
            id="propietario"
            className="border-2 mt-2 w-full placeholder-gray-400 rounded-md"
            type="text"
            placeholder="Qui&eacute;n es el propietario"
            value={propietario}
            onChange={(e) => setPropietario(e.target.value)}
          ></input>
        </div>
        <div className="mt-5">
          <label htmlFor="email" className="block text-gray-700 uppercase font-bold">
            Correo electrónico
          </label>
          <input
            id="email"
            className="border-2 mt-2 w-full placeholder-gray-400 rounded-md"
            type="text"
            placeholder="Correo electr&oacute;nico (e-mail) propietario"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          ></input>
        </div>
        <div className="mt-5">
          <label htmlFor="alta" className="block text-gray-700 uppercase font-bold">
            Alta
          </label>
          <input
            id="alta"
            className="border-2 mt-2 w-full placeholder-gray-400 rounded-md"
            type="date"
            value={fecha}
            onChange={(e) => setFecha(e.target.value)}
          ></input>
          <textarea
            id="sintomas"
            className="border-2 mt-2 w-full placeholder-gray-400 rounded-md"
            placeholder="Cu&aacute;les son sus s&iacute;ntomas"
            value={sintomas}
            onChange={(e) => setSintomas(e.target.value)}
          />
        </div>
        <input
          type="submit"
          className="mt-2 bg-indigo-600 w-full p-3 uppercase font-bold text-white hover:bg-indigo-800 cursor-pointer transition-colors"
          value={paciente.id ? 'Editar Mascota' : 'Agregar Mascota'}
          onSubmit={handleSubmit}
        />
      </form>
    </div>
  );
};

export default Formulario;
