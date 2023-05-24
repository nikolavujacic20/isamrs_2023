
import { Routes, Route } from 'react-router-dom';
import React, { useState } from 'react';
import './App.css';

import Navbar from './components/Navbar.jsx'
import Tickets from './pages/Tickets';
import Home from './pages/Home.jsx';
import Login from './pages/Login.jsx';
import Profile from './pages/Profile';
import Footer from './components/Footer.jsx';
import Users from './pages/Users';
import Register from './pages/Register';
import profilna from './images/profile.png';




function App() {

  const [role, setRole] = useState(null);

  const handleRoleUpdate = (newRole) => {
    setRole(newRole);
  };


  const user = {
    id: 1,
    name: 'Nikola',
    surname: 'Vujacic',
    phone: '0643996648',
    email: 'john@example.com',
    address: 'Ilije Bircanina 3',
    picture: profilna
  };


  return (
    <div>
      <Navbar role={role} onRoleUpdate={handleRoleUpdate} />

      <Routes>
        <Route exact path="/" element={<Home  />} />
        <Route exact path="/register" element={<Register  />} />
        <Route path="/users" element={<Users />} />
        <Route path="/tickets" element={<Tickets />} />
        <Route path="/login" element={<Login onRoleUpdate={handleRoleUpdate} />} />
        <Route path="/profile" element={<Profile user={user} />} />
      </Routes>

      <Footer />


    </div>



  );
};

export default App;