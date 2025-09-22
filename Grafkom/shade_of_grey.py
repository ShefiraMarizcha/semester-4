import cv2
import numpy as np
def shade_of_grey(image, power=6):
    img = image.astype(np.float32)
    img_power = np.power(img, power)
    
    mean_b = np.mean(img_power[:, :, 0])
    mean_g = np.mean(img_power[:, :, 1])
    mean_r = np.mean(img_power[:, :, 2])
   
    norm = np.sqrt(mean_r**2 + mean_g**2 + mean_b**2)
   
    scale_r = norm / mean_r
    scale_g = norm / mean_g
    scale_b = norm / mean_b
    
    img[:, :, 0] *= scale_b
    img[:, :, 1] *= scale_g
    img[:, :, 2] *= scale_r
    
    img = np.clip(img, 0, 255).astype(np.uint8)
    return img

image = cv2.imread('Gambar3_Grafkom.png')  
corrected_image = shade_of_grey(image, power=6)

cv2.imshow('Original', image)
cv2.imshow('Shade of Grey Corrected', corrected_image)
cv2.waitKey(0)
cv2.destroyAllWindows()
