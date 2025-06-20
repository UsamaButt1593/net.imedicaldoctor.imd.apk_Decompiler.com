package androidx.media3.exoplayer.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(18)
@UnstableApi
public final class DummyExoMediaDrm implements ExoMediaDrm {
    public static DummyExoMediaDrm y() {
        return new DummyExoMediaDrm();
    }

    public void a() {
    }

    public void b() {
    }

    @Nullable
    public PersistableBundle c() {
        return null;
    }

    public Map<String, String> d(byte[] bArr) {
        throw new IllegalStateException();
    }

    public void e(String str, byte[] bArr) {
    }

    public String f(String str) {
        return "";
    }

    public ExoMediaDrm.ProvisionRequest g() {
        throw new IllegalStateException();
    }

    public /* synthetic */ List h() {
        return t.a(this);
    }

    public CryptoConfig i(byte[] bArr) {
        throw new IllegalStateException();
    }

    public byte[] j() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    public void k(@Nullable ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
    }

    public boolean l(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    public void m(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public void n(String str, String str2) {
    }

    public void o(byte[] bArr) {
    }

    public byte[] p(String str) {
        return Util.f9651f;
    }

    @Nullable
    public byte[] q(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    public void r(@Nullable ExoMediaDrm.OnEventListener onEventListener) {
    }

    public void s(byte[] bArr) {
        throw new IllegalStateException();
    }

    public ExoMediaDrm.KeyRequest t(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i2, @Nullable HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    public /* synthetic */ void u(byte[] bArr, PlayerId playerId) {
        t.c(this, bArr, playerId);
    }

    public void v(@Nullable ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
    }

    public int w() {
        return 1;
    }

    public /* synthetic */ void x(byte[] bArr) {
        t.b(this, bArr);
    }
}
