import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void HeroInstantiatesCorrectly_true() {

        Hero testHero = newHero();
        assertEquals(true,testHero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesCorrectlyWithName_true() {
        Hero testHero = newHero();
        assertEquals("makmende",testHero.getName());
    }

    @Test
    public void HeroInstantiatesCorrectlyWithAge_true() {
        Hero testHero = newHero();
        assertEquals(30,testHero.getAge());
    }

    @Test
    public void HeroInstantiatesCorrectlyWithSpecialPower_true() {
        Hero testHero = newHero();
        assertEquals("water bender",testHero.getSpecialPower());
    }

    @Test
    public void HeroInstantiatesCorrectlyWithWeakness_true() {
        Hero testHero = newHero();
        assertEquals("fire",testHero.getWeakness());
    }

    public Hero newHero(){
        return new Hero("makmende",30,"water bender","fire");
    }
}