package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    public BufferedImage up, down, left1, left2, right1, right2;
    public String direnction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public int trapSeconds = 0;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
}
