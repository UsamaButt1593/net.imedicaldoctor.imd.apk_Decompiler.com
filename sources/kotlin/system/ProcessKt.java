package kotlin.system;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "status", "", "a", "(I)Ljava/lang/Void;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "ProcessKt")
public final class ProcessKt {
    @InlineOnly
    private static final Void a(int i2) {
        System.exit(i2);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
