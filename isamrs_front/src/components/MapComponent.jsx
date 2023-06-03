import L from "leaflet";
import "leaflet-routing-machine";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import React, { useEffect, useState, useRef } from "react";
import { useMap } from "react-leaflet";
import { Marker } from "react-leaflet";

const MapComponent = ({ startLocation, endLocation, markerIcon, onRouteInfoUpdate }) => {
  const map = useMap();
  const [distance, setDistance] = useState(null);
  const [duration, setDuration] = useState(null);

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

      if (startLocation && endLocation) {
        const control = L.Routing.control({
          waypoints: [
            L.latLng(startLocation[0], startLocation[1]),
            L.latLng(endLocation[0], endLocation[1])
          ],
          createMarker: (i, wp, nWps) => {
            return L.marker(wp.latLng, { icon: markerIcon, draggable: true });
          },
          routeWhileDragging: true,
        })
          .on("routesfound", (e) => {
            const routes = e.routes;
            if (routes && routes.length > 0) {
              const route = routes[0];
              const newDistance = route.summary.totalDistance / 1000;
              const newDuration = route.summary.totalTime / 60;
              setDistance(newDistance);
              setDuration(newDuration);
              onRouteInfoUpdate(newDistance, newDuration);
            }
          })
          .addTo(map);

        routingControlRef.current = control;
      }
    }
  }, [map, startLocation, endLocation, markerIcon, onRouteInfoUpdate]);

  return (
    <div>
      {/* Render distance and duration if available */}
      {distance && <p>Distance: {distance.toFixed(2)} km</p>}
      {duration && <p>Duration: {duration.toFixed(2)} minutes</p>}
      {startLocation && endLocation && (
        <Marker position={startLocation} icon={markerIcon} />
      )}
    </div>
  );
};

export default MapComponent;