# EscalateV1.py
# Mason Anderson
# escalate v1, enought money

def money():
    total = 0
    dollar = int(input("How many $1 bills do you have? "))
    total = total + dollar
    print("You entered", dollar, "$1 bills, the current total is $",total)
    dollar5 = int(input("How many $5 bills do you have? "))
    total = total + (dollar5*5)
    print("You entered", dollar5, "$5 bills, the current total is $",total)
    dollar10 = int(input("How many $10 bills do you have? "))
    total = total + (dollar10*10)
    print("You entered", dollar10, "$10 bills, the current total is $",total)
    dollar20 = int(input("How many $20 bills do you have? "))
    total = total + (dollar20*20)
    print("You entered", dollar20, "$20 bills, the current total is $",total)
    dollar50 = int(input("How many $50 bills do you have? "))
    total = total + (dollar50*50)
    print("You entered", dollar50, "$50 bills, the current total is $",total)
    dollar100 = int(input("How many $100 bills do you have? "))
    total = total + (dollar100*100)
    print("You entered", dollar100, "$100 bills, the total is $", total)
    return total
    
    

def main():
    total = 0

    item_num = int(input("How many items do you want to buy? "))

    for num in range(item_num):
        item_cost = float(input("How much does each item cost? "))
        total = total + item_cost

    money_total = money()
    
    
    if money_total >= total:
        print("You have enough money to buy that.")
    else:
        print("You don't have enought money to buy that.")



if __name__ == "__main__":
    main()
