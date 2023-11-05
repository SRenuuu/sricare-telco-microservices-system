import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './LandingPage.css';
  
const headerStyles = {
    backgroundColor: '#141098',
  };

const SriCarePortal = () => {
  return (
    <div className="d-flex flex-column justify-content-center align-items-center min-vh-100">
      <header className="text-white text-center py-5 w-100" style={headerStyles}>
        <h1 className="display-4">Welcome to Sri Care - New Customer Experience</h1>
        <p className="lead">Your Trusted Telecommunication Provider</p>
      </header>

      <div className="container my-5 text-center">
        <h2>Our Services</h2>
        <div className="d-flex justify-content-center">
          <button className="btn mx-2 custom-button">Activate Services</button>
          <button className="btn mx-2 custom-button">View Bills</button>
          <button className="btn mx-2 custom-button">Pay Bills</button>
          <button className="btn mx-2 custom-button">Receive Notifications</button>
          <button className="btn mx-2 custom-button">Chat with Us</button>
        </div>
      </div>

      <div className="py-5 text-center">
        <h2>Ready to Get Started?</h2>
        <p>Sign up or log in to access your Sri-Care account.</p>
        <button className="btn btn-primary custom-login-button">Log In</button>
        <button className="btn btn-secondary mx-2">Sign Up</button>
      </div>
    </div>
  );
};

export default SriCarePortal;
