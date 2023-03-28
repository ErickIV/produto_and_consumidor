public class Compartilhado {
    private int buffer;
    private int tamanhoBuffer;

    public Compartilhado(int tamanhoBuffer) {
        this.buffer = 0;
        this.tamanhoBuffer = tamanhoBuffer;
    }

    public Compartilhado() {
    }

    public synchronized void consumir() {
        while (buffer == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer--;
        notifyAll();
    }

    public synchronized void produzir() {
        while (buffer == tamanhoBuffer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer++;
        notifyAll();
    }

    public synchronized int getBuffer() {
        return buffer;
    }

    public synchronized void setBuffer(int buffer) {
        this.buffer = buffer;
    }
}
