import React, {useEffect, useState} from 'react';
import ProductGrid from '../homePage/productGrid/ProductGrid';
import searchPageActions from '../homePage/searchPageActions';
import {useDispatch} from 'react-redux';
import './SearchHeader.scss';

const SearchHeader = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const dispatch = useDispatch();
  // eslint-disable-next-line
  useEffect(() => { dispatch(searchPageActions.clearSelectedProduct()) }, [searchTerm]);
  return <>
    <header className="appHeader">Common's Amazing Product Querying System</header>
    <div className="searchBoxContainer">
      <input type="text" className="productSearchField" placeholder="search"
             onChange={(e) => setSearchTerm(e.target.value)}/>
      {searchTerm !== '' && <ProductGrid filterBy={searchTerm}/>}
    </div>
    <hr width="95%"/>
  </>;
};

export default SearchHeader;