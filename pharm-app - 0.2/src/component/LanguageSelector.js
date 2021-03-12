import React from 'react';
import { withTranslation } from 'react-i18next';
import { changeLanguage } from '../api/apiCalls'

const LanguageSelector = props => {
    const onChangeLanguage = language => {
        const { i18n } = props;
        i18n.changeLanguage(language);
        changeLanguage(language);
    }
    return (
        <div className="container">
            <img src="https://www.countryflags.io/az/flat/24.png" alt="az" onClick={() => onChangeLanguage('az')} style={{ cursor: 'pointer' }}></img>
            <img src="https://www.countryflags.io/GB/flat/24.png" alt="en" onClick={() => onChangeLanguage('en')} style={{ cursor: 'pointer' }}></img>
            <img src="https://www.countryflags.io/ru/flat/24.png" alt="ru" onClick={() => onChangeLanguage('ru')} style={{ cursor: 'pointer' }}></img>

        </div>
    );
};

export default withTranslation()(LanguageSelector);