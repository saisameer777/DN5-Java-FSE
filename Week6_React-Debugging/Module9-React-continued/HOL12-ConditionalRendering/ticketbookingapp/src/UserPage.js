import React from 'react';

function UserPage({ onLogout }) {
  return (
    <div>
      <h2>Welcome back!</h2>
      <p>You can now book your tickets.</p>
      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Date</th>
            <th>Price</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <tr><td>AI-101</td><td>Delhi</td><td>Mumbai</td><td>25-Jul-2024</td><td>Rs. 4500</td><td><button>Book</button></td></tr>
          <tr><td>6E-202</td><td>Chennai</td><td>Bangalore</td><td>26-Jul-2024</td><td>Rs. 2800</td><td><button>Book</button></td></tr>
          <tr><td>SG-303</td><td>Kolkata</td><td>Hyderabad</td><td>27-Jul-2024</td><td>Rs. 5200</td><td><button>Book</button></td></tr>
        </tbody>
      </table>
      <br />
      <button onClick={onLogout}>Logout</button>
    </div>
  );
}

export default UserPage;
