package org.example;

public class Firearm extends RangedWeapon {
    int cost;
    String name;
    double misfireRatio = 0.3;
    int bulletInMagazine = 20;
    int damage;
    int bulletDecrase = 1;

    public Firearm(String name, int cost, int damage, int bulletInMagazine) {
        super(name, cost, damage, bulletInMagazine);
    }

    public int getBulletDecrase() {
        return bulletDecrase;
    }

}
