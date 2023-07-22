import React, { useState } from 'react';

const SearchArea = () => {
  const [keyword, setKeyword] = useState('hola');

  return (
    <div>
      <form>
        <label htmlFor="search" className="block text-gray-700 font-bold">
          Maestro, por favor, sírvase a buscar algo
        </label>
        <input
          type="text"
          id="search"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
          className="rounded-md p-2 border-2 mr-2"
        />
        <button className="mt-2 p-2 cursor-pointer box font-bold uppercase bg-indigo-600 text-white rounded-md">
          Submit
        </button>
      </form>
    </div>
  );
};

export default SearchArea;
