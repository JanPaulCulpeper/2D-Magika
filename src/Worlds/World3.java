package Worlds;
import java.awt.event.KeyEvent;

import Game.Entities.Creatures.Company;
import Game.Entities.Creatures.Goblin;
import Game.Entities.Creatures.GoldenBoy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Chest2;
import Game.Entities.Statics.Chest3;
import Game.Entities.Statics.Rock;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class World3 extends BaseWorld{
    private Handler handler;


    public World3(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        
        
        
        
        	entityManager.addEntity(new GoldenBoy(handler, 600, 500)); //new enemy in cave world
        	entityManager.addEntity(new GoldenBoy(handler, 600, 800)); //new enemy in cave world 
        	 entityManager.addEntity(new Company(handler, spawnX + 100, spawnY - 50)); //new enemy in cave world 
            entityManager.addEntity(new Goblin(handler, 125, 1000)); //new enemy in cave world 
            entityManager.addEntity(new Goblin(handler, 500, 1000)); //new enemy in cave world 
            entityManager.addEntity(new Chest3(handler, 250, 100));
            
            entityManager.addEntity(new Rock(handler, 70, 250));
            
            entityManager.addEntity(new Rock(handler, 70, 1025));
            entityManager.addEntity(new Rock(handler, 70, 1100));
            
            entityManager.addEntity(new Rock(handler, 125, 900));
            
          
            entityManager.addEntity(new Rock(handler, 440, 900));
            entityManager.addEntity(new Rock(handler, 450, 760));
            entityManager.addEntity(new Rock(handler, 580, 900));
       
            
         

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }


}