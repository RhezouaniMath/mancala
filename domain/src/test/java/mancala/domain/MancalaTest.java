package mancala.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MancalaTest{

    @Test
    public void nrOfBallsMustBeFour(){
        //Speler speler = new Speler();
        Vakje vak = new Vakje(/*speler*/);
        assertEquals(4, vak.getNrOfBalls());
    }
}