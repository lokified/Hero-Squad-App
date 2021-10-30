public class Squad {

    private String name;
    private int maxNumberOfHeros;
    private String mission;

    public Squad(String name, int maxNumberOfHeros, String mission) {
        this.name = name;
        this.maxNumberOfHeros = maxNumberOfHeros;
        this.mission = mission;
    }

    public String getName() {
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
}
