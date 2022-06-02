package mancala.domain;

public class MancalaImpl implements Mancala {

    protected Spel game;

    public MancalaImpl() {
        this.game = new Spel();
    }

    @Override
    public boolean isPlayersTurn(int player) {
        if (player == PLAYER_TWO){
            return game.getSpeler().getTegenspeler().getAanDeBeurt();
        }
        return game.getSpeler().getAanDeBeurt();
    }

    @Override
	public void playPit(int index) //throws MancalaException {
    {   if ( game.getSpeler().getAanDeBeurt() == true){
            game.getSpeler().distribute(index, game.getVak());
        }
        else{
            game.getSpeler().getTegenspeler().distribute(index, game.getVak());
        }
    } //index < 7
	
	@Override
	public int getStonesForPit(int index) {
        return game.getVak().getVakje(index).getNrOfBalls();
    }

	@Override
	public boolean isEndOfGame() {
        Speler speler1 = game.getSpeler();
        Speler speler2 = game.getSpeler().getTegenspeler();
        int ballsSpeler1 = game.getVak().ballsOnPlayersSide(speler1);
        int ballsSpeler2 = game.getVak().ballsOnPlayersSide(speler2);
        if (ballsSpeler1 * ballsSpeler2 == 0){
            return true;
        }
        return false;
    }

	@Override
	public int getWinner() {
        int scoreSpeler1 = game.getSpeler().getScores();
        int scoreSpeler2 = game.getSpeler().getTegenspeler().getScores();
        if (scoreSpeler1 > scoreSpeler2){
            return Mancala.PLAYER_ONE;
        }
        if (scoreSpeler1 < scoreSpeler2){
            return Mancala.PLAYER_TWO;
        }
        return Mancala.NO_PLAYERS;
    }
}