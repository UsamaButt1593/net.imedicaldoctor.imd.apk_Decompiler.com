package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f16557b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f16558a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f16557b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f16558a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i2;
        int bottom;
        int i3;
        int V = this.f16558a.V();
        if (V == 0) {
            return true;
        }
        boolean z = this.f16558a.Q2() == 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = V;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i4 = 0;
        while (i4 < V) {
            View U = this.f16558a.U(i4);
            if (U != null) {
                ViewGroup.LayoutParams layoutParams = U.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f16557b;
                int[] iArr3 = iArr2[i4];
                if (z) {
                    top = U.getLeft();
                    i2 = marginLayoutParams.leftMargin;
                } else {
                    top = U.getTop();
                    i2 = marginLayoutParams.topMargin;
                }
                iArr3[0] = top - i2;
                int[] iArr4 = iArr2[i4];
                if (z) {
                    bottom = U.getRight();
                    i3 = marginLayoutParams.rightMargin;
                } else {
                    bottom = U.getBottom();
                    i3 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = bottom + i3;
                i4++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i5 = 1; i5 < V; i5++) {
            if (iArr2[i5 - 1][1] != iArr2[i5][0]) {
                return false;
            }
        }
        int[] iArr5 = iArr2[0];
        int i6 = iArr5[1];
        int i7 = iArr5[0];
        return i7 <= 0 && iArr2[V - 1][1] >= i6 - i7;
    }

    private boolean b() {
        int V = this.f16558a.V();
        for (int i2 = 0; i2 < V; i2++) {
            if (c(this.f16558a.U(i2))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (c(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return (!a() || this.f16558a.V() <= 1) && b();
    }
}
