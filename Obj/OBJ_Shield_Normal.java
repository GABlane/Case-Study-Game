package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Normal extends Entity {

    public OBJ_Shield_Normal(GamePanel gp) {
        super(gp);

        name = "Golden Shield";
        down1 = setup("/Objects/shield", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[ " + name + " ]";
    }
}
