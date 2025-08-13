import React, { useState } from "react";
import CricketApp from "./CricketApp";
import OfficeSpaceApp from "./OfficeSpaceApp";
import EventExamplesApp from "./EventExamplesApp";
import TicketBookingApp from "./TicketBookingApp";
import BloggerApp from "./BloggerApp";
import "./App.css";

function App() {
  const [selectedApp, setSelectedApp] = useState("");

  const renderSelectedApp = () => {
    switch (selectedApp) {
      case "Cricket":
        return <CricketApp />;
      case "Office":
        return <OfficeSpaceApp />;
      case "Event":
        return <EventExamplesApp />;
      case "Ticket":
        return <TicketBookingApp />;
      case "Blogger":
        return <BloggerApp />;
      default:
        return (
          <div className="app-content">
            <h3>Welcome! 👋</h3>
            <p>Select an app above to see it in action.</p>
          </div>
        );
    }
  };

  return (
    <div className="app-container">
      <h1>Week 7 React Apps</h1>

      {/* Buttons */}
      <div className="button-container">
        <button onClick={() => setSelectedApp("Cricket")}>Cricket App</button>
        <button onClick={() => setSelectedApp("Office")}>Office Space</button>
        <button onClick={() => setSelectedApp("Event")}>Event Example</button>
        <button onClick={() => setSelectedApp("Ticket")}>Ticket Booking</button>
        <button onClick={() => setSelectedApp("Blogger")}>Blogger</button>
      </div>

      {/* App Content */}
      {renderSelectedApp()}
    </div>
  );
}

export default App;
