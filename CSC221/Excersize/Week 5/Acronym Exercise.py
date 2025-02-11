# Acronym Exercise.py
# Mason Anderson
# builds acronyms

def acronym(phrase):

    words = phrase.split()
    acc_acronym = ""
    for word in words:
        first = word[0].upper()
        acc_acronym = acc_acronym + first
    
    return acc_acronym

def main():

    print(acronym("As soon as possible"))



main()
