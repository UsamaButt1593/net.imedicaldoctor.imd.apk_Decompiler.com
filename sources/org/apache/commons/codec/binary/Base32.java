package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import com.itextpdf.text.pdf.ByteBuffer;
import org.apache.commons.codec.binary.BaseNCodec;

public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I};
    private static final byte[] HEX_ENCODE_TABLE = {ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        byte b2;
        int i4 = i3;
        BaseNCodec.Context context2 = context;
        if (!context2.eof) {
            boolean z = true;
            if (i4 < 0) {
                context2.eof = true;
            }
            int i5 = i2;
            int i6 = 0;
            while (true) {
                if (i6 >= i4) {
                    break;
                }
                int i7 = i5 + 1;
                byte b3 = bArr[i5];
                if (b3 == this.pad) {
                    context2.eof = z;
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context2);
                if (b3 >= 0) {
                    byte[] bArr2 = this.decodeTable;
                    if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                        int i8 = (context2.modulus + (z ? 1 : 0)) % 8;
                        context2.modulus = i8;
                        long j2 = (context2.lbitWorkArea << 5) + ((long) b2);
                        context2.lbitWorkArea = j2;
                        if (i8 == 0) {
                            int i9 = context2.pos;
                            int i10 = i9 + 1;
                            context2.pos = i10;
                            ensureBufferSize[i9] = (byte) ((int) ((j2 >> 32) & 255));
                            int i11 = i9 + 2;
                            context2.pos = i11;
                            ensureBufferSize[i10] = (byte) ((int) ((j2 >> 24) & 255));
                            int i12 = i9 + 3;
                            context2.pos = i12;
                            ensureBufferSize[i11] = (byte) ((int) ((j2 >> 16) & 255));
                            int i13 = i9 + 4;
                            context2.pos = i13;
                            ensureBufferSize[i12] = (byte) ((int) ((j2 >> 8) & 255));
                            context2.pos = i9 + 5;
                            ensureBufferSize[i13] = (byte) ((int) (j2 & 255));
                        }
                    }
                }
                i6++;
                i5 = i7;
                z = true;
            }
            if (context2.eof && context2.modulus >= 2) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context2);
                switch (context2.modulus) {
                    case 2:
                        int i14 = context2.pos;
                        context2.pos = i14 + 1;
                        ensureBufferSize2[i14] = (byte) ((int) ((context2.lbitWorkArea >> 2) & 255));
                        return;
                    case 3:
                        int i15 = context2.pos;
                        context2.pos = i15 + 1;
                        ensureBufferSize2[i15] = (byte) ((int) ((context2.lbitWorkArea >> 7) & 255));
                        return;
                    case 4:
                        long j3 = context2.lbitWorkArea;
                        long j4 = j3 >> 4;
                        context2.lbitWorkArea = j4;
                        int i16 = context2.pos;
                        int i17 = i16 + 1;
                        context2.pos = i17;
                        ensureBufferSize2[i16] = (byte) ((int) ((j3 >> 12) & 255));
                        context2.pos = i16 + 2;
                        ensureBufferSize2[i17] = (byte) ((int) (j4 & 255));
                        return;
                    case 5:
                        long j5 = context2.lbitWorkArea;
                        long j6 = j5 >> 1;
                        context2.lbitWorkArea = j6;
                        int i18 = context2.pos;
                        int i19 = i18 + 1;
                        context2.pos = i19;
                        ensureBufferSize2[i18] = (byte) ((int) ((j5 >> 17) & 255));
                        int i20 = i18 + 2;
                        context2.pos = i20;
                        ensureBufferSize2[i19] = (byte) ((int) ((j5 >> 9) & 255));
                        context2.pos = i18 + 3;
                        ensureBufferSize2[i20] = (byte) ((int) (j6 & 255));
                        return;
                    case 6:
                        long j7 = context2.lbitWorkArea;
                        long j8 = j7 >> 6;
                        context2.lbitWorkArea = j8;
                        int i21 = context2.pos;
                        int i22 = i21 + 1;
                        context2.pos = i22;
                        ensureBufferSize2[i21] = (byte) ((int) ((j7 >> 22) & 255));
                        int i23 = i21 + 2;
                        context2.pos = i23;
                        ensureBufferSize2[i22] = (byte) ((int) ((j7 >> 14) & 255));
                        context2.pos = i21 + 3;
                        ensureBufferSize2[i23] = (byte) ((int) (j8 & 255));
                        return;
                    case 7:
                        long j9 = context2.lbitWorkArea;
                        long j10 = j9 >> 3;
                        context2.lbitWorkArea = j10;
                        int i24 = context2.pos;
                        int i25 = i24 + 1;
                        context2.pos = i25;
                        ensureBufferSize2[i24] = (byte) ((int) ((j9 >> 27) & 255));
                        int i26 = i24 + 2;
                        context2.pos = i26;
                        ensureBufferSize2[i25] = (byte) ((int) ((j9 >> 19) & 255));
                        int i27 = i24 + 3;
                        context2.pos = i27;
                        ensureBufferSize2[i26] = (byte) ((int) ((j9 >> 11) & 255));
                        context2.pos = i24 + 4;
                        ensureBufferSize2[i27] = (byte) ((int) (j10 & 255));
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + context2.modulus);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r17, int r18, int r19, org.apache.commons.codec.binary.BaseNCodec.Context r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r20
            boolean r3 = r2.eof
            if (r3 == 0) goto L_0x000b
            return
        L_0x000b:
            r3 = 0
            r4 = 1
            if (r1 >= 0) goto L_0x01d6
            r2.eof = r4
            int r1 = r2.modulus
            if (r1 != 0) goto L_0x001a
            int r1 = r0.lineLength
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            int r1 = r0.encodeSize
            byte[] r1 = r0.ensureBufferSize(r1, r2)
            int r5 = r2.pos
            int r6 = r2.modulus
            if (r6 == 0) goto L_0x01b7
            r7 = 3
            r8 = 2
            if (r6 == r4) goto L_0x0173
            r9 = 4
            if (r6 == r8) goto L_0x011d
            if (r6 == r7) goto L_0x00bc
            if (r6 != r9) goto L_0x00a3
            int r4 = r5 + 1
            r2.pos = r4
            byte[] r6 = r0.encodeTable
            long r9 = r2.lbitWorkArea
            r11 = 27
            long r11 = r9 >> r11
            int r12 = (int) r11
            r11 = r12 & 31
            byte r11 = r6[r11]
            r1[r5] = r11
            int r11 = r5 + 2
            r2.pos = r11
            r12 = 22
            long r12 = r9 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r6[r12]
            r1[r4] = r12
            int r4 = r5 + 3
            r2.pos = r4
            r12 = 17
            long r12 = r9 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r6[r12]
            r1[r11] = r12
            int r11 = r5 + 4
            r2.pos = r11
            r12 = 12
            long r12 = r9 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r6[r12]
            r1[r4] = r12
            int r4 = r5 + 5
            r2.pos = r4
            r12 = 7
            long r12 = r9 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r6[r12]
            r1[r11] = r12
            int r11 = r5 + 6
            r2.pos = r11
            long r12 = r9 >> r8
            int r8 = (int) r12
            r8 = r8 & 31
            byte r8 = r6[r8]
            r1[r4] = r8
            int r4 = r5 + 7
            r2.pos = r4
            long r7 = r9 << r7
            int r8 = (int) r7
            r7 = r8 & 31
            byte r6 = r6[r7]
            r1[r11] = r6
            int r6 = r5 + 8
            r2.pos = r6
            byte r6 = r0.pad
            r1[r4] = r6
            goto L_0x01b7
        L_0x00a3:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Impossible modulus "
            r3.append(r4)
            int r2 = r2.modulus
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x00bc:
            int r6 = r5 + 1
            r2.pos = r6
            byte[] r7 = r0.encodeTable
            long r10 = r2.lbitWorkArea
            r8 = 19
            long r12 = r10 >> r8
            int r8 = (int) r12
            r8 = r8 & 31
            byte r8 = r7[r8]
            r1[r5] = r8
            int r8 = r5 + 2
            r2.pos = r8
            r12 = 14
            long r12 = r10 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r7[r12]
            r1[r6] = r12
            int r6 = r5 + 3
            r2.pos = r6
            r12 = 9
            long r12 = r10 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r7[r12]
            r1[r8] = r12
            int r8 = r5 + 4
            r2.pos = r8
            long r12 = r10 >> r9
            int r9 = (int) r12
            r9 = r9 & 31
            byte r9 = r7[r9]
            r1[r6] = r9
            int r6 = r5 + 5
            r2.pos = r6
            long r9 = r10 << r4
            int r4 = (int) r9
            r4 = r4 & 31
            byte r4 = r7[r4]
            r1[r8] = r4
            int r4 = r5 + 6
            r2.pos = r4
            byte r7 = r0.pad
            r1[r6] = r7
            int r6 = r5 + 7
            r2.pos = r6
            r1[r4] = r7
            int r4 = r5 + 8
            r2.pos = r4
            r1[r6] = r7
            goto L_0x01b7
        L_0x011d:
            int r6 = r5 + 1
            r2.pos = r6
            byte[] r7 = r0.encodeTable
            long r10 = r2.lbitWorkArea
            r8 = 11
            long r12 = r10 >> r8
            int r8 = (int) r12
            r8 = r8 & 31
            byte r8 = r7[r8]
            r1[r5] = r8
            int r8 = r5 + 2
            r2.pos = r8
            r12 = 6
            long r12 = r10 >> r12
            int r13 = (int) r12
            r12 = r13 & 31
            byte r12 = r7[r12]
            r1[r6] = r12
            int r6 = r5 + 3
            r2.pos = r6
            long r12 = r10 >> r4
            int r4 = (int) r12
            r4 = r4 & 31
            byte r4 = r7[r4]
            r1[r8] = r4
            int r4 = r5 + 4
            r2.pos = r4
            long r8 = r10 << r9
            int r9 = (int) r8
            r8 = r9 & 31
            byte r7 = r7[r8]
            r1[r6] = r7
            int r6 = r5 + 5
            r2.pos = r6
            byte r7 = r0.pad
            r1[r4] = r7
            int r4 = r5 + 6
            r2.pos = r4
            r1[r6] = r7
            int r6 = r5 + 7
            r2.pos = r6
            r1[r4] = r7
            int r4 = r5 + 8
            r2.pos = r4
            r1[r6] = r7
            goto L_0x01b7
        L_0x0173:
            int r4 = r5 + 1
            r2.pos = r4
            byte[] r6 = r0.encodeTable
            long r9 = r2.lbitWorkArea
            long r11 = r9 >> r7
            int r7 = (int) r11
            r7 = r7 & 31
            byte r7 = r6[r7]
            r1[r5] = r7
            int r7 = r5 + 2
            r2.pos = r7
            long r8 = r9 << r8
            int r9 = (int) r8
            r8 = r9 & 31
            byte r6 = r6[r8]
            r1[r4] = r6
            int r4 = r5 + 3
            r2.pos = r4
            byte r6 = r0.pad
            r1[r7] = r6
            int r7 = r5 + 4
            r2.pos = r7
            r1[r4] = r6
            int r4 = r5 + 5
            r2.pos = r4
            r1[r7] = r6
            int r7 = r5 + 6
            r2.pos = r7
            r1[r4] = r6
            int r4 = r5 + 7
            r2.pos = r4
            r1[r7] = r6
            int r7 = r5 + 8
            r2.pos = r7
            r1[r4] = r6
        L_0x01b7:
            int r4 = r2.currentLinePos
            int r6 = r2.pos
            int r5 = r6 - r5
            int r4 = r4 + r5
            r2.currentLinePos = r4
            int r5 = r0.lineLength
            if (r5 <= 0) goto L_0x029a
            if (r4 <= 0) goto L_0x029a
            byte[] r4 = r0.lineSeparator
            int r5 = r4.length
            java.lang.System.arraycopy(r4, r3, r1, r6, r5)
            int r1 = r2.pos
            byte[] r3 = r0.lineSeparator
            int r3 = r3.length
            int r1 = r1 + r3
            r2.pos = r1
            goto L_0x029a
        L_0x01d6:
            r5 = r18
            r6 = 0
        L_0x01d9:
            if (r6 >= r1) goto L_0x029a
            int r7 = r0.encodeSize
            byte[] r7 = r0.ensureBufferSize(r7, r2)
            int r8 = r2.modulus
            int r8 = r8 + r4
            r9 = 5
            int r8 = r8 % r9
            r2.modulus = r8
            int r10 = r5 + 1
            byte r5 = r17[r5]
            if (r5 >= 0) goto L_0x01f0
            int r5 = r5 + 256
        L_0x01f0:
            long r11 = r2.lbitWorkArea
            r13 = 8
            long r11 = r11 << r13
            long r14 = (long) r5
            long r11 = r11 + r14
            r2.lbitWorkArea = r11
            if (r8 != 0) goto L_0x0291
            int r5 = r2.pos
            int r8 = r5 + 1
            r2.pos = r8
            byte[] r14 = r0.encodeTable
            r15 = 35
            long r3 = r11 >> r15
            int r4 = (int) r3
            r3 = r4 & 31
            byte r3 = r14[r3]
            r7[r5] = r3
            int r3 = r5 + 2
            r2.pos = r3
            r4 = 30
            r15 = r10
            long r9 = r11 >> r4
            int r4 = (int) r9
            r4 = r4 & 31
            byte r4 = r14[r4]
            r7[r8] = r4
            int r4 = r5 + 3
            r2.pos = r4
            r8 = 25
            long r8 = r11 >> r8
            int r9 = (int) r8
            r8 = r9 & 31
            byte r8 = r14[r8]
            r7[r3] = r8
            int r3 = r5 + 4
            r2.pos = r3
            r8 = 20
            long r8 = r11 >> r8
            int r9 = (int) r8
            r8 = r9 & 31
            byte r8 = r14[r8]
            r7[r4] = r8
            int r4 = r5 + 5
            r2.pos = r4
            r8 = 15
            long r8 = r11 >> r8
            int r9 = (int) r8
            r8 = r9 & 31
            byte r8 = r14[r8]
            r7[r3] = r8
            int r3 = r5 + 6
            r2.pos = r3
            r8 = 10
            long r8 = r11 >> r8
            int r9 = (int) r8
            r8 = r9 & 31
            byte r8 = r14[r8]
            r7[r4] = r8
            int r4 = r5 + 7
            r2.pos = r4
            r8 = 5
            long r8 = r11 >> r8
            int r9 = (int) r8
            r8 = r9 & 31
            byte r8 = r14[r8]
            r7[r3] = r8
            int r5 = r5 + r13
            r2.pos = r5
            int r3 = (int) r11
            r3 = r3 & 31
            byte r3 = r14[r3]
            r7[r4] = r3
            int r3 = r2.currentLinePos
            int r3 = r3 + r13
            r2.currentLinePos = r3
            int r4 = r0.lineLength
            if (r4 <= 0) goto L_0x028f
            if (r4 > r3) goto L_0x028f
            byte[] r3 = r0.lineSeparator
            int r4 = r3.length
            r8 = 0
            java.lang.System.arraycopy(r3, r8, r7, r5, r4)
            int r3 = r2.pos
            byte[] r4 = r0.lineSeparator
            int r4 = r4.length
            int r3 = r3 + r4
            r2.pos = r3
            r2.currentLinePos = r8
            goto L_0x0293
        L_0x028f:
            r8 = 0
            goto L_0x0293
        L_0x0291:
            r15 = r10
            goto L_0x028f
        L_0x0293:
            int r6 = r6 + 1
            r5 = r15
            r3 = 0
            r4 = 1
            goto L_0x01d9
        L_0x029a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base32.encode(byte[], int, int, org.apache.commons.codec.binary.BaseNCodec$Context):void");
    }

    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            return b2 < bArr.length && bArr[b2] != -1;
        }
    }

    public Base32(byte b2) {
        this(false, b2);
    }

    public Base32(int i2) {
        this(i2, CHUNK_SEPARATOR);
    }

    public Base32(int i2, byte[] bArr) {
        this(i2, bArr, false, (byte) 61);
    }

    public Base32(int i2, byte[] bArr, boolean z) {
        this(i2, bArr, z, (byte) 61);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base32(int i2, byte[] bArr, boolean z, byte b2) {
        super(5, 8, i2, bArr == null ? 0 : bArr.length, b2);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i2 <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            throw new IllegalArgumentException("lineLength " + i2 + " > 0, but lineSeparator is null");
        } else if (!containsAlphabetOrPad(bArr)) {
            this.encodeSize = bArr.length + 8;
            byte[] bArr2 = new byte[bArr.length];
            this.lineSeparator = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        } else {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + "]");
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b2) || BaseNCodec.isWhiteSpace(b2)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }

    public Base32(boolean z) {
        this(0, (byte[]) null, z, (byte) 61);
    }

    public Base32(boolean z, byte b2) {
        this(0, (byte[]) null, z, b2);
    }
}
