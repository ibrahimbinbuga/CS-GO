package org.example;

public class Pistol extends Firearm {
    int damage = 20;

    public Pistol(String name, int cost, int damage, int bulletInMagazine) {
        super(name, cost, damage, bulletInMagazine);
    }
}
