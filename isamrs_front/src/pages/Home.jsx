import React, { useState, useEffect } from 'react';
import './Home.css';
import Map from '../components/Map';
import RouteForm from '../components/RouteForm';
import Modal from 'react-modal';
import TaxiFinder from '../components/TaxiFinder';
Modal.setAppElement('#root');

const Home = () => {
  const [startLocation, setStartLocation] = useState(null);
  const [endLocation, setEndLocation] = useState(null);

  const [distance, setDistance] = useState(1);
  const [duration, setDuration] = useState(1);

  const [taxiLocations, setTaxiLocations] = useState([]);
  const [closestTaxi, setClosestTaxi] = useState(null);


  const [paymentMade, setPaymentMade] = useState(false);

  useEffect(() => {
    const newTaxiLocations = [{ id: 1, location: [51.123, -0.456] },
    { id: 2, location: [45.2421, 19.7139] },
    { id: 3, location: [51.456, -0.789] },
    ];

    setTaxiLocations(newTaxiLocations);
  }, []);

  const handleRouteInfoUpdate = (newDistance, newDuration) => {
    setDistance(newDistance);
    setDuration(newDuration);
    console.log(newDistance);
    console.log(newDuration);
  };


  const [modalIsOpen, setModalIsOpen] = useState(false);

  const handleOpenModal = () => {
    setModalIsOpen(true);
  };

  const handleCloseModal = () => {
    setModalIsOpen(false);
  };

  const handleCancel = () => {
    setModalIsOpen(false);
  };

  const handlePay = () => {
    setModalIsOpen(false);
    setPaymentMade(true);

  };

  const handleRouteSubmit = (startCoordinates, endCoordinates) => {
    setStartLocation(startCoordinates);
    setEndLocation(endCoordinates);
  };


  const [durationTaxi, setDurationTaxi] = useState(null);

  const handleTaxiUpdate = (taxi) => {
    setClosestTaxi(taxi);
    if (taxi !== null) {console.log(taxi.location);
    console.log(taxi.id);}
   
   
  };

  const handleDurationUpdate = (newDuration) => {
    setDurationTaxi(newDuration);
    

  };

  const startLocation1 = [45.2421, 19.7129];


  return (
    <div className="cinema-homepage">

      {<div>
        <h1>Taxi Finder</h1>
        <TaxiFinder
          taxiLocations={taxiLocations}
          startLocation={startLocation1}
          onTaxiUpdate={handleTaxiUpdate}
          onDurationUpdate={handleDurationUpdate}
        />

      </div>}



      <RouteForm onRouteSubmit={handleRouteSubmit} openBill={handleOpenModal} />

      {startLocation !== null && endLocation !== null && closestTaxi !==null && (
        <Map startLocation={startLocation} 
        endLocation={endLocation} 
        onRouteInfoUpdate={handleRouteInfoUpdate} 
        closestTaxiLocation= {closestTaxi.location}
        paymentMade={paymentMade} />
      )}

      <Modal
        isOpen={modalIsOpen}
        onRequestClose={handleCloseModal}
        contentLabel="Bill Confirmation Modal"
        overlayClassName="modal-overlay"
        className="modal-content"
      >
        <div className="modal-container">
          <h2 className="modal-title">DRIVE</h2>
          <p className="modal-amount">The cost of your drive is  {(distance * 120).toFixed(0)} dinars</p>
          <p className="modal-message">Estimated time of travel:  {duration.toFixed(0)} minutes</p>
          <p className="modal-message">Estimated distance:  {distance.toFixed(2)} km</p>

          <div className="modal-buttons">
            <button className="modal-cancel-button" onClick={handleCancel}>
              Cancel
            </button>
            <button className="modal-pay-button" onClick={handlePay}>
              Pay
            </button>
          </div>
        </div>
      </Modal>


    </div>
  );
};

export default Home;