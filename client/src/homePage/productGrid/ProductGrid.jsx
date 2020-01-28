import React from 'react';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import ProductRow from './productRow/ProductRow';
import {filterProductsByName} from '../productsReducer';
import './ProductGrid.css';

const mapStateToProps = (state, ownProps) => ({
  products: filterProductsByName(state, ownProps.filterBy)
});

const ProductGrid = (props) => <div className="productGrid">
  {props.products.map(product =>
    <ProductRow product={product} key={product.id}/>
  )}
  </div>;

ProductGrid.propTypes = {
  products: PropTypes.array,
  filterBy: PropTypes.string
};

export default connect(mapStateToProps, {})(ProductGrid);