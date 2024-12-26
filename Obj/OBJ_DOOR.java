package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_DOOR extends Entity {

    GamePanel gp;

    public OBJ_DOOR(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_Obstacle;
        name = "Door";
        down1 = setup("/Objects/door", gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    // @Override
    public void interact() {
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You need a key to open this";

    }
}
