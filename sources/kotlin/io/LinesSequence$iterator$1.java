package kotlin.io;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"kotlin/io/LinesSequence$iterator$1", "", "", "", "hasNext", "()Z", "a", "()Ljava/lang/String;", "s", "Ljava/lang/String;", "nextValue", "X", "Z", "done", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class LinesSequence$iterator$1 implements Iterator<String>, KMappedMarker {
    private boolean X;
    final /* synthetic */ LinesSequence Y;
    @Nullable
    private String s;

    LinesSequence$iterator$1(LinesSequence linesSequence) {
        this.Y = linesSequence;
    }

    @NotNull
    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            String str = this.s;
            this.s = null;
            Intrinsics.m(str);
            return str;
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.s == null && !this.X) {
            String readLine = this.Y.f28853a.readLine();
            this.s = readLine;
            if (readLine == null) {
                this.X = true;
            }
        }
        return this.s != null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
