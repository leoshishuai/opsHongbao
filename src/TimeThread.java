
public class TimeThread extends Thread {
    private MyLabelTimer lab;
    private MyLabelBonus labBonus;

    public TimeThread(MyLabelTimer lab, MyLabelBonus labBonus) {
        super();
        this.lab = lab;
        this.labBonus = labBonus;
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            lab.timer();
            labBonus.bonar();
        }
    }


}