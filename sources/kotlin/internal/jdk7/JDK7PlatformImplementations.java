package kotlin.internal.jdk7;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "<init>", "()V", "", "version", "", "e", "(I)Z", "", "cause", "exception", "", "a", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "", "d", "(Ljava/lang/Throwable;)Ljava/util/List;", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
public class JDK7PlatformImplementations extends PlatformImplementations {

    @SourceDebugExtension({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", "", "b", "Ljava/lang/Integer;", "sdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
    private static final class ReflectSdkVersion {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectSdkVersion f28816a = new ReflectSdkVersion();
        @Nullable
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f28817b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                    if (num != null && num.intValue() > 0) {
                        num2 = num;
                    }
                    f28817b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f28817b = num2;
        }

        private ReflectSdkVersion() {
        }
    }

    private final boolean e(int i2) {
        Integer num = ReflectSdkVersion.f28817b;
        return num == null || num.intValue() >= i2;
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.p(th, "cause");
        Intrinsics.p(th2, "exception");
        if (e(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }

    @NotNull
    public List<Throwable> d(@NotNull Throwable th) {
        Intrinsics.p(th, "exception");
        if (!e(19)) {
            return super.d(th);
        }
        Throwable[] suppressed = th.getSuppressed();
        Intrinsics.o(suppressed, "exception.suppressed");
        return ArraysKt.t(suppressed);
    }
}
