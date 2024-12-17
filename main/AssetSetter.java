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
        int mapNum = 0;
        int i = 0;

        gp.obj[mapNum][i] = new OBJ_DOOR(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 24;
        gp.obj[mapNum][i].worldY = gp.tileSize * 35;

        i++;
        gp.obj[mapNum][i] = new OBJ_DOOR(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 22;
        gp.obj[mapNum][i].worldY = gp.tileSize * 10;

        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 21;
        gp.obj[mapNum][i].worldY = gp.tileSize * 10;

        i++;
        gp.obj[mapNum][i] = new OBJ_COIN(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 25;
        gp.obj[mapNum][i].worldY = gp.tileSize * 13;

        i++;
        gp.obj[mapNum][i] = new OBJ_sanWitch(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 27;
        gp.obj[mapNum][i].worldY = gp.tileSize * 35;

        i++;
        gp.obj[mapNum][i] = new OBJ_Heart(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 25;
        gp.obj[mapNum][i].worldY = gp.tileSize * 25;
    }

    public void setNPC() {

        int mapNum = 0;
        gp.Npc[mapNum][0] = new NPC_Jake(gp);
        gp.Npc[mapNum][0].worldX = gp.tileSize * 27;
        gp.Npc[mapNum][0].worldY = gp.tileSize * 22;

    }

    public void setMonster() {

        int mapNum = 0;
        int i = 0;

        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 40;
        gp.monster[mapNum][i].worldY = gp.tileSize * 11;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 38;
        gp.monster[mapNum][i].worldY = gp.tileSize * 10;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 40;
        gp.monster[mapNum][i].worldY = gp.tileSize * 8;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 41;
        gp.monster[mapNum][i].worldY = gp.tileSize * 13;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 8;
        gp.monster[mapNum][i].worldY = gp.tileSize * 23;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 9;
        gp.monster[mapNum][i].worldY = gp.tileSize * 24;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 7;
        gp.monster[mapNum][i].worldY = gp.tileSize * 22;
    }
}
