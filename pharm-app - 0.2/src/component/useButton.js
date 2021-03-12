import React from 'react';

const useButton = props=> {
    const { onClick, disabled, pendingApi, text } = props;

    return (
        <button className="btn btn-primary" onClick={onClick} disabled={disabled}>
            {pendingApi && <span className="spinner-border spinner-border-sm"></span>}{text}
        </button>
    );

};

export default useButton;