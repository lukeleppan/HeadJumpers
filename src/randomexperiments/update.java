/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomexperiments;

import java.awt.Color;
import static randomexperiments.RandomExperiments.*;

/**
 *
 * @author 21lepplu
 */
public class update {
    static void update() {
        
        if (intro){
            if(IntroText1Alpha < 200){
                IntroText1Alpha += 1;
                IntroText1 = new Color(255, 255, 255, (int) IntroText1Alpha);
                IntroText2Alpha += 1;
                NameText1 = new Color(138, 43, 226, (int) IntroText2Alpha);
            }
            else{
                new Thread(new RandomExperiments.introWait()).start();
            }
            if(IntroText3Alpha < 150){
                IntroText3Alpha += 1;
                IntroText2 = new Color(255, 255, 255, (int) IntroText3Alpha);
                NameText2 = new Color(138, 43, 226, (int) IntroText3Alpha);
            }
        }
        
        if (MainMenu && ok){
            new Thread(new RandomExperiments.titleMovement()).start();
        }
        //Handles Collisions and Gravity for Level 1!
        if (level1){
            if (Player1Y < 281 && player1Fall == true) {
                Player1Y += 5;
                onGroundPlayer1 = false;
            }
            else if (Player1Y >= 281){
                onGroundPlayer1 = true;
            }
            if (Player2Y < 281 && player2Fall == true) {
                Player2Y += 5;
                onGroundPlayer2 = false;
            }
            else if (Player2Y >= 281){
                onGroundPlayer2 = true;
            }
        }
        //------------------------------------------------
        
        
        //Handles Collisions and Gravity for Level 2!
        if (level2){
            if (Player1Y < 201 && player1Fall == true && Player1X > 173 && Player1X < 521) {
                Player1Y += 5;
                onGroundPlayer1 = false;
            }
            else if (Player1Y >= 201 && Player1X > 173 && Player1X < 521){
                onGroundPlayer1 = true;
            }
            else if (Player1Y < 281 && player1Fall == true && Player1X > -15 && Player1X < 174){
                Player1Y += 5;
                onGroundPlayer1 = false;
            }
            else if (Player1Y >= 201 && Player1X > -15 && Player1X < 175){
                onGroundPlayer1 = true;
            }
            else if (Player1Y < 281 && player1Fall == true && Player1X > 520 && Player1X < 706){
                Player1Y += 5;
                onGroundPlayer1 = false;
            }
            else if (Player1Y >= 201 && Player1X > 520 && Player1X < 706){
                onGroundPlayer1 = true;
            }
            
            
            if (Player2Y < 201 && player2Fall == true && Player2X > 173 && Player2X < 521) {
                Player2Y += 5;
                onGroundPlayer2 = false;
            }
            else if (Player2Y >= 201 && Player2X > 173 && Player2X < 521){
                onGroundPlayer2 = true;
            }
            else if (Player2Y < 281 && player2Fall == true && Player2X > -15 && Player2X < 174){
                Player2Y += 5;
                onGroundPlayer2 = false;
            }
            else if (Player2Y >= 201 && Player2X > -15 && Player2X < 175){
                onGroundPlayer2 = true;
            }
            else if (Player2Y < 281 && player2Fall == true && Player2X > 520 && Player2X < 706){
                Player2Y += 5;
                onGroundPlayer2 = false;
            }
            else if (Player2Y >= 201 && Player2X > 520 && Player2X < 706){
                onGroundPlayer2 = true;
            }
        }
        //------------------------------------------------
        
        
        //Handles Telporting to other sides!
        if (Player1X < -10){
            Player1X = 702;
        }
        if (Player1X > 702){
            Player1X = -10;
        }
        if (Player2X < -10){
            Player2X = 702;
        }
        if (Player2X > 702){
            Player2X = -10;
        }
        //-------------------------------
        
        
        //Handles Jumping!
        if (player1Jump){
            Player1Y -= 7;
        }
        if (player2Jump){
            Player2Y -= 7;
        }
        if(up && onGroundPlayer2){
            onGroundPlayer2 = false;
            player2Jump = true;
            player2Fall = false;
            new Thread(new RandomExperiments.jumpThread2()).start();
        }
        if(w && onGroundPlayer1){
            onGroundPlayer1 = false;
            player1Jump = true;
            player1Fall = false;
            new Thread(new RandomExperiments.jumpThread1()).start();
        }
        //----------------------------------------------
        
        
        //Handles Movement, Left and Right!
        Player1VX = 0;
        Player2VX = 0;
        
        if (level1){
            if(a){
                Player1VX = -speed;
                player1EyeRight = true;
                player1EyeLeft = false;
            }
            if(d){
                Player1VX = speed;
                player1EyeLeft = true;
                player1EyeRight = false;
            }
            if(left){
                Player2VX = -speed;
                player2EyeRight = true;
                player2EyeLeft = false;
            }
            if(right){
                Player2VX = speed;
                player2EyeLeft = true;
                player2EyeRight = false;
            }
        
            Player1X += Player1VX;
            Player2X += Player2VX;
        }
        
        if (level2){
            if(a && Player1X > -15 && Player1X < 154 || a && Player1X > 521 && Player1X < 710){
                Player1VX = -speed;
                player1EyeRight = true;
                player1EyeLeft = false;
            }
            else if(a && Player1X > 154 && Player1X < 511 && Player1Y < 201){
                Player1VX = -speed;
                player1EyeRight = true;
                player1EyeLeft = false;
            }
            if(d && Player1X > -15 && Player1X < 152 || d && Player1X > 518 && Player1X < 710){
                Player1VX = speed;
                player1EyeLeft = true;
                player1EyeRight = false;
            }
            if(d && Player1X > 134 && Player1X < 491 && Player1Y < 201){
                Player1VX = +speed;
                player1EyeRight = true;
                player1EyeLeft = false;
            }
            if(left){
                Player2VX = -speed;
                player2EyeRight = true;
                player2EyeLeft = false;
            }
            if(right){
                Player2VX = speed;
                player2EyeLeft = true;
                player2EyeRight = false;
            }
        
            Player1X += Player1VX;
            Player2X += Player2VX;
        }
        //---------------------------------------------------
        
        
        //Handles Player Collisions!
        if (Player1X >= Player2X && Player1X <= Player2X + 20){
            
        }
        //--------------------------------
    }
}
