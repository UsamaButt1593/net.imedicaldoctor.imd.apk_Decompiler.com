package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.EGLSurfaceTexture;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

@RequiresApi(17)
@UnstableApi
public final class PlaceholderSurface extends Surface {
    private static int X2 = 0;
    private static boolean Y2 = false;
    private static final String Z = "PlaceholderSurface";
    private final PlaceholderSurfaceThread X;
    private boolean Y;
    public final boolean s;

    private static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int Y2 = 1;
        private static final int Z2 = 2;
        private Handler X;
        @Nullable
        private PlaceholderSurface X2;
        @Nullable
        private Error Y;
        @Nullable
        private RuntimeException Z;
        private EGLSurfaceTexture s;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i2) throws GlUtil.GlException {
            Assertions.g(this.s);
            this.s.h(i2);
            this.X2 = new PlaceholderSurface(this, this.s.g(), i2 != 0);
        }

        private void d() {
            Assertions.g(this.s);
            this.s.i();
        }

        public PlaceholderSurface a(int i2) {
            boolean z;
            start();
            this.X = new Handler(getLooper(), this);
            this.s = new EGLSurfaceTexture(this.X);
            synchronized (this) {
                z = false;
                this.X.obtainMessage(1, i2, 0).sendToTarget();
                while (this.X2 == null && this.Z == null && this.Y == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.Z;
            if (runtimeException == null) {
                Error error = this.Y;
                if (error == null) {
                    return (PlaceholderSurface) Assertions.g(this.X2);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void c() {
            Assertions.g(this.X);
            this.X.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e(PlaceholderSurface.Z, "Failed to initialize placeholder surface", e2);
                    this.Z = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e3) {
                    Log.e(PlaceholderSurface.Z, "Failed to initialize placeholder surface", e3);
                    this.Z = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e4) {
                    try {
                        Log.e(PlaceholderSurface.Z, "Failed to initialize placeholder surface", e4);
                        this.Y = e4;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i2 != 2) {
                return true;
            } else {
                try {
                    d();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }
    }

    private PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.X = placeholderSurfaceThread;
        this.s = z;
    }

    private static int a(Context context) {
        if (GlUtil.M(context)) {
            return GlUtil.N() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean b(Context context) {
        boolean z;
        synchronized (PlaceholderSurface.class) {
            try {
                z = true;
                if (!Y2) {
                    X2 = a(context);
                    Y2 = true;
                }
                if (X2 == 0) {
                    z = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return z;
    }

    public static PlaceholderSurface c(Context context, boolean z) {
        int i2 = 0;
        Assertions.i(!z || b(context));
        PlaceholderSurfaceThread placeholderSurfaceThread = new PlaceholderSurfaceThread();
        if (z) {
            i2 = X2;
        }
        return placeholderSurfaceThread.a(i2);
    }

    public void release() {
        super.release();
        synchronized (this.X) {
            try {
                if (!this.Y) {
                    this.X.c();
                    this.Y = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
