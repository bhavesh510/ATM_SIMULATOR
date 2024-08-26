import { useLocation, useNavigate } from 'react-router-dom';
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';


const QRCodeResult = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [password, setPassword] = useState("");
  const { qrCode } = location.state || {};  // Get the QR code data from the state
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState('');
  const [tranId, amount, customerId, atmId] = qrCode.split(',');

  // Convert the string data into an object
  const prepareData = (qrCode) => {
    try {
      // const [tranId, amount, customerId, atmId] = qrCode.split(',');
      return {
        tranId: tranId.toString(), // Ensure tranId is a string
        amount: parseFloat(amount),
        customerId: parseInt(customerId, 10),
        atmId: parseInt(atmId, 10),
      };
    } catch (err) {
      console.error('Error preparing data:', err);
      setError('Failed to prepare data for backend.');
      return null;
    }
  };

  // Function to send the data to the backend
  const sendDataToBackend = async () => {
    if (!qrCode) {
      setError('No QR code data to send.');
      return;
    }

    const preparedData = prepareData(qrCode);
    if (!preparedData) {
      return;
    }

    setIsLoading(true);
    setError('');

    try {
      const response = await axios.post('http://localhost:8251/api/submit-transaction-cardless', preparedData, {
        headers: {
          'Content-Type': 'application/json',
        },

      });
      console.log('Response from backend:', response.data);
      if (response.data === "") {
        alert("Invalid crediantials");
      }
      else {
        navigate('/PinEntryPage', { state: { qrCode } });
      }
      // Handle success (e.g., show a success message or redirect)
    } catch (error) {
      console.error('Error sending data to backend:', error);
      if (error.response) {
        console.error('Response data:', error.response.data);  // Log the actual error message
        console.error('Response status:', error.response.status);
        console.error('Response headers:', error.response.headers);
        setError(`Backend returned an error: ${error.response.data}`);
      } else if (error.request) {
        console.error('Request made but no response received:', error.request);
        setError('No response received from backend.');
      } else {
        console.error('Error setting up the request:', error.message);
        setError(`Request setup error: ${error.message}`);
      }

    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="body3">
      <div className='container'>
        <h1>Confirm Amount  Rs {amount}</h1>
        {qrCode ? (
          <>
            {/* <p>QR Code: {JSON.stringify(qrCode)}</p> */}
            <button className='btn btn-primary fs-2' onClick={sendDataToBackend} disabled={isLoading}>
              {isLoading ? 'Sending...' : 'Confirm & proceed to pay'}
            </button>
            {error && <p className="error">{error}</p>}
          </>
        ) : (
          <p>No QR code scanned.</p>
        )}
      </div>
    </div>
  );
};
export default QRCodeResult;