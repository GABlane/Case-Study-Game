package Obj;

import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Sword extends SuperObj {
    GamePanel gp;

    public OBJ_Sword(GamePanel gp) {
        name = "Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("")); // lalagay pako ng sword ni finn
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
