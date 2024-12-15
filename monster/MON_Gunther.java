package monster;

import java.util.Random;
import Entity.Entity;
import main.GamePanel;

public class MON_Gunther extends Entity {
    GamePanel gp;


    public MON_Gunther(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = 2;

        name = "Gunter";
        speed = 1;
        maxLife = 20;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 41;
        solidArea.height = 35;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    @Override
    public void getImage() {
        up1 = setup("/monster/Gunter-up1", gp.tileSize, gp.tileSize);
        up2 = setup("/monster/Gunter-up2", gp.tileSize, gp.tileSize);
        down1 = setup("/monster/Gunter-down1", gp.tileSize, gp.tileSize);
        down2 = setup("/monster/Gunter-down2", gp.tileSize, gp.tileSize);
        left1 = setup("/monster/Gunter-left1", gp.tileSize, gp.tileSize);
        left2 = setup("/monster/Gunter-left2", gp.tileSize, gp.tileSize);
        right1 = setup("/monster/Gunter-right1", gp.tileSize, gp.tileSize);
        right2 = setup("/monster/Gunter-right2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {
        actionLockCOunter++;
        if (actionLockCOunter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            } else if (i >= 25 && i <= 50) {
                direction = "down";
            } else if (i >= 50 && i <= 75) {
                direction = "left";

            } else if (i >= 75 && i <= 100) {
                direction = "right";

            }
            actionLockCOunter = 0;
        }
    }

    public void damageReaction() {

        actionLockCOunter = 0;
        direction = gp.player.direction;
    }
}
