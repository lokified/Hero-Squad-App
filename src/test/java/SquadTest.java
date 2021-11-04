import models.Hero;
import models.Squad;
import org.junit.Test;

import java.util.ArrayList;

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
    public void Squad_returnsCorrectlyWithId_1() {
        Squad.clearAllSquads();
        Squad firstTestSquad = new Squad("PowerPuff",3,"save children");
        Squad secondTestSquad = new Squad("Avengers",10,"save the world from Thanos");
        assertEquals(1,firstTestSquad.getId());
        assertEquals(2,secondTestSquad.getId());
    }

    @Test
    public void getAllSquad_returnsAllInstancesOfSquad_true(){

        Squad firstTestSquad = new Squad("PowerPuff",3,"save children");
        Squad secondTestSquad = new Squad("Avengers",10,"save the world from Thanos");
        assertTrue(Squad.getAllSquad().contains(firstTestSquad));
        assertTrue(Squad.getAllSquad().contains(secondTestSquad));
    }

    @Test
    public void findById_returnsCorrectlyTheId_3() {
        Squad.clearAllSquads();
        Squad newSquad= newSquad();
        Squad another = new Squad("ben 10",10,"transformation");
        Squad another1 = new Squad("TMNT",15,"flying");
        assertEquals(another1,Squad.findById(3));
    }

    @Test
    public void deleteDeletesASpecificSquad() throws Exception {
        Squad newSquad = newSquad();
        Squad otherSquad = new Squad("Avengers",5,"kill militia");
        newSquad.deleteSquad();
        assertEquals(1, Squad.getAllSquad().size());
        assertEquals(Squad.getAllSquad().get(0).getId(), 2);
    }

    @Test
    public void updateChangesSquad() throws Exception {
        Squad testSquad = newSquad();
        String formerName = testSquad.getName();
        int formerSize = testSquad.getMaxNumberOfHeros();
        String formerMission = testSquad.getMission();
        int formerId = testSquad.getId();

        testSquad.update("Man U",11,"UCL");

        assertNotEquals(formerName, testSquad.getName());
        assertNotEquals(formerSize, testSquad.getMaxNumberOfHeros());
        assertNotEquals(formerMission,testSquad.getMission());
        assertEquals(formerId,testSquad.getId());
    }

    @Test
    public void addsHeroToSquad_true() {
        Squad mySquad = newSquad();
        Hero myHero = new Hero("Captain America", 25, "Super Strong", "girlfriend","mySquad");
        mySquad.addHero(myHero);
        Squad foundSquad = Squad.findById(mySquad.getId());
        assertTrue(foundSquad.getAllheroInSquad(myHero).contains(myHero));
    }

    public Squad newSquad(){
        return new Squad("TNMT",4,"to save the world");
    }
}