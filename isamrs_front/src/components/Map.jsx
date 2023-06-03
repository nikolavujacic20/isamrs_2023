import L from "leaflet";
import "leaflet/dist/leaflet.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine";
import React, { useState, useRef } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import TaxiComponent from "./TaxiComponent";
import Modal from 'react-modal';
import './Modal.css';

import MapComponent from "./MapComponent";

const Map = ({ startLocation, endLocation, onRouteInfoUpdate, closestTaxiLocation,  paymentMade }) => {


  const [rideBegins, setRideBegins] = useState(false);

  const [modalIsOpen, setModalIsOpen] = useState(false);

  const handleTaxiArrival = () => {

    console.log("TAKSI STIGAO SISE");
    setRideBegins(true);
    setModalIsOpen(true);
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


  const taxiDrivers = [
    { id: 1, name: "Nikola Vujacic", location: [45.2421, 19.7129] },
    { id: 2, name: "Driver 2", location: [45.2453, 19.7399] },
  ];

  const center = [45.2396, 19.8207];
  const zoom = 13;


  const routingControlRef = useRef(null);



  const taxiRides = [
    {
      startLocation: [45.2421, 19.7129],
      endLocation: [45.2421, 19.8129],
      markerIcon: taxiIcon,
      simulationDuration: 200
    },
    {
      startLocation: [45.2453, 19.7399],
      endLocation: [45.2453, 19.8399],
      markerIcon: taxiIcon,
      simulationDuration: 500
    },

  ];

  return (
    <div>
      <MapContainer center={center} zoom={zoom} style={containerStyle}>
        <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" />



        {taxiDrivers.map((driver) => (
          <Marker key={driver.id} position={driver.location} icon={taxiIcon}>
            <Popup>
              <div>
                <h4>{driver.name}</h4>
                <p>Latitude: {driver.location[0]}</p>
                <p>Longitude: {driver.location[1]}</p>
              </div>
            </Popup>
          </Marker>
        ))}
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



        {/*     {taxiRides.map((taxi, index) => (
          <TaxiComponent
            key={index}
            startLocation={taxi.startLocation}
            endLocation={taxi.endLocation}
            markerIcon={taxi.markerIcon}
            simulationDuration={taxi.simulationDuration}
            onTaxiArrival={handleTaxiArrival}
          />
        ))} */}


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
          <p className="modal-amount">The cost of your drive is   dinars</p>
          <p className="modal-message">Estimated time of travel:   minutes</p>
         

          <div className="modal-buttons">
            <button className="modal-cancel-button" onClick={() => setModalIsOpen(false)}>
              Cancel
            </button>
            <button className="modal-pay-button" onClick={() => setModalIsOpen(false)}>
              Begin 
            </button>
          </div>
        </div>
      </Modal>


    </div>
  );
};

export default Map;