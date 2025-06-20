package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.TileList;

interface ThreadUtil<T> {

    public interface BackgroundCallback<T> {
        void a(int i2, int i3, int i4, int i5, int i6);

        @SuppressLint({"UnknownNullness"})
        void b(TileList.Tile<T> tile);

        void c(int i2, int i3);

        void d(int i2);
    }

    public interface MainThreadCallback<T> {
        @SuppressLint({"UnknownNullness"})
        void a(int i2, TileList.Tile<T> tile);

        void b(int i2, int i3);

        void c(int i2, int i3);
    }

    BackgroundCallback<T> a(BackgroundCallback<T> backgroundCallback);

    MainThreadCallback<T> b(MainThreadCallback<T> mainThreadCallback);
}
