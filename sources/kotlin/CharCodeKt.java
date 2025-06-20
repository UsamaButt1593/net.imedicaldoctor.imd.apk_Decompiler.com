package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\"\u001f\u0010\u0001\u001a\u00020\u0000*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"", "code", "", "a", "(I)C", "b", "(C)I", "c", "(C)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class CharCodeKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char a(int i2) {
        if (i2 >= 0 && i2 <= 65535) {
            return (char) i2;
        }
        throw new IllegalArgumentException("Invalid Char code: " + i2);
    }

    private static final int b(char c2) {
        return c2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void c(char c2) {
    }
}
