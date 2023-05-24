import L from "leaflet";
import "leaflet-routing-machine";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import React, { useEffect, useState, useRef } from "react";
import { useMap } from "react-leaflet";
import { Marker } from "react-leaflet";

const TaxiComponent = ({ startLocation, endLocation, markerIcon, simulationDuration, onTaxiArrival }) => {
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
            if (i === 0) {
              return L.marker(wp.latLng, { icon: markerIcon, draggable: true });
            }
            return null; // Do not create markers for other waypoints
          },
        routeWhileDragging: true,
        lineOptions: {
          styles: [{ color: "transparent" }]
        },
        show: false // Prevent the route line and info from being displayed on the map
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
        onTaxiArrival(); // Invoke the callback function when the taxi reaches the end location
        return;
      }

      const newPosition = positions[currentPositionIndex];
      setCurrentPosition([newPosition.lat, newPosition.lng]);
      currentPositionIndex++;
    }, simulationDuration);
  };

  return (
    <div>
      {distance !== null && <p>Distance: {distance.toFixed(2)} km</p>}
      <Marker position={currentPosition} icon={markerIcon} />
    </div>
  );
};

export default TaxiComponent;