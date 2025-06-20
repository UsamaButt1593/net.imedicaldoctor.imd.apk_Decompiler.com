package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0003\bª\u0001\n\u0002\u0010\u000f\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t*\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0003\u001a\u0013\u0010\u0013\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0007\u001a\u0013\u0010\u0014\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\u000b\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0015\u0010\r\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u000f\u001a\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t*\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0011\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u0018H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001c\u001a\u00020\u0005*\u00020\u001bH\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0014\u0010\u001f\u001a\u00020\t*\u00020\u001eH\b¢\u0006\u0004\b\u001f\u0010 \u001a\u001b\u0010#\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$\u001a\u001b\u0010%\u001a\u00020\u0005*\u00020\u001b2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b%\u0010&\u001a\u001b\u0010'\u001a\u00020\t*\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0016\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u0018H\b¢\u0006\u0004\b)\u0010*\u001a\u0016\u0010+\u001a\u0004\u0018\u00010\u0005*\u00020\u001bH\b¢\u0006\u0004\b+\u0010,\u001a\u0016\u0010-\u001a\u0004\u0018\u00010\t*\u00020\u001eH\b¢\u0006\u0004\b-\u0010.\u001a\u001d\u0010/\u001a\u0004\u0018\u00010\u0001*\u00020\u00182\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b/\u00100\u001a\u001d\u00101\u001a\u0004\u0018\u00010\u0005*\u00020\u001b2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b1\u00102\u001a\u001d\u00103\u001a\u0004\u0018\u00010\t*\u00020\u001e2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b3\u00104\u001a\u001e\u00107\u001a\u000206*\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b7\u00108\u001a\u001e\u00109\u001a\u000206*\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b9\u0010:\u001a\u001e\u0010;\u001a\u000206*\u00020\u001e2\b\u00105\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0004\b;\u0010<\u001a\"\u0010@\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010=2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010A\u001a\"\u0010B\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bB\u0010A\u001a\"\u0010D\u001a\u000206*\b\u0012\u0004\u0012\u00020C0=2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bD\u0010A\u001a\"\u0010F\u001a\u000206*\b\u0012\u0004\u0012\u00020E0=2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bF\u0010A\u001a\"\u0010H\u001a\u000206*\b\u0012\u0004\u0012\u00020G0=2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bH\u0010A\u001a\"\u0010J\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010I2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bJ\u0010K\u001a\"\u0010L\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050I2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bL\u0010K\u001a\"\u0010M\u001a\u000206*\b\u0012\u0004\u0012\u00020C0I2\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\bM\u0010K\u001a\u001c\u0010N\u001a\u000206*\u00020\u00182\u0006\u0010?\u001a\u00020>H\n¢\u0006\u0004\bN\u0010O\u001a\u001c\u0010P\u001a\u000206*\u00020\u001b2\u0006\u0010?\u001a\u00020>H\n¢\u0006\u0004\bP\u0010Q\u001a\"\u0010R\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010=2\u0006\u0010?\u001a\u00020EH\u0002¢\u0006\u0004\bR\u0010S\u001a\"\u0010T\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010?\u001a\u00020EH\u0002¢\u0006\u0004\bT\u0010S\u001a\"\u0010U\u001a\u000206*\b\u0012\u0004\u0012\u00020>0=2\u0006\u0010?\u001a\u00020EH\u0002¢\u0006\u0004\bU\u0010S\u001a\"\u0010V\u001a\u000206*\b\u0012\u0004\u0012\u00020C0=2\u0006\u0010?\u001a\u00020EH\u0002¢\u0006\u0004\bV\u0010S\u001a\"\u0010W\u001a\u000206*\b\u0012\u0004\u0012\u00020G0=2\u0006\u0010?\u001a\u00020EH\u0002¢\u0006\u0004\bW\u0010S\u001a\"\u0010X\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010=2\u0006\u0010?\u001a\u00020GH\u0002¢\u0006\u0004\bX\u0010Y\u001a\"\u0010Z\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010?\u001a\u00020GH\u0002¢\u0006\u0004\bZ\u0010Y\u001a\"\u0010[\u001a\u000206*\b\u0012\u0004\u0012\u00020>0=2\u0006\u0010?\u001a\u00020GH\u0002¢\u0006\u0004\b[\u0010Y\u001a\"\u0010\\\u001a\u000206*\b\u0012\u0004\u0012\u00020C0=2\u0006\u0010?\u001a\u00020GH\u0002¢\u0006\u0004\b\\\u0010Y\u001a\"\u0010]\u001a\u000206*\b\u0012\u0004\u0012\u00020E0=2\u0006\u0010?\u001a\u00020GH\u0002¢\u0006\u0004\b]\u0010Y\u001a\"\u0010^\u001a\u000206*\b\u0012\u0004\u0012\u00020E0I2\u0006\u0010?\u001a\u00020GH\u0002¢\u0006\u0004\b^\u0010_\u001a\"\u0010`\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\b`\u0010a\u001a\"\u0010b\u001a\u000206*\b\u0012\u0004\u0012\u00020>0=2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bb\u0010a\u001a\"\u0010c\u001a\u000206*\b\u0012\u0004\u0012\u00020C0=2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bc\u0010a\u001a\"\u0010d\u001a\u000206*\b\u0012\u0004\u0012\u00020E0=2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bd\u0010a\u001a\"\u0010e\u001a\u000206*\b\u0012\u0004\u0012\u00020G0=2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\be\u0010a\u001a\"\u0010f\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050I2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bf\u0010g\u001a\"\u0010h\u001a\u000206*\b\u0012\u0004\u0012\u00020>0I2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bh\u0010g\u001a\"\u0010i\u001a\u000206*\b\u0012\u0004\u0012\u00020C0I2\u0006\u0010?\u001a\u00020\u0001H\u0002¢\u0006\u0004\bi\u0010g\u001a\u001c\u0010j\u001a\u000206*\u00020\u001b2\u0006\u0010?\u001a\u00020\u0001H\n¢\u0006\u0004\bj\u0010k\u001a\"\u0010l\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010=2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bl\u0010m\u001a\"\u0010n\u001a\u000206*\b\u0012\u0004\u0012\u00020>0=2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bn\u0010m\u001a\"\u0010o\u001a\u000206*\b\u0012\u0004\u0012\u00020C0=2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bo\u0010m\u001a\"\u0010p\u001a\u000206*\b\u0012\u0004\u0012\u00020E0=2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bp\u0010m\u001a\"\u0010q\u001a\u000206*\b\u0012\u0004\u0012\u00020G0=2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bq\u0010m\u001a\"\u0010r\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010I2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\br\u0010s\u001a\"\u0010t\u001a\u000206*\b\u0012\u0004\u0012\u00020>0I2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bt\u0010s\u001a\"\u0010u\u001a\u000206*\b\u0012\u0004\u0012\u00020C0I2\u0006\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\bu\u0010s\u001a\u001c\u0010v\u001a\u000206*\u00020\u00182\u0006\u0010?\u001a\u00020\u0005H\n¢\u0006\u0004\bv\u0010w\u001a\"\u0010x\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010=2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0004\bx\u0010y\u001a\"\u0010z\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0004\bz\u0010y\u001a\"\u0010{\u001a\u000206*\b\u0012\u0004\u0012\u00020>0=2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0004\b{\u0010y\u001a\"\u0010|\u001a\u000206*\b\u0012\u0004\u0012\u00020E0=2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0004\b|\u0010y\u001a\"\u0010}\u001a\u000206*\b\u0012\u0004\u0012\u00020G0=2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0004\b}\u0010y\u001a\"\u0010~\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00010I2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0004\b~\u0010\u001a$\u0010\u0001\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00050I2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0005\b\u0001\u0010\u001a$\u0010\u0001\u001a\u000206*\b\u0012\u0004\u0012\u00020>0I2\u0006\u0010?\u001a\u00020CH\u0002¢\u0006\u0005\b\u0001\u0010\u001a\u001f\u0010\u0001\u001a\u000206*\u00020\u00182\u0006\u0010?\u001a\u00020CH\n¢\u0006\u0006\b\u0001\u0010\u0001\u001a\u001f\u0010\u0001\u001a\u000206*\u00020\u001b2\u0006\u0010?\u001a\u00020CH\n¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0000*\u00020\u00012\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0004*\u00020\u00052\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0000*\u00020>2\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0000*\u00020C2\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\b*\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0000*\u00020\u00012\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0004*\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0000*\u00020>2\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0000*\u00020C2\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0004*\u00020\u00012\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0004*\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0004*\u00020>2\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\b\u0001\u0010\u0001\u001a \u0010\u0001\u001a\u00020\u0004*\u00020C2\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\b\u0001\u0010 \u0001\u001a \u0010¡\u0001\u001a\u00020\u0000*\u00020\u00012\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\b¡\u0001\u0010¢\u0001\u001a \u0010£\u0001\u001a\u00020\u0004*\u00020\u00052\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\b£\u0001\u0010¤\u0001\u001a \u0010¥\u0001\u001a\u00020\u0000*\u00020>2\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\b¥\u0001\u0010¦\u0001\u001a \u0010§\u0001\u001a\u00020\u0000*\u00020C2\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\b§\u0001\u0010¨\u0001\u001a\u0014\u0010©\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0006\b©\u0001\u0010ª\u0001\u001a\u0014\u0010«\u0001\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0006\b«\u0001\u0010¬\u0001\u001a\u0014\u0010­\u0001\u001a\u00020\b*\u00020\b¢\u0006\u0006\b­\u0001\u0010®\u0001\u001a \u0010°\u0001\u001a\u00020\u0000*\u00020\u00002\u0007\u0010¯\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\b°\u0001\u0010±\u0001\u001a \u0010²\u0001\u001a\u00020\u0004*\u00020\u00042\u0007\u0010¯\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\b²\u0001\u0010³\u0001\u001a \u0010´\u0001\u001a\u00020\b*\u00020\b2\u0007\u0010¯\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\b´\u0001\u0010µ\u0001\u001a\u0018\u0010¶\u0001\u001a\u0004\u0018\u00010>*\u00020\u0001H\u0000¢\u0006\u0006\b¶\u0001\u0010·\u0001\u001a\u0018\u0010¸\u0001\u001a\u0004\u0018\u00010>*\u00020\u0005H\u0000¢\u0006\u0006\b¸\u0001\u0010¹\u0001\u001a\u0018\u0010º\u0001\u001a\u0004\u0018\u00010>*\u00020CH\u0000¢\u0006\u0006\bº\u0001\u0010»\u0001\u001a\u0018\u0010¼\u0001\u001a\u0004\u0018\u00010>*\u00020EH\u0000¢\u0006\u0006\b¼\u0001\u0010½\u0001\u001a\u0018\u0010¾\u0001\u001a\u0004\u0018\u00010>*\u00020GH\u0000¢\u0006\u0006\b¾\u0001\u0010¿\u0001\u001a\u0018\u0010À\u0001\u001a\u0004\u0018\u00010\u0001*\u00020\u0005H\u0000¢\u0006\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0018\u0010Â\u0001\u001a\u0004\u0018\u00010\u0001*\u00020EH\u0000¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0018\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0001*\u00020GH\u0000¢\u0006\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0018\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0005*\u00020EH\u0000¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0018\u0010È\u0001\u001a\u0004\u0018\u00010\u0005*\u00020GH\u0000¢\u0006\u0006\bÈ\u0001\u0010É\u0001\u001a\u0018\u0010Ê\u0001\u001a\u0004\u0018\u00010C*\u00020\u0001H\u0000¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0018\u0010Ì\u0001\u001a\u0004\u0018\u00010C*\u00020\u0005H\u0000¢\u0006\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0018\u0010Î\u0001\u001a\u0004\u0018\u00010C*\u00020EH\u0000¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001\u001a\u0018\u0010Ð\u0001\u001a\u0004\u0018\u00010C*\u00020GH\u0000¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001\u001a \u0010Ò\u0001\u001a\u00020\u0018*\u00020\u00012\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001\u001a \u0010Ô\u0001\u001a\u00020\u001b*\u00020\u00052\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001\u001a \u0010Ö\u0001\u001a\u00020\u0018*\u00020>2\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\bÖ\u0001\u0010×\u0001\u001a \u0010Ø\u0001\u001a\u00020\u0018*\u00020C2\u0007\u0010\u0001\u001a\u00020>H\u0004¢\u0006\u0006\bØ\u0001\u0010Ù\u0001\u001a \u0010Ú\u0001\u001a\u00020\u001e*\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0004¢\u0006\u0006\bÚ\u0001\u0010Û\u0001\u001a \u0010Ü\u0001\u001a\u00020\u0018*\u00020\u00012\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001\u001a \u0010Þ\u0001\u001a\u00020\u001b*\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\bÞ\u0001\u0010ß\u0001\u001a \u0010à\u0001\u001a\u00020\u0018*\u00020>2\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\bà\u0001\u0010á\u0001\u001a \u0010â\u0001\u001a\u00020\u0018*\u00020C2\u0007\u0010\u0001\u001a\u00020\u0001H\u0004¢\u0006\u0006\bâ\u0001\u0010ã\u0001\u001a \u0010ä\u0001\u001a\u00020\u001b*\u00020\u00012\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\bä\u0001\u0010å\u0001\u001a \u0010æ\u0001\u001a\u00020\u001b*\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\bæ\u0001\u0010ç\u0001\u001a \u0010è\u0001\u001a\u00020\u001b*\u00020>2\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\bè\u0001\u0010é\u0001\u001a \u0010ê\u0001\u001a\u00020\u001b*\u00020C2\u0007\u0010\u0001\u001a\u00020\u0005H\u0004¢\u0006\u0006\bê\u0001\u0010ë\u0001\u001a \u0010ì\u0001\u001a\u00020\u0018*\u00020\u00012\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\bì\u0001\u0010í\u0001\u001a \u0010î\u0001\u001a\u00020\u001b*\u00020\u00052\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\bî\u0001\u0010ï\u0001\u001a \u0010ð\u0001\u001a\u00020\u0018*\u00020>2\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\bð\u0001\u0010ñ\u0001\u001a \u0010ò\u0001\u001a\u00020\u0018*\u00020C2\u0007\u0010\u0001\u001a\u00020CH\u0004¢\u0006\u0006\bò\u0001\u0010ó\u0001\u001a.\u0010ö\u0001\u001a\u00028\u0000\"\u000f\b\u0000\u00107*\t\u0012\u0004\u0012\u00028\u00000ô\u0001*\u00028\u00002\u0007\u0010õ\u0001\u001a\u00028\u0000¢\u0006\u0006\bö\u0001\u0010÷\u0001\u001a\u001d\u0010ø\u0001\u001a\u00020>*\u00020>2\u0007\u0010õ\u0001\u001a\u00020>¢\u0006\u0006\bø\u0001\u0010ù\u0001\u001a\u001d\u0010ú\u0001\u001a\u00020C*\u00020C2\u0007\u0010õ\u0001\u001a\u00020C¢\u0006\u0006\bú\u0001\u0010û\u0001\u001a\u001d\u0010ü\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010õ\u0001\u001a\u00020\u0001¢\u0006\u0006\bü\u0001\u0010ý\u0001\u001a\u001d\u0010þ\u0001\u001a\u00020\u0005*\u00020\u00052\u0007\u0010õ\u0001\u001a\u00020\u0005¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u001d\u0010\u0002\u001a\u00020G*\u00020G2\u0007\u0010õ\u0001\u001a\u00020G¢\u0006\u0006\b\u0002\u0010\u0002\u001a\u001d\u0010\u0002\u001a\u00020E*\u00020E2\u0007\u0010õ\u0001\u001a\u00020E¢\u0006\u0006\b\u0002\u0010\u0002\u001a.\u0010\u0002\u001a\u00028\u0000\"\u000f\b\u0000\u00107*\t\u0012\u0004\u0012\u00028\u00000ô\u0001*\u00028\u00002\u0007\u0010\u0002\u001a\u00028\u0000¢\u0006\u0006\b\u0002\u0010÷\u0001\u001a\u001d\u0010\u0002\u001a\u00020>*\u00020>2\u0007\u0010\u0002\u001a\u00020>¢\u0006\u0006\b\u0002\u0010ù\u0001\u001a\u001d\u0010\u0002\u001a\u00020C*\u00020C2\u0007\u0010\u0002\u001a\u00020C¢\u0006\u0006\b\u0002\u0010û\u0001\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0002\u001a\u00020\u0001¢\u0006\u0006\b\u0002\u0010ý\u0001\u001a\u001d\u0010\u0002\u001a\u00020\u0005*\u00020\u00052\u0007\u0010\u0002\u001a\u00020\u0005¢\u0006\u0006\b\u0002\u0010ÿ\u0001\u001a\u001d\u0010\u0002\u001a\u00020G*\u00020G2\u0007\u0010\u0002\u001a\u00020G¢\u0006\u0006\b\u0002\u0010\u0002\u001a\u001d\u0010\u0002\u001a\u00020E*\u00020E2\u0007\u0010\u0002\u001a\u00020E¢\u0006\u0006\b\u0002\u0010\u0002\u001a;\u0010\u0002\u001a\u00028\u0000\"\u000f\b\u0000\u00107*\t\u0012\u0004\u0012\u00028\u00000ô\u0001*\u00028\u00002\t\u0010õ\u0001\u001a\u0004\u0018\u00018\u00002\t\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0006\b\u0002\u0010\u0002\u001a&\u0010\u0002\u001a\u00020>*\u00020>2\u0007\u0010õ\u0001\u001a\u00020>2\u0007\u0010\u0002\u001a\u00020>¢\u0006\u0006\b\u0002\u0010\u0002\u001a&\u0010\u0002\u001a\u00020C*\u00020C2\u0007\u0010õ\u0001\u001a\u00020C2\u0007\u0010\u0002\u001a\u00020C¢\u0006\u0006\b\u0002\u0010\u0002\u001a&\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0007\u0010õ\u0001\u001a\u00020\u00012\u0007\u0010\u0002\u001a\u00020\u0001¢\u0006\u0006\b\u0002\u0010\u0002\u001a&\u0010\u0002\u001a\u00020\u0005*\u00020\u00052\u0007\u0010õ\u0001\u001a\u00020\u00052\u0007\u0010\u0002\u001a\u00020\u0005¢\u0006\u0006\b\u0002\u0010\u0002\u001a&\u0010\u0002\u001a\u00020G*\u00020G2\u0007\u0010õ\u0001\u001a\u00020G2\u0007\u0010\u0002\u001a\u00020G¢\u0006\u0006\b\u0002\u0010\u0002\u001a&\u0010\u0002\u001a\u00020E*\u00020E2\u0007\u0010õ\u0001\u001a\u00020E2\u0007\u0010\u0002\u001a\u00020E¢\u0006\u0006\b\u0002\u0010\u0002\u001a7\u0010\u0002\u001a\u00028\u0000\"\u000f\b\u0000\u00107*\t\u0012\u0004\u0012\u00028\u00000ô\u0001*\u00028\u00002\u000e\u0010\u0002\u001a\t\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0006\b\u0002\u0010\u0002\u001a4\u0010\u0002\u001a\u00028\u0000\"\u000f\b\u0000\u00107*\t\u0012\u0004\u0012\u00028\u00000ô\u0001*\u00028\u00002\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000=¢\u0006\u0006\b\u0002\u0010\u0002\u001a#\u0010 \u0002\u001a\u00020\u0001*\u00020\u00012\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010=¢\u0006\u0006\b \u0002\u0010¡\u0002\u001a#\u0010¢\u0002\u001a\u00020\u0005*\u00020\u00052\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050=¢\u0006\u0006\b¢\u0002\u0010£\u0002¨\u0006¤\u0002"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "x0", "(Lkotlin/ranges/IntProgression;)I", "Lkotlin/ranges/LongProgression;", "", "y0", "(Lkotlin/ranges/LongProgression;)J", "Lkotlin/ranges/CharProgression;", "", "w0", "(Lkotlin/ranges/CharProgression;)C", "A0", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "B0", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "z0", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "Q0", "R0", "P0", "T0", "U0", "S0", "Lkotlin/ranges/IntRange;", "f1", "(Lkotlin/ranges/IntRange;)I", "Lkotlin/ranges/LongRange;", "h1", "(Lkotlin/ranges/LongRange;)J", "Lkotlin/ranges/CharRange;", "d1", "(Lkotlin/ranges/CharRange;)C", "Lkotlin/random/Random;", "random", "g1", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)I", "i1", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)J", "e1", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)C", "l1", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "n1", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "j1", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "m1", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "o1", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "k1", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "element", "", "T", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "X", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Q", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "Lkotlin/ranges/ClosedRange;", "", "value", "H0", "(Lkotlin/ranges/ClosedRange;B)Z", "V0", "", "s1", "", "Z", "", "C0", "Lkotlin/ranges/OpenEndRange;", "M0", "(Lkotlin/ranges/OpenEndRange;B)Z", "a1", "x1", "R", "(Lkotlin/ranges/IntRange;B)Z", "V", "(Lkotlin/ranges/LongRange;B)Z", "I0", "(Lkotlin/ranges/ClosedRange;D)Z", "W0", "j", "t1", "D0", "J0", "(Lkotlin/ranges/ClosedRange;F)Z", "X0", "k", "u1", "a0", "e0", "(Lkotlin/ranges/OpenEndRange;F)Z", "Y0", "(Lkotlin/ranges/ClosedRange;I)Z", "l", "v1", "b0", "E0", "b1", "(Lkotlin/ranges/OpenEndRange;I)Z", "o", "y1", "W", "(Lkotlin/ranges/LongRange;I)Z", "K0", "(Lkotlin/ranges/ClosedRange;J)Z", "m", "w1", "c0", "F0", "N0", "(Lkotlin/ranges/OpenEndRange;J)Z", "p", "z1", "S", "(Lkotlin/ranges/IntRange;J)Z", "L0", "(Lkotlin/ranges/ClosedRange;S)Z", "Z0", "n", "d0", "G0", "O0", "(Lkotlin/ranges/OpenEndRange;S)Z", "c1", "q", "U", "(Lkotlin/ranges/IntRange;S)Z", "Y", "(Lkotlin/ranges/LongRange;S)Z", "to", "j0", "(IB)Lkotlin/ranges/IntProgression;", "r0", "(JB)Lkotlin/ranges/LongProgression;", "g0", "(BB)Lkotlin/ranges/IntProgression;", "m0", "(SB)Lkotlin/ranges/IntProgression;", "f0", "(CC)Lkotlin/ranges/CharProgression;", "k0", "(II)Lkotlin/ranges/IntProgression;", "s0", "(JI)Lkotlin/ranges/LongProgression;", "h0", "(BI)Lkotlin/ranges/IntProgression;", "n0", "(SI)Lkotlin/ranges/IntProgression;", "q0", "(IJ)Lkotlin/ranges/LongProgression;", "t0", "(JJ)Lkotlin/ranges/LongProgression;", "p0", "(BJ)Lkotlin/ranges/LongProgression;", "v0", "(SJ)Lkotlin/ranges/LongProgression;", "l0", "(IS)Lkotlin/ranges/IntProgression;", "u0", "(JS)Lkotlin/ranges/LongProgression;", "i0", "(BS)Lkotlin/ranges/IntProgression;", "o0", "(SS)Lkotlin/ranges/IntProgression;", "q1", "(Lkotlin/ranges/IntProgression;)Lkotlin/ranges/IntProgression;", "r1", "(Lkotlin/ranges/LongProgression;)Lkotlin/ranges/LongProgression;", "p1", "(Lkotlin/ranges/CharProgression;)Lkotlin/ranges/CharProgression;", "step", "B1", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "C1", "(Lkotlin/ranges/LongProgression;J)Lkotlin/ranges/LongProgression;", "A1", "(Lkotlin/ranges/CharProgression;I)Lkotlin/ranges/CharProgression;", "F1", "(I)Ljava/lang/Byte;", "G1", "(J)Ljava/lang/Byte;", "H1", "(S)Ljava/lang/Byte;", "D1", "(D)Ljava/lang/Byte;", "E1", "(F)Ljava/lang/Byte;", "K1", "(J)Ljava/lang/Integer;", "I1", "(D)Ljava/lang/Integer;", "J1", "(F)Ljava/lang/Integer;", "L1", "(D)Ljava/lang/Long;", "M1", "(F)Ljava/lang/Long;", "P1", "(I)Ljava/lang/Short;", "Q1", "(J)Ljava/lang/Short;", "N1", "(D)Ljava/lang/Short;", "O1", "(F)Ljava/lang/Short;", "V1", "(IB)Lkotlin/ranges/IntRange;", "d2", "(JB)Lkotlin/ranges/LongRange;", "S1", "(BB)Lkotlin/ranges/IntRange;", "Y1", "(SB)Lkotlin/ranges/IntRange;", "R1", "(CC)Lkotlin/ranges/CharRange;", "W1", "(II)Lkotlin/ranges/IntRange;", "e2", "(JI)Lkotlin/ranges/LongRange;", "T1", "(BI)Lkotlin/ranges/IntRange;", "Z1", "(SI)Lkotlin/ranges/IntRange;", "c2", "(IJ)Lkotlin/ranges/LongRange;", "f2", "(JJ)Lkotlin/ranges/LongRange;", "b2", "(BJ)Lkotlin/ranges/LongRange;", "h2", "(SJ)Lkotlin/ranges/LongRange;", "X1", "(IS)Lkotlin/ranges/IntRange;", "g2", "(JS)Lkotlin/ranges/LongRange;", "U1", "(BS)Lkotlin/ranges/IntRange;", "a2", "(SS)Lkotlin/ranges/IntRange;", "", "minimumValue", "w", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "r", "(BB)B", "x", "(SS)S", "u", "(II)I", "v", "(JJ)J", "t", "(FF)F", "s", "(DD)D", "maximumValue", "D", "y", "E", "B", "C", "A", "z", "M", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "F", "(BBB)B", "P", "(SSS)S", "I", "(III)I", "K", "(JJJ)J", "H", "(FFF)F", "G", "(DDD)D", "Lkotlin/ranges/ClosedFloatingPointRange;", "range", "N", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "O", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "J", "(ILkotlin/ranges/ClosedRange;)I", "L", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/ranges/RangesKt")
@SourceDebugExtension({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1537:1\n1#2:1538\n*E\n"})
class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static final float A(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer A0(@NotNull IntProgression intProgression) {
        Intrinsics.p(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.j());
    }

    @NotNull
    public static final CharProgression A1(@NotNull CharProgression charProgression, int i2) {
        Intrinsics.p(charProgression, "<this>");
        RangesKt__RangesKt.a(i2 > 0, Integer.valueOf(i2));
        CharProgression.Companion companion = CharProgression.Z;
        char j2 = charProgression.j();
        char k2 = charProgression.k();
        if (charProgression.m() <= 0) {
            i2 = -i2;
        }
        return companion.a(j2, k2, i2);
    }

    public static int B(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long B0(@NotNull LongProgression longProgression) {
        Intrinsics.p(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.j());
    }

    @NotNull
    public static IntProgression B1(@NotNull IntProgression intProgression, int i2) {
        Intrinsics.p(intProgression, "<this>");
        RangesKt__RangesKt.a(i2 > 0, Integer.valueOf(i2));
        IntProgression.Companion companion = IntProgression.Z;
        int j2 = intProgression.j();
        int k2 = intProgression.k();
        if (intProgression.m() <= 0) {
            i2 = -i2;
        }
        return companion.a(j2, k2, i2);
    }

    public static long C(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    @NotNull
    public static final LongProgression C1(@NotNull LongProgression longProgression, long j2) {
        Intrinsics.p(longProgression, "<this>");
        RangesKt__RangesKt.a(j2 > 0, Long.valueOf(j2));
        LongProgression.Companion companion = LongProgression.Z;
        long j3 = longProgression.j();
        long k2 = longProgression.k();
        if (longProgression.m() <= 0) {
            j2 = -j2;
        }
        return companion.a(j3, k2, j2);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T D(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean D0(@NotNull ClosedRange<Float> closedRange, double d2) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Float.valueOf((float) d2));
    }

    @Nullable
    public static final Byte D1(double d2) {
        if (-128.0d > d2 || d2 > 127.0d) {
            return null;
        }
        return Byte.valueOf((byte) ((int) d2));
    }

    public static final short E(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    @Nullable
    public static final Byte E1(float f2) {
        if (-128.0f > f2 || f2 > 127.0f) {
            return null;
        }
        return Byte.valueOf((byte) ((int) f2));
    }

    public static final byte F(byte b2, byte b3, byte b4) {
        if (b3 > b4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + b4 + " is less than minimum " + b3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (b2 < b3) {
            return b3;
        } else {
            return b2 > b4 ? b4 : b2;
        }
    }

    @Nullable
    public static final Byte F1(int i2) {
        if (new IntRange(-128, WorkQueueKt.f29430c).q(i2)) {
            return Byte.valueOf((byte) i2);
        }
        return null;
    }

    public static final double G(double d2, double d3, double d4) {
        if (d3 > d4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (d2 < d3) {
            return d3;
        } else {
            return d2 > d4 ? d4 : d2;
        }
    }

    @Nullable
    public static final Byte G1(long j2) {
        if (new LongRange(-128, 127).q(j2)) {
            return Byte.valueOf((byte) ((int) j2));
        }
        return null;
    }

    public static final float H(float f2, float f3, float f4) {
        if (f3 > f4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (f2 < f3) {
            return f3;
        } else {
            return f2 > f4 ? f4 : f2;
        }
    }

    @JvmName(name = "intRangeContains")
    public static final boolean H0(@NotNull ClosedRange<Integer> closedRange, byte b2) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Integer.valueOf(b2));
    }

    @Nullable
    public static final Byte H1(short s) {
        if (L0(new IntRange(-128, WorkQueueKt.f29430c), s)) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    public static int I(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (i2 < i3) {
            return i3;
        } else {
            return i2 > i4 ? i4 : i2;
        }
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean I0(ClosedRange closedRange, double d2) {
        Intrinsics.p(closedRange, "<this>");
        Integer I1 = I1(d2);
        if (I1 != null) {
            return closedRange.b(I1);
        }
        return false;
    }

    @Nullable
    public static final Integer I1(double d2) {
        if (-2.147483648E9d > d2 || d2 > 2.147483647E9d) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object, kotlin.ranges.ClosedRange, kotlin.ranges.ClosedRange<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int J(int r2, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Integer> r3) {
        /*
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            boolean r0 = r3 instanceof kotlin.ranges.ClosedFloatingPointRange
            if (r0 == 0) goto L_0x001a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            kotlin.ranges.ClosedFloatingPointRange r3 = (kotlin.ranges.ClosedFloatingPointRange) r3
            java.lang.Comparable r2 = N(r2, r3)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            return r2
        L_0x001a:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0049
            java.lang.Comparable r0 = r3.c()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r2 >= r0) goto L_0x0037
            java.lang.Comparable r2 = r3.c()
        L_0x0030:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            goto L_0x0048
        L_0x0037:
            java.lang.Comparable r0 = r3.h()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r2 <= r0) goto L_0x0048
            java.lang.Comparable r2 = r3.h()
            goto L_0x0030
        L_0x0048:
            return r2
        L_0x0049:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot coerce value to an empty range: "
            r0.append(r1)
            r0.append(r3)
            r3 = 46
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.RangesKt___RangesKt.J(int, kotlin.ranges.ClosedRange):int");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean J0(ClosedRange closedRange, float f2) {
        Intrinsics.p(closedRange, "<this>");
        Integer J1 = J1(f2);
        if (J1 != null) {
            return closedRange.b(J1);
        }
        return false;
    }

    @Nullable
    public static final Integer J1(float f2) {
        if (-2.14748365E9f > f2 || f2 > 2.14748365E9f) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    public static long K(long j2, long j3, long j4) {
        if (j3 > j4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (j2 < j3) {
            return j3;
        } else {
            return j2 > j4 ? j4 : j2;
        }
    }

    @JvmName(name = "intRangeContains")
    public static boolean K0(@NotNull ClosedRange<Integer> closedRange, long j2) {
        Intrinsics.p(closedRange, "<this>");
        Integer K1 = K1(j2);
        if (K1 != null) {
            return closedRange.b(K1);
        }
        return false;
    }

    @Nullable
    public static final Integer K1(long j2) {
        if (new LongRange(-2147483648L, 2147483647L).q(j2)) {
            return Integer.valueOf((int) j2);
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, kotlin.ranges.ClosedRange<java.lang.Long>, kotlin.ranges.ClosedRange] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long L(long r3, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<java.lang.Long> r5) {
        /*
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            boolean r0 = r5 instanceof kotlin.ranges.ClosedFloatingPointRange
            if (r0 == 0) goto L_0x001a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            kotlin.ranges.ClosedFloatingPointRange r5 = (kotlin.ranges.ClosedFloatingPointRange) r5
            java.lang.Comparable r3 = N(r3, r5)
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            return r3
        L_0x001a:
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x004d
            java.lang.Comparable r0 = r5.c()
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0039
            java.lang.Comparable r3 = r5.c()
        L_0x0032:
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            goto L_0x004c
        L_0x0039:
            java.lang.Comparable r0 = r5.h()
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x004c
            java.lang.Comparable r3 = r5.h()
            goto L_0x0032
        L_0x004c:
            return r3
        L_0x004d:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Cannot coerce value to an empty range: "
            r4.append(r0)
            r4.append(r5)
            r5 = 46
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.RangesKt___RangesKt.L(long, kotlin.ranges.ClosedRange):long");
    }

    @JvmName(name = "intRangeContains")
    public static final boolean L0(@NotNull ClosedRange<Integer> closedRange, short s) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Integer.valueOf(s));
    }

    @Nullable
    public static final Long L1(double d2) {
        if (-9.223372036854776E18d > d2 || d2 > 9.223372036854776E18d) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T M(@NotNull T t, @Nullable T t2, @Nullable T t3) {
        Intrinsics.p(t, "<this>");
        if (t2 == null || t3 == null) {
            if (t2 == null || t.compareTo(t2) >= 0) {
                return (t3 == null || t.compareTo(t3) <= 0) ? t : t3;
            }
            return t2;
        } else if (t2.compareTo(t3) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean M0(@NotNull OpenEndRange<Integer> openEndRange, byte b2) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Integer.valueOf(b2));
    }

    @Nullable
    public static final Long M1(float f2) {
        if (-9.223372E18f > f2 || f2 > 9.223372E18f) {
            return null;
        }
        return Long.valueOf((long) f2);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T N(@NotNull T t, @NotNull ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(closedFloatingPointRange, "range");
        if (closedFloatingPointRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedFloatingPointRange + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (!closedFloatingPointRange.d(t, closedFloatingPointRange.c()) || closedFloatingPointRange.d(closedFloatingPointRange.c(), t)) {
            return (!closedFloatingPointRange.d(closedFloatingPointRange.h(), t) || closedFloatingPointRange.d(t, closedFloatingPointRange.h())) ? t : closedFloatingPointRange.h();
        } else {
            return closedFloatingPointRange.c();
        }
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean N0(@NotNull OpenEndRange<Integer> openEndRange, long j2) {
        Intrinsics.p(openEndRange, "<this>");
        Integer K1 = K1(j2);
        if (K1 != null) {
            return openEndRange.b(K1);
        }
        return false;
    }

    @Nullable
    public static final Short N1(double d2) {
        if (-32768.0d > d2 || d2 > 32767.0d) {
            return null;
        }
        return Short.valueOf((short) ((int) d2));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T O(@NotNull T t, @NotNull ClosedRange<T> closedRange) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return N(t, (ClosedFloatingPointRange) closedRange);
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (t.compareTo(closedRange.c()) < 0) {
            return closedRange.c();
        } else {
            return t.compareTo(closedRange.h()) > 0 ? closedRange.h() : t;
        }
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "intRangeContains")
    public static final boolean O0(@NotNull OpenEndRange<Integer> openEndRange, short s) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Integer.valueOf(s));
    }

    @Nullable
    public static final Short O1(float f2) {
        if (-32768.0f > f2 || f2 > 32767.0f) {
            return null;
        }
        return Short.valueOf((short) ((int) f2));
    }

    public static final short P(short s, short s2, short s3) {
        if (s2 > s3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + s3 + " is less than minimum " + s2 + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (s < s2) {
            return s2;
        } else {
            return s > s3 ? s3 : s;
        }
    }

    @SinceKotlin(version = "1.7")
    public static final char P0(@NotNull CharProgression charProgression) {
        Intrinsics.p(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.k();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @Nullable
    public static final Short P1(int i2) {
        if (new IntRange(-32768, 32767).q(i2)) {
            return Short.valueOf((short) i2);
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean Q(CharRange charRange, Character ch) {
        Intrinsics.p(charRange, "<this>");
        return ch != null && charRange.q(ch.charValue());
    }

    @SinceKotlin(version = "1.7")
    public static final int Q0(@NotNull IntProgression intProgression) {
        Intrinsics.p(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.k();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @Nullable
    public static final Short Q1(long j2) {
        if (new LongRange(-32768, 32767).q(j2)) {
            return Short.valueOf((short) ((int) j2));
        }
        return null;
    }

    @InlineOnly
    private static final boolean R(IntRange intRange, byte b2) {
        Intrinsics.p(intRange, "<this>");
        return H0(intRange, b2);
    }

    @SinceKotlin(version = "1.7")
    public static final long R0(@NotNull LongProgression longProgression) {
        Intrinsics.p(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.k();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @NotNull
    public static final CharRange R1(char c2, char c3) {
        return Intrinsics.t(c3, 0) <= 0 ? CharRange.X2.a() : new CharRange(c2, (char) (c3 - 1));
    }

    @InlineOnly
    private static final boolean S(IntRange intRange, long j2) {
        Intrinsics.p(intRange, "<this>");
        return RangesKt.K0(intRange, j2);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character S0(@NotNull CharProgression charProgression) {
        Intrinsics.p(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.k());
    }

    @NotNull
    public static final IntRange S1(byte b2, byte b3) {
        return new IntRange(b2, b3 - 1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean T(IntRange intRange, Integer num) {
        Intrinsics.p(intRange, "<this>");
        return num != null && intRange.q(num.intValue());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer T0(@NotNull IntProgression intProgression) {
        Intrinsics.p(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.k());
    }

    @NotNull
    public static final IntRange T1(byte b2, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.X2.a() : new IntRange(b2, i2 - 1);
    }

    @InlineOnly
    private static final boolean U(IntRange intRange, short s) {
        Intrinsics.p(intRange, "<this>");
        return L0(intRange, s);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long U0(@NotNull LongProgression longProgression) {
        Intrinsics.p(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.k());
    }

    @NotNull
    public static final IntRange U1(byte b2, short s) {
        return new IntRange(b2, s - 1);
    }

    @InlineOnly
    private static final boolean V(LongRange longRange, byte b2) {
        Intrinsics.p(longRange, "<this>");
        return V0(longRange, b2);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean V0(@NotNull ClosedRange<Long> closedRange, byte b2) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Long.valueOf((long) b2));
    }

    @NotNull
    public static final IntRange V1(int i2, byte b2) {
        return new IntRange(i2, b2 - 1);
    }

    @InlineOnly
    private static final boolean W(LongRange longRange, int i2) {
        Intrinsics.p(longRange, "<this>");
        return Y0(longRange, i2);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean W0(ClosedRange closedRange, double d2) {
        Intrinsics.p(closedRange, "<this>");
        Long L1 = L1(d2);
        if (L1 != null) {
            return closedRange.b(L1);
        }
        return false;
    }

    @NotNull
    public static IntRange W1(int i2, int i3) {
        return i3 <= Integer.MIN_VALUE ? IntRange.X2.a() : new IntRange(i2, i3 - 1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean X(LongRange longRange, Long l2) {
        Intrinsics.p(longRange, "<this>");
        return l2 != null && longRange.q(l2.longValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean X0(ClosedRange closedRange, float f2) {
        Intrinsics.p(closedRange, "<this>");
        Long M1 = M1(f2);
        if (M1 != null) {
            return closedRange.b(M1);
        }
        return false;
    }

    @NotNull
    public static final IntRange X1(int i2, short s) {
        return new IntRange(i2, s - 1);
    }

    @InlineOnly
    private static final boolean Y(LongRange longRange, short s) {
        Intrinsics.p(longRange, "<this>");
        return Z0(longRange, s);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean Y0(@NotNull ClosedRange<Long> closedRange, int i2) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Long.valueOf((long) i2));
    }

    @NotNull
    public static final IntRange Y1(short s, byte b2) {
        return new IntRange(s, b2 - 1);
    }

    @JvmName(name = "longRangeContains")
    public static final boolean Z0(@NotNull ClosedRange<Long> closedRange, short s) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Long.valueOf((long) s));
    }

    @NotNull
    public static final IntRange Z1(short s, int i2) {
        return i2 <= Integer.MIN_VALUE ? IntRange.X2.a() : new IntRange(s, i2 - 1);
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean a0(@NotNull ClosedRange<Double> closedRange, float f2) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Double.valueOf((double) f2));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean a1(@NotNull OpenEndRange<Long> openEndRange, byte b2) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Long.valueOf((long) b2));
    }

    @NotNull
    public static final IntRange a2(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean b1(@NotNull OpenEndRange<Long> openEndRange, int i2) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Long.valueOf((long) i2));
    }

    @NotNull
    public static final LongRange b2(byte b2, long j2) {
        return j2 <= Long.MIN_VALUE ? LongRange.X2.a() : new LongRange((long) b2, j2 - 1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "longRangeContains")
    public static final boolean c1(@NotNull OpenEndRange<Long> openEndRange, short s) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Long.valueOf((long) s));
    }

    @NotNull
    public static final LongRange c2(int i2, long j2) {
        return j2 <= Long.MIN_VALUE ? LongRange.X2.a() : new LongRange((long) i2, j2 - 1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char d1(CharRange charRange) {
        Intrinsics.p(charRange, "<this>");
        return e1(charRange, Random.s);
    }

    @NotNull
    public static final LongRange d2(long j2, byte b2) {
        return new LongRange(j2, ((long) b2) - 1);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "doubleRangeContains")
    public static final boolean e0(@NotNull OpenEndRange<Double> openEndRange, float f2) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Double.valueOf((double) f2));
    }

    @SinceKotlin(version = "1.3")
    public static final char e1(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.p(charRange, "<this>");
        Intrinsics.p(random, "random");
        try {
            return (char) random.n(charRange.j(), charRange.k() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @NotNull
    public static final LongRange e2(long j2, int i2) {
        return new LongRange(j2, ((long) i2) - 1);
    }

    @NotNull
    public static final CharProgression f0(char c2, char c3) {
        return CharProgression.Z.a(c2, c3, -1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int f1(IntRange intRange) {
        Intrinsics.p(intRange, "<this>");
        return g1(intRange, Random.s);
    }

    @NotNull
    public static final LongRange f2(long j2, long j3) {
        return j3 <= Long.MIN_VALUE ? LongRange.X2.a() : new LongRange(j2, j3 - 1);
    }

    @NotNull
    public static final IntProgression g0(byte b2, byte b3) {
        return IntProgression.Z.a(b2, b3, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final int g1(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.p(intRange, "<this>");
        Intrinsics.p(random, "random");
        try {
            return RandomKt.h(random, intRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @NotNull
    public static final LongRange g2(long j2, short s) {
        return new LongRange(j2, ((long) s) - 1);
    }

    @NotNull
    public static final IntProgression h0(byte b2, int i2) {
        return IntProgression.Z.a(b2, i2, -1);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long h1(LongRange longRange) {
        Intrinsics.p(longRange, "<this>");
        return i1(longRange, Random.s);
    }

    @NotNull
    public static final LongRange h2(short s, long j2) {
        return j2 <= Long.MIN_VALUE ? LongRange.X2.a() : new LongRange((long) s, j2 - 1);
    }

    @NotNull
    public static final IntProgression i0(byte b2, short s) {
        return IntProgression.Z.a(b2, s, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final long i1(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.p(longRange, "<this>");
        Intrinsics.p(random, "random");
        try {
            return RandomKt.i(random, longRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean j(ClosedRange closedRange, double d2) {
        Intrinsics.p(closedRange, "<this>");
        Byte D1 = D1(d2);
        if (D1 != null) {
            return closedRange.b(D1);
        }
        return false;
    }

    @NotNull
    public static final IntProgression j0(int i2, byte b2) {
        return IntProgression.Z.a(i2, b2, -1);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Character j1(CharRange charRange) {
        Intrinsics.p(charRange, "<this>");
        return k1(charRange, Random.s);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean k(ClosedRange closedRange, float f2) {
        Intrinsics.p(closedRange, "<this>");
        Byte E1 = E1(f2);
        if (E1 != null) {
            return closedRange.b(E1);
        }
        return false;
    }

    @NotNull
    public static IntProgression k0(int i2, int i3) {
        return IntProgression.Z.a(i2, i3, -1);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character k1(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.p(charRange, "<this>");
        Intrinsics.p(random, "random");
        if (charRange.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.n(charRange.j(), charRange.k() + 1));
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean l(@NotNull ClosedRange<Byte> closedRange, int i2) {
        Intrinsics.p(closedRange, "<this>");
        Byte F1 = F1(i2);
        if (F1 != null) {
            return closedRange.b(F1);
        }
        return false;
    }

    @NotNull
    public static final IntProgression l0(int i2, short s) {
        return IntProgression.Z.a(i2, s, -1);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Integer l1(IntRange intRange) {
        Intrinsics.p(intRange, "<this>");
        return m1(intRange, Random.s);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean m(@NotNull ClosedRange<Byte> closedRange, long j2) {
        Intrinsics.p(closedRange, "<this>");
        Byte G1 = G1(j2);
        if (G1 != null) {
            return closedRange.b(G1);
        }
        return false;
    }

    @NotNull
    public static final IntProgression m0(short s, byte b2) {
        return IntProgression.Z.a(s, b2, -1);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer m1(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.p(intRange, "<this>");
        Intrinsics.p(random, "random");
        if (intRange.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.h(random, intRange));
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean n(@NotNull ClosedRange<Byte> closedRange, short s) {
        Intrinsics.p(closedRange, "<this>");
        Byte H1 = H1(s);
        if (H1 != null) {
            return closedRange.b(H1);
        }
        return false;
    }

    @NotNull
    public static final IntProgression n0(short s, int i2) {
        return IntProgression.Z.a(s, i2, -1);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final Long n1(LongRange longRange) {
        Intrinsics.p(longRange, "<this>");
        return o1(longRange, Random.s);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean o(@NotNull OpenEndRange<Byte> openEndRange, int i2) {
        Intrinsics.p(openEndRange, "<this>");
        Byte F1 = F1(i2);
        if (F1 != null) {
            return openEndRange.b(F1);
        }
        return false;
    }

    @NotNull
    public static final IntProgression o0(short s, short s2) {
        return IntProgression.Z.a(s, s2, -1);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Long o1(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.p(longRange, "<this>");
        Intrinsics.p(random, "random");
        if (longRange.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.i(random, longRange));
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean p(@NotNull OpenEndRange<Byte> openEndRange, long j2) {
        Intrinsics.p(openEndRange, "<this>");
        Byte G1 = G1(j2);
        if (G1 != null) {
            return openEndRange.b(G1);
        }
        return false;
    }

    @NotNull
    public static final LongProgression p0(byte b2, long j2) {
        return LongProgression.Z.a((long) b2, j2, -1);
    }

    @NotNull
    public static final CharProgression p1(@NotNull CharProgression charProgression) {
        Intrinsics.p(charProgression, "<this>");
        return CharProgression.Z.a(charProgression.k(), charProgression.j(), -charProgression.m());
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "byteRangeContains")
    public static final boolean q(@NotNull OpenEndRange<Byte> openEndRange, short s) {
        Intrinsics.p(openEndRange, "<this>");
        Byte H1 = H1(s);
        if (H1 != null) {
            return openEndRange.b(H1);
        }
        return false;
    }

    @NotNull
    public static final LongProgression q0(int i2, long j2) {
        return LongProgression.Z.a((long) i2, j2, -1);
    }

    @NotNull
    public static final IntProgression q1(@NotNull IntProgression intProgression) {
        Intrinsics.p(intProgression, "<this>");
        return IntProgression.Z.a(intProgression.k(), intProgression.j(), -intProgression.m());
    }

    public static final byte r(byte b2, byte b3) {
        return b2 < b3 ? b3 : b2;
    }

    @NotNull
    public static final LongProgression r0(long j2, byte b2) {
        return LongProgression.Z.a(j2, (long) b2, -1);
    }

    @NotNull
    public static final LongProgression r1(@NotNull LongProgression longProgression) {
        Intrinsics.p(longProgression, "<this>");
        return LongProgression.Z.a(longProgression.k(), longProgression.j(), -longProgression.m());
    }

    public static final double s(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    @NotNull
    public static final LongProgression s0(long j2, int i2) {
        return LongProgression.Z.a(j2, (long) i2, -1);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean s1(@NotNull ClosedRange<Short> closedRange, byte b2) {
        Intrinsics.p(closedRange, "<this>");
        return closedRange.b(Short.valueOf((short) b2));
    }

    public static final float t(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    @NotNull
    public static final LongProgression t0(long j2, long j3) {
        return LongProgression.Z.a(j2, j3, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean t1(ClosedRange closedRange, double d2) {
        Intrinsics.p(closedRange, "<this>");
        Short N1 = N1(d2);
        if (N1 != null) {
            return closedRange.b(N1);
        }
        return false;
    }

    public static int u(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    @NotNull
    public static final LongProgression u0(long j2, short s) {
        return LongProgression.Z.a(j2, (long) s, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean u1(ClosedRange closedRange, float f2) {
        Intrinsics.p(closedRange, "<this>");
        Short O1 = O1(f2);
        if (O1 != null) {
            return closedRange.b(O1);
        }
        return false;
    }

    public static long v(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    @NotNull
    public static final LongProgression v0(short s, long j2) {
        return LongProgression.Z.a((long) s, j2, -1);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean v1(@NotNull ClosedRange<Short> closedRange, int i2) {
        Intrinsics.p(closedRange, "<this>");
        Short P1 = P1(i2);
        if (P1 != null) {
            return closedRange.b(P1);
        }
        return false;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T w(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    @SinceKotlin(version = "1.7")
    public static final char w0(@NotNull CharProgression charProgression) {
        Intrinsics.p(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.j();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean w1(@NotNull ClosedRange<Short> closedRange, long j2) {
        Intrinsics.p(closedRange, "<this>");
        Short Q1 = Q1(j2);
        if (Q1 != null) {
            return closedRange.b(Q1);
        }
        return false;
    }

    public static final short x(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    @SinceKotlin(version = "1.7")
    public static final int x0(@NotNull IntProgression intProgression) {
        Intrinsics.p(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.j();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean x1(@NotNull OpenEndRange<Short> openEndRange, byte b2) {
        Intrinsics.p(openEndRange, "<this>");
        return openEndRange.b(Short.valueOf((short) b2));
    }

    public static final byte y(byte b2, byte b3) {
        return b2 > b3 ? b3 : b2;
    }

    @SinceKotlin(version = "1.7")
    public static final long y0(@NotNull LongProgression longProgression) {
        Intrinsics.p(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.j();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean y1(@NotNull OpenEndRange<Short> openEndRange, int i2) {
        Intrinsics.p(openEndRange, "<this>");
        Short P1 = P1(i2);
        if (P1 != null) {
            return openEndRange.b(P1);
        }
        return false;
    }

    public static final double z(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character z0(@NotNull CharProgression charProgression) {
        Intrinsics.p(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.j());
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @JvmName(name = "shortRangeContains")
    public static final boolean z1(@NotNull OpenEndRange<Short> openEndRange, long j2) {
        Intrinsics.p(openEndRange, "<this>");
        Short Q1 = Q1(j2);
        if (Q1 != null) {
            return openEndRange.b(Q1);
        }
        return false;
    }
}
