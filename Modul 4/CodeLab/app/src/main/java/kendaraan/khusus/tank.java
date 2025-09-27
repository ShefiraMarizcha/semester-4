package kendaraan.khusus;

import kendaraan.kendaraan;
import kendaraan.util.ShootAble;

public abstract class tank extends kendaraan implements ShootAble {
    @Override
    public void Start() {
        System.out.println("Menyalakan " + this.getName() + " tank");
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan tank " + this.getName());
    }

    @Override
    public void Brake() {
        System.out.println("Tank berhenti");
    }

    @Override
    public void Shoot(String vehicle) {
        System.out.println("Tank menembak");
    }

    @java.lang.Override
    public void shoot(java.lang.String vehicle) {
        
    }
}
