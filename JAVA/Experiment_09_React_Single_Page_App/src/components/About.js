import React from 'react';

function About(props) {
  return (
    <div>
      <h1>About</h1>
      <p>{props.message}</p>
    </div>
  );
}

export default About;

// HOW TO RUN:
// Needs Node.js 16+. In the Experiment_09 folder run:
// 1. npm install
// 2. npm start   (opens http://localhost:3000)
