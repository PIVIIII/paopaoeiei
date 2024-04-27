package character;

import controller.GameController;

import java.util.ArrayList;

public class VampireCat extends BaseCharacter{
    private final int FIRST_SKILL_DAMAGE_MODIFIER = 2;
    private final int SECOND_SKILL_DAMAGE_MODIFIER = 2;

    public VampireCat(boolean isTeam1){
        super("Vampire Cat", 15, 6, 0,"Cat/VampireCat.PNG");
        setFirstSkillName("Crimson Slash");
        setFirstSkillDescription("Deals (atk + " + FIRST_SKILL_DAMAGE_MODIFIER + ") damage to an enemy");
        setSecondSkillName("Blood Manipulation");
        setSecondSkillDescription("Deals (atk + " + SECOND_SKILL_DAMAGE_MODIFIER + ") damage to an enemy with " +
                "the highest hp and heals self for half the damage");
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    public String useFirstSkill(BaseCharacter character) {
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        int damage = character.takeDamage(getAtk() + FIRST_SKILL_DAMAGE_MODIFIER);
        return "Vampire Cat uses Crimson Slash to " + character.getName() + " dealing " + damage + " damage!";
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
        BaseCharacter targetedCharacter = targetedTeam.getFirst();
        int maxHpInTeam = -1;
        for(BaseCharacter character : targetedTeam){
            if(!character.isDead() && (character.getHp() > maxHpInTeam)){
                targetedCharacter = character;
                maxHpInTeam = character.getHp();
            }
        }
        int damage = targetedCharacter.takeDamage(this.getAtk() + SECOND_SKILL_DAMAGE_MODIFIER);
        int heal =  damage / 2;
        setHp(getHp() + heal);
        return "Vampire Cat uses Blood Manipulation to " + targetedCharacter.getName() + " dealing " + damage +
                " damage and heals for " + heal + "!!!";
    }
}