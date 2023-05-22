import React, { useState } from 'react';
import './Home.css';
import Map from '../components/Map';
import RouteForm from '../components/RouteForm';

const Home = () => {
  const [startLocation, setStartLocation] = useState([]);
  const [endLocation, setEndLocation] = useState([]);

  const handleRouteSubmit = (start, end) => {
    setStartLocation(start);
    setEndLocation(end);
  };

  return (
    <div className="cinema-homepage">
      <RouteForm onRouteSubmit={handleRouteSubmit} />
      <Map startLocation={startLocation} endLocation={endLocation} />
      <p>
        <strong>Current price of the selected drive is: {localStorage.getItem('distanca')}</strong>
      </p>
    </div>
  );
};

export default Home;