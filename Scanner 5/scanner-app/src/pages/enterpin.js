import React, { useState } from 'react';
import './enterpin.css'; // Import internal CSS
import axios from "axios";
import { useNavigate ,useLocation} from 'react-router-dom';

const PinEntryPage = () => {
    const location = useLocation();
    const { qrCode } = location.state || {}; 
    const navigate = useNavigate();
    const [pin, setPin] = useState('');

    const handlePinChange = async (e) => {
        e.preventDefault();
        setPin(e.target.value);
        // alert(`Customer ID: ${customerId}\nPassword: ${password}`);
    };

    const handlePayClick = async () => {
        // Handle payment logic here
        console.log('PIN Entered:', pin);
        try{
            const response = await axios.post('http://localhost:8251/Login', {
                cardNo: 101,
                pin: pin
            });
            
            if(response.data === ""){
              alert("Invalid crediantials");
            }
            else {
                navigate('/PaymentSuccess',{state:{qrCode}});
            }
          } catch(error){
            // console.error(error);
            alert("Something went wrong try again later")
          }
    };

    return (
        <div className="pin-entry-page">
            <div className="enterpincontainer">
                <h2>Enter Your PIN</h2>
                <input
                    type="password"
                    value={pin}
                    onChange={handlePinChange}
                    placeholder="••••••••"
                    className="pin-input"
                />
                <button className="pay-button" onClick={handlePayClick}>
                    Pay
                </button>
            </div>
        </div>
    );
};

export default PinEntryPage;
