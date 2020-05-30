package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameBean {
	char winner;
	boolean isGameOver;
	boolean isGameDraw;
	boolean isMoveValid;
	char currentPlayer;
	boolean isBoardFull;
	Map<Integer, Character> matrix;
	char[][] grid;
	
	public GameBean() {
		setCurrentPlayer('O');
		matrix = new HashMap<>();
		grid = new char[3][3];
		matrix.put(0, '-');
		matrix.put(1, '-');
		matrix.put(2, '-');
		matrix.put(3, '-');
		matrix.put(4, '-');
		matrix.put(5, '-');
		matrix.put(6, '-');
		matrix.put(7, '-');
		matrix.put(8, '-');
	}
	
	public Map<Integer, Character> getMatrix() {
		return matrix;
	}

	public void setMatrix(Map<Integer, Character> matrix) {
		this.matrix = matrix;
	}

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
	
	public boolean isBoardFull() {
		checkBoard();
		return isBoardFull;
	}

	public void setBoardFull(boolean isBoardFull) {
		this.isBoardFull = isBoardFull;
	}
	
	public void checkResults() {
		checkWinner();
		if(getWinner() != 'X' && getWinner() != 'O') {
			if(isBoardFull()) {
				setGameDraw(true);
				setGameOver(true);
			}
		}
		else {
			setGameOver(true);
		}
	}
	
	public void checkBoard() {
		if(matrix.get(0) != '-' && matrix.get(1) != '-' && matrix.get(2) != '-'
			&& matrix.get(3) != '-' && matrix.get(4) != '-' && matrix.get(5) != '-'
			&& matrix.get(6) != '-' && matrix.get(7) != '-' && matrix.get(8) != '-')
			setBoardFull(true);
		else setBoardFull(false);
	}
	
	public void markLocation(int location, char player) {
		switch(location) {
			case 0:grid[0][0] = player; break;
			case 1:grid[0][1] = player; break;
			case 2:grid[0][2] = player; break;
			case 3:grid[1][0] = player; break;
			case 4:grid[1][1] = player; break;
			case 5:grid[1][2] = player; break;
			case 6:grid[2][0] = player; break;
			case 7:grid[2][1] = player; break;
			case 8:grid[2][2] = player; break;
		}
	}
	
	public void checkWinner() {
		char current;
		
		//rows check
		for(int i = 0; i < 3; i++) {
			current = grid[i][0];
			if(grid[i][1] == current && grid[i][2] == current) {
				setWinner(current);
				break;
			}
		}
		if(getWinner() == 'X' || getWinner() == 'O') return;
		
		//columns check
		for(int j = 0; j < 3; j++) {
			current = grid[0][j];
			if(grid[1][j] == current && grid[2][j] == current) {
				setWinner(current);
				break;
			}
		}
		if(getWinner() == 'X' || getWinner() == 'O') return;
		
		//diagonal
		current = grid[0][0];
		if(grid[1][1] == current && grid[2][2] ==current) {
			setWinner(current);
		}
		if(getWinner() == 'X' || getWinner() == 'O') return;
		
		//diagonal
		current = grid[2][0];
		if(grid[1][1] == current && grid[0][2] ==current) {
			setWinner(current);
		}
		
	}
	
	public static void main(String[] args) {
		char[][] matrix = new char[3][3];
		System.out.println(Arrays.toString(matrix));
	}
	
}
