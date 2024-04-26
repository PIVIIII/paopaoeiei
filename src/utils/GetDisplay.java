package utils;

//import item.Book;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.InputStream;

public class GetDisplay {


    public static ImageView ImageImage(String imagePath,int Height,int Width) {
        ImageView image;
        String classLoaderPath = ClassLoader.getSystemResource(imagePath).toString();
        image = new ImageView(classLoaderPath);
        image.setFitHeight(Height);
        image.setFitWidth(Width);
        return image;
    }


    public static Text TextText(String textinput, int fontSize, int wrappingWidth)  {
        Text text = new Text(textinput);
        text.setFill(Color.GRAY);
        text.setFont(Font.font(fontSize));
        text.setWrappingWidth(wrappingWidth);
        return text;
    }







}
