package mancala.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MancalaTest{

    @Test
    public void nrOfBallsMustBeFour(){
        Speler speler = new Speler();
        Vakje vak = new Vakje(speler);
        assertEquals(4, vak.getNrOfBalls());
    }

    @Test
    public void nrOfVakjesMustbeFourteen(){
        Speler speler = new Speler();
        Vakje vak = new Vakje(speler);
        int aantalvakjes = 1;
        Vakje a = vak;
        while(a.getNextVakje() != vak){
            aantalvakjes++;
            a=a.getNextVakje();
        }
        assertEquals(14, aantalvakjes);
    }

    @Test
    public void nrOfBallsIsAllrightInEveryVakje(){
        boolean kloppendeAantallenBallen = true;
        Speler speler = new Speler();
        Vakje vak = new Vakje(speler);
        for (int VakjeNr = 0; VakjeNr < 14; VakjeNr++){
            Vakje vakk=vak.getVakje(VakjeNr);
            if (VakjeNr == 6){
                if(vakk.getNrOfBalls() != 0){
                    kloppendeAantallenBallen = false;
                }
            }
            else if (VakjeNr == 13){
                if(vakk.getNrOfBalls() != 0){
                    kloppendeAantallenBallen = false;
                }
            }
            else{
                if(vakk.getNrOfBalls() != 4){
                    kloppendeAantallenBallen = false;
                }
            }
        }
        assertEquals(true, kloppendeAantallenBallen);
    }

    @Test
    public void tegenspelerIsDifferent(){
        Speler speler = new Speler();
        boolean equal = false;
        if (speler == speler.getTegenspeler()){
            equal = true;
        }
        assertEquals(false, equal);
    }

    @Test
    public void tegenspelerofTegenspelerIsSame(){
        Speler speler = new Speler();
        boolean equal = false;
        if (speler == speler.getTegenspeler().getTegenspeler()){
            equal = true;
        }
        assertEquals(true, equal);
    }

    @Test
    public void theRightPlayersAssigned(){
        boolean rightPlayers = true;
        Speler speler = new Speler();
        Vakje vak = new Vakje(speler);
        for (int VakjeNr =0; VakjeNr < 14; VakjeNr++){
            if(VakjeNr<7){
                if(vak.getVakje(VakjeNr).getSpeler() != speler){
                    rightPlayers = false;
                }
            }
            else{
                if(vak.getVakje(VakjeNr).getSpeler() != speler.getTegenspeler()){
                    rightPlayers = false;
                }
            }
        }
        assertEquals(true, rightPlayers);
    }

    @Test
    public void laatsteVakjeWijstNaarEersteVakje(){
        boolean isThatTrue=false;
        Speler speler = new Speler();
        Vakje controlevak = new Vakje(speler);
        Vakje vak = controlevak.getVakje(14);
        if (vak == controlevak){
            isThatTrue = true;
        }
        assertEquals(true, isThatTrue);
    }

    @Test
    public void nrOfBallsAfterDistribute(){
        Speler speler = new Speler();
        Vakje vak = new Vakje(speler);
        vak.getVakje(5).setNrOfBalls(10);
        speler.Distribute(6, vak);
        int[] arrayOfBalls = new int[14];
        for (int VakjeNr = 0; VakjeNr < 14; VakjeNr++){
            arrayOfBalls[VakjeNr] = vak.getVakje(VakjeNr).getNrOfBalls();
        }
        assertArrayEquals(new int[] {5,5,5,4,4,0,1,5,5,5,5,5,5,0}, arrayOfBalls);
    }

    @Test
    public void areTheRightVakjesKalahas(){
        Speler speler = new Speler();
        Vakje vak = new Vakje(speler);
        boolean[] booleanOfKalaha = new boolean[14];
        for (int VakjeNr = 0; VakjeNr < 14; VakjeNr++){
            booleanOfKalaha[VakjeNr] = vak.getVakje(VakjeNr).getKalaha();
        }
        assertArrayEquals(new boolean[] {false,false,false,false,false,false,true,false,false,false,false,false,false,true}, booleanOfKalaha);
    }

    @Test
    public void isItNotTheFirstPlayersTurnAfterChoice1InRound1(){
        Spel spel = new Spel();
        spel.playRound(1);
        boolean testBoolean1 = spel.getSpeler().getAanDeBeurt();
        assertEquals(false, testBoolean1);
    }

    @Test
    public void isItTheFirstPlayersTurnAfterChoice3InRound1(){
        Spel spel = new Spel();
        spel.playRound(3);
        boolean testBoolean1 = spel.getSpeler().getAanDeBeurt();
        assertEquals(true, testBoolean1);
    }

    @Test
    public void spelTestSecondPlayerHasFirstTurnAndChooses1IsItFirstPlayersTurn(){
        Spel spel = new Spel();
        spel.speler.setAanDeBeurt(false);
        spel.speler.getTegenspeler().setAanDeBeurt(true);
        spel.playRound(1);
        boolean testBoolean1 = spel.getSpeler().getAanDeBeurt();
        assertEquals(true, testBoolean1);
    }

    @Test
    public void spelTestSecondPlayerHasFirstTurnAndChooses3IsItNotFirstPlayersTurn(){
        Spel spel = new Spel();
        spel.speler.setAanDeBeurt(false);
        spel.speler.getTegenspeler().setAanDeBeurt(true);
        spel.playRound(3);
        boolean testBoolean1 = spel.getSpeler().getAanDeBeurt();
        assertEquals(false, testBoolean1);
    }

    @Test
    public void spelTestSecondPlayerHasFirstTurnAndChooses3IsItSecondPlayersTurn(){
        Spel spel = new Spel();
        spel.speler.setAanDeBeurt(false);
        spel.speler.getTegenspeler().setAanDeBeurt(true);
        spel.playRound(3);
        boolean testBoolean1 = spel.getSpeler().getTegenspeler().getAanDeBeurt();
        assertEquals(true, testBoolean1);
    }

    @Test
    public void jattenMakeFifthVakjeEmptyThenChoose1InRnd1FourthMustRemainEmpty(){
        Spel spel = new Spel();
        Vakje vak = spel.getVak().getVakje(4);
        vak.setNrOfBalls(0);
        spel.playRound(1);
        assertEquals(0, vak.getNrOfBalls());
    }

    @Test
    public void jattenMakeFifthVakjeEmptyThenChoose1inRnd1KalahaMustContain5(){
        Spel spel = new Spel();
        Vakje vak = spel.getVak();
        vak = vak.getVakje(4);
        vak.setNrOfBalls(0);
        spel.playRound(1);
        vak = spel.getVak();
        vak = vak.getVakje(6);
        assertEquals(5, vak.getNrOfBalls());
    }

    @Test
    public void jattenMakeFifthVakjeEmptyThenChoose1InRnd1ThenOppositeVakjeMustBeEmpty(){
        Spel spel = new Spel();
        Vakje vak = spel.getVak().getVakje(4);
        vak.setNrOfBalls(0);
        spel.playRound(1);
        vak = spel.getVak().getVakje(8);
        assertEquals(0, vak.getNrOfBalls());
    }

    @Test
    public void initialNrOfBallsOnPlayersSideMustBe24(){
        Spel spel = new Spel();
        Speler speler = spel.getSpeler();
        Vakje vak = spel.getVak();
        int nrOfB = vak.ballsOnPlayersSide(speler);
        assertEquals(24, nrOfB);
    }

    @Test
    public void nrOfBallsOnPlayersSideMustBe21AfterChoice5(){
        Spel spel = new Spel();
        Speler speler = spel.getSpeler();
        Vakje vak = spel.getVak();
        speler.Distribute(5, vak);
        int nrOfB = vak.ballsOnPlayersSide(speler);
        assertEquals(21, nrOfB);
    }

    @Test
    public void nrOfBallsOnOppositeSideMusteBe26AfterChoice5(){
        Spel spel = new Spel();
        Speler speler = spel.getSpeler();
        Vakje vak = spel.getVak();
        speler.Distribute(5, vak);
        int nrOfB = vak.ballsOnPlayersSide(speler.getTegenspeler());
        assertEquals(26, nrOfB);
    }

    @Test
    public void nrOfBallsMustBe24AfterChoices5and6(){
        Spel spel = new Spel();
        Speler speler = spel.getSpeler();
        Vakje vak = spel.getVak();
        speler.Distribute(5, vak);
        speler.getTegenspeler().Distribute(6, vak);
        int nrOfB = vak.ballsOnPlayersSide(speler);
        assertEquals(24, nrOfB);
    }

    @Test
    public void nrOfBallsOppositeSideMustBe22AfterChoices5and6(){
        Spel spel = new Spel();
        Speler speler = spel.getSpeler();
        Vakje vak = spel.getVak();
        speler.Distribute(5, vak);
        speler.getTegenspeler().Distribute(6, vak);
        int nrOfB = vak.ballsOnPlayersSide(speler.getTegenspeler());
        assertEquals(22, nrOfB);
    }

    @Test
    public void nrOfBallsOppositeSideMustBe22AfterChoices5and6WithPlayRoundMethodFromSpel(){
        Spel spel = new Spel();
        spel.playRound(5);//(5, vak);
        spel.playRound(6);
        int nrOfB = spel.getVak().ballsOnPlayersSide(spel.getSpeler().getTegenspeler());
        assertEquals(22, nrOfB);
    }
}