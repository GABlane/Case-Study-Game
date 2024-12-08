package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Boots extends SuperObj {
    GamePanel gp;

    public OBJ_Boots(GamePanel gp) {
        name = "Boot";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Boot.png")); // lalagay pako ng sword ni
                                                                                           // finn
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
