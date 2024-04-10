# House.py
# Mason Anderson
# This page has user click to draw a house

from graphic import *

def main():

    win = GraphWin("House", 500, 500)
    win.setBackground("white")

    instructions = Text(Point(250,100), "Click 5 times to draw a house.")
    instructions.draw(win)

    point1 = win.getMouse()
    point = point1
    point.draw(win)

    point2 = win.getMouse()
    line1 = Line(point1, point2)
    line1.draw(win)

    point3 = win.getMouse()
    line2 = Line(point2, point3)
    line2.draw(win)

    point4 = win.getMouse()
    line3 = Line(point3, point4)
    line3.draw(win)

    point5 = win.getMouse()
    line4 = Line(point4, point5)
    line4.draw(win)

    point6 = win.getMouse()
    line5 = Line(point5, point6)
    line5.draw(win)


main()
