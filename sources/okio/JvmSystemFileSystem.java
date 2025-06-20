package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000b*\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010%J\u001f\u0010'\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010(J\u001f\u0010.\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010,J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101¨\u00062"}, d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "<init>", "()V", "Lokio/Path;", "dir", "", "throwOnFailure", "", "M", "(Lokio/Path;Z)Ljava/util/List;", "", "O", "(Lokio/Path;)V", "N", "path", "h", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "D", "(Lokio/Path;)Lokio/FileMetadata;", "x", "(Lokio/Path;)Ljava/util/List;", "y", "file", "Lokio/FileHandle;", "E", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "G", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "L", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "J", "(Lokio/Path;Z)Lokio/Sink;", "e", "n", "(Lokio/Path;Z)V", "source", "target", "g", "(Lokio/Path;Lokio/Path;)V", "r", "p", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 5, 1})
public class JvmSystemFileSystem extends FileSystem {
    private final List<Path> M(Path path, boolean z) {
        File F = path.F();
        String[] list = F.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                Intrinsics.o(str, "it");
                arrayList.add(path.v(str));
            }
            CollectionsKt.j0(arrayList);
            return arrayList;
        } else if (!z) {
            return null;
        } else {
            if (!F.exists()) {
                throw new FileNotFoundException(Intrinsics.C("no such file: ", path));
            }
            throw new IOException(Intrinsics.C("failed to list ", path));
        }
    }

    private final void N(Path path) {
        if (w(path)) {
            throw new IOException(path + " already exists.");
        }
    }

    private final void O(Path path) {
        if (!w(path)) {
            throw new IOException(path + " doesn't exist.");
        }
    }

    @Nullable
    public FileMetadata D(@NotNull Path path) {
        Intrinsics.p(path, Cookie2.PATH);
        File F = path.F();
        boolean isFile = F.isFile();
        boolean isDirectory = F.isDirectory();
        long lastModified = F.lastModified();
        long length = F.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !F.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, (Path) null, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null, (Map) null, 128, (DefaultConstructorMarker) null);
    }

    @NotNull
    public FileHandle E(@NotNull Path path) {
        Intrinsics.p(path, Annotation.k3);
        return new JvmFileHandle(false, new RandomAccessFile(path.F(), "r"));
    }

    @NotNull
    public FileHandle G(@NotNull Path path, boolean z, boolean z2) {
        Intrinsics.p(path, Annotation.k3);
        if (!z || !z2) {
            if (z) {
                N(path);
            }
            if (z2) {
                O(path);
            }
            return new JvmFileHandle(true, new RandomAccessFile(path.F(), "rw"));
        }
        throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
    }

    @NotNull
    public Sink J(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Annotation.k3);
        if (z) {
            N(path);
        }
        return Okio__JvmOkioKt.q(path.F(), false, 1, (Object) null);
    }

    @NotNull
    public Source L(@NotNull Path path) {
        Intrinsics.p(path, Annotation.k3);
        return Okio.t(path.F());
    }

    @NotNull
    public Sink e(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Annotation.k3);
        if (z) {
            O(path);
        }
        return Okio.o(path.F(), true);
    }

    public void g(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        if (!path.F().renameTo(path2.F())) {
            throw new IOException("failed to move " + path + " to " + path2);
        }
    }

    @NotNull
    public Path h(@NotNull Path path) {
        Intrinsics.p(path, Cookie2.PATH);
        File canonicalFile = path.F().getCanonicalFile();
        if (canonicalFile.exists()) {
            Path.Companion companion = Path.X;
            Intrinsics.o(canonicalFile, "canonicalFile");
            return Path.Companion.g(companion, canonicalFile, false, 1, (Object) null);
        }
        throw new FileNotFoundException("no such file");
    }

    public void n(@NotNull Path path, boolean z) {
        Intrinsics.p(path, HTML.Attribute.u);
        if (!path.F().mkdir()) {
            FileMetadata D = D(path);
            if (D == null || !D.j()) {
                throw new IOException(Intrinsics.C("failed to create directory: ", path));
            } else if (z) {
                throw new IOException(path + " already exist.");
            }
        }
    }

    public void p(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        throw new IOException("unsupported");
    }

    public void r(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Cookie2.PATH);
        File F = path.F();
        if (F.delete()) {
            return;
        }
        if (F.exists()) {
            throw new IOException(Intrinsics.C("failed to delete ", path));
        } else if (z) {
            throw new FileNotFoundException(Intrinsics.C("no such file: ", path));
        }
    }

    @NotNull
    public String toString() {
        return "JvmSystemFileSystem";
    }

    @NotNull
    public List<Path> x(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        List<Path> M = M(path, true);
        Intrinsics.m(M);
        return M;
    }

    @Nullable
    public List<Path> y(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        return M(path, false);
    }
}
