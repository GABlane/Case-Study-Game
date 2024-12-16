package main;

import Entity.NPC_Jake;
import Obj.OBJ_COIN;
import Obj.OBJ_DOOR;
import Obj.OBJ_Heart;
import Obj.OBJ_Key;
import Obj.OBJ_sanWitch;
import monster.MON_Gunther;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int i = 0;
        gp.obj[i] = new OBJ_DOOR(gp);
        gp.obj[i].worldX = gp.tileSize * 24;
        gp.obj[i].worldY = gp.tileSize * 35;

        i++;
        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = gp.tileSize * 21;
        gp.obj[i].worldY = gp.tileSize * 10;

        i++;
        gp.obj[i] = new OBJ_COIN(gp);
        gp.obj[i].worldX = gp.tileSize * 25;
        gp.obj[i].worldY = gp.tileSize * 13;

        i++;
        gp.obj[i] = new OBJ_sanWitch(gp);
        gp.obj[i].worldX = gp.tileSize * 27;
        gp.obj[i].worldY = gp.tileSize * 35;

        i++;
        gp.obj[i] = new OBJ_Heart(gp);
        gp.obj[i].worldX = gp.tileSize * 25;
        gp.obj[i].worldY = gp.tileSize * 25;
    }

    public void setNPC() {
        gp.Npc[0] = new NPC_Jake(gp);
        gp.Npc[0].worldX = gp.tileSize * 27;
        gp.Npc[0].worldY = gp.tileSize * 22;

    }

    public void setMonster() {
        gp.monster[0] = new MON_Gunther(gp);
        gp.monster[0].worldX = gp.tileSize * 40;
        gp.monster[0].worldY = gp.tileSize * 11;

        gp.monster[1] = new MON_Gunther(gp);
        gp.monster[1].worldX = gp.tileSize * 38;
        gp.monster[1].worldY = gp.tileSize * 10;

        gp.monster[2] = new MON_Gunther(gp);
        gp.monster[2].worldX = gp.tileSize * 40;
        gp.monster[2].worldY = gp.tileSize * 8;

        gp.monster[1] = new MON_Gunther(gp);
        gp.monster[1].worldX = gp.tileSize * 41;
        gp.monster[1].worldY = gp.tileSize * 13;
    }
}
