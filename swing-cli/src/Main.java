import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main{
    public static JFrame menu = new JFrame();
    public static JFrame main = new JFrame();        
    public static int sizeX = 1200;
    public static int sizeY = 900;
    public static int buttonSizeX = 100;
    public static int buttonSizeY = 50;
    public static void main(String[] args){        
        initMenu();
    }

    //button actions
    public static void startClick(){
        System.out.println("Start button click...");
        initMain();
    }
    public static void settingsClick(){
        System.out.println("Settings button click...");
    }
    public static void exitClick(){
        System.out.println("Exit button click...");
    }

    //init/close frames
    public static void closeAll(){
        main.setVisible(false);
        menu.setVisible(false);
    }
    public static void initMain(){
        closeAll();

        //frame config
        main.setSize(sizeX, sizeY);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
    public static void initMenu(){
        closeAll();
        
        //buttons
        JButton start = new JButton("Start");
        start.setBounds(sizeX/2, sizeY/2  - 80, buttonSizeX, buttonSizeY);
        menu.add(start);

        JButton settings = new JButton("Settings");
        settings.setBounds(sizeX/2, sizeY/2, buttonSizeX, buttonSizeY);
        menu.add(settings);

        JButton exit = new JButton("Exit");
        exit.setBounds(sizeX/2, sizeY/2 + 80, buttonSizeX, buttonSizeY);
        menu.add(exit);

        //button events
        start.addActionListener(e->
            startClick()
        );
        settings.addActionListener(e->
            settingsClick()
        );
        exit.addActionListener(e->
            exitClick()
        );

        //frame config
        menu.setSize(sizeX, sizeY);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
}