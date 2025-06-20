package kotlin.text;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\t\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000b\u001a\u00020\u0000*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u000e\u001a\u00020\u0003*\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\r*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a!\u0010\u0013\u001a\u00020\u0003*\u00020\u00122\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u0012*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0018\u001a\u00020\u0003*\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u001a\u001a\u00020\u0017*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001d\u001a\u00020\u0003*\u00020\u001c2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\u001f\u001a\u00020\u001c*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlin/UByteArray;", "Lkotlin/text/HexFormat;", "format", "", "u", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "", "startIndex", "endIndex", "q", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "c", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lkotlin/UByte;", "o", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "a", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lkotlin/UShort;", "s", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "i", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lkotlin/UInt;", "k", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "e", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lkotlin/ULong;", "m", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "g", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class UHexExtensionsKt {
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final byte a(String str, HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UByte.i(HexExtensionsKt.i(str, hexFormat));
    }

    static /* synthetic */ byte b(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UByte.i(HexExtensionsKt.i(str, hexFormat));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final byte[] c(String str, HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UByteArray.g(HexExtensionsKt.m(str, hexFormat));
    }

    static /* synthetic */ byte[] d(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UByteArray.g(HexExtensionsKt.m(str, hexFormat));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final int e(String str, HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UInt.i(HexExtensionsKt.q(str, hexFormat));
    }

    static /* synthetic */ int f(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UInt.i(HexExtensionsKt.q(str, hexFormat));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final long g(String str, HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return ULong.i(HexExtensionsKt.u(str, hexFormat));
    }

    static /* synthetic */ long h(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return ULong.i(HexExtensionsKt.u(str, hexFormat));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final short i(String str, HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UShort.i(HexExtensionsKt.A(str, hexFormat));
    }

    static /* synthetic */ short j(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return UShort.i(HexExtensionsKt.A(str, hexFormat));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final String k(int i2, HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.F(i2, hexFormat);
    }

    static /* synthetic */ String l(int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.F(i2, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final String m(long j2, HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.G(j2, hexFormat);
    }

    static /* synthetic */ String n(long j2, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.G(j2, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final String o(byte b2, HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.E(b2, hexFormat);
    }

    static /* synthetic */ String p(byte b2, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.E(b2, hexFormat);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final String q(byte[] bArr, int i2, int i3, HexFormat hexFormat) {
        Intrinsics.p(bArr, "$this$toHexString");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.I(bArr, i2, i3, hexFormat);
    }

    static /* synthetic */ String r(byte[] bArr, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = UByteArray.r(bArr);
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(bArr, "$this$toHexString");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.I(bArr, i2, i3, hexFormat);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final String s(short s, HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.H(s, hexFormat);
    }

    static /* synthetic */ String t(short s, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.H(s, hexFormat);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final String u(byte[] bArr, HexFormat hexFormat) {
        Intrinsics.p(bArr, "$this$toHexString");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.J(bArr, hexFormat);
    }

    static /* synthetic */ String v(byte[] bArr, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        Intrinsics.p(bArr, "$this$toHexString");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return HexExtensionsKt.J(bArr, hexFormat);
    }
}
