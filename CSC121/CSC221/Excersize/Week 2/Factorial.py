# Factorial.py
# Mason Anderson
# This page calculates a factorial for a number

def main():
    n = int(input("Enter a whole number: "))
    factorial = 1
    
    for i in range(n, 0, -1):
        factorial = factorial * i
        
    
    print("The factorial of", n, "is", factorial)
    

main()
