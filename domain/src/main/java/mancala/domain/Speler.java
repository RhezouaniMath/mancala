package mancala.domain;
public class Speler{
    private boolean aanDeBeurt;
    private Speler tegenspeler;
    //private Vakje eersteVakje;
    public Speler(){
        this.aanDeBeurt=true;
        this.tegenspeler = new Speler(this);
        //this.eersteVakje = new Vakje(this);
    }
    private Speler(Speler player){
        this.aanDeBeurt=false;
        this.tegenspeler=player;
        //this.eersteVakje= new Vakje (this);
    }
    public Speler getTegenspeler(){
        return tegenspeler;
    }
    public boolean getAanDeBeurt(){
        return aanDeBeurt;
    }
    /*
    public Vakje getEersteVakje(){
        return eersteVakje;
    }
    */
}