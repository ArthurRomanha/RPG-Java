package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int defaultTileSize = 16; // final int é valor constante, não muda. / valor padrão do jogo dos tiles
    int scale = 3; // escala para telas maiores

    int tileSize = defaultTileSize * scale; // 48
    final int maxColum = 16; // o jogo terá 16 colunas
    final int maxRow = 12; // o jogo terá 12 linhas
    final int screenHeight = tileSize * maxRow; // maximo de linhas
    final int screenWidth = tileSize * maxColum; // maxima de colunas

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // player variables
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    final int FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));// define as dimensões da tela
        this.setBackground(Color.black);// define o background da tela
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this); // arthurzinho não gostou dessa linha
        gameThread.start(); // familia romanha gosta desta linha de codigo!

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {

            update();

            repaint();

           

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0 ;
                }

                nextDrawTime += drawInterval;

                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {
        if (keyH.upPressed) {
            playerY -= playerSpeed;
            System.out.println("a");
        } else if (keyH.downPressed) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}