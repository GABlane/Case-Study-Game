package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);

        name = "Heart";
        image = setup("/Objects/Full_Heart");
        image2 = setup("/Objects/Haft_Heart");
        image3 = setup("/Objects/Empty_Heart");

    }
}