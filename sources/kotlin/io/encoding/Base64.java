package kotlin.io.encoding;

import com.itextpdf.text.Annotation;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0013\b\u0017\u0018\u0000 =2\u00020\u0001:\u0001>B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0014J'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 J;\u0010!\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b!\u0010\u0012J)\u0010#\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J?\u0010(\u001a\u00028\u0000\"\f\b\u0000\u0010'*\u00060%j\u0002`&2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b(\u0010)J)\u0010*\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b*\u0010 J;\u0010+\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b+\u0010\u0012J)\u0010-\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020,2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b-\u0010.J;\u0010/\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020,2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b/\u00100J'\u00101\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b1\u0010 J7\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b2\u0010\u0012J'\u00103\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020,2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b3\u0010.J\u0017\u00104\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b4\u00105J'\u00106\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b6\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010\u0004\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b;\u00108\u001a\u0004\b<\u0010:¨\u0006?"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "", "isUrlSafe", "isMimeScheme", "<init>", "(ZZ)V", "", "sourceSize", "w", "(I)I", "", "source", "destination", "destinationOffset", "startIndex", "endIndex", "l", "([B[BIII)I", "q", "([BII)I", "padIndex", "byteStart", "C", "([BIII)I", "F", "destinationSize", "capacityNeeded", "", "f", "(III)V", "z", "([BII)[B", "t", "", "r", "([BII)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "x", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "i", "n", "", "h", "(Ljava/lang/CharSequence;II)[B", "m", "(Ljava/lang/CharSequence;[BIII)I", "B", "v", "e", "d", "([B)Ljava/lang/String;", "g", "a", "Z", "E", "()Z", "b", "D", "c", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ExperimentalEncodingApi
public class Base64 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Default f28854c = new Default((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f28855d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f28856e = 6;

    /* renamed from: f  reason: collision with root package name */
    public static final int f28857f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f28858g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static final byte f28859h = 61;

    /* renamed from: i  reason: collision with root package name */
    public static final int f28860i = 76;

    /* renamed from: j  reason: collision with root package name */
    private static final int f28861j = 19;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final byte[] f28862k = {13, 10};
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public static final Base64 f28863l = new Base64(true, false);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public static final Base64 f28864m = new Base64(false, true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28865a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28866b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0000XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u000f8\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00158\u0000XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000f8\u0000XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "<init>", "()V", "", "mimeLineSeparatorSymbols", "[B", "H", "()[B", "UrlSafe", "Lkotlin/io/encoding/Base64;", "I", "()Lkotlin/io/encoding/Base64;", "Mime", "G", "", "bitsPerByte", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "", "padSymbol", "B", "symbolsPerGroup", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Default extends Base64 {
        private Default() {
            super(false, false, (DefaultConstructorMarker) null);
        }

        @NotNull
        public final Base64 G() {
            return Base64.f28864m;
        }

        @NotNull
        public final byte[] H() {
            return Base64.f28862k;
        }

        @NotNull
        public final Base64 I() {
            return Base64.f28863l;
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Base64(boolean z, boolean z2) {
        this.f28865a = z;
        this.f28866b = z2;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public static /* synthetic */ byte[] A(Base64 base64, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return base64.z(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    private final int C(byte[] bArr, int i2, int i3, int i4) {
        if (i4 != -8) {
            if (i4 != -6) {
                if (i4 == -4) {
                    i2 = F(bArr, i2 + 1, i3);
                    if (i2 == i3 || bArr[i2] != 61) {
                        throw new IllegalArgumentException("Missing one pad character at index " + i2);
                    }
                } else if (i4 != -2) {
                    throw new IllegalStateException("Unreachable".toString());
                }
            }
            return i2 + 1;
        }
        throw new IllegalArgumentException("Redundant pad character at index " + i2);
    }

    private final int F(byte[] bArr, int i2, int i3) {
        if (!this.f28866b) {
            return i2;
        }
        while (i2 < i3) {
            if (Base64Kt.f28868b[bArr[i2] & 255] != -1) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    private final void f(int i2, int i3, int i4) {
        if (i3 < 0 || i3 > i2) {
            throw new IndexOutOfBoundsException("destination offset: " + i3 + ", destination size: " + i2);
        }
        int i5 = i3 + i4;
        if (i5 < 0 || i5 > i2) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i3 + ", destination size: " + i2 + ", capacity needed: " + i4);
        }
    }

    public static /* synthetic */ byte[] j(Base64 base64, CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = charSequence.length();
            }
            return base64.h(charSequence, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ byte[] k(Base64 base64, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return base64.i(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    private final int l(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        byte[] bArr3 = bArr;
        int i5 = i4;
        int[] c2 = this.f28865a ? Base64Kt.f28870d : Base64Kt.f28868b;
        int i6 = -8;
        int i7 = i2;
        int i8 = i3;
        int i9 = 0;
        int i10 = -8;
        while (true) {
            if (i8 >= i5) {
                break;
            }
            if (i10 == i6 && i8 + 3 < i5) {
                int i11 = i8 + 4;
                int i12 = (c2[bArr3[i8] & 255] << 18) | (c2[bArr3[i8 + 1] & 255] << 12) | (c2[bArr3[i8 + 2] & 255] << 6) | c2[bArr3[i8 + 3] & 255];
                if (i12 >= 0) {
                    bArr2[i7] = (byte) (i12 >> 16);
                    int i13 = i7 + 2;
                    bArr2[i7 + 1] = (byte) (i12 >> 8);
                    i7 += 3;
                    bArr2[i13] = (byte) i12;
                    i8 = i11;
                    i6 = -8;
                }
            }
            byte b2 = bArr3[i8] & 255;
            int i14 = c2[b2];
            if (i14 >= 0) {
                i8++;
                i9 = (i9 << 6) | i14;
                int i15 = i10 + 6;
                if (i15 >= 0) {
                    bArr2[i7] = (byte) (i9 >>> i15);
                    i9 &= (1 << i15) - 1;
                    i10 -= 2;
                    i7++;
                } else {
                    i10 = i15;
                }
            } else if (i14 == -2) {
                i8 = C(bArr3, i8, i5, i10);
                break;
            } else if (this.f28866b) {
                i8++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid symbol '");
                sb.append((char) b2);
                sb.append("'(");
                String num = Integer.toString(b2, CharsKt.a(8));
                Intrinsics.o(num, "toString(this, checkRadix(radix))");
                sb.append(num);
                sb.append(") at index ");
                sb.append(i8);
                throw new IllegalArgumentException(sb.toString());
            }
            i6 = -8;
        }
        if (i10 != -2) {
            int F = F(bArr3, i8, i5);
            if (F >= i5) {
                return i7 - i2;
            }
            byte b3 = bArr3[F] & 255;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Symbol '");
            sb2.append((char) b3);
            sb2.append("'(");
            String num2 = Integer.toString(b3, CharsKt.a(8));
            Intrinsics.o(num2, "toString(this, checkRadix(radix))");
            sb2.append(num2);
            sb2.append(") at index ");
            sb2.append(F - 1);
            sb2.append(" is prohibited after the pad character");
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    }

    public static /* synthetic */ int o(Base64 base64, CharSequence charSequence, byte[] bArr, int i2, int i3, int i4, int i5, Object obj) {
        if (obj == null) {
            int i6 = (i5 & 4) != 0 ? 0 : i2;
            int i7 = (i5 & 8) != 0 ? 0 : i3;
            if ((i5 & 16) != 0) {
                i4 = charSequence.length();
            }
            return base64.m(charSequence, bArr, i6, i7, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public static /* synthetic */ int p(Base64 base64, byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if (obj == null) {
            int i6 = (i5 & 4) != 0 ? 0 : i2;
            int i7 = (i5 & 8) != 0 ? 0 : i3;
            if ((i5 & 16) != 0) {
                i4 = bArr.length;
            }
            return base64.n(bArr, bArr2, i6, i7, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    private final int q(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 == 0) {
            return 0;
        }
        if (i4 != 1) {
            if (this.f28866b) {
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i5 = Base64Kt.f28868b[bArr[i2] & 255];
                    if (i5 < 0) {
                        if (i5 == -2) {
                            i4 -= i3 - i2;
                            break;
                        }
                        i4--;
                    }
                    i2++;
                }
            } else if (bArr[i3 - 1] == 61) {
                i4 = bArr[i3 + -2] == 61 ? i4 - 2 : i4 - 1;
            }
            return (int) ((((long) i4) * ((long) 6)) / ((long) 8));
        }
        throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + i2 + ", endIndex: " + i3);
    }

    public static /* synthetic */ String s(Base64 base64, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return base64.r(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public static /* synthetic */ int u(Base64 base64, byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if (obj == null) {
            int i6 = (i5 & 4) != 0 ? 0 : i2;
            int i7 = (i5 & 8) != 0 ? 0 : i3;
            if ((i5 & 16) != 0) {
                i4 = bArr.length;
            }
            return base64.t(bArr, bArr2, i6, i7, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    private final int w(int i2) {
        int i3 = (i2 + 2) / 3;
        int i4 = (i3 * 4) + ((this.f28866b ? (i3 - 1) / 19 : 0) * 2);
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    public static /* synthetic */ Appendable y(Base64 base64, byte[] bArr, Appendable appendable, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            if ((i4 & 8) != 0) {
                i3 = bArr.length;
            }
            return base64.x(bArr, appendable, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    @NotNull
    public final byte[] B(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        g(bArr.length, i2, i3);
        byte[] bArr2 = new byte[w(i3 - i2)];
        v(bArr, bArr2, 0, i2, i3);
        return bArr2;
    }

    public final boolean D() {
        return this.f28866b;
    }

    public final boolean E() {
        return this.f28865a;
    }

    @NotNull
    public final String d(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "source");
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b2 : bArr) {
            sb.append((char) b2);
        }
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "stringBuilder.toString()");
        return sb2;
    }

    @NotNull
    public final byte[] e(@NotNull CharSequence charSequence, int i2, int i3) {
        Intrinsics.p(charSequence, "source");
        g(charSequence.length(), i2, i3);
        byte[] bArr = new byte[(i3 - i2)];
        int i4 = 0;
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if (charAt <= 255) {
                bArr[i4] = (byte) charAt;
                i4++;
            } else {
                bArr[i4] = Utf8.f31404a;
                i4++;
            }
            i2++;
        }
        return bArr;
    }

    public final void g(int i2, int i3, int i4) {
        AbstractList.s.a(i3, i4, i2);
    }

    @NotNull
    public final byte[] h(@NotNull CharSequence charSequence, int i2, int i3) {
        byte[] e2;
        Intrinsics.p(charSequence, "source");
        if (charSequence instanceof String) {
            g(charSequence.length(), i2, i3);
            String substring = ((String) charSequence).substring(i2, i3);
            Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.f29058g;
            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
            e2 = substring.getBytes(charset);
            Intrinsics.o(e2, "this as java.lang.String).getBytes(charset)");
        } else {
            e2 = e(charSequence, i2, i3);
        }
        return k(this, e2, 0, 0, 6, (Object) null);
    }

    @NotNull
    public final byte[] i(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        g(bArr.length, i2, i3);
        int q = q(bArr, i2, i3);
        byte[] bArr2 = new byte[q];
        if (l(bArr, bArr2, 0, i2, i3) == q) {
            return bArr2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int m(@NotNull CharSequence charSequence, @NotNull byte[] bArr, int i2, int i3, int i4) {
        byte[] e2;
        Intrinsics.p(charSequence, "source");
        Intrinsics.p(bArr, Annotation.l3);
        if (charSequence instanceof String) {
            g(charSequence.length(), i3, i4);
            String substring = ((String) charSequence).substring(i3, i4);
            Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.f29058g;
            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
            e2 = substring.getBytes(charset);
            Intrinsics.o(e2, "this as java.lang.String).getBytes(charset)");
        } else {
            e2 = e(charSequence, i3, i4);
        }
        return p(this, e2, bArr, i2, 0, 0, 24, (Object) null);
    }

    public final int n(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        Intrinsics.p(bArr, "source");
        Intrinsics.p(bArr2, Annotation.l3);
        g(bArr.length, i3, i4);
        f(bArr2.length, i2, q(bArr, i3, i4));
        return l(bArr, bArr2, i2, i3, i4);
    }

    @NotNull
    public final String r(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        return new String(B(bArr, i2, i3), Charsets.f29058g);
    }

    public final int t(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        Intrinsics.p(bArr, "source");
        Intrinsics.p(bArr2, Annotation.l3);
        return v(bArr, bArr2, i2, i3, i4);
    }

    public final int v(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i2, int i3, int i4) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        Intrinsics.p(bArr3, "source");
        Intrinsics.p(bArr4, Annotation.l3);
        g(bArr3.length, i6, i7);
        f(bArr4.length, i5, w(i7 - i6));
        byte[] d2 = this.f28865a ? Base64Kt.f28869c : Base64Kt.f28867a;
        int i8 = this.f28866b ? 19 : Integer.MAX_VALUE;
        int i9 = i5;
        while (i6 + 2 < i7) {
            int min = Math.min((i7 - i6) / 3, i8);
            for (int i10 = 0; i10 < min; i10++) {
                int i11 = i6 + 2;
                i6 += 3;
                byte b2 = ((bArr3[i6 + 1] & 255) << 8) | ((bArr3[i6] & 255) << 16) | (bArr3[i11] & 255);
                bArr4[i9] = d2[b2 >>> 18];
                bArr4[i9 + 1] = d2[(b2 >>> 12) & 63];
                int i12 = i9 + 3;
                bArr4[i9 + 2] = d2[(b2 >>> 6) & 63];
                i9 += 4;
                bArr4[i12] = d2[b2 & Utf8.f31404a];
            }
            if (min == i8 && i6 != i7) {
                int i13 = i9 + 1;
                byte[] bArr5 = f28862k;
                bArr4[i9] = bArr5[0];
                i9 += 2;
                bArr4[i13] = bArr5[1];
            }
        }
        int i14 = i7 - i6;
        if (i14 == 1) {
            int i15 = (bArr3[i6] & 255) << 4;
            bArr4[i9] = d2[i15 >>> 6];
            bArr4[i9 + 1] = d2[i15 & 63];
            int i16 = i9 + 3;
            bArr4[i9 + 2] = 61;
            i9 += 4;
            bArr4[i16] = 61;
            i6++;
        } else if (i14 == 2) {
            int i17 = i6 + 1;
            i6 += 2;
            int i18 = ((bArr3[i17] & 255) << 2) | ((bArr3[i6] & 255) << 10);
            bArr4[i9] = d2[i18 >>> 12];
            bArr4[i9 + 1] = d2[(i18 >>> 6) & 63];
            int i19 = i9 + 3;
            bArr4[i9 + 2] = d2[i18 & 63];
            i9 += 4;
            bArr4[i19] = 61;
        }
        if (i6 == i7) {
            return i9 - i5;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @NotNull
    public final <A extends Appendable> A x(@NotNull byte[] bArr, @NotNull A a2, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        Intrinsics.p(a2, Annotation.l3);
        a2.append(new String(B(bArr, i2, i3), Charsets.f29058g));
        return a2;
    }

    @NotNull
    public final byte[] z(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "source");
        return B(bArr, i2, i3);
    }

    public /* synthetic */ Base64(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }
}
