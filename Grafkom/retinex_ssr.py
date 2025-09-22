import cv2
import numpy as np

def single_scale_retinex(img, sigma):
    img = img.astype(np.float32) + 1.0  # Hindari log(0)
    blurred = cv2.GaussianBlur(img, (0, 0), sigma)
    retinex = np.log10(img) - np.log10(blurred)
    return retinex

def SSR_retinex(img, sigma=30):
    # Pisah channel BGR
    b, g, r = cv2.split(img)
    r_retinex = single_scale_retinex(r, sigma)
    g_retinex = single_scale_retinex(g, sigma)
    b_retinex = single_scale_retinex(b, sigma)

    # Gabung hasilnya
    retinex = cv2.merge((b_retinex, g_retinex, r_retinex))

    # Normalisasi agar bisa ditampilkan (0–255)
    retinex = cv2.normalize(retinex, None, 0, 255, cv2.NORM_MINMAX)
    return retinex.astype(np.uint8)

# Baca gambar dari file
image = cv2.imread('Gambar2_Grafkom.png')  # Pastikan nama file benar dan berada di folder yang sama
retinex_corrected = SSR_retinex(image, sigma=30)

# Tampilkan hasil
cv2.imshow('Original', image)
cv2.imshow('Retinex Corrected', retinex_corrected)
cv2.waitKey(0)
cv2.destroyAllWindows()
