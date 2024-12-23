import React from 'react'
import { useState, useEffect } from 'react';

const Location = ({ onLocationSubmit }) => {
    const [location, setLocation] = useState('');
    const [isDay, setIsDay] = useState(null);

    const change = (event) => {
        setLocation(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        if(location){
            onLocationSubmit(location);

            try{
                const res = await fetch(`http://api.weatherstack.com/current?access_key=${import.meta.env.VITE_API_KEY}&query=${location}&units=f`);
                const data = await res.json();
                console.log(data);
                if(data && data.current){
                    setIsDay(data.current.is_day);
                  
                }
            } catch (error) {
                console.error('Error fetching data: ', error);
                
            }
        }
    };


    const backgroundClass = isDay === 'no' ? 'bg-blue-900' : 'bg-sky-500';
    const backgroundBorder = isDay === 'no' ? 'border-blue-950' : 'border-sky-700';


  return (
    <div className={`${backgroundClass} flex items-center 
    justify-center w-1/2 mx-auto border-2 ${backgroundBorder} 
    rounded-xl shadow-xl p-6`}>
    <form onSubmit={handleSubmit} className="flex flex-col items-center">
    <label htmlFor="location" className="mb-2 text-3xl font-extrabold text-white">
        Enter a Location: </label>
    <div className="flex items-center">
      <input 
        type="text" 
        id="location" 
        name="location" 
        value={location} 
        onChange={change}
        placeholder = "Omaha"
        className="p-2 border rounded"
      />
      <input 
        type="submit" 
        value="Submit" 
        className="p-2 border rounded ml-2 bg-sky-500 hover:bg-cyan-500 text-white font-bold"
      />
    </div>
  </form>
</div>

  )
}

export default Location