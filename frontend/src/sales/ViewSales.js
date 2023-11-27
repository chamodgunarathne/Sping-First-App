import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewItem() {
  const [item, setItem] = useState({
    name: "",
    sales: "",
    price: "",
  });

  const { id } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/item/${id}`);
    setItem(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Item Details</h2>

          <div className="card">
            <div className="card-header">
              Details of item id : {item.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Item:</b>
                  {item.name}
                </li>
                <li className="list-group-item">
                  <b>Sales:</b>
                  {item.sales}
                </li>
                <li className="list-group-item">
                  <b>Price:</b>
                  {item.price}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/"}>
            Back to Home
          </Link>
        </div>
      </div>
    </div>
  );
}
