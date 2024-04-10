# Square List.py
# Mason Anderson
# Square list

def squareEach(nums):
    for i in range(len(nums)):
        nums[i] = nums[i] * nums[i]

def main():

    nums = [6,7,10,2,4]
    squareEach(nums)
    print(nums)


main()
