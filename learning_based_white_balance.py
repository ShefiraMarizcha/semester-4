import cv2
import numpy as np
from sklearn.linear_model import LinearRegression

def learning_based_white_balance(image):
   
    img_float = image.astype(np.float32) / 255.0
    h, w, c = img_float.shape
    pixels = img_float.reshape((-1, 3))
    
    mean_rgb = np.mean(pixels, axis=0)
    target = np.mean(mean_rgb) * np.ones_like(mean_rgb)

   
    model = LinearRegression()
    model.fit(pixels, pixels * (target / mean_rgb))

    
    corrected_pixels = model.predict(pixels)
    corrected_pixels = np.clip(corrected_pixels, 0, 1)
    corrected_img = corrected_pixels.reshape((h, w, 3)) * 255
    return corrected_img.astype(np.uint8)


image = cv2.imread('Gambar2_Grafkom.png')  
corrected = learning_based_white_balance(image)


cv2.imshow('Original', image)
cv2.imshow('Learning-based Corrected', corrected)
cv2.waitKey(0)
cv2.destroyAllWindows()
