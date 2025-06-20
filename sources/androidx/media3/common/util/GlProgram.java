package androidx.media3.common.util;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlUtil;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

@UnstableApi
public final class GlProgram {

    /* renamed from: f  reason: collision with root package name */
    private static final int f9523f = 35815;

    /* renamed from: a  reason: collision with root package name */
    private final int f9524a;

    /* renamed from: b  reason: collision with root package name */
    private final Attribute[] f9525b;

    /* renamed from: c  reason: collision with root package name */
    private final Uniform[] f9526c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Attribute> f9527d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Uniform> f9528e;

    private static final class Attribute {

        /* renamed from: a  reason: collision with root package name */
        public final String f9529a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9530b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Buffer f9531c;

        /* renamed from: d  reason: collision with root package name */
        private int f9532d;

        private Attribute(String str, int i2) {
            this.f9529a = str;
            this.f9530b = i2;
        }

        public static Attribute b(int i2, int i3) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i2, 35722, iArr, 0);
            int i4 = iArr[0];
            byte[] bArr = new byte[i4];
            GLES20.glGetActiveAttrib(i2, i3, i4, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.j(bArr));
            return new Attribute(str, GlProgram.h(i2, str));
        }

        public void a() throws GlUtil.GlException {
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.f9530b, this.f9532d, 5126, false, 0, (Buffer) Assertions.h(this.f9531c, "call setBuffer before bind"));
            GLES20.glEnableVertexAttribArray(this.f9530b);
            GlUtil.d();
        }

        public void c(float[] fArr, int i2) {
            this.f9531c = GlUtil.i(fArr);
            this.f9532d = i2;
        }
    }

    private static final class Uniform {

        /* renamed from: a  reason: collision with root package name */
        public final String f9533a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9534b;

        /* renamed from: c  reason: collision with root package name */
        private final int f9535c;

        /* renamed from: d  reason: collision with root package name */
        private final float[] f9536d = new float[16];

        /* renamed from: e  reason: collision with root package name */
        private final int[] f9537e = new int[4];

        /* renamed from: f  reason: collision with root package name */
        private int f9538f;

        /* renamed from: g  reason: collision with root package name */
        private int f9539g;

        private Uniform(String str, int i2, int i3) {
            this.f9533a = str;
            this.f9534b = i2;
            this.f9535c = i3;
        }

        public static Uniform b(int i2, int i3) {
            int i4 = i2;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i2, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i5 = iArr[0];
            byte[] bArr = new byte[i5];
            GLES20.glGetActiveUniform(i2, i3, i5, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.j(bArr));
            return new Uniform(str, GlProgram.k(i2, str), iArr2[0]);
        }

        public void a() throws GlUtil.GlException {
            switch (this.f9535c) {
                case 5124:
                    GLES20.glUniform1iv(this.f9534b, 1, this.f9537e, 0);
                    break;
                case 5126:
                    GLES20.glUniform1fv(this.f9534b, 1, this.f9536d, 0);
                    break;
                case 35664:
                    GLES20.glUniform2fv(this.f9534b, 1, this.f9536d, 0);
                    break;
                case 35665:
                    GLES20.glUniform3fv(this.f9534b, 1, this.f9536d, 0);
                    break;
                case 35667:
                    GLES20.glUniform2iv(this.f9534b, 1, this.f9537e, 0);
                    break;
                case 35668:
                    GLES20.glUniform3iv(this.f9534b, 1, this.f9537e, 0);
                    break;
                case 35669:
                    GLES20.glUniform4iv(this.f9534b, 1, this.f9537e, 0);
                    break;
                case 35675:
                    GLES20.glUniformMatrix3fv(this.f9534b, 1, false, this.f9536d, 0);
                    break;
                case 35676:
                    GLES20.glUniformMatrix4fv(this.f9534b, 1, false, this.f9536d, 0);
                    break;
                case 35678:
                case GlProgram.f9523f /*35815*/:
                case 36198:
                    if (this.f9538f != 0) {
                        GLES20.glActiveTexture(this.f9539g + 33984);
                        GlUtil.d();
                        GlUtil.c(this.f9535c == 35678 ? 3553 : 36197, this.f9538f);
                        GLES20.glUniform1i(this.f9534b, this.f9539g);
                        break;
                    } else {
                        throw new IllegalStateException("No call to setSamplerTexId() before bind.");
                    }
                default:
                    throw new IllegalStateException("Unexpected uniform type: " + this.f9535c);
            }
            GlUtil.d();
        }

        public void c(float f2) {
            this.f9536d[0] = f2;
        }

        public void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f9536d, 0, fArr.length);
        }

        public void e(int i2) {
            this.f9537e[0] = i2;
        }

        public void f(int[] iArr) {
            System.arraycopy(iArr, 0, this.f9537e, 0, iArr.length);
        }

        public void g(int i2, int i3) {
            this.f9538f = i2;
            this.f9539g = i3;
        }
    }

    public GlProgram(Context context, String str, String str2) throws IOException, GlUtil.GlException {
        this(Util.z1(context, str), Util.z1(context, str2));
    }

    private static void d(int i2, int i3, String str) throws GlUtil.GlException {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        boolean z = false;
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            z = true;
        }
        GlUtil.e(z, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i2, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.d();
    }

    /* access modifiers changed from: private */
    public static int h(int i2, String str) {
        return GLES20.glGetAttribLocation(i2, str);
    }

    private int i(String str) {
        return h(this.f9524a, str);
    }

    /* access modifiers changed from: private */
    public static int j(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] == 0) {
                return i2;
            }
        }
        return bArr.length;
    }

    /* access modifiers changed from: private */
    public static int k(int i2, String str) {
        return GLES20.glGetUniformLocation(i2, str);
    }

    public void e() throws GlUtil.GlException {
        for (Attribute a2 : this.f9525b) {
            a2.a();
        }
        for (Uniform a3 : this.f9526c) {
            a3.a();
        }
    }

    public void f() throws GlUtil.GlException {
        GLES20.glDeleteProgram(this.f9524a);
        GlUtil.d();
    }

    public int g(String str) throws GlUtil.GlException {
        int i2 = i(str);
        GLES20.glEnableVertexAttribArray(i2);
        GlUtil.d();
        return i2;
    }

    public int l(String str) {
        return k(this.f9524a, str);
    }

    public void m(String str, float[] fArr, int i2) {
        ((Attribute) Assertions.g(this.f9527d.get(str))).c(fArr, i2);
    }

    public void n(String str, float f2) {
        ((Uniform) Assertions.g(this.f9528e.get(str))).c(f2);
    }

    public void o(String str, float[] fArr) {
        ((Uniform) Assertions.g(this.f9528e.get(str))).d(fArr);
    }

    public void p(String str, int i2) {
        ((Uniform) Assertions.g(this.f9528e.get(str))).e(i2);
    }

    public void q(String str, int[] iArr) {
        ((Uniform) Assertions.g(this.f9528e.get(str))).f(iArr);
    }

    public void r(String str, int i2, int i3) {
        ((Uniform) Assertions.g(this.f9528e.get(str))).g(i2, i3);
    }

    public void s() throws GlUtil.GlException {
        GLES20.glUseProgram(this.f9524a);
        GlUtil.d();
    }

    public GlProgram(String str, String str2) throws GlUtil.GlException {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f9524a = glCreateProgram;
        GlUtil.d();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        boolean z = iArr[0] == 1;
        GlUtil.e(z, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.f9527d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f9525b = new Attribute[iArr2[0]];
        for (int i2 = 0; i2 < iArr2[0]; i2++) {
            Attribute b2 = Attribute.b(this.f9524a, i2);
            this.f9525b[i2] = b2;
            this.f9527d.put(b2.f9529a, b2);
        }
        this.f9528e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f9524a, 35718, iArr3, 0);
        this.f9526c = new Uniform[iArr3[0]];
        for (int i3 = 0; i3 < iArr3[0]; i3++) {
            Uniform b3 = Uniform.b(this.f9524a, i3);
            this.f9526c[i3] = b3;
            this.f9528e.put(b3.f9533a, b3);
        }
        GlUtil.d();
    }
}
