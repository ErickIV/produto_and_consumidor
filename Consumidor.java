public class Consumidor implements Runnable {
    private Compartilhado x;
    private int tempo;
    
    public Consumidor(Compartilhado x) {
        this.x = x;
    }
    
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    public int getTempo() {
        return tempo;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * getTempo()));
            } catch (InterruptedException e) {
            }
            x.produzir();
        }
    }
}
