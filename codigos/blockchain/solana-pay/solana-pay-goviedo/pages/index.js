import React, { useState, useEffect } from "react";
import HeadComponent from "../components/Head";
import { PublicKey } from "@solana/web3.js";
import { useWallet } from "@solana/wallet-adapter-react";
import { WalletMultiButton } from "@solana/wallet-adapter-react-ui";
import Product from "../components/Product";
import styles from "../styles/Product.module.css";

// Constants
const TWITTER_HANDLE = "_buildspace";
const TWITTER_LINK = `https://twitter.com/${TWITTER_HANDLE}`;

const App = () => {
  // This will fetch the users' public key (wallet address) from any wallet we support
  const { publicKey } = useWallet();
  const [products, setProducts] = useState([]);

  // si detecto la clave publica, hago:
  useEffect(() => {
    if (publicKey) {
      fetch("/api/fetchProducts")
        .then((response) => {
          return response.json();
        })
        .then((data) => {
          setProducts(data);
          console.dir(data);
        })
        .catch((err) => {
          console.dir("Error");
          console.dir(err);
        });
    }
  }, [publicKey]);

  const renderNotConnectedContainer = () => (
    <div>
      <img
        src="https://www.upphone.com/wp-content/uploads/2020/09/iphone-12-not-connecting-to-cellular-fix-1-1096x520.jpg"
        alt="emoji"
      />

      <div className={styles.button_container}>
        <WalletMultiButton className="cta-button connect-wallet-button" />
      </div>
    </div>
  );

  const renderItemBuyContainer = () => (
    <div className={styles.product_container}>
      {products.map((product) => (
        <Product key={product.id} product={product} />
      ))}
    </div>
  );

  return (
    <div className="App">
      <HeadComponent />
      <div className="container">
        <header className="header-container">
          <p className="header"> Vende tu c&oacute;digo Java aqu&iacute; </p>
          <p className="sub-text">
            El &uacute;nico almacen que te paga por tu c&oacute;digo
          </p>
        </header>

        <main>
          {/* We only render the connect button if public key doesn't exist */}
          {publicKey ? renderItemBuyContainer() : renderNotConnectedContainer()}
          {publicKey && (
            <img
              src="https://d2slcw3kip6qmk.cloudfront.net/marketing/techblog/java-monadic-programming/java-monadic-blog-post-image@2x.png"
              alt="java"
            />
          )}
        </main>

        <div className="footer-container">
          <img
            alt="Twitter Logo"
            className="twitter-logo"
            src="twitter-logo.svg"
          />
          <a
            className="footer-text"
            href={TWITTER_LINK}
            target="_blank"
            rel="noreferrer"
          >{`built on @${TWITTER_HANDLE}`}</a>
        </div>
      </div>
    </div>
  );
};

export default App;
