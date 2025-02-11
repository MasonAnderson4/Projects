# EscalateV1.py
# Mason Anderson
# escalate v1, enought money

def money():
    dollar = int(input("How many $1 bills do you have? "))
    dollar5 = int(input("How many $5 bills do you have? "))
    dollar10 = int(input("How many $10 bills do you have? "))
    dollar20 = int(input("How many $20 bills do you have? "))
    dollar50 = int(input("How many $50 bills do you have? "))
    dollar100 = int(input("How many $100 bills do you have? "))
    total_money = (dollar)+(dollar5*5)+(dollar10*10)+(dollar20*20)+(dollar50*50)+(dollar100*100)
    return total_money
    

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
