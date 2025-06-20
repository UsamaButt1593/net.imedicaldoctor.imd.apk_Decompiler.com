package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Ljava/nio/file/Path;", "<anonymous parameter 0>", "<anonymous parameter 1>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "b", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/lang/Void;"}, k = 3, mv = {1, 9, 0})
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1 extends Lambda implements Function3 {
    public static final PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1 X = new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1();

    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object A(Object obj, Object obj2, Object obj3) {
        return b(C0507e.a(obj), C0507e.a(obj2), (Exception) obj3);
    }

    @NotNull
    public final Void b(@NotNull Path path, @NotNull Path path2, @NotNull Exception exc) {
        Intrinsics.p(path, "<anonymous parameter 0>");
        Intrinsics.p(path2, "<anonymous parameter 1>");
        Intrinsics.p(exc, "exception");
        throw exc;
    }
}
