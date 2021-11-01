import models.Squad;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void SquadInstantiatesCorrectly_true() {

        Squad testSquad =  newSquad();
        assertEquals(true,testSquad instanceof Squad);
    }

    @Test
    public void SquadInstantiatesCorrectlyWithName_true() {

        Squad testSquad = newSquad();
        assertEquals("TNMT",testSquad.getName());
    }

    @Test
    public void SquadInstantiatesCorrectlyWithNumberOfHeroes_true() {

        Squad testSquad = newSquad();
        assertEquals(4,testSquad.getMaxNumberOfHeros());
    }

    @Test
    public void SquadInstantiatesCorrectlyWithMission_true() {

        Squad testSquad = newSquad();
        assertEquals("to save the world",testSquad.getMission());
    }

    @Test
    public void getAllSquad_returnsAllInstancesOfSquad_true(){

        Squad firstTestSquad = new Squad("PowerPuff",3,"save children");
        Squad secondTestSquad = new Squad("Avengers",10,"save the world from Thanos");
        assertTrue(Squad.getAllSquad().contains(firstTestSquad));
        assertTrue(Squad.getAllSquad().contains(secondTestSquad));
    }

    @Test
    public void Squad_returnsCorrectlyWithId_1() {
        Squad firstTestSquad = new Squad("PowerPuff",3,"save children");
        Squad secondTestSquad = new Squad("Avengers",10,"save the world from Thanos");
        assertEquals(1,firstTestSquad.getId());
        assertEquals(2,secondTestSquad.getId());
    }

    @Test
    public void existingSquadCanBeFoundById() {
        Squad testSquad = newSquad();
        assertEquals(Squad.findById(testSquad.getId()),testSquad);
    }

    public Squad newSquad(){
        return new Squad("TNMT",4,"to save the world");
    }
}