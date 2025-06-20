package kotlin.io.path;

import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001By\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0015R(\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R(\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onPreVisitDirectory", "onVisitFile", "Ljava/io/IOException;", "onVisitFileFailed", "onPostVisitDirectory", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "dir", "attrs", "b", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", "file", "c", "exc", "d", "(Ljava/nio/file/Path;Ljava/io/IOException;)Ljava/nio/file/FileVisitResult;", "a", "Lkotlin/jvm/functions/Function2;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Function2<Path, BasicFileAttributes, FileVisitResult> f28884a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Function2<Path, BasicFileAttributes, FileVisitResult> f28885b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Function2<Path, IOException, FileVisitResult> f28886c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Function2<Path, IOException, FileVisitResult> f28887d;

    public FileVisitorImpl(@Nullable Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2, @Nullable Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function22, @Nullable Function2<? super Path, ? super IOException, ? extends FileVisitResult> function23, @Nullable Function2<? super Path, ? super IOException, ? extends FileVisitResult> function24) {
        this.f28884a = function2;
        this.f28885b = function22;
        this.f28886c = function23;
        this.f28887d = function24;
    }

    @NotNull
    public FileVisitResult a(@NotNull Path path, @Nullable IOException iOException) {
        FileVisitResult a2;
        Intrinsics.p(path, HTML.Attribute.u);
        Function2<Path, IOException, FileVisitResult> function2 = this.f28887d;
        if (function2 != null && (a2 = C0527o.a(function2.d0(path, iOException))) != null) {
            return a2;
        }
        FileVisitResult postVisitDirectory = super.postVisitDirectory(path, iOException);
        Intrinsics.o(postVisitDirectory, "super.postVisitDirectory(dir, exc)");
        return postVisitDirectory;
    }

    @NotNull
    public FileVisitResult b(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
        FileVisitResult a2;
        Intrinsics.p(path, HTML.Attribute.u);
        Intrinsics.p(basicFileAttributes, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.f28884a;
        if (function2 != null && (a2 = C0527o.a(function2.d0(path, basicFileAttributes))) != null) {
            return a2;
        }
        FileVisitResult preVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        Intrinsics.o(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return preVisitDirectory;
    }

    @NotNull
    public FileVisitResult c(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
        FileVisitResult a2;
        Intrinsics.p(path, Annotation.k3);
        Intrinsics.p(basicFileAttributes, "attrs");
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.f28885b;
        if (function2 != null && (a2 = C0527o.a(function2.d0(path, basicFileAttributes))) != null) {
            return a2;
        }
        FileVisitResult visitFile = super.visitFile(path, basicFileAttributes);
        Intrinsics.o(visitFile, "super.visitFile(file, attrs)");
        return visitFile;
    }

    @NotNull
    public FileVisitResult d(@NotNull Path path, @NotNull IOException iOException) {
        FileVisitResult a2;
        Intrinsics.p(path, Annotation.k3);
        Intrinsics.p(iOException, "exc");
        Function2<Path, IOException, FileVisitResult> function2 = this.f28886c;
        if (function2 != null && (a2 = C0527o.a(function2.d0(path, iOException))) != null) {
            return a2;
        }
        FileVisitResult visitFileFailed = super.visitFileFailed(path, iOException);
        Intrinsics.o(visitFileFailed, "super.visitFileFailed(file, exc)");
        return visitFileFailed;
    }

    public /* bridge */ /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
        return a(C0507e.a(obj), iOException);
    }

    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return b(C0507e.a(obj), basicFileAttributes);
    }

    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return c(C0507e.a(obj), basicFileAttributes);
    }

    public /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object obj, IOException iOException) {
        return d(C0507e.a(obj), iOException);
    }
}
