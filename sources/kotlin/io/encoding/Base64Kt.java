package kotlin.io.encoding;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000b\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\n\u001a\u00020\u00058\u0002X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\u001a\u0010\u000f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\t\"\u001a\u0010\u0012\u001a\u00020\u00058\u0002X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u0012\u0004\b\u0011\u0010\t\"\u001a\u0010\u0015\u001a\u00020\u000b8\u0002X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u0012\u0004\b\u0014\u0010\t¨\u0006\u0016"}, d2 = {"", "symbol", "", "i", "(I)Z", "", "a", "[B", "f", "()V", "base64EncodeMap", "", "b", "[I", "e", "base64DecodeMap", "c", "h", "base64UrlEncodeMap", "d", "g", "base64UrlDecodeMap", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,649:1\n13384#2,3:650\n13384#2,3:653\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n584#1:650,3\n603#1:653,3\n*E\n"})
public final class Base64Kt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f28867a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f28868b;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f28869c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f28870d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, DocWriter.g3};
        f28867a = bArr;
        int[] iArr = new int[256];
        int i2 = 0;
        ArraysKt.T1(iArr, -1, 0, 0, 6, (Object) null);
        iArr[61] = -2;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            iArr[bArr[i3]] = i4;
            i3++;
            i4++;
        }
        f28868b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f28869c = bArr2;
        int[] iArr2 = new int[256];
        ArraysKt.T1(iArr2, -1, 0, 0, 6, (Object) null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i5 = 0;
        while (i2 < length2) {
            iArr2[bArr2[i2]] = i5;
            i2++;
            i5++;
        }
        f28870d = iArr2;
    }

    @ExperimentalEncodingApi
    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }

    @ExperimentalEncodingApi
    private static /* synthetic */ void g() {
    }

    private static /* synthetic */ void h() {
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalEncodingApi
    public static final boolean i(int i2) {
        if (i2 >= 0) {
            int[] iArr = f28868b;
            return i2 < iArr.length && iArr[i2] != -1;
        }
    }
}
