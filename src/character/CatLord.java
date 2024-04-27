package character;

import controller.GameController;

import java.util.ArrayList;

public class CatLord extends BaseCharacter {
    private final int FIRST_SKILL_BONUS_DAMAGE = 2;
    private final int SECOND_SKILL_DAMAGE_MODIFIER = 2;
    private final int SECOND_SKILL_BUFF_MODIFIER = 3;
    public CatLord(boolean isTeam1){
        super("Cat Lord", 15, 6, 3, "Catwithoutbg/CatLord.PNG");
        setFirstSkillName("King's Sword");
        setFirstSkillDescription("Deals (atk + " + FIRST_SKILL_BONUS_DAMAGE + ") damage to an enemy");
        setSecondSkillName("King's Wish");
        setSecondSkillDescription("Increases all allies' atk by " + SECOND_SKILL_DAMAGE_MODIFIER
                + " and def by " + SECOND_SKILL_BUFF_MODIFIER);
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    public String useFirstSkill(BaseCharacter character){
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        int damage = character.takeDamage(getAtk() + FIRST_SKILL_BONUS_DAMAGE);
        return "Cat Lord uses King's Sword to " + character.getName() + " dealing " + damage + " damage!";
    }

    public String useSecondSkill(){
        if(getMp() < 2){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 2);
        ArrayList<BaseCharacter> targetedTeam;
        if(isTeam1()){
            targetedTeam = GameController.getInstance().getPlayer1();
        } else {
            targetedTeam = GameController.getInstance().getPlayer1();
        }
        BaseCharacter targetedCharacter = targetedTeam.getFirst();
        int minAtkInTeam = 100;
        for(BaseCharacter character : targetedTeam){
            if(!character.isDead() && (character.getAtk() < minAtkInTeam)){
                targetedCharacter = character;
                minAtkInTeam = character.getAtk();
            }
        }
        targetedCharacter.setAtk(targetedCharacter.getAtk() + SECOND_SKILL_DAMAGE_MODIFIER);
        targetedCharacter.setDef(targetedCharacter.getDef() + SECOND_SKILL_BUFF_MODIFIER);
        return "Cat Lord uses King's Wish to " + targetedCharacter.getName() + " increasing atk by "
                + SECOND_SKILL_DAMAGE_MODIFIER + " and def by " + SECOND_SKILL_BUFF_MODIFIER;
    }
}