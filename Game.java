package org.example;

public class Game {
    public static void main(String[] args) {

        //player creation
        MasterExpertPlayer kayla = new MasterExpertPlayer(false, "Kayla");
        BeginnerAmateurPlayer katie = new BeginnerAmateurPlayer(false, "katie");
        MasterExpertPlayer joseph = new MasterExpertPlayer(true, "joseph");
        MasterExpertPlayer arthur = new MasterExpertPlayer(true, "arthur");

        //Weapon creation
        RangedWeapon machineGun = new MachineGun("Machine Gun", 300, 25, 100);
        RangedWeapon sniperRifle = new Sniper("Sniper Rifle", 500, 75, 10);
        RangedWeapon pistol = new Pistol("Pistol", 200, 20, 20);
        RangedWeapon bowAndArrows = new BAA("Bow and Arrows", 200, 10, 20);
        Weapon meleeWeapon = new MeleeWeapon("Melee Weapon", 100, 30);

        //execution of the game with different scenarios
        System.out.println("Operation #1: Kayla tries to shoots at katie with no weapon.");
        kayla.shoot(katie);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #2: Kayla buys pistol");
        kayla.buyWeapon(pistol);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #3: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #4: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #5: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #6: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #7: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #8: Kayla drops weapon!");
        kayla.dropWeapon();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #9: Kayla buys sniper rifle");
        kayla.buyWeapon(sniperRifle);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #10: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #11: Kayla shoots at joseph");
        kayla.shoot(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #12: Katie tries to buy a machine gun");
        katie.buyWeapon(machineGun);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #13: Kayla tries to buy another weapon");
        kayla.buyWeapon(machineGun);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #14: Joseph takes cure");
        joseph.takeCure();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #15: Joseph buys a machine gun");
        joseph.buyWeapon(machineGun);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #16: Joseph sets sweep on");
        joseph.sweepOn();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #17: Joseph sets sweep");
        joseph.sweepOff();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #18: Kayla attaches scope");
        kayla.attachScope();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #19: Kayla detaches scope");
        kayla.detachScope();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #20: Katie moves to another coordinates");
        katie.move(22, 16);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #21: Katie tries to see distance between kayla");
        katie.seeDistance(kayla);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #22: Kayla sees distance between katie");
        kayla.seeDistance(katie);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #23: Kayla drops weapon");
        kayla.dropWeapon();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #24: Kayla buys bow and arrows");
        kayla.buyWeapon(bowAndArrows);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #25: Kayla poisons arrows");
        kayla.poisonArrow();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #26: Kayla cleans arrows");
        kayla.cleanArrow();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #27: Arthur buys a sniper rifle");
        arthur.buyWeapon(sniperRifle);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #28: Arthur tries to ignite sniper rifle");
        arthur.ignite();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #29: Arthur tries to douse sniper rifle");
        arthur.douse();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #30: Arthur exchanges weapons with joseph");
        arthur.exchangeWeapon(joseph);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #31: Arthur loans money to joseph");
        arthur.loanMoney(joseph, 100);
        System.out.println("----------------------------------------------");

        System.out.println("Operation #32: joseph loads magazine");
        joseph.loadMagazine();
        System.out.println("----------------------------------------------");

        System.out.println("Operation #33: Katie loans money to kayla ");
        katie.loanMoney(kayla, 100);
        System.out.println("----------------------------------------------");
    }
}
