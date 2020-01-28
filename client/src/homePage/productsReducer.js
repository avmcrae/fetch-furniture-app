import {productRequestActions} from './searchPageActions';

const initialState = {
  products: [],
  isLoading: false,
  hasError: false,
  selectedProduct: null
};

export const filterProductsByName = (state, filterBy) =>
  state.productGrid.products.filter(product => product.name.includes(filterBy));

export default (state = initialState, action) => {
  if (action.type === productRequestActions.LOAD_PRODUCTS_REQUEST_SENT) {
    return {...initialState, isLoading: true, selectedProduct: null};
  } if (action.type === productRequestActions.LOAD_PRODUCTS_RESPONSE_RECEIVED) {
    return {...initialState, isLoading: false, products: action.payload};
  } if (action.type === productRequestActions.LOAD_PRODUCTS_RESPONSE_FAILED) {
    return {...initialState, hasError: true};
  } if (action.type === productRequestActions.SELECT_PRODUCT) {
    return {...initialState, selectedProduct: action.payload}
  } if (action.type === productRequestActions.CLEAR_SELECTED_PRODUCT) {
    return {...state, selectedProduct: null}
  }
  return state;
};