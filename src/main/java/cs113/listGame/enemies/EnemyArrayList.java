package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.FollowObject;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import cs113.listGame.gamecore.GameObject;
import cs113.listGame.gamecore.PlayerObject;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class EnemyArrayList extends EnemyObject {
    public EnemyArrayList(ImageView imageView) { super(imageView); }

    private PlayerObject player;
    ArrayList<Behavior> behaviors =  new ArrayList<>();
    Random random = new Random();

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(random.nextDouble(700), random.nextDouble(800));
        //Point2D dest1 = new Point2D(player.echoPosition);

        behaviors.add(0,new Waiting(this, (long) random.nextDouble(750)));
        behaviors.add(1,new MoveToPoint(this,(long)random.nextDouble(4000),dest));
        behaviors.add(2,new Waiting(this, (long) random.nextDouble(750)));
        //behaviors.add(3,new FollowObject(this, random.nextLong(3000),player));
    }

    @Override
    public Behavior getNextBehavior() {
        if(behaviors.isEmpty()){
            return null;
        }
        int index = random.nextInt(behaviors.size());
        return behaviors.get(index);
    }
}