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

        VBox mainPage = new VBox();


        GridPane gridPane = new GridPane();
        Text ChooseText = GetDisplay.TextText("ChooseCharacter",30,250);
//        gridPane.add(ChooseText,1,1);


        GridPane gridPane2 = new GridPane();
        ImageView char1 = GetDisplay.ImageImage("Cat/CatLoad.PNG");
        char1.setFitHeight(100);
        char1.setFitWidth(100);

        ImageView char2 = GetDisplay.ImageImage("Cat/CurseCat.PNG");
        char2.setFitHeight(100);
        char2.setFitWidth(100);

        ImageView char3 = GetDisplay.ImageImage("Cat/DocterCat.png");
        char3.setFitHeight(100);
        char3.setFitWidth(100);

        ImageView char4 = GetDisplay.ImageImage("Cat/FightingCAt.PNG");
        char4.setFitHeight(100);
        char4.setFitWidth(100);

        HBox ListCharP1 = new HBox();
        HBox CharP1ChooseBFbutton = new HBox();


        char1.setOnMouseClicked(event -> {
            ImageView char1Copy = new ImageView();
            char1Copy.setImage(char1.getImage());
            char1Copy.setFitHeight(char1.getFitHeight());
            char1Copy.setFitWidth(char1.getFitWidth());
            CharP1ChooseBFbutton.getChildren().clear();
            CharP1ChooseBFbutton.getChildren().add(char1Copy);
        });
        char2.setOnMouseClicked(event -> {
            ImageView char2Copy = new ImageView();
            char2Copy.setImage(char2.getImage());
            char2Copy.setFitHeight(char2.getFitHeight());
            char2Copy.setFitWidth(char2.getFitWidth());
            CharP1ChooseBFbutton.getChildren().clear();
            CharP1ChooseBFbutton.getChildren().add(char2Copy);
        });
        char3.setOnMouseClicked(event -> {
            ImageView char3Copy = new ImageView();
            char3Copy.setImage(char3.getImage());
            char3Copy.setFitHeight(char3.getFitHeight());
            char3Copy.setFitWidth(char3.getFitWidth());
            CharP1ChooseBFbutton.getChildren().clear();
            CharP1ChooseBFbutton.getChildren().add(char3Copy);
        });
        char4.setOnMouseClicked(event -> {
            ImageView char4Copy = new ImageView();
            char4Copy.setImage(char4.getImage());
            char4Copy.setFitHeight(char4.getFitHeight());
            char4Copy.setFitWidth(char4.getFitWidth());
            CharP1ChooseBFbutton.getChildren().clear();
            CharP1ChooseBFbutton.getChildren().add(char4Copy);
        });

        //-----------------------------------
//        char1.setOnMouseClicked(event -> {
//            ImageView char1Copy = new ImageView();
//            char1Copy.setImage(char1.getImage());
//            char1Copy.setFitHeight(char1.getFitHeight());
//            char1Copy.setFitWidth(char1.getFitWidth());
//            CharP1ChooseBFbutton.getChildren().add(char1Copy);
//        });

        //-----------------------------------
        Button ChooseButton = new Button("Choose");
        ChooseButton.setPrefWidth(70);
        ChooseButton.setBackground(Background.fill(Color.DARKCYAN));
        ChooseButton.setTextFill(Color.WHITE);

        ChooseButton.setOnAction(event -> {
            // Check if listP1 is empty or not
            if (CharP1ChooseBFbutton.getChildren().isEmpty()) {
                System.out.println("Please select a character first.");
            } else {
                // If listP1 is not empty, proceed (assuming further actions)
                System.out.println("Selected character(s):");
                ListCharP1.getChildren().add(CharP1ChooseBFbutton);
//                for (int i = 0; i < ListCharP1.getChildren().size(); i++) {
//                    // You can access the selected characters here (e.g., for processing)
//                    System.out.println(ListCharP1.getChildren().get(i));
//                }
            }
        });
        //-----------------------------------






        mainPage.getChildren().addAll(ChooseText,char1,char2,char3,char4,ChooseButton,ListCharP1);

        StackPane stack = new StackPane(backgroundChoose, mainPage);

        rootPane.getChildren().add(stack);
    }

}

//        gridPane2.add(char1,0,1);
//        setOnMouseClicked(e -> Goto.bookPage(char1));
