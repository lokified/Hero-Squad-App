import models.Hero;
import models.Squad;
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
        assertEquals("water bender",testHero.getSuperPower());
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
    public void newHero_getAllInstances_true() {
        Hero newHero = newHero();
        Squad mySquad2 = new Squad("Power",10,"save ");
        Hero another = new Hero("ben 10",10,"transformation","family","mySquad2");
        assertTrue(Hero.getAll().contains(newHero));
        assertTrue(Hero.getAll().contains(another));
    }

    @Test
    public void newHero_getId_Int() {
        Hero.clearAllHeroes();
        Hero newHero = newHero();
        Squad mySquad1 = new Squad("Left",5,"Kill world");
        Squad mySquad2 = new Squad("Power",10,"save ");
        Hero another = new Hero("ben 10",10,"transformation","family","mySquad1");
        Hero another1 = new Hero("TMNT",15,"flying","world","mySquad2");
        assertEquals(3,another1.getId());
    }

    @Test
    public void deleteDeletesASpecificPost() throws Exception {
        Hero.clearAllHeroes();
        Hero newHero = newHero();
        Squad mySquad = new Squad("Avengers",5,"save world");
        Hero otherPost = new Hero("IronMan",45,"gunshots","magnet","mySquad");
        newHero.deleteHero();
        assertEquals(1, Hero.getAll().size());
        assertEquals(Hero.getAll().get(0).getId(), 2);
    }

    @Test
    public void deleteAllPostsDeletesAllPosts() throws Exception {

        Hero newHero = newHero();
        Hero otherPost = newHero();

        Hero.clearAllHeroes();
        assertEquals(0, Hero.getAll().size());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Hero testHero = newHero();
        String formerName = testHero.getName();
        int formerAge = testHero.getAge();
        String formerSpecialPower = testHero.getSuperPower();
        String formerWeakness = testHero.getWeakness();
        int formerId = testHero.getId();

        testHero.update("De Gea",29,"keeper","coach");

        assertNotEquals(formerName, testHero.getName());
        assertNotEquals(formerAge, testHero.getAge());
        assertNotEquals(formerSpecialPower,testHero.getSuperPower());
        assertNotEquals(formerWeakness, testHero.getWeakness());
        assertEquals(formerId,testHero.getId());
    }




    public Hero newHero(){
        Squad mySquad = new Squad("Avengers",5,"save world");
        return new Hero("makmende",30,"water bender","fire","mySquad");
    }


}