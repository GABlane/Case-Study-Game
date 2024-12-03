package Entity;

// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;

    public int hashkey = 0;
    int nspeed = 5;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 16, gp.tileSize - 10, gp.tileSize - 10);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    void setDefaultValues() {
        worldX = gp.tileSize * 26;
        worldY = gp.tileSize * 24;
        speed = 5;
        direnction = "down";
    }

    public void getPlayerImage() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/res/player/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/res/player/down.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
                trapSeconds = 0;
                speed = nspeed;
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

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

    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Key":

                    hashkey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Got A Key");
                    break;
                case "Door":
                    if (hashkey > 0) {
                        gp.obj[i] = null;
                        hashkey--;
                        gp.ui.showMessage("OPENED THE DOOR");
                    } else {
                        gp.ui.showMessage("You have " + hashkey + " key");
                    }
                    break;
                case "Boot":
                    nspeed += 1;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Speed up!");
                    break;
                case "Hole":
                    speed = 0;
                    gp.obj[i] = null;
                    gp.ui.showMessage("OOPS !!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playerSE(0);
                    break;

                default:
                    break;
            }
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
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
