import L from "leaflet";
import "leaflet/dist/leaflet.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine";
import React, { useState, useRef } from "react";
import { MapContainer, TileLayer, Marker, Popup} from "react-leaflet";
import TaxiComponent from "./TaxiComponent";

import MapComponent from "./MapComponent";

const Map = ({startLocation,endLocation}) => {

  const [rideBegins, setRideBegins] = useState(false);
 
  const handleTaxiArrival = () => {
    
    console.log("TAKSI STIGAO SISE");
    setRideBegins(true);
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
      startLocation: [45.2421, 19.7129], // Start location for Taxi 1
      endLocation: [45.2421, 19.8129], // End location for Taxi 1
      markerIcon: taxiIcon,
      simulationDuration: 200// Simulation duration for Taxi 1 in milliseconds
    },
    {
      startLocation: [45.2453, 19.7399], // Start location for Taxi 2
      endLocation: [45.2453, 19.8399], // End location for Taxi 2
      markerIcon: taxiIcon,
      simulationDuration: 500 // Simulation duration for Taxi 2 in milliseconds
    },
    // Add more taxi rides as needed...
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
         {startLocation && endLocation && (
          <MapComponent
            startLocation={startLocation}
            endLocation={endLocation}
            routingControlRef={routingControlRef}
            markerIcon={markerIcon}
            simulationDuration={1000}
          />
        )}

{taxiRides.map((taxi, index) => (
        <TaxiComponent
          key={index}
          startLocation={taxi.startLocation}
          endLocation={taxi.endLocation}
          markerIcon={taxi.markerIcon}
          simulationDuration={taxi.simulationDuration}
          onTaxiArrival={handleTaxiArrival}
        />
      ))}


      </MapContainer>
    </div>
  );
};

export default Map;