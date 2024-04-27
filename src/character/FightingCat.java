package character;

import controller.GameController;

import java.util.ArrayList;

public class FightingCat extends BaseCharacter{
    public FightingCat(boolean isTeam1){
        super("Fighting Cat", 15, 7, 3,"Catwithoutbg/FightingCat.PNG");
        setFirstSkillName("Hit");
        setFirstSkillDescription("Deals (atk + 1) damage to an enemy");
        setSecondSkillName("Eternal");
        setSecondSkillDescription("Deals (atk + 2) damage and decreases 1 atk from the highest atk enemy");
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    @Override
    public String useFirstSkill(BaseCharacter character) {
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        int damage = character.takeDamage(getAtk() + 1);
        return "Fighting Cat uses Hit to " + character.getName() + " dealing " + damage + " damage!";
    }

    @Override
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
