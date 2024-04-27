package character;

import controller.GameController;

import java.util.ArrayList;

public class KnightCat extends BaseCharacter {
    private final int FIRST_SKILL_BONUS_DAMAGE = 1;
    private final int SECOND_SKILL_DAMAGE_MODIFIER = 2;
    private final int SECOND_SKILL_DEBUFF_MODIFIER = 2;
    private boolean isGuard = false;
    public KnightCat(boolean isTeam1){
        super("Knight Cat", 13, 6, 3,"Catwithoutbg/KnightCat.PNG");
        setFirstSkillName("Holy Strike");
        setFirstSkillDescription("Deals (atk + " + FIRST_SKILL_BONUS_DAMAGE + ") damage to an enemy");
        setSecondSkillName("Excalibur");
        setSecondSkillDescription("Deals (atk + " + SECOND_SKILL_DAMAGE_MODIFIER + ") damage to an enemy " +
                "and decrease an enemy's def by " + SECOND_SKILL_DEBUFF_MODIFIER);
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    public String useFirstSkill(BaseCharacter character){
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        int damage = character.takeDamage(getAtk() + FIRST_SKILL_BONUS_DAMAGE);
        isGuard = true;
        return "Knight Cat uses Holy Strike to " + character.getName() + " dealing " + damage + " damage!";
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
        int maxDefInTeam = - 1;
        for(BaseCharacter character : targetedTeam){
            if(!character.isDead() && (character.getAtk() > maxDefInTeam)){
                targetedCharacter = character;
                maxDefInTeam = character.getAtk();
            }
        }
        int damage = targetedCharacter.takeDamage(this.getAtk() + SECOND_SKILL_DAMAGE_MODIFIER);
        targetedCharacter.setDef(targetedCharacter.getDef() - SECOND_SKILL_DEBUFF_MODIFIER);
        return "Knight Cat uses Excalibur to " + targetedCharacter.getName() + " dealing " + damage
                + " damage and inflict -" + SECOND_SKILL_DEBUFF_MODIFIER + " def!!!";
    }

    @Override
    public int takeDamage(int damage) {
        if (isGuard){
            int finalDamage = Math.max(damage - getDef(), 0) / 2;
            setHp(getHp() - finalDamage);
            isGuard = false;
            return finalDamage;
        } else {
            return super.takeDamage(damage);
        }
    }
}
