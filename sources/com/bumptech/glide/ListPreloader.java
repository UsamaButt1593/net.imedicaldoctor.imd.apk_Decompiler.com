package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f17624a;

    /* renamed from: b  reason: collision with root package name */
    private final PreloadTargetQueue f17625b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManager f17626c;

    /* renamed from: d  reason: collision with root package name */
    private final PreloadModelProvider<T> f17627d;

    /* renamed from: e  reason: collision with root package name */
    private final PreloadSizeProvider<T> f17628e;

    /* renamed from: f  reason: collision with root package name */
    private int f17629f;

    /* renamed from: g  reason: collision with root package name */
    private int f17630g;

    /* renamed from: h  reason: collision with root package name */
    private int f17631h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f17632i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17633j = true;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> a(int i2);

        @Nullable
        RequestBuilder<?> b(@NonNull U u);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] a(@NonNull T t, int i2, int i3);
    }

    private static final class PreloadTarget implements Target<Object> {
        int X;
        @Nullable
        private Request Y;
        int s;

        PreloadTarget() {
        }

        public void a() {
        }

        public void b() {
        }

        public void c(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        public void d() {
        }

        public void e(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void j(@Nullable Request request) {
            this.Y = request;
        }

        public void k(@Nullable Drawable drawable) {
        }

        public void p(@Nullable Drawable drawable) {
        }

        @Nullable
        public Request q() {
            return this.Y;
        }

        public void r(@Nullable Drawable drawable) {
        }

        public void s(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.e(this.X, this.s);
        }
    }

    private static final class PreloadTargetQueue {

        /* renamed from: a  reason: collision with root package name */
        final Queue<PreloadTarget> f17634a;

        PreloadTargetQueue(int i2) {
            this.f17634a = Util.f(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.f17634a.offer(new PreloadTarget());
            }
        }

        public PreloadTarget a(int i2, int i3) {
            PreloadTarget poll = this.f17634a.poll();
            this.f17634a.offer(poll);
            poll.X = i2;
            poll.s = i3;
            return poll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i2) {
        this.f17626c = requestManager;
        this.f17627d = preloadModelProvider;
        this.f17628e = preloadSizeProvider;
        this.f17624a = i2;
        this.f17625b = new PreloadTargetQueue(i2 + 1);
    }

    private void a() {
        for (int i2 = 0; i2 < this.f17625b.f17634a.size(); i2++) {
            this.f17626c.C(this.f17625b.a(0, 0));
        }
    }

    private void b(int i2, int i3) {
        int i4;
        int i5;
        if (i2 < i3) {
            i4 = Math.max(this.f17629f, i2);
            i5 = i3;
        } else {
            i5 = Math.min(this.f17630g, i2);
            i4 = i3;
        }
        int min = Math.min(this.f17632i, i5);
        int min2 = Math.min(this.f17632i, Math.max(0, i4));
        if (i2 < i3) {
            for (int i6 = min2; i6 < min; i6++) {
                d(this.f17627d.a(i6), i6, true);
            }
        } else {
            for (int i7 = min - 1; i7 >= min2; i7--) {
                d(this.f17627d.a(i7), i7, false);
            }
        }
        this.f17630g = min2;
        this.f17629f = min;
    }

    private void c(int i2, boolean z) {
        if (this.f17633j != z) {
            this.f17633j = z;
            a();
        }
        b(i2, (z ? this.f17624a : -this.f17624a) + i2);
    }

    private void d(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e(list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            e(list.get(i4), i2, i4);
        }
    }

    private void e(@Nullable T t, int i2, int i3) {
        int[] a2;
        RequestBuilder<?> b2;
        if (t != null && (a2 = this.f17628e.a(t, i2, i3)) != null && (b2 = this.f17627d.b(t)) != null) {
            b2.r2(this.f17625b.a(a2[0], a2[1]));
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.f17632i = i4;
        int i5 = this.f17631h;
        if (i2 > i5) {
            c(i3 + i2, true);
        } else if (i2 < i5) {
            c(i2, false);
        }
        this.f17631h = i2;
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
