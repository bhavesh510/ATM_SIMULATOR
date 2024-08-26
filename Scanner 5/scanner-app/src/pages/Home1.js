import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
import './style.css';
import video from './video/payment.mp4';



function Home1() {
    return (
        <div className='body'>
            <div className='container'>
            <video loop muted autoPlay src={video}> video</video>
            <div className='container2'>
        <h1 className='text'>Welcome to Payment Simulator</h1>
        <div className='btn'>
       <Link to='QRScanner'><button className='btn btn-primary btn-lg fs-2 '>Scan QR</button></Link> 
       </div>
       </div>
       </div>
    </div>
    )
}

export default Home1
