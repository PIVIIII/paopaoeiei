package utils;

import character.*;
import controller.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
//import pane.NewBookPane;
//import pane.CharPane;
//import pane.ChooseChar;
import pane.RootPane;
//import pane.BookListPane;

//import pane.SearchPane;

public class Goto {
    private static RootPane rootPane;

    static HBox ListCharP1 = new HBox();
    static HBox ListCharP2 = new HBox();
    final static HBox CharChooseBFbutton = new HBox();
//    final static BaseCharacter ChooseChar ;

    //----------------------------------------------
    static FightingCat FC = new FightingCat(true);
    static KnightCat KC = new KnightCat(true);
    static NinjaCat NC = new NinjaCat(true);
    static CatLord CL = new CatLord(true);
    static CursedCat CC = new CursedCat(true);
    static DoctorCat DC = new DoctorCat(true);
    static HolyCat HC = new HolyCat(true);
    static VampireCat VC = new VampireCat(true);
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
        button.setPrefWidth(100);
        button.setPrefHeight(40);
        button.setBackground(Background.fill(Color.DARKCYAN));
        button.setTextFill(Color.WHITE);
        button.setOnMouseClicked(e->choosePage());

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


        fightingCat.setOnMouseClicked(event -> handleCharacterSelection(FC.getName(),fightingCat,knightCat,ninjaCat,catLoad,curseCat,docterCat,holyCat,vampireCat));
        knightCat.setOnMouseClicked(event -> handleCharacterSelection(KC.getName(),knightCat,fightingCat,ninjaCat,catLoad,curseCat,docterCat,holyCat,vampireCat));
        ninjaCat.setOnMouseClicked(event -> handleCharacterSelection(NC.getName(),ninjaCat,knightCat,fightingCat,catLoad,curseCat,docterCat,holyCat,vampireCat));
        catLoad.setOnMouseClicked(event -> handleCharacterSelection(CL.getName(),catLoad,knightCat,ninjaCat,fightingCat,curseCat,docterCat,holyCat,vampireCat));
        curseCat.setOnMouseClicked(event -> handleCharacterSelection(CC.getName(),curseCat,knightCat,ninjaCat,catLoad,fightingCat,docterCat,holyCat,vampireCat));
        docterCat.setOnMouseClicked(event -> handleCharacterSelection(DC.getName(),docterCat,knightCat,ninjaCat,catLoad,curseCat,fightingCat,holyCat,vampireCat));
        holyCat.setOnMouseClicked(event -> handleCharacterSelection(HC.getName(),holyCat,knightCat,ninjaCat,catLoad,curseCat,docterCat,fightingCat,vampireCat));
        vampireCat.setOnMouseClicked(event -> handleCharacterSelection(VC.getName(),vampireCat,knightCat,ninjaCat,catLoad,curseCat,docterCat,holyCat,fightingCat));


        line1.getChildren().addAll(fightingCat, knightCat, ninjaCat, curseCat);
        line2.getChildren().addAll(docterCat, holyCat, catLoad, vampireCat);

        //---------------------
        Button button = new Button("Choose");
        button.setPrefWidth(90);
        button.setPrefHeight(30);
        button.setBackground(Background.fill(Color.ORANGE));
        button.setTextFill(Color.WHITE);

        Button nextGamebutton = new Button("Next >>");
        nextGamebutton.setPrefWidth(90);
        nextGamebutton.setPrefHeight(30);
        nextGamebutton.setBackground(Background.fill(Color.YELLOW));
        nextGamebutton.setTextFill(Color.BLACK);


        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(button);

        nextGamebutton.setOnMouseClicked(e->GamePage());


        button.setOnMouseClicked(event -> {
            if (CharChooseBFbutton.getChildren().isEmpty() ) {
                System.out.println("Please select a character first.");
            }
            else {
                System.out.println("Selected character(s):");
                ListCharP1.getChildren().add(CharChooseBFbutton.getChildren().get(0));
//                GameController.getInstance().setPlayer1(GameController.getInstance().getPlayer1().add());
//                System.out.println(GameController.getInstance().getPlayer1());
                if(ListCharP1.getChildren().size()==3) {
                    buttonBox.getChildren().remove(0);
                    buttonBox.getChildren().add(nextGamebutton);
                }
            }
        });
        //---------------------


        mainPage.getChildren().addAll(text, line1, line2, buttonBox, ListCharP1);
        StackPane stack = new StackPane(backgroundChoose, mainPage);
        rootPane.getChildren().add(stack);
    }


    private static void handleCharacterSelection(String BaseChar ,ImageView selectedCharacter,ImageView noSelect1,ImageView noSelect2,ImageView noSelect3,ImageView noSelect4,ImageView noSelect5,ImageView noSelect6,ImageView noSelect7) {
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
    }

    public static void GamePage() {

    }
}

