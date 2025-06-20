package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.utils.Utils;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.firebase.sessions.j;
import com.itextpdf.text.pdf.Barcode128;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
@SinceKotlin(version = "1.6")
@SourceDebugExtension({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1495:1\n38#1:1496\n38#1:1497\n38#1:1498\n38#1:1499\n38#1:1500\n683#1,2:1501\n700#1,2:1510\n163#2,6:1503\n1#3:1509\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1496\n40#1:1497\n458#1:1498\n478#1:1499\n662#1:1500\n979#1:1501,2\n1070#1:1510,2\n1021#1:1503,6\n*E\n"})
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b>\b@\u0018\u0000 \u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0016\u0010\n\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\rJ\u001e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0017H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0017H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\bJ\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\bJ\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\bJ\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\bJ\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0001\u00102\u001a\u00028\u0000\"\u0004\b\u0000\u0010(2u\u00101\u001aq\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00000)H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b2\u00103J\u0001\u00105\u001a\u00028\u0000\"\u0004\b\u0000\u0010(2`\u00101\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u000004H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b5\u00106Js\u00108\u001a\u00028\u0000\"\u0004\b\u0000\u0010(2K\u00101\u001aG\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u000007H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b8\u00109J^\u0010;\u001a\u00028\u0000\"\u0004\b\u0000\u0010(26\u00101\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00000:H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b?\u0010!J\u0015\u0010@\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0002H\u0007¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\u0002H\u0007¢\u0006\u0004\bC\u0010\u0005J\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ?\u0010N\u001a\u00020M*\u00060Gj\u0002`H2\u0006\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020D2\u0006\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010Q\u001a\u00020D2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010P\u001a\u00020\u0013¢\u0006\u0004\bQ\u0010RJ\r\u0010S\u001a\u00020D¢\u0006\u0004\bS\u0010FJ\u0010\u0010T\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\bT\u0010UJ\u001a\u0010W\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bW\u0010XR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0005R\u0015\u0010^\u001a\u00020\u00138Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b]\u0010UR\u0014\u0010a\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0017\u0010c\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bb\u0010\u0005R\u001a\u0010g\u001a\u00020\u00138@X\u0004¢\u0006\f\u0012\u0004\be\u0010f\u001a\u0004\bd\u0010UR\u001a\u0010j\u001a\u00020\u00138@X\u0004¢\u0006\f\u0012\u0004\bi\u0010f\u001a\u0004\bh\u0010UR\u001a\u0010m\u001a\u00020\u00138@X\u0004¢\u0006\f\u0012\u0004\bl\u0010f\u001a\u0004\bk\u0010UR\u001a\u0010o\u001a\u00020\u00138@X\u0004¢\u0006\f\u0012\u0004\bn\u0010f\u001a\u0004\b(\u0010UR\u001a\u0010r\u001a\u00020\u00178FX\u0004¢\u0006\f\u0012\u0004\bY\u0010f\u001a\u0004\bp\u0010qR\u001a\u0010u\u001a\u00020\u00178FX\u0004¢\u0006\f\u0012\u0004\bt\u0010f\u001a\u0004\bs\u0010qR\u001a\u0010x\u001a\u00020\u00178FX\u0004¢\u0006\f\u0012\u0004\bw\u0010f\u001a\u0004\bv\u0010qR\u001a\u0010{\u001a\u00020\u00178FX\u0004¢\u0006\f\u0012\u0004\bz\u0010f\u001a\u0004\by\u0010qR\u001a\u0010~\u001a\u00020\u00178FX\u0004¢\u0006\f\u0012\u0004\b}\u0010f\u001a\u0004\b|\u0010qR\u001c\u0010\u0001\u001a\u00020\u00178FX\u0004¢\u0006\r\u0012\u0005\b\u0001\u0010f\u001a\u0004\b\u0010qR\u001d\u0010\u0001\u001a\u00020\u00178FX\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u0010f\u001a\u0005\b\u0001\u0010qR\u0013\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0005R\u0012\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bZ\u0010\u0005R\u0013\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0005R\u0013\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0005R\u0013\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0005R\u0013\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0005R\u0013\u0010\u0001\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0005\u0001\u0003\u0001\u00020\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "", "rawValue", "j", "(J)J", "", "h0", "(J)Z", "g0", "Q0", "other", "p0", "(JJ)J", "thisMillis", "otherNanos", "e", "(JJJ)J", "m0", "", "scale", "r0", "(JI)J", "", "q0", "(JD)J", "m", "l", "k", "(JJ)D", "Lkotlin/time/DurationUnit;", "unit", "P0", "(JLkotlin/time/DurationUnit;)J", "j0", "k0", "i0", "e0", "i", "(JJ)I", "T", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "A0", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "x0", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "v0", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "s0", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "B0", "(JLkotlin/time/DurationUnit;)D", "G0", "C0", "(JLkotlin/time/DurationUnit;)I", "J0", "I0", "", "K0", "(J)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "", "f", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "L0", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "D0", "d0", "(J)I", "", "n", "(JLjava/lang/Object;)Z", "s", "J", "c0", "value", "a0", "unitDiscriminator", "Z", "(J)Lkotlin/time/DurationUnit;", "storageUnit", "p", "absoluteValue", "r", "q", "()V", "hoursComponent", "R", "Q", "minutesComponent", "W", "U", "secondsComponent", "S", "nanosecondsComponent", "u", "(J)D", "inDays", "w", "v", "inHours", "D", "C", "inMinutes", "H", "G", "inSeconds", "A", "z", "inMilliseconds", "y", "x", "inMicroseconds", "F", "E", "inNanoseconds", "I", "inWholeDays", "inWholeHours", "N", "inWholeMinutes", "P", "inWholeSeconds", "L", "inWholeMilliseconds", "K", "inWholeMicroseconds", "O", "inWholeNanoseconds", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalTime.class})
public final class Duration implements Comparable<Duration> {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long X2 = DurationKt.j(-4611686018427387903L);
    /* access modifiers changed from: private */
    public static final long Y = j(0);
    /* access modifiers changed from: private */
    public static final long Z = DurationKt.j(DurationKt.f29135c);
    private final long s;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\bB\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u001d\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u000eJ\u001d\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0011J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u001d\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u000eJ\u001d\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0011J\u001d\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u0013J\u001d\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u000eJ\u001d\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0011J\u001d\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0013J\u001d\u0010 \u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u000eJ\u001d\u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0011J\u001d\u0010\"\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0013J\u001d\u0010#\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u000eJ\u001d\u0010$\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0011J\u001d\u0010%\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0013J\u001b\u0010'\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001d\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010+R%\u00100\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b-\u0010\u000eR%\u00100\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b1\u0010\u0011R%\u00100\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b5\u00106\u001a\u0004\b4\u0010\u0013R%\u00109\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b8\u0010/\u001a\u0004\b7\u0010\u000eR%\u00109\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b;\u00103\u001a\u0004\b:\u0010\u0011R%\u00109\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b=\u00106\u001a\u0004\b<\u0010\u0013R%\u0010@\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b?\u0010/\u001a\u0004\b>\u0010\u000eR%\u0010@\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bB\u00103\u001a\u0004\bA\u0010\u0011R%\u0010@\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bD\u00106\u001a\u0004\bC\u0010\u0013R%\u0010G\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bF\u0010/\u001a\u0004\bE\u0010\u000eR%\u0010G\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bI\u00103\u001a\u0004\bH\u0010\u0011R%\u0010G\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bK\u00106\u001a\u0004\bJ\u0010\u0013R%\u0010N\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bM\u0010/\u001a\u0004\bL\u0010\u000eR%\u0010N\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bP\u00103\u001a\u0004\bO\u0010\u0011R%\u0010N\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bR\u00106\u001a\u0004\bQ\u0010\u0013R%\u0010U\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bT\u0010/\u001a\u0004\bS\u0010\u000eR%\u0010U\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bW\u00103\u001a\u0004\bV\u0010\u0011R%\u0010U\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\bY\u00106\u001a\u0004\bX\u0010\u0013R%\u0010\\\u001a\u00020\f*\u00020\u000b8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b[\u0010/\u001a\u0004\bZ\u0010\u000eR%\u0010\\\u001a\u00020\f*\u00020\u000f8Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b^\u00103\u001a\u0004\b]\u0010\u0011R%\u0010\\\u001a\u00020\f*\u00020\u00048Æ\u0002X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\u0012\u0004\b`\u00106\u001a\u0004\b_\u0010\u0013R\u001d\u0010a\u001a\u00020\f8\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001d\u0010e\u001a\u00020\f8\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\be\u0010b\u001a\u0004\bf\u0010dR \u0010g\u001a\u00020\f8\u0000X\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\bg\u0010b\u001a\u0004\bb\u0010d\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "", "value", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "a", "(DLkotlin/time/DurationUnit;Lkotlin/time/DurationUnit;)D", "", "Lkotlin/time/Duration;", "k0", "(I)J", "", "l0", "(J)J", "j0", "(D)J", "b0", "c0", "a0", "e0", "f0", "d0", "r0", "s0", "q0", "h0", "i0", "g0", "Y", "Z", "X", "c", "d", "b", "", "m0", "(Ljava/lang/String;)J", "n0", "p0", "(Ljava/lang/String;)Lkotlin/time/Duration;", "o0", "L", "O", "(I)V", "nanoseconds", "M", "P", "(J)V", "K", "N", "(D)V", "s", "v", "microseconds", "t", "w", "r", "u", "y", "B", "milliseconds", "z", "C", "x", "A", "R", "U", "seconds", "S", "V", "Q", "T", "E", "H", "minutes", "F", "I", "D", "G", "l", "o", "hours", "m", "p", "k", "n", "f", "i", "days", "g", "j", "e", "h", "ZERO", "J", "W", "()J", "INFINITE", "q", "NEG_INFINITE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        @InlineOnly
        public static /* synthetic */ void A(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void B(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void C(long j2) {
        }

        private final long D(double d2) {
            return DurationKt.l0(d2, DurationUnit.MINUTES);
        }

        private final long E(int i2) {
            return DurationKt.m0(i2, DurationUnit.MINUTES);
        }

        private final long F(long j2) {
            return DurationKt.n0(j2, DurationUnit.MINUTES);
        }

        @InlineOnly
        public static /* synthetic */ void G(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void H(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void I(long j2) {
        }

        private final long K(double d2) {
            return DurationKt.l0(d2, DurationUnit.NANOSECONDS);
        }

        private final long L(int i2) {
            return DurationKt.m0(i2, DurationUnit.NANOSECONDS);
        }

        private final long M(long j2) {
            return DurationKt.n0(j2, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void N(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void O(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void P(long j2) {
        }

        private final long Q(double d2) {
            return DurationKt.l0(d2, DurationUnit.SECONDS);
        }

        private final long R(int i2) {
            return DurationKt.m0(i2, DurationUnit.SECONDS);
        }

        private final long S(long j2) {
            return DurationKt.n0(j2, DurationUnit.SECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void T(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void U(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void V(long j2) {
        }

        private final long e(double d2) {
            return DurationKt.l0(d2, DurationUnit.DAYS);
        }

        private final long f(int i2) {
            return DurationKt.m0(i2, DurationUnit.DAYS);
        }

        private final long g(long j2) {
            return DurationKt.n0(j2, DurationUnit.DAYS);
        }

        @InlineOnly
        public static /* synthetic */ void h(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void i(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void j(long j2) {
        }

        private final long k(double d2) {
            return DurationKt.l0(d2, DurationUnit.HOURS);
        }

        private final long l(int i2) {
            return DurationKt.m0(i2, DurationUnit.HOURS);
        }

        private final long m(long j2) {
            return DurationKt.n0(j2, DurationUnit.HOURS);
        }

        @InlineOnly
        public static /* synthetic */ void n(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void o(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void p(long j2) {
        }

        private final long r(double d2) {
            return DurationKt.l0(d2, DurationUnit.MICROSECONDS);
        }

        private final long s(int i2) {
            return DurationKt.m0(i2, DurationUnit.MICROSECONDS);
        }

        private final long t(long j2) {
            return DurationKt.n0(j2, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        public static /* synthetic */ void u(double d2) {
        }

        @InlineOnly
        public static /* synthetic */ void v(int i2) {
        }

        @InlineOnly
        public static /* synthetic */ void w(long j2) {
        }

        private final long x(double d2) {
            return DurationKt.l0(d2, DurationUnit.MILLISECONDS);
        }

        private final long y(int i2) {
            return DurationKt.m0(i2, DurationUnit.MILLISECONDS);
        }

        private final long z(long j2) {
            return DurationKt.n0(j2, DurationUnit.MILLISECONDS);
        }

        public final long J() {
            return Duration.X2;
        }

        public final long W() {
            return Duration.Y;
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @ExperimentalTime
        public final /* synthetic */ long X(double d2) {
            return DurationKt.l0(d2, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @ExperimentalTime
        public final /* synthetic */ long Y(int i2) {
            return DurationKt.m0(i2, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @ExperimentalTime
        public final /* synthetic */ long Z(long j2) {
            return DurationKt.n0(j2, DurationUnit.HOURS);
        }

        @ExperimentalTime
        public final double a(double d2, @NotNull DurationUnit durationUnit, @NotNull DurationUnit durationUnit2) {
            Intrinsics.p(durationUnit, "sourceUnit");
            Intrinsics.p(durationUnit2, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.a(d2, durationUnit, durationUnit2);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long a0(double d2) {
            return DurationKt.l0(d2, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @ExperimentalTime
        public final /* synthetic */ long b(double d2) {
            return DurationKt.l0(d2, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long b0(int i2) {
            return DurationKt.m0(i2, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @ExperimentalTime
        public final /* synthetic */ long c(int i2) {
            return DurationKt.m0(i2, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long c0(long j2) {
            return DurationKt.n0(j2, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @ExperimentalTime
        public final /* synthetic */ long d(long j2) {
            return DurationKt.n0(j2, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long d0(double d2) {
            return DurationKt.l0(d2, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long e0(int i2) {
            return DurationKt.m0(i2, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long f0(long j2) {
            return DurationKt.n0(j2, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @ExperimentalTime
        public final /* synthetic */ long g0(double d2) {
            return DurationKt.l0(d2, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @ExperimentalTime
        public final /* synthetic */ long h0(int i2) {
            return DurationKt.m0(i2, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @ExperimentalTime
        public final /* synthetic */ long i0(long j2) {
            return DurationKt.n0(j2, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long j0(double d2) {
            return DurationKt.l0(d2, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long k0(int i2) {
            return DurationKt.m0(i2, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @ExperimentalTime
        public final /* synthetic */ long l0(long j2) {
            return DurationKt.n0(j2, DurationUnit.NANOSECONDS);
        }

        public final long m0(@NotNull String str) {
            Intrinsics.p(str, "value");
            try {
                return DurationKt.f0(str, false);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Invalid duration string format: '" + str + "'.", e2);
            }
        }

        public final long n0(@NotNull String str) {
            Intrinsics.p(str, "value");
            try {
                return DurationKt.f0(str, true);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e2);
            }
        }

        @Nullable
        public final Duration o0(@NotNull String str) {
            Intrinsics.p(str, "value");
            try {
                return Duration.g(DurationKt.f0(str, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        public final Duration p0(@NotNull String str) {
            Intrinsics.p(str, "value");
            try {
                return Duration.g(DurationKt.f0(str, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long q() {
            return Duration.Z;
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @ExperimentalTime
        public final /* synthetic */ long q0(double d2) {
            return DurationKt.l0(d2, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @ExperimentalTime
        public final /* synthetic */ long r0(int i2) {
            return DurationKt.m0(i2, DurationUnit.SECONDS);
        }

        @SinceKotlin(version = "1.5")
        @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @ExperimentalTime
        public final /* synthetic */ long s0(long j2) {
            return DurationKt.n0(j2, DurationUnit.SECONDS);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ Duration(long j2) {
        this.s = j2;
    }

    public static final <T> T A0(long j2, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.p(function5, "action");
        return function5.h0(Long.valueOf(I(j2)), Integer.valueOf(r(j2)), Integer.valueOf(R(j2)), Integer.valueOf(W(j2)), Integer.valueOf(T(j2)));
    }

    public static final double B0(long j2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        if (j2 == Z) {
            return Double.POSITIVE_INFINITY;
        }
        if (j2 == X2) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.a((double) c0(j2), Z(j2), durationUnit);
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void C() {
    }

    public static final int C0(long j2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        return (int) RangesKt.K(G0(j2, durationUnit), -2147483648L, 2147483647L);
    }

    @NotNull
    public static final String D0(long j2) {
        StringBuilder sb = new StringBuilder();
        if (j0(j2)) {
            sb.append('-');
        }
        sb.append("PT");
        long p = p(j2);
        long J = J(p);
        int R = R(p);
        int W = W(p);
        int T = T(p);
        if (i0(j2)) {
            J = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = J != 0;
        boolean z3 = (W == 0 && T == 0) ? false : true;
        if (R != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(J);
            sb.append('H');
        }
        if (z) {
            sb.append(R);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            f(j2, sb, W, T, 9, ExifInterface.R4, true);
        }
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void E() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void G() {
    }

    public static final long G0(long j2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        if (j2 == Z) {
            return Long.MAX_VALUE;
        }
        if (j2 == X2) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(c0(j2), Z(j2), durationUnit);
    }

    public static final long I(long j2) {
        return G0(j2, DurationUnit.DAYS);
    }

    public static final long J(long j2) {
        return G0(j2, DurationUnit.HOURS);
    }

    public static final long K(long j2) {
        return G0(j2, DurationUnit.MICROSECONDS);
    }

    @NotNull
    public static String K0(long j2) {
        int i2;
        long j3;
        StringBuilder sb;
        int i3;
        int i4;
        String str;
        boolean z;
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == Z) {
            return "Infinity";
        }
        if (j2 == X2) {
            return "-Infinity";
        }
        boolean j0 = j0(j2);
        StringBuilder sb2 = new StringBuilder();
        if (j0) {
            sb2.append('-');
        }
        long p = p(j2);
        long I = I(p);
        int r = r(p);
        int R = R(p);
        int W = W(p);
        int T = T(p);
        int i5 = 0;
        boolean z2 = I != 0;
        boolean z3 = r != 0;
        boolean z4 = R != 0;
        boolean z5 = (W == 0 && T == 0) ? false : true;
        if (z2) {
            sb2.append(I);
            sb2.append(Barcode128.G);
            i5 = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i6 = i5 + 1;
            if (i5 > 0) {
                sb2.append(' ');
            }
            sb2.append(r);
            sb2.append(Barcode128.K);
            i5 = i6;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i7 = i5 + 1;
            if (i5 > 0) {
                sb2.append(' ');
            }
            sb2.append(R);
            sb2.append('m');
            i5 = i7;
        }
        if (z5) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb2.append(' ');
            }
            if (W != 0 || z2 || z3 || z4) {
                i2 = 9;
                j3 = j2;
                sb = sb2;
                i3 = W;
                i4 = T;
                str = "s";
                z = false;
            } else {
                if (T >= 1000000) {
                    i3 = T / 1000000;
                    i4 = T % 1000000;
                    str = "ms";
                    z = false;
                    i2 = 6;
                } else if (T >= 1000) {
                    i3 = T / 1000;
                    i4 = T % 1000;
                    str = "us";
                    z = false;
                    i2 = 3;
                } else {
                    sb2.append(T);
                    sb2.append("ns");
                    i5 = i8;
                }
                j3 = j2;
                sb = sb2;
            }
            f(j3, sb, i3, i4, i2, str, z);
            i5 = i8;
        }
        if (j0 && i5 > 1) {
            sb2.insert(1, ASCIIPropertyListParser.f18649g).append(ASCIIPropertyListParser.f18650h);
        }
        String sb3 = sb2.toString();
        Intrinsics.o(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static final long L(long j2) {
        return (!g0(j2) || !e0(j2)) ? G0(j2, DurationUnit.MILLISECONDS) : c0(j2);
    }

    @NotNull
    public static final String L0(long j2, @NotNull DurationUnit durationUnit, int i2) {
        Intrinsics.p(durationUnit, "unit");
        if (i2 >= 0) {
            double B0 = B0(j2, durationUnit);
            if (Double.isInfinite(B0)) {
                return String.valueOf(B0);
            }
            return DurationJvmKt.b(B0, RangesKt.B(i2, 12)) + DurationUnitKt__DurationUnitKt.h(durationUnit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i2).toString());
    }

    public static final long N(long j2) {
        return G0(j2, DurationUnit.MINUTES);
    }

    public static /* synthetic */ String N0(long j2, DurationUnit durationUnit, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return L0(j2, durationUnit, i2);
    }

    public static final long O(long j2) {
        long c0 = c0(j2);
        if (h0(j2)) {
            return c0;
        }
        if (c0 > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (c0 < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.d0(c0);
    }

    public static final long P(long j2) {
        return G0(j2, DurationUnit.SECONDS);
    }

    public static final long P0(long j2, @NotNull DurationUnit durationUnit) {
        Intrinsics.p(durationUnit, "unit");
        DurationUnit Z2 = Z(j2);
        if (durationUnit.compareTo(Z2) <= 0 || i0(j2)) {
            return j2;
        }
        return DurationKt.n0(c0(j2) - (c0(j2) % DurationUnitKt__DurationUnitJvmKt.b(1, durationUnit, Z2)), Z2);
    }

    @PublishedApi
    public static /* synthetic */ void Q() {
    }

    public static final long Q0(long j2) {
        return DurationKt.i(-c0(j2), ((int) j2) & 1);
    }

    public static final int R(long j2) {
        if (i0(j2)) {
            return 0;
        }
        return (int) (N(j2) % ((long) 60));
    }

    @PublishedApi
    public static /* synthetic */ void S() {
    }

    public static final int T(long j2) {
        if (i0(j2)) {
            return 0;
        }
        boolean g0 = g0(j2);
        long c0 = c0(j2);
        return (int) (g0 ? DurationKt.d0(c0 % ((long) 1000)) : c0 % ((long) Utils.f17347a));
    }

    @PublishedApi
    public static /* synthetic */ void U() {
    }

    public static final int W(long j2) {
        if (i0(j2)) {
            return 0;
        }
        return (int) (P(j2) % ((long) 60));
    }

    private static final DurationUnit Z(long j2) {
        return h0(j2) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    private static final int a0(long j2) {
        return ((int) j2) & 1;
    }

    private static final long c0(long j2) {
        return j2 >> 1;
    }

    public static int d0(long j2) {
        return j.a(j2);
    }

    private static final long e(long j2, long j3, long j4) {
        long g2 = DurationKt.e0(j4);
        long j5 = j3 + g2;
        if (!new LongRange(-4611686018426L, 4611686018426L).q(j5)) {
            return DurationKt.j(RangesKt.K(j5, -4611686018427387903L, DurationKt.f29135c));
        }
        return DurationKt.l(DurationKt.d0(j5) + (j4 - DurationKt.d0(g2)));
    }

    public static final boolean e0(long j2) {
        return !i0(j2);
    }

    private static final void f(long j2, StringBuilder sb, int i2, int i3, int i4, String str, boolean z) {
        sb.append(i2);
        if (i3 != 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String R3 = StringsKt.R3(String.valueOf(i3), i4, '0');
            int i5 = -1;
            int length = R3.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i6 = length - 1;
                    if (R3.charAt(length) != '0') {
                        i5 = length;
                        break;
                    } else if (i6 < 0) {
                        break;
                    } else {
                        length = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            if (z || i7 >= 3) {
                sb.append(R3, 0, ((i5 + 3) / 3) * 3);
            } else {
                sb.append(R3, 0, i7);
            }
            Intrinsics.o(sb, "this.append(value, startIndex, endIndex)");
        }
        sb.append(str);
    }

    public static final /* synthetic */ Duration g(long j2) {
        return new Duration(j2);
    }

    private static final boolean g0(long j2) {
        return (((int) j2) & 1) == 1;
    }

    private static final boolean h0(long j2) {
        return (((int) j2) & 1) == 0;
    }

    public static int i(long j2, long j3) {
        long j4 = j2 ^ j3;
        if (j4 < 0 || (((int) j4) & 1) == 0) {
            return Intrinsics.u(j2, j3);
        }
        int i2 = (((int) j2) & 1) - (((int) j3) & 1);
        return j0(j2) ? -i2 : i2;
    }

    public static final boolean i0(long j2) {
        return j2 == Z || j2 == X2;
    }

    public static long j(long j2) {
        if (DurationJvmKt.d()) {
            if (h0(j2)) {
                if (!new LongRange(-4611686018426999999L, DurationKt.f29134b).q(c0(j2))) {
                    throw new AssertionError(c0(j2) + " ns is out of nanoseconds range");
                }
            } else if (!new LongRange(-4611686018427387903L, DurationKt.f29135c).q(c0(j2))) {
                throw new AssertionError(c0(j2) + " ms is out of milliseconds range");
            } else if (new LongRange(-4611686018426L, 4611686018426L).q(c0(j2))) {
                throw new AssertionError(c0(j2) + " ms is denormalized");
            }
        }
        return j2;
    }

    public static final boolean j0(long j2) {
        return j2 < 0;
    }

    public static final double k(long j2, long j3) {
        DurationUnit durationUnit = (DurationUnit) ComparisonsKt.X(Z(j2), Z(j3));
        return B0(j2, durationUnit) / B0(j3, durationUnit);
    }

    public static final boolean k0(long j2) {
        return j2 > 0;
    }

    public static final long l(long j2, double d2) {
        int K0 = MathKt.K0(d2);
        if (((double) K0) == d2 && K0 != 0) {
            return m(j2, K0);
        }
        DurationUnit Z2 = Z(j2);
        return DurationKt.l0(B0(j2, Z2) / d2, Z2);
    }

    public static final long m(long j2, int i2) {
        if (i2 == 0) {
            if (k0(j2)) {
                return Z;
            }
            if (j0(j2)) {
                return X2;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (h0(j2)) {
            return DurationKt.l(c0(j2) / ((long) i2));
        } else {
            if (i0(j2)) {
                return r0(j2, MathKt.U(i2));
            }
            long j3 = (long) i2;
            long c0 = c0(j2) / j3;
            if (!new LongRange(-4611686018426L, 4611686018426L).q(c0)) {
                return DurationKt.j(c0);
            }
            return DurationKt.l(DurationKt.d0(c0) + (DurationKt.d0(c0(j2) - (c0 * j3)) / j3));
        }
    }

    public static final long m0(long j2, long j3) {
        return p0(j2, Q0(j3));
    }

    public static boolean n(long j2, Object obj) {
        return (obj instanceof Duration) && j2 == ((Duration) obj).R0();
    }

    public static final boolean o(long j2, long j3) {
        return j2 == j3;
    }

    public static final long p(long j2) {
        return j0(j2) ? Q0(j2) : j2;
    }

    public static final long p0(long j2, long j3) {
        if (i0(j2)) {
            if (e0(j3) || (j3 ^ j2) >= 0) {
                return j2;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (i0(j3)) {
            return j3;
        } else {
            if ((((int) j2) & 1) == (((int) j3) & 1)) {
                long c0 = c0(j2) + c0(j3);
                return h0(j2) ? DurationKt.m(c0) : DurationKt.k(c0);
            } else if (g0(j2)) {
                return e(j2, c0(j2), c0(j3));
            } else {
                return e(j2, c0(j3), c0(j2));
            }
        }
    }

    @PublishedApi
    public static /* synthetic */ void q() {
    }

    public static final long q0(long j2, double d2) {
        int K0 = MathKt.K0(d2);
        if (((double) K0) == d2) {
            return r0(j2, K0);
        }
        DurationUnit Z2 = Z(j2);
        return DurationKt.l0(B0(j2, Z2) * d2, Z2);
    }

    public static final int r(long j2) {
        if (i0(j2)) {
            return 0;
        }
        return (int) (J(j2) % ((long) 24));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        if ((kotlin.math.MathKt.V(r1) * kotlin.math.MathKt.U(r18)) > 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        if ((kotlin.math.MathKt.V(r1) * kotlin.math.MathKt.U(r18)) > 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return Z;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return X2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long r0(long r16, int r18) {
        /*
            r0 = r18
            boolean r1 = i0(r16)
            if (r1 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0014
            if (r0 <= 0) goto L_0x000f
            r0 = r16
            goto L_0x0013
        L_0x000f:
            long r0 = Q0(r16)
        L_0x0013:
            return r0
        L_0x0014:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Multiplying infinite duration by zero yields an undefined result."
            r0.<init>(r1)
            throw r0
        L_0x001c:
            if (r0 != 0) goto L_0x0021
            long r0 = Y
            return r0
        L_0x0021:
            long r1 = c0(r16)
            long r3 = (long) r0
            long r5 = r1 * r3
            boolean r7 = h0(r16)
            r8 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            r10 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            if (r7 == 0) goto L_0x009a
            kotlin.ranges.LongRange r7 = new kotlin.ranges.LongRange
            r12 = -2147483647(0xffffffff80000001, double:NaN)
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r7.<init>(r12, r14)
            boolean r7 = r7.q(r1)
            if (r7 == 0) goto L_0x004e
            long r0 = kotlin.time.DurationKt.l(r5)
            goto L_0x00b7
        L_0x004e:
            long r12 = r5 / r3
            int r7 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0059
            long r0 = kotlin.time.DurationKt.m(r5)
            goto L_0x00b7
        L_0x0059:
            long r5 = kotlin.time.DurationKt.e0(r1)
            long r12 = kotlin.time.DurationKt.d0(r5)
            long r12 = r1 - r12
            long r14 = r5 * r3
            long r12 = r12 * r3
            long r12 = kotlin.time.DurationKt.e0(r12)
            long r12 = r12 + r14
            long r3 = r14 / r3
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0088
            long r3 = r12 ^ r14
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0088
            kotlin.ranges.LongRange r0 = new kotlin.ranges.LongRange
            r0.<init>(r10, r8)
            long r0 = kotlin.ranges.RangesKt.L(r12, r0)
        L_0x0083:
            long r0 = kotlin.time.DurationKt.j(r0)
            goto L_0x00b7
        L_0x0088:
            int r1 = kotlin.math.MathKt.V(r1)
            int r0 = kotlin.math.MathKt.U(r18)
            int r1 = r1 * r0
            if (r1 <= 0) goto L_0x0097
        L_0x0094:
            long r0 = Z
            goto L_0x00b7
        L_0x0097:
            long r0 = X2
            goto L_0x00b7
        L_0x009a:
            long r3 = r5 / r3
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x00aa
            kotlin.ranges.LongRange r0 = new kotlin.ranges.LongRange
            r0.<init>(r10, r8)
            long r0 = kotlin.ranges.RangesKt.L(r5, r0)
            goto L_0x0083
        L_0x00aa:
            int r1 = kotlin.math.MathKt.V(r1)
            int r0 = kotlin.math.MathKt.U(r18)
            int r1 = r1 * r0
            if (r1 <= 0) goto L_0x0097
            goto L_0x0094
        L_0x00b7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.Duration.r0(long, int):long");
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void s() {
    }

    public static final <T> T s0(long j2, @NotNull Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.p(function2, "action");
        return function2.d0(Long.valueOf(P(j2)), Integer.valueOf(T(j2)));
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void v() {
    }

    public static final <T> T v0(long j2, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.p(function3, "action");
        return function3.A(Long.valueOf(N(j2)), Integer.valueOf(W(j2)), Integer.valueOf(T(j2)));
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void x() {
    }

    public static final <T> T x0(long j2, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.p(function4, "action");
        return function4.O(Long.valueOf(J(j2)), Integer.valueOf(R(j2)), Integer.valueOf(W(j2)), Integer.valueOf(T(j2)));
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @ExperimentalTime
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void z() {
    }

    public final /* synthetic */ long R0() {
        return this.s;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return h(((Duration) obj).R0());
    }

    public boolean equals(Object obj) {
        return n(this.s, obj);
    }

    public int h(long j2) {
        return i(this.s, j2);
    }

    public int hashCode() {
        return d0(this.s);
    }

    @NotNull
    public String toString() {
        return K0(this.s);
    }
}
