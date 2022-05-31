package mancala.domain;

public class MancalaImpl implements Mancala {

    Spel game;

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
	public void playPit(int index) throws MancalaException {
        // Implement playing a pit.
    }
	
	@Override
	public int getStonesForPit(int index) {
        return game.getVak().getVakje(index).getNrOfBalls();
    }

	@Override
	public boolean isEndOfGame() {
        return false;
    }

	@Override
	public int getWinner() {
        return Mancala.NO_PLAYERS;
    }
}