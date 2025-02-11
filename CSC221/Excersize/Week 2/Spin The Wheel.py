# Spin The Wheel.py
# Mason Anderson
# This program spins a wheel and gives money

def main():
    credit = int(input("Enter the number of credits you have: "))

    total = 0

    for i in range(credit):
        spin = int(input("Enter the amount of money you received: "))

        total = total + spin

    print("The total amount of money received is", total)


main()
