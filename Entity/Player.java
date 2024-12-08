package Entity;

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
        direnction = "down";
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
                direnction = "up";
            }
            if (keyH.downPressed == true) {
                direnction = "down";
            }
            if (keyH.rightPressed == true) {
                direnction = "right";
            }
            if (keyH.leftPressed == true) {
                direnction = "left";
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

            if (collisionOn == false) {
                switch (direnction) {
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

    }

    // object
    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    // npc
    public void interactNPC(int i) {
        if (i != 999) {
            System.out.println("Uy Fin!");
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direnction) {
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
        g2.drawImage(image, screenX, screenY, null);

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
