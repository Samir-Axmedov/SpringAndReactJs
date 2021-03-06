import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import './component/i18n';
import App from './container/App';
import AuthenticationContex from './shared/AuthenticationContex';


//import './bootstrap-override.scss';

ReactDOM.render(
  <AuthenticationContex>
    <App />
  </AuthenticationContex>
  ,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
