import React from 'react';
import { useEffect, useState } from 'react';
import Spinner from './Spinner';

const GeneralStats = ( {location} ) => {

    const [temperature, setTemperature] = useState(null);
    const [feelslike, setFeelsLike] = useState(null);
    const [weatherDescription, setWeatherDescription] = useState(null);
    const [weatherIcon, setWeatherIcon] = useState(null);
    const [time, setTime] = useState(null);
    const [windSpeed, setWindSpeed] = useState(null);
    const [windDirection, setWindDirection] = useState(null);
    const [uv, setUv] = useState(null);
    const [loading, setLoading] = useState(true);
    const [humidity, setHumidity] = useState(null);
    const [isDay, setIsDay] = useState(null);

    useEffect(() => {
        const info = async () => {
            try {
                const res = await fetch(`http://api.weatherstack.com/current?access_key=${import.meta.env.VITE_API_KEY}&query=${location}&units=f`);
                const data = await res.json();
                console.log(data);
                if (data && data.current && data.location) {
                    setTemperature(data.current.temperature);
                    setFeelsLike(data.current.feelslike);
                    setWeatherDescription(data.current.weather_descriptions[0]);
                    setWeatherIcon(data.current.weather_icons[0]);
                    setTime(data.current.observation_time);
                    setWindSpeed(data.current.wind_speed);
                    setWindDirection(data.current.wind_dir);
                    setUv(data.current.uv_index);
                    setHumidity(data.current.humidity);
                    setIsDay(data.current.is_day);
                    setLoading(false);
                }
            } catch (error) {
                console.error('Error fetching data:', error);
                setLoading(true);
            }
        };
        if(location){
            setLoading(true);
            info();
        }
    }, [location]);

    useEffect(() => {
        if(isDay === 'yes'){
            document.body.style.backgroundColor = '#0285C7';
        } else if(isDay === 'no'){
            document.body.style.backgroundColor = '#172554';
        }
    }, [isDay]);

    const backgroundClass = isDay === 'no' ? 'bg-blue-900' : 'bg-sky-500';
    const backgroundBorder = isDay === 'no' ? 'border-blue-950' : 'border-sky-700';

  return (
    <>
    <div className={`${backgroundClass} flex 
    flex-col justify-center items-center w-1/2 mx-auto my-10 
    gap-0 border-2 ${backgroundBorder} rounded-xl shadow-xl p-6`}>
        
        <p className="text-white text-2xl font-bold">
            {location || 'Loading...'}</p>
        <h1 className="text-white text-6xl">
           {loading ? <Spinner loading={loading}/> : `${temperature}º`} 
           </h1>
        <p className="text-white">
        <span className="font-bold">Feels like: </span>
        {loading ? <Spinner loading={loading}/> : `${feelslike}º`}</p>

    </div>

    <div className={`${backgroundClass} flex 
    flex-col justify-center items-center w-1/2 mx-auto my-10 
    gap-0 border-2 ${backgroundBorder} rounded-xl shadow-xl p-6`}>
        <div className="text-white">
            <p><span className="font-bold">Weather Condition: </span> 
            {loading ? <Spinner loading={loading}/> : `${weatherDescription}`}
             </p>
            <p> <span className="font-bold">Time: </span> 
            {loading ? <Spinner loading={loading}/> : `${time}`}</p>
            <p> <span className="font-bold">Wind: </span> 
            {loading ? <Spinner loading={loading}/> : `${windSpeed} mph ${windDirection}`} </p>
            <p> <span className="font-bold">UV Index: </span> 
                {loading ? <Spinner loading={loading}/> : `${uv}`}
            </p>
            <p> <span className="font-bold">Humidity: </span>
            {loading ? <Spinner loading={loading}/> : `${humidity}%`}</p>
            
            <div className="flex justify-center items-center mt-4">
                <img src={weatherIcon || ''} alt="Weather Icon"  />
            </div>
        </div>
    </div>
    </>
  )
}

export default GeneralStats