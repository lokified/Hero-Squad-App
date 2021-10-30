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

    public Squad newSquad(){
        return new Squad("TNMT",4,"to save the world");
    }
}