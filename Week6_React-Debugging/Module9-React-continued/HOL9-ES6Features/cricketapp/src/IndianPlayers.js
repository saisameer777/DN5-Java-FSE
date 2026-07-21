import React from 'react';

function IndianPlayers() {
  const allPlayers = ['Rohit', 'Gill', 'Kohli', 'Iyer', 'Rahul', 'Pandya', 'Jadeja', 'Axar', 'Bumrah', 'Shami', 'Kuldeep'];

  const [oddPlayers, evenPlayers] = [
    allPlayers.filter((_, i) => i % 2 !== 0),
    allPlayers.filter((_, i) => i % 2 === 0),
  ];

  const T20players      = ['Rohit', 'Kohli', 'Bumrah', 'Pandya', 'Rahul'];
  const RanjiTrophyPlayers = ['Gill', 'Iyer', 'Jadeja', 'Axar', 'Shami'];
  const mergedPlayers   = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <ul>{oddPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h2>Even Team Players</h2>
      <ul>{evenPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>

      <h2>Merged Squad (T20 + Ranji Trophy)</h2>
      <ul>{mergedPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
}

export default IndianPlayers;
