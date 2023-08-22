import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './compo/Login';
import Signup from './compo/sign';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" exact element={<Login />} />
        <Route path="/signup" element={<Signup />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;
