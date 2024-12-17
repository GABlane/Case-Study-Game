package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_COIN extends Entity {
    GamePanel gp;

    public OBJ_COIN(GamePanel gp) {
        super(gp);
        this.gp = gp;

        value = 5;
        type = type_pickUpOnly;
        name = "Gold Coin";
        down1 = setup("/Objects/bronzecoin", gp.tileSize, gp.tileSize);
    }

    public boolean use(Entity entity) {
        gp.playerSE(4);
        gp.ui.addMessage("Coin + " + value);
        gp.player.coin += value;
        return true;
    }
}
