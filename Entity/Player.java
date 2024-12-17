package Entity;

import java.awt.AlphaComposite;
// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Obj.OBJ_Shield_Normal;
import Obj.OBJ_SnowBall;
import Obj.OBJ_Stick;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    // public int hasKey = 0;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();

        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        // attackArea.width = 36;
        // attackArea.height = 36;

        setDefaultValues();
        getImage();
        playerAttackImage();
        setItem();
    }

    public void setDefaultPosition() {
        worldX = gp.tileSize * 26;
        worldY = gp.tileSize * 24;
        direction = "down";
    }

    public void Retore() {
        life = maxLife;
        invisible = false;
    }

    public void setItem() {
        inventory.clear();
        inventory.add(currentWeapon);
        inventory.add(currentShield);
    }

    public void setDefaultValues() {
        name = "finn";
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 20;
        // worldX = gp.tileSize * 12;
        // worldY = gp.tileSize * 12;
        gp.currentMap = 1;
        speed = 5;
        direction = "down";

        // player status
        maxLife = 6;
        life = maxLife;
        level = 1;
        dexterity = 1;
        strength = 1;
        exp = 0;
        nextLvlExp = 5;
        coin = 1000;
        currentWeapon = new OBJ_Stick(gp);
        currentShield = new OBJ_Shield_Normal(gp);
        projectile = new OBJ_SnowBall(gp);
        attack = getAttack();
        defense = getDefense();
    }

    // the more attack in weapon or the more attack in shield enhances the stats
    public int getAttack() {
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue;
    }

    public int getDefense() {
        return defense = dexterity * currentShield.defenseValue;
    }

    @Override
    public void getImage() {

        up1 = setup("/player/up1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/up2", gp.tileSize, gp.tileSize);
        down1 = setup("/player/down1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/down2", gp.tileSize, gp.tileSize);
        left1 = setup("/player/left1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/left2", gp.tileSize, gp.tileSize);
        right1 = setup("/player/right1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/right2", gp.tileSize, gp.tileSize);

    }

    public void playerAttackImage() {
        if (currentWeapon.type == type_sword) {

            attackUp1 = setup("/player/attack_sword_up1", gp.tileSize, gp.tileSize * 2);
            attackUp2 = setup("/player/attack_sword_up2", gp.tileSize, gp.tileSize * 2);
            attackDown1 = setup("/player/attack_sword_down1", gp.tileSize, gp.tileSize * 2);
            attackDown2 = setup("/player/attack_sword_down2", gp.tileSize, gp.tileSize * 2);
            attackLeft1 = setup("/player/attack_sword_left1", gp.tileSize * 2, gp.tileSize);
            attackLeft2 = setup("/player/attack_sword_left2", gp.tileSize * 2, gp.tileSize);
            attackRight1 = setup("/player/attack_sword_right1", gp.tileSize * 2, gp.tileSize);
            attackRight2 = setup("/player/attack_sword_right2", gp.tileSize * 2, gp.tileSize);

        }
        if (currentWeapon.type == type_stick) {

            attackUp1 = setup("/player/attack_stick_up1", gp.tileSize, gp.tileSize * 2);
            attackUp2 = setup("/player/attack_stick_up2", gp.tileSize, gp.tileSize * 2);
            attackDown1 = setup("/player/attack_stick_down1", gp.tileSize, gp.tileSize * 2);
            attackDown2 = setup("/player/attack_stick_down2", gp.tileSize, gp.tileSize * 2);
            attackLeft1 = setup("/player/attack_stick_left1", gp.tileSize * 2, gp.tileSize);
            attackLeft2 = setup("/player/attack_stick_left2", gp.tileSize * 2, gp.tileSize);
            attackRight1 = setup("/player/attack_stick_right1", gp.tileSize * 2, gp.tileSize);
            attackRight2 = setup("/player/attack_stick_right2", gp.tileSize * 2, gp.tileSize);
        }
    }

    @Override
    public void update() {

        if (attacking == true) {
            attacking();
        } else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
                || keyH.rightPressed == true || keyH.enterPressed == true /* || keyH.enterPressed = true */ ) {
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

            // check tile collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // check npc collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.Npc);
            interactNPC(npcIndex);

            // check monster collision
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            // event checker
            gp.eHandler.checkEvent();

            if (collisionOn == false && keyH.enterPressed == false) {
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

            gp.keyH.enterPressed = false;

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
        // SET COORDINATES
        if (gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailbleCounter == 30) {
            projectile.set(worldX, worldY, direction, true, this);

            // ADD TO THE LIST
            gp.projectileList.add(projectile);

            shotAvailbleCounter = 0;
        }

        if (invisible == true) {
            invisibleCounter++;
            if (invisibleCounter == 90) {
                invisible = false;
                invisibleCounter = 0;
            }
        }
        if (shotAvailbleCounter < 30) {
            shotAvailbleCounter++;
        }
        if (life >= maxLife) {
            life = maxLife;
        }
        if (life <= 0) {
            gp.gameState = gp.gameOverState;
            gp.ui.commandNum -= 1;
        }
    }

    public void attacking() {
        spriteCounter++;

        if (spriteCounter <= 5) {
            spriteNum = 1;
        }
        if (spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;

            // save the current worldX, WorldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            // adjust player world/y for the attackArea
            switch (direction) {
                case "up":
                    worldY -= attackArea.height;
                    break;
                case "down":
                    worldY += attackArea.width;
                    break;
                case "left":
                    worldX -= attackArea.width;
                    break;
                case "right":
                    worldX += attackArea.width;
                    break;
            }

            // attackArea becomes solidArea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // check monster collision
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex, attack);

            // after checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if (spriteCounter > 25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }

    // object
    public void pickUpObject(int i) {
        if (i != 999) {
            // PICK UP ONLY ITEMS
            if (gp.obj[gp.currentMap][i].type == type_pickUpOnly) {
                gp.obj[gp.currentMap][i].use(this);
                gp.obj[gp.currentMap][i] = null;
            }
            // OBSTACLE
            else if (gp.obj[gp.currentMap][i].type == type_Obstacle) {
                if (keyH.enterPressed == true) {
                    gp.obj[gp.currentMap][i].interact();
                }
            } else {

                String text;
                if (inventory.size() != maxInventorySize) {
                    inventory.add(gp.obj[gp.currentMap][i]);
                    gp.playSE(4);
                    text = "Got a " + gp.obj[gp.currentMap][i].name + "!";
                } else {
                    text = "You cannot carry anymore";
                }
                gp.ui.addMessage(text);
                gp.obj[gp.currentMap][i] = null;
            }

        }
    }

    // npc
    public void interactNPC(int i) {

        if (gp.keyH.enterPressed == true) {
            if (i != 999) {
                gp.playSE(4);
                gp.gameState = gp.dialogueState;
                gp.Npc[gp.currentMap][i].speak();
            } else {
                gp.playSE(3);
                attacking = true;
            }
            gp.keyH.enterPressed = false;
        }
    }

    public void contactMonster(int i) {

        if (i != 999) {
            if (invisible == false && gp.monster[gp.currentMap][i].dying == false) {
                gp.playerSE(2);
                int damage = attack - gp.monster[gp.currentMap][i].attack - defense;
                if (damage < 0) {
                    damage = 0;
                }

                life -= damage;
                invisible = true;
            }
        }
    }

    public void damageMonster(int i, int attack) {
        if (i != 999) {

            if (gp.monster[gp.currentMap][i].invisible == false) {

                int damage = attack - gp.monster[gp.currentMap][i].defense;
                if (damage < 0) {
                    damage = 0;
                }

                gp.playSE(1);
                gp.monster[gp.currentMap][i].life -= damage;
                gp.ui.addMessage(damage + " damage dealt");

                gp.monster[gp.currentMap][i].invisible = true;
                gp.monster[gp.currentMap][i].damageReaction();

                if (gp.monster[gp.currentMap][i].life <= 0) {
                    gp.monster[gp.currentMap][i].dying = true;
                    gp.ui.addMessage("killed the " + gp.monster[gp.currentMap][i].name + " !");
                    exp += gp.monster[gp.currentMap][i].exp;
                    gp.ui.addMessage("Gained " + gp.monster[gp.currentMap][i].exp + " EXP");
                    checkLevel();
                }
            }
        }
    }

    public void checkLevel() {
        if (exp >= nextLvlExp) {
            level++;
            nextLvlExp = nextLvlExp * 2;
            maxLife += 2;
            strength++;
            dexterity++;
            defense = getDefense();
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You're level " + level;
            getAttack();
            getDefense();
            gp.aSetter.setMonster();
        }
    }

    public void selectItem() {

        int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerslotCol, gp.ui.playerslotRow);
        if (itemIndex < inventory.size()) {
            Entity selectedItem = inventory.get(itemIndex);

            if (selectedItem.type == type_sword || selectedItem.type == type_stick) {
                currentWeapon = selectedItem;
                attack = getAttack();
                playerAttackImage();
            }
            if (selectedItem.type == type_shield) {
                currentShield = selectedItem;
                defense = getDefense();
            }
            if (selectedItem.type == type_consumable) {
                if (selectedItem.use(this) == true) {
                    inventory.remove(itemIndex);
                }
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch (direction) {
            case "up":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                }
                if (attacking == true) {
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNum == 1) {
                        image = attackUp1;
                    }
                    if (spriteNum == 2) {
                        image = attackUp2;
                    }
                }
                break;
            case "down":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackDown1;
                    }
                    if (spriteNum == 2) {
                        image = attackDown2;
                    }
                }
                break;
            case "left":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                }
                if (attacking == true) {
                    tempScreenX = screenX - gp.tileSize;
                    if (spriteNum == 1) {
                        image = attackLeft1;
                    }
                    if (spriteNum == 2) {
                        image = attackLeft2;
                    }
                }
                break;
            case "right":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackRight1;
                    }
                    if (spriteNum == 2) {
                        image = attackRight2;
                    }
                }
                break;
        }

        if (invisible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }

        g2.drawImage(image, tempScreenX, tempScreenY, null);

        // reset oppacity
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        // g2.setFont(new Font("Arial", Font.PLAIN, 20));
        // g2.setColor(Color.black);
        // g2.drawString("invinsible counter:" + invisibleCounter, 400, 400);
    }
}
