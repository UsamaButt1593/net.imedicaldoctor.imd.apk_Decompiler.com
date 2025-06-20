package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\bS\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001e\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003H\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u0003*\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a0\u0010\u001d\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u001aH\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a0\u0010\u001f\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u001aH\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010#\u001a\u001a\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010#\u001a\u001a\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010#\u001a\"\u0010,\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001a\u0010.\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010#\u001a\u001a\u0010/\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010#\"\u0014\u00102\u001a\u00020\u00008\u0000XT¢\u0006\u0006\n\u0004\b0\u00101\"\u0014\u00105\u001a\u00020\u00068\u0000XT¢\u0006\u0006\n\u0004\b3\u00104\"\u0014\u00107\u001a\u00020\u00068\u0000XT¢\u0006\u0006\n\u0004\b6\u00104\"\u0014\u00109\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b8\u00104\"!\u0010>\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b<\u0010=\u001a\u0004\b:\u0010;\"!\u0010>\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b@\u0010A\u001a\u0004\b?\u0010#\"!\u0010>\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bD\u0010E\u001a\u0004\bB\u0010C\"!\u0010H\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bG\u0010=\u001a\u0004\bF\u0010;\"!\u0010H\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bJ\u0010A\u001a\u0004\bI\u0010#\"!\u0010H\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bL\u0010E\u001a\u0004\bK\u0010C\"!\u0010N\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b4\u0010=\u001a\u0004\bM\u0010;\"!\u0010N\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bP\u0010A\u001a\u0004\bO\u0010#\"!\u0010N\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u0010E\u001a\u0004\bQ\u0010C\"!\u0010T\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bS\u0010=\u001a\u0004\bR\u0010;\"!\u0010T\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bV\u0010A\u001a\u0004\bU\u0010#\"!\u0010T\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bX\u0010E\u001a\u0004\bW\u0010C\"!\u0010[\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bZ\u0010=\u001a\u0004\bY\u0010;\"!\u0010[\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b]\u0010A\u001a\u0004\b\\\u0010#\"!\u0010[\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b_\u0010E\u001a\u0004\b^\u0010C\"!\u0010b\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\ba\u0010=\u001a\u0004\b`\u0010;\"!\u0010b\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bd\u0010A\u001a\u0004\bc\u0010#\"!\u0010b\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bf\u0010E\u001a\u0004\be\u0010C\"!\u0010i\u001a\u00020\u0003*\u00020\u00008FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bh\u0010=\u001a\u0004\bg\u0010;\"!\u0010i\u001a\u00020\u0003*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bk\u0010A\u001a\u0004\bj\u0010#\"!\u0010i\u001a\u00020\u0003*\u00020\t8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\bm\u0010E\u001a\u0004\bl\u0010C\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "m0", "(ILkotlin/time/DurationUnit;)J", "", "n0", "(JLkotlin/time/DurationUnit;)J", "", "l0", "(DLkotlin/time/DurationUnit;)J", "duration", "k0", "(IJ)J", "j0", "(DJ)J", "", "value", "", "strictIso", "f0", "(Ljava/lang/String;Z)J", "g0", "(Ljava/lang/String;)J", "startIndex", "Lkotlin/Function1;", "", "predicate", "i0", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Ljava/lang/String;", "h0", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)I", "nanos", "e0", "(J)J", "millis", "d0", "normalNanos", "l", "normalMillis", "j", "normalValue", "unitDiscriminator", "i", "(JI)J", "m", "k", "a", "I", "NANOS_IN_MILLIS", "b", "J", "MAX_NANOS", "c", "MAX_MILLIS", "d", "MAX_NANOS_IN_MILLIS", "S", "(I)J", "V", "(I)V", "nanoseconds", "T", "W", "(J)V", "R", "(D)J", "U", "(D)V", "A", "D", "microseconds", "B", "E", "z", "C", "G", "milliseconds", "H", "K", "F", "Y", "b0", "seconds", "Z", "c0", "X", "a0", "M", "P", "minutes", "N", "Q", "L", "O", "u", "x", "hours", "v", "y", "t", "w", "o", "r", "days", "p", "s", "n", "q", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1495:1\n1447#1,6:1497\n1450#1,3:1503\n1447#1,6:1506\n1447#1,6:1512\n1450#1,3:1521\n1#2:1496\n1726#3,3:1518\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1371#1:1497,6\n1405#1:1503,3\n1408#1:1506,6\n1411#1:1512,6\n1447#1:1521,3\n1436#1:1518,3\n*E\n"})
public final class DurationKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f29133a = 1000000;

    /* renamed from: b  reason: collision with root package name */
    public static final long f29134b = 4611686018426999999L;

    /* renamed from: c  reason: collision with root package name */
    public static final long f29135c = 4611686018427387903L;

    /* renamed from: d  reason: collision with root package name */
    private static final long f29136d = 4611686018426L;

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void C(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void D(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void E(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void I(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void J(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void K(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void O(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void P(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @ExperimentalTime
    public static /* synthetic */ void Q(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void U(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void V(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @ExperimentalTime
    public static /* synthetic */ void W(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void a0(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void b0(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @ExperimentalTime
    public static /* synthetic */ void c0(long j2) {
    }

    /* access modifiers changed from: private */
    public static final long d0(long j2) {
        return j2 * ((long) 1000000);
    }

    /* access modifiers changed from: private */
    public static final long e0(long j2) {
        return j2 / ((long) 1000000);
    }

    /* access modifiers changed from: private */
    public static final long f0(String str, boolean z) {
        boolean z2;
        long j2;
        int i2;
        boolean z3;
        long j3;
        int i3;
        String str2 = str;
        int length = str.length();
        if (length != 0) {
            Duration.Companion companion = Duration.X;
            long W = companion.W();
            char charAt = str2.charAt(0);
            int i4 = (charAt == '+' || charAt == '-') ? 1 : 0;
            boolean z4 = i4 > 0;
            boolean z5 = z4 && StringsKt.b5(str2, '-', false, 2, (Object) null);
            if (length > i4) {
                String str3 = "No components";
                char c2 = '9';
                char c3 = '0';
                if (str2.charAt(i4) == 'P') {
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        boolean z6 = false;
                        DurationUnit durationUnit = null;
                        while (i5 < length) {
                            if (str2.charAt(i5) != 'T') {
                                int i6 = i5;
                                while (true) {
                                    if (i6 >= str.length()) {
                                        i3 = length;
                                        break;
                                    }
                                    char charAt2 = str2.charAt(i6);
                                    if (!new CharRange(c3, c2).q(charAt2)) {
                                        i3 = length;
                                        if (!StringsKt.S2("+-.", charAt2, false, 2, (Object) null)) {
                                            break;
                                        }
                                    } else {
                                        i3 = length;
                                    }
                                    i6++;
                                    length = i3;
                                    c3 = '0';
                                    c2 = '9';
                                }
                                Intrinsics.n(str2, "null cannot be cast to non-null type java.lang.String");
                                String substring = str2.substring(i5, i6);
                                Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                if (substring.length() != 0) {
                                    int length2 = i5 + substring.length();
                                    if (length2 < 0 || length2 > StringsKt.g3(str)) {
                                        throw new IllegalArgumentException("Missing unit for value " + substring);
                                    }
                                    char charAt3 = str2.charAt(length2);
                                    i5 = length2 + 1;
                                    DurationUnit f2 = DurationUnitKt__DurationUnitKt.f(charAt3, z6);
                                    if (durationUnit == null || durationUnit.compareTo(f2) > 0) {
                                        int o3 = StringsKt.o3(substring, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, (Object) null);
                                        if (f2 != DurationUnit.SECONDS || o3 <= 0) {
                                            W = Duration.p0(W, n0(g0(substring), f2));
                                        } else {
                                            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring2 = substring.substring(0, o3);
                                            Intrinsics.o(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                            long p0 = Duration.p0(W, n0(g0(substring2), f2));
                                            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring3 = substring.substring(o3);
                                            Intrinsics.o(substring3, "this as java.lang.String).substring(startIndex)");
                                            W = Duration.p0(p0, l0(Double.parseDouble(substring3), f2));
                                        }
                                        durationUnit = f2;
                                        length = i3;
                                        c3 = '0';
                                        c2 = '9';
                                        str2 = str;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected order of duration components");
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else if (z6 || (i5 = i5 + 1) == length) {
                                throw new IllegalArgumentException();
                            } else {
                                z6 = true;
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    int i7 = length;
                    if (!z) {
                        String str4 = "Unexpected order of duration components";
                        String str5 = "this as java.lang.String).substring(startIndex)";
                        String str6 = str3;
                        long j4 = W;
                        char c4 = '9';
                        if (StringsKt.b2(str, i4, "Infinity", 0, Math.max(i7 - i4, 8), true)) {
                            W = companion.q();
                        } else {
                            boolean z7 = !z4;
                            String str7 = str;
                            if (z4 && str7.charAt(i4) == '(' && StringsKt.r7(str) == ')') {
                                i4++;
                                int i8 = i7 - 1;
                                if (i4 != i8) {
                                    i2 = i8;
                                    j2 = j4;
                                    z3 = false;
                                    z2 = true;
                                } else {
                                    throw new IllegalArgumentException(str6);
                                }
                            } else {
                                z2 = z7;
                                j2 = j4;
                                i2 = i7;
                                z3 = false;
                            }
                            DurationUnit durationUnit2 = null;
                            while (i4 < i2) {
                                if (z3 && z2) {
                                    while (i4 < str.length() && str7.charAt(i4) == ' ') {
                                        i4++;
                                    }
                                }
                                int i9 = i4;
                                while (true) {
                                    if (i9 >= str.length()) {
                                        break;
                                    }
                                    char charAt4 = str7.charAt(i9);
                                    if (!new CharRange('0', c4).q(charAt4) && charAt4 != '.') {
                                        break;
                                    }
                                    i9++;
                                }
                                Intrinsics.n(str7, "null cannot be cast to non-null type java.lang.String");
                                String substring4 = str7.substring(i4, i9);
                                Intrinsics.o(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                                if (substring4.length() != 0) {
                                    int length3 = i4 + substring4.length();
                                    int i10 = length3;
                                    while (i10 < str.length()) {
                                        if (!new CharRange('a', 'z').q(str7.charAt(i10))) {
                                            break;
                                        }
                                        i10++;
                                    }
                                    Intrinsics.n(str7, "null cannot be cast to non-null type java.lang.String");
                                    String substring5 = str7.substring(length3, i10);
                                    Intrinsics.o(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
                                    i4 = length3 + substring5.length();
                                    DurationUnit g2 = DurationUnitKt__DurationUnitKt.g(substring5);
                                    if (durationUnit2 == null || durationUnit2.compareTo(g2) > 0) {
                                        String str8 = str4;
                                        int o32 = StringsKt.o3(substring4, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, (Object) null);
                                        if (o32 > 0) {
                                            Intrinsics.n(substring4, "null cannot be cast to non-null type java.lang.String");
                                            String substring6 = substring4.substring(0, o32);
                                            Intrinsics.o(substring6, "this as java.lang.String…ing(startIndex, endIndex)");
                                            long p02 = Duration.p0(j3, n0(Long.parseLong(substring6), g2));
                                            Intrinsics.n(substring4, "null cannot be cast to non-null type java.lang.String");
                                            String substring7 = substring4.substring(o32);
                                            Intrinsics.o(substring7, str5);
                                            j3 = Duration.p0(p02, l0(Double.parseDouble(substring7), g2));
                                            if (i4 < i2) {
                                                throw new IllegalArgumentException("Fractional component must be last");
                                            }
                                        } else {
                                            j3 = Duration.p0(j3, n0(Long.parseLong(substring4), g2));
                                        }
                                        str4 = str8;
                                        durationUnit2 = g2;
                                        z3 = true;
                                        c4 = '9';
                                    } else {
                                        throw new IllegalArgumentException(str4);
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                            W = j3;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                return z5 ? Duration.Q0(W) : W;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    private static final long g0(String str) {
        int length = str.length();
        int i2 = (length <= 0 || !StringsKt.S2("+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i2 > 16) {
            IntRange intRange = new IntRange(i2, StringsKt.g3(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator it2 = intRange.iterator();
                while (it2.hasNext()) {
                    if (!new CharRange('0', '9').q(str.charAt(((IntIterator) it2).b()))) {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (StringsKt.s2(str, "+", false, 2, (Object) null)) {
            str = StringsKt.y6(str, 1);
        }
        return Long.parseLong(str);
    }

    private static final int h0(String str, int i2, Function1<? super Character, Boolean> function1) {
        while (i2 < str.length() && function1.f(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static final long i(long j2, int i2) {
        return Duration.j((j2 << 1) + ((long) i2));
    }

    private static final String i0(String str, int i2, Function1<? super Character, Boolean> function1) {
        int i3 = i2;
        while (i3 < str.length() && function1.f(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        Intrinsics.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i2, i3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* access modifiers changed from: private */
    public static final long j(long j2) {
        return Duration.j((j2 << 1) + 1);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    private static final long j0(double d2, long j2) {
        return Duration.q0(j2, d2);
    }

    /* access modifiers changed from: private */
    public static final long k(long j2) {
        return new LongRange(-4611686018426L, f29136d).q(j2) ? l(d0(j2)) : j(RangesKt.K(j2, -4611686018427387903L, f29135c));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalTime.class})
    private static final long k0(int i2, long j2) {
        return Duration.r0(j2, i2);
    }

    /* access modifiers changed from: private */
    public static final long l(long j2) {
        return Duration.j(j2 << 1);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long l0(double d2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        double a2 = DurationUnitKt__DurationUnitJvmKt.a(d2, durationUnit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(a2)) {
            long M0 = MathKt.M0(a2);
            return new LongRange(-4611686018426999999L, f29134b).q(M0) ? l(M0) : k(MathKt.M0(DurationUnitKt__DurationUnitJvmKt.a(d2, durationUnit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    /* access modifiers changed from: private */
    public static final long m(long j2) {
        return new LongRange(-4611686018426999999L, f29134b).q(j2) ? l(j2) : j(e0(j2));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long m0(int i2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        return durationUnit.compareTo(DurationUnit.SECONDS) <= 0 ? l(DurationUnitKt__DurationUnitJvmKt.c((long) i2, durationUnit, DurationUnit.NANOSECONDS)) : n0((long) i2, durationUnit);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long n0(long j2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long c2 = DurationUnitKt__DurationUnitJvmKt.c(f29134b, durationUnit2, durationUnit);
        return new LongRange(-c2, c2).q(j2) ? l(DurationUnitKt__DurationUnitJvmKt.c(j2, durationUnit, durationUnit2)) : j(RangesKt.K(DurationUnitKt__DurationUnitJvmKt.b(j2, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, f29135c));
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void q(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void r(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @ExperimentalTime
    public static /* synthetic */ void s(long j2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void w(double d2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void x(int i2) {
    }

    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @ExperimentalTime
    public static /* synthetic */ void y(long j2) {
    }
}
