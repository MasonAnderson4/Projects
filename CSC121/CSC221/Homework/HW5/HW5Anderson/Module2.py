# Module2.py
# Mason Anderson
# This module reads the averages and compares to mystery images to find artist

from graphics import *

def mysteryImages():
    mystery_images = ["mystery1.gif", "mystery2.gif", "mystery3.gif"]
    return mystery_images

def mysteryPixels():
    win = GraphWin("Image Display",400,500)
    mystery_images = mysteryImages()

    red_avg_list = []
    green_avg_list = []
    blue_avg_list = []

    for image in mystery_images:
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

def comparingImages(red_avg_list, green_avg_list, blue_avg_list):
    file = open("outputfile.txt", "r")
    distances = []
    paintings = []
    
    for line in file:
        rgb = line.split()
        painting = rgb[0]
        red = rgb[1]
        green = rgb[2]
        blue = rgb[3]
        paintings.append(painting)

        for i in range(len(red_avg_list)):
            red_avg = float(red_avg_list[i])
            red_distance = (abs(float(red) - red_avg)) / red_avg
        for j in range(len(green_avg_list)):
            green_avg = float(green_avg_list[j])
            green_distance = (abs(float(green) - green_avg)) / green_avg
        for k in range(len(blue_avg_list)):
            blue_avg = float(blue_avg_list[k])
            blue_distance = (abs(float(blue) - blue_avg)) / blue_avg
            distance = red_distance+green_distance+blue_distance
            distances.append(distance)

    mystery1 = {distances[0]:paintings[0],distances[3]:paintings[1],
                distances[6]:paintings[2],distances[9]:paintings[3],
                distances[12]:paintings[4],distances[15]:paintings[5]}
    
    
    mystery2 = {distances[1]:paintings[0],distances[4]:paintings[1],
                distances[7]:paintings[2],distances[10]:paintings[3],
                distances[13]:paintings[4],distances[16]:paintings[5]}
    

    mystery3 = {distances[2]:paintings[0],distances[5]:paintings[1]
                ,distances[8]:paintings[2],distances[11]:paintings[3],
                distances[14]:paintings[4],distances[17]:paintings[5]}
    
    mystery1_sorted = sorted(mystery1.items())
    mystery2_sorted = sorted(mystery2.items())
    mystery3_sorted = sorted(mystery3.items())

    print("Mystery 1:", mystery1_sorted[0][1],"with the lowest sum of distances of",mystery1_sorted[0][0])
    print("Mystery 2:", mystery2_sorted[0][1],"with the lowest sum of distances of",mystery2_sorted[0][0])
    print("Mystery 3:", mystery3_sorted[0][1],"with the lowest sum of distances of",mystery3_sorted[0][0])

  
    file.close()
    

def main():
    red_avg_list, green_avg_list, blue_avg_list = mysteryPixels()
    distances = comparingImages(red_avg_list, green_avg_list, blue_avg_list)
   
if __name__ == "__main__":
    main()
