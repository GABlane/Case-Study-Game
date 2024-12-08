package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Hole extends SuperObj {
    GamePanel gp;

    public OBJ_Hole(GamePanel gp) {
        name = "Hole";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Hole.png")); // lalagay pako ng sword ni
                                                                                           // finn
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
