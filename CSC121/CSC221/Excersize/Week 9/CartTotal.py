# CartTotal.py
# Mason Anderson
# Find the total of shopping

def main():

    total = 0
    
    shop_item = float(input("Enter the cost of the item: "))
    while shop_item != 0:
        item_quantity = float(input("Enter the quantity of the item purchased: "))
        total = total + (shop_item * item_quantity)

        shop_item = float(input("Enter the cost of the item: "))
        

    print("The total is ${}".format(total))



if __name__ == "__main__":
    main()
