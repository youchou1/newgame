public class Skill {
    //设置技能名属性
    private String name;
    private Ninja ninja;
    private Enemy enemy;
    //构造方法初始化技能名
    public Skill(String name){
        this.setSkillName(name);
    }
    public void setSkillName(String name){
        this.name=name;
    }
    public String getSkillName(){
        return name;
    }
    public Ninja getNinja(){
        return ninja;
    }
    public void setNinja(Ninja ninja){
        this.ninja=ninja;
    }
    public Enemy getEnemy(){
        return enemy;
    }
    public void setEnemy(Enemy enemy){
        this.enemy=enemy;
    }
}
