package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Hole extends Entity {

    public OBJ_Hole(GamePanel gp) {
        super(gp);
        name = "Hole";

        down1 = setup("/Objects/Hole", gp.tileSize, gp.tileSize);

    }
}
