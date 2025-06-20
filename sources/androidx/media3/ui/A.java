package androidx.media3.ui;

import android.view.View;

public final /* synthetic */ class A implements View.OnLayoutChangeListener {
    public final /* synthetic */ PlayerControlViewLayoutManager s;

    public /* synthetic */ A(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.s = playerControlViewLayoutManager;
    }

    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.s.S(view, i2, i3, i4, i5, i6, i7, i8, i9);
    }
}
