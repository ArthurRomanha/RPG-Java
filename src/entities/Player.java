package entities;

import main.GameScreen;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GameScreen gs;
    KeyHandler keyH;

    public Player(GameScreen gs, KeyHandler keyH) {
        this.gs = gs;
        this.keyH = keyH;

        getPlayerImage();
        setDefaultValues();
    }

    public void setDefaultValues() {
        posX = 100;
        posY = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_up_2.png"));

            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_down_2.png"));

            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_left_2.png"));

            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            timerChangeSprite++;
            if (timerChangeSprite > 12) {
                if (spriteCounter == 1) {
                    spriteCounter = 2;
                } else if (spriteCounter == 2) {
                    spriteCounter = 1;
                }
                timerChangeSprite = 0;
            }
        };
        if (keyH.upPressed) {
            direction = "up";
            posY -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            posY += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            posX -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            posX += speed;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteCounter == 1) {
                    image = up1;
                } else if (spriteCounter == 2) {
                    image = up2;
                }
                break;


            case "down":
                if (spriteCounter == 1) {
                    image = down1;
                    System.out.println("j");
                } else if (spriteCounter == 2) {
                    image = down2;
                }
                break;

            case "left":
                if (spriteCounter == 1) {
                    image = left1;
                } else if (spriteCounter == 2) {
                    image = left2;
                }
                break;

            case "right":
                if (spriteCounter == 1) {
                    image = right1;
                } else if (spriteCounter == 2) {
                    image = right2;
                }
                break;
        }
        System.out.println(down1);
        System.out.println(direction);
        System.out.println(spriteCounter);
        g2.drawImage(image, posX, posY, gs.tileSize, gs.tileSize, null);
    }
}
