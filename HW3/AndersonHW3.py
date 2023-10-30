# AndersonHW3.py
# Mason Anderson
# This page is for HW3 (Frequencies and stop words).

from tkinter.filedialog import askopenfilename, asksaveasfilename

def getText():
    filename = askopenfilename()
    infile = open(filename,"r")
    allText = infile.read()
    return allText


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

def parallelList(wList, fList):
    for i in range(len(wList)):
        print(wList[i], fList[i])

def main():

    wList = []
    fList = []
    
    myText = getText()
    myWords = myText.split(" ")

    for word in myWords:
        inspectWord(word, wList, fList)
                       
    print(myText)
    parallel = parallelList(wList,fList)
    print(parallel)
 
    output = open("ignore.txt", "w")
    
    
    for i in range(len(wList)):
        if len(wList[i]) <= 4 and fList[i] >= 10:
            print(wList[i], file = output)

    output.close()
        
if __name__ == "__main__":
    main()

