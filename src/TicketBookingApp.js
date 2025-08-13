import React, { useState } from 'react';

function Login({ onLogin }) {
  return <button onClick={onLogin}>Login</button>;
}

function Booking() {
  return <h2>Welcome to Ticket Booking</h2>;
}

export default function TicketBookingApp() {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <div className="ticket-app">
      {loggedIn ? <Booking /> : <Login onLogin={() => setLoggedIn(true)} />}
    </div>
  );
}
