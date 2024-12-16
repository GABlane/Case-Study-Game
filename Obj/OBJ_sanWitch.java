package Obj;

import Entity.Entity;
import main.GamePanel;

public class OBJ_sanWitch extends Entity {
    GamePanel gp;

    public OBJ_sanWitch(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_consumable;
        value = 5;
        name = "San Witch";
        down1 = setup("/Objects/sandwitch", gp.tileSize, gp.tileSize);
        description = "[ " + name + " ]";
    }

    public void use(Entity entity) {
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You ate the " + name + "!\n" + "Your life has been recovered by " + value + ".";
        entity.life += value;
        if (gp.player.life > gp.player.maxLife) {
            gp.player.life = gp.player.maxLife;
        }
        // SFX
    }
}
