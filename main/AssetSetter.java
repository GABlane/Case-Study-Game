package main;

import Obj.Obj_Key;


public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObject(){

        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 23 *gp.tileSize;
        gp.obj[0].worldY = 23 *gp.tileSize;

        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 24 * gp.tileSize;
        gp.obj[1].worldY = 24 * gp.tileSize; 
    }
}
