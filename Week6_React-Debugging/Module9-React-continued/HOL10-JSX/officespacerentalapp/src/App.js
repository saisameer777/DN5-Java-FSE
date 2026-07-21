import React from 'react';

function App() {
  const offices = [
    { name: 'Tech Park A', rent: 45000, address: '12, MG Road, Bangalore' },
    { name: 'Business Hub B', rent: 75000, address: '5, Andheri East, Mumbai' },
    { name: 'Workspace C', rent: 55000, address: '8, Hitech City, Hyderabad' },
  ];

  return (
    <div>
      <h1>Office Space Rental</h1>
      <img src="https://via.placeholder.com/400x200" alt="Office Space" />

      {offices.map((office, index) => (
        <div key={index} style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
          <h3>{office.name}</h3>
          <p>
            Rent:{' '}
            <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
              Rs. {office.rent}
            </span>
          </p>
          <p>Address: {office.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
