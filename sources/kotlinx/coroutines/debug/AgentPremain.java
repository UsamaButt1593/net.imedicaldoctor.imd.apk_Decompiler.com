package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import k.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;

@SuppressLint({"all"})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0003R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "<init>", "()V", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "", "d", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", "b", "", "Z", "enableCreationStackTraces", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@IgnoreJRERequirement
public final class AgentPremain {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final AgentPremain f29252a = new AgentPremain();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f29253b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "<init>", "()V", "Ljava/lang/ClassLoader;", "loader", "", "className", "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", "a", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/Class;Ljava/security/ProtectionDomain;[B)[B", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final DebugProbesTransformer f29254a = new DebugProbesTransformer();

        private DebugProbesTransformer() {
        }

        @Nullable
        public byte[] a(@NotNull ClassLoader classLoader, @NotNull String str, @Nullable Class<?> cls, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] bArr) {
            if (!Intrinsics.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            AgentInstallationType.f29255a.b(true);
            return ByteStreamsKt.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    static {
        Object obj;
        Boolean bool = null;
        try {
            Result.Companion companion = Result.X;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            obj = Result.b(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
        if (!Result.i(obj)) {
            bool = obj;
        }
        Boolean bool2 = bool;
        f29253b = bool2 != null ? bool2.booleanValue() : DebugProbesImpl.f29286a.u();
    }

    private AgentPremain() {
    }

    private final void b() {
        try {
            Signal.handle(new Signal("TRAP"), new a());
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static final void c(Signal signal) {
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f29286a;
        if (debugProbesImpl.z()) {
            debugProbesImpl.f(System.out);
        } else {
            System.out.println("Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @JvmStatic
    public static final void d(@Nullable String str, @NotNull Instrumentation instrumentation) {
        AgentInstallationType.f29255a.b(true);
        instrumentation.addTransformer(DebugProbesTransformer.f29254a);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f29286a;
        debugProbesImpl.K(f29253b);
        debugProbesImpl.x();
        f29252a.b();
    }
}
