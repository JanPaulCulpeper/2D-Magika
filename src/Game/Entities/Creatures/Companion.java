//package Game.Entities.Creatures;
//
//import Game.Entities.EntityBase;
//import Game.GameStates.State;
//import Game.Inventories.Inventory;
//import Game.Items.Item;
//import Game.SpellCast.SpellCastUI;
//import Game.Tiles.Tile;
//import Resources.Animation;
//import Resources.Images;
//import Main.Handler;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.image.BufferedImage;
//
///**
// * Created by Elemental on 1/1/2017.
// */
//
//public class Companion extends CreatureBase {
//
//	//Animations
//	private Animation animDown, animUp, animLeft, animRight,animFireATT,animFireATTR,animFireATTU,animFireATTD;
//
//	// Attack
//
//
//	//Inventory
//	private Inventory inventory;
//
//	private SpellCastUI spellGUI;
//
//	private int fcounter = 0;
//	private Boolean fcactive=true;
//	private Boolean FireBall=false;
//	private Boolean LaunchedFireBall=false;
//	private Boolean LaunchedFireBallL=false;
//	private Boolean LaunchedFireBallR=false;
//	private Boolean LaunchedFireBallU=false;
//	private Boolean LaunchedFireBallD=false;
//	private Boolean attacking=false;
//	
//	public int counter=0;
//
//	private int animWalkingSpeed = 150;
//	private int animFireSpeed = 250;
//	private int FireSpeed = 2;
//	private int FireMove = 0;
//	private int movexp,moveyp,movexn,moveyn,tempmoveyp,tempmovexn,tempmoveyn,tempmovexp,fy,fx;
//	 
//	//COmpanion
//	private int direction;
//    private int moveCount=0;
//    private Rectangle CompanionCam;
//	//spells
//
//
//
//	public Companion(Handler handler, float x, float y) {
//		super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT);
//
//		bounds.x=8*2;
//		bounds.y=18*2;
//		bounds.width=16*2;
//		bounds.height=14*2;
//		health=75;
//		attack=2;
//		
//	    CompanionCam = new Rectangle();
//
//
//		animDown = new Animation(animWalkingSpeed,Images.Company_front);
//		animLeft = new Animation(animWalkingSpeed,Images.Company_left);
//		animRight = new Animation(animWalkingSpeed,Images.Company_right);
//		animUp = new Animation(animWalkingSpeed,Images.Company_back);
////		animFireATT = new Animation(animFireSpeed,Images.FireBallLeft);
////		animFireATTR = new Animation(animFireSpeed,Images.FireBallRight);
////		animFireATTU = new Animation(animFireSpeed,Images.FireBallUp);
////		animFireATTD = new Animation(animFireSpeed,Images.FireBallDown);
////
////		inventory= new Inventory(handler);
////		spellGUI= new SpellCastUI(handler);
//	}
//
//	@Override
//	public void tick() {
//	
////		Animations
//		animDown.tick();
//		animUp.tick();
//		animRight.tick();
//		animLeft.tick();
//		
////		 animDown.tick();
////	        animUp.tick();
////	        animRight.tick();
////	        animLeft.tick();
////
////
////		if(handler.getWorld().getEntityManager().getPlayer().CompanyStatus()== 1) {
////			  moveCount ++;
////			  if(moveCount>=60){
////		            moveCount=0;
////		           // direction = randint.nextInt(4) + 1;
////		        }
////		        checkIfMove();
////
////		        move();
//
////		Movement
//		
//		move();
//		handler.getGameCamera().centerOnEntity(this);
//
//		if(!fcactive){
//			fcounter++;
//		}
//		if(fcounter>=60){
//			fcounter=0;
//			fcactive=true;
//			FireBall=true;
//
//		}
//
//		if(FireBall){
//			FireMove++;
//		}
//
//		// Attack
////		if(handler.getKeyManager().attbut) {
////			checkAttacks();
////		}else if(handler.getKeyManager().fattbut){
////
////			fireAttack();
////
////		
////		}
//		}
//	
//	
//	private void checkIfMove() {
//        xMove = 0;
//        yMove = 0;
//
//        if(handler.getWorld().getEntityManager().getPlayer().CompanyStatus()== 1) {
//        CompanionCam.x = (int) (x - handler.getGameCamera().getxOffset() - (64 * 3));
//        CompanionCam.y = (int) (y - handler.getGameCamera().getyOffset() - (64 * 3));
//        CompanionCam.width = 64 * 7;
//        CompanionCam.height = 64 * 7;
//
//        if (CompanionCam.contains(handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset(), handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset())
//                || CompanionCam.contains(handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset() + handler.getWorld().getEntityManager().getPlayer().getWidth(), handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset() + handler.getWorld().getEntityManager().getPlayer().getHeight())) {
//
//            Rectangle cb = getCollisionBounds(0, 0);
//            Rectangle ar = new Rectangle();
//            int arSize = 13;
//            ar.width = arSize;
//            ar.height = arSize;
//
//            if (lu) {
//                ar.x = cb.x + cb.width / 2 - arSize / 2;
//                ar.y = cb.y - arSize;
//            } else if (ld) {
//                ar.x = cb.x + cb.width / 2 - arSize / 2;
//                ar.y = cb.y + cb.height;
//            } else if (ll) {
//                ar.x = cb.x - arSize;
//                ar.y = cb.y + cb.height / 2 - arSize / 2;
//            } else if (lr) {
//                ar.x = cb.x + cb.width;
//                ar.y = cb.y + cb.height / 2 - arSize / 2;
//            }
//
//            for (EntityBase e : handler.getWorld().getEntityManager().getEntities()) {
//                if (e.equals(this))
//                    continue;
//                if (e.getCollisionBounds(0, 0).intersects(ar) && e.equals(handler.getWorld().getEntityManager().getPlayer())) {
//
//                    checkAttacks();
//                    return;
//                }
//            }
//
//
//            if (x >= handler.getWorld().getEntityManager().getPlayer().getX() - 8 && x <= handler.getWorld().getEntityManager().getPlayer().getX() + 8) {//nada
//
//                xMove = 0;
//            } else if (x < handler.getWorld().getEntityManager().getPlayer().getX()) {//move right
//
//                xMove = speed;
//
//            } else if (x > handler.getWorld().getEntityManager().getPlayer().getX()) {//move left
//
//                xMove = -speed;
//            }
//
//            if (y >= handler.getWorld().getEntityManager().getPlayer().getY() - 8 && y <= handler.getWorld().getEntityManager().getPlayer().getY() + 8) {//nada
//                yMove = 0;
//            } else if (y < handler.getWorld().getEntityManager().getPlayer().getY()) {//move down
//                yMove = speed;
//
//            } else if (y > handler.getWorld().getEntityManager().getPlayer().getY()) {//move up
//                yMove = -speed;
//            }
//
//
//        } else {
//
//
//            switch (direction) {
//                case 1://up
//                    yMove = -speed;
//                    break;
//                case 2://down
//                    yMove = speed;
//                    break;
//                case 3://left
//                    xMove = -speed;
//                    break;
//                case 4://right
//                    xMove = speed;
//                    break;
//
//            }
//        }
//        }
//    }
//
//
//	@Override
//	public void render(Graphics g) {
//		
//    	if(handler.getWorld().getEntityManager().getPlayer().CompanyStatus()== 1) {
//
//		g.drawImage(getCurrentAnimationFrame(animDown,animUp,animLeft,animRight,Images.Company_front,Images.Company_back,Images.Company_left,Images.Company_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
//
////		if(FireBall){
////			FireBallAttack(g);
////
////		}
//
//
//
//
//		g.setColor(Color.BLACK);
//		g.drawRect((int)(x-handler.getGameCamera().getxOffset()-1),(int)(y-handler.getGameCamera().getyOffset()-21),76,11);
//		if(this.getHealth()>50){
//			g.setColor(Color.GREEN);
//			g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);
//
//		}else if(this.getHealth()>=15 && getHealth()<=50){
//			g.setColor(Color.YELLOW);
//			g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);
//
//		}else if(this.getHealth() < 15){
//			g.setColor(Color.RED);
//			g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);
//
//		}
//		g.setColor(Color.white);
//		g.drawString("Health: " + getHealth(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-10));
//
//
//
//	}
//	}
//
////	public void readyFireAttack(){
////		LaunchedFireBall=true;
////		movexp =(int) (x - handler.getGameCamera().getxOffset()) + 48;
////		moveyp =(int) (y - handler.getGameCamera().getyOffset()) + 64;
////		movexn =(int) (x - handler.getGameCamera().getxOffset()) - 48;
////		moveyn =(int) (y - handler.getGameCamera().getyOffset()) - 64;
////		tempmovexp =(int) (x - handler.getGameCamera().getxOffset()) + 48;
////		tempmoveyp =(int) (y - handler.getGameCamera().getyOffset()) + 64;
////		tempmovexn =(int) (x - handler.getGameCamera().getxOffset()) - 48;
////		tempmoveyn =(int) (y - handler.getGameCamera().getyOffset()) - 64;
////		LaunchedFireBallL=false;
////		LaunchedFireBallR=false;
////		LaunchedFireBallU=false;
////		LaunchedFireBallD=false;
////		fy=(int) (y - handler.getGameCamera().getyOffset()) + (height / 2);
////		fx=(int) (x - handler.getGameCamera().getxOffset()) + 16;
////	}
////	public void fireAttack() {
////
////		for (Item i : getInventory().getInventoryItems()) {
////			if (i.getName() == "Fire Rune"&&fcactive) {
////				attacking=true;
////				System.out.println("Burn");
////				i.setCount(i.getCount() - 1);
////				fcactive=false;
////				return;
////
////			}
////		}
////	}
//
//	@SuppressWarnings("Duplicates")
//	@Override
//	public void checkAttacks(){
//		attackTimer += System.currentTimeMillis() - lastAttackTimer;
//		lastAttackTimer = System.currentTimeMillis();
//		if(attackTimer < attackCooldown)
//			return;
//
//		Rectangle cb = getCollisionBounds(0, 0);
//		Rectangle ar = new Rectangle();
//		int arSize = 20;
//		ar.width = arSize;
//		ar.height = arSize;
//
//		if(lu ){
//			ar.x = cb.x + cb.width / 2 - arSize / 2;
//			ar.y = cb.y - arSize;
//		}else if(ld ){
//			ar.x = cb.x + cb.width / 2 - arSize / 2;
//			ar.y = cb.y + cb.height;
//		}else if(ll ){
//			ar.x = cb.x - arSize;
//			ar.y = cb.y + cb.height / 2 - arSize / 2;
//		}else if(lr ){
//			ar.x = cb.x + cb.width;
//			ar.y = cb.y + cb.height / 2 - arSize / 2;
//		}else{
//			return;
//		}
//
//		attackTimer = 0;
//
//		for(EntityBase e : handler.getWorld().getEntityManager().getEntities()){
//			if(e.equals(this))
//				continue;
//			if(e.getCollisionBounds(0, 0).intersects(ar)){
//				e.hurt(attack);
//				System.out.println(e + " has " + e.getHealth() + " lives.");
//				return;
//			}
//		}
//
//	}
//
//	@Override
//	public void die(){
//		System.out.println("Your companion is dead");
////		State.setState(handler.getGame().gamelose);
//	}
//	public void moveY(){
//        if(yMove < 0){//Up
//            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
//
//            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
//                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
//                y += yMove;
//            }else{
//                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
//            }
//
//        }else if(yMove > 0){//Down
//            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
//
//            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
//                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
//                y += yMove;
//            }else{
//                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
//            }
//
//        }
//    }
//    public void move(){
//        if(!checkEntityCollisions(xMove, 0f))
//            moveX();
//        if(!checkEntityCollisions(0f, yMove))
//            moveY();
//    }
//
//    public void moveX(){
//        if(xMove > 0){//Moving right
//            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
//
//            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
//                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
//                x += xMove;
//            }else{
//                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
//            }
//
//        }else if(xMove < 0){//Moving left
//            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
//
//            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
//                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
//                x += xMove;
//            }else{
//                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
//            }
//
//        }
//    }
//
//}