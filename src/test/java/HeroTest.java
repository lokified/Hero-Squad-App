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
    public void newHero_getAllInstances_true() {
        Hero newHero = newHero();
        Hero another = new Hero("ben 10",10,"transformation","family");
        assertTrue(Hero.getAll().contains(newHero));
        assertTrue(Hero.getAll().contains(another));
    }

    @Test
    public void newHero_getId_Int() {
        Hero.clearAllHeroes();
        Hero newHero = newHero();
        Hero another = new Hero("ben 10",10,"transformation","family");
        Hero another1 = new Hero("TMNT",15,"flying","world");
        assertEquals(3,another1.getId());
    }
    @Test
    public void deleteDeletesASpecificPost() throws Exception {
        Hero.clearAllHeroes();
        Hero newHero = newHero();
        Hero otherPost = new Hero("IronMan",45,"gunshots","magnet");
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


    public Hero newHero(){
        return new Hero("makmende",30,"water bender","fire");
    }


}