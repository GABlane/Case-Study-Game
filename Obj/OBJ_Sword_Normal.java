package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity {

    public OBJ_Sword_Normal(GamePanel gp) {
        super(gp);
        type = type_sword;
        name = "Golden Sword";
        down1 = setup("/Objects/sword", gp.tileSize, gp.tileSize);
        attackArea.width =36;
        attackArea.height =36;
        attackValue = 2;
        description = "[ " + name + " ]";
    }
}
