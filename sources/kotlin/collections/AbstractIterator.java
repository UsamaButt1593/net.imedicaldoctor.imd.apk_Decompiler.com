package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH$¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/collections/AbstractIterator;", "T", "", "<init>", "()V", "", "d", "()Z", "hasNext", "next", "()Ljava/lang/Object;", "", "a", "value", "c", "(Ljava/lang/Object;)V", "b", "Lkotlin/collections/State;", "s", "Lkotlin/collections/State;", "state", "X", "Ljava/lang/Object;", "nextValue", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    @Nullable
    private T X;
    @NotNull
    private State s = State.NotReady;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28782a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlin.collections.State[] r0 = kotlin.collections.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.collections.State r1 = kotlin.collections.State.Done     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.collections.State r1 = kotlin.collections.State.Ready     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f28782a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.AbstractIterator.WhenMappings.<clinit>():void");
        }
    }

    private final boolean d() {
        this.s = State.Failed;
        a();
        return this.s == State.Ready;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public final void b() {
        this.s = State.Done;
    }

    /* access modifiers changed from: protected */
    public final void c(T t) {
        this.X = t;
        this.s = State.Ready;
    }

    public boolean hasNext() {
        State state = this.s;
        if (state != State.Failed) {
            int i2 = WhenMappings.f28782a[state.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 != 2) {
                return d();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.s = State.NotReady;
            return this.X;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
