import models.Hero;
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

    @Test
    public void isPublishedIFalseAfterInstantiation_false() {
        Hero testHero = newHero();
        assertEquals(false,testHero.isPublished());
    }

    @Test
    public void getAll_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("Ben10",10,"transformation","family");
        Hero secondHero = new Hero("Batman",40,"strength","people");
        assertTrue(Hero.getAll().contains(firstHero));
        assertTrue(Hero.getAll().contains(secondHero));
    }

    @Test
    public void getId_HeroInstantiateWithId_1() {
        Hero.clearAllHeroes();
        Hero testHero = newHero();
        assertEquals(1,testHero.getId());
    }

    @Test
    public void findReturnsCorrectHero() {
        Hero.clearAllHeroes();
        Hero testHero = newHero();
        assertEquals(1,Hero.findById(testHero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectHero_2() {
        Hero.clearAllHeroes();
        Hero testHero = newHero();
        Hero secondTestHero = new Hero("Ben10",10,"transformation","family");
        assertEquals(2,Hero.findById(secondTestHero.getId()).getId());
    }

    public Hero newHero(){
        return new Hero("makmende",30,"water bender","fire");
    }


}