import SearchArea from './SearchArea';
import Titulo from './Titulo';
import Video from './Video';

export function App() {
   return (
    <div className="container mx-auto mt-1">
      <div className="mb-5 text-center">
        <Titulo titulo="Videos de Youtube" />
      </div>
      <div className="mb-10">
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
}
