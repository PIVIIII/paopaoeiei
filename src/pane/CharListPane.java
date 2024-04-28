package pane;

import character.*;
import item.Char;
import javafx.scene.layout.VBox;


import java.util.ArrayList;

public class CharListPane extends VBox {

    private static CharListPane instance;
    private ArrayList<Char> chars;

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

    private CharListPane() {
        chars = new ArrayList<>();
        chars.add(new Char(FC1));
        chars.add(new Char(KC1));
        chars.add(new Char(NC1));
        chars.add(new Char(CL1));
        chars.add(new Char(CC1));
        chars.add(new Char(DC1));
        chars.add(new Char(HC1));
        chars.add(new Char(VC1));
        chars.add(new Char(FC2));
        chars.add(new Char(KC2));
        chars.add(new Char(NC2));
        chars.add(new Char(CL2));
        chars.add(new Char(CC2));
        chars.add(new Char(DC2));
        chars.add(new Char(HC2));
        chars.add(new Char(VC2));

    }

    public static CharListPane getInstance() {
        if (instance == null) {
            instance = new CharListPane();
        }
        return instance;
    }

    public ArrayList<Char> getChars() {
        return chars;
    }
}


