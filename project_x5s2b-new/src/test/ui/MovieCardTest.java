package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.MovieCard;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieCardTest {

    private MovieCard movieCard;

    @BeforeEach
    public void setUp() {
        movieCard = new MovieCard ();
    }


    @Test
    public void testspentMoney(){
        assertEquals(200,movieCard.spentMoney("200"));
        assertFalse(2500 == movieCard.spentMoney("1200"));
    }

    @Test
    public void testgetPoints(){
        movieCard.myAmount = 8000;
        movieCard.moneyToPoints();
        assertEquals (1200,movieCard.getPoints ());
        assertFalse (movieCard.getPoints() == 500);
        movieCard.moneyToPoints();
        movieCard.spentMoney("1000");
        assertEquals(2400,movieCard.getPoints());


    }


    @Test
    public void testMoviesEarned(){
        movieCard.myAmount = 8000;
        movieCard.moneyToPoints();
        assertEquals(1,movieCard.moviesEarned());
        movieCard.spentMoney("1000");
        movieCard.moneyToPoints();
        assertEquals (2, movieCard.moviesEarned());

    }

    @Test
    public void testfreeMoviesCalculator(){
        movieCard.myAmount = 8000;
        movieCard.moneyToPoints();
        assertEquals(1,movieCard.freeMoviesCalculator());
        movieCard.spentMoney("1000");
        movieCard.moneyToPoints();
        assertEquals (2, movieCard.freeMoviesCalculator());

    }


//    @Test
//    public void testcardIsValid(){
//        movieCard.within6months = false;
//        assertTrue (movieCard.cardIsValid () == true);
//        assertTrue(movieCard.cardIsValid () == false);
//
//        movieCard.within6months = true;
//        assertTrue(movieCard.cardIsValid () == false);
//        assertTrue(movieCard.cardIsValid () == true);
//
//    }


}
