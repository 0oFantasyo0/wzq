package com.wuziqi.love.fantasy.faith.player.interfaces;

import com.wuziqi.love.fantasy.faith.IChessboard;
import com.wuziqi.love.fantasy.faith.Point;

import java.util.List;


public interface IPlayer {
	//下一步棋子，传入对手已经下的棋子集合
	public void run(List<Point> enemyPoints, Point point);

	public boolean hasWin();

	public void setChessboard(IChessboard chessboard);

	public List<Point> getMyPoints();
}
