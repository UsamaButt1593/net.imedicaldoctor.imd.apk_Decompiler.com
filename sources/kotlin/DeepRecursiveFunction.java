package kotlin;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.7")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BE\u00129\u0010\b\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004¢\u0006\u0002\b\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nRP\u0010\b\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004¢\u0006\u0002\b\u00078\u0000X\u0004ø\u0001\u0000¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/DeepRecursiveFunction;", "T", "R", "", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "a", "Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function3;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
public final class DeepRecursiveFunction<T, R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> f28774a;

    public DeepRecursiveFunction(@NotNull Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.p(function3, CSS.Value.v0);
        this.f28774a = function3;
    }

    @NotNull
    public final Function3<DeepRecursiveScope<T, R>, T, Continuation<? super R>, Object> a() {
        return this.f28774a;
    }
}
