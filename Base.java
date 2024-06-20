package org.example;

public class Base {
    int bulletInMagazine;
    double misfireRatio = 0.3;
    int costPerBullet = 5;
    int damage = 20;
    int immortalCost = 600;
    int bulletDecrase = 1;

    public void setBulletDecrase(int bulletDecrase) {
        this.bulletDecrase = bulletDecrase;
    }

    public int getBulletDecrase() {
        return bulletDecrase;
    }

    //random number for misfire possibility
    public boolean misfire() {
        double randomNumber = Math.random();
        return randomNumber < misfireRatio;
    }

    public void setBullletInMagazine(int bullet) {
        this.bulletInMagazine = bullet;
    }

    public int getBullletInMagazine() {
        return bulletInMagazine;
    }
}