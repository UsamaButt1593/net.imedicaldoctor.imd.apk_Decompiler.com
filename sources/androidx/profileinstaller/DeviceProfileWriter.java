package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceProfileWriter {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f15062a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Executor f15063b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final ProfileInstaller.DiagnosticsCallback f15064c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f15065d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final File f15066e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final String f15067f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final String f15068g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final String f15069h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15070i = false;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private DexProfileData[] f15071j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private byte[] f15072k;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.f15062a = assetManager;
        this.f15063b = executor;
        this.f15064c = diagnosticsCallback;
        this.f15067f = str;
        this.f15068g = str2;
        this.f15069h = str3;
        this.f15066e = file;
        this.f15065d = d();
    }

    @Nullable
    private DeviceProfileWriter b(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        ProfileInstaller.DiagnosticsCallback diagnosticsCallback;
        int i2;
        InputStream h2;
        try {
            h2 = h(this.f15062a, this.f15069h);
            if (h2 != null) {
                this.f15071j = ProfileTranscoder.q(h2, ProfileTranscoder.o(h2, ProfileTranscoder.f15118g), bArr, dexProfileDataArr);
                h2.close();
                return this;
            }
            if (h2 != null) {
                h2.close();
            }
            return null;
        } catch (FileNotFoundException e2) {
            e = e2;
            diagnosticsCallback = this.f15064c;
            i2 = 9;
            diagnosticsCallback.b(i2, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            diagnosticsCallback = this.f15064c;
            i2 = 7;
            diagnosticsCallback.b(i2, e);
            return null;
        } catch (IllegalStateException e4) {
            e = e4;
            this.f15071j = null;
            diagnosticsCallback = this.f15064c;
            i2 = 8;
            diagnosticsCallback.b(i2, e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void c() {
        if (!this.f15070i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    @Nullable
    private static byte[] d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || i2 > 34) {
            return null;
        }
        switch (i2) {
            case 24:
            case 25:
                return ProfileVersion.f15148e;
            case 26:
                return ProfileVersion.f15147d;
            case 27:
                return ProfileVersion.f15146c;
            case 28:
            case 29:
            case 30:
                return ProfileVersion.f15145b;
            case 31:
            case 32:
            case 33:
            case 34:
                return ProfileVersion.f15144a;
            default:
                return null;
        }
    }

    @Nullable
    private InputStream f(AssetManager assetManager) {
        int i2;
        ProfileInstaller.DiagnosticsCallback diagnosticsCallback;
        try {
            return h(assetManager, this.f15068g);
        } catch (FileNotFoundException e2) {
            e = e2;
            diagnosticsCallback = this.f15064c;
            i2 = 6;
            diagnosticsCallback.b(i2, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            diagnosticsCallback = this.f15064c;
            i2 = 7;
            diagnosticsCallback.b(i2, e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(int i2, Object obj) {
        this.f15064c.b(i2, obj);
    }

    @Nullable
    private InputStream h(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f15064c.a(5, (Object) null);
            }
            return null;
        }
    }

    @Nullable
    private DexProfileData[] j(InputStream inputStream) {
        try {
            DexProfileData[] w = ProfileTranscoder.w(inputStream, ProfileTranscoder.o(inputStream, ProfileTranscoder.f15117f), this.f15067f);
            try {
                inputStream.close();
                return w;
            } catch (IOException e2) {
                this.f15064c.b(7, e2);
                return w;
            }
        } catch (IOException e3) {
            this.f15064c.b(7, e3);
            inputStream.close();
            return null;
        } catch (IllegalStateException e4) {
            this.f15064c.b(8, e4);
            try {
                inputStream.close();
            } catch (IOException e5) {
                this.f15064c.b(7, e5);
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                this.f15064c.b(7, e6);
            }
            throw th;
        }
    }

    private static boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || i2 > 34) {
            return false;
        }
        if (!(i2 == 24 || i2 == 25)) {
            switch (i2) {
                case 31:
                case 32:
                case 33:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(int i2, @Nullable Object obj) {
        this.f15063b.execute(new b(this, i2, obj));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e() {
        if (this.f15065d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f15066e.exists()) {
            try {
                this.f15066e.createNewFile();
            } catch (IOException unused) {
                l(4, (Object) null);
                return false;
            }
        } else if (!this.f15066e.canWrite()) {
            l(4, (Object) null);
            return false;
        }
        this.f15070i = true;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r0 = b(r0, r2.f15065d);
     */
    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.profileinstaller.DeviceProfileWriter i() {
        /*
            r2 = this;
            r2.c()
            byte[] r0 = r2.f15065d
            if (r0 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.content.res.AssetManager r0 = r2.f15062a
            java.io.InputStream r0 = r2.f(r0)
            if (r0 == 0) goto L_0x0016
            androidx.profileinstaller.DexProfileData[] r0 = r2.j(r0)
            r2.f15071j = r0
        L_0x0016:
            androidx.profileinstaller.DexProfileData[] r0 = r2.f15071j
            if (r0 == 0) goto L_0x0029
            boolean r1 = k()
            if (r1 == 0) goto L_0x0029
            byte[] r1 = r2.f15065d
            androidx.profileinstaller.DeviceProfileWriter r0 = r2.b(r0, r1)
            if (r0 == 0) goto L_0x0029
            return r0
        L_0x0029:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.DeviceProfileWriter.i():androidx.profileinstaller.DeviceProfileWriter");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter m() {
        int i2;
        ProfileInstaller.DiagnosticsCallback diagnosticsCallback;
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.f15071j;
        byte[] bArr = this.f15065d;
        if (!(dexProfileDataArr == null || bArr == null)) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ProfileTranscoder.E(byteArrayOutputStream, bArr);
                if (!ProfileTranscoder.B(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                    this.f15064c.b(5, (Object) null);
                    this.f15071j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f15072k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f15071j = null;
            } catch (IOException e2) {
                e = e2;
                diagnosticsCallback = this.f15064c;
                i2 = 7;
            } catch (IllegalStateException e3) {
                e = e3;
                diagnosticsCallback = this.f15064c;
                i2 = 8;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return this;
        diagnosticsCallback.b(i2, e);
        this.f15071j = null;
        return this;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean n() {
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr = this.f15072k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            fileOutputStream = new FileOutputStream(this.f15066e);
            Encoding.l(byteArrayInputStream, fileOutputStream);
            l(1, (Object) null);
            fileOutputStream.close();
            byteArrayInputStream.close();
            this.f15072k = null;
            this.f15071j = null;
            return true;
        } catch (FileNotFoundException e2) {
            l(6, e2);
            this.f15072k = null;
            this.f15071j = null;
            return false;
        } catch (IOException e3) {
            l(7, e3);
            this.f15072k = null;
            this.f15071j = null;
            return false;
        } catch (Throwable th) {
            this.f15072k = null;
            this.f15071j = null;
            throw th;
        }
        throw th;
        throw th;
    }
}
