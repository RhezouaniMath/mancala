package mancala.domain;

import java.time.ZonedDateTime;

public class Vakje{
    protected int nrOfBalls;
    protected Vakje firstVakje;
    protected Vakje nextVakje;
    protected Speler speler;
    protected boolean kalaha;
    public Vakje(Speler speler){
        this.nrOfBalls = 4;
        this.firstVakje = this;
        this.speler = speler;
        this.kalaha = false;
        this.nextVakje = new Vakje(this.speler, this.firstVakje, 1);
    }
    private Vakje(Speler speler, Vakje vakje, int nummer){
        this.firstVakje = vakje;
        if (nummer == 6){
            this.nrOfBalls = 0;
            this.speler = speler;
            this.kalaha = true;
            nummer++;
            this.nextVakje = new Vakje(this.speler.getTegenspeler() ,this.firstVakje, nummer);
        }
        else if (nummer == 13){
            this.nrOfBalls = 0;
            this.speler = speler;
            this.kalaha = true;
            this.nextVakje = vakje;
        }
        else{
            this.nrOfBalls = 4;
            this.speler = speler;
            this.kalaha = false;
            nummer++;
            this.nextVakje = new Vakje(this.speler, this.firstVakje, nummer);
        }
    }
    public int getNrOfBalls(){
        return nrOfBalls;
    }
    public Vakje getNextVakje(){
        return nextVakje;
    }
    public Speler getSpeler(){
        return speler;
    }
    public boolean getKalaha(){
        return kalaha;
    }
    public int ballsOnPlayersSide(Speler speler){
        int countBalls = 0;
        Vakje vak = this;
        while (vak.getSpeler() != speler){
            vak = vak.getNextVakje();
        }
        while (vak.getKalaha() == false){
            countBalls = countBalls + vak.getNrOfBalls();
            vak = vak.getNextVakje();
        }
        return countBalls;
    }
    public int ballsInKalaha(Speler speler){
        Vakje vak = this;
        while (vak.getSpeler() != speler){
            vak = vak.getNextVakje();
        }
        while (vak.getKalaha() == false){
            vak = vak.getNextVakje();
        }
        return vak.getNrOfBalls();
    }
    public void setNrOfBalls(int newNrOfBalls){
        nrOfBalls = newNrOfBalls;
    }
    public void addNrOfBalls(int additionalBalls){
        nrOfBalls = nrOfBalls + additionalBalls;
    }
    public Vakje getVakje(int stappen){
        if(stappen==0){
            return this;
        }
        return this.getNextVakje().getVakje(stappen-1);
    }
}