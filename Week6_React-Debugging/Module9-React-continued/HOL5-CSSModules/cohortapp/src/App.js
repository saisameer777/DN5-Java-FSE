import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    { name: 'React Batch 1', trainer: 'John', startDate: '01-Jan-2024', endDate: '31-Mar-2024', status: 'completed' },
    { name: 'React Batch 2', trainer: 'Jane', startDate: '01-Apr-2024', endDate: '30-Jun-2024', status: 'ongoing' },
    { name: 'React Batch 3', trainer: 'Bob',  startDate: '01-Jul-2024', endDate: '30-Sep-2024', status: 'ongoing' },
  ];

  return (
    <div>
      <h2>Cohort Dashboard</h2>
      {cohorts.map((cohort, index) => (
        <CohortDetails
          key={index}
          name={cohort.name}
          trainer={cohort.trainer}
          startDate={cohort.startDate}
          endDate={cohort.endDate}
          status={cohort.status}
        />
      ))}
    </div>
  );
}

export default App;
