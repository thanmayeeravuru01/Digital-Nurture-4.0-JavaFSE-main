import React from 'react';

function PlayerDetails(props) {
  return (
    <div className="cricket-app">
      <h2>{props.name}</h2>
      <p>Runs: {props.runs}</p>
      <p>Country: {props.country}</p>
    </div>
  );
}

export default function CricketApp() {
  return <PlayerDetails name="Virat Kohli" runs={12000} country="India" />;
}
