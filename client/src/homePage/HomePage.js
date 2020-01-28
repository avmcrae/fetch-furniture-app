import React, {useEffect} from 'react';
import {connect} from 'react-redux';
import searchPageActions from './searchPageActions';
import './SearchPage.scss';
import SearchHeader from '../searchHeader/SearchHeader';
import ProductDetailView from '../productDetailView/ProductDetailView';

const mapStateToProps = (state) => ({
  selectedProduct: state.productGrid.selectedProduct
});

const HomePage = (props) => {
  // eslint-disable-next-line
  useEffect(() => props.dispatch(searchPageActions.loadProducts()), []);
  return <>
    <SearchHeader/>
    { props.selectedProduct !== null
      ? <ProductDetailView product={props.selectedProduct} />
      : <h2 className="noResultText">No result selected</h2> }
  </>
};

export default connect(mapStateToProps)(HomePage);