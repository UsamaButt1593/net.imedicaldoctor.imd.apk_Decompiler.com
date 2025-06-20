package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\r\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001GB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020 H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0013\u0010/\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b.\u0010\u0019R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u0006008F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u0002008F¢\u0006\u0006\u001a\u0004\b4\u00102R\u0011\u00108\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b9\u00107R\u0013\u0010>\u001a\u0004\u0018\u00010;8G¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010@\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b?\u0010-R\u0011\u0010B\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\bA\u0010)R\u0013\u0010C\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b*\u0010\u0019R\u0011\u0010E\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bD\u00107¨\u0006H"}, d2 = {"Lokio/Path;", "", "Lokio/ByteString;", "bytes", "<init>", "(Lokio/ByteString;)V", "", "child", "v", "(Ljava/lang/String;)Lokio/Path;", "x", "(Lokio/ByteString;)Lokio/Path;", "z", "(Lokio/Path;)Lokio/Path;", "", "normalize", "w", "(Ljava/lang/String;Z)Lokio/Path;", "y", "(Lokio/ByteString;Z)Lokio/Path;", "A", "(Lokio/Path;Z)Lokio/Path;", "other", "u", "r", "()Lokio/Path;", "Ljava/io/File;", "F", "()Ljava/io/File;", "Ljava/nio/file/Path;", "G", "()Ljava/nio/file/Path;", "", "a", "(Lokio/Path;)I", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "s", "Lokio/ByteString;", "i", "()Lokio/ByteString;", "j", "root", "", "k", "()Ljava/util/List;", "segments", "l", "segmentsBytes", "m", "()Z", "isAbsolute", "n", "isRelative", "", "H", "()Ljava/lang/Character;", "volumeLetter", "q", "nameBytes", "p", "name", "parent", "o", "isRoot", "X", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class Path implements Comparable<Path> {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final String Y;
    @NotNull
    private final ByteString s;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokio/Path$Companion;", "", "<init>", "()V", "", "", "normalize", "Lokio/Path;", "d", "(Ljava/lang/String;Z)Lokio/Path;", "Ljava/io/File;", "b", "(Ljava/io/File;Z)Lokio/Path;", "Ljava/nio/file/Path;", "f", "(Ljava/nio/file/Path;Z)Lokio/Path;", "DIRECTORY_SEPARATOR", "Ljava/lang/String;", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Path g(Companion companion, File file, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            return companion.b(file, z);
        }

        public static /* synthetic */ Path h(Companion companion, String str, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            return companion.d(str, z);
        }

        public static /* synthetic */ Path i(Companion companion, java.nio.file.Path path, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            return companion.f(path, z);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path a(@NotNull File file) {
            Intrinsics.p(file, "<this>");
            return g(this, file, false, 1, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path b(@NotNull File file, boolean z) {
            Intrinsics.p(file, "<this>");
            String file2 = file.toString();
            Intrinsics.o(file2, "toString()");
            return d(file2, z);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path c(@NotNull String str) {
            Intrinsics.p(str, "<this>");
            return h(this, str, false, 1, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @JvmName(name = "get")
        public final Path d(@NotNull String str, boolean z) {
            Intrinsics.p(str, "<this>");
            return _PathKt.B(str, z);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @IgnoreJRERequirement
        @JvmName(name = "get")
        public final Path e(@NotNull java.nio.file.Path path) {
            Intrinsics.p(path, "<this>");
            return i(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        @IgnoreJRERequirement
        @JvmName(name = "get")
        public final Path f(@NotNull java.nio.file.Path path, boolean z) {
            Intrinsics.p(path, "<this>");
            return d(path.toString(), z);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String str = File.separator;
        Intrinsics.o(str, "separator");
        Y = str;
    }

    public Path(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "bytes");
        this.s = byteString;
    }

    public static /* synthetic */ Path C(Path path, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return path.w(str, z);
    }

    public static /* synthetic */ Path D(Path path, ByteString byteString, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return path.y(byteString, z);
    }

    public static /* synthetic */ Path E(Path path, Path path2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return path.A(path2, z);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path b(@NotNull File file) {
        return X.a(file);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path c(@NotNull File file, boolean z) {
        return X.b(file, z);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path e(@NotNull String str) {
        return X.c(str);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @JvmName(name = "get")
    public static final Path f(@NotNull String str, boolean z) {
        return X.d(str, z);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @IgnoreJRERequirement
    @JvmName(name = "get")
    public static final Path g(@NotNull java.nio.file.Path path) {
        return X.e(path);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    @IgnoreJRERequirement
    @JvmName(name = "get")
    public static final Path h(@NotNull java.nio.file.Path path, boolean z) {
        return X.f(path, z);
    }

    @NotNull
    public final Path A(@NotNull Path path, boolean z) {
        Intrinsics.p(path, "child");
        return _PathKt.x(this, path, z);
    }

    @NotNull
    public final File F() {
        return new File(toString());
    }

    @NotNull
    @IgnoreJRERequirement
    public final java.nio.file.Path G() {
        java.nio.file.Path a2 = Paths.get(toString(), new String[0]);
        Intrinsics.o(a2, "get(toString())");
        return a2;
    }

    @Nullable
    @JvmName(name = "volumeLetter")
    public final Character H() {
        if (ByteString.H(i(), _PathKt.f31455a, 0, 2, (Object) null) != -1 || i().m0() < 2 || i().q(1) != ((byte) 58)) {
            return null;
        }
        char q = (char) i().q(0);
        if (('a' > q || q > 'z') && ('A' > q || q > 'Z')) {
            return null;
        }
        return Character.valueOf(q);
    }

    /* renamed from: a */
    public int compareTo(@NotNull Path path) {
        Intrinsics.p(path, "other");
        return i().compareTo(path.i());
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Path) && Intrinsics.g(((Path) obj).i(), i());
    }

    public int hashCode() {
        return i().hashCode();
    }

    @NotNull
    public final ByteString i() {
        return this.s;
    }

    @Nullable
    public final Path j() {
        int h2 = _PathKt.M(this);
        if (h2 == -1) {
            return null;
        }
        return new Path(i().A0(0, h2));
    }

    @NotNull
    public final List<String> k() {
        ArrayList<ByteString> arrayList = new ArrayList<>();
        int h2 = _PathKt.M(this);
        if (h2 == -1) {
            h2 = 0;
        } else if (h2 < i().m0() && i().q(h2) == ((byte) 92)) {
            h2++;
        }
        int m0 = i().m0();
        if (h2 < m0) {
            int i2 = h2;
            while (true) {
                int i3 = h2 + 1;
                if (i().q(h2) == ((byte) 47) || i().q(h2) == ((byte) 92)) {
                    arrayList.add(i().A0(i2, h2));
                    i2 = i3;
                }
                if (i3 >= m0) {
                    break;
                }
                h2 = i3;
            }
            h2 = i2;
        }
        if (h2 < i().m0()) {
            arrayList.add(i().A0(h2, i().m0()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(arrayList, 10));
        for (ByteString I0 : arrayList) {
            arrayList2.add(I0.I0());
        }
        return arrayList2;
    }

    @NotNull
    public final List<ByteString> l() {
        ArrayList arrayList = new ArrayList();
        int h2 = _PathKt.M(this);
        if (h2 == -1) {
            h2 = 0;
        } else if (h2 < i().m0() && i().q(h2) == ((byte) 92)) {
            h2++;
        }
        int m0 = i().m0();
        if (h2 < m0) {
            int i2 = h2;
            while (true) {
                int i3 = h2 + 1;
                if (i().q(h2) == ((byte) 47) || i().q(h2) == ((byte) 92)) {
                    arrayList.add(i().A0(i2, h2));
                    i2 = i3;
                }
                if (i3 >= m0) {
                    break;
                }
                h2 = i3;
            }
            h2 = i2;
        }
        if (h2 < i().m0()) {
            arrayList.add(i().A0(h2, i().m0()));
        }
        return arrayList;
    }

    public final boolean m() {
        return _PathKt.M(this) != -1;
    }

    public final boolean n() {
        return _PathKt.M(this) == -1;
    }

    public final boolean o() {
        return _PathKt.M(this) == i().m0();
    }

    @NotNull
    @JvmName(name = "name")
    public final String p() {
        return q().I0();
    }

    @NotNull
    @JvmName(name = "nameBytes")
    public final ByteString q() {
        int d2 = _PathKt.I(this);
        if (d2 != -1) {
            return ByteString.B0(i(), d2 + 1, 0, 2, (Object) null);
        }
        return (H() == null || i().m0() != 2) ? i() : ByteString.Y2;
    }

    @NotNull
    public final Path r() {
        return X.d(toString(), true);
    }

    @Nullable
    @JvmName(name = "parent")
    public final Path s() {
        Path path;
        if (Intrinsics.g(i(), _PathKt.f31458d) || Intrinsics.g(i(), _PathKt.f31455a) || Intrinsics.g(i(), _PathKt.f31456b) || _PathKt.L(this)) {
            return null;
        }
        int d2 = _PathKt.I(this);
        if (d2 != 2 || H() == null) {
            if (d2 == 1 && i().p0(_PathKt.f31456b)) {
                return null;
            }
            if (d2 != -1 || H() == null) {
                if (d2 == -1) {
                    return new Path(_PathKt.f31458d);
                }
                if (d2 != 0) {
                    return new Path(ByteString.B0(i(), 0, d2, 1, (Object) null));
                }
                path = new Path(ByteString.B0(i(), 0, 1, 1, (Object) null));
            } else if (i().m0() == 2) {
                return null;
            } else {
                path = new Path(ByteString.B0(i(), 0, 2, 1, (Object) null));
            }
        } else if (i().m0() == 3) {
            return null;
        } else {
            path = new Path(ByteString.B0(i(), 0, 3, 1, (Object) null));
        }
        return path;
    }

    @NotNull
    public String toString() {
        return i().I0();
    }

    @NotNull
    public final Path u(@NotNull Path path) {
        Intrinsics.p(path, "other");
        if (Intrinsics.g(j(), path.j())) {
            List<ByteString> l2 = l();
            List<ByteString> l3 = path.l();
            int min = Math.min(l2.size(), l3.size());
            int i2 = 0;
            while (i2 < min && Intrinsics.g(l2.get(i2), l3.get(i2))) {
                i2++;
            }
            if (i2 == min && i().m0() == path.i().m0()) {
                return Companion.h(X, ".", false, 1, (Object) null);
            }
            if (l3.subList(i2, l3.size()).indexOf(_PathKt.f31459e) == -1) {
                Buffer buffer = new Buffer();
                ByteString f2 = _PathKt.K(path);
                if (f2 == null && (f2 = _PathKt.K(this)) == null) {
                    f2 = _PathKt.Q(Y);
                }
                int size = l3.size();
                if (i2 < size) {
                    int i3 = i2;
                    do {
                        i3++;
                        buffer.g2(_PathKt.f31459e);
                        buffer.g2(f2);
                    } while (i3 < size);
                }
                int size2 = l2.size();
                if (i2 < size2) {
                    while (true) {
                        int i4 = i2 + 1;
                        buffer.g2(l2.get(i2));
                        buffer.g2(f2);
                        if (i4 >= size2) {
                            break;
                        }
                        i2 = i4;
                    }
                }
                return _PathKt.O(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path).toString());
    }

    @NotNull
    @JvmName(name = "resolve")
    public final Path v(@NotNull String str) {
        Intrinsics.p(str, "child");
        return _PathKt.x(this, _PathKt.O(new Buffer().W0(str), false), false);
    }

    @NotNull
    public final Path w(@NotNull String str, boolean z) {
        Intrinsics.p(str, "child");
        return _PathKt.x(this, _PathKt.O(new Buffer().W0(str), false), z);
    }

    @NotNull
    @JvmName(name = "resolve")
    public final Path x(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "child");
        return _PathKt.x(this, _PathKt.O(new Buffer().g2(byteString), false), false);
    }

    @NotNull
    public final Path y(@NotNull ByteString byteString, boolean z) {
        Intrinsics.p(byteString, "child");
        return _PathKt.x(this, _PathKt.O(new Buffer().g2(byteString), false), z);
    }

    @NotNull
    @JvmName(name = "resolve")
    public final Path z(@NotNull Path path) {
        Intrinsics.p(path, "child");
        return _PathKt.x(this, path, false);
    }
}
