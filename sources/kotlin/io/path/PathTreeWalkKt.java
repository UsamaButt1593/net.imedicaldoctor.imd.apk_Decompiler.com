package kotlin.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljava/nio/file/Path;", "path", "", "Ljava/nio/file/LinkOption;", "linkOptions", "", "d", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "Lkotlin/io/path/PathNode;", "", "c", "(Lkotlin/io/path/PathNode;)Z", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0})
public final class PathTreeWalkKt {
    /* access modifiers changed from: private */
    public static final boolean c(PathNode pathNode) {
        for (PathNode c2 = pathNode.c(); c2 != null; c2 = c2.c()) {
            if (c2.b() == null || pathNode.b() == null) {
                try {
                    if (Files.isSameFile(c2.d(), pathNode.d())) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (Intrinsics.g(c2.b(), pathNode.b())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes a2 = Files.readAttributes(path, A.a(), (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            Intrinsics.o(a2, "readAttributes(this, A::class.java, *options)");
            return a2.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
