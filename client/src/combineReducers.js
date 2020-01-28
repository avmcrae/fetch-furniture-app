import { combineReducers } from 'redux';
import productGrid from './homePage/productsReducer';

const reducers = combineReducers({
  productGrid
});

export default reducers;