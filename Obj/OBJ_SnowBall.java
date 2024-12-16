package Obj;

import Entity.Projectile;
import main.GamePanel;

public class OBJ_SnowBall extends Projectile {
    GamePanel gp;
    public OBJ_SnowBall(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "SnowBall";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        alive = false;
        getImage();
    }

    @Override
    public void getImage(){
        up1 = setup("/projectile/Snow-up1", gp.tileSize, gp.tileSize);
        up2 = setup("/projectile/Snow-up2", gp.tileSize, gp.tileSize);
        down1 = setup("/projectile/Snow-down1", gp.tileSize, gp.tileSize);
        down2 = setup("/projectile/Snow-down2", gp.tileSize, gp.tileSize);
        left1 = setup("/projectile/Snow-left1", gp.tileSize, gp.tileSize);
        left2 = setup("/projectile/Snow-left2", gp.tileSize, gp.tileSize);
        right1 = setup("/projectile/Snow-right1", gp.tileSize, gp.tileSize);
        right2= setup("/projectile/Snow-right2", gp.tileSize, gp.tileSize);
    }


}
