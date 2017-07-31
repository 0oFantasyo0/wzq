package com.wuziqi.love.fantasy.faith.player;

import com.wuziqi.love.fantasy.faith.player.concrete.SunWuKongAi;
import com.wuziqi.love.fantasy.faith.player.concrete.ZhuBaJieAi;
import com.wuziqi.love.fantasy.faith.player.interfaces.IPlayer;

import java.util.HashMap;
import java.util.Map;


//电脑AI工厂类
public class AiFactory {
	private final static Map<Integer,IPlayer> ais = new HashMap<Integer, IPlayer>(2);
	//工厂方法，数字越大，难度越高
	public static IPlayer getInstance(int level){
		IPlayer ai = ais.get(level);
		if(ai==null){
			switch (level) {
				case 1:
					ais.put(level, new ZhuBaJieAi());
					break;
				case 2:
					ais.put(level, new SunWuKongAi());
					break;
			}
		}
		return ais.get(level);
	}
}
