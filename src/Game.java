import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        Working work = new Working();
        work.instruction();
        work.narutoSet();
        Scanner sc = new Scanner(System.in);
        //读取输入的数值
        String answer1 = sc.nextLine();
        //将输入的数值分割并保存在数组value中
        String[] value1 = answer1.split(" ");
        //将数组中的内容赋值给鸣人的属性
        Ninja naruto = new Ninja(value1[0], Integer.parseInt(value1[1]), Integer.parseInt(value1[2]), Integer.parseInt(value1[3]),
                Integer.parseInt(value1[4]));
        work.enemy1Set();
        Scanner sc1 = new Scanner(System.in);
        //读取输入的数值
        String answer2 = sc1.nextLine();
        //将输入的数值分割并保存在数组value中
        String[] value2 = answer2.split(" ");
        //将数组中的内容赋值给敌人的属性
        Enemy enemy1 = new Enemy(value2[0], Integer.parseInt(value2[1]), Integer.parseInt(value2[2]), Integer.parseInt(value2[3]),
                Integer.parseInt(value2[4]));
        work.enemy2Set();
        Scanner sc2 = new Scanner(System.in);
        //读取输入的数值
        String answer3 = sc2.nextLine();
        //将输入的数值分割并保存在数组value中
        String[] value3 = answer3.split(" ");
        //将数组中的内容赋值给敌人的属性
        Enemy enemy21 = new Enemy(value3[0], Integer.parseInt(value3[1]), Integer.parseInt(value3[2]), Integer.parseInt(value3[3]),
                Integer.parseInt(value3[4]));
        Enemy enemy22 = new Enemy(value3[0], Integer.parseInt(value3[1]), Integer.parseInt(value3[2]), Integer.parseInt(value3[3]),
                Integer.parseInt(value3[4]));
        Enemy enemy23 = new Enemy(value3[0], Integer.parseInt(value3[1]), Integer.parseInt(value3[2]), Integer.parseInt(value3[3]),
                Integer.parseInt(value3[4]));
        //将木叶叛忍小队放入数组中
        Enemy[] t = new Enemy[3];
        t[0] = enemy21;
        t[1] = enemy22;
        t[2] = enemy23;
        //设置技能
        Skill narutoSkill = new Skill("螺旋丸");
        Skill enemy1Skill = new Skill("水遁：水龙卷");
        Skill enemy21Skill = new Skill("火遁：鬼灯笼");
        Skill enemy22Skill = new Skill("风遁：风杀阵");
        Skill enemy23Skill = new Skill("雷遁：雷电击");
        //鸣人拥有技能
        naruto.setSkill(narutoSkill);
        narutoSkill.setNinja(naruto);
        //木叶叛忍【单独】拥有技能
        enemy1.setSkill(enemy1Skill);
        enemy1Skill.setEnemy(enemy1);
        //木叶叛忍【小队】拥有技能
        enemy21.setSkill(enemy21Skill);
        enemy21Skill.setEnemy(enemy21);
        enemy22.setSkill(enemy22Skill);
        enemy22Skill.setEnemy(enemy22);
        enemy23.setSkill(enemy23Skill);
        enemy23Skill.setEnemy(enemy23);
        //查看角色信息
        naruto.tell();
        //实例化两个代表攻击的对象
        Fighting weAttack = new Fighting();
        Fighting theyAttack = new Fighting();
        //实例化一个用来将其他类和Fighting类联系起来的对象
        Fighting usual = new Fighting();
        //联系起来
        weAttack.setEnemy(enemy1);
        weAttack.setNinja(naruto);
        theyAttack.setEnemy(enemy1);
        theyAttack.setNinja(naruto);
        naruto.setFighting(usual);
        usual.setNinja(naruto);
        usual.setEnemy(enemy1);
        //防止一大段文字突然出现
        Working.nextLine();
        //第一章情节
        work.plot1();
        System.out.println("敌人的信息：");
        enemy1.tell1();
        //战斗界面
        System.out.println("开始战斗！");
        Working.nextLine();
        int i = 1;
        boolean situ = true;
        while (situ) {
            System.out.println("第" + i + "回合\n" + "请选择：\n1.查看自己状态\t2.查看对方状态\t3.使用技能\t4.逃跑");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> naruto.tell();
                case 2 -> System.out.println("敌人的血量目前为：" + enemy1.getHp());
                case 3 -> {
                    //我方攻击后敌方再进行攻击
                    //我方攻击
                    weAttack.attackThem();
                    enemy1.steHp(enemy1.getHp() - weAttack.hurt);
                    //如果敌人血量归零，回合结束
                    if (enemy1.getHp() <= 0) {
                        situ = false;
                        System.out.println("敌人倒下了，你取得了胜利！");
                        enemy1.steHp(1);
                    }
                    //敌人攻击
                    if (enemy1.getHp() > 0) {
                        theyAttack.attackMe(weAttack);//敌人攻击后我方反击
                        enemy1.steHp(enemy1.getHp()-weAttack.hurt);
                        naruto.steHp(naruto.getHp() - theyAttack.hurt);
                    }
                    if (enemy1.getHp() <= 0) {
                        situ = false;
                        System.out.println("敌人倒下了，你取得了胜利！");
                    }
                    i++;
                    //如果主角血量归零，回合结束
                    if (naruto.getHp() <= 0) {
                        situ = false;
                        //失败剧情
                        naruto.getFighting().failed();
                    }
                }
                case 4 -> {
                    //战斗时有几率逃跑，逃跑成功就可脱离战斗，失败则损失血量
                    System.out.println("你给路哒油~");
                    double random = Math.random();
                    if (random < 0.20) {
                        System.out.println("你逃掉了！");
                        situ = false;
                    } else {
                        System.out.print("你没能逃掉，被对方抓回来暴打了一顿");
                        Working.nextLine();
                        System.out.println("你的生命下降了1000点");
                        naruto.steHp(naruto.getHp() - 1000);
                        if (naruto.getHp() <= 0) {
                            situ = false;
                            i++;
                            naruto.getFighting().failed();
                        }
                    }
                }
                default -> System.out.println("请输入正确的选项");
            }
        }
        i=1;
        //第二章情节
        work.plot2();
        System.out.println("敌人的信息：");
        enemy21.tell1();
        Working.nextLine();
        enemy22.tell1();
        Working.nextLine();
        enemy23.tell1();
        Working.nextLine();
        System.out.println("开始战斗！");
        situ=true;
        //战斗界面
        while (situ) {
            System.out.println("第" + i + "回合\n" + "请选择：\n1.查看自己状态\t2.查看对方状态\t3.使用技能\t4.逃跑");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> naruto.tell();
                case 2 -> {
                    System.out.println("木叶叛忍【火遁】的血量为" + enemy21.getHp());
                    System.out.println("木叶叛忍【风遁】的血量为" + enemy22.getHp());
                    System.out.println("木叶叛忍【雷遁】的血量为" + enemy23.getHp());
                }
                case 3 -> {
                    //选择攻击对象
                    if(enemy21.getHp()>0&&enemy22.getHp()>0&&enemy23.getHp()>0){
                    System.out.println("请选择你的攻击目标：\n" +
                            "1.木叶叛忍【火遁】 2.木叶叛忍【风遁】 3.木叶叛忍【雷遁】");
                    }else if(enemy21.getHp()<1&&enemy22.getHp()>0&&enemy23.getHp()>0){
                        System.out.println("请选择你的攻击目标：\n" +
                                "1.木叶叛忍【火遁】（已死亡）2.木叶叛忍【风遁】 3.木叶叛忍【雷遁】");
                    }else if(enemy22.getHp()<1&&enemy21.getHp()>0&&enemy23.getHp()>0){
                        System.out.println("请选择你的攻击目标：\n" +
                                "1.木叶叛忍【火遁】 2.木叶叛忍【风遁】（已死亡） 3.木叶叛忍【雷遁】");
                    }else if(enemy23.getHp()<1&&enemy21.getHp()>0&&enemy22.getHp()>0){
                        System.out.println("请选择你的攻击目标：\n" +
                                "1.木叶叛忍【火遁】 2.木叶叛忍【风遁】 3.木叶叛忍【雷遁】（已死亡）");
                    }else if(enemy21.getHp()>0&&enemy22.getHp()<1&&enemy23.getHp()<1){
                        System.out.println("请选择你的攻击目标：\n" +
                                "1.木叶叛忍【火遁】 2.木叶叛忍【风遁】（已死亡） 3.木叶叛忍【雷遁】（已死亡）");
                    }else if(enemy22.getHp()>0&&enemy21.getHp()<1&&enemy23.getHp()<1){
                        System.out.println("请选择你的攻击目标：\n" +
                                "1.木叶叛忍【火遁】（已死亡） 2.木叶叛忍【风遁】 3.木叶叛忍【雷遁】（已死亡）");
                    }else if(enemy23.getHp()>0&&enemy21.getHp()<1&&enemy22.getHp()<1){
                        System.out.println("请选择你的攻击目标：\n" +
                                "1.木叶叛忍【火遁】（已死亡） 2.木叶叛忍【风遁】（已死亡） 3.木叶叛忍【雷遁】");
                    }
                    int opportunity = sc.nextInt();
                    //用rubbish读取回车的那一部分
                    String rubbish = sc.nextLine();
                    //对目标对象进行攻击
                    switch (opportunity) {
                        case 1 -> {
                            usual.setEnemy(enemy21);
                            weAttack.setEnemy(enemy21);
                            weAttack.attackThem();
                            enemy21.steHp(enemy21.getHp() - weAttack.hurt);
                        }
                        case 2 -> {
                            usual.setEnemy(enemy22);
                            weAttack.setEnemy(enemy22);
                            weAttack.attackThem();
                            enemy22.steHp(enemy22.getHp() - weAttack.hurt);
                        }
                        case 3 -> {
                            usual.setEnemy(enemy23);
                            weAttack.setEnemy(enemy23);
                            weAttack.attackThem();
                            enemy23.steHp(enemy23.getHp() - weAttack.hurt);
                        }
                    }

                    //敌人攻击
                        if (enemy21.getHp() > 0) {
                            usual.setEnemy(enemy21);
                            theyAttack.setEnemy(enemy21);
                            theyAttack.attackMe(weAttack);//敌人攻击后我方反击
                            naruto.steHp(naruto.getHp() - theyAttack.hurt);
                            enemy21.steHp(enemy21.getHp()-weAttack.hurt);
                        }
                        if(enemy22.getHp()>0){
                            usual.setEnemy(enemy22);
                            theyAttack.setEnemy(enemy22);
                            theyAttack.attackMe(weAttack);//敌人攻击后我方反击
                            naruto.steHp(naruto.getHp() - theyAttack.hurt);
                            enemy22.steHp(enemy22.getHp()-weAttack.hurt);
                        }
                        if(enemy23.getHp()>0){
                            usual.setEnemy(enemy23);
                            theyAttack.setEnemy(enemy23);
                            theyAttack.attackMe(weAttack);//敌人攻击后我方反击
                            naruto.steHp(naruto.getHp() - theyAttack.hurt);
                            enemy23.steHp(enemy23.getHp()-weAttack.hurt);
                        }
                    i++;
                        //如果主角血量归零，回合结束
                        if (naruto.getHp() <= 0) {
                            situ = false;
                            //失败剧情
                            naruto.getFighting().failed();
                        }
                        if (enemy21.getHp() <= 0&&enemy22.getHp()<=0&&enemy23.getHp()<=0) {
                        situ = false;
                        System.out.println("所有敌人都倒下了，你取得了胜利！");
                        }
                    }
                    case 4 -> {
                        //战斗时有几率逃跑，逃跑成功就可脱离战斗，失败则损失血量
                        System.out.println("你给路哒油~");
                        double random = Math.random();
                        if (random < 0.20) {
                            System.out.println("你逃掉了！");
                            situ = false;
                        } else {
                            System.out.print("你没能逃掉，被对方抓回来暴打了一顿");
                            Working.nextLine();
                            System.out.println("你的生命下降了1000点");
                            naruto.steHp(naruto.getHp() - 1000);
                            if (naruto.getHp() <= 0) {
                                situ = false;
                                i++;
                                naruto.getFighting().failed();
                            }
                        }
                    }
                    default -> System.out.println("请输入正确的选项");
                }
            }
        work.ending();
        }
    }