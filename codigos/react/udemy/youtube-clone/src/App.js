import React from 'react';
import ReactDOM from 'react-dom';
import Video from './Video';
import SearchArea from './SearchArea';
import Titulo from './Titulo';
import './css/style.css';

const App = () => {
  return (
    <div className="container mx-auto mt-1">
      <div className="mb-5 mix-blend-color-burn">
        <Titulo titulo="Videos de Youtube" />
      </div>
      <div>
        <SearchArea />
      </div>
      <Video
        title="Tremendo Video Maestro"
        dateAdded="23/09/2022"
        channel="The Best Channel in all Youtube"
      />
      <Video
        title="Tremendo Video Maestro"
        dateAdded="20/01/2022"
        channel="The Best Channel in all Youtube"
      />
    </div>
  );
};

ReactDOM.render(React.createElement(App), document.getElementById('root'));
