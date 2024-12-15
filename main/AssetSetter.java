package main;

import Entity.NPC_Jake;
import monster.MON_Gunther;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

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

    }
}
