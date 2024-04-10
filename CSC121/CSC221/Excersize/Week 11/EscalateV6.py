# EscalateV6.py
# Mason Anderson
# escalate v1, enought money

def itemList():
    file = open("items.txt","r")
    items = []
    for line in file:
        split_line = line.rstrip().split(",")
        items.append(split_line)
    return items

def cartTotal(items):
    total = 0
    for i in items:
        quantity = float(i[1])
        price = float(i[2])
        total = total + (quantity*price)
    print("The total for this cart is", total)
    return total

def money():
    total = 0
    dollar = input("Enter a type of bill you have(press enter to quit): $")
    while dollar != "":
        dollar_quantity = float(input("Enter the amount of that bill you have: "))
        total = total + (float(dollar)*dollar_quantity)

        dollar = input("Enter a type of bill you have(press enter to quit): $")
        
    return total

    
def main():
    items = itemList()
    total = cartTotal(items)
    
    money_total = money()
    
    if money_total >= total:
        print("You have enough money to buy that.")
    else:
        print("You don't have enought money to buy that.")



if __name__ == "__main__":
    main()
