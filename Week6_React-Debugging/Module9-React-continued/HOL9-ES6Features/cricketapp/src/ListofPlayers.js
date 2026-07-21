import React from 'react';

function ListofPlayers() {
  const players = [
    { name: 'Rohit Sharma',    score: 85 },
    { name: 'Shubman Gill',    score: 62 },
    { name: 'Virat Kohli',     score: 91 },
    { name: 'Shreyas Iyer',    score: 45 },
    { name: 'KL Rahul',        score: 78 },
    { name: 'Hardik Pandya',   score: 55 },
    { name: 'Ravindra Jadeja', score: 38 },
    { name: 'Axar Patel',      score: 67 },
    { name: 'Jasprit Bumrah',  score: 12 },
    { name: 'Mohammed Shami',  score: 8  },
    { name: 'Kuldeep Yadav',   score: 22 },
  ];

  const lowScorers = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>

      <h2>Players with Score Below 70</h2>
      <ul>
        {lowScorers.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
