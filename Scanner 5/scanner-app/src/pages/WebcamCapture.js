import React, { useEffect, useRef } from "react";
import Webcam from "react-webcam";
import './style.css';
import img from './video/back.jpg'; // Ensure this path is correct
import video from './video/payment.mp4';
const WebcamCapture = ({ onScan }) => {
  const webcamRef = useRef(null);

  useEffect(() => {
    const timer = setInterval(() => {
      capture();
    }, 500);
    return () => clearInterval(timer);
  }, []);

  const videoConstraints = {
    width: 300,
    height: 300,
    facingMode: "environment"
  };

  const capture = () => {
    const imageSrc = webcamRef.current.getScreenshot();
    onScan(imageSrc);
  };

  useEffect(() => {
    async function requestCameraAccess() {
      try {
        await navigator.mediaDevices.getUserMedia({ video: true });
      } catch (error) {
        console.error("Error requesting camera access:", error);
      }
    }
    requestCameraAccess();
  }, []);

  return (
    <div className="webcam-container">
      <video src={video} alt="Background" className="background-image" />
      <div className="webcam-body">
        <Webcam
          className="webcam"
          style={{ height: '300px', width: '300px', position:'relative', margin: '150px' }}
          audio={false}
          ref={webcamRef}
          screenshotFormat="image/png"
          videoConstraints={videoConstraints}
          onClick={capture}
        />
      </div>
    </div>
  );
};

export default WebcamCapture;
