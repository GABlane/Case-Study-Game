package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {
    GamePanel gp;

    public OBJ_Key(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "Key";
        down1 = setup("/Objects/Key", gp.tileSize, gp.tileSize);
        description = "[ " + name + " ]";

    }

    public boolean use(Entity entity) {
        gp.gameState = gp.dialogueState;

        int objIndex = getDetected(entity, gp.obj, "Door");

        if (objIndex != 999) {
            gp.ui.currentDialogue = "you used the " + name;
            gp.obj[gp.currentMap][objIndex] = null;
            return true;
        } else {
            gp.ui.currentDialogue = "YOU OK??";
            return false;
        }
    }
}
