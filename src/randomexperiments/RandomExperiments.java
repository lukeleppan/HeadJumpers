/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomexperiments;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;
import javax.swing.*;

public class RandomExperiments extends JPanel implements KeyListener, ActionListener, EventListener {

    public static int globalXData = 694;
    public static int globalYData = 371;
    public static int speed = 3;
    public static int Player1X = 30;
    public static int Player1Y = 135;
    public static int Player1VX;
    public static int Player1JumpTimer = 0;
    public static int Player2X = 654;
    public static int Player2Y = 135;
    public static int Player2VX;
    public static int TitleY = 60;

    public static int Clouds1X = 100;
    public static int Clouds1Y = 75;
    public static int Clouds2X = 500;
    public static int Clouds2Y = 50;

    public static float IntroText1Alpha = 0;
    public static float IntroText2Alpha = 0;
    public static float IntroText3Alpha = 0;

    public static boolean intro = true;
    public static boolean MainMenu = false;
    public static boolean level1 = false;
    public static boolean level2 = false;
    public static boolean clouds = false;
    public static boolean player1 = false;
    public static boolean player1EyeLeft = true, player1EyeRight;
    public static boolean player2 = false;
    public static boolean player2EyeLeft, player2EyeRight = true;
    public static boolean titleDown = true, titleUp = false;
    public static boolean StartButtonIdle = true, SettingsButtonIdle = true, QuitButtonIdle = true;

    public static boolean up, down, left, right;
    public static boolean w, s, a, d;
    public static boolean player1Jump = false, player2Jump = false;
    public static boolean player1Fall = true, player2Fall = true;
    public static boolean onGroundPlayer1, onGroundPlayer2;
    public static boolean ok = true;

    public static Color Red = new Color(255, 0, 0);
    public static Color Green = new Color(0, 255, 0);
    public static Color Blue = new Color(0, 255, 0);
    public static Color GroundBrown = new Color(71, 45, 5);
    public static Color GroungGreen = new Color(43, 94, 1);
    public static Color CloudColor = new Color(255, 255, 255);

    public static Color BackColorHappy = new Color(101, 157, 189);
    public static Color BackColorMenu = new Color(0, 31, 63, 255);
    public static Color BlackText = new Color(0, 0, 0, 255);
    public static Color BlackText2 = new Color(0, 0, 0, 150);
    public static Color IntroText1 = new Color(255, 255, 255, (int) IntroText1Alpha);
    public static Color NameText1 = new Color(138, 43, 225, (int) IntroText2Alpha);
    public static Color IntroText2 = new Color(255, 255, 255, (int) IntroText1Alpha);
    public static Color NameText2 = new Color(138, 43, 226, (int) IntroText2Alpha);
    public static Color HeadText = new Color(255, 127, 0);
    public static Color JumpersText = new Color(64, 224, 208);
    public static Color HeadText2 = new Color(255, 127, 0, 150);
    public static Color JumpersText2 = new Color(64, 224, 208, 150);

    public static Font FontCool = new Font("Comic Sans MS", Font.BOLD, 50);
    public static Font Font1 = new Font("Sans Serif", Font.BOLD, 75);
    public static Font font2 = new Font("Sans Serif", Font.BOLD, 60);
    public static Font font3 = new Font("Sans Serif", Font.BOLD, 33);
    public static Font font4 = new Font("Sans Serif", Font.BOLD, 40);

    public static JFrame window = new JFrame();
    public static RandomExperiments content = new RandomExperiments();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        if (intro) {
            g.setColor(BackColorMenu);
            g.fillRect(0, 0, 1000, 1000);

            g.setFont(FontCool);
            g.setColor(IntroText2);
            g.drawString("a game by", 73, 127);

            g.setFont(Font1);
            g.setColor(NameText2);
            g.drawString("Luke Leppan", 123, 202);

            g.setFont(FontCool);
            g.setColor(IntroText1);
            g.drawString("a game by", 75, 125);

            g.setFont(Font1);
            g.setColor(NameText1);
            g.drawString("Luke Leppan", 125, 200);

        }

        if (MainMenu) {
            g.setColor(BackColorMenu);
            g.fillRect(0, 0, 1000, 1000);

            g.setFont(font2);
            g.setColor(HeadText);
            g.drawString("Head", 155, TitleY);
            g.setColor(JumpersText);
            g.drawString("Jumpers", 295, TitleY);
            g.setColor(JumpersText2);
            g.drawString("Jumpers", 293, TitleY + 2);
            g.setColor(HeadText2);
            g.drawString("Head", 153, TitleY + 2);

            if (StartButtonIdle) {
                g.setColor(HeadText2);
                g.fillRoundRect(195, 110, 300, 75, 10, 10);
                g.setColor(HeadText);
                g.fillRoundRect(198, 107, 300, 75, 10, 10);
            } else {
                g.setColor(JumpersText2);
                g.fillRoundRect(195, 110, 300, 75, 10, 10);
                g.setColor(JumpersText);
                g.fillRoundRect(198, 107, 300, 75, 10, 10);
            }

            g.setColor(BlackText2);
            g.drawString("Start", 280, 165);
            g.setColor(BlackText);
            g.drawString("Start", 282, 163);

            if (SettingsButtonIdle) {
                g.setColor(HeadText2);
                g.fillRoundRect(195, 203, 140, 75, 10, 10);
                g.setColor(HeadText);
                g.fillRoundRect(198, 200, 140, 75, 10, 10);
            } else {
                g.setColor(JumpersText2);
                g.fillRoundRect(195, 203, 140, 75, 10, 10);
                g.setColor(JumpersText);
                g.fillRoundRect(198, 200, 140, 75, 10, 10);
            }

            g.setFont(font3);
            g.setColor(BlackText2);
            g.drawString("Settings", 203, 250);
            g.setColor(BlackText);
            g.drawString("Settings", 205, 248);

            if (QuitButtonIdle) {
                g.setColor(HeadText2);
                g.fillRoundRect(355, 203, 140, 75, 10, 10);
                g.setColor(HeadText);
                g.fillRoundRect(358, 200, 140, 75, 10, 10);
            } else {
                g.setColor(JumpersText2);
                g.fillRoundRect(355, 203, 140, 75, 10, 10);
                g.setColor(JumpersText);
                g.fillRoundRect(358, 200, 140, 75, 10, 10);
            }

            g.setFont(font4);
            g.setColor(BlackText2);
            g.drawString("Quit", 383, 253);
            g.setColor(BlackText);
            g.drawString("Quit", 385, 251);

        }

        if (level1 == true) {
            g.setColor(BackColorHappy);
            g.fillRect(0, 0, 1000, 1000);

            g.setColor(GroundBrown);
            g.fillRect(0, 331, 694, 40);
            g.setColor(GroungGreen);
            g.fillRect(0, 321, 694, 10);
        }

        if (level2 == true) {
            g.setColor(BackColorHappy);
            g.fillRect(0, 0, 1000, 1000);

            g.setColor(GroundBrown);
            g.fillRect(0, 331, 694, 40);
            g.fillRect(174, 251, 347, 80);

            g.setColor(GroungGreen);
            g.fillRect(0, 321, 174, 10);
            g.fillRect(520, 321, 174, 10);
            g.fillRect(174, 251, 10, 80);
            g.fillRect(511, 251, 10, 80);
            g.fillRect(174, 241, 347, 10);
        }

        if (clouds == true) {
            g.setColor(CloudColor);
            g.fillOval(Clouds1X + 20, Clouds1Y, 50, 50);
            g.fillOval(Clouds1X + 2, Clouds1Y - 15, 49, 49);
            g.fillOval(Clouds1X - 15, Clouds1Y - 2, 50, 50);

            g.fillOval(Clouds2X + 20, Clouds2Y, 50, 50);
            g.fillOval(Clouds2X + 2, Clouds2Y - 15, 49, 49);
            g.fillOval(Clouds2X - 15, Clouds2Y - 2, 50, 50);
        }

        if (player1 == true) {
            g.setColor(Red);
            g.fillRect(Player1X, Player1Y, 20, 40);
            g.setColor(Color.BLACK);
            g.drawRect(Player1X, Player1Y, 20, 40);
            if (player1EyeLeft) {
                g.setColor(Color.BLACK);
                g.fillRect(Player1X + 14, Player1Y + 5, 5, 5);
                g.fillRect(Player1X + 6, Player1Y + 5, 5, 5);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(Player1X + 2, Player1Y + 5, 5, 5);
                g.fillRect(Player1X + 10, Player1Y + 5, 5, 5);
            }
        }
        if (player2 == true) {
            g.setColor(Color.GREEN);
            g.fillRect(Player2X, Player2Y, 20, 40);
            g.setColor(Color.BLACK);
            g.drawRect(Player2X, Player2Y, 20, 40);
            if (player2EyeLeft) {
                g.setColor(Color.BLACK);
                g.fillRect(Player2X + 14, Player2Y + 5, 5, 5);
                g.fillRect(Player2X + 6, Player2Y + 5, 5, 5);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(Player2X + 2, Player2Y + 5, 5, 5);
                g.fillRect(Player2X + 10, Player2Y + 5, 5, 5);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        content.setFocusable(true);
        content.addKeyListener(content);
        content.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (MainMenu) {
                    if (mouseX > 197 && mouseX < 497 && mouseY > 106 && mouseY < 182) {
                        StartButtonIdle = false;
                        SettingsButtonIdle = true;
                        QuitButtonIdle = true;
                    } else if (mouseX > 197 && mouseX < 339 && mouseY > 199 && mouseY < 276) {
                        SettingsButtonIdle = false;
                        StartButtonIdle = true;
                        QuitButtonIdle = true;
                    } else if (mouseX > 357 && mouseX < 498 && mouseY > 199 && mouseY < 276) {
                        QuitButtonIdle = false;
                        SettingsButtonIdle = true;
                        StartButtonIdle = true;
                    } else {
                        StartButtonIdle = true;
                        SettingsButtonIdle = true;
                        QuitButtonIdle = true;
                    }
                }
            }
        });

        content.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (MainMenu) {
                    if (mouseX > 197 && mouseX < 497 && mouseY > 106 && mouseY < 182) {
                        MainMenu = false;
                        level1 = true;
                        player1 = true;
                        player2 = true;
                        clouds = true;
                    } else if (mouseX > 197 && mouseX < 339 && mouseY > 199 && mouseY < 276) {
                        System.out.println("Settings Coming Soon!");
                    } else if (mouseX > 357 && mouseX < 498 && mouseY > 199 && mouseY < 276) {
                        System.exit(0);
                    }
                }
            }
        });
        window.setContentPane(content);
        window.setResizable(false);
        window.setVisible(true);
        window.setLocation(0, 0);
        window.setSize(700, 400);
        window.setTitle("Head Jumpers");
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread.sleep(1000);
        while (true) {
            update.update();
            window.repaint();
            Thread.sleep((long) 16.66666666);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                s = true;
                break;
            case KeyEvent.VK_W:
                w = true;
                break;
            case KeyEvent.VK_A:
                a = true;
                break;
            case KeyEvent.VK_D:
                d = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                s = false;
                break;
            case KeyEvent.VK_W:
                w = false;
                break;
            case KeyEvent.VK_A:
                a = false;
                break;
            case KeyEvent.VK_D:
                d = false;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static class jumpThread1 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(300);
                player1Jump = false;
                player1Fall = true;
            } catch (Exception e) {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }
        }

    }

    public static class jumpThread2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(300);
                player2Jump = false;
                player2Fall = true;
            } catch (Exception e) {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }
        }
    }

    static class introWait implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                intro = false;
                MainMenu = true;
            } catch (Exception e) {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }
        }
    }

    static class titleMovement implements Runnable {

        @Override
        public void run() {
            try {
                ok = false;
                if (titleDown) {
                    Thread.sleep(40);
                    TitleY += 1;
                    if (TitleY == 80) {
                        titleDown = false;
                        titleUp = true;
                    }
                } else if (titleUp) {
                    Thread.sleep(40);
                    TitleY -= 1;
                    if (TitleY == 60) {
                        titleDown = true;
                        titleUp = false;
                    }
                }
                ok = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }

        }
    }
}
