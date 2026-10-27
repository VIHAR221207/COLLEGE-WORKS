import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <div className="menu">
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
        <Link to="/contact">Contact</Link>
      </div>

      <Routes>
        <Route path="/" element={<Home college="My College" />} />
        <Route path="/about" element={<About message="This is a React Single Page App" />} />
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;

// HOW TO RUN:
// Needs Node.js 16+. In the Experiment_09 folder run:
// 1. npm install
// 2. npm start   (opens http://localhost:3000)
