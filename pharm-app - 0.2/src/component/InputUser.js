import React from 'react';

const InputUser = props => {
    const { label, error, name, onChange, type } = props;
    const className = error ? "form-control is-invalid" : "form-control";
    return (
        <div className="form-group mb-3">
            <label className="form-label">{label}:</label>
            <input name={name} className={className} onChange={onChange} type={type} />
            <div className="invalid-feedback">
                {error}
            </div>
        </div>
    );
}

export default InputUser;


