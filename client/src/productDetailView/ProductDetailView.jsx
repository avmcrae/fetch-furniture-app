import React from 'react';
import './ProductDetailView.scss';

const ProductDetailView = ({product}) => {
  return <div className="content">
  <div className="productBox">
    <div className="photoContainer">
      <img src={product.photoUrl} alt={product.name}/>
    </div>
    <div className="productInformation">
      <div className="productField"><label>ID: </label><p>{product.id}</p></div>
      <div className="productField"><label>Name: </label><p>{product.name}</p></div>
      <div className="productField"><label>URL: </label><a href={product.link}><p>{product.link}</p></a></div>
      <div className="description">
        <label>Description: </label>
        <p>{product.description}</p>
      </div>
    </div>
  </div>
  </div>
};

export default ProductDetailView;