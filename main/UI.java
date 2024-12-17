package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Entity.Entity;

//import java.text.DecimalFormat;
import java.awt.BasicStroke;
import Obj.OBJ_Heart;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage Full_Heart, Half_Heart, Empty_Heart;
    public boolean messageOn = false;
    // public String message = "";
    // int messageCounter = 0;
    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: the first screen, 1: the second screen
    public int slotCol = 0;
    public int slotRow = 0;
    int subState = 0;

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        // create hud object
        Entity heart = new OBJ_Heart(gp);
        Full_Heart = heart.image;
        Half_Heart = heart.image2;
        Empty_Heart = heart.image3;
    }

    public void addMessage(String text) {

        message.add(text);
        messageCounter.add(0);
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.black);

        // titlestate
        if (gp.gameState == gp.titleState) {
            drawTitleScreen();
        }
        // PLAY STATE
        if (gp.gameState == gp.playState) {
            drawPlayerLife();
            drawMessage();
        }
        // PAUSE STATE
        if (gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
        // DIAGLOGUE STATE
        if (gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();
        }
        // character state
        if (gp.gameState == gp.characterState) {
            drawcharacterstate();
            drawInventory();
        }
        // options state
        if (gp.gameState == gp.optionState) {
            drawOptionScreen();
        }
        if (gp.gameState == gp.gameOverState) {
            GameOverScreen();
        }

    }

    public void drawcharacterstate() {
        // Create a frame

        final int frameX = gp.tileSize;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize * 5;
        final int frameHeight = gp.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // Text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameX + gp.tileSize;
        final int lineHeight = 35;

        g2.drawString("Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Life", textX, textY);
        textY += lineHeight;
        g2.drawString("Strength", textX, textY);
        textY += lineHeight;
        g2.drawString("Dexterity", textX, textY);
        textY += lineHeight;
        g2.drawString("Attack", textX, textY);
        textY += lineHeight;
        g2.drawString("Defense", textX, textY);
        textY += lineHeight;
        g2.drawString("EXP", textX, textY);
        textY += lineHeight;
        g2.drawString("Next Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Coin", textX, textY);
        textY += lineHeight + 15;
        g2.drawString("Shield", textX, textY);
        textY += lineHeight + 25;
        g2.drawString("Weapon", textX, textY);

        // Values
        int tailX = (frameX + frameWidth) - 30;
        textY = frameY + gp.tileSize;
        String value;

        value = String.valueOf(gp.player.level);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.strength);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.dexterity);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.exp);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.nextLvlExp);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);

        g2.drawImage(gp.player.currentShield.down1, tailX - gp.tileSize, textY + 15, null);
        textY += gp.tileSize;
        g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize, textY + 25, null);
    }

    public void drawPlayerLife() {

        // gp.player.life = 6;

        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        // draw max life
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(Empty_Heart, x, y, null);
            i++;
            x += gp.tileSize;
        }
        // reset
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // draw curret life
        while (i < gp.player.life) {
            g2.drawImage(Half_Heart, x, y, null);
            i++;
            if (i < gp.player.life) {
                g2.drawImage(Full_Heart, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }

    }

    public void drawOptionScreen() {
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        // SUB WINDOW
        int frameX = gp.tileSize * 5;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize * 6;
        int frameHeight = gp.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        switch (subState) {
            case 0:
                option_top(frameX, frameY);
                break;
            case 1:
                options_control(frameX, frameY);
                break;
            case 2:
                option_endGameConfirmation(frameX, frameY);
                break;

            default:
                break;
        }
        gp.keyH.enterPressed = false;
    }

    public void option_top(int frameX, int frameY) {
        int textX;
        int textY;

        // TITLE
        String Text = "OPTIONS";
        textX = getXforCenteredText(Text);
        textY = frameY + gp.tileSize;
        g2.drawString(Text, textX, textY);

        // MUSIC
        textX = frameX + gp.tileSize + 4;
        textY += gp.tileSize * 2;
        g2.drawString("Music", textX, textY);
        if (commandNum == 0) {
            g2.drawString(" >", textX - 40, textY);
        }
        // SE
        textY += gp.tileSize;
        g2.drawString("SE", textX, textY);
        if (commandNum == 1) {
            g2.drawString(" >", textX - 40, textY);
        }
        // CONTROL
        textY += gp.tileSize;
        g2.drawString("Control", textX, textY);
        if (commandNum == 2) {
            g2.drawString(" >", textX - 40, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 1;
                commandNum = 0;
            }
        }
        // END GAME
        textY += gp.tileSize;
        g2.drawString("END GAME", textX, textY);
        if (commandNum == 3) {
            g2.drawString(" >", textX - 40, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 2;
                commandNum = 0;
            }
        }
        // BACK
        textY += gp.tileSize * 3;
        g2.drawString("BACK", textX, textY);
        if (commandNum == 4) {
            g2.drawString(" >", textX - 40, textY);
            if (gp.keyH.enterPressed == true) {
                gp.gameState = gp.playState;
                commandNum = 0;
            }
        }

        // BOX
        textX = frameX + gp.tileSize * 3 + 24;
        textY = frameY + gp.tileSize * 2 + 22;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(textX, textY, 90, 24);
        int volumewidth = 22 * gp.music.volumeScale;
        g2.fillRect(textX, textY, volumewidth, 24);

        textY += gp.tileSize;
        g2.drawRect(textX, textY, 90, 24);
        volumewidth = 22 * gp.SFX.volumeScale;
        g2.fillRect(textX, textY, volumewidth, 24);

        gp.config.saveConfig();
    }

    public void drawMessage() {
        int messageX = gp.tileSize - 30;
        int messageY = gp.tileSize * 6;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
        for (int i = 0; i < message.size(); i++) {
            if (message.get(i) != null) {
                g2.setColor(Color.lightGray);
                g2.drawString(message.get(i), messageX + 2, messageY + 2);
                g2.setColor(Color.black);
                g2.drawString(message.get(i), messageX, messageY);

                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY += gp.tileSize;
                if (messageCounter.get(i) > 180) {
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
    }

    public void drawTitleScreen() {

        if (titleScreenState == 0) {
            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            // title name
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Case Study";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;

            // shadow
            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);
            // main color
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            // charac image
            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
            y += gp.tileSize * 2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            // menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 35F));

            text = "NEW GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize * 3.5;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "LOAD GAME";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "QUIT";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        } else if (titleScreenState == 1) {

            // class selection
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(42F));

            String text = "Select your class";
            int x = getXforCenteredText(text);
            int y = gp.tileSize * 3;
            g2.drawString(text, x, y);

            text = "Fighter";
            x = getXforCenteredText(text);
            y += gp.tileSize * 3;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Thief";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Sorcerer";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Back";
            x = getXforCenteredText(text);
            y += gp.tileSize * 2;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }
        }

    }

    public void drawPauseScreen() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {

        // WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }

    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 220);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 210);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 35, 35);
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }

    public void drawInventory() {

        // Frame
        int frameX = 10 + (gp.tileSize * 9);
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize * 6;
        int frameHeight = gp.tileSize * 5;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // SLOT
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        // DRAW ITEMS
        for (int i = 0; i < gp.player.inventory.size(); i++) {
            // EQUIP
            if (gp.player.inventory.get(i) == gp.player.currentWeapon
                    || gp.player.inventory.get(i) == gp.player.currentShield) {
                g2.setColor(new Color(240, 190, 90));
                g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);

            }

            g2.drawImage(gp.player.inventory.get(i).down1, slotX, slotY, null);
            slotX += gp.tileSize;
            if (i == 4 || i == 9 || i == 14) {
                slotX = slotXstart;
                slotY += gp.tileSize;
            }
        }

        // CURSOR
        int cursorX = slotXstart + (gp.tileSize * slotCol);
        int cursorY = slotYstart + (gp.tileSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;

        // DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

        // DESCRIPTION
        int dFrameX = frameX;
        int dFrameY = frameY + frameHeight;
        int dFrameWidth = frameWidth;
        int dFrameHeight = gp.tileSize * 3;
        // Draw Description X
        int textX = dFrameX + 20;
        int textY = dFrameY + gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(24F));
        int itemIndex = getItemIndexOnSlot();
        if (itemIndex < gp.player.inventory.size()) {
            for (String line : gp.player.inventory.get(itemIndex).description.split("\n")) {
                drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);
                g2.drawString(line, textX, textY);
                textY += 32;
            }
        }
    }

    public void options_control(int frameX, int frameY) {
        int textX;
        int textY;

        // TITLE
        String text = "Control";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        textX = frameX + gp.tileSize - 30;
        textY = frameY + gp.tileSize * 2;
        g2.drawString("Move", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Attack", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Shoot", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Stats", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Pause", textX, textY);
        textY += gp.tileSize;
        g2.drawString("Options", textX, textY);
        textY += gp.tileSize;

        textX = frameX + gp.tileSize * 3;
        textY = frameY + gp.tileSize;
        textY += gp.tileSize;
        g2.drawString("W-A-S-D", textX, textY);
        textY += gp.tileSize;
        g2.drawString("ENTER", textX, textY);
        textY += gp.tileSize;
        g2.drawString("F", textX, textY);
        textY += gp.tileSize;
        g2.drawString("C", textX, textY);
        textY += gp.tileSize;
        g2.drawString("P", textX, textY);
        textY += gp.tileSize;
        g2.drawString("ESC", textX, textY);

        // BACK
        textX = frameX + gp.tileSize;
        textY = frameY + gp.tileSize * 9;
        g2.drawString("BACK", textX, textY);
        if (commandNum == 0) {
            g2.drawString(" >", textX - 40, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 0;
                commandNum = 2;
            }
        }
    }

    public void option_endGameConfirmation(int frameX, int frameY) {

        int textX = frameX + gp.tileSize - 10;
        int textY = frameY + gp.tileSize;

        g2.setFont(g2.getFont().deriveFont(25F));
        currentDialogue = "QUIT THE GAME \n AND RETURN \nTO TITLE SCREEN?";
        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, textX, textY);
            textY += 40;
        }

        // YES
        String text = "YES";
        textX = getXforCenteredText(text);
        textY += gp.tileSize * 3;
        g2.drawString(text, textX, textY);
        if (commandNum == 0) {
            g2.drawString(" >", textX - 40, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 0;
                gp.gameState = gp.titleState;
            }
        }

        // NO
        text = "NO";
        textX = getXforCenteredText(text);
        textY += gp.tileSize;
        g2.drawString(text, textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX - 40, textY);
            if (gp.keyH.enterPressed == true) {
                subState = 0;
                commandNum = 3;
            }
        }

    };

    public void drawOptionsScreen() {

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        // sub window
        int frameX = gp.tileSize * 4;
        int frameY = gp.tileSize;
        int frameWidth = gp.tileSize * 8;
        int frameHeight = gp.tileSize * 10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        switch (subState) {
            case 0:
                options_top(frameX, frameY);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    public void options_top(int frameX, int frameY) {

        int textX;
        int textY;

        // title
        String text = "Options";
        textX = getXforCenteredText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        // full screen on and off
        textX = frameX + gp.tileSize;
        textY += gp.tileSize * 2;
        g2.drawString("Full Screen", textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX - 25, textY);
        }

        // music
        textY += gp.tileSize;
        g2.drawString("Music", textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX - 25, textY);
        }

        // se
        textY += gp.tileSize;
        g2.drawString("SE", textX, textY);
        if (commandNum == 2) {
            g2.drawString(">", textX - 25, textY);
        }

        // control
        textY += gp.tileSize;
        g2.drawString("Control", textX, textY);
        if (commandNum == 3) {
            g2.drawString(">", textX - 25, textY);
        }

        // end game
        textY += gp.tileSize;
        g2.drawString("End Game", textX, textY);
        if (commandNum == 4) {
            g2.drawString(">", textX - 25, textY);
        }

        // back
        textY += gp.tileSize * 2;
        g2.drawString("Back", textX, textY);
        if (commandNum == 5) {
            g2.drawString(">", textX - 25, textY);
        }
    }

    public void GameOverScreen() {
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110F));

        // SHADOW
        text = "GAME OVER";
        g2.setColor(Color.BLACK);
        x = getXforCenteredText(text);
        y = gp.tileSize * 4;
        g2.drawString(text, x, y);

        // MAIN
        g2.setColor(Color.white);
        g2.drawString(text, x - 4, y - 4);

        // RETRY
        g2.setFont(g2.getFont().deriveFont(60F));
        text = "RETRY";
        x = getXforCenteredText(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - 40, y);
        }
        // BACK OF TITLE SCREEN

        text = "QUIT";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - 40, y);
        }
    }

    public int getItemIndexOnSlot() {
        int itemIndex = slotCol + (slotRow * 5);
        return itemIndex;
    }

    public int getXforAlignToRightText(String text, int tailX) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }

}
