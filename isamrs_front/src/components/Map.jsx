import L from "leaflet";
import "leaflet/dist/leaflet.css";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import "leaflet-routing-machine";
import React, { useState, useRef } from "react";
import { MapContainer, TileLayer, Marker, Popup} from "react-leaflet";

import MapComponent from "./MapComponent";

const Map = () => {

 


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

  const [startLocation, setStartLocation] = useState([45.2421, 19.8129]);
  const [endLocation, setEndLocation] = useState([45.2453, 19.8399]);
  const routingControlRef = useRef(null);

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
        <MapComponent
          startLocation={startLocation}
          endLocation={endLocation}
          routingControlRef={routingControlRef}
          markerIcon={markerIcon}
        />
      </MapContainer>
    </div>
  );
};

export default Map;