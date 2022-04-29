package mancala.domain;
public class Speler{
    protected boolean aanDeBeurt;
    protected Speler tegenspeler;
    protected Vakje eersteVakje;

    public Speler(){
        this.aanDeBeurt=true;
        this.tegenspeler = new Speler(this);
    }
    private Speler(Speler player){
        this.aanDeBeurt=false;
        this.tegenspeler=player;
    }
    public Speler getTegenspeler(){
        return tegenspeler;
    }
    public boolean getAanDeBeurt(){
        return aanDeBeurt;
    }
    public void setAanDeBeurt(boolean bool){
        aanDeBeurt = bool;
    }
    public Vakje chooseVakje(int choice, Vakje vakje){  //choice = 1,2,3,4,5 or 6
        choice--;
        if (this != vakje.getSpeler()){
            choice = choice + 7;
        }
        for (int NrOfVakje = 0; NrOfVakje < choice; NrOfVakje++){
            vakje = vakje.getNextVakje();
        }
        return vakje;
    }
    public void Distribute(int choice, Vakje vakje){
        Vakje keuzevak = chooseVakje(choice, vakje);
        int nrOfBallsToDistribute = keuzevak.getNrOfBalls();
        keuzevak.setNrOfBalls(0);
        while(nrOfBallsToDistribute != 0){
            keuzevak=keuzevak.getNextVakje();
            int previousNrOfBalls = keuzevak.getNrOfBalls();
            if (nrOfBallsToDistribute == 1 && keuzevak.getSpeler() == this && keuzevak.getKalaha() == false && previousNrOfBalls == 0){
                nrOfBallsToDistribute--;
                Stelen(keuzevak);
            }
            else{
                if (keuzevak.getKalaha() == true && keuzevak.getSpeler()!=this){
                }
                else{
                    previousNrOfBalls++;
                    keuzevak.setNrOfBalls(previousNrOfBalls);
                    nrOfBallsToDistribute--;
                    if (keuzevak.getKalaha() == true && keuzevak.getSpeler()==this){
                        toSwitchOrNotToSwitch(true, false);
                    }
                    else{
                        toSwitchOrNotToSwitch(false, true);
                    }
                }
            }
        }
        printScores(vakje);
    }
    public void Stelen(Vakje keuzevak){
        int counter = 0;
        toSwitchOrNotToSwitch(false, true);
        while (keuzevak.getKalaha() == false){
            counter++;
            keuzevak = keuzevak.getNextVakje();
        }
        Vakje ThisKalaha = keuzevak;
        while (counter != 0){
            counter--;
            keuzevak = keuzevak.getNextVakje();
        }
        int NrOfBallsToAddToKalaha = keuzevak.getNrOfBalls();
        NrOfBallsToAddToKalaha++;
        keuzevak.setNrOfBalls(0);
        ThisKalaha.addNrOfBalls(NrOfBallsToAddToKalaha);
    }
    public void toSwitchOrNotToSwitch(boolean boolSp1, boolean boolSp2){
        this.aanDeBeurt = boolSp1;
        this.tegenspeler.aanDeBeurt = boolSp2;
    }
    public void printScores(Vakje vakje){
        int ballsSpeler = vakje.ballsOnPlayersSide(this);
        int ballsTegenspeler = vakje.ballsOnPlayersSide(this.getTegenspeler());
        int ballInKalahaSpeler = vakje.ballsInKalaha(this);
        int ballInKalahaTegenspeler = vakje.ballsInKalaha(this.getTegenspeler());
        int scoreSpeler = ballsSpeler + ballInKalahaSpeler;
        int scoreTegenspeler = ballsTegenspeler + ballInKalahaTegenspeler;
        if (ballsSpeler * ballsTegenspeler == 0){
            System.out.println("Er kan niet meer gespeeld worden. Het spel eindigt.");
            if (scoreSpeler == scoreTegenspeler){
                System.out.println("Het is gelijkspel.");
            }
            else if (scoreSpeler > scoreTegenspeler){
                System.out.println("Jij hebt gewonnen.");
            }
            else {
                System.out.println("Jouw tegenspeler heeft gewonnen.");
            }
        }
    }

    public int getScores(){
        int score = this.eersteVakje.ballsOnPlayersSide(this) + this.eersteVakje.getVakje(6).ballsInKalaha(this);
        return score;
    }
    public void setEersteVakje(Vakje vak) {
        this.eersteVakje=vak;
    }
}