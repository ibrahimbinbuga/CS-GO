package org.example;

public class Sniper extends Firearm {
    int bulletInMagazine = 10;
    boolean scope;
    double misfireWithScope = 0.01;
    double misfireWithoutScope = 0.45;
    double fieldViewDistance;
    int damage;

    public Sniper(String name, int cost, int damage, int bulletInMagazine) {
        super(name, cost, damage, bulletInMagazine);
    }

    public void setScope(boolean scope) {
        this.scope = scope;
    }

    public boolean isScope() {
        return scope;
    }
}