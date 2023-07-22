import React from "react";
import styles from "../styles/Product.module.css";
import IPFSDownload from "./IpfsDownload";

export default function Product({ product }) {
  const { id, name, price, description, image_url } = product;

  return (
    <div>
      <div>
        <img
          className={styles.product_image}
          width="30px"
          src={image_url}
          alt={name}
        />
      </div>
      <div className={styles.product_details}>
        <div className={styles.product_text}>
          <div className={styles.product_title}>{name}</div>
          <div className={styles.product_description}>{description}</div>
        </div>

        <div className={styles.product_action}>
          <div className={styles.product_price}>{price} USDC</div>

          <IPFSDownload
            filename="143553809-rut-sin-deuda.jpeg"
            hash="QmRs2t6fwqTFi2B8NsLJgw132WR9q2BnGzDRpKLfaADYjY"
          ></IPFSDownload>
        </div>
      </div>
    </div>
  );
}
