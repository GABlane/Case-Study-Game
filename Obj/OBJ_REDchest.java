package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_REDchest extends Entity {
    GamePanel gp;
    boolean opened = false;

    public OBJ_REDchest(GamePanel gp) {

        super(gp);
        this.gp = gp;

        type = type_Obstacle;
        name = "Chest";
        image = setup("/Objects/red_chest", gp.tileSize, gp.tileSize);
        image2 = setup("/Objects/red_chest_opened", gp.tileSize, gp.tileSize);
        down1 = image;
        collision = true;

        solidArea.x = 4;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void interact() {
        gp.gameState = gp.dialogueState;
        if (opened == false) {
            gp.ui.currentDialogue = "CONGRATULATION YOU COMPLETED THE GAME FOR NOW!..";
            gp.gameState = gp.gameOverState;
        } else {
            gp.ui.currentDialogue = "already opened";
        }

    }
}
