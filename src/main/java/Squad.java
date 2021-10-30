public class Squad {

    private String name;
    private int numberOfHeros;
    private String mission;

    public Squad(String name, int numberOfHeros, String mission) {
        this.name = name;
        this.numberOfHeros = numberOfHeros;
        this.mission = mission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHeros() {
        return numberOfHeros;
    }

    public void setNumberOfHeros(int numberOfHeros) {
        this.numberOfHeros = numberOfHeros;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
