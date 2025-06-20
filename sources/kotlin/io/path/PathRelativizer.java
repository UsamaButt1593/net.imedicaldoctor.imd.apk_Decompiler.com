package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "<init>", "()V", "Ljava/nio/file/Path;", "path", "base", "a", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "b", "Ljava/nio/file/Path;", "emptyPath", "c", "parentPath", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
final class PathRelativizer {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final PathRelativizer f28897a = new PathRelativizer();

    /* renamed from: b  reason: collision with root package name */
    private static final Path f28898b = Paths.get("", new String[0]);

    /* renamed from: c  reason: collision with root package name */
    private static final Path f28899c = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }

    @NotNull
    public final Path a(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, Cookie2.PATH);
        Intrinsics.p(path2, "base");
        Path a2 = path2.normalize();
        Path a3 = path.normalize();
        Path a4 = a2.relativize(a3);
        int min = Math.min(a2.getNameCount(), a3.getNameCount());
        int i2 = 0;
        while (i2 < min) {
            Path a5 = a2.getName(i2);
            Path path3 = f28899c;
            if (!Intrinsics.g(a5, path3)) {
                break;
            } else if (Intrinsics.g(a3.getName(i2), path3)) {
                i2++;
            } else {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (Intrinsics.g(a3, a2) || !Intrinsics.g(a2, f28898b)) {
            String obj = a4.toString();
            String a6 = a4.getFileSystem().getSeparator();
            Intrinsics.o(a6, "rn.fileSystem.separator");
            a3 = StringsKt.J1(obj, a6, false, 2, (Object) null) ? a4.getFileSystem().getPath(StringsKt.A6(obj, a4.getFileSystem().getSeparator().length()), new String[0]) : a4;
        }
        Intrinsics.o(a3, "r");
        return a3;
    }
}
