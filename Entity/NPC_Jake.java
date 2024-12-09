package Entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Jake extends Entity {

    public NPC_Jake(GamePanel gp) {
        super(gp);

        direnction = "down";
        speed = 2;
        getImage();
        setDialogue();
    }

    @Override
    public void getImage() {

        up = setup("/NPC/jake-up");
        down = setup("/NPC/jake-1");
        left1 = setup("/NPC/jake-left-1");
        left2 = setup("/NPC/jake-left-2");
        right1 = setup("/NPC/jake-right-1");
        right2 = setup("/NPC/jake-right-2");

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
                direnction = "up";
            } else if (i >= 25 && i <= 50) {
                direnction = "down";
            } else if (i >= 50 && i <= 75) {
                direnction = "left";

            } else if (i >= 75 && i <= 100) {
                direnction = "right";

            }
            actionLockCOunter = 0;
        }

    }

    public void speak() {

        super.speak();
    }
}
