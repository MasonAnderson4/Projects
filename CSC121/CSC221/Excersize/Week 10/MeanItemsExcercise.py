# MeanItemsExcercise.py
# Mason Anderson
#

def main():

    item_list = []
    

    while True:
        item = input("Enter a item (press enter to quit): ")
        if item == "": break
        
        item = int(item)
        if item_list.count(item) == 0:
            item_list.append(item)
       
        
        
            

    print(item_list)

    average = sum(item_list) / len(item_list)
    print(average)



if __name__ == "__main__":
    main()
