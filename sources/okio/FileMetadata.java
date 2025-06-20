package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\r¢\u0006\u0004\b\u0013\u0010\u0014Jw\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b\"\u0010%R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b'\u0010%R'\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f8\u0006¢\u0006\f\n\u0004\b$\u0010)\u001a\u0004\b&\u0010*¨\u0006+"}, d2 = {"Lokio/FileMetadata;", "", "", "isRegularFile", "isDirectory", "Lokio/Path;", "symlinkTarget", "", "size", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "", "Lkotlin/reflect/KClass;", "extras", "<init>", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "T", "type", "c", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "a", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "", "toString", "()Ljava/lang/String;", "Z", "k", "()Z", "b", "j", "Lokio/Path;", "i", "()Lokio/Path;", "d", "Ljava/lang/Long;", "h", "()Ljava/lang/Long;", "e", "f", "g", "Ljava/util/Map;", "()Ljava/util/Map;", "okio"}, k = 1, mv = {1, 5, 1})
public final class FileMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31356a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31357b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Path f31358c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Long f31359d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Long f31360e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Long f31361f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Long f31362g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final Map<KClass<?>, Object> f31363h;

    public FileMetadata() {
        this(false, false, (Path) null, (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FileMetadata b(FileMetadata fileMetadata, boolean z, boolean z2, Path path, Long l2, Long l3, Long l4, Long l5, Map map, int i2, Object obj) {
        FileMetadata fileMetadata2 = fileMetadata;
        int i3 = i2;
        return fileMetadata.a((i3 & 1) != 0 ? fileMetadata2.f31356a : z, (i3 & 2) != 0 ? fileMetadata2.f31357b : z2, (i3 & 4) != 0 ? fileMetadata2.f31358c : path, (i3 & 8) != 0 ? fileMetadata2.f31359d : l2, (i3 & 16) != 0 ? fileMetadata2.f31360e : l3, (i3 & 32) != 0 ? fileMetadata2.f31361f : l4, (i3 & 64) != 0 ? fileMetadata2.f31362g : l5, (i3 & 128) != 0 ? fileMetadata2.f31363h : map);
    }

    @NotNull
    public final FileMetadata a(boolean z, boolean z2, @Nullable Path path, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5, @NotNull Map<KClass<?>, ? extends Object> map) {
        Map<KClass<?>, ? extends Object> map2 = map;
        Intrinsics.p(map2, "extras");
        return new FileMetadata(z, z2, path, l2, l3, l4, l5, map2);
    }

    @Nullable
    public final <T> T c(@NotNull KClass<? extends T> kClass) {
        Intrinsics.p(kClass, "type");
        Object obj = this.f31363h.get(kClass);
        if (obj == null) {
            return null;
        }
        return KClasses.a(kClass, obj);
    }

    @Nullable
    public final Long d() {
        return this.f31360e;
    }

    @NotNull
    public final Map<KClass<?>, Object> e() {
        return this.f31363h;
    }

    @Nullable
    public final Long f() {
        return this.f31362g;
    }

    @Nullable
    public final Long g() {
        return this.f31361f;
    }

    @Nullable
    public final Long h() {
        return this.f31359d;
    }

    @Nullable
    public final Path i() {
        return this.f31358c;
    }

    public final boolean j() {
        return this.f31357b;
    }

    public final boolean k() {
        return this.f31356a;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f31356a) {
            arrayList.add("isRegularFile");
        }
        if (this.f31357b) {
            arrayList.add("isDirectory");
        }
        Long l2 = this.f31359d;
        if (l2 != null) {
            arrayList.add(Intrinsics.C("byteCount=", l2));
        }
        Long l3 = this.f31360e;
        if (l3 != null) {
            arrayList.add(Intrinsics.C("createdAt=", l3));
        }
        Long l4 = this.f31361f;
        if (l4 != null) {
            arrayList.add(Intrinsics.C("lastModifiedAt=", l4));
        }
        Long l5 = this.f31362g;
        if (l5 != null) {
            arrayList.add(Intrinsics.C("lastAccessedAt=", l5));
        }
        if (!this.f31363h.isEmpty()) {
            arrayList.add(Intrinsics.C("extras=", this.f31363h));
        }
        return CollectionsKt.j3(arrayList, ", ", "FileMetadata(", ")", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    public FileMetadata(boolean z, boolean z2, @Nullable Path path, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5, @NotNull Map<KClass<?>, ? extends Object> map) {
        Intrinsics.p(map, "extras");
        this.f31356a = z;
        this.f31357b = z2;
        this.f31358c = path;
        this.f31359d = l2;
        this.f31360e = l3;
        this.f31361f = l4;
        this.f31362g = l5;
        this.f31363h = MapsKt.D0(map);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileMetadata(boolean r10, boolean r11, okio.Path r12, java.lang.Long r13, java.lang.Long r14, java.lang.Long r15, java.lang.Long r16, java.util.Map r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r11
        L_0x0010:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0017
            r3 = r4
            goto L_0x0018
        L_0x0017:
            r3 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r4
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r4
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r4
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r4 = r16
        L_0x0034:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003d
            java.util.Map r0 = kotlin.collections.MapsKt.z()
            goto L_0x003f
        L_0x003d:
            r0 = r17
        L_0x003f:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r4
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.FileMetadata.<init>(boolean, boolean, okio.Path, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
