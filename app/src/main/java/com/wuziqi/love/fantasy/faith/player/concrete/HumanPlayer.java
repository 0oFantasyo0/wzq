package com.wuziqi.love.fantasy.faith.player.concrete;

import com.wuziqi.love.fantasy.faith.Point;
import com.wuziqi.love.fantasy.faith.player.base.BasePlayer;
import com.wuziqi.love.fantasy.faith.player.interfaces.IPlayer;

import java.util.List;



public class HumanPlayer extends BasePlayer implements IPlayer {

	@Override
	public void run(List<Point> enemyPoints, Point p) {
		getMyPoints().add(p);
		allFreePoints.remove(p);
	}
}
