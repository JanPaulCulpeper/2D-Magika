package Worlds;
import java.awt.event.KeyEvent;

import Game.Entities.Creatures.Company;
import Game.Entities.Creatures.GoldenBoy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;

    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        
        
        
        entityManager.addEntity(new GoldenBoy(handler, 100, 500)); //new enemy in cave world 
            entityManager.addEntity(new Company(handler, 150, 500)); //new enemy in cave world 

        

    }


}