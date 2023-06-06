import L from "leaflet";
import "leaflet/dist/leaflet.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine";
import React, { useState, useRef } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import TaxiComponent from "./TaxiComponent";
import Modal from 'react-modal';
import './Modal.css';
import TaxiSim from "./TaxiSim";
import MapComponent from "./MapComponent";

const Map = ({ startLocation, endLocation, onRouteInfoUpdate, closestTaxiLocation, paymentMade, taxiDrivers, rideBegins }) => {

  const [taxiLocations, setTaxiLocations] = useState([]);

  const [rideApproved, setRideApproved] = useState(false);

  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [modalIsOpen1, setModalIsOpen1] = useState(false);

  const handleTaxiArrival = () => {



    setModalIsOpen(true);
  };


  const handleTaxiOver = () => {



    setModalIsOpen1(true);
  };



  const handleBegin = () => {
    setModalIsOpen(false);
    setRideApproved(true);
  };


  const handleEnd = () => {
    setModalIsOpen1(false)
    setRideApproved(true);
    const rideStringified = localStorage.getItem('ride');
    const ride = JSON.parse(rideStringified);
    console.log(ride);
  };


  const containerStyle = {
    width: "60%",
    height: "750px",
    margin: "0 auto",
  };

  const taxiIcon = new L.Icon({
    iconUrl: require("../images/taxi.png"),
    iconSize: [25, 25],
    iconAnchor: [12, 25],
    popupAnchor: [0, -25],
  });

  const markerIcon = new L.Icon({
    iconUrl: require("../images/marker.png"),
    iconSize: [25, 25],
    iconAnchor: [12, 25],
    popupAnchor: [0, -25],
  });




  const center = [45.2396, 19.8207];
  const simLocation = [45.2547, 19.862];
  const zoom = 13;


  const routingControlRef = useRef(null);

  const handleLocationUpdate = (location) => {

    setTaxiLocations((prevLocations) => [...prevLocations, location]);
    console.log(taxiLocations);
  };


  return (
    <div>
      <MapContainer center={center} zoom={zoom} style={containerStyle}>
        <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />




        {startLocation !== null && endLocation !== null && (
          <MapComponent
            startLocation={startLocation}
            endLocation={endLocation}
            markerIcon={markerIcon}
            onRouteInfoUpdate={onRouteInfoUpdate}
            routingControlRef={routingControlRef}
            simulationDuration={1000}

          />
        )}

        {paymentMade && (
          <TaxiComponent
            startLocation={closestTaxiLocation}
            endLocation={startLocation}
            markerIcon={taxiIcon}
            simulationDuration={100}
            onTaxiArrival={handleTaxiArrival}
          />
        )}



        {rideApproved && (
          <TaxiComponent
            startLocation={startLocation}
            endLocation={endLocation}
            markerIcon={taxiIcon}
            simulationDuration={200}
            onTaxiArrival={handleTaxiOver}
          />
        )}



        {(rideApproved !== true) && (rideBegins !== true) && taxiDrivers.map((taxi, index) => (
          <TaxiSim
            key={index}
            startLocation={taxi.location}
            endLocation={simLocation}
            markerIcon={taxiIcon}
            simulationDuration={1000}
            taxiName={taxi.name}
            taxiStatus={taxi.state}

          />
        ))}


      </MapContainer>


      <Modal
        isOpen={modalIsOpen}
        onRequestClose={() => setModalIsOpen(false)}
        contentLabel="Bill Confirmation Modal"
        overlayClassName="modal-overlay"
        className="modal-content"
      >
        <div className="modal-container">
          <h2 className="modal-title">DRIVE</h2>
          <p className="modal-amount">Your Taxi has arrived !!!</p>



          <div className="modal-buttons">
            <button className="modal-cancel-button" onClick={() => setModalIsOpen(false)}>
              Cancel
            </button>
            <button className="modal-pay-button" onClick={handleBegin}>
              Begin
            </button>
          </div>
        </div>
      </Modal>


      <Modal
        isOpen={modalIsOpen1}
        onRequestClose={() => setModalIsOpen1(false)}
        contentLabel="Bill Confirmation Modal"
        overlayClassName="modal-overlay"
        className="modal-content"
      >
        <div className="modal-container">
          <h2 className="modal-title">DRIVE</h2>
          <p className="modal-amount">Your reached your destination!!!</p>



          {<div className="modal-buttons">

            <button className="modal-pay-button" onClick={handleEnd}>
              Done
            </button>
          </div>}
        </div>
      </Modal>


    </div>
  );
};

export default Map;