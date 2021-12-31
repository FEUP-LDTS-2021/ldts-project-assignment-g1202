import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;



public class Game {
    //Iniciar variaveis - Terminais e screen

    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, choiceButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    Font normalFont = new Font("Arial", Font.PLAIN, 30);
    JButton startButton, surv, pvp;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public Game() throws IOException { // construtor de Game
        try {

            //Terminal
            window = new JFrame();
            window.setSize(800,600);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.black);
            window.setLayout(null);
            window.setVisible(true);
            con = window.getContentPane();

            //Painel que recebe titulo
            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100,70,600,150);
            titleNamePanel.setBackground(Color.black);
            titleNameLabel = new JLabel("DUNGEON BOY");
            titleNameLabel.setForeground(Color.white);
            titleNameLabel.setFont(titleFont);

            //Painel que recebe o botão start
            startButtonPanel = new JPanel();
            startButtonPanel.setBounds(300,400,200,100);
            startButtonPanel.setBackground(Color.black);

            //Botao de start
            startButton = new JButton("START");
            startButton.setBackground(Color.black);
            startButton.setForeground(Color.white);
            startButton.setFont(normalFont);
            startButton.addActionListener(tsHandler); // receber click do rato no botao start

            //Adds para aparecerem no programa
            titleNamePanel.add(titleNameLabel);
            startButtonPanel.add(startButton);
            con.add(titleNamePanel);
            con.add(startButtonPanel);

            screen.startScreen(); // start


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createGameMenu(){

        //Temos de "desligar" o botao start quando ele é carregado
        startButtonPanel.setVisible(false);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(120,275,500,100);
        choiceButtonPanel.setBackground(Color.black);
        con.add(choiceButtonPanel);

        //Botão survival mode
        surv = new JButton("Survival Mode");
        surv.setBackground(Color.black);
        surv.setForeground(Color.white);
        surv.setFont(normalFont);
        choiceButtonPanel.add(surv);

        //Botão PVP
        pvp = new JButton("PvP Mode");
        pvp.setBackground(Color.black);
        pvp.setForeground(Color.white);
        pvp.setFont(normalFont);
        choiceButtonPanel.add(pvp);
    }
    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            createGameMenu(); // cria nova janela com o menu
        }
    }

    public void survival() throws IOException{
        screen.clear();

        Arena arena = new Arena(80, 24);
        arena.draw(tg);
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3, 1, "Survival");

        screen.refresh();

        boolean keepRunning = true;

        while (keepRunning){
            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                menu();
            }
        }
    }

    public void pvp() throws IOException{
        screen.clear();

        Arena arena = new Arena(80, 24);
        arena.draw(tg);
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(3,1,"Player VS Player");

        screen.refresh();

        boolean keepRunning = true;

        while (keepRunning){
            KeyStroke keyPressed = terminal.readInput();
            if (keyPressed.getKeyType() == KeyType.Escape) {
                keepRunning = false;
                menu();
            }
        }
    }

    public void menu() throws IOException{
        screen.clear();
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
        tg.putString(8,10, "Survival Mode");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(8,13, "Player VS Player Mode");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53,3, "ArrowUp (Go UP)");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(53,5, "ArrowDown (Go Down)");

        screen.refresh();

        boolean keepRunning = true;
        boolean surv = true;

        while (keepRunning){
            KeyStroke keyPressed = terminal.readInput();

            switch (keyPressed.getKeyType()){
                case ArrowDown:
                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                    tg.putString(8,10, "Survival Mode");

                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.putString(8,13, "Player VS Player Mode");

                    screen.refresh();

                    surv = false;
                    break;
                case ArrowUp:
                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
                    tg.putString(8,10, "Survival Mode");

                    tg.setForegroundColor(TextColor.ANSI.DEFAULT);
                    tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
                    tg.putString(8,13, "Player VS Player Mode");

                    screen.refresh();

                    surv = true;
                    break;
                case Enter:
                    keepRunning = false;
                    if (surv){
                        survival();
                    }
                    else{
                        pvp();
                    }
                    break;
                case Escape:
                    keepRunning = false;
                    run();
            }
        }
    }

    //Ciclo para manter terminal aberto ate receber alguma key que quebre

    public void run() throws IOException {

        boolean keepRunning = true;
        StringBuilder sb = new StringBuilder();

        screen.clear();
        screen.setCursorPosition(null);
        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(30, 15,"Press ENTER to START");

        tg.setForegroundColor(TextColor.ANSI.DEFAULT);
        tg.setBackgroundColor(TextColor.ANSI.DEFAULT);
        tg.putString(35, 4,"CAVE BOYYYY");
        screen.refresh();

        while (keepRunning) {
            KeyStroke keyPressed = terminal.pollInput();

            if (keyPressed != null) {
                switch (keyPressed.getKeyType()) {
                    case Escape:
                        keepRunning = false;
                        System.out.println("Exiting...");
                        break;
                    case Enter:
                        System.out.println("Enter");
                        menu();
                        sb = new StringBuilder();
                        break;
                    case ArrowDown:
                        //System.out.println("baixo");
                        break;
                    case ArrowLeft:
                        System.out.println("Esq");
                        break;
                    case ArrowRight:
                        System.out.println("Drt");
                        break;
                 /*  case Character:
                      if(Character == 'x'){
                          System.out.println("Carreguei no x");
                      }
                       // break;
                   */ //case (keyPressed.getKeyType() == KeyType.Character && keyPressed.getCharacter() == 'x')
                }

            }

        }
        //screen.refresh();
        //screen.readInput(); // read users input
        screen.stopScreen();
    }


}




