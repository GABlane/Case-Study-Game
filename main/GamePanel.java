package main;

import Entity.Entity;
import Entity.Player;
import Obj.SuperObj;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
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
    Thread gameThread;

    // UI
    public UI ui = new UI(this);

    // Entity Object
    public Player player = new Player(this, keyH);
    public SuperObj obj[] = new SuperObj[10];
    public Entity Npc[] = new Entity[10];

    // game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;

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
            for (int i = 0; i < Npc.length; i++) {
                if (Npc[i] != null) {
                    Npc[i].update();
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

        //title
        if(gameState == titleState){
            ui.draw(g2);
        }
        //others
        else{
            tileM.draw(g2);

            // OBJECT
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].draw(g2, this);
                }
            }

            // NPC
            for (int i = 0; i < Npc.length; i++) {
                if (Npc[i] != null) {
                    Npc[i].draw(g2);
                }
            }

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

}
