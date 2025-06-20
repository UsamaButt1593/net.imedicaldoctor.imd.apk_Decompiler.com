package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a7\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\b¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0012\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/util/AtomicFile;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "", "block", "d", "(Landroid/util/AtomicFile;Lkotlin/jvm/functions/Function1;)V", "", "array", "e", "(Landroid/util/AtomicFile;[B)V", "", "text", "Ljava/nio/charset/Charset;", "charset", "f", "(Landroid/util/AtomicFile;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "a", "(Landroid/util/AtomicFile;)[B", "b", "(Landroid/util/AtomicFile;Ljava/nio/charset/Charset;)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAtomicFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n1#1,76:1\n30#1,13:77\n*S KotlinDebug\n*F\n+ 1 AtomicFile.kt\nandroidx/core/util/AtomicFileKt\n*L\n48#1:77,13\n*E\n"})
public final class AtomicFileKt {
    @NotNull
    public static final byte[] a(@NotNull AtomicFile atomicFile) {
        return atomicFile.readFully();
    }

    @NotNull
    public static final String b(@NotNull AtomicFile atomicFile, @NotNull Charset charset) {
        return new String(atomicFile.readFully(), charset);
    }

    public static /* synthetic */ String c(AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f29053b;
        }
        return b(atomicFile, charset);
    }

    public static final void d(@NotNull AtomicFile atomicFile, @NotNull Function1<? super FileOutputStream, Unit> function1) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            function1.f(startWrite);
            InlineMarker.d(1);
            atomicFile.finishWrite(startWrite);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.d(1);
            atomicFile.failWrite(startWrite);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void e(@NotNull AtomicFile atomicFile, @NotNull byte[] bArr) {
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }

    public static final void f(@NotNull AtomicFile atomicFile, @NotNull String str, @NotNull Charset charset) {
        byte[] bytes = str.getBytes(charset);
        Intrinsics.o(bytes, "this as java.lang.String).getBytes(charset)");
        e(atomicFile, bytes);
    }

    public static /* synthetic */ void g(AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.f29053b;
        }
        f(atomicFile, str, charset);
    }
}
