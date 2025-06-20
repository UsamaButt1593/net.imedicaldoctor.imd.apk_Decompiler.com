package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010(\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\b\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/io/path/PathNode;", "", "Ljava/nio/file/Path;", "path", "key", "parent", "<init>", "(Ljava/nio/file/Path;Ljava/lang/Object;Lkotlin/io/path/PathNode;)V", "a", "Ljava/nio/file/Path;", "d", "()Ljava/nio/file/Path;", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "c", "Lkotlin/io/path/PathNode;", "()Lkotlin/io/path/PathNode;", "", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "e", "(Ljava/util/Iterator;)V", "contentIterator", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
final class PathNode {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Path f28893a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Object f28894b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final PathNode f28895c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Iterator<PathNode> f28896d;

    public PathNode(@NotNull Path path, @Nullable Object obj, @Nullable PathNode pathNode) {
        Intrinsics.p(path, Cookie2.PATH);
        this.f28893a = path;
        this.f28894b = obj;
        this.f28895c = pathNode;
    }

    @Nullable
    public final Iterator<PathNode> a() {
        return this.f28896d;
    }

    @Nullable
    public final Object b() {
        return this.f28894b;
    }

    @Nullable
    public final PathNode c() {
        return this.f28895c;
    }

    @NotNull
    public final Path d() {
        return this.f28893a;
    }

    public final void e(@Nullable Iterator<PathNode> it2) {
        this.f28896d = it2;
    }
}
