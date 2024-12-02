package Obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Chest extends SuperObj {
    public OBJ_Chest() {
        name = "Chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/Objects/Chest.png")); // lalagay pako ng sword ni
                                                                                            // finn
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
