# AndersonHW4.py
# Mason Anderson
# HW4 - AQI Calculator based on different pollutants

def calcAQI(pollutant, concentration):
    
    aqi = [0, 50, 51, 100, 101, 150, 151, 200, 201, 300, 301, 500]
    pm2_5 = [0,12,12.1,35.4,35.5,55.4,55.5,150.4,150.5,250.4,250.5,500.4]
    pm10 =[1,54,55,154,155,254,255,354,355,424,425,604]
    no2 = [0,53,54,100,101,360,361,649,650,1249,1250,2049]
    so2 = [0,35,36,75,76,185,186,304,305,604,605,1004]
    co = [0,4.4,4.5,9.4,9.5,12.4,12.5,15.4,15.5,30.4,30.5,50.4]
    o3 = [0,0.054,0.055,0.070,0.071,0.085,0.086,0.105,0.106,0.200]
    
    if pollutant == "PM2.5":
        if round(concentration,1) <= pm2_5[1]:
            final = (aqi[1]-aqi[0])/(pm2_5[1]-pm2_5[0])*(round(concentration,1)-pm2_5[0])+aqi[0]
        elif round(concentration,1) <= pm2_5[3]:
            final = (aqi[3]-aqi[2])/(pm2_5[3]-pm2_5[2])*(round(concentration,1)-pm2_5[2])+aqi[2]
        elif round(concentration,1) <= pm2_5[5]:
            final = (aqi[5]-aqi[4])/(pm2_5[5]-pm2_5[4])*(round(concentration,1)-pm2_5[4])+aqi[4]
        elif round(concentration,1) <= pm2_5[7]:
            final = (aqi[7]-aqi[6])/(pm2_5[7]-pm2_5[6])*(round(concentration,1)-pm2_5[6])+aqi[6]
        elif round(concentration,1) <= pm2_5[9]:
            final = (aqi[9]-aqi[8])/(pm2_5[9]-pm2_5[8])*(round(concentration,1)-pm2_5[8])+aqi[8]
        elif round(concentration,1) <= pm2_5[11]:
            final = (aqi[11]-aqi[10])/(pm2_5[11]-pm2_5[10])*(round(concentration,1)-pm2_5[10])+aqi[10]
        return int(final)

    if pollutant == "PM10":
        if round(concentration,0) <= pm10[1]:
            final = (aqi[1]-aqi[0])/(pm10[1]-pm10[0])*(round(concentration,0)-pm10[0])+aqi[0]
        elif round(concentration,0) <= pm10[3]:
            final = (aqi[3]-aqi[2])/(pm10[3]-pm10[2])*(round(concentration,0)-pm10[2])+aqi[2]  
        elif round(concentration,0) <= pm10[5]:
            final = (aqi[5]-aqi[4])/(pm10[5]-pm10[4])*(round(concentration,0)-pm10[4])+aqi[4]
        elif round(concentration,0) <= pm10[7]:
            final = (aqi[7]-aqi[6])/(pm10[7]-pm10[6])*(round(concentration,0)-pm10[6])+aqi[6]
        elif round(concentration,0) <= pm10[9]:
            final = (aqi[9]-aqi[8])/(pm10[9]-pm10[8])*(round(concentration,0)-pm10[8])+aqi[8]
        elif round(concentration,0) <= pm10[11]:
            final = (aqi[11]-aqi[10])/(pm10[11]-pm10[10])*(round(concentration,0)-pm10[10])+aqi[10]
        return int(final)

    if pollutant == "NO2":
        if round(concentration,0) <= no2[1]:
            final = (aqi[1]-aqi[0])/(no2[1]-no2[0])*(round(concentration,0)-no2[0])+aqi[0]
        elif round(concentration,0) <= no2[3]:
            final = (aqi[3]-aqi[2])/(no2[3]-no2[2])*(round(concentration,0)-no2[2])+aqi[2]
        elif round(concentration,0) <= no2[5]:
            final = (aqi[5]-aqi[4])/(no2[5]-no2[4])*(round(concentration,0)-no2[4])+aqi[4]
        elif round(concentration,0) <= no2[7]:
            final = (aqi[7]-aqi[6])/(no2[7]-no2[6])*(round(concentration,0)-no2[6])+aqi[6]
        elif round(concentration,0) <= no2[9]:
            final = (aqi[9]-aqi[8])/(no2[9]-no2[8])*(round(concentration,0)-no2[8])+aqi[8]
        elif round(concentration,0) <= no2[11]:
            final = (aqi[11]-aqi[10])/(no2[11]-no2[10])*(round(concentration,0)-no2[10])+aqi[10]
        return int(final)

    if pollutant == "SO2":
        if round(concentration,0) <= so2[1]:
            final = (aqi[1]-aqi[0])/(so2[1]-so2[0])*(round(concentration,0)-so2[0])+aqi[0]
        elif round(concentration,0) <= so2[3]:
            final = (aqi[3]-aqi[2])/(so2[3]-so2[2])*(round(concentration,0)-so2[2])+aqi[2]
        elif round(concentration,0) <= so2[5]:
            final = (aqi[5]-aqi[4])/(so2[5]-so2[4])*(round(concentration,0)-so2[4])+aqi[4]
        elif round(concentration,0) <= so2[7]:
            final = (aqi[7]-aqi[6])/(so2[7]-so2[6])*(round(concentration,0)-so2[6])+aqi[6]
        elif round(concentration,0) <= so2[9]:
            final = (aqi[9]-aqi[8])/(so2[9]-so2[8])*(round(concentration,0)-so2[8])+aqi[8]
        elif round(concentration,0) <= so2[11]:
            final = (aqi[11]-aqi[10])/(so2[11]-so2[10])*(round(concentration,0)-so2[10])+aqi[10]
        return int(final)

    if pollutant == "CO":
        if round(concentration,1) <= co[1]:
            final = (aqi[1]-aqi[0])/(co[1]-co[0])*(round(concentration,1)-co[0])+aqi[0]
        elif round(concentration,1) <= co[3]:
            final = (aqi[3]-aqi[2])/(co[3]-co[2])*(round(concentration,1)-co[2])+aqi[2]
        elif round(concentration,1) <= co[5]:
            final = (aqi[5]-aqi[4])/(co[5]-co[4])*(round(concentration,1)-co[4])+aqi[4]
        elif round(concentration,1) <= co[7]:
            final = (aqi[7]-aqi[6])/(co[7]-co[6])*(round(concentration,1)-co[6])+aqi[6]
        elif round(concentration,1) <= co[9]:
            final = (aqi[9]-aqi[8])/(co[9]-co[8])*(round(concentration,1)-co[8])+aqi[8]
        elif round(concentration,1) <= co[11]:
            final = (aqi[11]-aqi[10])/(co[11]-co[10])*(round(concentration,1)-co[10])+aqi[10]
        return int(final)

    if pollutant == "O3":
        if round(concentration,3) <= o3[1]:
            final = (aqi[1]-aqi[0])/(o3[1]-o3[0])*(round(concentration,3)-o3[0])+aqi[0]
        elif round(concentration,3) <= o3[3]:
            final = (aqi[3]-aqi[2])/(o3[3]-o3[2])*(round(concentration,3)-o3[2])+aqi[2]
        elif round(concentration,3) <= o3[5]:
            final = (aqi[5]-aqi[4])/(o3[5]-o3[4])*(round(concentration,3)-o3[4])+aqi[4]
        elif round(concentration,3) <= o3[7]:
            final = (aqi[7]-aqi[6])/(o3[7]-o3[6])*(round(concentration,3)-o3[6])+aqi[6]
        elif round(concentration,3) <= o3[9]:
            final = (aqi[9]-aqi[8])/(o3[9]-o3[8])*(round(concentration,3)-o3[8])+aqi[8]
        elif round(concentration,3) <= o3[11]:
            final = (aqi[11]-aqi[10])/(o3[11]-o3[10])*(round(concentration,3)-o3[10])+aqi[10]
        return int(final)

def getRating(aqi):
    text = "The overall AQI for this area is:"
    if aqi <= 50:
        print(text, aqi, "- Good")
    elif aqi <=100:
        print(text, aqi, "- Moderate")
    elif aqi <=150:
        print(text, aqi, "- Unhealthy for sensitive groups")
    elif aqi <=200:
        print(text, aqi, "- Unhealthy")
    elif aqi <=300:
        print(text, aqi, "- Very Unhealthy")
    elif aqi <=500:
        print(text, aqi, "- Hazardous")
    
    
        
def main():

    print("Welcome to the AQI calculator.")

    more_data = "Yes"

    aqi_list = []
    
    while more_data[0] == "Y":
        pollutant = input("What is the pollutant you would like to enter? ")

        if pollutant == "PM2.5":
            result = float(input("What is the 24 hr average concentration of PM2.5 in ug/m3? "))
            unit = "ug/m3"
        elif pollutant == "PM10":
            result = float(input("What is the 24 hr average concentration of PM10 in ug/m3? "))
            unit = "ug/m3"
        elif pollutant == "NO2":
            result = float(input("What is the 1 hr average concentration of NO2 in ppb? "))
            unit = "ppb"
        elif pollutant == "SO2":
            result = float(input("What is the 1 hr average concentration of SO2 in ppb? "))
            unit = "ppb"
        elif pollutant == "CO":
            result = float(input("What is the 8 hr average concentration of CO in ppm? "))
            unit = "ppm"
        elif pollutant == "O3":
            result = float(input("What is the 8 hr average concentration of O3 in ppb? "))
            unit = "ppb"
          
        aqi_result = calcAQI(pollutant, result)
        
        
        print("The AQI for", pollutant, "at", result, unit, "is", aqi_result)
        
        more_data = input("Do you have another sensor to enter data for (Y or YES to continue)? ")

        aqi_list.append(aqi_result)
        aqi_list.sort()
        aqi_result = aqi_list[-1]
    
    getRating(aqi_result)

if __name__ == "__main__":
    main()
