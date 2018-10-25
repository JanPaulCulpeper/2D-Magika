package Worlds;
import java.awt.event.KeyEvent;

import Game.Entities.Creatures.Company;
import Game.Entities.Creatures.Goblin;
import Game.Entities.Creatures.GoldenBoy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
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
            entityManager.addEntity(new Company(handler, 150, 500)); //new enemy in cave world 
            entityManager.addEntity(new Goblin(handler, 100, 1000)); //new enemy in cave world 
            entityManager.addEntity(new Goblin(handler, 500, 1000)); //new enemy in cave world 
         

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }


}