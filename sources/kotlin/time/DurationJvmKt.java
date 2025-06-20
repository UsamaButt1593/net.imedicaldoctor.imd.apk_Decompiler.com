package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\t\"\u001a\u0010\u000f\u001a\u00020\u000b8\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\" \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00110\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012¨\u0006\u0014"}, d2 = {"", "decimals", "Ljava/text/DecimalFormat;", "a", "(I)Ljava/text/DecimalFormat;", "", "value", "", "b", "(DI)Ljava/lang/String;", "c", "", "Z", "d", "()Z", "durationAssertionsEnabled", "", "Ljava/lang/ThreadLocal;", "[Ljava/lang/ThreadLocal;", "precisionFormats", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
public final class DurationJvmKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f29131a = false;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f29132b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        f29132b = threadLocalArr;
    }

    private static final DecimalFormat a(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i2 > 0) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @NotNull
    public static final String b(double d2, int i2) {
        DecimalFormat decimalFormat;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f29132b;
        if (i2 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i2];
            DecimalFormat decimalFormat2 = threadLocal.get();
            if (decimalFormat2 == null) {
                decimalFormat2 = a(i2);
                threadLocal.set(decimalFormat2);
            } else {
                Intrinsics.o(decimalFormat2, "get() ?: default().also(this::set)");
            }
            decimalFormat = decimalFormat2;
        } else {
            decimalFormat = a(i2);
        }
        String format = decimalFormat.format(d2);
        Intrinsics.o(format, "format.format(value)");
        return format;
    }

    @NotNull
    public static final String c(double d2, int i2) {
        DecimalFormat a2 = a(0);
        a2.setMaximumFractionDigits(i2);
        String format = a2.format(d2);
        Intrinsics.o(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }

    public static final boolean d() {
        return f29131a;
    }
}
