import L from "leaflet";
import "leaflet-routing-machine";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import React, { useEffect, useState, useRef } from "react";
import { useMap } from "react-leaflet";
import { Marker, Popup } from "react-leaflet";

const TaxiArrived = ({
  startLocation,
  endLocation,
  markerIcon,
  simulationDuration,
  onTaxiArrival,
  taxiName,
  taxiStatus
}) => {
  const map = useMap();
  const [distance, setDistance] = useState(null);
  const [currentPosition, setCurrentPosition] = useState(startLocation);
  const routingControlRef = useRef(null);
  const prevStartLocation = useRef(null);
  const prevEndLocation = useRef(null);

  useEffect(() => {
    if (
      !prevStartLocation.current ||
      !prevEndLocation.current ||
      prevStartLocation.current[0] !== startLocation[0] ||
      prevStartLocation.current[1] !== startLocation[1] ||
      prevEndLocation.current[0] !== endLocation[0] ||
      prevEndLocation.current[1] !== endLocation[1]
    ) {
      prevStartLocation.current = startLocation;
      prevEndLocation.current = endLocation;

      if (routingControlRef.current) {
        map.removeControl(routingControlRef.current);
      }

      const control = L.Routing.control({
        waypoints: [
          L.latLng(startLocation[0], startLocation[1]),
          L.latLng(endLocation[0], endLocation[1])
        ],
        createMarker: (i, wp, nWps) => {
          return null; // Return null for all waypoints to prevent the rendering of the route information box
        },
        routeWhileDragging: true,
        lineOptions: {
          styles: [{ color: "transparent" }]
        },
        show: false
      })
        .on("routesfound", (e) => {
          const routes = e.routes;
          if (routes && routes.length > 0) {
            const route = routes[0];
            setDistance(route.summary.totalDistance / 1000);
            simulateMarkerMovement(route);
          }
        })
        .addTo(map);

      routingControlRef.current = control;
    }
  }, [map, startLocation, endLocation, markerIcon]);

  const simulateMarkerMovement = (route) => {
    const positions = route.coordinates;
    const totalPositions = positions.length;
    let currentPositionIndex = 0;

    const interval = setInterval(() => {
      if (currentPositionIndex >= totalPositions) {
        clearInterval(interval);
        onTaxiArrival();
        return;
      }

      const newPosition = positions[currentPositionIndex];
      setCurrentPosition([newPosition.lat, newPosition.lng]);
      currentPositionIndex++;
    }, simulationDuration);
  };

  useEffect(() => {
    const routeInstructionsPanel = document.querySelector(
      ".leaflet-routing-container .leaflet-routing-container-via-instructions"
    );
    if (routeInstructionsPanel) {
      routeInstructionsPanel.style.display = "none";
    }
  }, []);

  return (
    <div>

      <Marker position={currentPosition} icon={markerIcon}>
        <Popup>
          <p><strong>Driver: {taxiName} </strong></p>
          <p><strong>Status: {taxiStatus}</strong></p>
          <button></button>
        </Popup>
      </Marker>
    </div>
  );
};

export default TaxiArrived;