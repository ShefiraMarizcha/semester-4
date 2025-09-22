package org.example;

public class RataArray {

    int[] arrNilai = new int[4];

    public RataArray() {
        arrNilai[0] = 5;
        arrNilai[1] = 11;
        arrNilai[2] = 17;
        arrNilai[3] = 21;
    }

    public void hitungArray() {
        int total = 0;
        for (int i = 0; i < arrNilai.length; i++) {
            total += arrNilai[i];
        }
        double rataRata = (double) total / arrNilai.length;

        System.out.println("Rata-rata nilai dalam array adalah: " + rataRata);
    }

    public static void main(String[] args) {

        RataArray rataArray = new RataArray();
        rataArray.hitungArray();
    }
}
