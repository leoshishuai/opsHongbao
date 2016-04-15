
public class LoserThread extends Thread {
    private MyLabelLoser loser;
    public LoserThread(MyLabelLoser loser) {
        super();
        this.loser = loser;
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loser.randomMember();
        }
    }


}