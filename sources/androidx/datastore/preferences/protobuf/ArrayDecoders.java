package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

final class ArrayDecoders {

    /* renamed from: androidx.datastore.preferences.protobuf.ArrayDecoders$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6975a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6975a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f6975a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.<clinit>():void");
        }
    }

    static final class Registers {

        /* renamed from: a  reason: collision with root package name */
        public int f6976a;

        /* renamed from: b  reason: collision with root package name */
        public long f6977b;

        /* renamed from: c  reason: collision with root package name */
        public Object f6978c;

        /* renamed from: d  reason: collision with root package name */
        public final ExtensionRegistryLite f6979d;

        Registers() {
            this.f6979d = ExtensionRegistryLite.d();
        }

        Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.f6979d = extensionRegistryLite;
        }
    }

    ArrayDecoders() {
    }

    static int A(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i3, registers);
        while (true) {
            intArrayList.h0(CodedInputStream.b(registers.f6976a));
            if (I >= i4) {
                break;
            }
            int I2 = I(bArr, I, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            I = I(bArr, I2, registers);
        }
        return I;
    }

    static int B(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i3, registers);
        while (true) {
            longArrayList.S0(CodedInputStream.c(registers.f6977b));
            if (L >= i4) {
                break;
            }
            int I = I(bArr, L, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            L = L(bArr, I, registers);
        }
        return L;
    }

    static int C(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.g();
        } else if (i3 == 0) {
            registers.f6978c = "";
            return I;
        } else {
            registers.f6978c = new String(bArr, I, i3, Internal.f7166a);
            return I + i3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int D(int r4, byte[] r5, int r6, int r7, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r8, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r9) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f6976a
            if (r0 < 0) goto L_0x003f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
        L_0x000c:
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.Internal.f7166a
            r2.<init>(r5, r6, r0, r3)
        L_0x0017:
            r8.add(r2)
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x003e
            int r0 = I(r5, r6, r9)
            int r2 = r9.f6976a
            if (r4 == r2) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f6976a
            if (r0 < 0) goto L_0x0039
            if (r0 != 0) goto L_0x0031
            goto L_0x000c
        L_0x0031:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.Internal.f7166a
            r2.<init>(r5, r6, r0, r3)
            goto L_0x0017
        L_0x0039:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r4
        L_0x003e:
            return r6
        L_0x003f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.D(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int E(int r5, byte[] r6, int r7, int r8, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r9, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r10) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f6976a
            if (r0 < 0) goto L_0x0059
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
        L_0x000c:
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.u(r6, r7, r2)
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.Internal.f7166a
            r3.<init>(r6, r7, r0, r4)
        L_0x001f:
            r9.add(r3)
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0053
            int r0 = I(r6, r7, r10)
            int r2 = r10.f6976a
            if (r5 == r2) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f6976a
            if (r0 < 0) goto L_0x004e
            if (r0 != 0) goto L_0x0039
            goto L_0x000c
        L_0x0039:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.u(r6, r7, r2)
            if (r3 == 0) goto L_0x0049
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.Internal.f7166a
            r3.<init>(r6, r7, r0, r4)
            goto L_0x001f
        L_0x0049:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.d()
            throw r5
        L_0x004e:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r5
        L_0x0053:
            return r7
        L_0x0054:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.d()
            throw r5
        L_0x0059:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.E(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static int F(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.g();
        } else if (i3 == 0) {
            registers.f6978c = "";
            return I;
        } else {
            registers.f6978c = Utf8.h(bArr, I, i3);
            return I + i3;
        }
    }

    static int G(int i2, byte[] bArr, int i3, int i4, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i2) != 0) {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                int L = L(bArr, i3, registers);
                unknownFieldSetLite.r(i2, Long.valueOf(registers.f6977b));
                return L;
            } else if (b2 == 1) {
                unknownFieldSetLite.r(i2, Long.valueOf(j(bArr, i3)));
                return i3 + 8;
            } else if (b2 == 2) {
                int I = I(bArr, i3, registers);
                int i5 = registers.f6976a;
                if (i5 < 0) {
                    throw InvalidProtocolBufferException.g();
                } else if (i5 <= bArr.length - I) {
                    unknownFieldSetLite.r(i2, i5 == 0 ? ByteString.X2 : ByteString.z(bArr, I, i5));
                    return I + i5;
                } else {
                    throw InvalidProtocolBufferException.l();
                }
            } else if (b2 == 3) {
                UnknownFieldSetLite p = UnknownFieldSetLite.p();
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int I2 = I(bArr, i3, registers);
                    int i8 = registers.f6976a;
                    i7 = i8;
                    if (i8 == i6) {
                        i3 = I2;
                        break;
                    }
                    int G = G(i7, bArr, I2, i4, p, registers);
                    i7 = i8;
                    i3 = G;
                }
                if (i3 > i4 || i7 != i6) {
                    throw InvalidProtocolBufferException.h();
                }
                unknownFieldSetLite.r(i2, p);
                return i3;
            } else if (b2 == 5) {
                unknownFieldSetLite.r(i2, Integer.valueOf(h(bArr, i3)));
                return i3 + 4;
            } else {
                throw InvalidProtocolBufferException.c();
            }
        } else {
            throw InvalidProtocolBufferException.c();
        }
    }

    static int H(int i2, byte[] bArr, int i3, Registers registers) {
        int i4;
        int i5 = i2 & WorkQueueKt.f29430c;
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            i4 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i3 + 2;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                registers.f6976a = i7 | (b3 << 14);
                return i8;
            }
            i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
            i6 = i3 + 3;
            byte b4 = bArr[i8];
            if (b4 >= 0) {
                i4 = b4 << Ascii.y;
            } else {
                int i9 = i5 | ((b4 & Byte.MAX_VALUE) << Ascii.y);
                int i10 = i3 + 4;
                byte b5 = bArr[i6];
                if (b5 >= 0) {
                    registers.f6976a = i9 | (b5 << Ascii.F);
                    return i10;
                }
                int i11 = i9 | ((b5 & Byte.MAX_VALUE) << Ascii.F);
                while (true) {
                    int i12 = i10 + 1;
                    if (bArr[i10] < 0) {
                        i10 = i12;
                    } else {
                        registers.f6976a = i11;
                        return i12;
                    }
                }
            }
        }
        registers.f6976a = i5 | i4;
        return i6;
    }

    static int I(byte[] bArr, int i2, Registers registers) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return H(b2, bArr, i3, registers);
        }
        registers.f6976a = b2;
        return i3;
    }

    static int J(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i3, registers);
        while (true) {
            intArrayList.h0(registers.f6976a);
            if (I >= i4) {
                break;
            }
            int I2 = I(bArr, I, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            I = I(bArr, I2, registers);
        }
        return I;
    }

    static int K(long j2, byte[] bArr, int i2, Registers registers) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j3 = (j2 & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j3 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            byte b4 = b3;
            i3 = i5;
            b2 = b4;
        }
        registers.f6977b = j3;
        return i3;
    }

    static int L(byte[] bArr, int i2, Registers registers) {
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        if (j2 < 0) {
            return K(j2, bArr, i3, registers);
        }
        registers.f6977b = j2;
        return i3;
    }

    static int M(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i3, registers);
        while (true) {
            longArrayList.S0(registers.f6977b);
            if (L >= i4) {
                break;
            }
            int I = I(bArr, L, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            L = L(bArr, I, registers);
        }
        return L;
    }

    static int N(int i2, byte[] bArr, int i3, int i4, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.a(i2) != 0) {
            int b2 = WireFormat.b(i2);
            if (b2 == 0) {
                return L(bArr, i3, registers);
            }
            if (b2 == 1) {
                return i3 + 8;
            }
            if (b2 == 2) {
                return I(bArr, i3, registers) + registers.f6976a;
            }
            if (b2 == 3) {
                int i5 = (i2 & -8) | 4;
                int i6 = 0;
                while (i3 < i4) {
                    i3 = I(bArr, i3, registers);
                    i6 = registers.f6976a;
                    if (i6 == i5) {
                        break;
                    }
                    i3 = N(i6, bArr, i3, i4, registers);
                }
                if (i3 <= i4 && i6 == i5) {
                    return i3;
                }
                throw InvalidProtocolBufferException.h();
            } else if (b2 == 5) {
                return i3 + 4;
            } else {
                throw InvalidProtocolBufferException.c();
            }
        } else {
            throw InvalidProtocolBufferException.c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x000e, code lost:
        if (r12.f6977b != 0) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r11.c1(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (r9 >= r10) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = I(r8, r9, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r7 == r12.f6976a) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r9 = L(r8, r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r12.f6977b == 0) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int a(int r7, byte[] r8, int r9, int r10, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r11, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r12) {
        /*
            androidx.datastore.preferences.protobuf.BooleanArrayList r11 = (androidx.datastore.preferences.protobuf.BooleanArrayList) r11
            int r9 = L(r8, r9, r12)
            long r0 = r12.f6977b
            r2 = 0
            r3 = 1
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0012
        L_0x0010:
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            r11.c1(r0)
            if (r9 >= r10) goto L_0x002c
            int r0 = I(r8, r9, r12)
            int r1 = r12.f6976a
            if (r7 == r1) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            int r9 = L(r8, r0, r12)
            long r0 = r12.f6977b
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0012
            goto L_0x0010
        L_0x002c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.a(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static int b(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a;
        if (i3 < 0) {
            throw InvalidProtocolBufferException.g();
        } else if (i3 > bArr.length - I) {
            throw InvalidProtocolBufferException.l();
        } else if (i3 == 0) {
            registers.f6978c = ByteString.X2;
            return I;
        } else {
            registers.f6978c = ByteString.z(bArr, I, i3);
            return I + i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r4 = I(r3, r0, r7);
        r0 = r7.f6976a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r0 < 0) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r0 > (r3.length - r4)) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        if (r0 != 0) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        if (r0 == 0) goto L_0x000e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r6.add(androidx.datastore.preferences.protobuf.ByteString.X2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r6.add(androidx.datastore.preferences.protobuf.ByteString.z(r3, r4, r0));
        r4 = r4 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r4 >= r5) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0 = I(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r2 == r7.f6976a) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int c(int r2, byte[] r3, int r4, int r5, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r6, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r7) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f6976a
            if (r0 < 0) goto L_0x0046
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0041
            if (r0 != 0) goto L_0x0014
        L_0x000e:
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.X2
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.z(r3, r4, r0)
            r6.add(r1)
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x0040
            int r0 = I(r3, r4, r7)
            int r1 = r7.f6976a
            if (r2 == r1) goto L_0x0027
            goto L_0x0040
        L_0x0027:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f6976a
            if (r0 < 0) goto L_0x003b
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0036
            if (r0 != 0) goto L_0x0014
            goto L_0x000e
        L_0x0036:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()
            throw r2
        L_0x003b:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r2
        L_0x0040:
            return r4
        L_0x0041:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()
            throw r2
        L_0x0046:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.c(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static double d(byte[] bArr, int i2) {
        return Double.longBitsToDouble(j(bArr, i2));
    }

    static int e(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.k1(d(bArr, i3));
        int i5 = i3 + 8;
        while (i5 < i4) {
            int I = I(bArr, i5, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            doubleArrayList.k1(d(bArr, I));
            i5 = I + 8;
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0126, code lost:
        r2 = r14.f6978c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0163, code lost:
        r2 = java.lang.Long.valueOf(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x018f, code lost:
        r9 = r9 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x019a, code lost:
        r9 = r9 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int f(int r7, byte[] r8, int r9, int r10, androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r11, androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r12, androidx.datastore.preferences.protobuf.UnknownFieldSchema<androidx.datastore.preferences.protobuf.UnknownFieldSetLite, androidx.datastore.preferences.protobuf.UnknownFieldSetLite> r13, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r14) throws java.io.IOException {
        /*
            androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r11.extensions
            int r7 = r7 >>> 3
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r12.f7163d
            boolean r1 = r1.M()
            r2 = 0
            if (r1 == 0) goto L_0x00cb
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r1 = r12.f7163d
            boolean r1 = r1.a2()
            if (r1 == 0) goto L_0x00cb
            int[] r10 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.f6975a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r12.b()
            int r1 = r1.ordinal()
            r10 = r10[r1]
            switch(r10) {
                case 1: goto L_0x00c1;
                case 2: goto L_0x00b7;
                case 3: goto L_0x00ad;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a3;
                case 6: goto L_0x00a3;
                case 7: goto L_0x0099;
                case 8: goto L_0x0099;
                case 9: goto L_0x008f;
                case 10: goto L_0x008f;
                case 11: goto L_0x0085;
                case 12: goto L_0x007b;
                case 13: goto L_0x006b;
                case 14: goto L_0x0041;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.f7163d
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.V()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0041:
            androidx.datastore.preferences.protobuf.IntArrayList r10 = new androidx.datastore.preferences.protobuf.IntArrayList
            r10.<init>()
            int r8 = y(r8, r9, r10, r14)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r9 = r11.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r14 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.e()
            if (r9 != r14) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r9
        L_0x0054:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.f7163d
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r9 = r9.b1()
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.SchemaUtil.B(r7, r10, r9, r2, r13)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r7 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r7
            if (r7 == 0) goto L_0x0064
            r11.unknownFields = r7
        L_0x0064:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.f7163d
            r0.O(r7, r10)
            goto L_0x01ef
        L_0x006b:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = x(r8, r9, r7, r14)
        L_0x0074:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.f7163d
            r0.O(r9, r7)
            goto L_0x01ef
        L_0x007b:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = w(r8, r9, r7, r14)
            goto L_0x0074
        L_0x0085:
            androidx.datastore.preferences.protobuf.BooleanArrayList r7 = new androidx.datastore.preferences.protobuf.BooleanArrayList
            r7.<init>()
            int r8 = r(r8, r9, r7, r14)
            goto L_0x0074
        L_0x008f:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = t(r8, r9, r7, r14)
            goto L_0x0074
        L_0x0099:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = u(r8, r9, r7, r14)
            goto L_0x0074
        L_0x00a3:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = y(r8, r9, r7, r14)
            goto L_0x0074
        L_0x00ad:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = z(r8, r9, r7, r14)
            goto L_0x0074
        L_0x00b7:
            androidx.datastore.preferences.protobuf.FloatArrayList r7 = new androidx.datastore.preferences.protobuf.FloatArrayList
            r7.<init>()
            int r8 = v(r8, r9, r7, r14)
            goto L_0x0074
        L_0x00c1:
            androidx.datastore.preferences.protobuf.DoubleArrayList r7 = new androidx.datastore.preferences.protobuf.DoubleArrayList
            r7.<init>()
            int r8 = s(r8, r9, r7, r14)
            goto L_0x0074
        L_0x00cb:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r12.b()
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
            if (r1 != r3) goto L_0x0101
            int r9 = I(r8, r9, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.f7163d
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r8 = r8.b1()
            int r10 = r14.f6976a
            androidx.datastore.preferences.protobuf.Internal$EnumLite r8 = r8.a(r10)
            if (r8 != 0) goto L_0x00f9
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r8 = r11.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r10 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.e()
            if (r8 != r10) goto L_0x00f3
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r8 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.p()
            r11.unknownFields = r8
        L_0x00f3:
            int r10 = r14.f6976a
            androidx.datastore.preferences.protobuf.SchemaUtil.Q(r7, r10, r8, r13)
            return r9
        L_0x00f9:
            int r7 = r14.f6976a
        L_0x00fb:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x01bc
        L_0x0101:
            int[] r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.f6975a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r13 = r12.b()
            int r13 = r13.ordinal()
            r11 = r11[r13]
            switch(r11) {
                case 1: goto L_0x01b3;
                case 2: goto L_0x01aa;
                case 3: goto L_0x01a3;
                case 4: goto L_0x01a3;
                case 5: goto L_0x019d;
                case 6: goto L_0x019d;
                case 7: goto L_0x0192;
                case 8: goto L_0x0192;
                case 9: goto L_0x0187;
                case 10: goto L_0x0187;
                case 11: goto L_0x0173;
                case 12: goto L_0x0168;
                case 13: goto L_0x0159;
                case 14: goto L_0x0151;
                case 15: goto L_0x014c;
                case 16: goto L_0x0147;
                case 17: goto L_0x012a;
                case 18: goto L_0x0112;
                default: goto L_0x0110;
            }
        L_0x0110:
            goto L_0x01bc
        L_0x0112:
            androidx.datastore.preferences.protobuf.Protobuf r7 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r11 = r12.c()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.Schema r7 = r7.i(r11)
            int r9 = p(r7, r8, r9, r10, r14)
        L_0x0126:
            java.lang.Object r2 = r14.f6978c
            goto L_0x01bc
        L_0x012a:
            int r7 = r7 << 3
            r5 = r7 | 4
            androidx.datastore.preferences.protobuf.Protobuf r7 = androidx.datastore.preferences.protobuf.Protobuf.a()
            androidx.datastore.preferences.protobuf.MessageLite r11 = r12.c()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.Schema r1 = r7.i(r11)
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r14
            int r9 = n(r1, r2, r3, r4, r5, r6)
            goto L_0x0126
        L_0x0147:
            int r9 = C(r8, r9, r14)
            goto L_0x0126
        L_0x014c:
            int r9 = b(r8, r9, r14)
            goto L_0x0126
        L_0x0151:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x0159:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f6977b
            long r7 = androidx.datastore.preferences.protobuf.CodedInputStream.c(r7)
        L_0x0163:
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            goto L_0x01bc
        L_0x0168:
            int r9 = I(r8, r9, r14)
            int r7 = r14.f6976a
            int r7 = androidx.datastore.preferences.protobuf.CodedInputStream.b(r7)
            goto L_0x00fb
        L_0x0173:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f6977b
            r10 = 0
            int r13 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r13 == 0) goto L_0x0181
            r7 = 1
            goto L_0x0182
        L_0x0181:
            r7 = 0
        L_0x0182:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)
            goto L_0x01bc
        L_0x0187:
            int r7 = h(r8, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
        L_0x018f:
            int r9 = r9 + 4
            goto L_0x01bc
        L_0x0192:
            long r7 = j(r8, r9)
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
        L_0x019a:
            int r9 = r9 + 8
            goto L_0x01bc
        L_0x019d:
            int r9 = I(r8, r9, r14)
            goto L_0x00f9
        L_0x01a3:
            int r9 = L(r8, r9, r14)
            long r7 = r14.f6977b
            goto L_0x0163
        L_0x01aa:
            float r7 = l(r8, r9)
            java.lang.Float r2 = java.lang.Float.valueOf(r7)
            goto L_0x018f
        L_0x01b3:
            double r7 = d(r8, r9)
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            goto L_0x019a
        L_0x01bc:
            boolean r7 = r12.f()
            if (r7 == 0) goto L_0x01c8
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.f7163d
            r0.h(r7, r2)
            goto L_0x01ee
        L_0x01c8:
            int[] r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.f6975a
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r8 = r12.b()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 17
            if (r7 == r8) goto L_0x01dd
            r8 = 18
            if (r7 == r8) goto L_0x01dd
            goto L_0x01e9
        L_0x01dd:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.f7163d
            java.lang.Object r7 = r0.u(r7)
            if (r7 == 0) goto L_0x01e9
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.Internal.v(r7, r2)
        L_0x01e9:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.f7163d
            r0.O(r7, r2)
        L_0x01ee:
            r8 = r9
        L_0x01ef:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.f(int, byte[], int, int, androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage, androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static int g(int i2, byte[] bArr, int i3, int i4, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension c2 = registers.f6979d.c(messageLite, i2 >>> 3);
        if (c2 == null) {
            return G(i2, bArr, i3, i4, MessageSchema.w(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.M2();
        return f(i2, bArr, i3, i4, extendableMessage, c2, unknownFieldSchema, registers);
    }

    static int h(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << Ascii.B) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    static int i(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.h0(h(bArr, i3));
        int i5 = i3 + 4;
        while (i5 < i4) {
            int I = I(bArr, i5, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            intArrayList.h0(h(bArr, I));
            i5 = I + 4;
        }
        return i5;
    }

    static long j(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    static int k(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.S0(j(bArr, i3));
        int i5 = i3 + 8;
        while (i5 < i4) {
            int I = I(bArr, i5, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            longArrayList.S0(j(bArr, I));
            i5 = I + 8;
        }
        return i5;
    }

    static float l(byte[] bArr, int i2) {
        return Float.intBitsToFloat(h(bArr, i2));
    }

    static int m(int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.J(l(bArr, i3));
        int i5 = i3 + 4;
        while (i5 < i4) {
            int I = I(bArr, i5, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            floatArrayList.J(l(bArr, I));
            i5 = I + 4;
        }
        return i5;
    }

    static int n(Schema schema, byte[] bArr, int i2, int i3, int i4, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object h2 = messageSchema.h();
        int e0 = messageSchema.e0(h2, bArr, i2, i3, i4, registers);
        messageSchema.c(h2);
        registers.f6978c = h2;
        return e0;
    }

    static int o(Schema schema, int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i5 = (i2 & -8) | 4;
        int n2 = n(schema, bArr, i3, i4, i5, registers);
        while (true) {
            protobufList.add(registers.f6978c);
            if (n2 >= i4) {
                break;
            }
            int I = I(bArr, n2, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            n2 = n(schema, bArr, I, i4, i5, registers);
        }
        return n2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int p(androidx.datastore.preferences.protobuf.Schema r6, byte[] r7, int r8, int r9, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = H(r8, r7, r0, r10)
            int r8 = r10.f6976a
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.h()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.i(r1, r2, r3, r4, r5)
            r6.c(r9)
            r10.f6978c = r9
            return r8
        L_0x0025:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.l()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.p(androidx.datastore.preferences.protobuf.Schema, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static int q(Schema<?> schema, int i2, byte[] bArr, int i3, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int p = p(schema, bArr, i3, i4, registers);
        while (true) {
            protobufList.add(registers.f6978c);
            if (p >= i4) {
                break;
            }
            int I = I(bArr, p, registers);
            if (i2 != registers.f6976a) {
                break;
            }
            p = p(schema, bArr, I, i4, registers);
        }
        return p;
    }

    static int r(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            I = L(bArr, I, registers);
            booleanArrayList.c1(registers.f6977b != 0);
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int s(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            doubleArrayList.k1(d(bArr, I));
            I += 8;
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int t(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            intArrayList.h0(h(bArr, I));
            I += 4;
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int u(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            longArrayList.S0(j(bArr, I));
            I += 8;
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int v(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            floatArrayList.J(l(bArr, I));
            I += 4;
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int w(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            I = I(bArr, I, registers);
            intArrayList.h0(CodedInputStream.b(registers.f6976a));
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int x(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            I = L(bArr, I, registers);
            longArrayList.S0(CodedInputStream.c(registers.f6977b));
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int y(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            I = I(bArr, I, registers);
            intArrayList.h0(registers.f6976a);
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }

    static int z(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i2, registers);
        int i3 = registers.f6976a + I;
        while (I < i3) {
            I = L(bArr, I, registers);
            longArrayList.S0(registers.f6977b);
        }
        if (I == i3) {
            return I;
        }
        throw InvalidProtocolBufferException.l();
    }
}
