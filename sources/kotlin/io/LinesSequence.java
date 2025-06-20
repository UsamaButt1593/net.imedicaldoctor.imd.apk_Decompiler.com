package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/io/LinesSequence;", "Lkotlin/sequences/Sequence;", "", "Ljava/io/BufferedReader;", "reader", "<init>", "(Ljava/io/BufferedReader;)V", "", "iterator", "()Ljava/util/Iterator;", "a", "Ljava/io/BufferedReader;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class LinesSequence implements Sequence<String> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f28853a;

    public LinesSequence(@NotNull BufferedReader bufferedReader) {
        Intrinsics.p(bufferedReader, "reader");
        this.f28853a = bufferedReader;
    }

    @NotNull
    public Iterator<String> iterator() {
        return new LinesSequence$iterator$1(this);
    }
}
