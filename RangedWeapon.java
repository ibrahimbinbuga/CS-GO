package org.example;

public class RangedWeapon extends Weapon {
    int effectiveRange;
    double misfireRatio;
    int cost;

    public void setMisfireRatio(double misfireRatio) {
        this.misfireRatio = misfireRatio;
    }

    public RangedWeapon(String name, int cost, int damage, int bulletInMagazine) {
        super(name, cost, damage);
        this.bulletInMagazine = bulletInMagazine;
        this.cost = cost;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setBulletDecrase(int bulletDecrase) {
        this.bulletDecrase = bulletDecrase;
    }

    @Override
    public int getBulletDecrase() {
        return bulletDecrase;
    }

    @Override
    public void setBullletInMagazine(int bullet) {
        this.bulletInMagazine = bullet;
    }

    @Override
    public int getBullletInMagazine() {
        return bulletInMagazine;
    }
}
