package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity {

    GamePanel gp;
    Entity loot;
    boolean opened = false;

    public OBJ_Chest(GamePanel gp) {

        super(gp);
        this.gp = gp;
        this.loot = loot;

        type = type_Obstacle;
        name = "Chest";
        image = setup("/Objects/Chest", gp.tileSize, gp.tileSize);
        image2 = setup("/Objects/Open_Chest", gp.tileSize, gp.tileSize);
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
            StringBuilder sb = new StringBuilder();

            sb.append("You open the chest and found " + loot.name);
            if (gp.player.inventory.size() == gp.player.maxInventorySize) {
                sb.append("\n... you canoot carry anymore");
            } else {
                sb.append("you obtain the" + loot.name);
                gp.player.inventory.add(loot);
                down1 = image2;
                opened = true;
            }
            gp.ui.currentDialogue = sb.toString();
        } else {
            gp.ui.currentDialogue = "already opened";
        }

    }
}
