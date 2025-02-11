# TableTennisSimulation.py
# Mason Anderson
# Table tennis simulation for many games

from random import random

def getInputs():
    probA = float(input("What is the prob that Player A wins serve? "))
    probB = float(input("What is the prob that Player B wins serve? "))
    n = int(input("How many games would you like to simulate? "))

    return probA, probB, n

def simNgames(probA, probB, n):
    winsA = 0
    winsB = 0
    for game in range(n):
        scoreA, scoreB = simGame(probA, probB)
        if scoreA > scoreB:
            winsA += 1
        else:
            winsB += 1

    return winsA, winsB

def simGame(probA, probB):
    scoreA = 0
    scoreB = 0
    server = "a"
    while not gameOver(scoreA,scoreB):
        if server == "a":
            won = simServe(probA)
            if won:
                scoreA += 1
            else:
                scoreB += 1
            other = "b"
        elif server == "b":
            won = simServe(probB)
            if won:
                scoreB += 1
            else:
                scoreA += 1
            other = "a"

        server = updateServer(server, other, scoreA, scoreB)

    return scoreA, scoreB
        

def updateServer(server, other, scoreA, scoreB):
    total = scoreA + scoreB
    if total % 2 == 0:
        return other
    else:
        return server

def gameOver(scoreA, scoreB):
    return (scoreA >= 11 or scoreB >= 11) and abs(scoreA - scoreB) >= 2

def simServe(prob_server):
    num = random()
    server_won = prob_server > num
        
    return server_won

def printSummary(winsA, winsB, n):
    print("After simulating", n, "games, player a won",winsA, "times, and player b won",winsB, "times.")
          
    

def main():
    probA, probB, n = getInputs()
    winsA, winsB = simNgames(probA,probB,n)
    printSummary(winsA, winsB, n)



if __name__ == "__main__":
    main()
