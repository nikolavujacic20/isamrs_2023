import React, { useState } from "react";

const GeosearchForm = () => {
  const [address, setAddress] = useState("");
  const [coordinates, setCoordinates] = useState(null);

  const handleAddressChange = (event) => {
    setAddress(event.target.value);
  };

  const handleGeocode = () => {
    fetch(
      `https://nominatim.openstreetmap.org/search?q=${encodeURIComponent(
        address
      )}&format=json`
    )
      .then((response) => response.json())
      .then((data) => {
        if (data && data.length > 0) {
          const { lat, lon } = data[0];
          setCoordinates([parseFloat(lat), parseFloat(lon)]);
        }
      })
      .catch((error) => {
        console.error("Error geocoding address:", error);
      });
  };

  return (
    <div>
      <input type="text" value={address} onChange={handleAddressChange} />
      <button onClick={handleGeocode}>Geocode</button>
      {coordinates && (
        <p>Coordinates: {coordinates[0]}, {coordinates[1]}</p>
      )}
    </div>
  );
};

export default GeosearchForm;