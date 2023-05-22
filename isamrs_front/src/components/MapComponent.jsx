import L from "leaflet";
import "leaflet-routing-machine";
import "leaflet-routing-machine/dist/leaflet-routing-machine.css";
import React, { useEffect, useState, useRef } from "react";
import { useMap } from "react-leaflet";

const MapComponent = ({ startLocation, endLocation, markerIcon }) => {
  const map = useMap();
  const [distance, setDistance] = useState(null);
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
          return L.marker(wp.latLng, { icon: markerIcon, draggable: true });
        },
        routeWhileDragging: true,
      })
        .on("routesfound", (e) => {
          const routes = e.routes;
          if (routes && routes.length > 0) {
            const route = routes[0];
            setDistance(route.summary.totalDistance / 1000);
          }
        })
        .addTo(map);

      routingControlRef.current = control;
    }
  }, [map, startLocation, endLocation, markerIcon]);

  return (
    <div>
      {distance !== null && <p>Distance: {distance.toFixed(2)} km</p>}
    </div>
  );
};

export default MapComponent;