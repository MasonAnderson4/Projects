# Module1.py
# Mason Anderson
# HW5 first file - average rgb pixels of each painting

from graphics import *

def images():
    images = ["DaVinci1.gif", "DaVinci2.gif", "DaVinci3.gif",
              "Rembrandt1.gif", "Rembrandt2.gif", "Rembrandt3.gif"]
    return images

def averagePixels(images):
    win = GraphWin("Image Display",400,500)
    images = images()

    red_avg_list = []
    green_avg_list = []
    blue_avg_list = []

    
   
    for image in images:
        display_image = Image(Point(200,250),image)
        display_image.draw(win)

        red_sum = 0
        green_sum = 0
        blue_sum = 0

        for y in range(display_image.getHeight()):
            for x in range(display_image.getWidth()):
                red, green, blue = display_image.getPixel(x,y)
                red_sum += red
                green_sum += green
                blue_sum += blue

        num_pixels = display_image.getHeight() * display_image.getWidth()
        red_avg = red_sum / num_pixels
        red_avg_list.append(red_avg)
        green_avg = green_sum / num_pixels
        green_avg_list.append(green_avg)
        blue_avg = blue_sum / num_pixels
        blue_avg_list.append(blue_avg)
        
    win.close()
    return red_avg_list, green_avg_list, blue_avg_list


def main():
    image_list = images()
    pixels = averagePixels(images)
    output = open("outputfile.txt", "w")

    for image in range(len(image_list)):
        print(image_list[image], pixels[0][image], pixels[1][image], pixels[2][image], file = output)
        
if __name__ == "__main__":
    main()
