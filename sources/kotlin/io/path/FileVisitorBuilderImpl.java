package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJG\u0010\u0013\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014JG\u0010\u0016\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0014JG\u0010\u0019\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0019\u0010\u0014JI\u0010\u001a\u001a\u00020\u000428\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u000e\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001b¢\u0006\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR*\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR*\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR,\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010$¨\u0006&"}, d2 = {"Lkotlin/io/path/FileVisitorBuilderImpl;", "Lkotlin/io/path/FileVisitorBuilder;", "<init>", "()V", "", "f", "", "function", "", "name", "g", "(Ljava/lang/Object;Ljava/lang/String;)V", "Lkotlin/Function2;", "Ljava/nio/file/Path;", "Lkotlin/ParameterName;", "directory", "Ljava/nio/file/attribute/BasicFileAttributes;", "attributes", "Ljava/nio/file/FileVisitResult;", "b", "(Lkotlin/jvm/functions/Function2;)V", "file", "a", "Ljava/io/IOException;", "exception", "d", "c", "Ljava/nio/file/FileVisitor;", "e", "()Ljava/nio/file/FileVisitor;", "Lkotlin/jvm/functions/Function2;", "onPreVisitDirectory", "onVisitFile", "onVisitFileFailed", "onPostVisitDirectory", "", "Z", "isBuilt", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
@ExperimentalPathApi
public final class FileVisitorBuilderImpl implements FileVisitorBuilder {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f28879a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f28880b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Function2<? super Path, ? super IOException, ? extends FileVisitResult> f28881c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Function2<? super Path, ? super IOException, ? extends FileVisitResult> f28882d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f28883e;

    private final void f() {
        if (this.f28883e) {
            throw new IllegalStateException("This builder was already built");
        }
    }

    private final void g(Object obj, String str) {
        if (obj != null) {
            throw new IllegalStateException(str + " was already defined");
        }
    }

    public void a(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2) {
        Intrinsics.p(function2, "function");
        f();
        g(this.f28880b, "onVisitFile");
        this.f28880b = function2;
    }

    public void b(@NotNull Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2) {
        Intrinsics.p(function2, "function");
        f();
        g(this.f28879a, "onPreVisitDirectory");
        this.f28879a = function2;
    }

    public void c(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2) {
        Intrinsics.p(function2, "function");
        f();
        g(this.f28882d, "onPostVisitDirectory");
        this.f28882d = function2;
    }

    public void d(@NotNull Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2) {
        Intrinsics.p(function2, "function");
        f();
        g(this.f28881c, "onVisitFileFailed");
        this.f28881c = function2;
    }

    @NotNull
    public final FileVisitor<Path> e() {
        f();
        this.f28883e = true;
        return C0509f.a(new FileVisitorImpl(this.f28879a, this.f28880b, this.f28881c, this.f28882d));
    }
}
