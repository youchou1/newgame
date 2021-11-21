import java.util.Scanner;
//创建接口“反击”
interface Counterattack {
    void counterattack();
}
//实现接口
public class Fighting implements Counterattack{
    int hurt=0;
    private Ninja ninja;
    private Enemy enemy;
    //使Fighting类里的方法能使用Ninja和Enemy里的方法
    public void setEnemy(Enemy enemy){
        this.enemy=enemy;
    }
    public Enemy getEnemy(){
        return enemy;
    }
    public void setNinja(Ninja ninja){
        this.ninja=ninja;
    }
    public Ninja getNinja(){
        return ninja;
    }
    //覆写接口方法
    @Override
    public void counterattack(){
        System.out.print(getNinja().getName()+"发动了反击！");
        Working.nextLine();
        this.attackThem();
    }
    //加入随机数
    public static double random() {
        double ran = 0;
        ran = Math.random();
        return ran;
    }
    //自己攻击对方
    public void attackThem() {
        if(getNinja().getHp()>0){
        int i = getEnemy().getAgile() / 1000;
        int hurt=0;
        //伤害计算公式
        hurt= (int) (getNinja().getStrength()*(0.8+random()*0.7)*(1-getEnemy().getDefence()/(500+getEnemy().getDefence())));
        if (random() > i) {
            System.out.println(getNinja().getName() + "使用了" + getNinja().getSkill().getSkillName() + ",对敌人造成了" +hurt+"点伤害");
        }else{
            System.out.println("被闪避了");
        }
        Working.nextLine();
        this.hurt=hurt;
        }
    }
    //对方攻击自己
    public  void attackMe(Counterattack counterattack) {
        if(getEnemy().getHp()>0){
        //敏捷决定闪避几率
        int i = getNinja().getAgile()/ 1000;
        //伤害计算公式
        int hurt=0;
        hurt= (int) (getEnemy().getStrength()*(0.8+random()*0.7)*(1-getNinja().getDefence()/(500+getNinja().getDefence())));
        //伤害结算
        if (random() > i) {
            System.out.println(getEnemy().getName() + "使用了" + getEnemy().getSkill().getSkillName() + ",对你造成了" +hurt+"点伤害");
        }else{
            System.out.println("被闪避了");
        }
        this.hurt=hurt;
        Working.nextLine();
        }
        if(getNinja().getHp()>0){
            this.counterattack();
        }
    }
    //失败剧情
    public void failed(){
        System.out.print("你不敌眼前的敌人，你眼前一黑，倒下了") ;
        Working.nextLine();
        System.out.print("次日，木叶村派来的救援部队赶到，发现了倒在地上的"+getNinja().getName()+"，连忙抓紧救援，你侥幸活了下来" );
        Working.nextLine();
        System.out.println("任务失败");
    }
}
