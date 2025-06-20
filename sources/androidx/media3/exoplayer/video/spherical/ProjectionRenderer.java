package androidx.media3.exoplayer.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.nio.FloatBuffer;

final class ProjectionRenderer {

    /* renamed from: j  reason: collision with root package name */
    private static final String f12848j = "ProjectionRenderer";

    /* renamed from: k  reason: collision with root package name */
    private static final String f12849k = "uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n";

    /* renamed from: l  reason: collision with root package name */
    private static final String f12850l = "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n";

    /* renamed from: m  reason: collision with root package name */
    private static final float[] f12851m = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: n  reason: collision with root package name */
    private static final float[] f12852n = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    private static final float[] o = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] p = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] q = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private int f12853a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private MeshData f12854b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private MeshData f12855c;

    /* renamed from: d  reason: collision with root package name */
    private GlProgram f12856d;

    /* renamed from: e  reason: collision with root package name */
    private int f12857e;

    /* renamed from: f  reason: collision with root package name */
    private int f12858f;

    /* renamed from: g  reason: collision with root package name */
    private int f12859g;

    /* renamed from: h  reason: collision with root package name */
    private int f12860h;

    /* renamed from: i  reason: collision with root package name */
    private int f12861i;

    private static class MeshData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f12862a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final FloatBuffer f12863b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final FloatBuffer f12864c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f12865d;

        public MeshData(Projection.SubMesh subMesh) {
            this.f12862a = subMesh.a();
            this.f12863b = GlUtil.i(subMesh.f12837c);
            this.f12864c = GlUtil.i(subMesh.f12838d);
            int i2 = subMesh.f12836b;
            this.f12865d = i2 != 1 ? i2 != 2 ? 4 : 6 : 5;
        }
    }

    ProjectionRenderer() {
    }

    public static boolean c(Projection projection) {
        Projection.Mesh mesh = projection.f12829a;
        Projection.Mesh mesh2 = projection.f12830b;
        return mesh.b() == 1 && mesh.a(0).f12835a == 0 && mesh2.b() == 1 && mesh2.a(0).f12835a == 0;
    }

    public void a(int i2, float[] fArr, boolean z) {
        MeshData meshData = z ? this.f12855c : this.f12854b;
        if (meshData != null) {
            int i3 = this.f12853a;
            GLES20.glUniformMatrix3fv(this.f12858f, 1, false, i3 == 1 ? z ? o : f12852n : i3 == 2 ? z ? q : p : f12851m, 0);
            GLES20.glUniformMatrix4fv(this.f12857e, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(this.f12861i, 0);
            try {
                GlUtil.d();
            } catch (GlUtil.GlException e2) {
                Log.e(f12848j, "Failed to bind uniforms", e2);
            }
            GLES20.glVertexAttribPointer(this.f12859g, 3, 5126, false, 12, meshData.f12863b);
            try {
                GlUtil.d();
            } catch (GlUtil.GlException e3) {
                Log.e(f12848j, "Failed to load position data", e3);
            }
            GLES20.glVertexAttribPointer(this.f12860h, 2, 5126, false, 8, meshData.f12864c);
            try {
                GlUtil.d();
            } catch (GlUtil.GlException e4) {
                Log.e(f12848j, "Failed to load texture data", e4);
            }
            GLES20.glDrawArrays(meshData.f12865d, 0, meshData.f12862a);
            try {
                GlUtil.d();
            } catch (GlUtil.GlException e5) {
                Log.e(f12848j, "Failed to render", e5);
            }
        }
    }

    public void b() {
        try {
            GlProgram glProgram = new GlProgram(f12849k, f12850l);
            this.f12856d = glProgram;
            this.f12857e = glProgram.l("uMvpMatrix");
            this.f12858f = this.f12856d.l("uTexMatrix");
            this.f12859g = this.f12856d.g("aPosition");
            this.f12860h = this.f12856d.g("aTexCoords");
            this.f12861i = this.f12856d.l("uTexture");
        } catch (GlUtil.GlException e2) {
            Log.e(f12848j, "Failed to initialize the program", e2);
        }
    }

    public void d(Projection projection) {
        if (c(projection)) {
            this.f12853a = projection.f12831c;
            MeshData meshData = new MeshData(projection.f12829a.a(0));
            this.f12854b = meshData;
            if (!projection.f12832d) {
                meshData = new MeshData(projection.f12830b.a(0));
            }
            this.f12855c = meshData;
        }
    }

    public void e() {
        GlProgram glProgram = this.f12856d;
        if (glProgram != null) {
            try {
                glProgram.f();
            } catch (GlUtil.GlException e2) {
                Log.e(f12848j, "Failed to delete the shader program", e2);
            }
        }
    }
}
