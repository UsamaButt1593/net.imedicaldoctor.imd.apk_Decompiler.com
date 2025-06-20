package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0013\b&\u0018\u0000 +2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0012J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010 \u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\fH&¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u001dJ\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010%J:\u0010+\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2\u0006\u0010\u001a\u001a\u00020\u00042\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00028\u00000'¢\u0006\u0002\b)H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\fH&¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b0\u00101JD\u00104\u001a\u00028\u0000\"\u0004\b\u0000\u0010&2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\f2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00028\u00000'¢\u0006\u0002\b)H\bø\u0001\u0000¢\u0006\u0004\b4\u00105J!\u00106\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\fH&¢\u0006\u0004\b6\u0010/J\u0015\u00107\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b7\u00101J!\u00109\u001a\u0002082\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\fH&¢\u0006\u0004\b9\u0010:J\u0015\u0010;\u001a\u0002082\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b;\u0010<J\u001f\u0010=\u001a\u0002082\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b=\u0010:J\u0015\u0010>\u001a\u0002082\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b>\u0010<J\u001f\u0010A\u001a\u0002082\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H&¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u0002082\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H\u0016¢\u0006\u0004\bC\u0010BJ!\u0010D\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\fH&¢\u0006\u0004\bD\u0010:J\u0015\u0010E\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bE\u0010<J!\u0010G\u001a\u0002082\u0006\u0010F\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010:J\u0015\u0010H\u001a\u0002082\u0006\u0010F\u001a\u00020\u0004¢\u0006\u0004\bH\u0010<J\u001f\u0010I\u001a\u0002082\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004H&¢\u0006\u0004\bI\u0010B\u0002\u0007\n\u0005\b20\u0001¨\u0006K"}, d2 = {"Lokio/FileSystem;", "", "<init>", "()V", "Lokio/Path;", "path", "h", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "C", "(Lokio/Path;)Lokio/FileMetadata;", "D", "", "w", "(Lokio/Path;)Z", "dir", "", "x", "(Lokio/Path;)Ljava/util/List;", "y", "followSymlinks", "Lkotlin/sequences/Sequence;", "A", "(Lokio/Path;Z)Lkotlin/sequences/Sequence;", "z", "(Lokio/Path;)Lkotlin/sequences/Sequence;", "file", "Lokio/FileHandle;", "E", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "G", "(Lokio/Path;ZZ)Lokio/FileHandle;", "F", "Lokio/Source;", "L", "(Lokio/Path;)Lokio/Source;", "T", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "readerAction", "a", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lokio/Sink;", "J", "(Lokio/Path;Z)Lokio/Sink;", "I", "(Lokio/Path;)Lokio/Sink;", "Lokio/BufferedSink;", "writerAction", "b", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "e", "d", "", "n", "(Lokio/Path;Z)V", "m", "(Lokio/Path;)V", "k", "j", "source", "target", "g", "(Lokio/Path;Lokio/Path;)V", "i", "r", "q", "fileOrDirectory", "u", "t", "p", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class FileSystem {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f31364a = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final FileSystem f31365b;
    @NotNull
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final Path f31366c;
    @NotNull
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final FileSystem f31367d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "RESOURCES", "Lokio/FileSystem;", "SYSTEM", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        FileSystem fileSystem;
        try {
            Class.forName("java.nio.file.Files");
            fileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            fileSystem = new JvmSystemFileSystem();
        }
        f31365b = fileSystem;
        Path.Companion companion = Path.X;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.o(property, "getProperty(\"java.io.tmpdir\")");
        f31366c = Path.Companion.h(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.o(classLoader, "ResourceFileSystem::class.java.classLoader");
        f31367d = new ResourceFileSystem(classLoader, false);
    }

    public static /* synthetic */ Sequence B(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return fileSystem.A(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
    }

    public static /* synthetic */ FileHandle H(FileSystem fileSystem, Path path, boolean z, boolean z2, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            return fileSystem.G(path, z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
    }

    public static /* synthetic */ Sink K(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return fileSystem.J(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    public static /* synthetic */ Object c(FileSystem fileSystem, Path path, boolean z, Function1 function1, int i2, Object obj) throws IOException {
        Object obj2;
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            Intrinsics.p(path, Annotation.k3);
            Intrinsics.p(function1, "writerAction");
            BufferedSink d2 = Okio.d(fileSystem.J(path, z));
            Throwable th = null;
            try {
                obj2 = function1.f(d2);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                obj2 = null;
                th = th3;
            }
            if (d2 != null) {
                try {
                    d2.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.a(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.m(obj2);
                return obj2;
            }
            throw th;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    public static /* synthetic */ Sink f(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return fileSystem.e(path, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
    }

    public static /* synthetic */ void l(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            fileSystem.k(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
    }

    public static /* synthetic */ void o(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            fileSystem.n(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
    }

    public static /* synthetic */ void s(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            fileSystem.r(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
    }

    public static /* synthetic */ void v(FileSystem fileSystem, Path path, boolean z, int i2, Object obj) throws IOException {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            fileSystem.u(path, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
    }

    @NotNull
    public Sequence<Path> A(@NotNull Path path, boolean z) {
        Intrinsics.p(path, HTML.Attribute.u);
        return _FileSystemKt.f(this, path, z);
    }

    @NotNull
    public final FileMetadata C(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Cookie2.PATH);
        return _FileSystemKt.g(this, path);
    }

    @Nullable
    public abstract FileMetadata D(@NotNull Path path) throws IOException;

    @NotNull
    public abstract FileHandle E(@NotNull Path path) throws IOException;

    @NotNull
    public final FileHandle F(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return G(path, false, false);
    }

    @NotNull
    public abstract FileHandle G(@NotNull Path path, boolean z, boolean z2) throws IOException;

    @NotNull
    public final Sink I(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return J(path, false);
    }

    @NotNull
    public abstract Sink J(@NotNull Path path, boolean z) throws IOException;

    @NotNull
    public abstract Source L(@NotNull Path path) throws IOException;

    @JvmName(name = "-read")
    public final <T> T a(@NotNull Path path, @NotNull Function1<? super BufferedSource, ? extends T> function1) throws IOException {
        T t;
        Intrinsics.p(path, Annotation.k3);
        Intrinsics.p(function1, "readerAction");
        BufferedSource e2 = Okio.e(L(path));
        Throwable th = null;
        try {
            t = function1.f(e2);
        } catch (Throwable th2) {
            th = th2;
            t = null;
        }
        if (e2 != null) {
            try {
                e2.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.a(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.m(t);
            return t;
        }
        throw th;
    }

    @JvmName(name = "-write")
    public final <T> T b(@NotNull Path path, boolean z, @NotNull Function1<? super BufferedSink, ? extends T> function1) throws IOException {
        T t;
        Intrinsics.p(path, Annotation.k3);
        Intrinsics.p(function1, "writerAction");
        BufferedSink d2 = Okio.d(J(path, z));
        Throwable th = null;
        try {
            t = function1.f(d2);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            t = null;
            th = th3;
        }
        if (d2 != null) {
            try {
                d2.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                } else {
                    ExceptionsKt.a(th, th4);
                }
            }
        }
        if (th == null) {
            Intrinsics.m(t);
            return t;
        }
        throw th;
    }

    @NotNull
    public final Sink d(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return e(path, false);
    }

    @NotNull
    public abstract Sink e(@NotNull Path path, boolean z) throws IOException;

    public abstract void g(@NotNull Path path, @NotNull Path path2) throws IOException;

    @NotNull
    public abstract Path h(@NotNull Path path) throws IOException;

    public void i(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        _FileSystemKt.b(this, path, path2);
    }

    public final void j(@NotNull Path path) throws IOException {
        Intrinsics.p(path, HTML.Attribute.u);
        k(path, false);
    }

    public final void k(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(path, HTML.Attribute.u);
        _FileSystemKt.c(this, path, z);
    }

    public final void m(@NotNull Path path) throws IOException {
        Intrinsics.p(path, HTML.Attribute.u);
        n(path, false);
    }

    public abstract void n(@NotNull Path path, boolean z) throws IOException;

    public abstract void p(@NotNull Path path, @NotNull Path path2) throws IOException;

    public final void q(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Cookie2.PATH);
        r(path, false);
    }

    public abstract void r(@NotNull Path path, boolean z) throws IOException;

    public final void t(@NotNull Path path) throws IOException {
        Intrinsics.p(path, "fileOrDirectory");
        u(path, false);
    }

    public void u(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(path, "fileOrDirectory");
        _FileSystemKt.d(this, path, z);
    }

    public final boolean w(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Cookie2.PATH);
        return _FileSystemKt.e(this, path);
    }

    @NotNull
    public abstract List<Path> x(@NotNull Path path) throws IOException;

    @Nullable
    public abstract List<Path> y(@NotNull Path path);

    @NotNull
    public final Sequence<Path> z(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        return A(path, false);
    }
}
