package org.example;

public class MasterExpertPlayer extends Player {
    public MasterExpertPlayer(boolean terrorist, String name) {
        super(terrorist, name);
    }

    boolean immortal = false;
    //weapon limit for master expert player
    Weapon[] weapons = new Weapon[5];
    int money = 1000;
}
