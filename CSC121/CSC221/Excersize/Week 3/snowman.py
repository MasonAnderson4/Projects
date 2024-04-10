# Snowman.py
# Mason Anderson
# This page draws a snowman

from graphic import *

def main():

    win = GraphWin("Snowman", 500, 750)
   

    circle1 = Circle(Point(250,500),100)
    circle1.setFill("white")
    circle1.draw(win)

    circle2 = Circle(Point(250,350),85)
    circle2.setFill("white")

    circle2.draw(win)

    circle3 = Circle(Point(250,225),70)
    circle3.setFill("white")
    circle3.draw(win)

    circle4 = Circle(Point(250,325),15)
    circle4.setFill("black")
    circle4.draw(win)

    circle5 = Circle(Point(250,365),15)
    circle5.setFill("black")
    circle5.draw(win)

    circle6 = Circle(Point(250,405),15)
    circle6.setFill("black")
    circle6.draw(win)

    circle7 = Circle(Point(225,210),10)
    circle7.setFill("black")
    circle7.draw(win)

    circle8 = Circle(Point(275,210),10)
    circle8.setFill("black")
    circle8.draw(win)

    nose = Line(Point(250,235), Point(300, 250))
    nose.draw(win)
    nose.setOutline("orange")

    


main()
