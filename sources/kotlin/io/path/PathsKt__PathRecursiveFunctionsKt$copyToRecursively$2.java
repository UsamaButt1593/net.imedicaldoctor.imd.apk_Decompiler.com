package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/io/path/CopyActionContext;", "Ljava/nio/file/Path;", "src", "dst", "Lkotlin/io/path/CopyActionResult;", "b", "(Lkotlin/io/path/CopyActionContext;Ljava/nio/file/Path;Ljava/nio/file/Path;)Lkotlin/io/path/CopyActionResult;"}, k = 3, mv = {1, 9, 0})
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2 extends Lambda implements Function3<CopyActionContext, Path, Path, CopyActionResult> {
    final /* synthetic */ boolean X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(boolean z) {
        super(3);
        this.X = z;
    }

    public /* bridge */ /* synthetic */ Object A(Object obj, Object obj2, Object obj3) {
        return b((CopyActionContext) obj, C0507e.a(obj2), C0507e.a(obj3));
    }

    @NotNull
    public final CopyActionResult b(@NotNull CopyActionContext copyActionContext, @NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(copyActionContext, "$this$copyToRecursively");
        Intrinsics.p(path, "src");
        Intrinsics.p(path2, "dst");
        LinkOption[] a2 = LinkFollowing.f28888a.a(this.X);
        boolean a3 = Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(a2, a2.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !a3) {
            if (a3) {
                PathsKt__PathRecursiveFunctionsKt.R(path2);
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.b(a2);
            spreadBuilder.a(StandardCopyOption.REPLACE_EXISTING);
            CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.d(new CopyOption[spreadBuilder.c()]);
            Intrinsics.o(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(this, target, *options)");
        }
        return CopyActionResult.CONTINUE;
    }
}
