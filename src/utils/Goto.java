package utils;

import character.*;
import controller.GameController;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pane.RootPane;

import java.util.ArrayList;
//import pane.BookListPane;

//import pane.SearchPane;

public class Goto {
    private static RootPane rootPane;

    final static HBox CharChooseBFbutton = new HBox();
    private static int position ;
    final static boolean[] CharChoose = new boolean[8];
    private static BaseCharacter CharBaseCharacter;
    static boolean TernP2 = true;

    //----------------------------------------------
    static FightingCat FC = new FightingCat(TernP2);
    static KnightCat KC = new KnightCat(TernP2);
    static NinjaCat NC = new NinjaCat(TernP2);
    static CatLord CL = new CatLord(TernP2);
    static CursedCat CC = new CursedCat(TernP2);
    static DoctorCat DC = new DoctorCat(TernP2);
    static HolyCat HC = new HolyCat(TernP2);
    static VampireCat VC = new VampireCat(TernP2);
    //----------------------------------------------

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    public static void clear() {
        rootPane.getChildren().clear();
    }

    public static void mainPage() {
        clear();
        ImageView background = GetDisplay.ImageImage("BG/castle.png",550,1000);

        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);
        main.setSpacing(250);
        main.setPadding(new Insets(5, 0, 0, 0));

        Text title = new Text("CatCatCat");
        title.setFont(Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 80));
        title.setFill(Color.WHITE);

        Button button = new Button("Start");
        button.setPrefWidth(130);
        button.setPrefHeight(30);
        button.setBackground(Background.fill(Color.DARKCYAN));
        button.setTextFill(Color.WHITE);
        button.setOnMouseClicked(e->choosePage());
        button.setFont(Font.font("Berlin Sans FB Demi", FontWeight.NORMAL, 30));


        main.getChildren().addAll(title, button);
        StackPane stack = new StackPane(background, main);
        rootPane.getChildren().add(stack);
    }

    public static void choosePage() {
        clear();
        ImageView backgroundChoose = GetDisplay.ImageImage("BG/choose2.jpg",580,1000);

        Text text = new Text("Choose Your Character");
        text.setFont(Font.font("Berlin Sans FB Demi", FontWeight.BOLD, 60));
        text.setFill(Color.WHITE);

        VBox mainPage = new VBox();
        mainPage.setAlignment(Pos.CENTER);
        mainPage.setSpacing(30);

        HBox line1 = new HBox();
        line1.setSpacing(50);
        line1.setAlignment(Pos.CENTER);

        HBox line2 = new HBox();
        line2.setSpacing(50);
        line2.setAlignment(Pos.CENTER);

        ImageView fightingCat = GetDisplay.ImageImage(FC.getImg(),100,100);
        ImageView knightCat = GetDisplay.ImageImage(KC.getImg(),100,100);
        ImageView ninjaCat = GetDisplay.ImageImage(NC.getImg(),100,100);
        ImageView catLoad = GetDisplay.ImageImage(CL.getImg(),100,100);
        ImageView curseCat = GetDisplay.ImageImage(CC.getImg(),100,100);
        ImageView docterCat = GetDisplay.ImageImage(DC.getImg(),100,100);
        ImageView holyCat = GetDisplay.ImageImage(HC.getImg(),100,100);
        ImageView vampireCat = GetDisplay.ImageImage(VC.getImg(),100,100);

        fightingCat.setOnMouseClicked(event -> handleCharacterSelection(FC,fightingCat,knightCat,ninjaCat,catLoad,curseCat,docterCat,holyCat,vampireCat));
        knightCat.setOnMouseClicked(event -> handleCharacterSelection(KC,knightCat,fightingCat,ninjaCat,catLoad,curseCat,docterCat,holyCat,vampireCat));
        ninjaCat.setOnMouseClicked(event -> handleCharacterSelection(NC,ninjaCat,knightCat,fightingCat,catLoad,curseCat,docterCat,holyCat,vampireCat));
        catLoad.setOnMouseClicked(event -> handleCharacterSelection(CL,catLoad,knightCat,ninjaCat,fightingCat,curseCat,docterCat,holyCat,vampireCat));
        curseCat.setOnMouseClicked(event -> handleCharacterSelection(CC,curseCat,knightCat,ninjaCat,catLoad,fightingCat,docterCat,holyCat,vampireCat));
        docterCat.setOnMouseClicked(event -> handleCharacterSelection(DC,docterCat,knightCat,ninjaCat,catLoad,curseCat,fightingCat,holyCat,vampireCat));
        holyCat.setOnMouseClicked(event -> handleCharacterSelection(HC,holyCat,knightCat,ninjaCat,catLoad,curseCat,docterCat,fightingCat,vampireCat));
        vampireCat.setOnMouseClicked(event -> handleCharacterSelection(VC,vampireCat,knightCat,ninjaCat,catLoad,curseCat,docterCat,holyCat,fightingCat));


        line1.getChildren().addAll(fightingCat, knightCat, ninjaCat, curseCat);
        line2.getChildren().addAll(docterCat, holyCat, catLoad, vampireCat);

        //---------------------
        Button button = new Button("Choose");
        button.setPrefWidth(120);
        button.setPrefHeight(30);
        button.setBackground(Background.fill(Color.ORANGE));
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font("Berlin Sans FB Demi", FontWeight.NORMAL, 20));

        Button nextGamebutton = new Button("Next >>");
        nextGamebutton.setPrefWidth(120);
        nextGamebutton.setPrefHeight(30);
        nextGamebutton.setBackground(Background.fill(Color.YELLOW));
        nextGamebutton.setTextFill(Color.BLACK);
        nextGamebutton.setFont(Font.font("Berlin Sans FB Demi", FontWeight.NORMAL, 20));


        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(button);

        nextGamebutton.setOnMouseClicked(e->GamePage());


        HBox ListCharP1 = new HBox();
        HBox ListCharP2 = new HBox();
        button.setOnMouseClicked(event -> {
            if (CharChooseBFbutton.getChildren().isEmpty() ) {
                System.out.println("Please select a character first.");
            }
            else {
                if( CharChoose[position] ){
                    System.out.println("Same Char Choose");
                }
                else {
                    if(TernP2) {
                        CharChooseBFbutton.getChildren().get(0).setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

                        ListCharP2.getChildren().add(CharChooseBFbutton.getChildren().get(0));

                        ArrayList<BaseCharacter> player2Characters = GameController.getInstance().getPlayer1();
                        if (player2Characters == null) {
                            player2Characters = new ArrayList<>();
                            GameController.getInstance().setPlayer2(player2Characters);
                            GameController.getInstance().getPlayer2().add(CharBaseCharacter);
                        }
                        else {
                            GameController.getInstance().getPlayer2().add(CharBaseCharacter);
                        }

                        System.out.println("eiei2-> " + GameController.getInstance().getPlayer2());
                        TernP2 = false;
                        System.out.println(TernP2);

                    }else {
                        ListCharP1.getChildren().add(CharChooseBFbutton.getChildren().get(0));

                        ArrayList<BaseCharacter> player1Characters = GameController.getInstance().getPlayer1();
                        if (player1Characters == null) {
                            player1Characters = new ArrayList<>();
                            GameController.getInstance().setPlayer1(player1Characters);
                            GameController.getInstance().getPlayer1().add(CharBaseCharacter);
                        }
                        else {
                            GameController.getInstance().getPlayer1().add(CharBaseCharacter);
                        }
                        System.out.println("eiei-> " + GameController.getInstance().getPlayer1() );
                        TernP2 = true;
                        System.out.println(TernP2);
                    }
                    CharChoose[position] = true;
                    if(ListCharP1.getChildren().size()==3 && ListCharP2.getChildren().size()==3) {
                        buttonBox.getChildren().remove(0);
                        buttonBox.getChildren().add(nextGamebutton);
                    }
                }
            }
        });

        //---------------------

        HBox charChoose = new HBox();

        charChoose.getChildren().addAll(ListCharP1, ListCharP2 );
        charChoose.setAlignment(Pos.CENTER_RIGHT);
        charChoose.setSpacing(400);

        mainPage.getChildren().addAll(text, line1, line2, buttonBox, charChoose);
        StackPane stack = new StackPane(backgroundChoose, mainPage);
        rootPane.getChildren().add(stack);
    }


    private static void handleCharacterSelection(BaseCharacter BaseChar ,ImageView selectedCharacter,ImageView noSelect1,ImageView noSelect2,ImageView noSelect3,ImageView noSelect4,ImageView noSelect5,ImageView noSelect6,ImageView noSelect7) {
        ColorAdjust colorAdjust = new ColorAdjust();
        ColorAdjust NOcolorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        NOcolorAdjust.setBrightness(0);

        selectedCharacter.setEffect(colorAdjust);
        noSelect1.setEffect(NOcolorAdjust);
        noSelect2.setEffect(NOcolorAdjust);
        noSelect3.setEffect(NOcolorAdjust);
        noSelect4.setEffect(NOcolorAdjust);
        noSelect5.setEffect(NOcolorAdjust);
        noSelect6.setEffect(NOcolorAdjust);
        noSelect7.setEffect(NOcolorAdjust);

        ImageView charCopy = new ImageView();
        charCopy.setImage(selectedCharacter.getImage());
        charCopy.setFitHeight(selectedCharacter.getFitHeight());
        charCopy.setFitWidth(selectedCharacter.getFitWidth());

        CharChooseBFbutton.getChildren().clear();
        CharChooseBFbutton.getChildren().add(charCopy);
        System.out.println(selectedCharacter);

        if (BaseChar.equals(FC)) {
            position=0;
        }
        else if (BaseChar.equals(KC)){
            position=1;
        }
        else if (BaseChar.equals(NC)) {
            position=2;
        }
        else if (BaseChar.equals(CL)) {
            position=3;
        }
        else if (BaseChar.equals(CC)) {
            position=4;
        }
        else if (BaseChar.equals(DC)) {
            position=5;
        }else if (BaseChar.equals(HC)) {
            position=6;
        }else if (BaseChar.equals(VC)) {
            position=7;
        }
//        System.out.println(position);
//        System.out.println(BaseChar);

        CharBaseCharacter = BaseChar;
        System.out.println(CharBaseCharacter);

    }

    public static void GamePage() {
        clear();
        ImageView background = GetDisplay.ImageImage("BG/field.jpg",580,1000);

        VBox main = new VBox();

        StackPane stack = new StackPane(background, main);
        rootPane.getChildren().add(stack);

    }

}