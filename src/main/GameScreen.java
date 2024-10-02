package main;

import entities.Player;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {
    final int defaultTileSize = 16; // final int é valor constante, não muda. / valor padrão do jogo dos tiles
    int scale = 3; // escala para telas maiores

    public int tileSize = defaultTileSize * scale; // 48
    final int maxColum = 16; // o jogo terá 16 colunas
    final int maxRow = 12; // o jogo terá 12 linhas
    final int screenHeight = tileSize * maxRow; // maximo de linhas
    final int screenWidth = tileSize * maxColum; // maxima de colunas

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    TileManager TileM = new TileManager(this);
    final int FPS = 60;

    public GameScreen() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));// define as dimensões da tela
        this.setBackground(Color.black);// define o background da tela
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);

        this.setFocusable(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        double drawInterval = 1000 / FPS;
        double delta = 0;
        long lastTime = System.currentTimeMillis();// tempo desde a última execução (ele é atualizado no while)
        long currentTime;

        while (gameThread != null) {
            currentTime = System.currentTimeMillis();// tempo desta execução / ele vai sendo incremenado até que seu
                                                     // valor ultrapasse o tempo desde a última execução

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {// se o tempo da última execução for >= que 1 significa que a função pode ser
                             // executada novamente
                update();

                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        TileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}