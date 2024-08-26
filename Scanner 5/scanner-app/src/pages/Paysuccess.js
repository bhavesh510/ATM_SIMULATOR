import React from 'react';
import { useLocation } from 'react-router-dom';
import './paysuccess.css'; // Import the internal CSS
import gif from './video/ani.gif'
import { Link } from 'react-router-dom';

const PaymentSuccess = () => {
  const location = useLocation();
  const { qrCode } = location.state || {};
  const[tranId,amount,customerId,atmId] = qrCode.split(',');  
//   const { amount } = location.state || {}; // Retrieve amount from the previous page
  // const[tranId,amount,customerId,atmId] = qrCode.split(',');
  return (
    <div className="payment-success-container">
      <div className="payment-success-content">
        <h1>Withdraw Successful!</h1>
        <h4><p>Amount Rs {amount}</p></h4>
        <div className="gifs-container">
          <img src={gif} alt="Success GIF 1" className="success-gif" />       
        </div>
        <Link to='/Home'><button className='btn btn-primary'>Done</button></Link>
      </div>
    </div>
  );
};

export default PaymentSuccess;
