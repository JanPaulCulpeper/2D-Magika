package Game.Inventories;

import Game.Entities.Creatures.Player;
import Game.Entities.Statics.Chest;
import Game.GameStates.State;
import Game.Items.Item;
import Game.SpellCast.FireBallSpell;
import Resources.Images;
import UI.UIInventory;
import UI.UIManager;
import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Elemental on 1/3/2017.
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;
    private UIManager uiManager;
    private ArrayList<Item> inventoryItems;
    

    public Inventory(Handler handler){

        this.handler=handler;
        inventoryItems = new ArrayList<>();

        uiManager = new UIManager(handler);

        uiManager.addObjects(new UIInventory(0,0, 329, 265, Images.inventory,() -> {
        }));
    }
//    public void XaddItems() {
//    //Add all items when X is pressed
//    	
//    if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_X)) {
//    	for(Item i : inventoryItems){
//    	 handler.getWorld().getItemManager().;
//    }}
//    }

    public void tick() {
    	for(Item i: inventoryItems) {
    		if(i.getId()== Item.Trophy.getId() && i.getCount()==2) {
    			State.setState(handler.getGame().gamewon);
    		}
    	
    	}

        for(Item i : inventoryItems){
            if(i.getCount()==0){
                inventoryItems.remove(inventoryItems.indexOf(i));
                return;
            }
            
            if(i.getId() == 4) {
            	Player e = handler.getWorld().getEntityManager().getPlayer();
    			if (!(e.getHealth()==75)) {
    				e.setHealth(75);
    				i.setCount(i.getCount()-1);
            }
    		
        }
        }

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)){
            active=!active;
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().setActive(false);

        }
        

        if(!active){
            return;
        }
        
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_SPACE)) {
        	ChestInventory();
        }

        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();



    }

    public void render(Graphics g) {

        if(!active){
            uiManager.isActive(uiManager.getObjects(),false);
            return;
        }



        uiManager.isActive(uiManager.getObjects(),true);
        uiManager.Render(g);
        g.setColor(Color.white);
        renderItems(g);


    }

    //Inventory Methods
    private void renderItems(Graphics g) {

        if (inventoryItems.size() == 1) {
            g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
        }else if(inventoryItems.size() == 2) {
            g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
            g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
        }else if(inventoryItems.size() == 3) {
            g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
            g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
            g.drawImage(inventoryItems.get(2).getTexture(), 147, 24, inventoryItems.get(2).getWidth(), inventoryItems.get(2).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147+33,24+35);
        }else if(inventoryItems.size() == 4) {
            g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
            g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
            g.drawImage(inventoryItems.get(2).getTexture(), 147, 24, inventoryItems.get(2).getWidth(), inventoryItems.get(2).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147+33,24+35);
            g.drawImage(inventoryItems.get(3).getTexture(), 208, 24, inventoryItems.get(3).getWidth(), inventoryItems.get(3).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208+33,24+35);
        }else if(inventoryItems.size() == 5) {
                g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
                g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
                g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
                g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
                g.drawImage(inventoryItems.get(2).getTexture(), 147, 24, inventoryItems.get(2).getWidth(), inventoryItems.get(2).getHeight(), null);
                g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147+33,24+35);
                g.drawImage(inventoryItems.get(3).getTexture(), 208, 24, inventoryItems.get(3).getWidth(), inventoryItems.get(3).getHeight(), null);
                g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208+33,24+35);
                g.drawImage(inventoryItems.get(4).getTexture(), 269, 24, inventoryItems.get(4).getWidth(), inventoryItems.get(4).getHeight(), null);
                g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269+33,24+35);
        }else if(inventoryItems.size() == 6) {
            g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
            g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
            g.drawImage(inventoryItems.get(2).getTexture(), 147, 24, inventoryItems.get(2).getWidth(), inventoryItems.get(2).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147+33,24+35);
            g.drawImage(inventoryItems.get(3).getTexture(), 208, 24, inventoryItems.get(3).getWidth(), inventoryItems.get(3).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208+33,24+35);
            g.drawImage(inventoryItems.get(4).getTexture(), 269, 24, inventoryItems.get(4).getWidth(), inventoryItems.get(4).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269+33,24+35);
            g.drawImage(inventoryItems.get(5).getTexture(), 25, 80, inventoryItems.get(5).getWidth(), inventoryItems.get(5).getHeight(), null);
            g.drawString(String.valueOf(inventoryItems.get(5).getCount()), 25+33,80+35);
    }else if(inventoryItems.size() == 7) {
        g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
        g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
        g.drawImage(inventoryItems.get(2).getTexture(), 147, 24, inventoryItems.get(2).getWidth(), inventoryItems.get(2).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147+33,24+35);
        g.drawImage(inventoryItems.get(3).getTexture(), 208, 24, inventoryItems.get(3).getWidth(), inventoryItems.get(3).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208+33,24+35);
        g.drawImage(inventoryItems.get(4).getTexture(), 269, 24, inventoryItems.get(4).getWidth(), inventoryItems.get(4).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269+33,24+35);
        g.drawImage(inventoryItems.get(5).getTexture(), 25, 80, inventoryItems.get(5).getWidth(), inventoryItems.get(5).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(5).getCount()), 25+33,80+35);
        g.drawImage(inventoryItems.get(6).getTexture(), 80, 80, inventoryItems.get(6).getWidth(), inventoryItems.get(6).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(6).getCount()), 80+33,80+35);
    }else if(inventoryItems.size() == 8) {
        g.drawImage(inventoryItems.get(0).getTexture(), 25, 24, inventoryItems.get(0).getWidth(), inventoryItems.get(0).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(0).getCount()), 25+33,25+35);
        g.drawImage(inventoryItems.get(1).getTexture(), 86, 24, inventoryItems.get(1).getWidth(), inventoryItems.get(1).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(1).getCount()), 86+33,24+35);
        g.drawImage(inventoryItems.get(2).getTexture(), 147, 24, inventoryItems.get(2).getWidth(), inventoryItems.get(2).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(2).getCount()), 147+33,24+35);
        g.drawImage(inventoryItems.get(3).getTexture(), 208, 24, inventoryItems.get(3).getWidth(), inventoryItems.get(3).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(3).getCount()), 208+33,24+35);
        g.drawImage(inventoryItems.get(4).getTexture(), 269, 24, inventoryItems.get(4).getWidth(), inventoryItems.get(4).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(4).getCount()), 269+33,24+35);
        g.drawImage(inventoryItems.get(5).getTexture(), 25, 80, inventoryItems.get(5).getWidth(), inventoryItems.get(5).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(5).getCount()), 25+33,80+35);
        g.drawImage(inventoryItems.get(6).getTexture(), 80, 80, inventoryItems.get(6).getWidth(), inventoryItems.get(6).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(6).getCount()), 80+33,80+35);
        g.drawImage(inventoryItems.get(7).getTexture(), 145, 80, inventoryItems.get(7).getWidth(), inventoryItems.get(7).getHeight(), null);
        g.drawString(String.valueOf(inventoryItems.get(7).getCount()), 145+33,80+35);
    }
                
            
          

    }
    

    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(1+item.getCount());
                return;
            }
        }
        if(item.getId()==2){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new FireBallSpell(handler));
        }
        inventoryItems.add(item);
        
    }
    
    public void ChestInventory() {
		int Amount1= Chest.getItem1Amount();
		int Amount2 = Chest.getItem2Amount();
		int Item1Id = Chest.getItem1().getId();
		int Item2Id = Chest.getItem2().getId();

		for(Item i : inventoryItems){
			if((i.getId() == Item1Id)&&(Amount1<3)){
				switch (i.getCount()) {
				case 0 :
					//do nothing
					break;
				case 1:
					Chest.setItem1Amount(Amount1+1);
					i.setCount(i.getCount()-1);
					break;

				case 2:
					if (Amount1==2) {
						Chest.setItem1Amount(Amount1+1);
						i.setCount(i.getCount()-1);
						break;
					}else {
						Chest.setItem1Amount(Amount1+2);
						i.setCount(i.getCount()-2);
					}
					break;
				default:
					switch (Amount1) {
					case 0:
						Chest.setItem1Amount(Amount1+3);
						i.setCount(i.getCount()-3);
						break;
					case 1:
						Chest.setItem1Amount(Amount1+2);
						i.setCount(i.getCount()-2);
						break;
					case 2:
						Chest.setItem1Amount(Amount1+1);
						i.setCount(i.getCount()-1);
						break;

					}
					break;
				}

			}
			if((i.getId() == Item2Id)&&(Amount2<3)){
				switch (i.getCount()) {
				case 0 :
					//do nothing
					break;
				case 1:
					Chest.setItem2Amount(Amount2+1);
					i.setCount(i.getCount()-1);
					break;


				default:
					switch (Amount2) {
					case 0:
						Chest.setItem2Amount(Amount2+1);
						i.setCount(i.getCount()-1);
						break;

					}
					break;
				}

				return;

			}
		}
		

	}
    
    public boolean CompStatus() {
    	if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)) {
    	for( Item i : inventoryItems) {
    		if( i.getId() == 6  ) {
    			return true;
    	}
    	
	}
    	
    }
    	return false;
    }
  
    

    //GET SET
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getInventoryItems(){
        return inventoryItems;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
