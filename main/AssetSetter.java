package main;

import Entity.NPC_Jake;
import Obj.OBJ_DOOR;
import monster.MON_Gunther;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        gp.obj[0] = new OBJ_DOOR(gp);
        gp.obj[0].worldX = gp.tileSize * 24;
        gp.obj[0].worldY = gp.tileSize * 35;

    }

    public void setNPC() {
        gp.Npc[0] = new NPC_Jake(gp);
        gp.Npc[0].worldX = gp.tileSize * 27;
        gp.Npc[0].worldY = gp.tileSize * 22;

    }

    public void setMonster() {
        gp.monster[0] = new MON_Gunther(gp);
        gp.monster[0].worldX = gp.tileSize * 40;
        gp.monster[0].worldY = gp.tileSize * 13;

        gp.monster[1] = new MON_Gunther(gp);
        gp.monster[1].worldX = gp.tileSize * 41;
        gp.monster[1].worldY = gp.tileSize * 13;
    }
}
