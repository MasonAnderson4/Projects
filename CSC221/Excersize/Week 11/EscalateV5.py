# EscalateV5.py
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

def main():
    items = itemList()
    print(items)
    cartTotal(items)

    #money = float(input("How much money do you have? "))
    #if money >= total:
        #print("You have enough money to buy that.")
    #else:
        #print("You don't have enought money to buy that.")



if __name__ == "__main__":
    main()
