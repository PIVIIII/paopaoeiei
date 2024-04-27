package character;

import controller.GameController;

import java.util.ArrayList;

public class NinjaCat extends BaseCharacter{
    public NinjaCat(boolean isTeam1){
        super("Ninja Cat", 13, 7, 3,"Catwithoutbg/NinjaCat.PNG");
        setFirstSkillName("Slash");
        setFirstSkillDescription("Deals (atk + 2) damage to an enemy");
        setSecondSkillName("Iaigiri");
        setSecondSkillDescription("Deals (atk + 3) damage to an enemy with the highest hp");
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    public String useFirstSkill(BaseCharacter character) {
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        int damage = character.takeDamage(getAtk() + 2);
        return "Fighting Cat uses Slash to " + character.getName() + " dealing " + damage + " damage!";
    }
    // TODO
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
        BaseCharacter targetedCharacter = targetedTeam.getFirst();
        int maxAtkInTeam = - 1;
        for(BaseCharacter character : targetedTeam){
            if(!character.isDead() && (character.getAtk() > maxAtkInTeam)){
                targetedCharacter = character;
                maxAtkInTeam = character.getAtk();
            }
        }
        targetedCharacter.setAtk(targetedCharacter.getAtk() - 1);
        int damage = targetedCharacter.takeDamage(this.getAtk() + 2);
        return "Fighting Cat uses Eternal to " + targetedCharacter.getName() + " dealing " + damage + " damage and inflict -1 atk!!!";
    }
}
