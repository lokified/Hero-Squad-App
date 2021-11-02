package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {

    private String name;
    private int age;
    private String superPower;
    private String weakness;
    private boolean published;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<Hero>();

    public Hero(String name, int age, String superPower, String weakness) {
        this.name = name;
        this.age = age;
        this.superPower = superPower;
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

    public String getSuperPower() {
        return superPower;
    }

    public void setSpecialPower(String specialPower) {
        this.superPower = specialPower;
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

    public void deleteHero() {
        instances.remove(id -1);
    }

    public void update(String name,int age,String superPower, String weakness) {
        this.name = name;
        this.age  = age;
        this.superPower = superPower;
        this.weakness = weakness;
    }


}
