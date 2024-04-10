# Temperature Converter.py   Mason Anderson
# This page converts fahrenheit to celcius

def main():
    fahrenheit = int(input("Enter degrees in fahrenheit: "))
    celcius = (fahrenheit - 32) * (5 / 9)
    print("The degrees in celcius is", celcius)



main()

