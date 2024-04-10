# Bills and Wallet.py
# Mason Anderson
# Bills and wallets class

class Bills:

    def __init__(self,value,quantity):
        self.value = value
        self.quantity = quantity

    def getValue(self):
        return self.value

    def getQuantity(self):
        return self.quantity

    def getTotal(self):
        return self.value * self.quantity

    def updateQuantity(self,quantity):
        self.quantity = quantity

class Wallet:

    def __init__(self):
        self.bills = []

    def getBills(self):
        return self.bills

    def addBill(self,bill):
        self.bills.append(bill)

    def getTotal(self):
        total = 0
        for bill in self.bills:
            total += bill.getTotal()
        return total



def main():

    wallet = Wallet()
    while True:
        value = input("What kind of bill do you have (press enter to quit)? ")
        if value == "":
            break
        quantity = int(input("How many of this bill do you have? "))

        bills = Bills(int(value),quantity)
        wallet.addBill(bills)
    print(wallet.getTotal())
        


if __name__ == "__main__":
    main()
