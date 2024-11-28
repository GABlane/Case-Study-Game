package Obj;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Sword extends SuperObj {
    public OBJ_Sword() {
        name = "Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("")); // lalagay pako ng sword ni finn
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
