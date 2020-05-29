package model;

public class GameBean {
	char winner;
	boolean isGameOver;
	boolean isGameDraw;
	boolean isMoveValid;
	char currentPlayer;
	
	public char getWinner() {
		return winner;
	}
	public void setWinner(char winner) {
		this.winner = winner;
	}
	public boolean isGameOver() {
		return isGameOver;
	}
	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}
	public boolean isGameDraw() {
		return isGameDraw;
	}
	public void setGameDraw(boolean isGameDraw) {
		this.isGameDraw = isGameDraw;
	}
	public boolean isMoveValid() {
		return isMoveValid;
	}
	public void setMoveValid(boolean isMoveValid) {
		this.isMoveValid = isMoveValid;
	}
	public char getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(char currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	
}
