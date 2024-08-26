
import React from 'react';
import { useNavigate } from 'react-router-dom';
import WebcamCapture from './WebcamCapture';
import jsQR from 'jsqr';

const QRScanner = () => {
  const navigate = useNavigate();

  const handleScan = (imageSrc) => {
    if (imageSrc) {
      const image = new Image();
      image.src = imageSrc;
      image.onload = () => {
        const canvas = document.createElement('canvas');
        canvas.width = image.width;
        canvas.height = image.height;
        const ctx = canvas.getContext('2d');
        ctx.drawImage(image, 0, 0, canvas.width, canvas.height);
        const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        const code = jsQR(imageData.data, imageData.width, imageData.height, { inversionAttempts: 'dontInvert' });
        if (code) {
          navigate('/QRCodeResult', { state: { qrCode: code.data } });
        }
      };
    }
  };

  return (
    <div>
      <WebcamCapture onScan={handleScan} />
    </div>
  );
};

export default QRScanner;
