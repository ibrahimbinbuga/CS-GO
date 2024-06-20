package org.example;

public class MeleeWeapon extends Weapon {
    int cost;
    String name;
    boolean fireSupport;
    boolean fire = false;
    double damagePerShoot;
    double damageWithFire = damagePerShoot + 5.0;
    int damage;

    public MeleeWeapon(String name, int cost, int damage) {
        super(name, cost, damage);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
