package org.example;

public class BAA extends RangedWeapon {
    int costOfBAA;
    String nameOfBAA;

    //there is no value yet because i could not see any damage value in the booklet
    private int damage;
    boolean poisonSupport;
    boolean poisoned = false;
    int damageWithPoison = damage + 15;
    int theNumberOfArrows;

    public BAA(String name, int cost, int damage, int bulletInMagazine) {
        super(name, cost, damage, bulletInMagazine);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }
}
