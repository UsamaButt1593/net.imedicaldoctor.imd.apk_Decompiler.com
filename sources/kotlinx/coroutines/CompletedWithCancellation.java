package kotlinx.coroutines;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B4\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012#\b\u0002\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR/\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "a", "()Ljava/lang/Object;", "b", "()Lkotlin/jvm/functions/Function1;", "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CompletedWithCancellation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class CompletedWithCancellation {
    @Nullable
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final Object f29165a;
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Throwable, Unit> f29166b;

    public CompletedWithCancellation(@Nullable Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        this.f29165a = obj;
        this.f29166b = function1;
    }

    public static /* synthetic */ CompletedWithCancellation d(CompletedWithCancellation completedWithCancellation, Object obj, Function1<Throwable, Unit> function1, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = completedWithCancellation.f29165a;
        }
        if ((i2 & 2) != 0) {
            function1 = completedWithCancellation.f29166b;
        }
        return completedWithCancellation.c(obj, function1);
    }

    @Nullable
    public final Object a() {
        return this.f29165a;
    }

    @NotNull
    public final Function1<Throwable, Unit> b() {
        return this.f29166b;
    }

    @NotNull
    public final CompletedWithCancellation c(@Nullable Object obj, @NotNull Function1<? super Throwable, Unit> function1) {
        return new CompletedWithCancellation(obj, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
        return Intrinsics.g(this.f29165a, completedWithCancellation.f29165a) && Intrinsics.g(this.f29166b, completedWithCancellation.f29166b);
    }

    public int hashCode() {
        Object obj = this.f29165a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f29166b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f29165a + ", onCancellation=" + this.f29166b + ASCIIPropertyListParser.f18650h;
    }
}
