import React, { useState } from 'react';

function Home(props) {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h1>Home</h1>
      <p>Welcome to {props.college}</p>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Add</button>
      <button onClick={() => setCount(count - 1)}>Subtract</button>
    </div>
  );
}

export default Home;

// HOW TO RUN:
// Needs Node.js 16+. In the Experiment_09 folder run:
// 1. npm install
// 2. npm start   (opens http://localhost:3000)
