package Worlds;
import java.awt.event.KeyEvent;

import Game.Entities.Creatures.Company;
import Game.Entities.Creatures.GoldenBoy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.CoinBlock;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;
    private BaseWorld world3;


    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        
        world3 = new World3(handler,"res/Maps/map3",player);

        
        
        entityManager.addEntity(new GoldenBoy(handler, 100, 500)); //new enemy in cave world 
            entityManager.addEntity(new Company(handler, 150, 500)); //new enemy in cave world 
            entityManager.addEntity(new Door(handler, 100, 0,world3)); //new enemy in cave world 
            entityManager.addEntity(new Chest(handler, 250, 100));
            entityManager.addEntity(new CoinBlock(handler, 1300, 800));
            entityManager.addEntity(new CoinBlock(handler, 800, 500));
            entityManager.addEntity(new CoinBlock(handler, 100, 1220));
            entityManager.addEntity(new Tree(handler, 765, 888));
            entityManager.addEntity(new Rock(handler, 88, 1345));
            entityManager.addEntity(new Tree(handler, 77, 700));


        

    }


}