package main;

import javax.swing.JFrame; //biblioteca da janela

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame(); // cria uma nova janela
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar janela quando clicar no "x"
        window.setResizable(true); // não será possível mudar seu tamanho padrão
        window.setTitle("MyGame"); // título da janela

        GamePanel gamePanel = new GamePanel(); // cria a tela
        window.add(gamePanel); // adiciona a tela à tela

        window.pack();//ajusta o tamanho da tela

        window.setLocationRelativeTo(null); // janela ao centro
        window.setVisible(true); // visível

        gamePanel.startGameThread();//inicia o jogo
    }
}