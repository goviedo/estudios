import React from "react";
import useIPFS from "../hooks/useIPFS";

const IPFSDownload = ({ hash, filename }) => {
  const file = useIPFS(hash, filename);

  return (
    <div>
      {file ? (
        <div className="download-component">
          <a className="download-button" href={file} download={filename}>
            Download
          </a>
        </div>
      ) : (
        <p>
          Please wait, it will take a little while, do something else, a cup of
          coffee maybe, the file is downloading...
        </p>
      )}
    </div>
  );
};

export default IPFSDownload;
