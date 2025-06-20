package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/text/SystemProperties;", "", "<init>", "()V", "", "b", "Ljava/lang/String;", "LINE_SEPARATOR", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class SystemProperties {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final SystemProperties f29112a = new SystemProperties();
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final String f29113b;

    static {
        String property = System.getProperty("line.separator");
        Intrinsics.m(property);
        f29113b = property;
    }

    private SystemProperties() {
    }
}
