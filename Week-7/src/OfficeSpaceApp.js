import React from 'react';

function SpaceDetails({ name, location, price }) {
  return (
    <div className="office-app">
      <h2>{name}</h2>
      <p>Location: {location}</p>
      <p>Price: ₹{price}/month</p>
    </div>
  );
}

export default function OfficeSpaceApp() {
  return <SpaceDetails name="Tech Park" location="Chennai" price={50000} />;
}
