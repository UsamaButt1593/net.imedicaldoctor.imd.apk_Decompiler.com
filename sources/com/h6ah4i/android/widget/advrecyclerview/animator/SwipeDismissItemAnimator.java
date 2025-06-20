package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.AddAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ChangeAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAddAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.MoveAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.RemoveAnimationInfo;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder;

public class SwipeDismissItemAnimator extends GeneralItemAnimator {
    public static final Interpolator s = new AccelerateDecelerateInterpolator();

    private static class DefaultItemAddAnimationManager extends ItemAddAnimationManager {
        public DefaultItemAddAnimationManager(BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public void r(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            ViewCompat.M1(viewHolder.f15587a, 1.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public void s(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            ViewCompat.M1(viewHolder.f15587a, 1.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: F */
        public void t(AddAnimationInfo addAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: G */
        public void u(AddAnimationInfo addAnimationInfo) {
            ViewPropertyAnimatorCompat g2 = ViewCompat.g(addAnimationInfo.f25344a.f15587a);
            g2.b(1.0f);
            g2.s(o());
            y(addAnimationInfo, addAnimationInfo.f25344a, g2);
        }

        public boolean z(RecyclerView.ViewHolder viewHolder) {
            j(viewHolder);
            ViewCompat.M1(viewHolder.f15587a, 0.0f);
            n(new AddAnimationInfo(viewHolder));
            return true;
        }
    }

    private static class SwipeDismissItemChangeAnimationManager extends ItemChangeAnimationManager {
        public SwipeDismissItemChangeAnimationManager(BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        /* access modifiers changed from: protected */
        public void E(ChangeAnimationInfo changeAnimationInfo) {
            ViewPropertyAnimatorCompat g2 = ViewCompat.g(changeAnimationInfo.f25353a.f15587a);
            g2.z(0.0f);
            g2.B(0.0f);
            g2.s(o());
            g2.b(1.0f);
            y(changeAnimationInfo, changeAnimationInfo.f25353a, g2);
        }

        /* access modifiers changed from: protected */
        public void F(ChangeAnimationInfo changeAnimationInfo) {
            ViewPropertyAnimatorCompat g2 = ViewCompat.g(changeAnimationInfo.f25354b.f15587a);
            g2.s(o());
            g2.z((float) (changeAnimationInfo.f25357e - changeAnimationInfo.f25355c));
            g2.B((float) (changeAnimationInfo.f25358f - changeAnimationInfo.f25356d));
            g2.b(0.0f);
            y(changeAnimationInfo, changeAnimationInfo.f25354b, g2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: G */
        public void r(ChangeAnimationInfo changeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: H */
        public void s(ChangeAnimationInfo changeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            ViewCompat.M1(view, 1.0f);
            ViewCompat.E2(view, 0.0f);
            ViewCompat.F2(view, 0.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: I */
        public void t(ChangeAnimationInfo changeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            ViewCompat.M1(view, 1.0f);
            ViewCompat.E2(view, 0.0f);
            ViewCompat.F2(view, 0.0f);
        }

        public boolean z(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
            float B0 = ViewCompat.B0(viewHolder.f15587a);
            float C0 = ViewCompat.C0(viewHolder.f15587a);
            float L = ViewCompat.L(viewHolder.f15587a);
            j(viewHolder);
            int i6 = (int) (((float) (i4 - i2)) - B0);
            int i7 = (int) (((float) (i5 - i3)) - C0);
            ViewCompat.E2(viewHolder.f15587a, B0);
            ViewCompat.F2(viewHolder.f15587a, C0);
            ViewCompat.M1(viewHolder.f15587a, L);
            if (!(viewHolder2 == null || viewHolder2.f15587a == null)) {
                j(viewHolder2);
                ViewCompat.E2(viewHolder2.f15587a, (float) (-i6));
                ViewCompat.F2(viewHolder2.f15587a, (float) (-i7));
                ViewCompat.M1(viewHolder2.f15587a, 0.0f);
            }
            n(new ChangeAnimationInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
            return true;
        }
    }

    private static class SwipeDismissItemMoveAnimationManager extends ItemMoveAnimationManager {
        public SwipeDismissItemMoveAnimationManager(BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        /* access modifiers changed from: protected */
        /* renamed from: D */
        public void r(MoveAnimationInfo moveAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            int i2 = moveAnimationInfo.f25366d - moveAnimationInfo.f25364b;
            int i3 = moveAnimationInfo.f25367e - moveAnimationInfo.f25365c;
            if (i2 != 0) {
                ViewCompat.g(view).z(0.0f);
            }
            if (i3 != 0) {
                ViewCompat.g(view).B(0.0f);
            }
            if (i2 != 0) {
                ViewCompat.E2(view, 0.0f);
            }
            if (i3 != 0) {
                ViewCompat.F2(view, 0.0f);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public void s(MoveAnimationInfo moveAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            ViewCompat.F2(view, 0.0f);
            ViewCompat.E2(view, 0.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: F */
        public void t(MoveAnimationInfo moveAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: G */
        public void u(MoveAnimationInfo moveAnimationInfo) {
            View view = moveAnimationInfo.f25363a.f15587a;
            int i2 = moveAnimationInfo.f25366d - moveAnimationInfo.f25364b;
            int i3 = moveAnimationInfo.f25367e - moveAnimationInfo.f25365c;
            if (i2 != 0) {
                ViewCompat.g(view).z(0.0f);
            }
            if (i3 != 0) {
                ViewCompat.g(view).B(0.0f);
            }
            ViewPropertyAnimatorCompat g2 = ViewCompat.g(view);
            g2.s(o());
            g2.t(SwipeDismissItemAnimator.s);
            y(moveAnimationInfo, moveAnimationInfo.f25363a, g2);
        }

        public boolean z(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
            View view = viewHolder.f15587a;
            int B0 = (int) (((float) i2) + ViewCompat.B0(view));
            int C0 = (int) (((float) i3) + ViewCompat.C0(viewHolder.f15587a));
            j(viewHolder);
            int i6 = i4 - B0;
            int i7 = i5 - C0;
            MoveAnimationInfo moveAnimationInfo = new MoveAnimationInfo(viewHolder, B0, C0, i4, i5);
            if (i6 == 0 && i7 == 0) {
                e(moveAnimationInfo, moveAnimationInfo.f25363a);
                moveAnimationInfo.a(moveAnimationInfo.f25363a);
                return false;
            }
            if (i6 != 0) {
                ViewCompat.E2(view, (float) (-i6));
            }
            if (i7 != 0) {
                ViewCompat.F2(view, (float) (-i7));
            }
            n(moveAnimationInfo);
            return true;
        }
    }

    private static class SwipeDismissItemRemoveAnimationManager extends ItemRemoveAnimationManager {

        /* renamed from: f  reason: collision with root package name */
        private static final Interpolator f25343f = new AccelerateDecelerateInterpolator();

        public SwipeDismissItemRemoveAnimationManager(BaseItemAnimator baseItemAnimator) {
            super(baseItemAnimator);
        }

        private static boolean D(RecyclerView.ViewHolder viewHolder) {
            if (!(viewHolder instanceof SwipeableItemViewHolder)) {
                return false;
            }
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
            int a2 = swipeableItemViewHolder.a();
            return (a2 == 2 || a2 == 3) && swipeableItemViewHolder.f() == 1;
        }

        private static boolean E(RemoveAnimationInfo removeAnimationInfo) {
            return removeAnimationInfo instanceof SwipeDismissRemoveAnimationInfo;
        }

        /* access modifiers changed from: protected */
        /* renamed from: F */
        public void r(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
        }

        /* access modifiers changed from: protected */
        /* renamed from: G */
        public void s(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            if (E(removeAnimationInfo)) {
                ViewCompat.E2(view, 0.0f);
                ViewCompat.F2(view, 0.0f);
                return;
            }
            ViewCompat.M1(view, 1.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: H */
        public void t(RemoveAnimationInfo removeAnimationInfo, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.f15587a;
            if (E(removeAnimationInfo)) {
                ViewCompat.E2(view, 0.0f);
                ViewCompat.F2(view, 0.0f);
                return;
            }
            ViewCompat.M1(view, 1.0f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: I */
        public void u(RemoveAnimationInfo removeAnimationInfo) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
            if (D(removeAnimationInfo.f25368a)) {
                viewPropertyAnimatorCompat = ViewCompat.g(removeAnimationInfo.f25368a.f15587a);
                viewPropertyAnimatorCompat.s(o());
            } else {
                viewPropertyAnimatorCompat = ViewCompat.g(removeAnimationInfo.f25368a.f15587a);
                viewPropertyAnimatorCompat.s(o());
                viewPropertyAnimatorCompat.t(f25343f);
                viewPropertyAnimatorCompat.b(0.0f);
            }
            y(removeAnimationInfo, removeAnimationInfo.f25368a, viewPropertyAnimatorCompat);
        }

        public boolean z(RecyclerView.ViewHolder viewHolder) {
            ItemAnimationInfo removeAnimationInfo;
            if (D(viewHolder)) {
                View view = viewHolder.f15587a;
                j(viewHolder);
                ViewCompat.E2(view, (float) ((int) (ViewCompat.B0(view) + 0.5f)));
                ViewCompat.F2(view, (float) ((int) (ViewCompat.C0(view) + 0.5f)));
                removeAnimationInfo = new SwipeDismissRemoveAnimationInfo(viewHolder);
            } else {
                j(viewHolder);
                removeAnimationInfo = new RemoveAnimationInfo(viewHolder);
            }
            n(removeAnimationInfo);
            return true;
        }
    }

    private static class SwipeDismissRemoveAnimationInfo extends RemoveAnimationInfo {
        public SwipeDismissRemoveAnimationInfo(RecyclerView.ViewHolder viewHolder) {
            super(viewHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void a0(RecyclerView.ViewHolder viewHolder) {
        super.a0(viewHolder);
    }

    /* access modifiers changed from: protected */
    public void h0() {
        j0();
    }

    /* access modifiers changed from: protected */
    public void i0() {
        l0(new DefaultItemAddAnimationManager(this));
        o0(new SwipeDismissItemRemoveAnimationManager(this));
        m0(new SwipeDismissItemChangeAnimationManager(this));
        n0(new SwipeDismissItemMoveAnimationManager(this));
        C(150);
        B(150);
    }
}
