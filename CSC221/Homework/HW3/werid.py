# AndersonHW3.py
# Mason Anderson
# This page is for HW3 (Frequencies and stop words).

def inspectWord(theWord, wList, fList):
    tempWord = theWord.rstrip("\"\'.,`;:-!")
    tempWord = tempWord.lstrip("\"\'.,`;:-!")
    tempWord = tempWord.lower()

    if tempWord in wList:
        tIndex = wList.index(tempWord)
        fList[tIndex]+=1

    else:
        wList.append(tempWord)
        fList.append(1)

def test(phrase):
    words = phrase
    testing = ""
    for word in words:
        first = word[0].upper()
        testing = testing + first

def main():

    wList = []
    fList = []

    print(test("testing test tst"))

    

    

    



if __name__ == "__main__":
    main()
