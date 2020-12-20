package day13;

public class Bus {

    private long index;
    private long id;
    private long b;
    private long n;
    private long x;
    private long product;

    public Bus(long index, long id) {
        this.index = index;
        this.id = id;
        this.b = id - index;
    }

    public void setN(long value) {
        this.n = value / this.id;
    }

    public void setX() {
        for (int i=1;;i++) {
            if (i * this.n % this.id == 1) {
                this.x = i;
                this.product = this.b * this.n * this.x;
                return;
            }
        }
    }

    public long getIndex() {
        return index;
    }

    public long getId() {
        return id;
    }

    public long getProduct() {
        return product;
    }
}
