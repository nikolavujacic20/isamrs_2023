import axios from 'axios';
import { BASE_URL } from '../constants/constants';

const userRegister = async (email, password, firstName, lastName, address, phoneNumber) => {
  const headers = {
    'Content-Type': 'application/json',
  };

  try {
    const response = await axios.post(`${BASE_URL}/auth/sign-up`, {email, password, firstName, lastName, address, phoneNumber}, {  headers, responseType: 'json',});

    if (response && response.data) {
      return response.data;
    } else {
      throw new Error('Invalid response format');
    }
  } catch (error) {
    console.error(error);
    console.log('Error occurred during registration or fetch request');
    throw error;
  }
};

export default userRegister;