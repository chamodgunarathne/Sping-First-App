import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const useAuthorization = () => {
  const navigate = useNavigate();
  const [userRoles, setUserRoles] = useState([]);

  useEffect(() => {
    const accessToken = localStorage.getItem('accessToken');
    console.log("AToken : ",accessToken)

    if (!accessToken) {
      navigate('/');
      return;
    }
  
    try {
      console.log('Access Token:', accessToken);
      const decodedToken = parseJwt(accessToken);
      console.log('Decoded Token:', decodedToken);
  
      const roles = decodedToken.roles || [];
      setUserRoles(roles);
    } catch (error) {
      console.error('Error decoding JWT token:', error);
      navigate('/');
    }
  }, [navigate]);

  const parseJwt = (token) => {
    try {
      const base64Url = token.split('.')[1];
      if (!base64Url) {
        throw new Error('Invalid token format');
      }
  
      const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      const jsonPayload = decodeURIComponent(atob(base64).split('').map((c) => '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2)).join(''));
      return JSON.parse(jsonPayload);
    } catch (error) {
      console.error('Error decoding JWT token:', error);
      throw error;
    }
  };
  
  return userRoles;
};

export default useAuthorization;
