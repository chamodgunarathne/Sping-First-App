import React from 'react';
import useAuthorization from '../hooks/useAuthorization';
import Home from './Home';
import Navbar from "../layout/Navbar";

const AdminComponent = () => <div><Home/>Admin</div>;
const UserComponent = () => <div>User</div>;

const Dashboard = () => {
  const userRoles = useAuthorization();
  console.log("Role :",userRoles);

  const isAdmin = userRoles.includes('ADMIN');
  const isUser = userRoles.includes('USER');

  return (
    <div>
        <Navbar/>
      <h2>Dashboard</h2>
      {isAdmin && <AdminComponent />}
      {isUser && <UserComponent />}
    </div>
  );
};

export default Dashboard;
