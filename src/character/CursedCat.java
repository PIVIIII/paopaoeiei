package character;

import controller.GameController;

import java.util.ArrayList;
// NOT DONE*****************************************************
public class CursedCat extends BaseCharacter{
    public CursedCat(boolean isTeam1){
        super("Cursed Cat", 13, 6, 2,"Catwithoutbg/CurseCat.PNG");
        setFirstSkillName("Curse");
        setFirstSkillDescription("Decreases all enemies' atk by 1");
        setSecondSkillName("CurseCurse");
        setSecondSkillDescription("Decreases all enemies' atk by 2");
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    public String useFirstSkill(BaseCharacter character) {
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        character.setAtk(character.getAtk() + 1);
        ArrayList<BaseCharacter> targetedTeam;
        if(isTeam1()){
            targetedTeam = GameController.getInstance().getPlayer1();
        } else {
            targetedTeam = GameController.getInstance().getPlayer1();
        }
        for(BaseCharacter baseCharacter : targetedTeam){
            baseCharacter.setHp(baseCharacter.getHp() + 1);
        }
        return "Holy Cat uses Holy Light to " + character.getName() + ", increasing " + character.getName() +
                "'s atk by 1 and heal 1 to all allies!";
    }

    public String useSecondSkill() {
        if(getMp() < 2){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 2);
        ArrayList<BaseCharacter> targetedTeam;
        if(isTeam1()){
            targetedTeam = GameController.getInstance().getPlayer2();
        } else {
            targetedTeam = GameController.getInstance().getPlayer1();
        }
        for(BaseCharacter character : targetedTeam){
            character.setAtk(character.getAtk() + 1);
            character.setDef(character.getDef() + 1);
        }
        return "Holy Cat uses Heaven's Whisper to increase all allies' atk and def by 1!!!";
    }
}
