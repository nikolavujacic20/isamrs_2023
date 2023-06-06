import React, { useState, useEffect } from 'react';
import './Tickets.css';

const Tickets = () => {
  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    const rideStringified = localStorage.getItem('ride');
    setTickets(JSON.parse(rideStringified));
  }, []);

  console.log(tickets);

  return (
    <div className="tickets-container">
      <table className="tickets-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Driver</th>
            <th>Price</th>
            <th>Time</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{tickets.id}</td>
            <td>{tickets.driverName}</td>
            <td>{tickets.price}</td>

          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default Tickets;