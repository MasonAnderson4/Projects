# TableTennis.py
# Mason Anderson
# Table tennis scoreboard required excercise

def main():

    player1 = 0
    player2 = 0
    difference = player1 - player2

    print("Here is a scoreboard to keep track of your table tennis game.")

    while player1 != 11 and player2 != 11:
        point = int(input("Who scored the point (1 or 2): "))
        if point == 1:
            player1 = player1 + 1
        elif point == 2:
            player2 = player2 + 1

        print("Player 1:", player1)
        print("Player 2:", player2)
    
        

if __name__ == "__main__":
    main()
