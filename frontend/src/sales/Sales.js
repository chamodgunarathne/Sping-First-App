import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Home() {
  const [items, setItems] = useState([]);

  const { id } = useParams();

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/items");
    setItems(result.data);
  };
 

  const deleteUser = async (id) => {
    const isConfirmed = window.confirm("Are you sure you want to delete the user?");
    if (isConfirmed) {
      await axios.delete(`http://localhost:8080/itemDelete/${id}`);
    loadUsers();
    } else {
      console.log("Error deleted item.");
    }
    
  };

  return (
    <>
    <div className="d-flex justify-content-end" style={{ margin: '10px' }}>
    <Link className="btn btn-secondary" to="/addSales">
        Add Sales
    </Link>
</div>

    
    
            <div className="container">
                    
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Item</th>
              <th scope="col">Quantity</th>
              <th scope="col">Price</th>
              <th scope="col">Total</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{item.name}</td>
                <td>{item.sales}</td>
                <td>{item.price}</td>
                <td>{item.price * item.sales}</td>
                <td>
                  <Link
                    className="btn btn-primary mx-2"
                    to={`/viewSales/${item.id}`}
                  >
                    View
                  </Link>
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/editSales/${item.id}`}
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deleteUser(item.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
    
    </>
    
  );
}
