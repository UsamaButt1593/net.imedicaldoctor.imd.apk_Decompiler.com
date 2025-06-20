package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 92\u00020\u0001:\u0001:B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010)J\u001f\u0010,\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020+2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b2\u0010-J\u001f\u00103\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b3\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u00104R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00107R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u00108¨\u0006;"}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "fileSystem", "", "Lokio/internal/ZipEntry;", "entries", "", "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "path", "N", "(Lokio/Path;)Lokio/Path;", "dir", "", "throwOnFailure", "", "O", "(Lokio/Path;Z)Ljava/util/List;", "h", "Lokio/FileMetadata;", "D", "(Lokio/Path;)Lokio/FileMetadata;", "file", "Lokio/FileHandle;", "E", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "G", "(Lokio/Path;ZZ)Lokio/FileHandle;", "x", "(Lokio/Path;)Ljava/util/List;", "y", "Lokio/Source;", "L", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "J", "(Lokio/Path;Z)Lokio/Sink;", "e", "", "n", "(Lokio/Path;Z)V", "source", "target", "g", "(Lokio/Path;Lokio/Path;)V", "r", "p", "Lokio/Path;", "f", "Lokio/FileSystem;", "Ljava/util/Map;", "Ljava/lang/String;", "i", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class ZipFileSystem extends FileSystem {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final Companion f31412i = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final Path f31413j = Path.Companion.h(Path.X, "/", false, 1, (Object) null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Path f31414e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final FileSystem f31415f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Map<Path, ZipEntry> f31416g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final String f31417h;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "<init>", "()V", "Lokio/Path;", "ROOT", "Lokio/Path;", "a", "()Lokio/Path;", "okio"}, k = 1, mv = {1, 5, 1})
    private static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Path a() {
            return ZipFileSystem.f31413j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ZipFileSystem(@NotNull Path path, @NotNull FileSystem fileSystem, @NotNull Map<Path, ZipEntry> map, @Nullable String str) {
        Intrinsics.p(path, "zipPath");
        Intrinsics.p(fileSystem, "fileSystem");
        Intrinsics.p(map, "entries");
        this.f31414e = path;
        this.f31415f = fileSystem;
        this.f31416g = map;
        this.f31417h = str;
    }

    private final Path N(Path path) {
        return f31413j.A(path, true);
    }

    private final List<Path> O(Path path, boolean z) {
        ZipEntry zipEntry = this.f31416g.get(N(path));
        if (zipEntry != null) {
            return CollectionsKt.S5(zipEntry.b());
        }
        if (!z) {
            return null;
        }
        throw new IOException(Intrinsics.C("not a directory: ", path));
    }

    @Nullable
    public FileMetadata D(@NotNull Path path) {
        BufferedSource bufferedSource;
        Intrinsics.p(path, Cookie2.PATH);
        ZipEntry zipEntry = this.f31416g.get(N(path));
        Throwable th = null;
        if (zipEntry == null) {
            return null;
        }
        FileMetadata fileMetadata = new FileMetadata(!zipEntry.j(), zipEntry.j(), (Path) null, zipEntry.j() ? null : Long.valueOf(zipEntry.i()), (Long) null, zipEntry.g(), (Long) null, (Map) null, 128, (DefaultConstructorMarker) null);
        if (zipEntry.h() == -1) {
            return fileMetadata;
        }
        FileHandle E = this.f31415f.E(this.f31414e);
        try {
            bufferedSource = Okio.e(E.I(zipEntry.h()));
        } catch (Throwable th2) {
            th = th2;
            bufferedSource = null;
        }
        if (E != null) {
            try {
                E.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.a(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.m(bufferedSource);
            return ZipKt.i(bufferedSource, fileMetadata);
        }
        throw th;
    }

    @NotNull
    public FileHandle E(@NotNull Path path) {
        Intrinsics.p(path, Annotation.k3);
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @NotNull
    public FileHandle G(@NotNull Path path, boolean z, boolean z2) {
        Intrinsics.p(path, Annotation.k3);
        throw new IOException("zip entries are not writable");
    }

    @NotNull
    public Sink J(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Annotation.k3);
        throw new IOException("zip file systems are read-only");
    }

    @NotNull
    public Source L(@NotNull Path path) throws IOException {
        BufferedSource bufferedSource;
        Intrinsics.p(path, Cookie2.PATH);
        ZipEntry zipEntry = this.f31416g.get(N(path));
        if (zipEntry != null) {
            FileHandle E = this.f31415f.E(this.f31414e);
            Throwable th = null;
            try {
                bufferedSource = Okio.e(E.I(zipEntry.h()));
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedSource = null;
                th = th3;
            }
            if (E != null) {
                try {
                    E.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.a(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.m(bufferedSource);
                ZipKt.l(bufferedSource);
                return zipEntry.e() == 0 ? new FixedLengthSource(bufferedSource, zipEntry.i(), true) : new FixedLengthSource(new InflaterSource((Source) new FixedLengthSource(bufferedSource, zipEntry.d(), true), new Inflater(true)), zipEntry.i(), false);
            }
            throw th;
        }
        throw new FileNotFoundException(Intrinsics.C("no such file: ", path));
    }

    @NotNull
    public Sink e(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Annotation.k3);
        throw new IOException("zip file systems are read-only");
    }

    public void g(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        throw new IOException("zip file systems are read-only");
    }

    @NotNull
    public Path h(@NotNull Path path) {
        Intrinsics.p(path, Cookie2.PATH);
        return N(path);
    }

    public void n(@NotNull Path path, boolean z) {
        Intrinsics.p(path, HTML.Attribute.u);
        throw new IOException("zip file systems are read-only");
    }

    public void p(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        throw new IOException("zip file systems are read-only");
    }

    public void r(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Cookie2.PATH);
        throw new IOException("zip file systems are read-only");
    }

    @NotNull
    public List<Path> x(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        List<Path> O = O(path, true);
        Intrinsics.m(O);
        return O;
    }

    @Nullable
    public List<Path> y(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        return O(path, false);
    }
}
