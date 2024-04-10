# EscalateV1.py
# Mason Anderson
# escalate v1, enought money

def main():
    total = 0

    item_num = int(input("How many items do you want to buy? "))

    for num in range(item_num):
        item_cost = float(input("How much does each item cost? "))
        total = total + item_cost

    money = float(input("How much money do you have? "))
    if money >= total:
        print("You have enough money to buy that.")
    else:
        print("You don't have enought money to buy that.")



if __name__ == "__main__":
    main()
