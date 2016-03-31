

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            win.getLab().notifyLabel();
        }else if(e.getActionCommand().equals("暂停")) {
            win.getBut1().setText("开始");
            win.getLab().setFlag(false);
            win.getLabBonus().setFlag(false);

        }else{
            win.getBut1().setText("开始");
            win.getLab().init();
            win.getLabBonus().init();
        }
    }

}