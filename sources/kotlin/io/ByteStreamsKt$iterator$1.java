package kotlin.io;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u0017¨\u0006\u001d"}, d2 = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "", "e", "()V", "", "hasNext", "()Z", "", "K", "()B", "", "s", "I", "c", "()I", "g", "(I)V", "nextByte", "X", "Z", "d", "h", "(Z)V", "nextPrepared", "Y", "b", "f", "finished", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class ByteStreamsKt$iterator$1 extends ByteIterator {
    private boolean X;
    private boolean Y;
    final /* synthetic */ BufferedInputStream Z;
    private int s = -1;

    ByteStreamsKt$iterator$1(BufferedInputStream bufferedInputStream) {
        this.Z = bufferedInputStream;
    }

    private final void e() {
        if (!this.X && !this.Y) {
            int read = this.Z.read();
            this.s = read;
            boolean z = true;
            this.X = true;
            if (read != -1) {
                z = false;
            }
            this.Y = z;
        }
    }

    public byte K() {
        e();
        if (!this.Y) {
            byte b2 = (byte) this.s;
            this.X = false;
            return b2;
        }
        throw new NoSuchElementException("Input stream is over.");
    }

    public final boolean b() {
        return this.Y;
    }

    public final int c() {
        return this.s;
    }

    public final boolean d() {
        return this.X;
    }

    public final void f(boolean z) {
        this.Y = z;
    }

    public final void g(int i2) {
        this.s = i2;
    }

    public final void h(boolean z) {
        this.X = z;
    }

    public boolean hasNext() {
        e();
        return !this.Y;
    }
}
