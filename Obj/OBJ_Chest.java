package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity {

    public OBJ_Chest(GamePanel gp) {
        super(gp);
        name = "Chest";
        down1 = setup("/Objects/Chest", gp.tileSize, gp.tileSize);

        collision = true;
    }
}
