package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n1#1,80:1\n43#1,3:81\n*S KotlinDebug\n*F\n+ 1 Path.kt\nandroidx/core/graphics/PathKt\n*L\n60#1:81,3\n*E\n"})
@SuppressLint({"ClassVerificationFailure"})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\n\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\n¢\u0006\u0004\b\n\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\f¢\u0006\u0004\b\u000b\u0010\t\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\f¢\u0006\u0004\b\f\u0010\t\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\f¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Landroid/graphics/Path;", "", "error", "", "Landroidx/core/graphics/PathSegment;", "b", "(Landroid/graphics/Path;F)Ljava/lang/Iterable;", "p", "f", "(Landroid/graphics/Path;Landroid/graphics/Path;)Landroid/graphics/Path;", "d", "e", "a", "g", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class PathKt {
    @NotNull
    public static final Path a(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> b(@NotNull Path path, float f2) {
        return PathUtils.b(path, f2);
    }

    public static /* synthetic */ Iterable c(Path path, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return b(path, f2);
    }

    @NotNull
    public static final Path d(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @NotNull
    public static final Path e(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @NotNull
    public static final Path f(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @NotNull
    public static final Path g(@NotNull Path path, @NotNull Path path2) {
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
