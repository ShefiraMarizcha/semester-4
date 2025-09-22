import cv2
import numpy as np

def white_patch_assumption(image):
    img_float = image.astype(np.float32)
    b, g, r = cv2.split(img_float)
    max_r, max_g, max_b = np.max(r), np.max(g), np.max(b)
    r, g, b = r * 255.0 / max_r, g * 255.0 / max_g, b * 255.0 / max_b
    balanced = cv2.merge((b, g, r))
    return np.clip(balanced, 0, 255).astype(np.uint8)

# Baca dan proses gambar
image = cv2.imread('Gambar1_grafkom.png')  # Ganti sesuai nama file gambar
corrected = white_patch_assumption(image)

cv2.imshow('Original', image)
cv2.imshow('White Patch Corrected', corrected)
cv2.waitKey(0)
cv2.destroyAllWindows()
