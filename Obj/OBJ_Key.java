package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Key extends Entity {

    public OBJ_Key(GamePanel gp) {

        super(gp);
        name = "Key";
        down1 = setup("/Objects/Key.png", gp.tileSize, gp.tileSize);

    }
}
