package org.example;

public class MachineGun extends Firearm {
    int bulletInMagazine = 100;
    double misfireRatioOfMachineGun = 0.1;
    boolean sweep;
    int bulletDecrase;
    int bulletDecraseWithSweep = 10;
    int bulletDecraseWithoutSweep = 1;

    public MachineGun(String name, int cost, int damage, int bulletInMagazine) {
        super(name, cost, damage, bulletInMagazine);
    }

    public void setSweep(boolean sweep) {
        this.sweep = sweep;
    }

    public boolean isSweep() {
        return sweep;
    }

    public void setBulletDecrase(int bulletDecrase) {
        this.bulletDecrase = bulletDecrase;
    }

    public int getBulletDecrase() {
        return bulletDecrase;
    }
}
