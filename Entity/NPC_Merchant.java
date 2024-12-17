package Entity;

import Obj.OBJ_Key;
import Obj.OBJ_Shield_Normal;
import Obj.OBJ_Stick;
import Obj.OBJ_Sword_Normal;
import Obj.OBJ_sanWitch;
import main.GamePanel;

public class NPC_Merchant extends Entity {
    public NPC_Merchant(GamePanel gp) {
        super(gp);

        // solidArea = new Rectangle();
        // solidArea.x = 0;
        // solidArea.y = 16;
        // solidAreaDefaultX = solidArea.x;
        // solidAreaDefaultY = solidArea.y;
        // solidArea.width = 32;
        // solidArea.height = 32;
        direction = "down";
        speed = 0;
        getImage();
        setDialogue();
        setItems();
    }

    @Override
    public void getImage() {

        up1 = setup("/NPC/jake-up1", gp.tileSize, gp.tileSize);
        up2 = setup("/NPC/jake-up2", gp.tileSize, gp.tileSize);
        down1 = setup("/NPC/jake-down1", gp.tileSize, gp.tileSize);
        down2 = setup("/NPC/jake-down2", gp.tileSize, gp.tileSize);
        left1 = setup("/NPC/jake-left-1", gp.tileSize, gp.tileSize);
        left2 = setup("/NPC/jake-left-2", gp.tileSize, gp.tileSize);
        right1 = setup("/NPC/jake-right-1", gp.tileSize, gp.tileSize);
        right2 = setup("/NPC/jake-right-2", gp.tileSize, gp.tileSize);

    }

    public void setDialogue() {

        dialogues[0] = "hehehe you found me!.";

    }

    public void setItems() {
        inventory.add(new OBJ_Shield_Normal(gp));
        inventory.add(new OBJ_Key(gp));
        inventory.add(new OBJ_sanWitch(gp));
        inventory.add(new OBJ_Stick(gp));
        inventory.add(new OBJ_Sword_Normal(gp));
    }

    public void speak() {

        super.speak();
        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }
}
