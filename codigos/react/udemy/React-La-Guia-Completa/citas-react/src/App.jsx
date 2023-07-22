import { useState } from 'react';
import Header from './components/Header';
import ListadoPacientes from './components/ListadoPacientes';
import Formulario from './components/Formulario';

function App() {
  const [personas, setPersonas] = useState([]);
  const [paciente, setPaciente] = useState({});

  return (
    <div className="container mx-auto mt-20">
      <Header />
      <div className="mt-12 md:flex">
        <Formulario personas={personas} setPersonas={setPersonas} paciente={paciente} />
        <ListadoPacientes personas={personas} setPaciente={setPaciente} />
      </div>
    </div>
  );
}

export default App;
