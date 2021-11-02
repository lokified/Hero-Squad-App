package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {

    private  String name;
    private int maxNumberOfHeros;
    private String mission;
    private  int id;
    private static ArrayList<Squad> instances = new ArrayList<Squad>();

    public Squad(String name, int maxNumberOfHeros, String mission) {
        this.name = name;
        this.maxNumberOfHeros = maxNumberOfHeros;
        this.mission = mission;
        instances.add(this);
        this.id = instances.size();
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNumberOfHeros() {
        return maxNumberOfHeros;
    }

    public void setMaxNumberOfHeros(int maxNumberOfHeros) {
        this.maxNumberOfHeros = maxNumberOfHeros;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
    public static ArrayList<Squad> getAllSquad(){
        return instances;
    }

}
