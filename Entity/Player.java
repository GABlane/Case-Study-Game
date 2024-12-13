package Entity;

import java.awt.AlphaComposite;
// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    // public int hasKey = 0;

    int nspeed = 5;

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 16, gp.tileSize - 10, gp.tileSize - 10);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getImage();
    }

    void setDefaultValues() {
        worldX = gp.tileSize * 26;
        worldY = gp.tileSize * 24;
        speed = 5;
        direction = "down";

        // player status
        maxLife = 6;
        life = maxLife;
    }

    @Override
    public void getImage() {

        up = setup("/player/up");
        down = setup("/player/down");
        left1 = setup("/player/left1");
        left2 = setup("/player/left2");
        right1 = setup("/player/right1");
        right2 = setup("/player/right2");

    }

    @Override
    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
                || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            }
            if (keyH.downPressed == true) {
                direction = "down";
            }
            if (keyH.rightPressed == true) {
                direction = "right";
            }
            if (keyH.leftPressed == true) {
                direction = "left";
            }

            trapSeconds++;
            if (trapSeconds == 200) {
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            int npcIndex = gp.cChecker.checkEntity(this, gp.Npc);
            interactNPC(npcIndex);

            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            // event checker
            gp.eHandler.checkEvent();

            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    default:
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if (invisible == true) {
            invisibleCounter++;
            if (invisibleCounter == 90) {
                invisible = false;
                invisibleCounter = 0;
            }
        }
    }

    // object
    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    // npc
    public void interactNPC(int i) {
        if (i != 999) {

            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.dialogueState;
                gp.Npc[i].speak();
            }

        }
        gp.keyH.enterPressed = false;
    }

    public void contactMonster(int i) {

        if (i != 999) {
            if (invisible == false) {
                life -= 1;
                invisible = true;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up;
                break;
            case "down":
                image = down;
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        if (invisible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }

        g2.drawImage(image, screenX, screenY, null);

        // reset oppacity
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        // g2.setFont(new Font("Arial", Font.PLAIN, 20));
        // g2.setColor(Color.black);
        // g2.drawString("invinsible counter:" + invisibleCounter, 400, 400);
    }
}
