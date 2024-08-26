import { useState } from "react";
import {Link, useNavigate} from 'react-router-dom';
import '../pages/Login.css'
import axios from "axios";

const Login = () => {
    const navigate = useNavigate();
    const [customerId, setCustomerId] = useState("");
    const [password, setPassword] = useState("");

  const handleSubmit = async(e) => {
    e.preventDefault();
    // alert(`Customer ID: ${customerId}\nPassword: ${password}`);
    try{
    const response = await axios.post('http://localhost:8251/Login1', {
      cardNo: customerId,
      pin: password
    });
    
    if(response.data === ""){
      alert("Invalid crediantials");
    }
    else {
      navigate('/Home',{state : {customerId : customerId}});
    }
  } catch(error){
    console.error(error);
    alert("Something went wrong try again later")
  }
    
  };

    return (
        <div className="bg">
        <div className="login-container">
        <form onSubmit={handleSubmit} className="login-form">
          <h2>Wlecome to Payment Simulator</h2>
          <div className="form-group">
            <label htmlFor="customerId">Customer ID:</label>
            <input
              type="text"
              id="customerId"
              value={customerId}
              onChange={(e) => setCustomerId(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="button-group">
            <button type="submit">Login</button>
            <Link to='/Welcome'><button type="button">
            Sign up
            </button></Link>
          </div>
        </form>
      </div>
      </div>
    )
}
export default Login
