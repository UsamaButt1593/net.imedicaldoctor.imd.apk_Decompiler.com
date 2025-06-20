package androidx.media3.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLU;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public final class GlUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9540a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static final float f9541b = 2.0f;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f9542c = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f9543d = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: e  reason: collision with root package name */
    private static final long f9544e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final String f9545f = "EGL_EXT_protected_content";

    /* renamed from: g  reason: collision with root package name */
    private static final String f9546g = "EGL_KHR_surfaceless_context";

    /* renamed from: h  reason: collision with root package name */
    private static final String f9547h = "GL_EXT_YUV_target";

    /* renamed from: i  reason: collision with root package name */
    private static final String f9548i = "EGL_EXT_gl_colorspace_bt2020_pq";

    /* renamed from: j  reason: collision with root package name */
    private static final int f9549j = 12445;

    /* renamed from: k  reason: collision with root package name */
    private static final int f9550k = 13120;

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f9551l = {f9549j, f9550k, 12344, 12344};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f9552m = {12344};

    @RequiresApi(17)
    private static final class Api17 {
        private Api17() {
        }

        @DoNotInline
        public static void a(String str) throws GlException {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                throw new GlException(str + ", error code: 0x" + Integer.toHexString(eglGetError));
            }
        }

        @DoNotInline
        public static EGLContext b(EGLContext eGLContext, EGLDisplay eGLDisplay, int i2, int[] iArr) throws GlException {
            EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, k(eGLDisplay, iArr), eGLContext, new int[]{12440, i2, 12344}, 0);
            if (eglCreateContext != null) {
                GlUtil.d();
                return eglCreateContext;
            }
            EGL14.eglTerminate(eGLDisplay);
            throw new GlException("eglCreateContext() failed to create a valid context. The device may not support EGL version " + i2);
        }

        @DoNotInline
        public static EGLSurface c(EGLDisplay eGLDisplay, int[] iArr, int[] iArr2) throws GlException {
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, k(eGLDisplay, iArr), iArr2, 0);
            a("Error creating a new EGL Pbuffer surface");
            return eglCreatePbufferSurface;
        }

        @DoNotInline
        public static EGLSurface d(EGLDisplay eGLDisplay, Object obj, int[] iArr, int[] iArr2) throws GlException {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, k(eGLDisplay, iArr), obj, iArr2, 0);
            a("Error creating a new EGL surface");
            return eglCreateWindowSurface;
        }

        @DoNotInline
        public static void e(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) throws GlException {
            if (eGLDisplay != null) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                a("Error releasing context");
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                    a("Error destroying context");
                }
                EGL14.eglReleaseThread();
                a("Error releasing thread");
                EGL14.eglTerminate(eGLDisplay);
                a("Error terminating display");
            }
        }

        @DoNotInline
        public static void f(@Nullable EGLDisplay eGLDisplay, @Nullable EGLSurface eGLSurface) throws GlException {
            if (eGLDisplay != null && eGLSurface != null && EGL14.eglGetCurrentSurface(12377) != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                a("Error destroying surface");
            }
        }

        @DoNotInline
        public static void g(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i2, int i3, int i4) throws GlException {
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            a("Error making context current");
            GlUtil.E(i2, i3, i4);
        }

        @DoNotInline
        public static int h() throws GlException {
            int[] iArr = new int[1];
            EGL14.eglQueryContext(EGL14.eglGetDisplay(0), EGL14.eglGetCurrentContext(), 12440, iArr, 0);
            GlUtil.d();
            return iArr[0];
        }

        @DoNotInline
        public static EGLContext i() {
            return EGL14.eglGetCurrentContext();
        }

        @DoNotInline
        public static EGLDisplay j() throws GlException {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            GlUtil.e(!eglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
            GlUtil.e(EGL14.eglInitialize(eglGetDisplay, new int[1], 0, new int[1], 0), "Error in eglInitialize.");
            GlUtil.d();
            return eglGetDisplay;
        }

        @DoNotInline
        private static EGLConfig k(EGLDisplay eGLDisplay, int[] iArr) throws GlException {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            throw new GlException("eglChooseConfig failed.");
        }

        @DoNotInline
        public static boolean l(String str) {
            String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
            return eglQueryString != null && eglQueryString.contains(str);
        }
    }

    @RequiresApi(18)
    private static final class Api18 {
        private Api18() {
        }

        @DoNotInline
        public static long a() throws GlException {
            long glFenceSync = GLES30.glFenceSync(37143, 0);
            GlUtil.d();
            GLES20.glFlush();
            GlUtil.d();
            return glFenceSync;
        }

        @DoNotInline
        public static void b(long j2) throws GlException {
            GLES30.glDeleteSync(j2);
            GlUtil.d();
        }

        @DoNotInline
        public static void c(long j2) throws GlException {
            GLES30.glWaitSync(j2, 0, -1);
            GlUtil.d();
        }
    }

    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    private GlUtil() {
    }

    @RequiresApi(17)
    public static void A(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) throws GlException {
        Api17.e(eGLDisplay, eGLContext);
    }

    @RequiresApi(17)
    public static void B(@Nullable EGLDisplay eGLDisplay, @Nullable EGLSurface eGLSurface) throws GlException {
        Api17.f(eGLDisplay, eGLSurface);
    }

    @RequiresApi(17)
    public static void C(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i2, int i3) throws GlException {
        Api17.g(eGLDisplay, eGLContext, eGLSurface, 0, i2, i3);
    }

    @RequiresApi(17)
    public static void D(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i2, int i3, int i4) throws GlException {
        Api17.g(eGLDisplay, eGLContext, eGLSurface, i2, i3, i4);
    }

    public static void E(int i2, int i3, int i4) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        if (iArr[0] != i2) {
            GLES20.glBindFramebuffer(36160, i2);
        }
        d();
        GLES20.glViewport(0, 0, i3, i4);
        d();
    }

    public static int F() throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        d();
        return iArr[0];
    }

    @RequiresApi(17)
    public static long G() throws GlException {
        return (long) Api17.h();
    }

    @RequiresApi(17)
    public static EGLContext H() {
        return Api17.i();
    }

    @RequiresApi(17)
    public static EGLDisplay I() throws GlException {
        return Api17.j();
    }

    public static float[] J() {
        return new float[]{-1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static float[] K() {
        return new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    }

    public static boolean L() {
        return Util.f9646a >= 17 && Api17.l(f9548i);
    }

    public static boolean M(Context context) {
        int i2 = Util.f9646a;
        if (i2 < 24) {
            return false;
        }
        if (i2 < 26 && ("samsung".equals(Util.f9648c) || "XT1650".equals(Util.f9649d))) {
            return false;
        }
        if (i2 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return Api17.l(f9545f);
        }
        return false;
    }

    public static boolean N() {
        return Util.f9646a >= 17 && Api17.l(f9546g);
    }

    public static boolean O() {
        String str;
        if (Util.f9646a < 17) {
            return false;
        }
        if (Util.g(Api17.i(), EGL14.EGL_NO_CONTEXT)) {
            try {
                EGLDisplay I = I();
                EGLContext k2 = k(I);
                o(k2, I);
                str = GLES20.glGetString(7939);
                A(I, k2);
            } catch (GlException unused) {
                return false;
            }
        } else {
            str = GLES20.glGetString(7939);
        }
        return str != null && str.contains(f9547h);
    }

    public static void P(int i2, Bitmap bitmap) throws GlException {
        a(bitmap.getWidth(), bitmap.getHeight());
        c(3553, i2);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        d();
    }

    public static void Q(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    private static void a(int i2, int i3) throws GlException {
        boolean z = true;
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(MetaDo.f0, iArr, 0);
        int i4 = iArr[0];
        if (i4 <= 0) {
            z = false;
        }
        Assertions.j(z, "Create a OpenGL context first or run the GL methods on an OpenGL thread.");
        if (i2 < 0 || i3 < 0) {
            throw new GlException("width or height is less than 0");
        } else if (i2 > i4 || i3 > i4) {
            throw new GlException("width or height is greater than GL_MAX_TEXTURE_SIZE " + i4);
        }
    }

    public static void b(long j2) throws GlException {
        if (j2 == 0) {
            GLES20.glFinish();
        } else {
            Api18.c(j2);
        }
    }

    public static void c(int i2, int i3) throws GlException {
        GLES20.glBindTexture(i2, i3);
        d();
        GLES20.glTexParameteri(i2, 10240, 9729);
        d();
        GLES20.glTexParameteri(i2, 10241, 9729);
        d();
        GLES20.glTexParameteri(i2, 10242, 33071);
        d();
        GLES20.glTexParameteri(i2, 10243, 33071);
        d();
    }

    public static void d() throws GlException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z) {
                sb.append(10);
            }
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x" + Integer.toHexString(glGetError);
            }
            sb.append("glError: ");
            sb.append(gluErrorString);
            z = true;
        }
        if (z) {
            throw new GlException(sb.toString());
        }
    }

    public static void e(boolean z, String str) throws GlException {
        if (!z) {
            throw new GlException(str);
        }
    }

    public static void f() throws GlException {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClearDepthf(1.0f);
        GLES20.glClear(16640);
        d();
    }

    public static float[] g() {
        float[] fArr = new float[16];
        Q(fArr);
        return fArr;
    }

    private static FloatBuffer h(int i2) {
        return ByteBuffer.allocateDirect(i2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer i(float[] fArr) {
        return (FloatBuffer) h(fArr.length).put(fArr).flip();
    }

    @RequiresApi(17)
    public static EGLContext j(EGLContext eGLContext, EGLDisplay eGLDisplay, @IntRange(from = 2, to = 3) int i2, int[] iArr) throws GlException {
        boolean z = true;
        Assertions.a(Arrays.equals(iArr, f9542c) || Arrays.equals(iArr, f9543d));
        if (!(i2 == 2 || i2 == 3)) {
            z = false;
        }
        Assertions.a(z);
        return Api17.b(eGLContext, eGLDisplay, i2, iArr);
    }

    @RequiresApi(17)
    public static EGLContext k(EGLDisplay eGLDisplay) throws GlException {
        return j(EGL14.EGL_NO_CONTEXT, eGLDisplay, 2, f9542c);
    }

    @RequiresApi(17)
    public static EGLSurface l(EGLDisplay eGLDisplay, Object obj, int i2, boolean z) throws GlException {
        int[] iArr;
        int[] iArr2;
        if (i2 == 3 || i2 == 10) {
            iArr2 = f9542c;
        } else if (i2 == 6) {
            iArr2 = f9543d;
            if (!z) {
                iArr = f9551l;
                return Api17.d(eGLDisplay, obj, iArr2, iArr);
            }
        } else if (i2 == 7) {
            Assertions.b(z, "Outputting HLG to the screen is not supported.");
            iArr2 = f9543d;
        } else {
            throw new IllegalArgumentException("Unsupported color transfer: " + i2);
        }
        iArr = f9552m;
        return Api17.d(eGLDisplay, obj, iArr2, iArr);
    }

    public static int m() throws GlException {
        int F = F();
        c(36197, F);
        return F;
    }

    public static int n(int i2) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        d();
        GLES20.glBindFramebuffer(36160, iArr[0]);
        d();
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        d();
        return iArr[0];
    }

    @RequiresApi(17)
    public static EGLSurface o(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlException {
        EGLSurface q = N() ? EGL14.EGL_NO_SURFACE : q(eGLDisplay, 1, 1, f9542c);
        C(eGLDisplay, eGLContext, q, 1, 1);
        return q;
    }

    @RequiresApi(17)
    public static long p() throws GlException {
        if (Api17.h() >= 3) {
            return Api18.a();
        }
        return 0;
    }

    @RequiresApi(17)
    private static EGLSurface q(EGLDisplay eGLDisplay, int i2, int i3, int[] iArr) throws GlException {
        return Api17.c(eGLDisplay, iArr, new int[]{12375, i2, 12374, i3, 12344});
    }

    public static int r(int i2, int i3, boolean z) throws GlException {
        int i4;
        int i5;
        if (z) {
            Assertions.j(Util.f9646a >= 18, "GLES30 extensions are not supported below API 18.");
            i4 = 34842;
            i5 = 5131;
        } else {
            i4 = 6408;
            i5 = 5121;
        }
        return t(i2, i3, i4, i5);
    }

    public static int s(Bitmap bitmap) throws GlException {
        int F = F();
        P(F, bitmap);
        return F;
    }

    private static int t(int i2, int i3, int i4, int i5) throws GlException {
        a(i2, i3);
        int F = F();
        c(3553, F);
        GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, 6408, i5, (Buffer) null);
        d();
        return F;
    }

    public static float[] u(List<float[]> list) {
        float[] fArr = new float[(list.size() * 4)];
        for (int i2 = 0; i2 < list.size(); i2++) {
            System.arraycopy(list.get(i2), 0, fArr, i2 * 4, 4);
        }
        return fArr;
    }

    public static void v(int i2) throws GlException {
        GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
        d();
    }

    public static void w(int i2) throws GlException {
        GLES20.glDeleteRenderbuffers(1, new int[]{i2}, 0);
        d();
    }

    public static void x(long j2) throws GlException {
        if (Util.f9646a >= 18) {
            Api18.b(j2);
        }
    }

    public static void y(long j2) {
        if (Util.f9646a >= 18) {
            try {
                Api18.b(j2);
            } catch (GlException unused) {
            }
        }
    }

    public static void z(int i2) throws GlException {
        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
        d();
    }
}
