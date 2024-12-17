package main;

import Entity.Entity;
import Entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // World Settings
    public int maxWorldCol;
    public int maxWorldRow;
    public final int maxMap = 10;
    public int currentMap = 0;
    // public final int worldWidth = tileSize * maxWorldCol;
    // public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 60;

    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    // System Sound
    Sound music = new Sound();
    Sound SFX = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    Config config = new Config(this);
    Thread gameThread;

    // UI
    public UI ui = new UI(this);

    public EventHandler eHandler = new EventHandler(this);

    // Entity & Object
    public Player player = new Player(this, keyH);
    public Entity obj[][] = new Entity[maxMap][10];
    public Entity Npc[][] = new Entity[maxMap][10];
    public Entity monster[][] = new Entity[maxMap][20];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    // game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionState = 5;
    public final int gameOverState = 6;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        // playMusic(0);
        gameState = titleState;
    }

    void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    void update() {

        if (gameState == playState) {
            // player
            player.update();
            // NPC
            for (int i = 0; i < Npc[1].length; i++) {
                if (Npc[currentMap][i] != null) {
                    Npc[currentMap][i].update();
                }
            }
            for (int i = 0; i < monster[1].length; i++) {
                if (monster[currentMap][i] != null) {
                    if (monster[currentMap][i].alive == true && monster[currentMap][i].dying == false) {
                        monster[currentMap][i].update();
                    }
                    if (monster[currentMap][i].alive == false) {
                        monster[currentMap][i].checkDrop();
                        monster[currentMap][i] = null;
                    }
                }
            }
            for (int i = 0; i < projectileList.size(); i++) {
                if (projectileList.get(i) != null) {
                    if (projectileList.get(i).alive == true) {
                        projectileList.get(i).update();
                    }
                    if (projectileList.get(i).alive == false) {
                        projectileList.remove(i);
                    }
                }
            }
        }
        if (gameState == pauseState) {
            // wala
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // TILE
        long drawStart = 0;
        if (keyH.checkDraw == true) {
            drawStart = System.nanoTime();
        }

        // title
        if (gameState == titleState) {
            ui.draw(g2);
        }
        // others
        else {
            tileM.draw(g2);

            // add entities to the list
            entityList.add(player);

            // npc add
            for (int i = 0; i < Npc[1].length; i++) {
                if (Npc[currentMap][i] != null) {
                    entityList.add(Npc[currentMap][i]);
                }
            }
            // add objs
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null) {
                    entityList.add(obj[currentMap][i]);
                }
            }

            for (int i = 0; i < monster[1].length; i++) {
                if (monster[currentMap][i] != null) {
                    entityList.add(monster[currentMap][i]);
                }
            }
            for (int i = 0; i < projectileList.size(); i++) {
                if (projectileList.get(i) != null) {
                    entityList.add(projectileList.get(i));
                }
            }

            Collections.sort(entityList, new Comparator<Entity>() {

                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }

            });

            // Draw entities
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            // Empty the list
            entityList.clear();

            // PLAYER
            player.draw(g2);
            // UI
            ui.draw(g2);
        }

        // DEBUG
        if (keyH.checkDraw == true) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.black);
            g2.drawString("Draw time" + passed, 10, 400);
        }

        g2.dispose();
    }

    public void retry() {

        player.setDefaultPosition();
        player.Retore();
        aSetter.setMonster();
    }

    public void restart() {
        player.setDefaultValues();
        player.setItem();
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        music.stop();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {
        music.stop();
    }

    public void playerSE(int i) {
        SFX.setFile(i);
        SFX.play();
    }

    public void playSE(int i) {
        SFX.setFile(i);
        SFX.play();
    }
}
