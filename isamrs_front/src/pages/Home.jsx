import React, { useState, useEffect } from 'react';
import './Home.css';
import Map from '../components/Map';
import RouteForm from '../components/RouteForm';
import Modal from 'react-modal';
import TaxiFinder from '../components/TaxiFinder';
import getAllDrivers from '../services/getAllDrivers';
Modal.setAppElement('#root');

const Home = () => {
  const [startLocation, setStartLocation] = useState(null);
  const [endLocation, setEndLocation] = useState(null);

  const [distance, setDistance] = useState(1);
  const [duration, setDuration] = useState(1);

  const [taxiLocations, setTaxiLocations] = useState([]);
  const [closestTaxi, setClosestTaxi] = useState(null);

  const [rideBegins, setRideBegins] = useState([]);



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

  const handlePay = async () => {
    setModalIsOpen(false);
    
    setPaymentMade(true); //OVO TREBA DA SE POSTAVI NA TRUE KADA TAKSISTA PRIHVATI
    setRideBegins(true);

    /*  try {
       const drivers = await getAllDrivers();
       console.log(drivers); 
     } catch (error) {
       console.error(error);
     }
  */
  };

  const handleRouteSubmit = (startCoordinates, endCoordinates) => {
    setStartLocation(startCoordinates);
    setEndLocation(endCoordinates);
  };

  const [taxiDrivers, setTaxiDrivers] = useState([
    { id: 1, name: "Nikola Vujacic", location: [45.2640, 19.8447], state: 'available', vehcicleType: 'caravan' },
    { id: 2, name: "Slobodan Zelic", location: [45.2567, 19.8110], state: 'available', vehcicleType: 'car' },
    { id: 3, name: "Marko Markovic", location: [45.2394, 19.8234], state: 'available', vehcicleType: 'car' },
    { id: 4, name: "Janko Jankovic", location: [45.2229, 19.8071], state: 'available', vehcicleType: 'bus' },
    { id: 5, name: "Petar Petrovic", location: [45.2415, 19.8327], state: 'available', vehcicleType: 'caravan' },
  ]);


  const [durationTaxi, setDurationTaxi] = useState(null);

  let ride = {};
  const handleTaxiUpdate = (taxi) => {
    setClosestTaxi(taxi);
    if (taxi!=null){
     ride = { driverName: taxi.name, id:taxi.id,
      price: '420'
    }
  }
    const rideStringified = JSON.stringify(ride);
    localStorage.setItem('closest', taxi);
    localStorage.setItem('ride',rideStringified);
    if (taxi !== null) {
      console.log(taxi.location);
      console.log(taxi.id);
      console.log(taxi);
    }


  };

  const handleDurationUpdate = (newDuration) => {
    setDurationTaxi(newDuration);


  };

  const startLocation1 = [45.2568, 19.8185];


  return (
    <div className="cinema-homepage">

      {<div>
        <h1>Taxi Finder</h1>
        <TaxiFinder
          taxiLocations={taxiDrivers}
          startLocation={startLocation}
          onTaxiUpdate={handleTaxiUpdate}
          onDurationUpdate={handleDurationUpdate}
        />

      </div>}



      <RouteForm onRouteSubmit={handleRouteSubmit} openBill={handleOpenModal} />

      {startLocation !== null && endLocation !== null && closestTaxi !== null && (
        <Map startLocation={startLocation}
          endLocation={endLocation}
          onRouteInfoUpdate={handleRouteInfoUpdate}
          closestTaxiLocation={closestTaxi.location}
          taxiDrivers={taxiDrivers}
          paymentMade={paymentMade}
          rideBegins={rideBegins} />
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
              Reserve
            </button>
          </div>
        </div>
      </Modal>


    </div>
  );
};

export default Home;