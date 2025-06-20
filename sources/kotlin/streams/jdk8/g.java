package kotlin.streams.jdk8;

import java.util.function.Supplier;
import kotlin.sequences.Sequence;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sequence f29051a;

    public /* synthetic */ g(Sequence sequence) {
        this.f29051a = sequence;
    }

    public final Object get() {
        return StreamsKt.g(this.f29051a);
    }
}
