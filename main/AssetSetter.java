package main;

import Obj.OBJ_Boots;
import Obj.OBJ_DOOR;
import Obj.OBJ_Hole;
import Obj.OBJ_Key;
// import Obj.OBJ_Sword;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

    
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 17 * gp.tileSize;
        gp.obj[0].worldY = 14 * gp.tileSize;

        gp.obj[1] = new OBJ_DOOR();
        gp.obj[1].worldX = 32 * gp.tileSize;
        gp.obj[1].worldY = 27 * gp.tileSize;
        
        gp.obj[2] = new OBJ_Boots();
        gp.obj[2].worldX = 16 * gp.tileSize;
        gp.obj[2].worldY = 45 * gp.tileSize;
        
        gp.obj[3] = new OBJ_Hole();
        gp.obj[3].worldX = 17 * gp.tileSize;
        gp.obj[3].worldY = 46 * gp.tileSize;


        
        
    }
}
