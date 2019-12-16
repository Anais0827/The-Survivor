package Control;

import java.util.Set;

import Animation.DownAnimation;
import Animation.LeftAnimation;
import Animation.RightAnimation;
import Animation.UpAnimation;
import Character.BarObstacle;
import Character.Enemy;
import Character.Survivor;
import Scene.Background;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Gamemanager {
	private Group root;
	private Set<BarObstacle> obstacles;
	private Background background;
	private Survivor survivor;
	private Enemy enemy;
	private AnimationTimer leftAnimation;
    private AnimationTimer rightAnimation;
    private AnimationTimer upAnimation;
    private AnimationTimer downAnimation;
	
	public Gamemanager(Group root) {
		this.root = root;
		this.background = new Background();
		background.createBackground(root);
		this.survivor = background.getSurvivor();
		this.enemy = background.getEnemy();
		this.leftAnimation = new LeftAnimation(this.survivor, this, this.obstacles).getAnimation();
        this.rightAnimation = new RightAnimation(this.survivor, this, this.obstacles).getAnimation();
        this.upAnimation = new UpAnimation(this.survivor, this, this.obstacles).getAnimation();
        this.downAnimation = new DownAnimation(this.survivor, this, this.obstacles).getAnimation();
	}
	
	public void moveSurvivor(KeyEvent event) {
        enemy.run();
        
        switch(event.getCode()) {
            case RIGHT:
                this.rightAnimation.start();
                break;
            case LEFT:
                this.leftAnimation.start();
                break;
            case UP:
                this.upAnimation.start();
                break;
            case DOWN:
                this.downAnimation.start();
                break;
		default:
			break;
        }
    }


    public void stopSurvivor(KeyEvent event) {   	
        switch(event.getCode()) {
            case RIGHT:
                this.rightAnimation.stop();
                break;
            case LEFT:
                this.leftAnimation.stop();
                break;
            case UP:
                this.upAnimation.stop();
                break;
            case DOWN:
                this.downAnimation.stop();
                break;
            default:
            	break;
        }
    }
}
