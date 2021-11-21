public class Person {
    //人物属性
    private  String name;
    private  int hp;
    private  int strength;
    private  int defence;
    private  int agile;
    //设定数值
    public Person(String name, int hp, int strength, int defence, int agile) {
        this.setName(name);
        this.steHp(hp);
        this.setStrength(strength);
        this.setDefence(defence);
        this.setAgile(agile);
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getName() {
        return name;
    }

    public void steHp(int hp) {
        this.hp = hp;
    }

    public  int getHp() {
        if(this.hp<0) {
            this.hp=0;
        }
        return hp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public  int getStrength() {
        return strength;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public  int getDefence() {
        return defence;
    }

    public void setAgile(int agile) {
        this.agile = agile;
    }

    public  int getAgile() {
        return agile;
    }


}
//敌人继承人物
class Enemy extends Person{
    public Enemy(String name, int hp, int strength, int defence, int agile) {
        super(name, hp, strength, defence, agile);
        }
        private  Skill skill;
        private Fighting fight;
    public  Skill getSkill() {
        return skill;
    }
    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public Fighting getFighting(){
        return fight;
    }
    public void setFighting(Fighting fight){
        this.fight=fight;
    }
        public void tell1(){
            //查看属性
            System.out.println("角色属性为：\n"+"名字："+super.getName()+"\n"+"血量：" + super.getHp() + "\n"
                    + "力量：" + super.getStrength() + "\n" + "防御：" + super.getDefence() + "\n"
                    + "敏捷：" + super.getAgile()+"\n"+"技能："+getSkill().getSkillName());
    }
}
class Ninja extends Person{
    public Ninja(String name,int hp, int strength, int defence, int agile){
        super(name, hp, strength, defence, agile);
    }
    private  Skill skill;
    private Fighting fight;
    public Fighting getFighting(){
        return fight;
    }
    public void setFighting(Fighting fight){
        this.fight=fight;
    }
    public  Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
    public void tell(){
        //查看属性
        System.out.println("角色属性为：\n名称：" + super.getName() + "\n" + "血量：" + super.getHp() + "\n"
                + "力量：" + super.getStrength() + "\n" + "防御：" + super.getDefence() + "\n"
                + "敏捷：" + super.getAgile()+"\n"+"技能："+getSkill().getSkillName());
    }
}

