import React from 'react'
import Location from './components/Location';
import GeneralStats from './components/GeneralStats';
import { useState, useEffect } from 'react';

const App = () => {

  const [location, setLocation] = useState('');

  const handleLocationSubmit = (newLocation) => {
    setLocation(newLocation);
  };


  return (
    <>
      <Location onLocationSubmit={handleLocationSubmit} />
      <GeneralStats location = {location} />
    </>
    
  )
}

export default App
