package Obj;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_Key extends SuperObj {
    public Obj_Key(){
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream(""));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
