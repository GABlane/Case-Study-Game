package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Boots extends Entity {

    public OBJ_Boots(GamePanel gp) {
        super(gp);
        name = "Boot";
        down = setup("/Objects/Boot");
    }
}
