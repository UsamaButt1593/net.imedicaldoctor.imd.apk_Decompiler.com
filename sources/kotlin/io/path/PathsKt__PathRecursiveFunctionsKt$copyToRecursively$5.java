package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/io/path/FileVisitorBuilder;", "", "b", "(Lkotlin/io/path/FileVisitorBuilder;)V"}, k = 3, mv = {1, 9, 0})
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5 extends Lambda implements Function1<FileVisitorBuilder, Unit> {
    final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> X;
    final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> X2;
    final /* synthetic */ Path Y;
    final /* synthetic */ Path Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32) {
        super(1);
        this.X = function3;
        this.Y = path;
        this.Z = path2;
        this.X2 = function32;
    }

    public final void b(@NotNull FileVisitorBuilder fileVisitorBuilder) {
        Intrinsics.p(fileVisitorBuilder, "$this$visitFileTree");
        final Function3<CopyActionContext, Path, Path, CopyActionResult> function3 = this.X;
        final Path path = this.Y;
        final Path path2 = this.Z;
        final Function3<Path, Path, Exception, OnErrorResult> function32 = this.X2;
        fileVisitorBuilder.b(new Function2<Path, BasicFileAttributes, FileVisitResult>() {
            @NotNull
            public final FileVisitResult D0(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
                Intrinsics.p(path, "p0");
                Intrinsics.p(basicFileAttributes, "p1");
                return PathsKt__PathRecursiveFunctionsKt.M(function3, path, path2, function32, path, basicFileAttributes);
            }

            public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
                return D0(C0507e.a(obj), C0524m0.a(obj2));
            }
        });
        final Function3<CopyActionContext, Path, Path, CopyActionResult> function33 = this.X;
        final Path path3 = this.Y;
        final Path path4 = this.Z;
        final Function3<Path, Path, Exception, OnErrorResult> function34 = this.X2;
        fileVisitorBuilder.a(new Function2<Path, BasicFileAttributes, FileVisitResult>() {
            @NotNull
            public final FileVisitResult D0(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
                Intrinsics.p(path, "p0");
                Intrinsics.p(basicFileAttributes, "p1");
                return PathsKt__PathRecursiveFunctionsKt.M(function33, path3, path4, function34, path, basicFileAttributes);
            }

            public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
                return D0(C0507e.a(obj), C0524m0.a(obj2));
            }
        });
        final Function3<Path, Path, Exception, OnErrorResult> function35 = this.X2;
        final Path path5 = this.Y;
        final Path path6 = this.Z;
        fileVisitorBuilder.d(new Function2<Path, Exception, FileVisitResult>() {
            @NotNull
            public final FileVisitResult D0(@NotNull Path path, @NotNull Exception exc) {
                Intrinsics.p(path, "p0");
                Intrinsics.p(exc, "p1");
                return PathsKt__PathRecursiveFunctionsKt.Q(function35, path5, path6, path, exc);
            }

            public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
                return D0(C0507e.a(obj), (Exception) obj2);
            }
        });
        final Function3<Path, Path, Exception, OnErrorResult> function36 = this.X2;
        final Path path7 = this.Y;
        final Path path8 = this.Z;
        fileVisitorBuilder.c(new Function2<Path, IOException, FileVisitResult>() {
            @NotNull
            public final FileVisitResult b(@NotNull Path path, @Nullable IOException iOException) {
                Intrinsics.p(path, "directory");
                return iOException == null ? FileVisitResult.CONTINUE : PathsKt__PathRecursiveFunctionsKt.Q(function36, path7, path8, path, iOException);
            }

            public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
                return b(C0507e.a(obj), (IOException) obj2);
            }
        });
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((FileVisitorBuilder) obj);
        return Unit.f28779a;
    }
}
