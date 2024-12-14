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

        up = setup("/NPC/jake-up",gp.tileSize,gp.tileSize);
        down = setup("/NPC/jake-1",gp.tileSize,gp.tileSize);
        left1 = setup("/NPC/jake-left-1",gp.tileSize,gp.tileSize);
        left2 = setup("/NPC/jake-left-2",gp.tileSize,gp.tileSize);
        right1 = setup("/NPC/jake-right-1",gp.tileSize,gp.tileSize);
        right2 = setup("/NPC/jake-right-2",gp.tileSize,gp.tileSize);

    }

    public void setDialogue() {

        dialogues[0] = "Hello, my nigga.";
        dialogues[1] = "So you've come to this island to \nfind the treasure?";
        dialogues[2] = "I used to be a great nigga but now... \nI'm a bit too old for taking an adventure.";
        dialogues[3] = "Well, goodluck on you.";

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
