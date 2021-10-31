package models;

import java.util.ArrayList;

public class Hero {

    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    private boolean published;
    private static ArrayList<Hero> instances = new ArrayList<Hero>();
    private int id;

    public Hero(String name, int age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.published = false;
        instances.add(this);
        this.id = instances.size();
    }

    public static ArrayList<Hero> getAll() {
        return instances;
    }

    public  static void  clearAllHeroes(){
        instances.clear();
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPublished() {
        return published;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public static Hero findById(int id){
        return instances.get(id - 1);
    }


}
