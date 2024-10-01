package entities;

import java.awt.image.BufferedImage;

public class Entity {
    public int posX, posY, speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 1;
    public int timerChangeSprite = 0;
}
