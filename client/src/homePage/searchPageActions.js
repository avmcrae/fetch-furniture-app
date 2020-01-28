import axios from 'axios';

export const productRequestActions = {
  LOAD_PRODUCTS_REQUEST_SENT: 'LOAD_PRODUCTS_REQUEST_SENT',
  LOAD_PRODUCTS_RESPONSE_RECEIVED: 'LOAD_PRODUCTS_RESPONSE_RECEIVED',
  LOAD_PRODUCTS_RESPONSE_FAILED: 'LOAD_PRODUCTS_RESPONSE_FAILED',
  SELECT_PRODUCT: 'SELECT_PRODUCT',
  CLEAR_SELECTED_PRODUCT: 'CLEAR_SELECTED_PRODUCT'
};

const loadProducts = () => (dispatch) => {
  dispatch({type: productRequestActions.LOAD_PRODUCTS_REQUEST_SENT});
  axios.get("/api/search")
    .then((response) => {
      dispatch({type: productRequestActions.LOAD_PRODUCTS_RESPONSE_RECEIVED, payload: response.data})
    }).catch((error) => {
    dispatch({type: productRequestActions.LOAD_PRODUCTS_RESPONSE_FAILED})
  });
};

export default {
  loadProducts,
  selectProduct: (payload) => ({type: productRequestActions.SELECT_PRODUCT, payload}),
  clearSelectedProduct: () => ({type: productRequestActions.CLEAR_SELECTED_PRODUCT})
};