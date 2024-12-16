package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity {

    public OBJ_Sword_Normal(GamePanel gp) {
        super(gp);

        name = "Golden Sword";
        down1 = setup("/Objects/sword", gp.tileSize, gp.tileSize);
        attackValue = 2;
        description = "[ " + name + " ]";
    }
}
