# Die.py
# Mason Anderson
# Class for six sided die

from random import randrange

class Die:

    def __init__(self, sides):
        self.sides = sides
        self.current = self.sides[0]

    def roll(self):
        result = randrange(len(self.sides))
        self.current = self.sides[result]

        return self.current
                 

def main():

    die = Die([1,2,3,4,5,6])
    result = die.roll()
    print(result)


if __name__ == "__main__":
    main()
