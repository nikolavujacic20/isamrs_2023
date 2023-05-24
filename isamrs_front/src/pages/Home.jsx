import React, { useState } from 'react';
import './Home.css';
import Map from '../components/Map';
import RouteForm from '../components/RouteForm';

const Home = () => {
  const [startLocation, setStartLocation] = useState([null]);
  const [endLocation, setEndLocation] = useState([null]);


  const [routeCoordinates, setRouteCoordinates] = useState(null);

  const handleRouteSubmit = (startCoordinates, endCoordinates) => {

    setStartLocation(startCoordinates);
    setEndLocation(endCoordinates);

    console.log(startLocation+'OVO JE START');
    console.log(endLocation+'OVO JE END');
  };


  return (
    <div className="cinema-homepage">

      <RouteForm onRouteSubmit={handleRouteSubmit} />
      {startLocation && endLocation && (
      <Map startLocation={startLocation} endLocation={endLocation} />
    )}
     
    </div>
  );
};

export default Home;