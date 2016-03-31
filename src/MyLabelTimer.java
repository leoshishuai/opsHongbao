import java.text.DecimalFormat;

import javax.swing.JLabel;

public class MyLabelTimer extends JLabel{
    private int min,senconds,ps;
    private boolean flag=false;
    private DecimalFormat df = new DecimalFormat("00");

    public MyLabelTimer(String names) {
        super(names);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSenconds() {
        return senconds;
    }

    public void setSenconds(int senconds) {
        this.senconds = senconds;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
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
    public void init(){
        this.flag=false;
        this.min=0;
        this.senconds=0;
        this.ps=0;

        this.setText("00:00:00");
    }

    /**
     * ¼ÆÊ±Æ÷
     */
    public synchronized void timer(){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ps++;
        if(ps>=100){
            senconds++;
            ps=0;
            if(senconds>=60){
                min++;
                senconds=0;
            }
        }

        this.setText(df.format(min)+":"+df.format(senconds)+":"+df.format(ps));

    }
    /**
     * »½ÐÑÐÝÃß
     */
    public synchronized void notifyLabel() {
        this.notifyAll();
    }

}