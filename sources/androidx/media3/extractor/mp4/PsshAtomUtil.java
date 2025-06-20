package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;
import java.util.UUID;

@UnstableApi
public final class PsshAtomUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13621a = "PsshAtomUtil";

    public static final class PsshAtom {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f13622a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13623b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f13624c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final UUID[] f13625d;

        PsshAtom(UUID uuid, int i2, byte[] bArr, @Nullable UUID[] uuidArr) {
            this.f13622a = uuid;
            this.f13623b = i2;
            this.f13624c = bArr;
            this.f13625d = uuidArr;
        }
    }

    private PsshAtomUtil() {
    }

    public static byte[] a(UUID uuid, @Nullable byte[] bArr) {
        return b(uuid, (UUID[]) null, bArr);
    }

    public static byte[] b(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(Atom.z0);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            allocate.putInt(0);
        } else {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @Nullable
    public static PsshAtom d(byte[] bArr) {
        UUID[] uuidArr;
        StringBuilder sb;
        String str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        if (parsableByteArray.g() < 32) {
            return null;
        }
        parsableByteArray.Y(0);
        int a2 = parsableByteArray.a();
        int s = parsableByteArray.s();
        if (s != a2) {
            sb = new StringBuilder();
            sb.append("Advertised atom size (");
            sb.append(s);
            str = ") does not match buffer size: ";
        } else {
            a2 = parsableByteArray.s();
            if (a2 != 1886614376) {
                sb = new StringBuilder();
                str = "Atom type is not pssh: ";
            } else {
                a2 = Atom.c(parsableByteArray.s());
                if (a2 > 1) {
                    sb = new StringBuilder();
                    str = "Unsupported pssh version: ";
                } else {
                    UUID uuid = new UUID(parsableByteArray.E(), parsableByteArray.E());
                    if (a2 == 1) {
                        int P = parsableByteArray.P();
                        uuidArr = new UUID[P];
                        for (int i2 = 0; i2 < P; i2++) {
                            uuidArr[i2] = new UUID(parsableByteArray.E(), parsableByteArray.E());
                        }
                    } else {
                        uuidArr = null;
                    }
                    int P2 = parsableByteArray.P();
                    int a3 = parsableByteArray.a();
                    if (P2 != a3) {
                        sb = new StringBuilder();
                        sb.append("Atom data size (");
                        sb.append(P2);
                        sb.append(") does not match the bytes left: ");
                        sb.append(a3);
                        Log.n(f13621a, sb.toString());
                        return null;
                    }
                    byte[] bArr2 = new byte[P2];
                    parsableByteArray.n(bArr2, 0, P2);
                    return new PsshAtom(uuid, a2, bArr2, uuidArr);
                }
            }
        }
        sb.append(str);
        sb.append(a2);
        Log.n(f13621a, sb.toString());
        return null;
    }

    @Nullable
    public static byte[] e(byte[] bArr, UUID uuid) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        if (uuid.equals(d2.f13622a)) {
            return d2.f13624c;
        }
        Log.n(f13621a, "UUID mismatch. Expected: " + uuid + ", got: " + d2.f13622a + ".");
        return null;
    }

    @Nullable
    public static UUID f(byte[] bArr) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return null;
        }
        return d2.f13622a;
    }

    public static int g(byte[] bArr) {
        PsshAtom d2 = d(bArr);
        if (d2 == null) {
            return -1;
        }
        return d2.f13623b;
    }
}
