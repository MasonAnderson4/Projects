# AndersonChangeViz.py
# Mason Anderson
# This page is for HW2 and shows a cemetery and burial density in a 7 year period.
# A001-A100 = 79
# A101-A250 = 69
# A251-A399 = 51
# A400-A499 = 39
# A500-A599 = 4
# A600-A750 = 514
# A751-A899 = 295
# A900-A1010 = 71
# B001-B300 = 38
# B301-B999 = 201


from graphics import *


def main():

    a001 = 79
    a101 = 69
    a251 = 51
    a400 = 39
    a500 = 4
    a600 = 514
    a751 = 295
    a900 = 71
    b001 = 38
    b301 = 201

    proportion = 0.496

    
    win = GraphWin("Cemetery",750,500)
    win.setBackground("white")
    win.setCoords(0,0,150,100)

    whole = Rectangle(Point(1,1),Point(149,99))
    whole.draw(win)

    b001rec = Rectangle(Point(5, 95), Point(60, 55))
    b001rec.setFill(color_rgb(255,255,255))
    b001rec.draw(win)
    label1 = Text(Point(32.5,75), "B001-B300")
    label1.draw(win)

    b301rec = b001rec.clone()
    b301rec.move(0,-50)
    b301rec.setFill(color_rgb(255,255,255))
    b301rec.draw(win)
    label2 = Text(Point(32.5,25), "B301-B999")
    label2.draw(win)

    a751tri = Polygon(Point(65,55),Point(95,55),Point(65,95))
    a751tri.setFill(color_rgb(255,255,255))
    a751tri.draw(win)
    label3 = Text(Point(75, 70), "A751-A899")
    label3.draw(win)

    a900tri = Polygon(Point(100,55),Point(70,95),Point(100,95))
    a900tri.setFill(color_rgb(255,255,255))
    a900tri.draw(win)
    label4 = Text(Point(90,80), "A900-A1010")
    label4.draw(win)

    a001tri = Polygon(Point(110,55),Point(110,95),Point(140,95))
    a001tri.setFill(color_rgb(255,255,255))
    a001tri.draw(win)
    label5 = Text(Point(120,80), "A001-A100")
    label5.draw(win)

    a101tri = Polygon(Point(145,55),Point(145,95),Point(115,55))
    a101tri.setFill(color_rgb(255,255,255))
    a101tri.draw(win)
    label6 = Text(Point(135, 70), "A101-A250")
    label6.draw(win)

    a600tri = Polygon(Point(65, 45),Point(65,5),Point(95,45))
    a600tri.setFill(color_rgb(255,255,255))
    a600tri.draw(win)
    label7 = Text(Point(75,30), "A600-A750")
    label7.draw(win)

    a500tri = Polygon(Point(100, 5),Point(70,5),Point(100,45))
    a500tri.setFill(color_rgb(255,255,255))
    a500tri.draw(win)
    label8 = Text(Point(90,20), "A500-A599")
    label8.draw(win)

    a400tri = Polygon(Point(110, 5),Point(140,5),Point(110,45))
    a400tri.setFill(color_rgb(255,255,255))
    a400tri.draw(win)
    label9 = Text(Point(120,20), "A400-A499")
    label9.draw(win)

    a251tri = Polygon(Point(145, 5),Point(145,45),Point(115,45))
    a251tri.setFill(color_rgb(255,255,255))
    a251tri.draw(win)
    label10 = Text(Point(135,30), "A251-A399")
    label10.draw(win)

    oval = Oval(Point(97.5,46),Point(112.5,54))
    oval.setFill(color_rgb(255,255,255))
    oval.draw(win)

    
    
    
    change = win.getMouse()
    change = label1.undraw()
    change = label2.undraw()
    change = label3.undraw()
    change = label4.undraw()
    change = label5.undraw()
    change = label6.undraw()
    change = label7.undraw()
    change = label8.undraw()
    change = label9.undraw()
    change = label10.undraw()
    change = b001rec.setFill(color_rgb(255 - round(proportion*b001),0,255 - round(proportion*b001)))
    change = b301rec.setFill(color_rgb(255 - round(proportion*b301),0,255 - round(proportion*b301)))
    change = a751tri.setFill(color_rgb(255 - round(proportion*a751),0,255 - round(proportion*a751)))
    change = a900tri.setFill(color_rgb(255 - round(proportion*a900),0,255 - round(proportion*a900))) 
    change = a001tri.setFill(color_rgb(255 - round(proportion*a001),0,255 - round(proportion*a001)))
    change = a101tri.setFill(color_rgb(255 - round(proportion*a101),0,255 - round(proportion*a101)))
    change = a600tri.setFill(color_rgb(255 - round(proportion*a600),0,255 - round(proportion*a600)))
    change = a500tri.setFill(color_rgb(255 - round(proportion*a500),0,255 - round(proportion*a500)))
    change = a400tri.setFill(color_rgb(255 - round(proportion*a400),0,255 - round(proportion*a400)))
    change = a251tri.setFill(color_rgb(255 - round(proportion*a251),0,255 - round(proportion*a251)))
    label11 = Text(Point(75,2),"1878").draw(win)
    
main()

