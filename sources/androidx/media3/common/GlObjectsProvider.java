package androidx.media3.common;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface GlObjectsProvider {
    @RequiresApi(17)
    EGLContext a(EGLDisplay eGLDisplay, @IntRange(from = 2, to = 3) int i2, int[] iArr) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLSurface b(EGLDisplay eGLDisplay, Object obj, int i2, boolean z) throws GlUtil.GlException;

    GlTextureInfo c(int i2, int i3, int i4) throws GlUtil.GlException;

    @RequiresApi(17)
    EGLSurface d(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlUtil.GlException;
}
