package main;

import Entity.NPC_Jake;
import Entity.NPC_Merchant;
import Obj.OBJ_DOOR;
import Obj.OBJ_Key;
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
        gp.obj[mapNum][i].worldX = gp.tileSize * 46;
        gp.obj[mapNum][i].worldY = gp.tileSize * 30;

        // i++;
        // gp.obj[mapNum][i] = new OBJ_DOOR(gp);
        // gp.obj[mapNum][i].worldX = gp.tileSize * 22;
        // gp.obj[mapNum][i].worldY = gp.tileSize * 10;

        i++;
        gp.obj[mapNum][i] = new OBJ_Key(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 6;
        gp.obj[mapNum][i].worldY = gp.tileSize * 45;

        // i++;
        // gp.obj[mapNum][i] = new OBJ_COIN(gp);
        // gp.obj[mapNum][i].worldX = gp.tileSize * 25;
        // gp.obj[mapNum][i].worldY = gp.tileSize * 13;

        // i++;
        // gp.obj[mapNum][i] = new OBJ_sanWitch(gp);
        // gp.obj[mapNum][i].worldX = gp.tileSize * 27;
        // gp.obj[mapNum][i].worldY = gp.tileSize * 35;

        // i++;
        // gp.obj[mapNum][i] = new OBJ_Heart(gp);
        // gp.obj[mapNum][i].worldX = gp.tileSize * 25;
        // gp.obj[mapNum][i].worldY = gp.tileSize * 25;
    }

    public void setNPC() {
        int i = 0;

        int mapNum = 0;
        gp.Npc[mapNum][0] = new NPC_Jake(gp);
        gp.Npc[mapNum][0].worldX = gp.tileSize * 7;
        gp.Npc[mapNum][0].worldY = gp.tileSize * 10;

        mapNum = 1;
        i++;
        gp.Npc[mapNum][i] = new NPC_Merchant(gp);
        gp.Npc[mapNum][i].worldX = gp.tileSize * 20;
        gp.Npc[mapNum][i].worldY = gp.tileSize * 15;

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

        // i++;
        // gp.monster[mapNum][i] = new MON_Gunther(gp);
        // gp.monster[mapNum][i].worldX = gp.tileSize * 7;
        // gp.monster[mapNum][i].worldY = gp.tileSize * 45;
        // i++;
        // gp.monster[mapNum][i] = new MON_Gunther(gp);
        // gp.monster[mapNum][i].worldX = gp.tileSize * 5;
        // gp.monster[mapNum][i].worldY = gp.tileSize * 45;
        // i++;
        // gp.monster[mapNum][i] = new MON_Gunther(gp);
        // gp.monster[mapNum][i].worldX = gp.tileSize * 10;
        // gp.monster[mapNum][i].worldY = gp.tileSize * 45;
    }
}
