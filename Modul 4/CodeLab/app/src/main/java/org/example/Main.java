package org.example;

import kendaraan.kendaraan;
import kendaraan.khusus.pesawat;
import kendaraan.khusus.tank;
import kendaraan.pribadi.mobil;
import kendaraan.pribadi.motor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // menyimpan semua object dalam satu array dengan teknik polymorphism
        kendaraan[] kendaraan = new kendaraan[4];
        kendaraan[0] = new motor() {
            @java.lang.Override
            public void Shoot(java.lang.String vehicle) {

            }

            @Override
            public void shoot(String vehicle) {

            }
        };
        kendaraan[1] = new mobil() {
            @Override
            public void Shoot(String vehicle) {

            }

            @Override
            public void shoot(String vehicle) {

            }
        };
        kendaraan[2] = new tank() {
            @Override
            public void shoot(Object vehicle) {

            }
        };
        kendaraan[3] = new pesawat() {
            @Override
            public void Shoot(String vehicle) {

            }

            @Override
            public void shoot(String vehicle) {

            }
        };

        // input atribut pada setiap object kendaraan
        for (int i = 0; i < kendaraan.length; i++) {
            System.out.printf("Masukkan nama kendaraan ke-%d ", (i + 1));
            kendaraan[i].setName(input.next());
            System.out.printf("Masukkan model kendaraan ke-%d ", (i + 1));
            kendaraan[i].setModel(input.next());
            System.out.printf("Masukkan warna kendaraan ke-%d ", (i + 1));
            kendaraan[i].setWarna(input.next());
            System.out.printf("Masukkan tahun kendaraan ke-%d ", (i + 1));
            kendaraan[i].setTahun(input.nextInt());
            System.out.println();
        }

        // output pada setiap method di kendaraan
        for (kendaraan objectKendaraan : kendaraan) {
            if (objectKendaraan instanceof tank tank){
                tank.Start();
                tank.Brake();
                tank.Stop();
                tank.Shoot("Truk");

            } else if(objectKendaraan instanceof pesawat pesawat){
                pesawat.Start();
                pesawat.fly();
                pesawat.Brake();
                pesawat.Stop();

            } else {
                objectKendaraan.Start();
                objectKendaraan.Brake();
                objectKendaraan.Stop();
            }

            objectKendaraan.getInfo();
            System.out.println();
        }
    }
}
