package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\n\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\t\"\u0014\u0010\f\u001a\u00020\b8\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\t\"\u0014\u0010\u000e\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\t\"\u0014\u0010\u0010\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\t\"\u0014\u0010\u0012\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\t\"\u001a\u0010\u0015\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u001a\u0010\u0017\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\"\u001a\u0010\u0019\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0011\u0010\u0014\"\u001a\u0010\u001e\u001a\u00020\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\r\u0010\u001d¨\u0006\u001f"}, d2 = {"", "f", "()V", "Lkotlin/Function0;", "", "value", "a", "(Lkotlin/jvm/functions/Function0;)V", "", "Ljava/lang/String;", "DEBUG_PROPERTY_NAME", "b", "STACKTRACE_RECOVERY_PROPERTY_NAME", "c", "DEBUG_PROPERTY_VALUE_AUTO", "d", "DEBUG_PROPERTY_VALUE_ON", "e", "DEBUG_PROPERTY_VALUE_OFF", "Z", "()Z", "ASSERTIONS_ENABLED", "g", "DEBUG", "h", "RECOVER_STACK_TRACES", "Ljava/util/concurrent/atomic/AtomicLong;", "i", "Ljava/util/concurrent/atomic/AtomicLong;", "()Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class DebugKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f29170a = "kotlinx.coroutines.debug";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f29171b = "kotlinx.coroutines.stacktrace.recovery";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final String f29172c = "auto";
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final String f29173d = "on";
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final String f29174e = "off";

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f29175f = false;

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f29176g;

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f29177h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicLong f29178i = new AtomicLong(0);

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r0.equals(f29173d) != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r0.equals("") != false) goto L_0x0042;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002f
            int r3 = r0.hashCode()
            if (r3 == 0) goto L_0x003a
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L_0x0031
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L_0x0027
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L_0x0044
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0044
            goto L_0x002f
        L_0x0027:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0044
        L_0x002f:
            r0 = 0
            goto L_0x0064
        L_0x0031:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0044
            goto L_0x0042
        L_0x003a:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0044
        L_0x0042:
            r0 = 1
            goto L_0x0064
        L_0x0044:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.append(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0064:
            f29176g = r0
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.SystemPropsKt.e(r0, r1)
            if (r0 == 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r1 = 0
        L_0x0072:
            f29177h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            f29178i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }

    @InlineOnly
    private static final void a(Function0<Boolean> function0) {
    }

    public static final boolean b() {
        return f29175f;
    }

    @NotNull
    public static final AtomicLong c() {
        return f29178i;
    }

    public static final boolean d() {
        return f29176g;
    }

    public static final boolean e() {
        return f29177h;
    }

    public static final void f() {
        f29178i.set(0);
    }
}
