package tile;

import main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileManager {
    GameScreen gs;
    Tile[] tile;

    public TileManager (GameScreen gs){
        this.gs = gs;
        tile = new Tile[10];
        getTileImage();
    }
    public void getTileImage (){
        BufferedImage grass, water, wall;
        try {
            grass = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/grass.png"));
            wall = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall.png"));
            water = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water.png"));
            tile[0] = new Tile();
            tile[0].image = grass;

            tile[1] = new Tile();
            tile[1].image = wall;

            tile[2] = new Tile();
            tile[2].image = water;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(tile[0].image, 0, 0, gs.tileSize, gs.tileSize, null);
    }
}
