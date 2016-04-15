import javax.swing.*;
import java.text.DecimalFormat;

public class MyLabelBonus extends JLabel {
    private int  yuan, ps, pc;

    private boolean flag = false;


    private boolean startBonus = false;

    private DecimalFormat df = new DecimalFormat("000");

    public MyLabelBonus(String names) {
        super(names);
    }


    public int getYuan() {
        return yuan;
    }

    public void setYuan(int yuan) {
        this.yuan = yuan;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }


    public boolean isStartBonus() {
        return startBonus;
    }

    public void setStartBonus(boolean startBonus) {
        this.startBonus = startBonus;
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    /**
     * ÖØÖÃ
     */
    public void init() {
        this.flag = false;
        this.yuan = 0;
        this.ps = 0;
        this.pc = 0;
        this.setText("");
    }

    /**
     * »½ÐÑÐÝÃß
     */
    public synchronized void notifyLabel() {
        this.notifyAll();
    }

    public synchronized void bonar() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        pc++;
        if (pc >= 12000)
            ps++;
        if (ps >= 1000) {
            yuan++;
            ps = 0;
        }

        if (yuan > 0 || ps > 0)
            this.setText("R MONEY: " + yuan + "." + df.format(ps));
    }
}