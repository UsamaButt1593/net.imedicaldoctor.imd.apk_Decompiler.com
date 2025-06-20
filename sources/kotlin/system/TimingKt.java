package kotlin.system;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a.\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a.\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0006\u0010\u0005\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", "block", "", "b", "(Lkotlin/jvm/functions/Function0;)J", "a", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "TimingKt")
public final class TimingKt {
    public static final long a(@NotNull Function0<Unit> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        long nanoTime = System.nanoTime();
        function0.o();
        return System.nanoTime() - nanoTime;
    }

    public static final long b(@NotNull Function0<Unit> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        long currentTimeMillis = System.currentTimeMillis();
        function0.o();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}
