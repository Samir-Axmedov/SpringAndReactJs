import React, { Component } from 'react';
import logo from '../assets/logo192.png';
import { Link } from 'react-router-dom';
import { withTranslation } from 'react-i18next';
import { Authentication } from '../shared/AuthenticationContex';

class TopBar extends Component {
    static contextType=Authentication;

    render() {
        // const { t, isLoggedIn, username, onLogoutSuccess  } = this.props;
        const { t } = this.props;
                    const { state, onLogoutSuccess, } = this.context;

                    const { isLoggedIn, username, } = state;
                    let links = (
                        <ul className="navbar-nav ml-auto">
                            <li><Link className="nav-link" to="/login"> {t('Login')} </Link> </li>
                            <li><Link className="nav-link" to="/signup"> {t('Sign Up')} </Link></li>
                        </ul>
                    );
                    if (isLoggedIn) {
                        links = (
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-link" onClick={onLogoutSuccess} >{t('Logout')}</li>
                                <li className="">
                                    <Link className="nav-link" to={`/user/${username}`}>{username}
                                    </Link>
                                </li>
                            </ul>
                        );
                    }


                    return (
                        <div className="shadow-sm bg-light mb-1">
                            <nav className="navbar navbar-light container navbar-expand">

                                <Link className="navbar-brand" to="/">
                                    <img src={logo} width="66" alt="logo" />
                    Pharmas
                    </Link>
                                {links}
                            </nav>


                        </div>
                    )
                

                


    }
}
export default withTranslation()(TopBar);