import React, { useState } from 'react';

function Contact() {
  const [name, setName] = useState('');
  const [sent, setSent] = useState(false);

  function submit(e) {
    e.preventDefault();
    setSent(true);
  }

  return (
    <div>
      <h1>Contact</h1>
      {sent ? (
        <p>Thank you {name}</p>
      ) : (
        <form onSubmit={submit}>
          Name: <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
          <button type="submit">Send</button>
        </form>
      )}
    </div>
  );
}

export default Contact;

// HOW TO RUN:
// Needs Node.js 16+. In the Experiment_09 folder run:
// 1. npm install
// 2. npm start   (opens http://localhost:3000)
