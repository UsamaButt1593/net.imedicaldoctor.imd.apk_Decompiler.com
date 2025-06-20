package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/File;", "f", "Ljava/io/IOException;", "e", "", "b", "(Ljava/io/File;Ljava/io/IOException;)V"}, k = 3, mv = {1, 9, 0})
final class FilesKt__UtilsKt$copyRecursively$2 extends Lambda implements Function2<File, IOException, Unit> {
    final /* synthetic */ Function2<File, IOException, OnErrorAction> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilesKt__UtilsKt$copyRecursively$2(Function2<? super File, ? super IOException, ? extends OnErrorAction> function2) {
        super(2);
        this.X = function2;
    }

    public final void b(@NotNull File file, @NotNull IOException iOException) {
        Intrinsics.p(file, "f");
        Intrinsics.p(iOException, "e");
        if (this.X.d0(file, iOException) == OnErrorAction.TERMINATE) {
            throw new TerminateException(file);
        }
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        b((File) obj, (IOException) obj2);
        return Unit.f28779a;
    }
}
