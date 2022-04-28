package mancala.domain;
public class Spel{
    protected Speler speler;
    protected Vakje vak;
    public Spel(){
        this.speler = new Speler();
        this.vak = new Vakje(this.speler);
    }
    public void playRound(int choice){
        if(speler.getAanDeBeurt() == true){
            speler.Distribute(choice, vak);
        }
        else{
            speler.getTegenspeler().Distribute(choice,vak);
        }
    }
    public Speler getSpeler(){
        return speler;
    }
    public Vakje getVak(){
        return vak;
    }
}