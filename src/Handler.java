

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Handler implements ActionListener{
    private MyTimerFrame win;

    public Handler(MyTimerFrame win) {
        super();
        this.win = win;
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("开始")){
            win.getBut1().setText("暂停");
            win.getLab().setFlag(true);
            win.getLabBonus().setFlag(true);
            win.getLoserTxt().setFlag(false);
            win.getLab().notifyLabel();
        }else if(e.getActionCommand().equals("暂停")) {
            win.getBut1().setText("开始");
            win.getLab().setFlag(false);
            win.getLabBonus().setFlag(false);

            if ("".equals(win.getLabBonus().getText()) == false) {
                win.getLoserTxt().setFlag(true);
                win.getLoserTxt().notifyLabel();
                Random ra = new Random();
                int temp = ra.nextInt(3) + 2;
                win.getLoserLab().setText("你好意思不发个" + temp + "倍红包吗？！");
                win.getLabel1().setIcon(new ImageIcon("resource/yaoming.png"));
            }

        }else{
            win.getBut1().setText("开始");
            win.getLab().init();
            win.getLabBonus().init();
            win.getLoserTxt().init();;
            win.getLoserLab().setText("");
            win.getLabel1().setIcon(new ImageIcon("resource/IwantU.png"));
        }
    }
}