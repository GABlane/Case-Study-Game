package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Heart extends SuperObj {
    GamePanel gp;

    public OBJ_Heart(GamePanel gp) {

        this.gp = gp;

        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Full_Heart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Haft_Heart.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Empty_Heart.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}