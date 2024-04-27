package character;

// Character for testing.
public class Dummy extends BaseCharacter{
    // Real character won't have parameters in constructor
    public Dummy(String name, int maxHp, int atk, int def, boolean isTeam1){
        super(name, maxHp, atk, def,"Cat/CurseCat.PNG");
        setFirstSkillName("First Skill Name");
        setFirstSkillDescription("First Skill Description");
        setSecondSkillName("Second Skill Name");
        setSecondSkillDescription("Second Skill Description");
        setTeam1(isTeam1);
        setFirstSkillTargetEnemy(true);
    }

    @Override
    public String useFirstSkill(BaseCharacter character) {
        return getName() + " use First Skill to " + character.getName();
    }

    @Override
    public String useSecondSkill() {
        return getName() + " use Second Skill";
    }
}
