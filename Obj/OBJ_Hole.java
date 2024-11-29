package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Hole extends SuperObj{
public OBJ_Hole() {
        name = "Hole";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Hole.png")); // lalagay pako ng sword ni finn
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
