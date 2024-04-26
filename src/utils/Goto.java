package utils;

import controller.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
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

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    public static void clear() {
//        if (rootPane != null && rootPane.getChildren().size() > 1) {
//            rootPane.getChildren().remove(1, rootPane.getChildren().size());
//        }
        rootPane.getChildren().clear();
    }

//    public static Button ChooseButton() {
////        button.setOnMouseClicked(e -> Goto.addNewBookPage());
//        return button;
//    }

    public static void mainPage() {
        clear();
        ImageView background = GetDisplay.ImageImage("BG/castle.png");
        background.setFitHeight(550);
        background.setFitWidth(1000);

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
        ImageView backgroundChoose = GetDisplay.ImageImage("BG/choose2.jpg");
        backgroundChoose.setFitHeight(580);
        backgroundChoose.setFitWidth(1000);

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

        ImageView fightingCat = GetDisplay.ImageImage("Cat/FightingCat.PNG");
        fightingCat.setFitHeight(100);
        fightingCat.setFitWidth(100);

        ImageView knightCat = GetDisplay.ImageImage("Cat/KnightCat.PNG");
        knightCat.setFitHeight(100);
        knightCat.setFitWidth(100);

        ImageView ninjaCat = GetDisplay.ImageImage("Cat/NinjaCat.PNG");
        ninjaCat.setFitHeight(100);
        ninjaCat.setFitWidth(100);

        ImageView catLoad = GetDisplay.ImageImage("Cat/CatLoad.PNG");
        catLoad.setFitHeight(100);
        catLoad.setFitWidth(100);

        ImageView curseCat = GetDisplay.ImageImage("Cat/CurseCat.PNG");
        curseCat.setFitHeight(100);
        curseCat.setFitWidth(100);

        ImageView docterCat = GetDisplay.ImageImage("Cat/DocterCat.PNG");
        docterCat.setFitHeight(100);
        docterCat.setFitWidth(100);

        ImageView holyCat = GetDisplay.ImageImage("Cat/HolyCat.PNG");
        holyCat.setFitHeight(100);
        holyCat.setFitWidth(100);

        ImageView vampireCat = GetDisplay.ImageImage("Cat/VampireCat.PNG");
        vampireCat.setFitHeight(100);
        vampireCat.setFitWidth(100);

        line1.getChildren().addAll(fightingCat, knightCat, ninjaCat, curseCat);
        line2.getChildren().addAll(docterCat, holyCat, catLoad, vampireCat);

        Button button = new Button("Choose");
        button.setPrefWidth(90);
        button.setPrefHeight(30);
        button.setBackground(Background.fill(Color.ORANGE));
        button.setTextFill(Color.WHITE);

        mainPage.getChildren().addAll(text, line1, line2, button);
        StackPane stack = new StackPane(backgroundChoose, mainPage);
        rootPane.getChildren().add(stack);
    }

}

//        gridPane2.add(char1,0,1);
//        setOnMouseClicked(e -> Goto.bookPage(char1));
