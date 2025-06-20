package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import com.google.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiresApi(18)
public final class FrameworkMediaDrm implements ExoMediaDrm {

    /* renamed from: j  reason: collision with root package name */
    private static final String f11334j = "FrameworkMediaDrm";
    @UnstableApi

    /* renamed from: k  reason: collision with root package name */
    public static final ExoMediaDrm.Provider f11335k = new G();

    /* renamed from: l  reason: collision with root package name */
    private static final String f11336l = "cenc";

    /* renamed from: m  reason: collision with root package name */
    private static final String f11337m = "https://x";

    /* renamed from: n  reason: collision with root package name */
    private static final String f11338n = "<LA_URL>https://x</LA_URL>";
    private static final int o = 2;

    /* renamed from: g  reason: collision with root package name */
    private final UUID f11339g;

    /* renamed from: h  reason: collision with root package name */
    private final MediaDrm f11340h;

    /* renamed from: i  reason: collision with root package name */
    private int f11341i = 1;

    @RequiresApi(31)
    private static class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        @DoNotInline
        public static void b(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                I.a(Assertions.g(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(a2);
            }
        }
    }

    private FrameworkMediaDrm(UUID uuid) throws UnsupportedSchemeException {
        Assertions.g(uuid);
        Assertions.b(!C.i2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f11339g = uuid;
        MediaDrm mediaDrm = new MediaDrm(H(uuid));
        this.f11340h = mediaDrm;
        if (C.k2.equals(uuid) && Q()) {
            J(mediaDrm);
        }
    }

    private static byte[] C(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int w = parsableByteArray.w();
        short z = parsableByteArray.z();
        short z2 = parsableByteArray.z();
        if (z == 1 && z2 == 1) {
            short z3 = parsableByteArray.z();
            Charset charset = Charsets.f22257e;
            String J = parsableByteArray.J(z3, charset);
            if (J.contains("<LA_URL>")) {
                return bArr;
            }
            int indexOf = J.indexOf("</DATA>");
            if (indexOf == -1) {
                Log.n(f11334j, "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String str = J.substring(0, indexOf) + f11338n + J.substring(indexOf);
            int i2 = w + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i2);
            allocate.putShort((short) z);
            allocate.putShort((short) z2);
            allocate.putShort((short) (str.length() * 2));
            allocate.put(str.getBytes(charset));
            return allocate.array();
        }
        Log.h(f11334j, "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    private static String D(String str) {
        if (f11338n.equals(str)) {
            return "";
        }
        return (Util.f9646a < 33 || !"https://default.url".equals(str)) ? str : "";
    }

    private static byte[] E(UUID uuid, byte[] bArr) {
        return C.j2.equals(uuid) ? ClearKeyUtil.a(bArr) : bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if ("AFTT".equals(r0) == false) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] F(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = androidx.media3.common.C.l2
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L_0x0018
            byte[] r1 = androidx.media3.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r1 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r4 = r1
        L_0x0010:
            byte[] r4 = C(r4)
            byte[] r4 = androidx.media3.extractor.mp4.PsshAtomUtil.a(r0, r4)
        L_0x0018:
            int r1 = androidx.media3.common.util.Util.f9646a
            r2 = 23
            if (r1 >= r2) goto L_0x0026
            java.util.UUID r1 = androidx.media3.common.C.k2
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0058
        L_0x0026:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = androidx.media3.common.util.Util.f9648c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = androidx.media3.common.util.Util.f9649d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x005f
        L_0x0058:
            byte[] r3 = androidx.media3.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r3 == 0) goto L_0x005f
            return r3
        L_0x005f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkMediaDrm.F(java.util.UUID, byte[]):byte[]");
    }

    private static String G(UUID uuid, String str) {
        return (Util.f9646a >= 26 || !C.j2.equals(uuid) || (!MimeTypes.f9231f.equals(str) && !MimeTypes.E.equals(str))) ? str : "cenc";
    }

    private static UUID H(UUID uuid) {
        return (Util.f9646a >= 27 || !C.j2.equals(uuid)) ? uuid : C.i2;
    }

    private static void J(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData K(UUID uuid, List<DrmInitData.SchemeData> list) {
        if (C.k2.equals(uuid)) {
            if (Util.f9646a >= 28 && list.size() > 1) {
                DrmInitData.SchemeData schemeData = list.get(0);
                int i2 = 0;
                int i3 = 0;
                while (i2 < list.size()) {
                    DrmInitData.SchemeData schemeData2 = list.get(i2);
                    byte[] bArr = (byte[]) Assertions.g(schemeData2.X2);
                    if (Util.g(schemeData2.Z, schemeData.Z) && Util.g(schemeData2.Y, schemeData.Y) && PsshAtomUtil.c(bArr)) {
                        i3 += bArr.length;
                        i2++;
                    }
                }
                byte[] bArr2 = new byte[i3];
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    byte[] bArr3 = (byte[]) Assertions.g(list.get(i5).X2);
                    int length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i4, length);
                    i4 += length;
                }
                return schemeData.b(bArr2);
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                DrmInitData.SchemeData schemeData3 = list.get(i6);
                int g2 = PsshAtomUtil.g((byte[]) Assertions.g(schemeData3.X2));
                int i7 = Util.f9646a;
                if (i7 < 23 && g2 == 0) {
                    return schemeData3;
                }
                if (i7 >= 23 && g2 == 1) {
                    return schemeData3;
                }
            }
        }
        return list.get(0);
    }

    public static boolean L(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(H(uuid));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(ExoMediaDrm.OnEventListener onEventListener, MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        onEventListener.a(this, bArr, i2, i3, bArr2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener, MediaDrm mediaDrm, byte[] bArr, long j2) {
        onExpirationUpdateListener.a(this, bArr, j2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (Object a2 : list) {
            MediaDrm.KeyStatus a3 = x.a(a2);
            arrayList.add(new ExoMediaDrm.KeyStatus(a3.getStatusCode(), a3.getKeyId()));
        }
        onKeyStatusChangeListener.a(this, bArr, arrayList, z);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ExoMediaDrm P(UUID uuid) {
        try {
            return R(uuid);
        } catch (UnsupportedDrmException unused) {
            Log.d(f11334j, "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new DummyExoMediaDrm();
        }
    }

    private static boolean Q() {
        return "ASUS_Z00AD".equals(Util.f9649d);
    }

    @UnstableApi
    public static FrameworkMediaDrm R(UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e3) {
            throw new UnsupportedDrmException(2, e3);
        }
    }

    @UnstableApi
    /* renamed from: I */
    public FrameworkCryptoConfig i(byte[] bArr) throws MediaCryptoException {
        return new FrameworkCryptoConfig(H(this.f11339g), bArr, Util.f9646a < 21 && C.k2.equals(this.f11339g) && "L3".equals(f("securityLevel")));
    }

    @UnstableApi
    public synchronized void a() {
        int i2 = this.f11341i - 1;
        this.f11341i = i2;
        if (i2 == 0) {
            this.f11340h.release();
        }
    }

    @UnstableApi
    public synchronized void b() {
        Assertions.i(this.f11341i > 0);
        this.f11341i++;
    }

    @UnstableApi
    @Nullable
    public PersistableBundle c() {
        if (Util.f9646a < 28) {
            return null;
        }
        return this.f11340h.getMetrics();
    }

    @UnstableApi
    public Map<String, String> d(byte[] bArr) {
        return this.f11340h.queryKeyStatus(bArr);
    }

    @UnstableApi
    public void e(String str, byte[] bArr) {
        this.f11340h.setPropertyByteArray(str, bArr);
    }

    @UnstableApi
    public String f(String str) {
        return this.f11340h.getPropertyString(str);
    }

    @UnstableApi
    public ExoMediaDrm.ProvisionRequest g() {
        MediaDrm.ProvisionRequest provisionRequest = this.f11340h.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @RequiresApi(29)
    @UnstableApi
    public List<byte[]> h() {
        if (Util.f9646a >= 29) {
            return this.f11340h.getOfflineLicenseKeySetIds();
        }
        throw new UnsupportedOperationException();
    }

    @UnstableApi
    public byte[] j() throws MediaDrmException {
        return this.f11340h.openSession();
    }

    @RequiresApi(23)
    @UnstableApi
    public void k(@Nullable ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        if (Util.f9646a >= 23) {
            this.f11340h.setOnKeyStatusChangeListener(onKeyStatusChangeListener == null ? null : new F(this, onKeyStatusChangeListener), (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @UnstableApi
    public boolean l(byte[] bArr, String str) {
        if (Util.f9646a >= 31) {
            return Api31.a(this.f11340h, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f11339g, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @UnstableApi
    public void m(byte[] bArr, byte[] bArr2) {
        this.f11340h.restoreKeys(bArr, bArr2);
    }

    @UnstableApi
    public void n(String str, String str2) {
        this.f11340h.setPropertyString(str, str2);
    }

    @UnstableApi
    public void o(byte[] bArr) {
        this.f11340h.closeSession(bArr);
    }

    @UnstableApi
    public byte[] p(String str) {
        return this.f11340h.getPropertyByteArray(str);
    }

    @UnstableApi
    @Nullable
    public byte[] q(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.j2.equals(this.f11339g)) {
            bArr2 = ClearKeyUtil.b(bArr2);
        }
        return this.f11340h.provideKeyResponse(bArr, bArr2);
    }

    @UnstableApi
    public void r(@Nullable ExoMediaDrm.OnEventListener onEventListener) {
        this.f11340h.setOnEventListener(onEventListener == null ? null : new E(this, onEventListener));
    }

    @UnstableApi
    public void s(byte[] bArr) throws DeniedByServerException {
        this.f11340h.provideProvisionResponse(bArr);
    }

    @UnstableApi
    @SuppressLint({"WrongConstant"})
    public ExoMediaDrm.KeyRequest t(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i2, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException {
        DrmInitData.SchemeData schemeData;
        String str;
        byte[] bArr2;
        if (list != null) {
            schemeData = K(this.f11339g, list);
            bArr2 = F(this.f11339g, (byte[]) Assertions.g(schemeData.X2));
            str = G(this.f11339g, schemeData.Z);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f11340h.getKeyRequest(bArr, bArr2, str, i2, hashMap);
        byte[] E = E(this.f11339g, keyRequest.getData());
        String D = D(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(D) && schemeData != null && !TextUtils.isEmpty(schemeData.Y)) {
            D = schemeData.Y;
        }
        return new ExoMediaDrm.KeyRequest(E, D, Util.f9646a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @UnstableApi
    public void u(byte[] bArr, PlayerId playerId) {
        if (Util.f9646a >= 31) {
            try {
                Api31.b(this.f11340h, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.n(f11334j, "setLogSessionId failed.");
            }
        }
    }

    @RequiresApi(23)
    @UnstableApi
    public void v(@Nullable ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        if (Util.f9646a >= 23) {
            this.f11340h.setOnExpirationUpdateListener(onExpirationUpdateListener == null ? null : new D(this, onExpirationUpdateListener), (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @UnstableApi
    public int w() {
        return 2;
    }

    @RequiresApi(29)
    @UnstableApi
    public void x(byte[] bArr) {
        if (Util.f9646a >= 29) {
            this.f11340h.removeOfflineLicense(bArr);
            return;
        }
        throw new UnsupportedOperationException();
    }
}
