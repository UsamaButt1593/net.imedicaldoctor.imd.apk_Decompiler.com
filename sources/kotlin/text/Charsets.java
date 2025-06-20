package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0019¨\u0006\u001d"}, d2 = {"Lkotlin/text/Charsets;", "", "<init>", "()V", "Ljava/nio/charset/Charset;", "b", "Ljava/nio/charset/Charset;", "UTF_8", "c", "UTF_16", "d", "UTF_16BE", "e", "UTF_16LE", "f", "US_ASCII", "g", "ISO_8859_1", "h", "utf_32", "i", "utf_32le", "j", "utf_32be", "a", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF_32LE", "UTF_32BE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Charsets {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Charsets f29052a = new Charsets();
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f29053b;
    @NotNull
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f29054c;
    @NotNull
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f29055d;
    @NotNull
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f29056e;
    @NotNull
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f29057f;
    @NotNull
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f29058g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static volatile Charset f29059h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static volatile Charset f29060i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static volatile Charset f29061j;

    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.o(forName, "forName(\"UTF-8\")");
        f29053b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        Intrinsics.o(forName2, "forName(\"UTF-16\")");
        f29054c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.o(forName3, "forName(\"UTF-16BE\")");
        f29055d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        Intrinsics.o(forName4, "forName(\"UTF-16LE\")");
        f29056e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        Intrinsics.o(forName5, "forName(\"US-ASCII\")");
        f29057f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        Intrinsics.o(forName6, "forName(\"ISO-8859-1\")");
        f29058g = forName6;
    }

    private Charsets() {
    }

    @NotNull
    @JvmName(name = "UTF32")
    public final Charset a() {
        Charset charset = f29059h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        Intrinsics.o(forName, "forName(\"UTF-32\")");
        f29059h = forName;
        return forName;
    }

    @NotNull
    @JvmName(name = "UTF32_BE")
    public final Charset b() {
        Charset charset = f29061j;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        Intrinsics.o(forName, "forName(\"UTF-32BE\")");
        f29061j = forName;
        return forName;
    }

    @NotNull
    @JvmName(name = "UTF32_LE")
    public final Charset c() {
        Charset charset = f29060i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        Intrinsics.o(forName, "forName(\"UTF-32LE\")");
        f29060i = forName;
        return forName;
    }
}
