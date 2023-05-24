import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css';
import profile from '../images/profile.png';

const Navbar = ({ role, onRoleUpdate }) => {
  const isUserLoggedIn = role === 'admin' || role === 'registered';
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    onRoleUpdate('');
    navigate('/');
  };

  return (
    <nav className="navbar">
      <div className="navbar-links">
        <Link to="/" className="navbar-link">
          <b>Home</b>
        </Link>
      </div>
      <div className="navbar-links navbar-links-right">
        {!isUserLoggedIn && (
          <>
            <Link to="/register" className="navbar-link">
              <b>Register</b>
            </Link>
            <Link to="/login" className="navbar-link">
              <b>Login</b>
            </Link>
          </>
        )}
        {isUserLoggedIn && role === 'admin' && (
          <Link to="/users" className="navbar-link">
            <b>Users</b>
          </Link>
        )}
        {isUserLoggedIn && (
          <Link to="/tickets" className="navbar-link">
            <b>Tickets</b>
          </Link>
        )}
        {isUserLoggedIn && (
          <Link to="/profile">
            <img src={profile} alt="Profile" style={{ width: 50, height: 50 }} />
          </Link>
        )}
        {isUserLoggedIn && (
          <span className="navbar-link" onClick={handleLogoutClick}>
            Logout
          </span>
        )}
      </div>
    </nav>
  );
};

export default Navbar;