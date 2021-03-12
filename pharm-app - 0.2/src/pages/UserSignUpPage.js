import React, { Component } from 'react'
import { signUp, } from '../api/apiCalls'
import InputUser from '../component/InputUser'
import { withTranslation } from 'react-i18next'
import ButtonWithProgress from '../component/ButtonWithProgress';
import { withApiProgress } from '../shared/ApiProgress';

class UserSignUpPage extends Component {
    state = {
        username: null,
        displayName: null,
        password: null,
        passwordRepeat: null,
        errors: {}
    }
    onChange = event => {
        const { t } = this.props;
        const { name, value } = event.target;
        const errors = { ...this.state.errors };
        errors[name] = undefined;
        if (name === 'password' || name === 'passwordRepeat') {
            if (name === 'password' && value !== this.state.passwordRepeat) {
                errors.passwordRepeat = t('Password mismatch');
            } else if (name === 'passwordRepeat' && value !== this.state.password) {
                errors.passwordRepeat = t('Password mismatch')
            } else {
                errors.passwordRepeat = undefined;
            }
        }
        this.setState({
            [name]: value,
            errors
        })
    }

    onClickSignUp = async event => {
        event.preventDefault();
        const { username, displayName, password } = this.state;
        const body = {
            username,
            displayName,
            password
        };
    
        try {
            await signUp(body);
        } catch (error) {
            if (error.response.data.validationErrors) {
                console.log(error.response.data.validationErrors);
                this.setState({
                    errors: error.response.data.validationErrors
                })
            }
        };
    }

    render() {
        const { t, pendingApiCall } = this.props;
        const { errors} = this.state;
        const { username, displayName, password, passwordRepeat } = errors;
        const SignUpEnabled = pendingApiCall&& (!passwordRepeat===undefined);
        return (

            <div className="container">
                <h3 className="h3 mb-3">{t('Sign Up')}</h3>
                <form>
                    <InputUser label={t('Username')} name="username" error={username} onChange={this.onChange} />
                    <InputUser label={t('Display name')} name="displayName" error={displayName} onChange={this.onChange} />
                    <InputUser label={t('Password')} name="password" error={password || passwordRepeat} onChange={this.onChange} type="password" />
                    <InputUser label={t('Password repeat')} name="passwordRepeat" error={passwordRepeat} onChange={this.onChange} type="password" />
                    <div className="text-center">
                        <ButtonWithProgress
                            onClick={this.onClickSignUp}
                            disabled={SignUpEnabled}
                            pendingApiByUser={pendingApiCall}
                            text={t('Sign Up')} />
                    </div>
                </form>
            </div>
        )
    }
}

const UserSignUpPagewithTranslation = withTranslation()(UserSignUpPage, '/api/1.0/users');
const UserSignUpPageWithApiProgress = withApiProgress(UserSignUpPagewithTranslation)
export default UserSignUpPageWithApiProgress;
