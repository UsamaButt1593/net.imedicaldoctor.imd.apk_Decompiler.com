package net.lingala.zip4j.crypto.engine;

import androidx.media3.extractor.ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import java.lang.reflect.Array;
import net.lingala.zip4j.exception.ZipException;
import okio.Utf8;

public class AESEngine {

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f30562g = {99, 124, 119, 123, -14, 107, 111, -59, ByteBuffer.X2, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.f31404a, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.y, 4, -57, 35, -61, Ascii.B, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.D, Ascii.E, 110, 90, -96, 82, 59, -42, -77, 41, -29, DocWriter.g3, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, DocWriter.b3, -97, -88, 81, -93, SignedBytes.f22967a, -113, -110, -99, 56, -11, -68, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, Ascii.A, -60, -89, 126, 61, 100, 93, Ascii.C, 115, 96, -127, 79, -36, DocWriter.e3, 42, -112, -120, 70, -18, -72, Ascii.x, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.F, -90, -76, -58, -24, -35, 116, Ascii.I, 75, -67, -117, -118, 112, DocWriter.f3, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, Ascii.G, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.H, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, Ascii.z};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f30563h = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, TsExtractor.D, 99, 198, 151, 53, 106, 212, 179, 125, ItemTouchHelper.Callback.f15380c, 239, 197, 145};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f30564i = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};

    /* renamed from: a  reason: collision with root package name */
    private int f30565a;

    /* renamed from: b  reason: collision with root package name */
    private int[][] f30566b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f30567c;

    /* renamed from: d  reason: collision with root package name */
    private int f30568d;

    /* renamed from: e  reason: collision with root package name */
    private int f30569e;

    /* renamed from: f  reason: collision with root package name */
    private int f30570f;

    public AESEngine(byte[] bArr) throws ZipException {
        c(bArr);
    }

    private void a(int[][] iArr) {
        int i2 = this.f30567c;
        int[] iArr2 = iArr[0];
        this.f30567c = i2 ^ iArr2[0];
        this.f30568d ^= iArr2[1];
        this.f30569e ^= iArr2[2];
        char c2 = 3;
        this.f30570f ^= iArr2[3];
        int i3 = 1;
        while (i3 < this.f30565a - 1) {
            int[] iArr3 = f30564i;
            int f2 = (((iArr3[this.f30567c & 255] ^ f(iArr3[(this.f30568d >> 8) & 255], 24)) ^ f(iArr3[(this.f30569e >> 16) & 255], 16)) ^ f(iArr3[(this.f30570f >> 24) & 255], 8)) ^ iArr[i3][0];
            int f3 = (((iArr3[this.f30568d & 255] ^ f(iArr3[(this.f30569e >> 8) & 255], 24)) ^ f(iArr3[(this.f30570f >> 16) & 255], 16)) ^ f(iArr3[(this.f30567c >> 24) & 255], 8)) ^ iArr[i3][1];
            int f4 = (((iArr3[this.f30569e & 255] ^ f(iArr3[(this.f30570f >> 8) & 255], 24)) ^ f(iArr3[(this.f30567c >> 16) & 255], 16)) ^ f(iArr3[(this.f30568d >> 24) & 255], 8)) ^ iArr[i3][2];
            int i4 = i3 + 1;
            int f5 = (((iArr3[this.f30570f & 255] ^ f(iArr3[(this.f30567c >> 8) & 255], 24)) ^ f(iArr3[(this.f30568d >> 16) & 255], 16)) ^ f(iArr3[(this.f30569e >> 24) & 255], 8)) ^ iArr[i3][c2];
            this.f30567c = (((f(iArr3[(f3 >> 8) & 255], 24) ^ iArr3[f2 & 255]) ^ f(iArr3[(f4 >> 16) & 255], 16)) ^ f(iArr3[(f5 >> 24) & 255], 8)) ^ iArr[i4][0];
            this.f30568d = (((iArr3[f3 & 255] ^ f(iArr3[(f4 >> 8) & 255], 24)) ^ f(iArr3[(f5 >> 16) & 255], 16)) ^ f(iArr3[(f2 >> 24) & 255], 8)) ^ iArr[i4][1];
            this.f30569e = (((iArr3[f4 & 255] ^ f(iArr3[(f5 >> 8) & 255], 24)) ^ f(iArr3[(f2 >> 16) & 255], 16)) ^ f(iArr3[(f3 >> 24) & 255], 8)) ^ iArr[i4][2];
            i3 += 2;
            this.f30570f = (f(iArr3[(f4 >> 24) & 255], 8) ^ ((iArr3[f5 & 255] ^ f(iArr3[(f2 >> 8) & 255], 24)) ^ f(iArr3[(f3 >> 16) & 255], 16))) ^ iArr[i4][3];
            c2 = 3;
        }
        int[] iArr4 = f30564i;
        int f6 = (((iArr4[this.f30567c & 255] ^ f(iArr4[(this.f30568d >> 8) & 255], 24)) ^ f(iArr4[(this.f30569e >> 16) & 255], 16)) ^ f(iArr4[(this.f30570f >> 24) & 255], 8)) ^ iArr[i3][0];
        char f7 = (((iArr4[this.f30568d & 255] ^ f(iArr4[(this.f30569e >> 8) & 255], 24)) ^ f(iArr4[(this.f30570f >> 16) & 255], 16)) ^ f(iArr4[(this.f30567c >> 24) & 255], 8)) ^ iArr[i3][1];
        int f8 = (((iArr4[this.f30569e & 255] ^ f(iArr4[(this.f30570f >> 8) & 255], 24)) ^ f(iArr4[(this.f30567c >> 16) & 255], 16)) ^ f(iArr4[(this.f30568d >> 24) & 255], 8)) ^ iArr[i3][2];
        int i5 = i3 + 1;
        int f9 = iArr[i3][3] ^ (f(iArr4[(this.f30569e >> 24) & 255], 8) ^ ((iArr4[this.f30570f & 255] ^ f(iArr4[(this.f30567c >> 8) & 255], 24)) ^ f(iArr4[(this.f30568d >> 16) & 255], 16)));
        byte[] bArr = f30562g;
        int[] iArr5 = iArr[i5];
        this.f30567c = iArr5[0] ^ ((((bArr[f6 & 255] & 255) ^ ((bArr[(f7 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f8 >> 16) & 255] & 255) << 16)) ^ (bArr[(f9 >> 24) & 255] << Ascii.B));
        this.f30568d = ((((bArr[f7 & 255] & 255) ^ ((bArr[(f8 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f9 >> 16) & 255] & 255) << 16)) ^ (bArr[(f6 >> 24) & 255] << Ascii.B)) ^ iArr5[1];
        this.f30569e = ((((bArr[f8 & 255] & 255) ^ ((bArr[(f9 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f6 >> 16) & 255] & 255) << 16)) ^ (bArr[(f7 >> 24) & 255] << Ascii.B)) ^ iArr5[2];
        this.f30570f = ((((bArr[f9 & 255] & 255) ^ ((bArr[(f6 >> 8) & 255] & 255) << 8)) ^ ((bArr[(f7 >> 16) & 255] & 255) << 16)) ^ (bArr[(f8 >> 24) & 255] << Ascii.B)) ^ iArr5[3];
    }

    private int[][] b(byte[] bArr) throws ZipException {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            this.f30565a = length + 6;
            int[] iArr = new int[2];
            iArr[1] = 4;
            int i2 = 0;
            iArr[0] = length + 7;
            int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            int i3 = 0;
            while (i2 < bArr.length) {
                iArr2[i3 >> 2][i3 & 3] = (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | (bArr[i2 + 3] << Ascii.B);
                i2 += 4;
                i3++;
            }
            int i4 = (this.f30565a + 1) << 2;
            for (int i5 = length; i5 < i4; i5++) {
                int i6 = i5 - 1;
                int i7 = iArr2[i6 >> 2][i6 & 3];
                int i8 = i5 % length;
                if (i8 == 0) {
                    i7 = i(f(i7, 8)) ^ f30563h[(i5 / length) - 1];
                } else if (length > 6 && i8 == 4) {
                    i7 = i(i7);
                }
                int i9 = i5 - length;
                iArr2[i5 >> 2][i5 & 3] = i7 ^ iArr2[i9 >> 2][i9 & 3];
            }
            return iArr2;
        }
        throw new ZipException("invalid key length (not 128/192/256)");
    }

    private void c(byte[] bArr) throws ZipException {
        this.f30566b = b(bArr);
    }

    private int f(int i2, int i3) {
        return (i2 << (-i3)) | (i2 >>> i3);
    }

    private void g(byte[] bArr, int i2) {
        byte b2 = bArr[i2] & 255;
        this.f30567c = b2;
        byte b3 = ((bArr[i2 + 1] & 255) << 8) | b2;
        this.f30567c = b3;
        byte b4 = b3 | ((bArr[i2 + 2] & 255) << 16);
        this.f30567c = b4;
        this.f30567c = b4 | (bArr[i2 + 3] << Ascii.B);
        byte b5 = bArr[i2 + 4] & 255;
        this.f30568d = b5;
        byte b6 = ((bArr[i2 + 5] & 255) << 8) | b5;
        this.f30568d = b6;
        byte b7 = b6 | ((bArr[i2 + 6] & 255) << 16);
        this.f30568d = b7;
        this.f30568d = b7 | (bArr[i2 + 7] << Ascii.B);
        byte b8 = bArr[i2 + 8] & 255;
        this.f30569e = b8;
        byte b9 = ((bArr[i2 + 9] & 255) << 8) | b8;
        this.f30569e = b9;
        byte b10 = b9 | ((bArr[i2 + 10] & 255) << 16);
        this.f30569e = b10;
        this.f30569e = b10 | (bArr[i2 + 11] << Ascii.B);
        byte b11 = bArr[i2 + 12] & 255;
        this.f30570f = b11;
        byte b12 = ((bArr[i2 + 13] & 255) << 8) | b11;
        this.f30570f = b12;
        byte b13 = b12 | ((bArr[i2 + 14] & 255) << 16);
        this.f30570f = b13;
        this.f30570f = (bArr[i2 + 15] << Ascii.B) | b13;
    }

    private void h(byte[] bArr, int i2) {
        int i3 = this.f30567c;
        bArr[i2] = (byte) i3;
        bArr[i2 + 1] = (byte) (i3 >> 8);
        bArr[i2 + 2] = (byte) (i3 >> 16);
        bArr[i2 + 3] = (byte) (i3 >> 24);
        int i4 = this.f30568d;
        bArr[i2 + 4] = (byte) i4;
        bArr[i2 + 5] = (byte) (i4 >> 8);
        bArr[i2 + 6] = (byte) (i4 >> 16);
        bArr[i2 + 7] = (byte) (i4 >> 24);
        int i5 = this.f30569e;
        bArr[i2 + 8] = (byte) i5;
        bArr[i2 + 9] = (byte) (i5 >> 8);
        bArr[i2 + 10] = (byte) (i5 >> 16);
        bArr[i2 + 11] = (byte) (i5 >> 24);
        int i6 = this.f30570f;
        bArr[i2 + 12] = (byte) i6;
        bArr[i2 + 13] = (byte) (i6 >> 8);
        bArr[i2 + 14] = (byte) (i6 >> 16);
        bArr[i2 + 15] = (byte) (i6 >> 24);
    }

    private int i(int i2) {
        byte[] bArr = f30562g;
        return (bArr[(i2 >> 24) & 255] << Ascii.B) | (bArr[i2 & 255] & 255) | ((bArr[(i2 >> 8) & 255] & 255) << 8) | ((bArr[(i2 >> 16) & 255] & 255) << 16);
    }

    public int d(byte[] bArr, int i2, byte[] bArr2, int i3) throws ZipException {
        if (this.f30566b == null) {
            throw new ZipException("AES engine not initialised");
        } else if (i2 + 16 > bArr.length) {
            throw new ZipException("input buffer too short");
        } else if (i3 + 16 <= bArr2.length) {
            g(bArr, i2);
            a(this.f30566b);
            h(bArr2, i3);
            return 16;
        } else {
            throw new ZipException("output buffer too short");
        }
    }

    public int e(byte[] bArr, byte[] bArr2) throws ZipException {
        return d(bArr, 0, bArr2, 0);
    }
}
