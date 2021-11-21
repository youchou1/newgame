import java.util.Scanner;
public class Working {
    private String work=null;
    //初始设置部分
    public void instruction() {
        System.out.println("欢迎来到这个游戏，您的角色是漩涡鸣人");
    }
        public void narutoSet() {
            //鸣人的属性填写
            System.out.println("请输入你的信息（空格键分割）：\n忍者名称（长度1-20），血量（范围1-9999），力量（范围1-999），" +
                    "防御（1-999），敏捷（1-200）" + "\n" + "建议分别为：漩涡鸣人 8000 800 500 250");
        }
        public void enemy1Set() {
            System.out.println("请输入敌人【木叶叛忍（单独）】的信息（空格键分割）：\n名称（长度1-20），血量（范围1-9999）," +
                    "力量（范围1-999），防御（1-999），敏捷（1-200）" + "\n" + "建议分别为：木叶叛忍 2000 600 400 250");
        }
        public void enemy2Set(){
            System.out.println("请输入敌人【木叶叛忍（群体）】的信息（空格键分割）：\n名称（长度1-20），血量（范围1-9999）," +
                    "力量（范围1-999），防御（1-999），敏捷（1-200）"+ "\n" + "建议分别为：木叶叛忍 1000 300 200 250");
        }
        public void plot1(){
        System.out.println("------------------------------------------------------------------------");
        System.out.print("木叶村收到了之前派往前去任务的小队的求救信号，现派你去营救这支小队，请多加小心！");
        Working.nextLine();
        System.out.print("求救信号来自于一片森林，你马不停蹄来到了森林区域，遇到了一个木叶叛忍，他向你发起了攻击！");
        Working.nextLine();
        }
        public  void plot2(){
            System.out.println("------------------------------------------------------------------------");
            System.out.print("打败了刚刚的木叶叛忍后，你决定继续深入探索这片森林");
            Working.nextLine();
            System.out.print("这一次……");
            Working.nextLine();
            System.out.print("你遇上了更多的敌人……");
            Working.nextLine();
        }
        public static void nextLine(){
        System.out.println("(按回车键继续)");
            Scanner input = new Scanner(System.in);
            String k=input.nextLine();
        }
        public void plot3(){
            System.out.println("------------------------------------------------------------------------");
            System.out.print("与敌人恶战一番后，你拖着疲惫的身体继续前进");
            Working.nextLine();
            System.out.print("这次，你遇上了难以想象的对手（后续更新。。。。。）");
            Working.nextLine();
        }
        public void ending(){
            System.out.println("------------------------------------------------------------------------");
            System.out.print("你击破重重阻碍，终于将发出救援信号的小队安全得带回，\n" +
                    "击碎了敌人的阴谋，木叶村又恢复了往日的宁静(才怪)");
            Working.nextLine();
            System.out.print("感谢您的游玩，期待与您的下次再会。（话说真的会有下次吗（滑稽））");
        }
    }
