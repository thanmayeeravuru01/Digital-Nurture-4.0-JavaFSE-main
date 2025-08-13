import React from 'react';

function EventButton() {
  const handleClick = () => {
    alert('Button was clicked!');
  };
  return (
    <div className="event-app">
      <button onClick={handleClick}>Click Me</button>
    </div>
  );
}

export default function EventExamplesApp() {
  return <EventButton />;
}
