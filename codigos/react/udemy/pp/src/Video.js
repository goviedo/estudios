import React from 'react';

const Video = (props) => {
  // return React.createElement('div', {}, [
  //   React.createElement('h3', {}, props.title),
  //   React.createElement('b', {}, props.dateAdded),
  //   React.createElement('br', {}),
  //   React.createElement('b', {}, props.channel),
  // ]);
  return (
    <div>
      <h3>{props.title}</h3>
      <b>{props.dateAdded}</b>
      <br />
      <b>{props.channel}</b>
    </div>
  );
};

export default Video;
