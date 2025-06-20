package kotlin.io;

import com.itextpdf.text.Annotation;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "Ljava/io/File;", "file", "other", "", "reason", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "s", "Ljava/io/File;", "a", "()Ljava/io/File;", "X", "b", "Y", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public class FileSystemException extends IOException {
    @Nullable
    private final File X;
    @Nullable
    private final String Y;
    @NotNull
    private final File s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemException(@NotNull File file, @Nullable File file2, @Nullable String str) {
        super(ExceptionsKt.b(file, file2, str));
        Intrinsics.p(file, Annotation.k3);
        this.s = file;
        this.X = file2;
        this.Y = str;
    }

    @NotNull
    public final File a() {
        return this.s;
    }

    @Nullable
    public final File b() {
        return this.X;
    }

    @Nullable
    public final String c() {
        return this.Y;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileSystemException(File file, File file2, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? null : file2, (i2 & 4) != 0 ? null : str);
    }
}
