package character;

import controller.GameController;

import java.util.ArrayList;

public class DoctorCat extends BaseCharacter {
    private final int FIRST_SKILL_HEAL = 4;
    private final int SECOND_SKILL_HEAL = 3;
    public DoctorCat(boolean isTeam1){
        super("Doctor Cat", 14, 6, 4, "Cat/DoctorCat.PNG");
        setFirstSkillName("Healing");
        setFirstSkillDescription("Heal an ally hp by" + FIRST_SKILL_HEAL);
        setSecondSkillName("Call an ambulance");
        setSecondSkillDescription("Heal all allies hp by " + SECOND_SKILL_HEAL);
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(false);
    }

    public String useFirstSkill(BaseCharacter character){
        if(getMp() < 1){
            return "This character doesn't have enough mp to use this skill";
        }
        setMp(getMp() - 1);
        character.setHp(character.getHp() + FIRST_SKILL_HEAL);
        return "Doctor Cat uses Healing to " + character.getName() + ", heal by " + FIRST_SKILL_HEAL;
    }

    public String useSecondSkill() {
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
        for(BaseCharacter baseCharacter : targetedTeam){
            baseCharacter.setHp(baseCharacter.getHp() + SECOND_SKILL_HEAL);
        }
        return "Doctor Cat uses Call an ambulance to heal " + SECOND_SKILL_HEAL + " to all allies!";
    }

}