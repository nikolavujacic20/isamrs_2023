import L from "leaflet";
import React, { useEffect, useState } from "react";

const TaxiFinder = ({ taxiLocations, startLocation, onTaxiUpdate, onDurationUpdate }) => {
  useEffect(() => {
    let closestDistance = Infinity;
    let closestTaxi = null;

    if (startLocation && taxiLocations.length > 0) {
      for (const taxi of taxiLocations) {
        const distance = calculateDistance(startLocation, taxi.location);

        if (distance < closestDistance) {
          closestDistance = distance;
          closestTaxi = taxi;
        }
      }
    }

    onTaxiUpdate(closestTaxi);

    if (closestTaxi) {
      const distance = calculateDistance(startLocation, closestTaxi.location);
      const calculatedDuration = estimateDuration(distance);
      onDurationUpdate(calculatedDuration);
    } else {
      onDurationUpdate(null);
    }
  }, [startLocation, taxiLocations, onTaxiUpdate, onDurationUpdate]);

  const calculateDistance = (location1, location2) => {
    const latLng1 = L.latLng(location1[0], location1[1]);
    const latLng2 = L.latLng(location2[0], location2[1]);
    return latLng1.distanceTo(latLng2) / 1000; // Distance in kilometers
  };

  const estimateDuration = (distance) => {
    // Customize this function to estimate the duration based on the distance
    // You can use a simple formula or refer to any external data source for more accurate estimations
    return Math.round(distance * 10); // Example: 10 minutes per kilometer
  };

  return null; // Render nothing
};

export default TaxiFinder;