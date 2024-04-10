# credits.py
# Mason Anderson
# Takes credits to determine which grade you are in

def grade(credit):
    if credit < 24:
        return "freshman"
    elif credit <= 59.6:
        return "sophomore"
    elif credit <= 95.5:
        return "junior"
    else:
        return "senior"
    

def main():
    credit = float(input("Enter the number of credits you have: "))
    print(grade(credit))



if __name__ == "__main__":
    main()
