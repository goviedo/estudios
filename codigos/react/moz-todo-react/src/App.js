import React, { useState } from 'react';
import Todo from './components/Todo';
import Form from './components/Form';
import FilterButton from './components/FilterButton';
import { nanoid } from 'nanoid';

function App(props) {
  const [tasks, setTasks] = useState(props.tasks);

  function addTask(task) {
    const newTask = { id: 'todo-' + nanoid(), name: task, completed: false };
    setTasks([...tasks, newTask]);
  }

  function toggleTaskCompleted(id) {
    const updatedTasks = tasks?.map((task) => {
      if (task.id === id) {
        return { ...task, completed: !task.completed };
      }
      return task;
    });
    setTasks(updatedTasks);
  }

  function editTask(id, newName) {
    const editTasks = tasks?.map(task=>{
      if(id===task.id) {
        return {...tasks, name: newName}
      }
      return tasks;
    })
    setTasks(editTasks);
  }

  function deleteTask(id) {
    const remainingTasks = tasks?.filter((task) => id !== task.id);
    setTasks(remainingTasks);
  }

  const taskList = tasks?.map((task) => (
    <Todo
      id={task.id}
      name={task.name}
      completed={task.completed}
      key={task.id}
      toggleTaskCompleted={toggleTaskCompleted}
      deleteTask={deleteTask}
    />
  ));

  return (
    <div className="todoapp stack-large">
      <h1>Todo Gonzalo Oviedo</h1>
      <Form
        titleInput="Maestro, por favor, indíqueme que tarea realizará"
        titleButton="Por favor Maestro, tenga la bondad!"
        addTask={addTask}
      />
      <div className="filters btn-group stack-exception">
        <FilterButton />
        <FilterButton />
        <FilterButton />
      </div>
      <h2 id="list-heading">
        {tasks.length === 0 ? 'Maestro, sin Tareas!' : tasks.length + ' task remaining'}
      </h2>
      <ul className="todo-list stack-large stack-exception" aria-labelledby="list-heading">
        {taskList}
      </ul>
    </div>
  );
}

export default App;
