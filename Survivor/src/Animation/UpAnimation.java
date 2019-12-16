package Animation;

import java.util.Set;

import Character.BarObstacle;
import Character.Survivor;
import Control.Gamemanager;
import javafx.animation.AnimationTimer;

public class UpAnimation {
	
	private AnimationTimer Animation;
	
	/**
	 * Constructor
	 * @param survivor 
	 * @param gamemanager game manager
	 * @param obstacles the set of obstacles
	 */
	public UpAnimation(Survivor survivor, Gamemanager gamemanager, Set<BarObstacle> obstacles){
		Animation = createAnimation(survivor, gamemanager, obstacles);
	}
	
	private AnimationTimer createAnimation(Survivor survivor, Gamemanager gamemanager,Set<BarObstacle> obstacles) {
		 double step = 5;
		 
		 return new AnimationTimer() {
	       	public void handle(long currentNanoTime)
	       	{
	       		if(survivor.getY() - step > 25) {
        			survivor.setY(survivor.getY() - step);
        		}
	       	}
		 };
	}
	
	
	/**
	 * getter
	 * @return the created animation
	 */
	public AnimationTimer getAnimation() {
		return Animation;
	}
}
