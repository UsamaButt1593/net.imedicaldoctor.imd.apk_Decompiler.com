package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\"!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015\"$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u0018*\u00020\u00008FX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"", "", "f", "(Ljava/lang/Throwable;)V", "Ljava/io/PrintWriter;", "writer", "h", "(Ljava/lang/Throwable;Ljava/io/PrintWriter;)V", "Ljava/io/PrintStream;", "stream", "g", "(Ljava/lang/Throwable;Ljava/io/PrintStream;)V", "", "i", "(Ljava/lang/Throwable;)Ljava/lang/String;", "exception", "a", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "", "Ljava/lang/StackTraceElement;", "b", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "c", "stackTrace", "", "d", "(Ljava/lang/Throwable;)Ljava/util/List;", "e", "suppressedExceptions", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/ExceptionsKt")
class ExceptionsKt__ExceptionsKt {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void a(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.p(th, "<this>");
        Intrinsics.p(th2, "exception");
        if (th != th2) {
            PlatformImplementationsKt.f28815a.a(th, th2);
        }
    }

    @NotNull
    public static final StackTraceElement[] b(@NotNull Throwable th) {
        Intrinsics.p(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.m(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    @NotNull
    public static final List<Throwable> d(@NotNull Throwable th) {
        Intrinsics.p(th, "<this>");
        return PlatformImplementationsKt.f28815a.d(th);
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void e(Throwable th) {
    }

    @InlineOnly
    private static final void f(Throwable th) {
        Intrinsics.p(th, "<this>");
        th.printStackTrace();
    }

    @InlineOnly
    private static final void g(Throwable th, PrintStream printStream) {
        Intrinsics.p(th, "<this>");
        Intrinsics.p(printStream, "stream");
        th.printStackTrace(printStream);
    }

    @InlineOnly
    private static final void h(Throwable th, PrintWriter printWriter) {
        Intrinsics.p(th, "<this>");
        Intrinsics.p(printWriter, "writer");
        th.printStackTrace(printWriter);
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final String i(@NotNull Throwable th) {
        Intrinsics.p(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.o(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
