# Olympics.py
# Mason Anderson
# This page has user click and draws olympics symbol

from graphic import *

def main():

    win = GraphWin("Olympics", 500, 500)
    win.setBackground("white")

    instructions = Text(Point(250,100), "Click to reveal a circle of the Olympics logo.")
    instructions.draw(win)
    
    click1 = win.getMouse()
    circle1 = Circle(Point(150, 200), 50)
    circle1.draw(win)
    circle1.setWidth(5)
    circle1.setOutline("blue")

    click2 = win.getMouse()
    circle2 = Circle(Point(265, 200), 50)
    circle2.draw(win)
    circle2.setWidth(5)
    circle2.setOutline("black")

    click3 = win.getMouse()
    circle3 = Circle(Point(380, 200), 50)
    circle3.draw(win)
    circle3.setWidth(5)
    circle3.setOutline("red")

    click4 = win.getMouse()
    circle4 = Circle(Point(207.5, 250), 50)
    circle4.draw(win)
    circle4.setWidth(5)
    circle4.setOutline("yellow")

    click5 = win.getMouse()
    circle5 = Circle(Point(322.5, 250), 50)
    circle5.draw(win)
    circle5.setWidth(5)
    circle5.setOutline("green")


main()
