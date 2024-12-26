package Obj;

import Entity.Projectile;
import main.GamePanel;

public class OBJ_SnowFlake extends Projectile {
    GamePanel gp;

    public OBJ_SnowFlake(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "SnowFlake";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        alive = false;
        getImage();
    }

    @Override
    public void getImage() {
        up1 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        up2 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        down1 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        down2 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        left1 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        left2 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        right1 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
        right2 = setup("/projectile/snow_flake", gp.tileSize, gp.tileSize);
    }
}
