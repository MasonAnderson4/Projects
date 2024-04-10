# AndersonHW7.py
# Mason Anderson
# HW7 - This code simulates a game of chicago dice with the users choice of players and rounds 

from random import randrange

class Die:
    "This class models an n-sided die"

    def __init__(self, sides):
        "A Die needs a number of sides"
        self.sides = sides
        self.current = 1

    def roll(self):
        "Rolls the die and returns the result"
        result = randrange(1, self.sides + 1)
        self.current = result

        return self.current

    def getCurrent(self):
        "Returns the current side up"
        return self.current

class Player:
    "This class models a player for a game"

    def __init__(self, name):
        "A Player needs a name to be created"
        self.name = name
        self.score = 0

    def getName(self):
        "Returns the name of the player"
        return self.name

    def getScore(self):
        "Returns the current score of the player"
        return self.score

    def addPoints(self, points):
        "Adds points to the player's score"
        self.score += points

    def removePoints(self, points):
        "Remove points from the player's score"
        self.score -= points

    def __str__(self):
        "The string format for a player consists of the player's name and score"
        return "{} with {} points".format(self.name, self.score)

def simulateGame():

    players = []
    die = Die(6)
    highest_score = 0
    winners = []

    rounds = int(input("How many rounds would you like to play? "))
    player_num = int(input("How many players are playing(2+)? "))

    for i in range(1,player_num+1):
        player_name = input("Enter Player {}'s name: ".format(i))
        player = Player(player_name)
        players.append(player)
    
    
    for i in range(1,rounds+1):
        names_scores = {}
        
        print("Round {} (target: {})".format(i, i+1))

        for player in players:
            die1 = die.roll()
            die2 = die.roll()
            total = die1+die2
    
            if total == i+1:
                player.addPoints(total)     

            print("{} rolled a {} (current score: {})".format(player.getName(),total,player.getScore()))
            
            names_scores[player.getName()] = player.getScore()

            if player.getScore() > highest_score:
                winners = [player.getName()]
                highest_score = player.getScore()
            elif player.getScore() == highest_score and player.getName() not in winners:
                winners.append(player.getName())

            
                    
    if len(winners) > 1:
        print("There was a tie! \nWinners:")
        for winner in range(len(winners)):
            print("{} with {} points".format(winners[winner],highest_score)) 
    else:
        print("Winner: {} with {} points".format(winners[0],highest_score))

        

def main():

    simulateGame()

if __name__ == "__main__":
    main()
