# EscalateV4.py
# Mason Anderson
# reading list of items

def itemList():

    file = open("items.txt","r")

    items = []

    for line in file:
        split_line = line.rstrip().split(",")
        items.append(split_line)
    return items

def main():

    item_list = itemList()
    print(item_list)


if __name__ == "__main__":
    main()
