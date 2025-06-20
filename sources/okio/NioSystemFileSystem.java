package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.path.A;
import kotlin.io.path.C0507e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "<init>", "()V", "Ljava/nio/file/attribute/FileTime;", "", "P", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "D", "(Lokio/Path;)Lokio/FileMetadata;", "source", "target", "", "g", "(Lokio/Path;Lokio/Path;)V", "p", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 5, 1})
@IgnoreJRERequirement
public final class NioSystemFileSystem extends JvmSystemFileSystem {
    private final Long P(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    @Nullable
    public FileMetadata D(@NotNull Path path) {
        Intrinsics.p(path, Cookie2.PATH);
        Path G = path.G();
        Long l2 = null;
        try {
            BasicFileAttributes a2 = Files.readAttributes(G, A.a(), new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            Path a3 = c.a(a2) ? Files.readSymbolicLink(G) : C0507e.a((Object) null);
            boolean a4 = a2.isRegularFile();
            boolean a5 = a2.isDirectory();
            Path i2 = a3 == null ? null : Path.Companion.i(Path.X, a3, false, 1, (Object) null);
            Long valueOf = Long.valueOf(a2.size());
            FileTime a6 = a2.creationTime();
            Long P = a6 == null ? null : P(a6);
            FileTime a7 = a2.lastModifiedTime();
            Long P2 = a7 == null ? null : P(a7);
            FileTime a8 = a2.lastAccessTime();
            if (a8 != null) {
                l2 = P(a8);
            }
            return new FileMetadata(a4, a5, i2, valueOf, P, P2, l2, (Map) null, 128, (DefaultConstructorMarker) null);
        } catch (FileSystemException | NoSuchFileException unused) {
            return null;
        }
    }

    public void g(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        try {
            java.nio.file.Path unused = Files.move(path.G(), path2.G(), new CopyOption[]{i.a(StandardCopyOption.ATOMIC_MOVE), i.a(StandardCopyOption.REPLACE_EXISTING)});
        } catch (NoSuchFileException e2) {
            throw new FileNotFoundException(e2.getMessage());
        } catch (UnsupportedOperationException unused2) {
            throw new IOException("atomic move not supported");
        }
    }

    public void p(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        java.nio.file.Path unused = Files.createSymbolicLink(path.G(), path2.G(), new FileAttribute[0]);
    }

    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }
}
