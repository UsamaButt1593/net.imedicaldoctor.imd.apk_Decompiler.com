package androidx.profileinstaller;

import androidx.annotation.RestrictTo;
import com.itextpdf.text.pdf.ByteBuffer;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ProfileVersion {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f15144a = {ByteBuffer.X2, 49, 53, 0};

    /* renamed from: b  reason: collision with root package name */
    static final byte[] f15145b = {ByteBuffer.X2, 49, ByteBuffer.X2, 0};

    /* renamed from: c  reason: collision with root package name */
    static final byte[] f15146c = {ByteBuffer.X2, ByteBuffer.X2, 57, 0};

    /* renamed from: d  reason: collision with root package name */
    static final byte[] f15147d = {ByteBuffer.X2, ByteBuffer.X2, 53, 0};

    /* renamed from: e  reason: collision with root package name */
    static final byte[] f15148e = {ByteBuffer.X2, ByteBuffer.X2, 49, 0};

    /* renamed from: f  reason: collision with root package name */
    static final byte[] f15149f = {ByteBuffer.X2, ByteBuffer.X2, 49, 0};

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f15150g = {ByteBuffer.X2, ByteBuffer.X2, 50, 0};

    /* renamed from: h  reason: collision with root package name */
    public static final int f15151h = 24;

    /* renamed from: i  reason: collision with root package name */
    public static final int f15152i = 34;

    private ProfileVersion() {
    }

    static String a(byte[] bArr) {
        return (!Arrays.equals(bArr, f15148e) && !Arrays.equals(bArr, f15147d)) ? "!" : ":";
    }
}
