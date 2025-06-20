package androidx.lifecycle;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, FunctionAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Function1 f8598a;

    Transformations$sam$androidx_lifecycle_Observer$0(Function1 function1) {
        Intrinsics.p(function1, "function");
        this.f8598a = function1;
    }

    @NotNull
    public final Function<?> a() {
        return this.f8598a;
    }

    public final /* synthetic */ void b(Object obj) {
        this.f8598a.f(obj);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.g(a(), ((FunctionAdapter) obj).a());
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
