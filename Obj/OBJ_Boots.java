package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObj {
public OBJ_Boots() {
        name = "Boot";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Boot.png")); // lalagay pako ng sword ni finn
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
