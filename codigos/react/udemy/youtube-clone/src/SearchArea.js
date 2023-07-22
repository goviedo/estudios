import axios from 'axios';
import React, { useState } from 'react';

const SearchArea = () => {
  const [keyword, setKeyword] = useState('');

  const r = (e) => {
    e.preventDefault();
    axios
      .get(
        'https://youtube.googleapis.com/youtube/v3/search?type=video&part=snippet&maxResult=25&key=AIzaSyASre9cfyBlm28yI6ma1q03DLxs4RmCWZE'
      )
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="md:flex md:justify-center md:items-center mx-96 p-4 py-12 border-4 bg-yellow-300">
      <form onSubmit={(e) => r(e)}>
        <label htmlFor="search" className="block text-gray-700 font-bold">
          Buscar...
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
