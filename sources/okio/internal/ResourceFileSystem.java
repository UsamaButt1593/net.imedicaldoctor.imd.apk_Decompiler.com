package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 52\u00020\u0001:\u00016B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010%J\u001f\u0010(\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020'2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020'2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010)J\u001f\u0010/\u001a\u00020'2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u0010-R-\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b000\u00118BX\u0002¢\u0006\f\n\u0004\b&\u00101\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "classLoader", "", "indexEagerly", "<init>", "(Ljava/lang/ClassLoader;Z)V", "Lokio/Path;", "path", "O", "(Lokio/Path;)Lokio/Path;", "", "Q", "(Lokio/Path;)Ljava/lang/String;", "h", "dir", "", "x", "(Lokio/Path;)Ljava/util/List;", "y", "file", "Lokio/FileHandle;", "E", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "G", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/FileMetadata;", "D", "(Lokio/Path;)Lokio/FileMetadata;", "Lokio/Source;", "L", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "J", "(Lokio/Path;Z)Lokio/Sink;", "e", "", "n", "(Lokio/Path;Z)V", "source", "target", "g", "(Lokio/Path;Lokio/Path;)V", "r", "p", "Lkotlin/Pair;", "Lkotlin/Lazy;", "P", "()Ljava/util/List;", "roots", "f", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class ResourceFileSystem extends FileSystem {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f31425f = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final Path f31426g = Path.Companion.h(Path.X, "/", false, 1, (Object) null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f31427e;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "<init>", "()V", "Lokio/Path;", "path", "", "c", "(Lokio/Path;)Z", "base", "d", "(Lokio/Path;Lokio/Path;)Lokio/Path;", "Ljava/lang/ClassLoader;", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "e", "(Ljava/lang/ClassLoader;)Ljava/util/List;", "Ljava/net/URL;", "f", "(Ljava/net/URL;)Lkotlin/Pair;", "g", "ROOT", "Lokio/Path;", "b", "()Lokio/Path;", "okio"}, k = 1, mv = {1, 5, 1})
    private static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean c(Path path) {
            return !StringsKt.I1(path.p(), ".class", true);
        }

        @NotNull
        public final Path b() {
            return ResourceFileSystem.f31426g;
        }

        @NotNull
        public final Path d(@NotNull Path path, @NotNull Path path2) {
            Intrinsics.p(path, "<this>");
            Intrinsics.p(path2, "base");
            return b().v(StringsKt.h2(StringsKt.a4(path.toString(), path2.toString()), ASCIIPropertyListParser.p, '/', false, 4, (Object) null));
        }

        @NotNull
        public final List<Pair<FileSystem, Path>> e(@NotNull ClassLoader classLoader) {
            Intrinsics.p(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            Intrinsics.o(resources, "getResources(\"\")");
            ArrayList<T> list = Collections.list(resources);
            Intrinsics.o(list, "java.util.Collections.list(this)");
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                Companion M = ResourceFileSystem.f31425f;
                Intrinsics.o(t, "it");
                Pair<FileSystem, Path> f2 = M.f(t);
                if (f2 != null) {
                    arrayList.add(f2);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            Intrinsics.o(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<T> list2 = Collections.list(resources2);
            Intrinsics.o(list2, "java.util.Collections.list(this)");
            ArrayList arrayList2 = new ArrayList();
            for (T t2 : list2) {
                Companion M2 = ResourceFileSystem.f31425f;
                Intrinsics.o(t2, "it");
                Pair<FileSystem, Path> g2 = M2.g(t2);
                if (g2 != null) {
                    arrayList2.add(g2);
                }
            }
            return CollectionsKt.A4(arrayList, arrayList2);
        }

        @Nullable
        public final Pair<FileSystem, Path> f(@NotNull URL url) {
            Intrinsics.p(url, "<this>");
            if (!Intrinsics.g(url.getProtocol(), Annotation.k3)) {
                return null;
            }
            return TuplesKt.a(FileSystem.f31365b, Path.Companion.g(Path.X, new File(url.toURI()), false, 1, (Object) null));
        }

        @Nullable
        public final Pair<FileSystem, Path> g(@NotNull URL url) {
            int D3;
            Intrinsics.p(url, "<this>");
            String url2 = url.toString();
            Intrinsics.o(url2, "toString()");
            if (!StringsKt.s2(url2, "jar:file:", false, 2, (Object) null) || (D3 = StringsKt.D3(url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.X;
            String substring = url2.substring(4, D3);
            Intrinsics.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return TuplesKt.a(ZipKt.d(Path.Companion.g(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.f31365b, ResourceFileSystem$Companion$toJarRoot$zip$1.X), b());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ResourceFileSystem(@NotNull ClassLoader classLoader, boolean z) {
        Intrinsics.p(classLoader, "classLoader");
        this.f31427e = LazyKt.c(new ResourceFileSystem$roots$2(classLoader));
        if (z) {
            P().size();
        }
    }

    private final Path O(Path path) {
        return f31426g.A(path, true);
    }

    private final List<Pair<FileSystem, Path>> P() {
        return (List) this.f31427e.getValue();
    }

    private final String Q(Path path) {
        return O(path).u(f31426g).toString();
    }

    @Nullable
    public FileMetadata D(@NotNull Path path) {
        Intrinsics.p(path, Cookie2.PATH);
        if (!f31425f.c(path)) {
            return null;
        }
        String Q = Q(path);
        for (Pair next : P()) {
            FileMetadata D = ((FileSystem) next.a()).D(((Path) next.b()).v(Q));
            if (D != null) {
                return D;
            }
        }
        return null;
    }

    @NotNull
    public FileHandle E(@NotNull Path path) {
        Intrinsics.p(path, Annotation.k3);
        if (f31425f.c(path)) {
            String Q = Q(path);
            for (Pair next : P()) {
                try {
                    return ((FileSystem) next.a()).E(((Path) next.b()).v(Q));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException(Intrinsics.C("file not found: ", path));
        }
        throw new FileNotFoundException(Intrinsics.C("file not found: ", path));
    }

    @NotNull
    public FileHandle G(@NotNull Path path, boolean z, boolean z2) {
        Intrinsics.p(path, Annotation.k3);
        throw new IOException("resources are not writable");
    }

    @NotNull
    public Sink J(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Annotation.k3);
        throw new IOException(this + " is read-only");
    }

    @NotNull
    public Source L(@NotNull Path path) {
        Intrinsics.p(path, Annotation.k3);
        if (f31425f.c(path)) {
            String Q = Q(path);
            for (Pair next : P()) {
                try {
                    return ((FileSystem) next.a()).L(((Path) next.b()).v(Q));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException(Intrinsics.C("file not found: ", path));
        }
        throw new FileNotFoundException(Intrinsics.C("file not found: ", path));
    }

    @NotNull
    public Sink e(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Annotation.k3);
        throw new IOException(this + " is read-only");
    }

    public void g(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        throw new IOException(this + " is read-only");
    }

    @NotNull
    public Path h(@NotNull Path path) {
        Intrinsics.p(path, Cookie2.PATH);
        return O(path);
    }

    public void n(@NotNull Path path, boolean z) {
        Intrinsics.p(path, HTML.Attribute.u);
        throw new IOException(this + " is read-only");
    }

    public void p(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        throw new IOException(this + " is read-only");
    }

    public void r(@NotNull Path path, boolean z) {
        Intrinsics.p(path, Cookie2.PATH);
        throw new IOException(this + " is read-only");
    }

    @NotNull
    public List<Path> x(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        String Q = Q(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair next : P()) {
            FileSystem fileSystem = (FileSystem) next.a();
            Path path2 = (Path) next.b();
            try {
                List<Path> x = fileSystem.x(path2.v(Q));
                ArrayList<Path> arrayList = new ArrayList<>();
                for (T next2 : x) {
                    if (f31425f.c((Path) next2)) {
                        arrayList.add(next2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(arrayList, 10));
                for (Path d2 : arrayList) {
                    arrayList2.add(f31425f.d(d2, path2));
                }
                CollectionsKt.n0(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt.S5(linkedHashSet);
        }
        throw new FileNotFoundException(Intrinsics.C("file not found: ", path));
    }

    @Nullable
    public List<Path> y(@NotNull Path path) {
        Intrinsics.p(path, HTML.Attribute.u);
        String Q = Q(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it2 = P().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it2.hasNext()) {
                break;
            }
            Pair next = it2.next();
            Path path2 = (Path) next.b();
            List<Path> y = ((FileSystem) next.a()).y(path2.v(Q));
            if (y != null) {
                ArrayList<Path> arrayList2 = new ArrayList<>();
                for (T next2 : y) {
                    if (f31425f.c((Path) next2)) {
                        arrayList2.add(next2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.Y(arrayList2, 10));
                for (Path d2 : arrayList2) {
                    arrayList3.add(f31425f.d(d2, path2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                CollectionsKt.n0(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (z) {
            return CollectionsKt.S5(linkedHashSet);
        }
        return null;
    }
}
