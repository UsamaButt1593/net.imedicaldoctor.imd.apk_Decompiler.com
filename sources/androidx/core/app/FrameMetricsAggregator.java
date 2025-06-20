package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator {

    /* renamed from: b  reason: collision with root package name */
    public static final int f5234b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5235c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5236d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5237e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5238f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5239g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5240h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5241i = 7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f5242j = 8;

    /* renamed from: k  reason: collision with root package name */
    private static final int f5243k = 8;

    /* renamed from: l  reason: collision with root package name */
    public static final int f5244l = 1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f5245m = 2;

    /* renamed from: n  reason: collision with root package name */
    public static final int f5246n = 4;
    public static final int o = 8;
    public static final int p = 16;
    public static final int q = 32;
    public static final int r = 64;
    public static final int s = 128;
    public static final int t = 256;
    public static final int u = 511;

    /* renamed from: a  reason: collision with root package name */
    private final FrameMetricsBaseImpl f5247a;

    @RequiresApi(24)
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* renamed from: e  reason: collision with root package name */
        private static final int f5248e = 1000000;

        /* renamed from: f  reason: collision with root package name */
        private static final int f5249f = 500000;

        /* renamed from: g  reason: collision with root package name */
        private static HandlerThread f5250g;

        /* renamed from: h  reason: collision with root package name */
        private static Handler f5251h;

        /* renamed from: a  reason: collision with root package name */
        int f5252a;

        /* renamed from: b  reason: collision with root package name */
        SparseIntArray[] f5253b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<WeakReference<Activity>> f5254c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f5255d = new Window.OnFrameMetricsAvailableListener() {
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.f5252a & 1) != 0) {
                    frameMetricsApi24Impl.f(frameMetricsApi24Impl.f5253b[0], frameMetrics.getMetric(8));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl2.f5252a & 2) != 0) {
                    frameMetricsApi24Impl2.f(frameMetricsApi24Impl2.f5253b[1], frameMetrics.getMetric(1));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl3.f5252a & 4) != 0) {
                    frameMetricsApi24Impl3.f(frameMetricsApi24Impl3.f5253b[2], frameMetrics.getMetric(3));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl4.f5252a & 8) != 0) {
                    frameMetricsApi24Impl4.f(frameMetricsApi24Impl4.f5253b[3], frameMetrics.getMetric(4));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl5.f5252a & 16) != 0) {
                    frameMetricsApi24Impl5.f(frameMetricsApi24Impl5.f5253b[4], frameMetrics.getMetric(5));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl6.f5252a & 64) != 0) {
                    frameMetricsApi24Impl6.f(frameMetricsApi24Impl6.f5253b[6], frameMetrics.getMetric(7));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl7.f5252a & 32) != 0) {
                    frameMetricsApi24Impl7.f(frameMetricsApi24Impl7.f5253b[5], frameMetrics.getMetric(6));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl8.f5252a & 128) != 0) {
                    frameMetricsApi24Impl8.f(frameMetricsApi24Impl8.f5253b[7], frameMetrics.getMetric(0));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl9.f5252a & 256) != 0) {
                    frameMetricsApi24Impl9.f(frameMetricsApi24Impl9.f5253b[8], frameMetrics.getMetric(2));
                }
            }
        };

        FrameMetricsApi24Impl(int i2) {
            this.f5252a = i2;
        }

        public void a(Activity activity) {
            if (f5250g == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f5250g = handlerThread;
                handlerThread.start();
                f5251h = new Handler(f5250g.getLooper());
            }
            for (int i2 = 0; i2 <= 8; i2++) {
                SparseIntArray[] sparseIntArrayArr = this.f5253b;
                if (sparseIntArrayArr[i2] == null && (this.f5252a & (1 << i2)) != 0) {
                    sparseIntArrayArr[i2] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f5255d, f5251h);
            this.f5254c.add(new WeakReference(activity));
        }

        public SparseIntArray[] b() {
            return this.f5253b;
        }

        public SparseIntArray[] c(Activity activity) {
            Iterator<WeakReference<Activity>> it2 = this.f5254c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                WeakReference next = it2.next();
                if (next.get() == activity) {
                    this.f5254c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f5255d);
            return this.f5253b;
        }

        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f5253b;
            this.f5253b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        public SparseIntArray[] e() {
            for (int size = this.f5254c.size() - 1; size >= 0; size--) {
                WeakReference weakReference = this.f5254c.get(size);
                Activity activity = (Activity) weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f5255d);
                    this.f5254c.remove(size);
                }
            }
            return this.f5253b;
        }

        /* access modifiers changed from: package-private */
        public void f(SparseIntArray sparseIntArray, long j2) {
            if (sparseIntArray != null) {
                int i2 = (int) ((500000 + j2) / 1000000);
                if (j2 >= 0) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                }
            }
        }
    }

    private static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }

        public SparseIntArray[] e() {
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void a(@NonNull Activity activity) {
        this.f5247a.a(activity);
    }

    @Nullable
    public SparseIntArray[] b() {
        return this.f5247a.b();
    }

    @Nullable
    public SparseIntArray[] c(@NonNull Activity activity) {
        return this.f5247a.c(activity);
    }

    @Nullable
    public SparseIntArray[] d() {
        return this.f5247a.d();
    }

    @Nullable
    public SparseIntArray[] e() {
        return this.f5247a.e();
    }

    public FrameMetricsAggregator(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f5247a = new FrameMetricsApi24Impl(i2);
        } else {
            this.f5247a = new FrameMetricsBaseImpl();
        }
    }
}
