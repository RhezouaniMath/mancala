package mancala.domain;
public class Spel{



    protected Speler speler;

    protected Vakje vak;



    public Spel(){
        this.speler = new Speler();
        this.vak = new Vakje(this.speler);
        this.speler.setEersteVakje(this.vak);
        this.speler.getTegenspeler().setEersteVakje(this.vak.getVakje(7));
    }

    public void playRound(int choice){
        if(speler.getAanDeBeurt() == true){
            speler.distribute(choice, vak);
        }
        else{
            speler.getTegenspeler().distribute(choice,vak);
        }
    }

    public Speler getSpeler(){
        return speler;
    }

    public Vakje getVak(){
        return vak;
    }



}