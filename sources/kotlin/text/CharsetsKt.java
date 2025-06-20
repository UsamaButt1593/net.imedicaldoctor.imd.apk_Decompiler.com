package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "charsetName", "Ljava/nio/charset/Charset;", "a", "(Ljava/lang/String;)Ljava/nio/charset/Charset;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "CharsetsKt")
public final class CharsetsKt {
    @InlineOnly
    private static final Charset a(String str) {
        Intrinsics.p(str, "charsetName");
        Charset forName = Charset.forName(str);
        Intrinsics.o(forName, "forName(charsetName)");
        return forName;
    }
}
