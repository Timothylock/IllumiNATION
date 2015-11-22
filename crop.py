import cv2

def crop(filename, n, m, lengthx, lengthy):
# w and y are the delta-x and delta-y of the images, respectively
# n and m are the number of lines on the x and y respectively - n x m	
#note that length x and length are just the overall length of the image
#note that length x/n = stepsize x
	stepsizex = lengthx/n 
	stepsizey = lengthy/m
	img = cv2.imread(filename)
   	# this is the filename of big image file, not yet divided
   	for i in range (0,lengthx):
   		for j in range (0,lengthy):

			crop_img = img[stepsizey*j: stepsizey+stepsizey*j, stepsizex*i: stepsizex+stepsizex*i]
			cv2.imwrite(str(i) + str(j) + ".jpg", crop_img)
			listt[i][j] = str(i) + str(j) + ".jpg"

	return listt
    

    #cv2.imshow("cropped", crop_img)
    #.waitkey(0)
if __name__  == "__main__":
	listnew = crop ("Aerial03.jpg", 5, 5, 1000, 300)
	