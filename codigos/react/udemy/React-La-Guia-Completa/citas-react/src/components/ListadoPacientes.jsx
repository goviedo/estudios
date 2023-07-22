import { useEffect } from 'react';
import Paciente from './Paciente';

const ListadoPacientes = ({ personas, setPaciente }) => {

  return (
    <div className="md:w-1/2 lg:w-3/5 mx-1">
      {personas && personas.length ? (
        <>
          <h2 className="font-black text-3xl text-center">Listado de Pacientes</h2>
          <p className="mt-5 text-xl mb-10 text-center">
            Administra tus {''}
            <span className="text-indigo-600 font-bold text-xl">Pacientes y Citas</span>
          </p>
          <div className="md:h-screen overflow-y-scroll">
            {personas.map((persona) => (
              <Paciente key={persona.id} persona={persona} setPaciente={setPaciente} />
            ))}
          </div>
        </>
      ) : (
        <>
          <div className="md:w-1/2 lg:w-3/5 mx-1">
            <h2 className="font-black text-3xl text-center">No hay pacientes</h2>
            <p className="mt-5 text-xl mb-10 text-center">
              Aqui aparecerán tus {''}
              <span className="text-indigo-600 font-bold text-xl">Pacientes y Citas</span>
            </p>
          </div>
        </>
      )}
    </div>
  );
};

export default ListadoPacientes;
