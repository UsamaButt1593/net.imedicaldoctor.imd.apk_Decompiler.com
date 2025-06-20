package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001a\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\b¢\u0006\u0004\b\t\u0010\n\u001a\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000bH\b¢\u0006\u0004\b\f\u0010\r\u001a\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000eH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0011H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0014H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0017H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u001aH\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u001dH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001a\u0010 \u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\b¢\u0006\u0004\b \u0010\u0004\u001a\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\b¢\u0006\u0004\b!\u0010\u0007\u001a\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\b¢\u0006\u0004\b\"\u0010\n\u001a\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000bH\b¢\u0006\u0004\b#\u0010\r\u001a\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000eH\b¢\u0006\u0004\b$\u0010\u0010\u001a\u0018\u0010%\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0011H\b¢\u0006\u0004\b%\u0010\u0013\u001a\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0014H\b¢\u0006\u0004\b&\u0010\u0016\u001a\u0018\u0010'\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0017H\b¢\u0006\u0004\b'\u0010\u0019\u001a\u0018\u0010(\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u001aH\b¢\u0006\u0004\b(\u0010\u001c\u001a\u0018\u0010)\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u001dH\b¢\u0006\u0004\b)\u0010\u001f\u001a\u0010\u0010*\u001a\u00020\u0002H\b¢\u0006\u0004\b*\u0010+\u001a\u000f\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0004\b/\u0010.\u001a\u000f\u00100\u001a\u0004\u0018\u00010,¢\u0006\u0004\b0\u0010.¨\u00061"}, d2 = {"", "message", "", "g", "(Ljava/lang/Object;)V", "", "e", "(I)V", "", "f", "(J)V", "", "a", "(B)V", "", "h", "(S)V", "", "b", "(C)V", "", "i", "(Z)V", "", "d", "(F)V", "", "c", "(D)V", "", "j", "([C)V", "r", "p", "q", "l", "s", "m", "t", "o", "n", "u", "k", "()V", "", "w", "()Ljava/lang/String;", "x", "v", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "ConsoleKt")
public final class ConsoleKt {
    @InlineOnly
    private static final void a(byte b2) {
        System.out.print(Byte.valueOf(b2));
    }

    @InlineOnly
    private static final void b(char c2) {
        System.out.print(c2);
    }

    @InlineOnly
    private static final void c(double d2) {
        System.out.print(d2);
    }

    @InlineOnly
    private static final void d(float f2) {
        System.out.print(f2);
    }

    @InlineOnly
    private static final void e(int i2) {
        System.out.print(i2);
    }

    @InlineOnly
    private static final void f(long j2) {
        System.out.print(j2);
    }

    @InlineOnly
    private static final void g(Object obj) {
        System.out.print(obj);
    }

    @InlineOnly
    private static final void h(short s) {
        System.out.print(Short.valueOf(s));
    }

    @InlineOnly
    private static final void i(boolean z) {
        System.out.print(z);
    }

    @InlineOnly
    private static final void j(char[] cArr) {
        Intrinsics.p(cArr, "message");
        System.out.print(cArr);
    }

    @InlineOnly
    private static final void k() {
        System.out.println();
    }

    @InlineOnly
    private static final void l(byte b2) {
        System.out.println(Byte.valueOf(b2));
    }

    @InlineOnly
    private static final void m(char c2) {
        System.out.println(c2);
    }

    @InlineOnly
    private static final void n(double d2) {
        System.out.println(d2);
    }

    @InlineOnly
    private static final void o(float f2) {
        System.out.println(f2);
    }

    @InlineOnly
    private static final void p(int i2) {
        System.out.println(i2);
    }

    @InlineOnly
    private static final void q(long j2) {
        System.out.println(j2);
    }

    @InlineOnly
    private static final void r(Object obj) {
        System.out.println(obj);
    }

    @InlineOnly
    private static final void s(short s) {
        System.out.println(Short.valueOf(s));
    }

    @InlineOnly
    private static final void t(boolean z) {
        System.out.println(z);
    }

    @InlineOnly
    private static final void u(char[] cArr) {
        Intrinsics.p(cArr, "message");
        System.out.println(cArr);
    }

    @Nullable
    public static final String v() {
        LineReader lineReader = LineReader.f28844a;
        InputStream inputStream = System.in;
        Intrinsics.o(inputStream, "`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.o(defaultCharset, "defaultCharset()");
        return lineReader.d(inputStream, defaultCharset);
    }

    @NotNull
    @SinceKotlin(version = "1.6")
    public static final String w() {
        String x = x();
        if (x != null) {
            return x;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(version = "1.6")
    @Nullable
    public static final String x() {
        return v();
    }
}
