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
    final static boolean[] CharChoose = new boolean[16];
    private static BaseCharacter CharBaseCharacter;
    static boolean TernP2 = true;

    //----------------------------------------------
    static FightingCat FC1 = new FightingCat(true);
    static KnightCat KC1 = new KnightCat(true);
    static NinjaCat NC1 = new NinjaCat(true);
    static CatLord CL1 = new CatLord(true);
    static CursedCat CC1 = new CursedCat(true);
    static DoctorCat DC1 = new DoctorCat(true);
    static HolyCat HC1 = new HolyCat(true);
    static VampireCat VC1 = new VampireCat(true);
    static FightingCat FC2 = new FightingCat(false);
    static KnightCat KC2 = new KnightCat(false);
    static NinjaCat NC2 = new NinjaCat(false);
    static CatLord CL2 = new CatLord(false);
    static CursedCat CC2 = new CursedCat(false);
    static DoctorCat DC2 = new DoctorCat(false);
    static HolyCat HC2 = new HolyCat(false);
    static VampireCat VC2 = new VampireCat(false);
    //----------------------------------------------

    static ImageView fightingCat = GetDisplay.ImageImage(FC1.getImg(),100,100);
    static ImageView knightCat = GetDisplay.ImageImage(KC1.getImg(),100,100);
    static ImageView ninjaCat = GetDisplay.ImageImage(NC1.getImg(),100,100);
    static ImageView catLoad = GetDisplay.ImageImage(CL1.getImg(),100,100);
    static ImageView curseCat = GetDisplay.ImageImage(CC1.getImg(),100,100);
    static ImageView docterCat = GetDisplay.ImageImage(DC1.getImg(),100,100);
    static ImageView holyCat = GetDisplay.ImageImage(HC1.getImg(),100,100);
    static ImageView vampireCat = GetDisplay.ImageImage(VC1.getImg(),100,100);

    static ImageView[] catImages = {fightingCat, knightCat, ninjaCat, catLoad, curseCat, docterCat, holyCat, vampireCat};
    static BaseCharacter[] catCharacters = {FC1, KC1, NC1, CL1, CC1, DC1, HC1, VC1, FC2, KC2, NC2, CL2, CC2, DC2, HC2, VC2};

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

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            catImages[i].setOnMouseClicked(event -> handleCharacterSelection(catCharacters[finalI], catImages[finalI]));
        }

        line1.getChildren().addAll(catImages[0], catImages[1], catImages[2], catImages[3]);
        line2.getChildren().addAll(catImages[4], catImages[5], catImages[6], catImages[7]);

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
                if( CharChoose[position] || (TernP2 && CharChoose[position-8]) || (!TernP2 && CharChoose[position+8]) ){
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

                        System.out.println("P2-> " + GameController.getInstance().getPlayer2());
                        TernP2 = false;

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
                        System.out.println("P1-> " + GameController.getInstance().getPlayer1() );
                        TernP2 = true;
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

    private static void handleCharacterSelection(BaseCharacter catCharacter, ImageView catImage) {
        ColorAdjust colorAdjust = new ColorAdjust();
        ColorAdjust NOcolorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        NOcolorAdjust.setBrightness(0);

        for (int i = 0; i < 8; i++) {
            int finalII = i;
            if( catImages[finalII] == catImage ) {
                catImage.setEffect(colorAdjust);
            }
            else {
                catImages[finalII].setEffect(NOcolorAdjust);
            }
        }

        ImageView charCopy = new ImageView();
        charCopy.setImage(catImage.getImage());
        charCopy.setFitHeight(catImage.getFitHeight());
        charCopy.setFitWidth(catImage.getFitWidth());

        CharChooseBFbutton.getChildren().clear();
        CharChooseBFbutton.getChildren().add(charCopy);
        System.out.println(catImage);

        CharBaseCharacter = catCharacter;
        System.out.println(CharBaseCharacter);

        if (catCharacter.equals(FC1)) {
            position=0;
        }
        else if (catCharacter.equals(KC1)){
            position=1;
        }
        else if (catCharacter.equals(NC1)) {
            position=2;
        }
        else if (catCharacter.equals(CL1)) {
            position=3;
        }
        else if (catCharacter.equals(CC1)) {
            position=4;
        }
        else if (catCharacter.equals(DC1)) {
            position=5;
        }else if (catCharacter.equals(HC1)) {
            position=6;
        }else if (catCharacter.equals(VC1)) {
            position=7;
        }

        if(TernP2) {
            position = position+8;
        }

        System.out.println("position -> " + position);

    }


    public static void GamePage() {
        clear();
        ImageView background = GetDisplay.ImageImage("BG/field.jpg",580,1000);

        VBox main = new VBox();

        StackPane stack = new StackPane(background, main);
        rootPane.getChildren().add(stack);

    }

}