package kotlin.io.path;

import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/DirectoryEntriesReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlin/io/path/DirectoryEntriesReader;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "", "followLinks", "<init>", "(Z)V", "Lkotlin/io/path/PathNode;", "directoryNode", "", "c", "(Lkotlin/io/path/PathNode;)Ljava/util/List;", "dir", "Ljava/nio/file/attribute/BasicFileAttributes;", "attrs", "Ljava/nio/file/FileVisitResult;", "b", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", "file", "d", "a", "Z", "()Z", "Lkotlin/io/path/PathNode;", "Lkotlin/collections/ArrayDeque;", "Lkotlin/collections/ArrayDeque;", "entries", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
final class DirectoryEntriesReader extends SimpleFileVisitor<Path> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28872a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private PathNode f28873b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private ArrayDeque<PathNode> f28874c = new ArrayDeque<>();

    public DirectoryEntriesReader(boolean z) {
        this.f28872a = z;
    }

    public final boolean a() {
        return this.f28872a;
    }

    @NotNull
    public FileVisitResult b(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
        Intrinsics.p(path, HTML.Attribute.u);
        Intrinsics.p(basicFileAttributes, "attrs");
        this.f28874c.add(new PathNode(path, basicFileAttributes.fileKey(), this.f28873b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        Intrinsics.o(preVisitDirectory, "super.preVisitDirectory(dir, attrs)");
        return preVisitDirectory;
    }

    @NotNull
    public final List<PathNode> c(@NotNull PathNode pathNode) {
        Intrinsics.p(pathNode, "directoryNode");
        this.f28873b = pathNode;
        Path unused = Files.walkFileTree(pathNode.d(), LinkFollowing.f28888a.b(this.f28872a), 1, C0509f.a(this));
        this.f28874c.removeFirst();
        ArrayDeque<PathNode> arrayDeque = this.f28874c;
        this.f28874c = new ArrayDeque<>();
        return arrayDeque;
    }

    @NotNull
    public FileVisitResult d(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) {
        Intrinsics.p(path, Annotation.k3);
        Intrinsics.p(basicFileAttributes, "attrs");
        this.f28874c.add(new PathNode(path, (Object) null, this.f28873b));
        FileVisitResult visitFile = super.visitFile(path, basicFileAttributes);
        Intrinsics.o(visitFile, "super.visitFile(file, attrs)");
        return visitFile;
    }

    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return b(C0507e.a(obj), basicFileAttributes);
    }

    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return d(C0507e.a(obj), basicFileAttributes);
    }
}
