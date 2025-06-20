package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b+\u0010*J\u001f\u0010-\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b3\u0010.J\u001f\u00104\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u00102J\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u00106R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "<init>", "(Lokio/FileSystem;)V", "Lokio/Path;", "path", "", "functionName", "parameterName", "N", "(Lokio/Path;Ljava/lang/String;Ljava/lang/String;)Lokio/Path;", "O", "(Lokio/Path;Ljava/lang/String;)Lokio/Path;", "h", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "D", "(Lokio/Path;)Lokio/FileMetadata;", "dir", "", "x", "(Lokio/Path;)Ljava/util/List;", "y", "", "followSymlinks", "Lkotlin/sequences/Sequence;", "A", "(Lokio/Path;Z)Lkotlin/sequences/Sequence;", "file", "Lokio/FileHandle;", "E", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "G", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "L", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "J", "(Lokio/Path;Z)Lokio/Sink;", "e", "", "n", "(Lokio/Path;Z)V", "source", "target", "g", "(Lokio/Path;Lokio/Path;)V", "r", "p", "toString", "()Ljava/lang/String;", "Lokio/FileSystem;", "M", "()Lokio/FileSystem;", "okio"}, k = 1, mv = {1, 5, 1})
public abstract class ForwardingFileSystem extends FileSystem {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final FileSystem f31368e;

    public ForwardingFileSystem(@NotNull FileSystem fileSystem) {
        Intrinsics.p(fileSystem, "delegate");
        this.f31368e = fileSystem;
    }

    @NotNull
    public Sequence<Path> A(@NotNull Path path, boolean z) {
        Intrinsics.p(path, HTML.Attribute.u);
        return SequencesKt.k1(this.f31368e.A(N(path, "listRecursively", HTML.Attribute.u), z), new ForwardingFileSystem$listRecursively$1(this));
    }

    @Nullable
    public FileMetadata D(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Cookie2.PATH);
        FileMetadata D = this.f31368e.D(N(path, "metadataOrNull", Cookie2.PATH));
        if (D == null) {
            return null;
        }
        return D.i() == null ? D : FileMetadata.b(D, false, false, O(D.i(), "metadataOrNull"), (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 251, (Object) null);
    }

    @NotNull
    public FileHandle E(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return this.f31368e.E(N(path, "openReadOnly", Annotation.k3));
    }

    @NotNull
    public FileHandle G(@NotNull Path path, boolean z, boolean z2) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return this.f31368e.G(N(path, "openReadWrite", Annotation.k3), z, z2);
    }

    @NotNull
    public Sink J(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return this.f31368e.J(N(path, "sink", Annotation.k3), z);
    }

    @NotNull
    public Source L(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return this.f31368e.L(N(path, "source", Annotation.k3));
    }

    @NotNull
    @JvmName(name = "delegate")
    public final FileSystem M() {
        return this.f31368e;
    }

    @NotNull
    public Path N(@NotNull Path path, @NotNull String str, @NotNull String str2) {
        Intrinsics.p(path, Cookie2.PATH);
        Intrinsics.p(str, "functionName");
        Intrinsics.p(str2, "parameterName");
        return path;
    }

    @NotNull
    public Path O(@NotNull Path path, @NotNull String str) {
        Intrinsics.p(path, Cookie2.PATH);
        Intrinsics.p(str, "functionName");
        return path;
    }

    @NotNull
    public Sink e(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(path, Annotation.k3);
        return this.f31368e.e(N(path, "appendingSink", Annotation.k3), z);
    }

    public void g(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        this.f31368e.g(N(path, "atomicMove", "source"), N(path2, "atomicMove", TypedValues.AttributesType.M));
    }

    @NotNull
    public Path h(@NotNull Path path) throws IOException {
        Intrinsics.p(path, Cookie2.PATH);
        return O(this.f31368e.h(N(path, "canonicalize", Cookie2.PATH)), "canonicalize");
    }

    public void n(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(path, HTML.Attribute.u);
        this.f31368e.n(N(path, "createDirectory", HTML.Attribute.u), z);
    }

    public void p(@NotNull Path path, @NotNull Path path2) throws IOException {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        this.f31368e.p(N(path, "createSymlink", "source"), N(path2, "createSymlink", TypedValues.AttributesType.M));
    }

    public void r(@NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(path, Cookie2.PATH);
        this.f31368e.r(N(path, "delete", Cookie2.PATH), z);
    }

    @NotNull
    public String toString() {
        return Reflection.d(getClass()).K() + ASCIIPropertyListParser.f18649g + this.f31368e + ASCIIPropertyListParser.f18650h;
    }

    @NotNull
    public List<Path> x(@NotNull Path path) throws IOException {
        Intrinsics.p(path, HTML.Attribute.u);
        List<Path> x = this.f31368e.x(N(path, "list", HTML.Attribute.u));
        ArrayList arrayList = new ArrayList();
        for (Path O : x) {
            arrayList.add(O(O, "list"));
        }
        CollectionsKt.j0(arrayList);
        return arrayList;
    }

    @Nullable
    public List<Path> y(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        List<Path> y = this.f31368e.y(N(path, "listOrNull", HTML.Attribute.u));
        if (y == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Path O : y) {
            arrayList.add(O(O, "listOrNull"));
        }
        CollectionsKt.j0(arrayList);
        return arrayList;
    }
}
