package mancala.api.models;

public class PlayerChoice {

    int choice;

    public int getChoice(){
        return choice;
    }

    public void setChoice(int choice){
        this.choice = choice;
    }

    public void setChoiceStrToInt(String choice){
        this.choice = Integer.parseInt(choice);
    }

/*
    String choice;

    public String getChoice(){
        return choice;
    }

    public void setChoice(String choice){
        this.choice = choice;
    }

*/

}
