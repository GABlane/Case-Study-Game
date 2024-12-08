package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[80];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void getTileImage() {

        // floring
        setup(20, "snow", false);

        // boulder
        setup(21, "ice_tree", true);

        // wall
        setup(22, "ice_wall", true);

        // water
        setup(23, "water", true);

        // lava
        setup(25, "stone", true);
        // setup(24, "lava", true);

        // stairs
        setup(26, "Stair", false);
        setup(27, "LeftStair", false);
        setup(28, "RightStair", false);

        // tree
        setup(29, "1Tree", true);
        setup(10, "2Tree", true);
        setup(11, "4Tree", true);
        setup(12, "3Tree", true);
        setup(13, "6Tree", true);
        setup(14, "5Tree", true);
        setup(15, "7Tree", true);
        setup(16, "8Tree", true);
        setup(30, "tree-left", true);
        setup(31, "tree-right", true);

        // water
        setup(17, "water-upper", true);
        setup(18, "water-upper2", true);
        setup(19, "water-toleft", true);
        setup(32, "water-down", true);
        setup(33, "water-left", true);
        setup(34, "water-right", true);
        setup(35, "water-right-down", true);
        setup(36, "water-down-right", true);
        setup(37, "water-left-down", true);
        setup(38, "water-left-up", true);
        setup(39, "water-down-left", true);
        setup(40, "water-right-down2", true);
        setup(41, "water-up-right", true);

    }

    public void setup(int index, String ImagePath, boolean collision) {
        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/" + ImagePath + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filepath) {
        try {
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

                String line = br.readLine();
                while (col < gp.maxWorldCol) {

                    String number[] = line.split(" ");

                    int num = Integer.parseInt(number[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {// tile[1] is wall and tile[3] is floor
        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
