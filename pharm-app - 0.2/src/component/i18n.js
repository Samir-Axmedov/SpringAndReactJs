import i18n from 'i18next'
import { initReactI18next } from 'react-i18next'

i18n.use(initReactI18next).init({
    resources: {
        en: {
            translations: {
                'Sign Up': 'Sign Up',
                'Password mismatch': 'Password mismatch',
                'Username':'Username',
                'Display name': 'Display name',
                'Password': 'Password',
                'Password repeat': 'Password repeat',
                'Login':'Login',
                'Logout': 'Logout'
            }
        },
        az: {
            translations: {
                'Sign Up': 'Qeydiyyat',
                'Password mismatch': 'Eyni parol olmalı',
                'Username': 'Qeydiyyat adı',
                'Display name': 'Görüntü adı',
                'Password': 'Parol',
                'Password repeat': 'Təkrar parol',
                'Login': 'Daxil ol',
                'Logout': 'CHixis'
            }
        },
        ru: {
            translations: {
                'Sign Up': 'Регистр',
                'Password mismatch': 'Password рывог вдыв ы ы ',
                'Username': 'Гывроваоад',
                'Display name': 'ВЫ вы вып а евар ',
                'Password': 'Password',
                'Password repeat': 'Password ывввап',
                'Login': 'выв ыв ывыв  ',
                'Logout': 'dsds ds '

            }
        }
    },
    fallbackLng: 'en',
    ns: ['translations'],
    defaultNS: 'translations',
    keySeperator: false,
    interpolation: {
        escapeValue: false,
        formatSeperator: ','
    },
    react: {
        wait: true
    }
})

export default i18n;