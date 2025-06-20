package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0001\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"", "primitive", "Ljava/lang/Boolean;", "a", "(Z)Ljava/lang/Boolean;", "", "Ljava/lang/Byte;", "b", "(B)Ljava/lang/Byte;", "", "Ljava/lang/Short;", "h", "(S)Ljava/lang/Short;", "", "Ljava/lang/Integer;", "f", "(I)Ljava/lang/Integer;", "", "Ljava/lang/Long;", "g", "(J)Ljava/lang/Long;", "", "Ljava/lang/Float;", "e", "(F)Ljava/lang/Float;", "", "Ljava/lang/Double;", "d", "(D)Ljava/lang/Double;", "", "Ljava/lang/Character;", "c", "(C)Ljava/lang/Character;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "Boxing")
public final class Boxing {
    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Boolean a(boolean z) {
        return Boolean.valueOf(z);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Byte b(byte b2) {
        return Byte.valueOf(b2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Character c(char c2) {
        return new Character(c2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Double d(double d2) {
        return new Double(d2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Float e(float f2) {
        return new Float(f2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Integer f(int i2) {
        return new Integer(i2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Long g(long j2) {
        return new Long(j2);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final Short h(short s) {
        return new Short(s);
    }
}
