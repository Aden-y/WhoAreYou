package com.sheridan.whoareyou.models;
public class Avanger {
    private String name;
    private boolean canFly;
    private int intelligence;
    private int strength;
    private int speed;
    private int energy;
    private int skill;
    private int leadership;
    private int charm;
    private int luck;
    private String detailUrl,imageUrl;

    public Avanger(String name, boolean canFly, int intelligence, int strength, int speed, int energy, int skill, int leadership, int charm, int luck, String detailUrl, String imageUrl) {
        this.name = name;
        this.canFly = canFly;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.energy = energy;
        this.skill = skill;
        this.leadership = leadership;
        this.charm = charm;
        this.luck = luck;
        this.detailUrl = detailUrl;
        this.imageUrl = imageUrl;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public double getSimilarity(Avanger another) {
        //name,canFly,intelligence,strength,speed,energy,skill,leadership,charm,luck,detailUrl,imageUrl
        double canFlyDiff = canFly != another.canFly ? 2 : 0,
                intelligenceDiff = Math.abs(intelligence - another.intelligence),
                strengthDiff = Math.abs(strength - another.strength),
                speedDiff = Math.abs(speed - another.speed),
                energyDiff = Math.abs(energy - another.energy),
                skillDiff = Math.abs(skill - another.skill),
                leadershipDiff = Math.abs(leadership - another.leadership),
                charmDiff = Math.abs(charm - another.charm),
                luckDiff = Math.abs(luck - another.luck);
        double total = intelligenceDiff + strengthDiff +speedDiff + energyDiff + skillDiff + leadershipDiff + charmDiff + luckDiff;
        double percent = (total/80);
        return ((1.0 - percent) * 100) - canFlyDiff;
    }
    
//    public static void main(String[] args) {
//        Avanger a = new Avanger("Joakim", true, 10, 10, 10, 10, 10, 10, 10, 10, "", "");
//        Avanger a1 = new Avanger("Adeny", true, 1, 1, 1, 1, 1, 1, 1, 1, "", "");
//        System.out.println("Similar : "+a.getSimilarity(a));
//        System.out.println("Different : "+a1.getSimilarity(a1));
//    }
}
