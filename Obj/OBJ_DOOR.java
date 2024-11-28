package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_DOOR extends SuperObj{
public OBJ_DOOR() {
        name = "DOOR";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/door.png")); // lalagay pako ng sword ni finn
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
