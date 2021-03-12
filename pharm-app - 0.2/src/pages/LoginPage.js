import React, { Component } from 'react'
import InputUser from '../component/InputUser';
import { withTranslation } from 'react-i18next';
import {login} from '../api/apiCalls';
import axios from 'axios';
import ButtonWithProgress from '../component/ButtonWithProgress';
import { withApiProgress } from '../shared/ApiProgress';
import { Authentication } from '../shared/AuthenticationContex';
class LoginPage extends Component {
    static contextType = Authentication;
    state = {
        username: null,
        password: null,
        error: null,
        pendingApiCall: false
    }
    componentDidMount() {
        axios.interceptors.request.use((request) => {
            this.setState({ pendingApiCall: true })
            return request;
        });
        axios.interceptors.response.use((response) => {
            this.setState({ pendingApiCall: false })
            return response;
        }, error => {
            this.setState({ pendingApiCall: false });
            throw error;
        });
    }
    onChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value, error: null })
    }
    onClickLogin = async event => {
        event.preventDefault();
        const { username, password } = this.state;
        const { onLoginSuccess } = this.context;
        const creds = {
            username,
            password
        };
       
        this.setState({
            error: null
        });

        try {
           const response= await login(creds);
            console.log(response.data)
            const { push } = this.props.history;
            push('/');

            const authState = {
                ...response.data,
               // username: username,
                password: password
              //  displayName: response.data.displayName,
             //   image: response.data.image,
            }
            onLoginSuccess(authState);
        } catch (apiError) {
                this.setState({
                error: apiError.response.data.message
            });
        }
    }

    render() {
        const { t, pendingApiCall } = this.props;
        const { error, username, password } = this.state;
        const buttonEnabled = username && password;
        return (
            <div className="container">
                <form>
                    <h1 className="text-center">{t('Login')}</h1>
                    <InputUser label={t('Username')} name="username" onChange={this.onChange} />
                    <InputUser label={t('Password')} name="password" type="password" onChange={this.onChange} />
                    {error && <div className="alert alert-danger" role="alert">
                        {error}
                    </div>}
                  
                    <div className="text-center">
                        <ButtonWithProgress
                            onClick={this.onClickLogin}
                            disabled={!buttonEnabled || pendingApiCall}
                            pendingApiByUser={pendingApiCall}
                            text={t('Login')} />
                    </div>
                </form>
            </div>
        )
    }
}
const LoginPagewithTranslation = withTranslation()(LoginPage);

export default withApiProgress(LoginPagewithTranslation, '/api/1.0/auth')
