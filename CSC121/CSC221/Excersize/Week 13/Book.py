# Book.py
# Mason Anderson
# This makes a book with classes

class Book:

    def __init__(self, title, author, pages):
        self.title = title
        self.author = author
        self.pages = pages
        self.read = False
        self.current_page = 1

    def turnPage(self):
        if self.current_page == self.pages:
            self.read = True
        else:
            self.current_page += 1

    def markAsRead(self):
        self.read = True
        self.current_page = self.pages

    def getCurrentPage(self):
        return self.current_page

    def isRead(self):
        return self.read

    def __str__(self):
        return "{} by {}".format(self.title,self.author)

def main():

    books = [Book("The Life of Pi","Yann Martel",352), Book("Design for a Better World","Some Guy",500)]
    for book in books:
        print(book)
        while True:
            print(book.getCurrentPage())
            book.turnPage()
            if book.isRead() == True:
                break


if __name__ == "__main__":
    main()
