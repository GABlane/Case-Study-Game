package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObj{
public OBJ_Key() {
        name = "key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Key.png")); // lalagay pako ng sword ni finn
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
