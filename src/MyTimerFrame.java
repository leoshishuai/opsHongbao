import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class MyTimerFrame extends JFrame {

    private MyLabelTimer lab;
    private MyLabelTimer labTxt;
    private MyLabelBonus labBonus;
    private JButton but1, but2;

    private TimeThread time;

    public MyTimerFrame() {
        super("OPS的红包计算器");
        this.setBounds(200, 200, 300, 300);
        this.setLayout(null);

        lab = new MyLabelTimer("00:00:00");


        this.lab.setBounds(80, 50, 120, 20);
        this.lab.setBorder(new LineBorder(Color.BLACK));
        this.lab.setFont(new Font("仿宋", Font.BOLD, 20));
        this.lab.setHorizontalAlignment(0);

        labTxt =new MyLabelTimer("会后您需要发红包：");
        this.labTxt.setBounds(20, 150, 250, 60);
        this.labTxt.setFont(new Font("仿宋", Font.BOLD, 16));
        this.labTxt.setHorizontalAlignment(0);

        labBonus = new MyLabelBonus("0.000");
        this.labBonus.setBounds(80, 230, 120, 40);
        this.labBonus.setFont(new Font("仿宋", Font.BOLD, 30));
        this.labBonus.setForeground(Color.red);
        this.labBonus.setHorizontalAlignment(0);

        this.add(lab);
        this.add(labTxt);
        this.add(labBonus);

        but1 = new JButton("开始");
        but1.setBounds(40, 110, 100, 20);

        but2 = new JButton("重置");
        but2.setBounds(160, 110, 100, 20);


        Handler h = new Handler(this);

        but1.addActionListener(h);
        but2.addActionListener(h);
        this.add(but1);
        this.add(but2);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        time = new TimeThread(lab,labBonus);
        time.setDaemon(true);
        time.start();
    }

    public JButton getBut1() {
        return but1;
    }

    public void setBut1(JButton but1) {
        this.but1 = but1;
    }

    public JButton getBut2() {
        return but2;
    }

    public void setBut2(JButton but2) {
        this.but2 = but2;
    }

    public MyLabelTimer getLab() {
        return lab;
    }

    public void setLab(MyLabelTimer lab) {
        this.lab = lab;
    }

    public MyLabelBonus getLabBonus() {
        return labBonus;
    }

    public void setLabBonus(MyLabelBonus labBonus) {
        this.labBonus = labBonus;
    }

    public static void main(String[] args) {
        new MyTimerFrame();
    }
}