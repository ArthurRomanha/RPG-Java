package main;

import javax.swing.JFrame; //biblioteca da janela

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame(); // cria uma nova janela
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechar janela quando clicar no "x"
        window.setResizable(false); // não será possível mudar seu tamanho padrão
        window.setTitle("MyGame"); // título da janela

        GameScreen gameScreen = new GameScreen(); // cria a tela
        window.add(gameScreen); // adiciona a tela à tela

        window.pack();//ajusta o tamanho da tela

        window.setLocationRelativeTo(null); // janela ao centro
        window.setVisible(true); // visível

        gameScreen.startGameThread();//inicia o jogo
    }
}