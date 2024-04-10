# Change Over Time.py
# Mason Anderson
# This page is the content for the first problem of HW1
# 1872 = 180
# 1873 = 191
# 1874 = 193
# 1875 = 168
# 1876 = 192
# 1877 = 184
# 1878 = 261
# I used math.floor for rounding because I thought should be rounded to whole person

import math
def main():
    grand_total = 0
    num_years = 7
    for i in range(num_years):
        input_years = int(input("Enter the year: "))
        input_burial = int(input("Enter the amount of burials for that year: "))
        print("For the year",input_years, "there were", input_burial, "burials.")
        grand_total = grand_total + input_burial

    avg_burial = grand_total / num_years

    print("There were an average of", math.floor(avg_burial), "burials per year.")



main()
