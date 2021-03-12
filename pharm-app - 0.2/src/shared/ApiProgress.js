import axios from 'axios';
import React, { Component } from 'react'

export function withApiProgress(WrappedComponent, apiPath) {
    return class extends Component {
        static displayName ="ApiProgress"
        state = {
            pendingApiCall: false
        }
        componentDidMount() {
            this.requestInterceptors = axios.interceptors.request.use(request => {
                this.updateApiCallFor(request.config.url, true);
                return request;
            });
            this.responseInterceptors = axios.interceptors.response.use(respons => {
                this.updateApiCallFor(respons.config.url, false);
                return respons;
            }, error => {
                this.updateApiCallFor(error.config.url, false);
                throw error;
            });
        }
        componentWillUnmount() {
            axios.interceptors.request.eject(this.requestInterceptors);
            axios.interceptors.response.eject(this.responseInterceptors);
        }
        updateApiCallFor = (url, inProgress) => {
            if (url === apiPath) {
                this.setState({ pendingApiCall: inProgress });
            }
        }
        render() {
            const { pendingApiCall } = this.state
            return <WrappedComponent pendingApiCall={pendingApiCall} />
        }
    }
}
