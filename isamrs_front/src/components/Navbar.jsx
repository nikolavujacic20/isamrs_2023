import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css';
import profile from '../images/profile.png';

const Navbar = ({ role, onRoleUpdate }) => {
  const isUserLoggedIn = role === 'admin' || role === 'driver';
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    onRoleUpdate('');
    navigate('/');
  };

  return (
    <nav className="navbar">
      <div className="navbar-links">
        {isUserLoggedIn && (
          <Link to="/profile">
            <img src={profile} alt="Profile" className="profile-image" />
          </Link>
        )}
        <Link to="/" className="navbar-link">
          <b>Home</b>
        </Link>
        {isUserLoggedIn && (
          <>
            {role === 'admin' && (
              <Link to="/users" className="navbar-link">
                <b>Users</b>
              </Link>
            )}
            <Link to="/tickets" className="navbar-link">
              <b>Reservations</b>
            </Link>
            {role === 'driver' && (
              <Link to="/drives" className="navbar-link">
                <b>History</b>
              </Link>
            )}
          </>
        )}
      </div>
      {isUserLoggedIn ? (
        <div className="navbar-links-right">
          <span className="navbar-link" onClick={handleLogoutClick}>
            Logout
          </span>
        </div>
      ) : (
        <div className="navbar-links-right">
          <Link to="/register" className="navbar-link">
            <b>Register</b>
          </Link>
          <Link to="/login" className="navbar-link">
            <b>Login</b>
          </Link>
        </div>
      )}
    </nav>
  );
};

export default Navbar;