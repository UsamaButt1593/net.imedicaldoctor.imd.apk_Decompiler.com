package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nDelegates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delegates.kt\nkotlin/properties/Delegates$vetoable$1\n*L\n1#1,73:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kotlin/properties/Delegates$vetoable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "d", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Delegates$vetoable$1 extends ObservableProperty<T> {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function3<KProperty<?>, T, T, Boolean> f28985b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Delegates$vetoable$1(T t, Function3<? super KProperty<?>, ? super T, ? super T, Boolean> function3) {
        super(t);
        this.f28985b = function3;
    }

    /* access modifiers changed from: protected */
    public boolean d(@NotNull KProperty<?> kProperty, T t, T t2) {
        Intrinsics.p(kProperty, "property");
        return this.f28985b.A(kProperty, t, t2).booleanValue();
    }
}
