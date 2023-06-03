import React, { useState } from 'react';
import './RouteForm.css';

const RouteForm = ({ onRouteSubmit,openBill }) => {
  const [start, setStart] = useState('');
  const [end, setEnd] = useState('');

  const handleStartChange = (e) => {
    setStart(e.target.value);
  };

  const handleEndChange = (e) => {
    setEnd(e.target.value);
  };

  const handleGeocode = async (address) => {
    try {
      const response = await fetch(
        `https://nominatim.openstreetmap.org/search?q=${encodeURIComponent(address)}&format=json`
      );
      const data = await response.json();

      if (data && data.length > 0) {
        const { lat, lon } = data[0];
        return [parseFloat(lat), parseFloat(lon)];
      } else {
        return null;
      }
    } catch (error) {
      console.error('Error geocoding address:', error);
      return null;
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const startCoordinates = await handleGeocode(start);
    const endCoordinates = await handleGeocode(end);
  
    onRouteSubmit(startCoordinates, endCoordinates);
    
  };

  return (
    <form className="route-form" onSubmit={handleSubmit}>
      <div className="form-group">
        <label htmlFor="start">Start Location</label>
        <input
          type="text"
          id="start"
          value={start}
          onChange={handleStartChange}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="end">End Location</label>
        <input
          type="text"
          id="end"
          value={end}
          onChange={handleEndChange}
          required
        />
      </div>
      <button type="submit">Find Route</button>
      <button onClick={openBill}>Calculate Route</button>
    </form>
  );
};

export default RouteForm;