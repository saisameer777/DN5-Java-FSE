import React from 'react';
import CalculateScore from './CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore name="John Doe" school="ABC High School" total={450} goal={500} />
    </div>
  );
}

export default App;
