package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "T", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class SingleProcessDataStore$actor$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ SingleProcessDataStore<T> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$actor$1(SingleProcessDataStore<T> singleProcessDataStore) {
        super(1);
        this.X = singleProcessDataStore;
    }

    public final void b(@Nullable Throwable th) {
        if (th != null) {
            this.X.f6921h.setValue(new Final(th));
        }
        SingleProcessDataStore.Companion companion = SingleProcessDataStore.f6911k;
        Object b2 = companion.b();
        SingleProcessDataStore<T> singleProcessDataStore = this.X;
        synchronized (b2) {
            companion.a().remove(singleProcessDataStore.r().getAbsolutePath());
            Unit unit = Unit.f28779a;
        }
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }
}
