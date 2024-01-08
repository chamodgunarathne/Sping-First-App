import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddUser from "./users/AddUser";
import EditUser from "./users/EditUser";
import ViewUser from "./users/ViewUser";
import Sales from "./sales/Sales";
import AddSales from "./sales/AddSales";
import ViewSales from "./sales/ViewSales";
import EditSales from "./sales/EditSales";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";

function App() {
  return (
    <div className="App">
      <Router>
        
        <Routes>
        <Route exact path="/" element={<Login />} />
        <Route exact path="/dashboard" element={<Dashboard />} />
          <Route exact path="/home" element={<Home />} />
          <Route exact path="/adduser" element={<AddUser />} />
          <Route exact path="/edituser/:id" element={<EditUser />} />
          <Route exact path="/viewuser/:id" element={<ViewUser />} />
          <Route exact path="/sales" element={<Sales />} />
          <Route exact path="/addSales" element={<AddSales />} />
          <Route exact path="/viewSales/:id" element={<ViewSales />} />
          <Route exact path="/editSales/:id" element={<EditSales />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
