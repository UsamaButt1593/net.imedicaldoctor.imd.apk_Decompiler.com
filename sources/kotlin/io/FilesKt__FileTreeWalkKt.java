package kotlin.io;

import com.itextpdf.tool.xml.css.CSS;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Lkotlin/io/FileTreeWalk;", "J", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)Lkotlin/io/FileTreeWalk;", "M", "(Ljava/io/File;)Lkotlin/io/FileTreeWalk;", "L", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    @NotNull
    public static final FileTreeWalk J(@NotNull File file, @NotNull FileWalkDirection fileWalkDirection) {
        Intrinsics.p(file, "<this>");
        Intrinsics.p(fileWalkDirection, CSS.Property.K0);
        return new FileTreeWalk(file, fileWalkDirection);
    }

    public static /* synthetic */ FileTreeWalk K(File file, FileWalkDirection fileWalkDirection, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return J(file, fileWalkDirection);
    }

    @NotNull
    public static final FileTreeWalk L(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        return J(file, FileWalkDirection.BOTTOM_UP);
    }

    @NotNull
    public static final FileTreeWalk M(@NotNull File file) {
        Intrinsics.p(file, "<this>");
        return J(file, FileWalkDirection.TOP_DOWN);
    }
}
