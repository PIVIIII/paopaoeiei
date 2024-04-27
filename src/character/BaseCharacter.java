package character;

public abstract class BaseCharacter {
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private final int MAX_MP;
    private int atk;
    private int def;
    private String firstSkillName;
    private String firstSkillDescription;
    private String secondSkillName;
    private String secondSkillDescription;
    private boolean isTeam1;
    private boolean firstSkillTargetEnemy;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BaseCharacter(String name, int maxHp, int atk, int def , String img) {
        setName(name);
        setMaxHp(maxHp);
        setHp(maxHp);
        MAX_MP = 3;
        setMp(3);
        setAtk(atk);
        setDef(def);
        setImg(img);
    }

    // return int in case of future use
    public int takeDamage(int damage){
        int finalDamage = Math.max(damage - def, 0);
        setHp(getHp() - finalDamage);
        return finalDamage;
    }

    public String normalAttack(BaseCharacter character){
        setMp(getMp() + 1);
        return name + " use normal attack dealing " + character.takeDamage(atk) + " damage!";
    }

    // For character has 2 unique skills
    public abstract String useFirstSkill(BaseCharacter character);
    public abstract String useSecondSkill();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()){
            this.name = "Unnamed";
        } else {
            this.name = name;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.min(Math.max(hp, 0), maxHp);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = Math.max(maxHp, 1);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = Math.min(Math.max(mp, 0), MAX_MP);
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = Math.max(atk, 0);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public boolean isDead() {
        return hp == 0;
    }

    public String getFirstSkillName() {
        return firstSkillName;
    }

    public void setFirstSkillName(String firstSkillName) {
        this.firstSkillName = firstSkillName;
    }

    public String getFirstSkillDescription() {
        return firstSkillDescription;
    }

    public void setFirstSkillDescription(String firstSkillDescription) {
        this.firstSkillDescription = firstSkillDescription;
    }

    public String getSecondSkillName() {
        return secondSkillName;
    }

    public void setSecondSkillName(String secondSkillName) {
        this.secondSkillName = secondSkillName;
    }

    public String getSecondSkillDescription() {
        return secondSkillDescription;
    }

    public void setSecondSkillDescription(String secondSkillDescription) {
        this.secondSkillDescription = secondSkillDescription;
    }

    public boolean isTeam1() {
        return isTeam1;
    }

    public void setTeam1(boolean team1) {
        isTeam1 = team1;
    }

    public boolean isFirstSkillTargetEnemy() {
        return firstSkillTargetEnemy;
    }

    public void setFirstSkillTargetEnemy(boolean firstSkillTargetEnemy) {
        this.firstSkillTargetEnemy = firstSkillTargetEnemy;
    }

    // For test purpose
    public String toString(){
        return name + " hp: " + hp + "/" + maxHp + " mp: " + mp + "/" + MAX_MP + " atk: " + atk + " def: " + def;
    }
}
