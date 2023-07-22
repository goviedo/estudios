const Paciente = ({ persona, setPaciente }) => {
  const { nombre, propietario, email, fecha, sintomas } = persona;

  return (
    <div className="mb-3 bg-white shadow-md px-5 mx-3 py-10 rounded-xl">
      <p className="font-bold mb-3 text-gray-700 uppercase">
        Nombre Mascota:
        <span className="font-normal normal-case ml-3">{nombre}</span>
      </p>

      <p className="font-bold mb-3 text-gray-700 uppercase">
        Propietario:
        <span className="font-normal normal-case ml-3">{propietario}</span>
      </p>

      <p className="font-bold mb-3 text-gray-700 uppercase">
        e-mail:
        <span className="font-normal normal-case ml-3">{email}</span>
      </p>

      <p className="font-bold mb-3 text-gray-700 uppercase">
        Fecha Alta:
        <span className="font-normal normal-case ml-3">{fecha}</span>
      </p>

      <p className="font-bold mb-3 text-gray-700 uppercase">
        S&iacute;ntomas:
        <span className="font-normal normal-case ml-3">{sintomas}</span>
      </p>

      <p className="flex justify-between">
        <button
          className="py-5 px-10 bg-green-600 hover:bg-green-800 font-bold text-white rounded-xl"
          type="button"
          onClick={() => {
            setPaciente(persona);
          }}
        >
          Editar
        </button>
        <button
          className="py-5 px-10 bg-red-600 hover:bg-red-800 font-bold text-white rounded-xl"
          type="button"
        >
          Eliminar
        </button>
      </p>
    </div>
  );
};

export default Paciente;
