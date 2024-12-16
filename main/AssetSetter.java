package main;

import Entity.NPC_Jake;
import Obj.OBJ_DOOR;
import Obj.OBJ_Key;
import Obj.OBJ_Sword_Normal;
import Obj.OBJ_sanWitch;
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
        
        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = gp.tileSize * 21;
        gp.obj[1].worldY = gp.tileSize * 10;
        
        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].worldX = gp.tileSize * 25;
        gp.obj[2].worldY = gp.tileSize * 13;
        
        gp.obj[3] = new OBJ_Sword_Normal(gp);
        gp.obj[3].worldX = gp.tileSize * 25;
        gp.obj[3].worldY = gp.tileSize * 15;
        
        gp.obj[4] = new OBJ_sanWitch(gp);
        gp.obj[4].worldX = gp.tileSize * 27;
        gp.obj[4].worldY = gp.tileSize * 35;
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
