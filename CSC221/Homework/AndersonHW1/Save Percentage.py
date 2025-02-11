# Save Percentage.py
# Mason Anderson
# This page calculates the save percentage of a hockey goalie

import math

def main():
    print("This program calculates the save percentage of a hockey goalie in a game.")
    total_shots = 0
    total_saves = 0
    periods = 3
    for i in range(periods):
        shots = int(input("Enter the number of shots in the period: "))
        saves = int(input("Enter the number of saves in the period: "))
        print("For that period, there were", shots, "shots and", saves, "saves.")
        total_shots = total_shots + shots
        total_saves = total_saves + saves

        save_percentage = (total_saves / total_shots) * 100

    print("For that game, there were", total_shots, "shots and", total_saves, "saves. Making the save percentage", round(save_percentage, 2),"%.")



main()
