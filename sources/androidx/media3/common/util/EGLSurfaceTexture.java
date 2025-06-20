package androidx.media3.common.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.GlUtil;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RequiresApi(17)
@UnstableApi
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int a3 = 0;
    public static final int b3 = 1;
    public static final int c3 = 2;
    private static final int d3 = 1;
    private static final int e3 = 1;
    private static final int[] f3 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private static final int g3 = 12992;
    private final int[] X;
    @Nullable
    private EGLContext X2;
    @Nullable
    private final TextureImageListener Y;
    @Nullable
    private EGLSurface Y2;
    @Nullable
    private EGLDisplay Z;
    @Nullable
    private SurfaceTexture Z2;
    private final Handler s;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecureMode {
    }

    public interface TextureImageListener {
        void a();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, (TextureImageListener) null);
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) throws GlUtil.GlException {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f3, 0, eGLConfigArr, 0, 1, iArr, 0);
        GlUtil.e(eglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null, Util.S("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        return eGLConfigArr[0];
    }

    private static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) throws GlUtil.GlException {
        boolean z = true;
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, g3, 1, 12344}, 0);
        if (eglCreateContext == null) {
            z = false;
        }
        GlUtil.e(z, "eglCreateContext failed");
        return eglCreateContext;
    }

    private static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i2) throws GlUtil.GlException {
        EGLSurface eGLSurface;
        boolean z = true;
        if (i2 == 1) {
            eGLSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, g3, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurface == null) {
                z = false;
            }
            GlUtil.e(z, "eglCreatePbufferSurface failed");
        }
        GlUtil.e(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext), "eglMakeCurrent failed");
        return eGLSurface;
    }

    private void d() {
        TextureImageListener textureImageListener = this.Y;
        if (textureImageListener != null) {
            textureImageListener.a();
        }
    }

    private static void e(int[] iArr) throws GlUtil.GlException {
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.d();
    }

    private static EGLDisplay f() throws GlUtil.GlException {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        GlUtil.e(eglGetDisplay != null, "eglGetDisplay failed");
        int[] iArr = new int[2];
        GlUtil.e(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        return eglGetDisplay;
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) Assertions.g(this.Z2);
    }

    public void h(int i2) throws GlUtil.GlException {
        EGLDisplay f2 = f();
        this.Z = f2;
        EGLConfig a2 = a(f2);
        EGLContext b2 = b(this.Z, a2, i2);
        this.X2 = b2;
        this.Y2 = c(this.Z, a2, b2, i2);
        e(this.X);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.X[0]);
        this.Z2 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public void i() {
        this.s.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.Z2;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.X, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.Z;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.Z;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.Y2;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.Z, this.Y2);
            }
            EGLContext eGLContext = this.X2;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.Z, eGLContext);
            }
            if (Util.f9646a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.Z;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.Z);
            }
            this.Z = null;
            this.X2 = null;
            this.Y2 = null;
            this.Z2 = null;
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.s.post(this);
    }

    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.Z2;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public EGLSurfaceTexture(Handler handler, @Nullable TextureImageListener textureImageListener) {
        this.s = handler;
        this.Y = textureImageListener;
        this.X = new int[1];
    }
}
