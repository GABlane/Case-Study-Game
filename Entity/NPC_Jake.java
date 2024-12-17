package Entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Jake extends Entity {

    public NPC_Jake(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 2;
        getImage();
        setDialogue();
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

        dialogues[0] = "Hello, FINN!.";
        dialogues[1] = "SO YOU'VE COME FOR \nANOTHER ADVENTURE?";
        dialogues[2] = "GO SAVE PRINCESS BUBBLE GUM \nFROM THAT EVIL ICEKING.";
        dialogues[3] = "Well, goodluck to you. \n\nI'll go to lady unicord";

    }

    @Override
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

    public void speak() {
        super.speak();
    }
}
