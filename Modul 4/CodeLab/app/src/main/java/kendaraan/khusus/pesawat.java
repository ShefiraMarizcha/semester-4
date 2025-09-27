package kendaraan.khusus;

import kendaraan.kendaraan;
import kendaraan.util.flyble;

public abstract class pesawat extends kendaraan implements flyble {

    @Override
    public void Start() {
        System.out.println("Menyalakan pesawat " + this.getName());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getName());
    }

    @Override
    public void Brake() {
        System.out.println("Pesawat " + this.getName() + " melakukan pengereman");
    }

    @Override
    public void fly() {
        System.out.println("Pesawat " + this.getName() + " lepas landas");
    }
}
