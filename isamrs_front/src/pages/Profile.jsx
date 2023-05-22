import React, { useState } from 'react';
import './Profile.css';

const Profile = ({ user }) => {
  const [editing, setEditing] = useState(false);
  const [editedUser, setEditedUser] = useState(user);

  const handleInputChange = (e) => {
    setEditedUser({ ...editedUser, [e.target.name]: e.target.value });
    console.log(editedUser);
  };

  const handleEditClick = () => {
    setEditing(true);
  };

  const handleSaveClick = () => {

    
    setEditing(false);

  };

  return (
    <div className="profile-container">
      <h2 className="profile-heading">User Profile</h2>
      <div className="profile-picture">
        <img src={user.picture} alt="" />
      </div>
      <div className="profile-info">
        <div className="profile-field">
          <label className="profile-label">Name:</label>
          {editing ? (
            <input
              className="profile-input"
              type="text"
              name="name"
              value={editedUser.name}
              onChange={handleInputChange}
            />
          ) : (
            <span className="profile-value">{editedUser.name}</span>
          )}
        </div>
        <div className="profile-field">
          <label className="profile-label">Surname:</label>
          {editing ? (
            <input
              className="profile-input"
              type="surname"
              name="surname"
              value={editedUser.surname}
              onChange={handleInputChange}
            />
          ) : (
            <span className="profile-value">{editedUser.surname}</span>
          )}
        </div>
        <div className="profile-field">
          <label className="profile-label">Phone:</label>
          {editing ? (
            <input
              className="profile-input"
              type="phone"
              name="phone"
              value={editedUser.phone}
              onChange={handleInputChange}
            />
          ) : (
            <span className="profile-value">{editedUser.phone}</span>
          )}
        </div>
        <div className="profile-field">
          <label className="profile-label">Email:</label>
          {editing ? (
            <input
              className="profile-input"
              type="email"
              name="email"
              value={editedUser.email}
              onChange={handleInputChange}
            />
          ) : (
            <span className="profile-value">{editedUser.email}</span>
          )}
        </div>
        <div className="profile-field">
          <label className="profile-label">Address:</label>
          {editing ? (
            <input
              className="profile-input"
              type="address"
              name="address"
              value={editedUser.address}
              onChange={handleInputChange}
            />
          ) : (
            <span className="profile-value">{editedUser.address}</span>
          )}
        </div>
        {editing ? (
          <button className="profile-button" onClick={handleSaveClick}>Save</button>
        ) : (
          <button className="profile-button" onClick={handleEditClick}>Edit</button>
        )}
      </div>
    </div>
  );
};

export default Profile;