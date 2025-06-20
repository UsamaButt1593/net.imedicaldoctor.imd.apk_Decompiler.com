package kotlin.io.path;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000f\u001a\u00020\b2\n\u0010\u000e\u001a\u00060\fj\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R$\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u001a\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u00168\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\n¨\u0006 "}, d2 = {"Lkotlin/io/path/ExceptionsCollector;", "", "", "limit", "<init>", "(I)V", "Ljava/nio/file/Path;", "name", "", "b", "(Ljava/nio/file/Path;)V", "c", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "a", "(Ljava/lang/Exception;)V", "I", "<set-?>", "f", "()I", "totalExceptions", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "collectedExceptions", "Ljava/nio/file/Path;", "e", "()Ljava/nio/file/Path;", "g", "path", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
final class ExceptionsCollector {

    /* renamed from: a  reason: collision with root package name */
    private final int f28875a;

    /* renamed from: b  reason: collision with root package name */
    private int f28876b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<Exception> f28877c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Path f28878d;

    public ExceptionsCollector() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public final void a(@NotNull Exception exc) {
        Intrinsics.p(exc, "exception");
        this.f28876b++;
        if (this.f28877c.size() < this.f28875a) {
            if (this.f28878d != null) {
                C0525n.a();
                Throwable a2 = C0523m.a(String.valueOf(this.f28878d)).initCause(exc);
                Intrinsics.n(a2, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exc = C0521l.a(a2);
            }
            this.f28877c.add(exc);
        }
    }

    public final void b(@NotNull Path path) {
        Intrinsics.p(path, "name");
        Path path2 = this.f28878d;
        this.f28878d = path2 != null ? path2.resolve(path) : null;
    }

    public final void c(@NotNull Path path) {
        Intrinsics.p(path, "name");
        Path path2 = this.f28878d;
        Path path3 = null;
        if (Intrinsics.g(path, path2 != null ? path2.getFileName() : null)) {
            Path path4 = this.f28878d;
            if (path4 != null) {
                path3 = path4.getParent();
            }
            this.f28878d = path3;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public final List<Exception> d() {
        return this.f28877c;
    }

    @Nullable
    public final Path e() {
        return this.f28878d;
    }

    public final int f() {
        return this.f28876b;
    }

    public final void g(@Nullable Path path) {
        this.f28878d = path;
    }

    public ExceptionsCollector(int i2) {
        this.f28875a = i2;
        this.f28877c = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExceptionsCollector(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 64 : i2);
    }
}
