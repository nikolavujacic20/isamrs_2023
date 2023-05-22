import React, { useState } from 'react';
import './RouteForm.css';

const RouteForm = ({ onRouteSubmit }) => {
  const [start, setStart] = useState('');
  const [end, setEnd] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onRouteSubmit(start, end);
  };

  return (
    <form className="route-form" onSubmit={handleSubmit}>
      <div className="form-group">
        <label htmlFor="start">Start Location</label>
        <input
          type="text"
          id="start"
          value={start}
          onChange={(e) => setStart(e.target.value)}
          required
        />
      </div>
      <div className="form-group">
        <label htmlFor="end">End Location</label>
        <input
          type="text"
          id="end"
          value={end}
          onChange={(e) => setEnd(e.target.value)}
          required
        />
      </div>
      <button type="submit">Calculate Route</button>
    </form>
  );
};

export default RouteForm;