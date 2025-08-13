import React from "react";
import CohortDetails from "./CohortDetails";

function App() {
  const cohorts = [
    { name: "React Basics", status: "ongoing", startDate: "2025-08-01", endDate: "2025-09-01" },
    { name: "Advanced JavaScript", status: "completed", startDate: "2025-06-01", endDate: "2025-07-01" },
  ];

  return (
    <div>
      <h1>Cohort Dashboard</h1>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
