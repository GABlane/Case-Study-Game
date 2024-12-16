package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {
    GamePanel gp;

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickUpOnly;
        name = "Heart";
        value = 1;
        down1 = setup("/Objects/Full_Heart", gp.tileSize, gp.tileSize);
        image = setup("/Objects/Full_Heart", gp.tileSize, gp.tileSize);
        image2 = setup("/Objects/Haft_Heart", gp.tileSize, gp.tileSize);
        image3 = setup("/Objects/Empty_Heart", gp.tileSize, gp.tileSize);

    }

    public void use(Entity entity) {
        // gp.playSE();
        gp.ui.addMessage("Life +" + value);
        entity.life += value;
    }
}