# AndersonHW4.py
# Mason Anderson
# HW6 - HW4 modification function to make code more efficient

def calcFinal(pollutant,concentration):
    aqi = [0, 50, 51, 100, 101, 150, 151, 200, 201, 300, 301, 500]

    for i in range(0,11,2):
        if round(concentration,1) <= pollutant[i+1]:
            final = (aqi[i+1]-aqi[i])/(pollutant[i+1]-pollutant[i])*(round(concentration,1)-pollutant[i])+aqi[i]
            return int(final)

def calcAQI(pollutant, concentration):
    pollutants = ["PM2.5","PM10","NO2","SO2","CO","O3"]
    pollutants_list = [[0,12,12.1,35.4,35.5,55.4,55.5,150.4,150.5,250.4,250.5,500.4],[1,54,55,154,155,254,255,354,355,424,425,604],
                       [0,53,54,100,101,360,361,649,650,1249,1250,2049],[0,35,36,75,76,185,186,304,305,604,605,1004],
                       [0,4.4,4.5,9.4,9.5,12.4,12.5,15.4,15.5,30.4,30.5,50.4],[0,0.054,0.055,0.070,0.071,0.085,0.086,0.105,0.106,0.200]]

    for i in range(len(pollutants)):
        if pollutant == pollutants[i]:
            final = calcFinal(pollutants_list[i],concentration)
            return final

def getRating(aqi):
    aqi_value = [50,100,150,200,300,500]
    aqi_description = ["- Good","- Moderate","- Unhealthy for sensitive groups","- Unhealthy","- Very Unhealthy",
                       "- Hazardous"]
    for i in range(len(aqi_value)): 
        if aqi <= aqi_value[i]:
            return "The overall AQI for this area is: {} {}".format(aqi, aqi_description[i])
        
def main():

    print("Welcome to the AQI calculator.")

    more_data = "Yes"

    aqi_list = []
    pollutants = ["PM2.5","PM10","NO2","SO2","CO","O3"]
    time = [24,24,1,1,8,8]
    units = ["ug/m3","ug/m3","ppb","ppb","ppm","ppb"]
    
    while more_data[0] == "Y":
        pollutant = input("What is the pollutant you would like to enter? ")

        for i in range(len(pollutants)):
            if pollutant == pollutants[i]:
                test = "What is the {} hr average concetration of {} in {}? ".format(time[i],pollutants[i],units[i])
                result = float(input(test))
                unit = units[i]

        aqi_result = calcAQI(pollutant, result)
        
        
        print("The AQI for", pollutant, "at", result, unit, "is", aqi_result)
        
        more_data = input("Do you have another sensor to enter data for (Y or YES to continue)? ")

        aqi_list.append(aqi_result)
        aqi_list.sort()
        aqi_result = aqi_list[-1]
    
    print(getRating(aqi_result))

if __name__ == "__main__":
    main()
