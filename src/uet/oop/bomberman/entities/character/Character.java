package uet.oop.bomberman.entities.character;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.AnimatedEntitiy;
import uet.oop.bomberman.graphics.Screen;

// including Bomber and Enemy
public abstract class Character extends AnimatedEntitiy {
	
	protected Board _board;
	protected int _direction = -1;
	protected boolean _alive = true;
	protected boolean _moving = false;
	public int _timeAfter = 40;
	
	public Character(int x, int y, Board board) {
		_x = x;
		_y = y;
		_board = board;
	}
	
	@Override
	public abstract void update();
	
	@Override
	public abstract void render(Screen screen);

	//calculate the direction
	protected abstract void calculateMove();
	
	protected abstract void move(double xa, double ya);

	//when object die 
	public abstract void kill();

	protected abstract void afterKill();

	/**
	 * Kiểm tra xem đối tượng có di chuyển tới vị trí đã tính toán hay không
	 * @param x
	 * @param y
	 * @return
	 */
	protected abstract boolean canMove(double x, double y);

	protected double getXMessage() {
		return (_x * Game.SCALE) + (_sprite.SIZE / 2 * Game.SCALE);
	}
	
	protected double getYMessage() {
		return (_y* Game.SCALE) - (_sprite.SIZE / 2 * Game.SCALE);
	}
	
}
