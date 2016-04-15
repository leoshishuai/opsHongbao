import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyTimerFrame extends JFrame {

    private MyLabelTimer lab;
    private MyLabelTimer labTxt;
    private MyLabelBonus labBonus;
    private JButton but1, but2;
    private JLabel label1;
    private MyLabelLoser loserTxt;

    private JLabel loserLab;

    private TimeThread time;
    private LoserThread loser;

    public MyTimerFrame() {
        super("OPS的红包计算器");
        this.setBounds(200, 200, 600, 600);
        this.setLayout(null);

        lab = new MyLabelTimer("00:00:00");
        this.lab.setBounds(60, 20, 400, 70);
        this.lab.setBorder(new LineBorder(Color.BLACK));
        this.lab.setFont(new Font("仿宋", Font.BOLD, 40));
        this.lab.setHorizontalAlignment(0);

        labTxt =new MyLabelTimer("I WANT YOU");
        this.labTxt.setBounds(20, 360, 250, 60);
        this.labTxt.setFont(new Font("仿宋", Font.BOLD, 30));
        this.labTxt.setHorizontalAlignment(0);

        labBonus = new MyLabelBonus("");
        this.labBonus.setBounds(228, 360, 350, 60);
        this.labBonus.setFont(new Font("仿宋", Font.BOLD, 30));
        this.labBonus.setHorizontalAlignment(SwingConstants.LEFT);
        this.labBonus.setForeground(Color.red);

        this.label1 = new JLabel();
        this.label1.setIcon(new ImageIcon("resource/IwantU.png"));
        this.label1.setBounds(60, 100, 250, 250);

        this.loserTxt = new MyLabelLoser();
        this.loserTxt.setBounds(10, 430, 450, 60);
        this.loserTxt.setFont(new Font("仿宋", Font.BOLD, 30));
        this.loserTxt.setHorizontalAlignment(0);
        this.loserTxt.setForeground(Color.red);

        this.loserLab = new JLabel("");
        this.loserLab.setBounds(40, 470, 550, 60);
        this.loserLab.setFont(new Font("仿宋", Font.BOLD, 30));
        this.loserLab.setHorizontalAlignment(0);
        this.loserLab.setForeground(Color.red);

        this.add(lab);
        this.add(labTxt);
        this.add(labBonus);
        this.add(label1);
        this.add(loserTxt);
        this.add(loserLab);

        but1 = new JButton("开始");
        but1.setBounds(370, 120, 100, 60);

        but2 = new JButton("重置");
        but2.setBounds(370, 220, 100, 60);


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
        loser = new LoserThread(loserTxt);
        loser.setDaemon(true);
        loser.start();
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

    public MyLabelLoser getLoserTxt() {
        return loserTxt;
    }

    public void setLoserTxt(MyLabelLoser loserTxt) {
        this.loserTxt = loserTxt;
    }

    public JLabel getLoserLab() {
        return loserLab;
    }

    public void setLoserLab(JLabel loserLab) {
        this.loserLab = loserLab;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

}