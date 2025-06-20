package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "T", "Landroidx/datastore/core/CorruptionHandler;", "Lkotlin/Function1;", "Landroidx/datastore/core/CorruptionException;", "produceNewData", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ex", "a", "(Landroidx/datastore/core/CorruptionException;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Function1<CorruptionException, T> f6934a;

    public ReplaceFileCorruptionHandler(@NotNull Function1<? super CorruptionException, ? extends T> function1) {
        Intrinsics.p(function1, "produceNewData");
        this.f6934a = function1;
    }

    @Nullable
    public Object a(@NotNull CorruptionException corruptionException, @NotNull Continuation<? super T> continuation) throws IOException {
        return this.f6934a.f(corruptionException);
    }
}
