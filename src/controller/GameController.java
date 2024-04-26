package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import character.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class GameController {
    private Scanner scanner;
    private static GameController instance;
    private ArrayList<BaseCharacter> player1;
    private ArrayList<BaseCharacter> player2;
    private boolean isRunning;

    public static GameController getInstance(){
        if(instance == null){
            instance = new GameController();
        }
        return instance;
    }

    public void start(){
        setRunning(true);
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the game");
        System.out.println("Press 'p' to play the game or 'q' to quit");
        while(isRunning){
            if(scanner.nextLine().equals("p")){
                selectCharacterPhase();
                mainGamePhase();
            } else {
                System.out.println("Thank you for playing!");
                setRunning(false);
                break;
            }
            System.out.println("Enter 'p' to play again ot 'q' to quit");
        }
    }

    public void selectCharacterPhase(){
        System.out.println("select character");
        boolean[] selected = new boolean[8];
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int input;
            while(true){
                System.out.println("p2 choose char");
                input = Integer.parseInt(scanner.nextLine());
                if(!selected[input]){
                    selected[input] = true;
                    player2.add(new Dummy(("Dummy" + i), i + 1,  i + 1, i + 1, false));
                    break;
                } else {
                    System.out.println("character already chosen");
                }
            }
            while(true){
                System.out.println("p1 choose char");
                input = Integer.parseInt(scanner.nextLine());
                if(!selected[input]){
                    selected[input] = true;
                    player1.add(new Dummy(("Dummy" + i), i + 1,  i + 1, i + 1, true));
                    break;
                } else {
                    System.out.println("character already chosen");
                }
            }
        }
        player1.set(0, new FightingCat(true));
        System.out.println("Team1: ");
        for(BaseCharacter character : player1){
            System.out.println(character.toString());
        }
        System.out.println("Team2: ");
        for(BaseCharacter character : player2){
            System.out.println(character.toString());
        }
    }

    public void mainGamePhase(){
        int i = 0;
        BaseCharacter activeCharacter;
        while(!isGameOver()){
            // Player 1's turn
            activeCharacter = player1.get(i % 3);
            if(!activeCharacter.isDead()){
                System.out.println("It's player 1's " + activeCharacter.getName() + " turn!");
                System.out.println(activeCharacter.toString()); // TODO: It says toString() is redundant?
                System.out.println("Enter '0' to use normal attack, '1' to use " + activeCharacter.getFirstSkillName() + ", '2' to use " + activeCharacter.getSecondSkillName());
                int actionChoice = Integer.parseInt(scanner.nextLine());
                if(actionChoice == 2){
                    System.out.println(activeCharacter.useSecondSkill());
                } else if (actionChoice == 1){
                    System.out.println("Choose your target:");
                    BaseCharacter targetCharacter;
                    if(activeCharacter.isFirstSkillTargetEnemy()){
                        printCharactersInTeam(player2);
                        actionChoice = Integer.parseInt(scanner.nextLine());
                        targetCharacter = player2.get(actionChoice);
                    } else {
                        printCharactersInTeam(player1);
                        actionChoice = Integer.parseInt(scanner.nextLine());
                        targetCharacter = player1.get(actionChoice);
                    }
                    System.out.println(activeCharacter.useFirstSkill(targetCharacter));
                } else {
                    System.out.println("Choose your target:");
                    printCharactersInTeam(player2);
                    actionChoice = Integer.parseInt(scanner.nextLine());
                    System.out.println(activeCharacter.normalAttack(player2.get(actionChoice)));
                }
              if(isGameOver()){
                  break;
              }
            }

            // Player 2's turn
            activeCharacter = player2.get(i % 3);
            if(!activeCharacter.isDead()){
                System.out.println("It's player 2's " + activeCharacter.getName() + " turn!");
                System.out.println(activeCharacter.toString()); // TODO: It says toString() is redundant?
                System.out.println("Enter '0' to use normal attack, '1' to use " + activeCharacter.getFirstSkillName() + ", '2' to use " + activeCharacter.getSecondSkillName());
                int actionChoice = Integer.parseInt(scanner.nextLine());
                if(actionChoice == 2){
                    System.out.println(activeCharacter.useSecondSkill());
                } else if (actionChoice == 1){
                    System.out.println("Choose your target:");
                    BaseCharacter targetCharacter;
                    if(activeCharacter.isFirstSkillTargetEnemy()){
                        printCharactersInTeam(player1);
                        actionChoice = Integer.parseInt(scanner.nextLine());
                        targetCharacter = player1.get(actionChoice);
                    } else {
                        printCharactersInTeam(player2);
                        actionChoice = Integer.parseInt(scanner.nextLine());
                        targetCharacter = player2.get(actionChoice);
                    }
                    System.out.println(activeCharacter.useFirstSkill(targetCharacter));
                } else {
                    System.out.println("Choose your target:");
                    printCharactersInTeam(player1);
                    actionChoice = Integer.parseInt(scanner.nextLine());
                    System.out.println(activeCharacter.normalAttack(player1.get(actionChoice)));
                }
            }
            i++;
        }
    }

    public void printCharactersInTeam(ArrayList<BaseCharacter> team){
        for(int i = 0; i < 3; i++){
            if(!team.get(i).isDead()){
                System.out.println("[" + i + "] " + team.get(i));
            } else {
                System.out.println("[" + i + "] " + "[DEFEATED] " + team.get(i));
            }
        }
    }

    public boolean isGameOver(){
        boolean allCharactersAreDead = true;
        for(BaseCharacter character : player1){
            if(!character.isDead()){
                allCharactersAreDead = false;
                break;
            }
        }
        if(allCharactersAreDead){
            System.out.println("Player 2 wins!");
            return true;
        }
        allCharactersAreDead = true;
        for(BaseCharacter character : player2){
            if(!character.isDead()){
                allCharactersAreDead = false;
                break;
            }
        }
        if(allCharactersAreDead){
            System.out.println("Player 1 wins!");
            return true;
        }
        return false;
    }


    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public ArrayList<BaseCharacter> getPlayer1() {
        return player1;
    }

    public ArrayList<BaseCharacter> getPlayer2() {
        return player2;
    }


}
