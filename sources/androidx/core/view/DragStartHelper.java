package androidx.core.view;

import android.graphics.Point;
import android.view.View;
import androidx.annotation.NonNull;

public class DragStartHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f6377a;

    /* renamed from: b  reason: collision with root package name */
    private final OnDragStartListener f6378b;

    /* renamed from: c  reason: collision with root package name */
    private int f6379c;

    /* renamed from: d  reason: collision with root package name */
    private int f6380d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6381e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnLongClickListener f6382f = new C0124t(this);

    /* renamed from: g  reason: collision with root package name */
    private final View.OnTouchListener f6383g = new C0126u(this);

    public interface OnDragStartListener {
        boolean a(@NonNull View view, @NonNull DragStartHelper dragStartHelper);
    }

    public DragStartHelper(@NonNull View view, @NonNull OnDragStartListener onDragStartListener) {
        this.f6377a = view;
        this.f6378b = onDragStartListener;
    }

    public void a() {
        this.f6377a.setOnLongClickListener(this.f6382f);
        this.f6377a.setOnTouchListener(this.f6383g);
    }

    public void b() {
        this.f6377a.setOnLongClickListener((View.OnLongClickListener) null);
        this.f6377a.setOnTouchListener((View.OnTouchListener) null);
    }

    public void c(@NonNull Point point) {
        point.set(this.f6379c, this.f6380d);
    }

    public boolean d(@NonNull View view) {
        if (this.f6381e) {
            return true;
        }
        boolean a2 = this.f6378b.a(view, this);
        this.f6381e = a2;
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (r2 != 3) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(@androidx.annotation.NonNull android.view.View r7, @androidx.annotation.NonNull android.view.MotionEvent r8) {
        /*
            r6 = this;
            float r0 = r8.getX()
            int r0 = (int) r0
            float r1 = r8.getY()
            int r1 = (int) r1
            int r2 = r8.getAction()
            r3 = 0
            if (r2 == 0) goto L_0x0049
            r4 = 1
            if (r2 == r4) goto L_0x0046
            r5 = 2
            if (r2 == r5) goto L_0x001b
            r7 = 3
            if (r2 == r7) goto L_0x0046
            goto L_0x004d
        L_0x001b:
            r2 = 8194(0x2002, float:1.1482E-41)
            boolean r2 = androidx.core.view.MotionEventCompat.l(r8, r2)
            if (r2 == 0) goto L_0x004d
            int r8 = r8.getButtonState()
            r8 = r8 & r4
            if (r8 != 0) goto L_0x002b
            goto L_0x004d
        L_0x002b:
            boolean r8 = r6.f6381e
            if (r8 == 0) goto L_0x0030
            goto L_0x004d
        L_0x0030:
            int r8 = r6.f6379c
            if (r8 != r0) goto L_0x0039
            int r8 = r6.f6380d
            if (r8 != r1) goto L_0x0039
            goto L_0x004d
        L_0x0039:
            r6.f6379c = r0
            r6.f6380d = r1
            androidx.core.view.DragStartHelper$OnDragStartListener r8 = r6.f6378b
            boolean r7 = r8.a(r7, r6)
            r6.f6381e = r7
            return r7
        L_0x0046:
            r6.f6381e = r3
            goto L_0x004d
        L_0x0049:
            r6.f6379c = r0
            r6.f6380d = r1
        L_0x004d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.DragStartHelper.e(android.view.View, android.view.MotionEvent):boolean");
    }
}
