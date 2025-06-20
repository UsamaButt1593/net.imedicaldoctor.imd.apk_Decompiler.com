package androidx.media3.exoplayer.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {
    private static final String X2 = "VideoDecoderGLSV";
    private final Renderer s;

    private static final class Renderer implements GLSurfaceView.Renderer {
        private static final float[] d3 = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        private static final float[] e3 = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        private static final float[] f3 = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        private static final String g3 = "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
        private static final String[] h3 = {"y_tex", "u_tex", "v_tex"};
        private static final String i3 = "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
        private static final FloatBuffer j3 = GlUtil.i(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        private final int[] X = new int[3];
        private final int[] X2 = new int[3];
        private final int[] Y = new int[3];
        private final AtomicReference<VideoDecoderOutputBuffer> Y2 = new AtomicReference<>();
        private final int[] Z = new int[3];
        private final FloatBuffer[] Z2 = new FloatBuffer[3];
        private GlProgram a3;
        private int b3;
        private VideoDecoderOutputBuffer c3;
        private final GLSurfaceView s;

        public Renderer(GLSurfaceView gLSurfaceView) {
            this.s = gLSurfaceView;
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArr = this.Z;
                this.X2[i2] = -1;
                iArr[i2] = -1;
            }
        }

        @RequiresNonNull({"program"})
        private void b() {
            try {
                GLES20.glGenTextures(3, this.X, 0);
                for (int i2 = 0; i2 < 3; i2++) {
                    GLES20.glUniform1i(this.a3.l(h3[i2]), i2);
                    GLES20.glActiveTexture(33984 + i2);
                    GlUtil.c(3553, this.X[i2]);
                }
                GlUtil.d();
            } catch (GlUtil.GlException e2) {
                Log.e(VideoDecoderGLSurfaceView.X2, "Failed to set up the textures", e2);
            }
        }

        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer andSet = this.Y2.getAndSet(videoDecoderOutputBuffer);
            if (andSet != null) {
                andSet.q();
            }
            this.s.requestRender();
        }

        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer andSet = this.Y2.getAndSet((Object) null);
            if (andSet != null || this.c3 != null) {
                if (andSet != null) {
                    VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.c3;
                    if (videoDecoderOutputBuffer != null) {
                        videoDecoderOutputBuffer.q();
                    }
                    this.c3 = andSet;
                }
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) Assertions.g(this.c3);
                float[] fArr = e3;
                int i2 = videoDecoderOutputBuffer2.f3;
                if (i2 == 1) {
                    fArr = d3;
                } else if (i2 == 3) {
                    fArr = f3;
                }
                GLES20.glUniformMatrix3fv(this.b3, 1, false, fArr, 0);
                int[] iArr = (int[]) Assertions.g(videoDecoderOutputBuffer2.e3);
                ByteBuffer[] byteBufferArr = (ByteBuffer[]) Assertions.g(videoDecoderOutputBuffer2.d3);
                for (int i4 = 0; i4 < 3; i4++) {
                    int i5 = videoDecoderOutputBuffer2.b3;
                    if (i4 != 0) {
                        i5 = (i5 + 1) / 2;
                    }
                    int i6 = i5;
                    GLES20.glActiveTexture(33984 + i4);
                    GLES20.glBindTexture(3553, this.X[i4]);
                    GLES20.glPixelStorei(3317, 1);
                    GLES20.glTexImage2D(3553, 0, 6409, iArr[i4], i6, 0, 6409, 5121, byteBufferArr[i4]);
                }
                int[] iArr2 = new int[3];
                int i7 = videoDecoderOutputBuffer2.a3;
                iArr2[0] = i7;
                int i8 = (i7 + 1) / 2;
                iArr2[2] = i8;
                iArr2[1] = i8;
                for (int i9 = 0; i9 < 3; i9++) {
                    if (this.Z[i9] != iArr2[i9] || this.X2[i9] != iArr[i9]) {
                        Assertions.i(iArr[i9] != 0);
                        float f2 = ((float) iArr2[i9]) / ((float) iArr[i9]);
                        this.Z2[i9] = GlUtil.i(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                        GLES20.glVertexAttribPointer(this.Y[i9], 2, 5126, false, 0, this.Z2[i9]);
                        this.Z[i9] = iArr2[i9];
                        this.X2[i9] = iArr[i9];
                    }
                }
                GLES20.glClear(16384);
                GLES20.glDrawArrays(5, 0, 4);
                try {
                    GlUtil.d();
                } catch (GlUtil.GlException e2) {
                    Log.e(VideoDecoderGLSurfaceView.X2, "Failed to draw a frame", e2);
                }
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i4) {
            GLES20.glViewport(0, 0, i2, i4);
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                GlProgram glProgram = new GlProgram(g3, i3);
                this.a3 = glProgram;
                GLES20.glVertexAttribPointer(glProgram.g("in_pos"), 2, 5126, false, 0, j3);
                this.Y[0] = this.a3.g("in_tc_y");
                this.Y[1] = this.a3.g("in_tc_u");
                this.Y[2] = this.a3.g("in_tc_v");
                this.b3 = this.a3.l("mColorConversion");
                GlUtil.d();
                b();
                GlUtil.d();
            } catch (GlUtil.GlException e2) {
                Log.e(VideoDecoderGLSurfaceView.X2, "Failed to set up the textures and program", e2);
            }
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.s.a(videoDecoderOutputBuffer);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Renderer renderer = new Renderer(this);
        this.s = renderer;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setRenderMode(0);
    }
}
