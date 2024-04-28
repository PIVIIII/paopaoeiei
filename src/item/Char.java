package item;

import character.BaseCharacter;
import javafx.scene.image.ImageView;
import utils.GetDisplay;

public class Char {

    private BaseCharacter baseCharacter;

    public Char(BaseCharacter baseCharacter) {
        setBaseCharacter(baseCharacter);
    }

    public BaseCharacter getBaseCharacter() {
        return baseCharacter;
    }

    public void setBaseCharacter(BaseCharacter baseCharacter) {
        this.baseCharacter = baseCharacter;
    }
}
