package main;

import Entity.NPC_Jake;
import Obj.OBJ_Chest;
import Obj.OBJ_DOOR;
import Obj.OBJ_Key;
import monster.MON_Gunther;
import monster.MON_ICEKING;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int mapNum = 0;
        int i = 0;

        gp.obj[mapNum][i] = new OBJ_DOOR(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 46;
        gp.obj[mapNum][i].worldY = gp.tileSize * 30;

        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 6;
        gp.obj[mapNum][i].worldY = gp.tileSize * 45;

        mapNum = 1;
        i++;
        gp.obj[mapNum][i] = new OBJ_Chest(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 20;
        gp.obj[mapNum][i].worldY = gp.tileSize * 16;

        i++;
        gp.obj[mapNum][i] = new OBJ_DOOR(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 20;
        gp.obj[mapNum][i].worldY = gp.tileSize * 12;

    }

    public void setNPC() {

        int mapNum = 0;
        gp.Npc[mapNum][0] = new NPC_Jake(gp);
        gp.Npc[mapNum][0].worldX = gp.tileSize * 7;
        gp.Npc[mapNum][0].worldY = gp.tileSize * 10;

    }

    public void setMonster() {

        int mapNum = 0;
        int i = 0;

        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 25;
        gp.monster[mapNum][i].worldY = gp.tileSize * 11;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 23;
        gp.monster[mapNum][i].worldY = gp.tileSize * 10;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 21;
        gp.monster[mapNum][i].worldY = gp.tileSize * 8;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 23;
        gp.monster[mapNum][i].worldY = gp.tileSize * 13;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 23;
        gp.monster[mapNum][i].worldY = gp.tileSize * 11;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 25;
        gp.monster[mapNum][i].worldY = gp.tileSize * 15;

        mapNum = 1;
        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 7;
        gp.monster[mapNum][i].worldY = gp.tileSize * 8;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 8;
        gp.monster[mapNum][i].worldY = gp.tileSize * 8;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 8;
        gp.monster[mapNum][i].worldY = gp.tileSize * 7;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 7;
        gp.monster[mapNum][i].worldY = gp.tileSize * 7;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 32;
        gp.monster[mapNum][i].worldY = gp.tileSize * 8;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 34;
        gp.monster[mapNum][i].worldY = gp.tileSize * 8;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 33;
        gp.monster[mapNum][i].worldY = gp.tileSize * 7;

        i++;
        gp.monster[mapNum][i] = new MON_Gunther(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 30;
        gp.monster[mapNum][i].worldY = gp.tileSize * 7;

        mapNum = 2;
        i++;
        gp.monster[mapNum][i] = new MON_ICEKING(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 18;
        gp.monster[mapNum][i].worldY = gp.tileSize * 29;
    }
}
