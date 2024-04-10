# Investment.py
# Mason Anderson
# This program shows investment and returns

def main():
    years = int(input("Investing $6000 a year, enter the amount of years you wish to invest with a 7% annual return rate: "))

    total = 0
    for i in range(years):
        
        
        total = 6000 + (total * 1.07)

    print("After", years, "years, your total is", round(total,2))



main()
