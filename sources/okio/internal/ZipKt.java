package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.BufferedSource;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a5\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u001f\u001a\u00020\u001d*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010!\u001a\u00020\u001d*\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010%\u001a\u00020#*\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010'\u001a\u0004\u0018\u00010#*\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b'\u0010&\u001a!\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0002¢\u0006\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010,\"\u0014\u0010.\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b*\u0010,\"\u0014\u00100\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b/\u0010,\"\u0014\u00101\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010,\"\u0014\u00103\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b2\u0010,\"\u0014\u00104\u001a\u00020\u00198\u0000XT¢\u0006\u0006\n\u0004\b\u0011\u0010,\"\u0014\u00105\u001a\u00020\u00198\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010,\"\u0014\u00106\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010,\"\u0014\u00107\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b%\u0010,\"\u0014\u00109\u001a\u00020\u001c8\u0002XT¢\u0006\u0006\n\u0004\b'\u00108\"\u0014\u0010:\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010,\"\u0014\u0010;\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b!\u0010,\"\u0018\u0010>\u001a\u00020<*\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010=¨\u0006?"}, d2 = {"Lokio/Path;", "zipPath", "Lokio/FileSystem;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", "", "predicate", "Lokio/ZipFileSystem;", "d", "(Lokio/Path;Lokio/FileSystem;Lkotlin/jvm/functions/Function1;)Lokio/ZipFileSystem;", "", "entries", "", "a", "(Ljava/util/List;)Ljava/util/Map;", "Lokio/BufferedSource;", "f", "(Lokio/BufferedSource;)Lokio/internal/ZipEntry;", "Lokio/internal/EocdRecord;", "g", "(Lokio/BufferedSource;)Lokio/internal/EocdRecord;", "regularRecord", "k", "(Lokio/BufferedSource;Lokio/internal/EocdRecord;)Lokio/internal/EocdRecord;", "", "extraSize", "Lkotlin/Function2;", "", "", "block", "h", "(Lokio/BufferedSource;ILkotlin/jvm/functions/Function2;)V", "l", "(Lokio/BufferedSource;)V", "Lokio/FileMetadata;", "basicMetadata", "i", "(Lokio/BufferedSource;Lokio/FileMetadata;)Lokio/FileMetadata;", "j", "date", "time", "b", "(II)Ljava/lang/Long;", "I", "LOCAL_FILE_HEADER_SIGNATURE", "CENTRAL_FILE_HEADER_SIGNATURE", "c", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "e", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "J", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_EXTENDED_TIMESTAMP", "", "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {1, 5, 1})
public final class ZipKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31438a = 67324752;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31439b = 33639248;

    /* renamed from: c  reason: collision with root package name */
    private static final int f31440c = 101010256;

    /* renamed from: d  reason: collision with root package name */
    private static final int f31441d = 117853008;

    /* renamed from: e  reason: collision with root package name */
    private static final int f31442e = 101075792;

    /* renamed from: f  reason: collision with root package name */
    public static final int f31443f = 8;

    /* renamed from: g  reason: collision with root package name */
    public static final int f31444g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final int f31445h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f31446i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final long f31447j = 4294967295L;

    /* renamed from: k  reason: collision with root package name */
    private static final int f31448k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f31449l = 21589;

    private static final Map<Path, ZipEntry> a(List<ZipEntry> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : CollectionsKt.r5(list, new ZipKt$buildIndex$$inlined$sortedBy$1())) {
            if (((ZipEntry) linkedHashMap.put(t.a(), t)) == null) {
                while (true) {
                    Path s = t.a().s();
                    if (s == null) {
                        break;
                    }
                    ZipEntry zipEntry = (ZipEntry) linkedHashMap.get(s);
                    if (zipEntry != null) {
                        zipEntry.b().add(t.a());
                        break;
                    }
                    ZipEntry zipEntry2 = r4;
                    ZipEntry zipEntry3 = new ZipEntry(s, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TypedValues.PositionType.p, (DefaultConstructorMarker) null);
                    ZipEntry zipEntry4 = zipEntry2;
                    linkedHashMap.put(s, zipEntry4);
                    zipEntry4.b().add(t.a());
                    t = zipEntry4;
                }
            }
        }
        return linkedHashMap;
    }

    private static final Long b(int i2, int i3) {
        if (i3 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar2.set(((i2 >> 9) & WorkQueueKt.f29430c) + 1980, ((i2 >> 5) & 15) - 1, i2 & 31, (i3 >> 11) & 31, (i3 >> 5) & 63, (i3 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i2) {
        String num = Integer.toString(i2, CharsKt.a(16));
        Intrinsics.o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return Intrinsics.C("0x", num);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
        r11 = g(r14);
        r12 = r14.B((long) r11.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r14.close();
        r8 = r8 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        if (r8 <= 0) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a6, code lost:
        r8 = okio.Okio.e(r3.I(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b5, code lost:
        if (r8.R1() != f31441d) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        r9 = r8.R1();
        r13 = r8.p2();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
        if (r8.R1() != 1) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        if (r9 != 0) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        r4 = okio.Okio.e(r3.I(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r9 = r4.R1();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
        if (r9 != f31442e) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d8, code lost:
        r11 = k(r4, r11);
        r9 = kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        kotlin.io.CloseableKt.a(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e3, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010c, code lost:
        throw new java.io.IOException("bad zip: expected " + c(f31442e) + " but was " + c(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010f, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        kotlin.io.CloseableKt.a(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0113, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011b, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011c, code lost:
        r4 = kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        kotlin.io.CloseableKt.a(r8, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0127, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        kotlin.io.CloseableKt.a(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012d, code lost:
        r4 = new java.util.ArrayList();
        r8 = okio.Okio.e(r3.I(r11.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r9 = r11.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0144, code lost:
        if (0 >= r9) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0146, code lost:
        r5 = r5 + 1;
        r13 = f(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0157, code lost:
        if (r13.h() >= r11.a()) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0163, code lost:
        if (r2.f(r13).booleanValue() == false) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0165, code lost:
        r4.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0169, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x016a, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x016e, code lost:
        if (r5 < r9) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0178, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0179, code lost:
        r2 = kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        kotlin.io.CloseableKt.a(r8, (java.lang.Throwable) null);
        r4 = new okio.ZipFileSystem(r0, r1, a(r4), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0187, code lost:
        kotlin.io.CloseableKt.a(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018a, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x018c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018d, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        kotlin.io.CloseableKt.a(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0191, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem d(@org.jetbrains.annotations.NotNull okio.Path r19, @org.jetbrains.annotations.NotNull okio.FileSystem r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r21) throws java.io.IOException {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.Intrinsics.p(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.p(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.Intrinsics.p(r2, r3)
            okio.FileHandle r3 = r1.E(r0)
            r4 = 1
            r5 = 0
            r7 = 0
            okio.Source r8 = okio.FileHandle.J(r3, r5, r4, r7)     // Catch:{ all -> 0x0122 }
            okio.BufferedSource r8 = okio.Okio.e(r8)     // Catch:{ all -> 0x0122 }
            int r9 = r8.R1()     // Catch:{ all -> 0x003d }
            java.lang.String r10 = " but was "
            r11 = 101010256(0x6054b50, float:2.506985E-35)
            r12 = 67324752(0x4034b50, float:1.5433558E-36)
            if (r9 == r12) goto L_0x0066
            if (r9 != r11) goto L_0x0041
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "unsupported zip: empty"
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            r1 = r0
            goto L_0x01c0
        L_0x0041:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "not a zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = c(r12)     // Catch:{ all -> 0x003d }
            r1.append(r2)     // Catch:{ all -> 0x003d }
            r1.append(r10)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = c(r9)     // Catch:{ all -> 0x003d }
            r1.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003d }
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x0066:
            kotlin.Unit r9 = kotlin.Unit.f28779a     // Catch:{ all -> 0x003d }
            kotlin.io.CloseableKt.a(r8, r7)     // Catch:{ all -> 0x0122 }
            long r8 = r3.H()     // Catch:{ all -> 0x0122 }
            r12 = 22
            long r12 = (long) r12     // Catch:{ all -> 0x0122 }
            long r8 = r8 - r12
            int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r12 < 0) goto L_0x01ac
            r12 = 65536(0x10000, double:3.2379E-319)
            long r12 = r8 - r12
            long r12 = java.lang.Math.max(r12, r5)     // Catch:{ all -> 0x0122 }
        L_0x0080:
            okio.Source r14 = r3.I(r8)     // Catch:{ all -> 0x0122 }
            okio.BufferedSource r14 = okio.Okio.e(r14)     // Catch:{ all -> 0x0122 }
            int r15 = r14.R1()     // Catch:{ all -> 0x0192 }
            if (r15 != r11) goto L_0x0194
            okio.internal.EocdRecord r11 = g(r14)     // Catch:{ all -> 0x0192 }
            int r12 = r11.b()     // Catch:{ all -> 0x0192 }
            long r12 = (long) r12     // Catch:{ all -> 0x0192 }
            java.lang.String r12 = r14.B(r12)     // Catch:{ all -> 0x0192 }
            r14.close()     // Catch:{ all -> 0x0122 }
            r13 = 20
            long r13 = (long) r13     // Catch:{ all -> 0x0122 }
            long r8 = r8 - r13
            int r13 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x012d
            okio.Source r8 = r3.I(r8)     // Catch:{ all -> 0x0122 }
            okio.BufferedSource r8 = okio.Okio.e(r8)     // Catch:{ all -> 0x0122 }
            int r9 = r8.R1()     // Catch:{ all -> 0x00e2 }
            r13 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r9 != r13) goto L_0x011c
            int r9 = r8.R1()     // Catch:{ all -> 0x00e2 }
            long r13 = r8.p2()     // Catch:{ all -> 0x00e2 }
            int r15 = r8.R1()     // Catch:{ all -> 0x00e2 }
            if (r15 != r4) goto L_0x0114
            if (r9 != 0) goto L_0x0114
            okio.Source r4 = r3.I(r13)     // Catch:{ all -> 0x00e2 }
            okio.BufferedSource r4 = okio.Okio.e(r4)     // Catch:{ all -> 0x00e2 }
            int r9 = r4.R1()     // Catch:{ all -> 0x00e5 }
            r13 = 101075792(0x6064b50, float:2.525793E-35)
            if (r9 != r13) goto L_0x00e8
            okio.internal.EocdRecord r11 = k(r4, r11)     // Catch:{ all -> 0x00e5 }
            kotlin.Unit r9 = kotlin.Unit.f28779a     // Catch:{ all -> 0x00e5 }
            kotlin.io.CloseableKt.a(r4, r7)     // Catch:{ all -> 0x00e2 }
            goto L_0x011c
        L_0x00e2:
            r0 = move-exception
            r1 = r0
            goto L_0x0126
        L_0x00e5:
            r0 = move-exception
            r1 = r0
            goto L_0x010d
        L_0x00e8:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r1.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = c(r13)     // Catch:{ all -> 0x00e5 }
            r1.append(r2)     // Catch:{ all -> 0x00e5 }
            r1.append(r10)     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = c(r9)     // Catch:{ all -> 0x00e5 }
            r1.append(r2)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e5 }
            r0.<init>(r1)     // Catch:{ all -> 0x00e5 }
            throw r0     // Catch:{ all -> 0x00e5 }
        L_0x010d:
            throw r1     // Catch:{ all -> 0x010e }
        L_0x010e:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.a(r4, r1)     // Catch:{ all -> 0x00e2 }
            throw r2     // Catch:{ all -> 0x00e2 }
        L_0x0114:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x00e2 }
            throw r0     // Catch:{ all -> 0x00e2 }
        L_0x011c:
            kotlin.Unit r4 = kotlin.Unit.f28779a     // Catch:{ all -> 0x00e2 }
            kotlin.io.CloseableKt.a(r8, r7)     // Catch:{ all -> 0x0122 }
            goto L_0x012d
        L_0x0122:
            r0 = move-exception
            r1 = r0
            goto L_0x01c7
        L_0x0126:
            throw r1     // Catch:{ all -> 0x0127 }
        L_0x0127:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.a(r8, r1)     // Catch:{ all -> 0x0122 }
            throw r2     // Catch:{ all -> 0x0122 }
        L_0x012d:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0122 }
            r4.<init>()     // Catch:{ all -> 0x0122 }
            long r8 = r11.a()     // Catch:{ all -> 0x0122 }
            okio.Source r8 = r3.I(r8)     // Catch:{ all -> 0x0122 }
            okio.BufferedSource r8 = okio.Okio.e(r8)     // Catch:{ all -> 0x0122 }
            long r9 = r11.c()     // Catch:{ all -> 0x0169 }
            int r13 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x0179
        L_0x0146:
            r13 = 1
            long r5 = r5 + r13
            okio.internal.ZipEntry r13 = f(r8)     // Catch:{ all -> 0x0169 }
            long r14 = r13.h()     // Catch:{ all -> 0x0169 }
            long r16 = r11.a()     // Catch:{ all -> 0x0169 }
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x0171
            java.lang.Object r14 = r2.f(r13)     // Catch:{ all -> 0x0169 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0169 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0169 }
            if (r14 == 0) goto L_0x016c
            r4.add(r13)     // Catch:{ all -> 0x0169 }
            goto L_0x016c
        L_0x0169:
            r0 = move-exception
            r1 = r0
            goto L_0x018b
        L_0x016c:
            int r13 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r13 < 0) goto L_0x0146
            goto L_0x0179
        L_0x0171:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0169 }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x0169 }
            throw r0     // Catch:{ all -> 0x0169 }
        L_0x0179:
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0169 }
            kotlin.io.CloseableKt.a(r8, r7)     // Catch:{ all -> 0x0122 }
            java.util.Map r2 = a(r4)     // Catch:{ all -> 0x0122 }
            okio.ZipFileSystem r4 = new okio.ZipFileSystem     // Catch:{ all -> 0x0122 }
            r4.<init>(r0, r1, r2, r12)     // Catch:{ all -> 0x0122 }
            kotlin.io.CloseableKt.a(r3, r7)
            return r4
        L_0x018b:
            throw r1     // Catch:{ all -> 0x018c }
        L_0x018c:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.a(r8, r1)     // Catch:{ all -> 0x0122 }
            throw r2     // Catch:{ all -> 0x0122 }
        L_0x0192:
            r0 = move-exception
            goto L_0x01a8
        L_0x0194:
            r14.close()     // Catch:{ all -> 0x0122 }
            r14 = -1
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x01a0
            goto L_0x0080
        L_0x01a0:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0122 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x0122 }
            throw r0     // Catch:{ all -> 0x0122 }
        L_0x01a8:
            r14.close()     // Catch:{ all -> 0x0122 }
            throw r0     // Catch:{ all -> 0x0122 }
        L_0x01ac:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0122 }
            java.lang.String r1 = "not a zip: size="
            long r4 = r3.H()     // Catch:{ all -> 0x0122 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0122 }
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.C(r1, r2)     // Catch:{ all -> 0x0122 }
            r0.<init>(r1)     // Catch:{ all -> 0x0122 }
            throw r0     // Catch:{ all -> 0x0122 }
        L_0x01c0:
            throw r1     // Catch:{ all -> 0x01c1 }
        L_0x01c1:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.a(r8, r1)     // Catch:{ all -> 0x0122 }
            throw r2     // Catch:{ all -> 0x0122 }
        L_0x01c7:
            throw r1     // Catch:{ all -> 0x01c8 }
        L_0x01c8:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.a(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipKt.d(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem e(Path path, FileSystem fileSystem, Function1 function1, int i2, Object obj) throws IOException {
        if ((i2 & 4) != 0) {
            function1 = ZipKt$openZip$1.X;
        }
        return d(path, fileSystem, function1);
    }

    @NotNull
    public static final ZipEntry f(@NotNull BufferedSource bufferedSource) throws IOException {
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.p(bufferedSource2, "<this>");
        int R1 = bufferedSource.R1();
        if (R1 == f31439b) {
            bufferedSource2.skip(4);
            short j2 = bufferedSource.j2();
            short s = j2 & UShort.Z;
            if ((j2 & 1) == 0) {
                short j22 = bufferedSource.j2() & UShort.Z;
                Long b2 = b(bufferedSource.j2() & UShort.Z, bufferedSource.j2() & UShort.Z);
                long R12 = ((long) bufferedSource.R1()) & 4294967295L;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.s = ((long) bufferedSource.R1()) & 4294967295L;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.s = ((long) bufferedSource.R1()) & 4294967295L;
                short j23 = bufferedSource.j2() & UShort.Z;
                short j24 = bufferedSource.j2() & UShort.Z;
                short j25 = bufferedSource.j2() & UShort.Z;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.s = ((long) bufferedSource.R1()) & 4294967295L;
                String B = bufferedSource2.B((long) j23);
                if (!StringsKt.S2(B, 0, false, 2, (Object) null)) {
                    long j3 = longRef2.s == 4294967295L ? (long) 8 : 0;
                    long j4 = longRef.s == 4294967295L ? j3 + ((long) 8) : j3;
                    Ref.LongRef longRef4 = longRef;
                    if (longRef3.s == 4294967295L) {
                        j4 += (long) 8;
                    }
                    long j5 = j4;
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    long j6 = R12;
                    ZipKt$readEntry$1 zipKt$readEntry$1 = r0;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    Ref.LongRef longRef5 = longRef2;
                    String str = B;
                    Ref.LongRef longRef6 = longRef3;
                    ZipKt$readEntry$1 zipKt$readEntry$12 = new ZipKt$readEntry$1(booleanRef, j5, longRef2, bufferedSource, longRef4, longRef3);
                    h(bufferedSource2, j24, zipKt$readEntry$1);
                    if (j5 <= 0 || booleanRef2.s) {
                        return new ZipEntry(Path.Companion.h(Path.X, "/", false, 1, (Object) null).v(str), StringsKt.J1(str, "/", false, 2, (Object) null), bufferedSource2.B((long) j25), j6, longRef4.s, longRef5.s, j22, b2, longRef6.s);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException(Intrinsics.C("unsupported zip: general purpose bit flag=", c(s)));
        }
        throw new IOException("bad zip: expected " + c(f31439b) + " but was " + c(R1));
    }

    private static final EocdRecord g(BufferedSource bufferedSource) throws IOException {
        short j2 = bufferedSource.j2() & UShort.Z;
        short j22 = bufferedSource.j2() & UShort.Z;
        long j23 = (long) (bufferedSource.j2() & UShort.Z);
        if (j23 == ((long) (bufferedSource.j2() & UShort.Z)) && j2 == 0 && j22 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(j23, 4294967295L & ((long) bufferedSource.R1()), bufferedSource.j2() & UShort.Z);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void h(BufferedSource bufferedSource, int i2, Function2<? super Integer, ? super Long, Unit> function2) {
        long j2 = (long) i2;
        while (j2 != 0) {
            if (j2 >= 4) {
                short j22 = bufferedSource.j2() & UShort.Z;
                long j23 = ((long) bufferedSource.j2()) & 65535;
                long j3 = j2 - ((long) 4);
                if (j3 >= j23) {
                    bufferedSource.I2(j23);
                    long L0 = bufferedSource.m().L0();
                    function2.d0(Integer.valueOf(j22), Long.valueOf(j23));
                    long L02 = (bufferedSource.m().L0() + j23) - L0;
                    int i3 = (L02 > 0 ? 1 : (L02 == 0 ? 0 : -1));
                    if (i3 >= 0) {
                        if (i3 > 0) {
                            bufferedSource.m().skip(L02);
                        }
                        j2 = j3 - j23;
                    } else {
                        throw new IOException(Intrinsics.C("unsupported zip: too many bytes processed for ", Integer.valueOf(j22)));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    @NotNull
    public static final FileMetadata i(@NotNull BufferedSource bufferedSource, @NotNull FileMetadata fileMetadata) {
        Intrinsics.p(bufferedSource, "<this>");
        Intrinsics.p(fileMetadata, "basicMetadata");
        FileMetadata j2 = j(bufferedSource, fileMetadata);
        Intrinsics.m(j2);
        return j2;
    }

    private static final FileMetadata j(BufferedSource bufferedSource, FileMetadata fileMetadata) {
        BufferedSource bufferedSource2 = bufferedSource;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.s = fileMetadata == null ? null : fileMetadata.g();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int R1 = bufferedSource.R1();
        if (R1 == f31438a) {
            bufferedSource2.skip(2);
            short j2 = bufferedSource.j2();
            short s = j2 & UShort.Z;
            if ((j2 & 1) == 0) {
                bufferedSource2.skip(18);
                short j22 = bufferedSource.j2() & UShort.Z;
                bufferedSource2.skip(((long) bufferedSource.j2()) & 65535);
                if (fileMetadata == null) {
                    bufferedSource2.skip((long) j22);
                    return null;
                }
                h(bufferedSource2, j22, new ZipKt$readOrSkipLocalHeader$1(bufferedSource2, objectRef, objectRef2, objectRef3));
                return new FileMetadata(fileMetadata.k(), fileMetadata.j(), (Path) null, fileMetadata.h(), (Long) objectRef3.s, (Long) objectRef.s, (Long) objectRef2.s, (Map) null, 128, (DefaultConstructorMarker) null);
            }
            throw new IOException(Intrinsics.C("unsupported zip: general purpose bit flag=", c(s)));
        }
        throw new IOException("bad zip: expected " + c(f31438a) + " but was " + c(R1));
    }

    private static final EocdRecord k(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int R1 = bufferedSource.R1();
        int R12 = bufferedSource.R1();
        long p2 = bufferedSource.p2();
        if (p2 == bufferedSource.p2() && R1 == 0 && R12 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(p2, bufferedSource.p2(), eocdRecord.b());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void l(@NotNull BufferedSource bufferedSource) {
        Intrinsics.p(bufferedSource, "<this>");
        j(bufferedSource, (FileMetadata) null);
    }
}
