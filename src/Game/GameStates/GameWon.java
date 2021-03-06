package Game.GameStates;



import Main.Game;
import Resources.Images;
import UI.ClickListlener;
import UI.UIImageButton;
import UI.UIManager;
import Main.Handler;

import java.awt.*;

/**
 * Created by Elemental on 12/10/2016.
 */
public class GameWon extends State {

    private UIManager uiManager;

    public GameWon(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);


    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();

        // Temporarily just go directly to the GameState, skip the menu state!
        //handler.getMouseManager().setUimanager(null);
        //State.setState(handler.getGame().gameState);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.GameWon,0,0,800,600,null);
        uiManager.Render(g);

    }


}
