import UserSignUpPage from '../pages/UserSignUpPage';
import LoginPage from '../pages/LoginPage';
import LanguageSelector from '../component/LanguageSelector';
import HomePage from '../pages/HomePage';
import UserPage from '../pages/UserPage';
import { Route, Redirect, Switch, HashRouter as Router } from 'react-router-dom';
import TopBar from './TopBar';
import React from 'react';

class App extends React.Component {



  render() {
    const isLoggedIn=false
    const username =undefined
    //const { isLoggedIn,username } = this.state


    return (
      <div className="container-sm">
        <LanguageSelector />
        <Router>
          <TopBar/>
          <Switch>
            <Route exact path="/" component={HomePage} />

            {!isLoggedIn && <Route path="/login" component={LoginPage} />}

            <Route path="/signup" component={UserSignUpPage} />
            <Route path="/user/:username" component={props => {
              return <UserPage {...props} username={username} />
               }} />
            <Redirect to="/" />
          </Switch>
        </Router>

      </div>
    );
  }
}

export default App;
