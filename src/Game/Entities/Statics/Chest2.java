package Game.Entities.Statics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Other;

import Game.Entities.Creatures.Player;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

public class Chest2 extends StaticEntity{

	private Rectangle ir = new Rectangle();
	public Boolean EP = false;
	public Boolean CI = false;
	static Item Item1;
	static Item Item2; 
	public static Item getItem1() {
		return Item1;
	}



	public static Item getItem2() {
		return Item2;
	}
	

	public static int Item1Amount=0;
	public static int Item2Amount=0;
	public int 	textBoxWidth = 300;
	public int textBowHeight= 80;

	public Chest2(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
		bounds.x=0;
		bounds.y=0;
		bounds.width = 80;
		bounds.height = 80;
		
		ir.width = bounds.width*3;
		ir.height = bounds.height*2;
		int irx=(int)(x-32-handler.getGameCamera().getxOffset());
		int iry= (int)(y-32-handler.getGameCamera().getyOffset());
		ir.y=iry;
		ir.x=irx;
	}



	@Override
	public void tick() {

		if(isBeinghurt()){
			setHealth(10);
		}


		if(handler.getKeyManager().attbut){
			EP=true;

		}else if(!handler.getKeyManager().attbut){
			EP=false;
		}
		
	}

	@Override
	public void render(Graphics g) {

		 Item1 = Item.Coin;
		 Item2 = Item.key;
		 if (String.valueOf(handler.getWorld()).contains("CaveWorld")) {
				Item1 = Item.rockItem;
				 Item2 = Item.compItem;
			}
		
		if (CI) {
			g.drawImage(Images.BunnyOpen,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),80,80,null);
			g.drawImage(Images.ChestUI,668,0,132,66,null);
			
		
	    	g.fillRect((int)(x-handler.getGameCamera().getxOffset())+100,(int)(y-handler.getGameCamera().getyOffset())-90, textBoxWidth,  textBowHeight);
	    	g.setColor(Color.YELLOW);
	    	g.drawRect((int)(x-handler.getGameCamera().getxOffset())+100,(int)(y-handler.getGameCamera().getyOffset())-90, textBoxWidth-2,  textBowHeight-2);
	    	g.setColor(Color.WHITE);
	    	g.setFont(new Font("Times New Roman",Font.BOLD,20));
	    	g.drawString("You can't leave",(int)(x-handler.getGameCamera().getxOffset())+140,(int)(y-handler.getGameCamera().getyOffset())-70);
	    	g.drawString("this world alone...",(int)(x-handler.getGameCamera().getxOffset())+140,(int)(y-handler.getGameCamera().getyOffset())-45);
	    	g.drawString("'G' key might be useful.",(int)(x-handler.getGameCamera().getxOffset())+140,(int)(y-handler.getGameCamera().getyOffset())-20);
	    	
		} else {
			g.drawImage(Images.GiveBunny,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),80,80,null);
		}

		checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
		    
		    	g.setFont(new Font("Times New Roman",Font.BOLD,15) );
		
	}
	
	private void checkForPlayer(Graphics g, Player p) {
		Rectangle pr = p.getCollisionBounds(0,0);

		if(ir.intersects(pr)&& !EP){
			g.drawImage(Images.E,(int) x+32,(int) y-32,32,32,null);

		}else if(ir.intersects(pr) && EP){
			CI = true;
		}
		if (!ir.intersects(pr)) {
			CI=false;
		}
	}

	

	public static int getItem1Amount() {
		return Item1Amount;
	}



	public static void setItem1Amount(int item1Amount) {
		Item1Amount = item1Amount;
	}



	public static int getItem2Amount() {
		return Item2Amount;
	}



	public static void setItem2Amount(int item2Amount) {
		Item2Amount = item2Amount;
	}



	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}


}