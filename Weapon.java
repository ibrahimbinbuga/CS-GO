package org.example;

public class Weapon extends Base {
    int damage;
    int cost;
    String name;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Weapon(String name, int cost, int damage) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }
}
