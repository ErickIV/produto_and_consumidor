public class Produtor implements Runnable {
    private Compartilhado x;
    private int tempo;

    public Produtor(Compartilhado x) {
        this.x = x;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * tempo));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x.produzir();
        }
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
