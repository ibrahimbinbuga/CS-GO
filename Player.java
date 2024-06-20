package org.example;

import java.util.Random;

public class Player extends Base {
    String name;
    int money;
    int health = 100;
    boolean terrorist;
    boolean beginnerAmateur = true;
    boolean masterExpert;

    //x axis between 0-100
    int xPosition;

    //y axis between 0-50
    int yPosition;
    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Player(boolean terrorist, String name) {
        this.terrorist = terrorist;
        this.name = name;
        this.money = 1000;
        this.health = 100;
        this.playerPosition();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public void setName(String playerName) {
        name = playerName;
    }

    public void setHealth(int hp) {
        health = hp;
    }

    public void setTerrorist(boolean isPlayerTerrorist) {
        terrorist = isPlayerTerrorist;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }


    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getHealth() {
        return health;
    }

    public boolean isTerrorist() {
        return terrorist;
    }


    //to take cure
    public void takeCure() {
        if (this.getMoney() < 500) {
            System.out.println("Failed! " + this.getName() + " cannot afford it now!");
        } else {
            this.setHealth(100);
            this.setMoney(this.getMoney() - 500);
            System.out.println("Success! " + this.getName() + " is now as fit as s(he) has never been before!");
            System.out.println("Info: " + this.getName() + "'s health level is now " + this.getHealth() + ".");
            System.out.println("Info: " + this.getName() + " has now " + this.getMoney() + " dollars.");
        }
    }

    //to load magazine
    public void loadMagazine() {
        int bulletCost = (20 - this.getBullletInMagazine()) * costPerBullet;
        if (this.getMoney() < bulletCost) {
            System.out.println("Failed! " + this.getName() + " cannot afford it now!");
        } else {
            this.setBullletInMagazine(20);
            this.setMoney(this.getMoney() - bulletCost);
            System.out.println("Success! The real war begins now!");
            System.out.println("Info: " + this.getName() + " has now " + this.getBullletInMagazine() + " bullets in the magazine!");
            System.out.println("Info: " + this.getName() + " has now " + this.getMoney() + " dollars!");
        }
    }

    //to loan money
    public void loanMoney(Player borrower, int amountOfDebt) {
        if (this instanceof BeginnerAmateurPlayer) {
            if (this.isTerrorist() != borrower.isTerrorist()) {
                System.out.println("Failed! Come on! Too young to be a spy!");
            } else if (amountOfDebt > this.getMoney()) {
                System.out.println("Failed! Player cannot afford it now!");
            } else {
                borrower.setMoney(borrower.getMoney() + amountOfDebt);
                this.setMoney(this.getMoney() - amountOfDebt);
                System.out.println("Success! " + this.getName() + " is a perfect philanthropist!");
                System.out.println("Info: " + this.getName() + " has now " + this.getMoney() + " dollars!");
                System.out.println("Info: " + borrower.getName() + " has now " + borrower.getMoney() + " dollars!");
            }
        } else {
            System.out.println("Failed! Only beginner amateur players can loan money!");
        }
    }

    //random coordinates for X axis and Y axis
    public void playerPosition() {
        int maxXbound = 100;
        int maxYbound = 50;
        Random random = new Random();
        int x = random.nextInt(maxXbound + 1);
        int y = random.nextInt(maxYbound + 1);
        this.xPosition = x;
        this.yPosition = y;
    }

    //to check if target is alive
    public boolean isTargetAlive(Player target) {
        if (target.getHealth() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //to check if weapon exists
    public boolean doesWeaponExist() {
        if (this.weapon == null) {
            return false;
        } else {
            return true;
        }
    }

    //to check if target exists
    public boolean doesTargetExist(Player target) {
        if (target == null) {
            return false;
        } else {
            return true;
        }
    }

    //to check if weapon has bullets
    public boolean doesWeaponHasBullets() {
        if (this.weapon instanceof RangedWeapon && this.weapon.getBullletInMagazine() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //to shoot a target
    public void shoot(Player target) {
        if (target.doesTargetExist(target)) {
            if (target.isTargetAlive(target)) {
                if (this.doesWeaponExist()) {
                    if (this.doesWeaponHasBullets()) {
                        if (this.terrorist == target.terrorist) {
                            System.out.println("Failed! Target player is on the same side!");
                        } else {
                            if (misfire()) {
                                System.out.println("Failed! Pistol misfired!");
                            } else {
                                if (target.getHealth() < this.weapon.damage) {
                                    target.setHealth(0);
                                    this.weapon.setBullletInMagazine(this.weapon.getBullletInMagazine() - this.weapon.getBulletDecrase());
                                    System.out.println("Success! Pinpoint accuracy!");
                                    System.out.println("Info: There are " + this.weapon.getBullletInMagazine() + " bullet(s) left in " + this.getName() + "'s magazine.");
                                    System.out.println("Info: " + target.getName() + "'s health level is decreased to " + target.getHealth() + ".");
                                } else if (target.getHealth() > this.weapon.damage) {
                                    this.weapon.setBullletInMagazine(this.weapon.getBullletInMagazine() - this.weapon.getBulletDecrase());
                                    target.setHealth(target.getHealth() - (this.weapon.getDamage()));
                                    System.out.println("Success! Pinpoint accuracy!");
                                    System.out.println("Info: There are " + this.weapon.getBullletInMagazine() + " bullet(s) left in " + this.getName() + "'s magazine.");
                                    System.out.println("Info: " + target.getName() + "'s health level is decreased to " + target.getHealth() + ".");
                                }
                            }
                        }
                    } else {
                        System.out.println("Failed! No bullet left in magazine!");
                    }
                } else {
                    System.out.println("Failed! " + this.getName() + " has no weapon!");
                }
            } else {
                System.out.println("Failed! The enemy is already dead!");
            }
        } else {
            System.out.println("Failed! Target player does not exist!");
        }
    }

    //to ignite a melee weapon
    public void ignite() {
        if (this.weapon instanceof MeleeWeapon) {
            if (((MeleeWeapon) this.weapon).fireSupport) {
                ((MeleeWeapon) this.weapon).setDamage(this.weapon.damage + 5);
                System.out.println("Info: Melee weapon is on fire now!");
            }
        } else {
            System.out.println("Failed! Only melee weapons can be ignited!");
        }
    }

    //to douse a melee weapon
    public void douse() {
        if (this.weapon instanceof MeleeWeapon) {
            if (((MeleeWeapon) this.weapon).fire) {
                ((MeleeWeapon) this.weapon).setDamage(damage - 5);
            } else {
                System.out.println("Failed! Only fired melee weapons can be doused!");
            }
        } else {
            System.out.println("Failed! Only melee weapons can be doused!");
        }
    }

    //to attach scope to a sniper rifle
    public void attachScope() {
        if (this.weapon instanceof Sniper) {
            ((Sniper) this.weapon).setScope(true);
            ((Sniper) this.weapon).setMisfireRatio(0.01);
            System.out.println("Info: The scope is attached!");
        } else if (((Sniper) this.weapon).isScope()) {
            System.out.println("Info: The scope is already attached!");
        } else {
            System.out.println("Failed! Scopes can be attached with only sniper rifles!");
        }
    }

    //to detach scope from a sniper rifle
    public void detachScope() {
        if (this.weapon instanceof Sniper) {
            if (((Sniper) this.weapon).scope) {
                ((Sniper) this.weapon).setScope(false);
                ((Sniper) this.weapon).setMisfireRatio(0.45);
                System.out.println("Info: The scope is detached!");
            } else {
                System.out.println("Info: The scope is already detached!");
            }
        } else {
            System.out.println("Failed! Scopes can be detached with only sniper rifles!");
        }
    }

    //to buy a weapon
    public void buyWeapon(Weapon weapon) {
        if (this.weapon == null) {
            if (this instanceof BeginnerAmateurPlayer && weapon instanceof RangedWeapon) {
                System.out.println("Failed! Only master expert players can buy this type of weapons!");
            } else if (this instanceof MasterExpertPlayer && weapon instanceof Weapon) {
                if (this.getMoney() >= weapon.getCost()) {
                    this.setMoney(this.getMoney() - weapon.getCost());
                    this.setWeapon(weapon);
                    System.out.println("Info: " + this.getName() + " bought a " + this.weapon.getName());
                } else {
                    System.out.println("Failed! " + this.getName() + " has no enough money!");
                }
            }
        } else {
            System.out.println("Failed! Players can have only one weapon!");
        }
    }

    //to drop a weapon
    public void dropWeapon() {
        if (this instanceof MasterExpertPlayer) {
            if (this.doesWeaponExist()) {
                this.setWeapon(null);
                System.out.println("Info: " + this.getName() + " dropped the weapon!");
            }
        } else {
            System.out.println("Failed! Only master expert players can drop weapon!");
        }
    }

    //to poison arrows
    public void poisonArrow() {
        if (this.weapon instanceof BAA) {
            if (((BAA) this.weapon).poisonSupport) {
                ((BAA) this.weapon).setPoisoned(true);
                this.weapon.setDamage(this.weapon.damage + 15);
                System.out.println("Success! Arrows are poisoned!");
            } else {
                System.out.println("Failed! Arrows does not support poison!");
            }
        } else {
            System.out.println("Failed! Only arrows can be poisoned!");
        }
    }

    //to clean arrows
    public void cleanArrow() {
        if (this.weapon instanceof BAA) {
            if (((BAA) this.weapon).poisoned) {
                ((BAA) this.weapon).setPoisoned(false);
                this.weapon.setDamage(this.weapon.damage - 15);
                System.out.println("Success! Arrows are cleaned!");
            } else {
                System.out.println("Failed! Only poisoned arrows can be cleaned!");
            }
        } else {
            System.out.println("Failed! Only arrows can be cleaned!");
        }
    }

    //to set sweep on
    public void sweepOn() {
        if (this.weapon instanceof MachineGun) {
            if (this instanceof MasterExpertPlayer) {
                if (((MachineGun) this.weapon).sweep) {
                    System.out.println("Info: Sweep is already on!");
                } else {
                    ((MachineGun) this.weapon).setSweep(true);
                    ((MachineGun) this.weapon).setBulletDecrase(((MachineGun) this.weapon).bulletDecraseWithSweep);
                    System.out.println("Success! Sweep is now on!");
                }
            } else {
                System.out.println("Failed! Only master expert players can set sweep on!");
            }
        } else {
            System.out.println("Failed! Only machine guns can be set as sweep on!");
        }
    }

    //to set sweep off
    public void sweepOff() {
        if (this.weapon instanceof MachineGun) {
            if (this instanceof MasterExpertPlayer) {
                if (((MachineGun) this.weapon).sweep = false) {
                    System.out.println("Sweep is already off!");
                } else {
                    ((MachineGun) this.weapon).setSweep(false);
                    ((MachineGun) this.weapon).setBulletDecrase(((MachineGun) this.weapon).bulletDecraseWithoutSweep);
                    System.out.println("Success! Sweep is now off!");
                }
            } else {
                System.out.println("Failed! Only master expert players can set sweep off!");
            }
        } else {
            System.out.println("Failed! Only machine guns can be set as sweep off!");
        }
    }

    //to exchange weapon
    public void exchangeWeapon(Player receiver) {
        if (this instanceof MasterExpertPlayer) {
            if (receiver.doesTargetExist(receiver)) {
                if (receiver.doesWeaponExist()) {
                    System.out.println("Info: " + this.getName() + " has changed " + this.getWeapon().getName() + " with " + receiver.getName() + "'s " + receiver.getWeapon().getName());
                    Weapon empty = null;
                    empty = this.weapon;
                    this.weapon = receiver.weapon;
                    receiver.weapon = empty;
                } else {
                    System.out.println("Failed! Receiver does not have any weapon!");
                }
            } else {
                System.out.println("Failed! Receiver does not exist!");
            }
        } else {
            System.out.println("Failed! Only master expert players can exchange weapon!");
        }
    }

    //to move to another coordinates
    public void move(int xAxis, int yAxis) {
        if (xAxis > 0 && xAxis < 100) {
            this.setxPosition(xAxis);
        } else {
            System.out.println("Failed! The X-axis coordinate is out of boundary!");
        }
        if (yAxis > 0 && yAxis < 50) {
            this.setyPosition(yAxis);
        } else {
            System.out.println("Failed! The Y-axis coordinate is out of boundary!");
        }
    }

    //to see distance between two players
    public void seeDistance(Player player) {
        if (this instanceof MasterExpertPlayer) {
            int xDistance = this.xPosition - player.xPosition;
            int yDistance = this.yPosition - player.yPosition;
            System.out.println("Info: The distance between " + this.getName() + " and " + player.getName() + " is " + Math.sqrt((xDistance * xDistance) + (yDistance * yDistance)) + " meters.");
        } else {
            System.out.println("Failed! Only master expert players can see distance between the other players.");
        }
    }
}
