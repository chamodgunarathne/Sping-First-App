import React, { useState } from 'react';
import axios from 'axios';
import './styles.css'; 

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
  
    const handleLogin = async (e) => {
        e.preventDefault();
        setLoading(true);
      
        try {
          const response = await axios.post('http://localhost:8080/api/v1/auth/signIn', {
            email: email,
            password: password,
          });
      
          if (response.status === 200) {
            const { token, refreshtoken } = response.data;
      
            console.log('Access Token:', token);
            console.log('Refresh Token:', refreshtoken);
      
            // Store both access and refresh tokens in a secure storage (e.g., localStorage)
            localStorage.setItem('accessToken', token);
            localStorage.setItem('refreshToken', refreshtoken);
      
            // Redirect to the dashboard after successful login
             window.location.replace('/dashboard');
          } else {
            setError(response.data.message);
          }
        } catch (error) {
          setError('An unexpected error occurred.');
        }
      
        setLoading(false);
      };
      
  return (
    <div className='login-form-container'>
      <h2>Login</h2><br/>
      <form onSubmit={handleLogin} className='login-form'>
        <label>
          Email:
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </label>
        <br />
        <label>
          Password:
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </label>
        <br />
        <button type="submit" disabled={loading} className='login-button'>
          {loading ? 'Logging in...' : 'Login'}
        </button>
      </form>
      {error && <p style={{ color: 'red' }}>{error}</p>}
    </div>
  );
};

export default Login;
