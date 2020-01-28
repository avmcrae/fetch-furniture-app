import React from 'react';
import searchPageActions from '../../searchPageActions';
import {connect} from 'react-redux';
import './ProductRow.scss';

const ProductRow = ({product, dispatch}) => <div className="productRow">
  <div className="clickableProduct" onClick={() => dispatch(searchPageActions.selectProduct(product))}>
    <div className="photoContainer">
      <img src={product.photoUrl} alt={`Thumbnail of ${product.name}`}/>
    </div>
    <div className="productInformation">
      <h3>{product.name}</h3>
      <h5 className="productDescription">{product.description}</h5>
    </div>
  </div>
</div>;

export default connect(undefined)(ProductRow);