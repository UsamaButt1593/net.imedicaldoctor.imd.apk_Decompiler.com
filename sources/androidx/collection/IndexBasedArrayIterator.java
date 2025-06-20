package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class IndexBasedArrayIterator<T> implements Iterator<T> {
    private int X;
    private boolean Y;
    private int s;

    IndexBasedArrayIterator(int i2) {
        this.s = i2;
    }

    /* access modifiers changed from: protected */
    public abstract T a(int i2);

    /* access modifiers changed from: protected */
    public abstract void b(int i2);

    public final boolean hasNext() {
        return this.X < this.s;
    }

    public T next() {
        if (hasNext()) {
            T a2 = a(this.X);
            this.X++;
            this.Y = true;
            return a2;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (this.Y) {
            int i2 = this.X - 1;
            this.X = i2;
            b(i2);
            this.s--;
            this.Y = false;
            return;
        }
        throw new IllegalStateException();
    }
}
