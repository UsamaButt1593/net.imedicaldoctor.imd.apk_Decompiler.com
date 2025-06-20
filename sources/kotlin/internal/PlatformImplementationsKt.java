package kotlin.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\f8\u0000X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r¨\u0006\u000f"}, d2 = {"", "T", "instance", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "major", "minor", "patch", "", "a", "(III)Z", "Lkotlin/internal/PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "IMPLEMENTATIONS", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class PlatformImplementationsKt {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public static final PlatformImplementations f28815a = new JDK8PlatformImplementations();

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean a(int i2, int i3, int i4) {
        return KotlinVersion.Z2.g(i2, i3, i4);
    }

    @InlineOnly
    private static final /* synthetic */ <T> T b(Object obj) {
        try {
            Intrinsics.y(1, ExifInterface.d5);
            return obj;
        } catch (ClassCastException e2) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.y(4, ExifInterface.d5);
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (!Intrinsics.g(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e2);
            }
            throw e2;
        }
    }
}
