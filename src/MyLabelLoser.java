import javax.swing.*;
import java.util.Random;

public class MyLabelLoser extends JLabel{
    private String[] members;
    private boolean flag = false;
    private int count = 0;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MyLabelLoser() {
        super();
        members = new String[13];
        members[0] = "Leslie (menglz1)";
        members[1] = "Leo (shishuai)";
        members[2] = "Lanhui (lilh8)";
        members[3] = "Pengcheng (yanpc1)";
        members[4] = "Zhiwen (zhangzw1)";
        members[5] = "Hao (xinghao1)";
        members[6] = "Qi (xueqi2)";
        members[7] = "Sichao (laisc1)";
        members[8] = "Xing (yaoxing2)";
        members[9] = "Ken (wangkai4)";
        members[10] = "Timothy (zhangding1)";
        members[11] = "Xu (zhangxu6)";
        members[12] = "Wei (yaowei5)";
    }

    public void init() {
        this.flag = false;
        this.setText("");
    }

    public synchronized void randomMember() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (true) {
            Random ra = new Random();
            if (count < 30) {
                try {
                    Thread.sleep(10);
                    this.setText(members[ra.nextInt(members.length)]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            } else if (count < 40) {
                try {
                    Thread.sleep(100);
                    this.setText(members[ra.nextInt(members.length)]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            } else if (count < 48) {
                try {
                    Thread.sleep(300);
                    this.setText(members[ra.nextInt(members.length)]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            } else if (count < 53) {
                try {
                    Thread.sleep(500);
                    this.setText(members[ra.nextInt(members.length)]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            } else {
                flag = false;
                count = 0;
            }
        }
    }

    /**
     * »½ÐÑÐÝÃß
     */
    public synchronized void notifyLabel() {
        this.notifyAll();
    }

}