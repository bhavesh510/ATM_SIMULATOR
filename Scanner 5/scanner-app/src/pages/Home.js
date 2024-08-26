import React from 'react';
import './Home.css'; // Import internal CSS
import  image from './Images/Profile.png'
import image2 from './Images/Qr Scanner.png'
import image3 from './Images/prepaid.png'
import image4 from './Images/online.png'
import image5 from './Images/rent.png'
import image6 from './Images/electricity.png'
import { Link } from 'react-router-dom';
import image7 from './Images/notification.png';

const Home = () => {

    const buttonGridStyle = {
        display: 'grid',
        gridTemplateColumns: 'repeat(2,200px)',
        gap: '50px',
    }

    return (
        <div className="payment-page">
            
            <header className="header">
                <div className="logo-left"><img src={image} height='60px' width='60px' alt='image not founds'></img></div>
                <div className="logo-center">Transfer Money</div>
                <div className="notification" ><img src={image7} height='60px' width='60px' alt='image not founds' ></img></div>
                <div className="logo-right"><Link to='/QRSCanner'><img src={image2} height='60px' width='60px' alt='image not founds'></img></Link></div>
            </header>
            <main className="main-content">
                <div className="button-container" style={buttonGridStyle}>
                    <button className="btn1">To mobile No</button>
                    <button className="btn1">To Bank</button>
                    <button className="btn1">To Self Account</button>
                    <button className="btn1">Button 4</button>
                    <button className="btn1">Button 1</button>
                    <button className="btn1">To UPI ID</button>
                    <button className="btn1">Check Balance</button>
                    <Link to='/QRSCanner'><button className="btn2">Scan QR</button></Link>
                </div>
                <div className="bottom-box">
                    <footer>
                    <div className="bottom-box-title">Bill & Recharges</div>
                    <div className="options">
                    <button className="option-btn"><img src={image6} height='40px' width='40px'></img></button>
                        <button className="option-btn"><img src={image3} height='40px' width='40px' alt='image not founds'></img></button>
                        <button className="option-btn"><img src={image4} height='40px' width='40px' alt='image not founds'></img></button>
                        <button className="option-btn"><img src={image5} height='40px' width='40px' alt='image not founds'></img></button>
                    </div>
                    <div className="options2">
                    <div id='id1'>Electricity</div>
                    <div id='id2'>Prepaid</div>
                    <div id='id3'>DTH</div>
                    <div id='id4'>Rent</div>
                    </div>
                    </footer>
                </div>
            </main>
        </div>
    );
};

export default Home;