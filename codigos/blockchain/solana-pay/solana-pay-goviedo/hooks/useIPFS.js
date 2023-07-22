const useIPFS = (hash, filename) => {
  return `https://gateway.ipfscdn.io/ipfs/${hash}?filename=${filename}`;
  //return `https://cloudflare-ipfs.com/ipfs/${hash}`;
};

export default useIPFS;
