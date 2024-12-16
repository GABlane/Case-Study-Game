package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Stick extends Entity{
    public OBJ_Stick(GamePanel gp) {
        super(gp);
        type = type_stick;

        name = "Stick";
        down1 = setup("/Objects/Stick", gp.tileSize, gp.tileSize);
        attackValue = 1;
        description = "[ " + name + " ]";
        attackArea.width =25;
        attackArea.height =25;
    }
}
