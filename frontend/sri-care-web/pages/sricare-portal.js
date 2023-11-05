// pages/sricare-portal.js
import React from 'react';
import styles from './sricare-portal.module.css';

const SriCarePortal = () => {
  return (
    <div className={styles['sri-care-portal']}>
      <h1>Welcome to Sri Care - New Customer Experience</h1>
      <p>Your Trusted Telecommunication Provider</p>
      <a href="/activate-services" className={styles['custom-button']}>
        Activate Services
      </a>
      <a href="/view-bills" className={styles['custom-button']}>
        View Bills
      </a>
      {/* Add links to other pages with corresponding styles */}
    </div>
  );
};
