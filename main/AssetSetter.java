package main;

import Obj.OBJ_Sword;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        // sa gagawa lang ng mapa gagalaw neto
        // if gusto gumawa ng object make a file first in the Obj package || file tapos
        // dito nakalagay kung saan mo lalagay sa mapa yung object

        // gp.obj[0] = new OBJ_Sword();
        // gp.obj[0].worldX = 23 * gp.tileSize;
        // gp.obj[0].worldY = 23 * gp.tileSize;

        // gp.obj[1] = new OBJ_Sword();
        // gp.obj[1].worldX = 24 * gp.tileSize;
        // gp.obj[1].worldY = 24 * gp.tileSize;
    }
}
