package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new View.OnClickListener() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            r3 = r0.y;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                androidx.appcompat.app.AlertController r0 = androidx.appcompat.app.AlertController.this
                android.widget.Button r1 = r0.o
                if (r3 != r1) goto L_0x000f
                android.os.Message r1 = r0.q
                if (r1 == 0) goto L_0x000f
            L_0x000a:
                android.os.Message r3 = android.os.Message.obtain(r1)
                goto L_0x0026
            L_0x000f:
                android.widget.Button r1 = r0.s
                if (r3 != r1) goto L_0x0018
                android.os.Message r1 = r0.u
                if (r1 == 0) goto L_0x0018
                goto L_0x000a
            L_0x0018:
                android.widget.Button r1 = r0.w
                if (r3 != r1) goto L_0x0025
                android.os.Message r3 = r0.y
                if (r3 == 0) goto L_0x0025
                android.os.Message r3 = android.os.Message.obtain(r3)
                goto L_0x0026
            L_0x0025:
                r3 = 0
            L_0x0026:
                if (r3 == 0) goto L_0x002b
                r3.sendToTarget()
            L_0x002b:
                androidx.appcompat.app.AlertController r3 = androidx.appcompat.app.AlertController.this
                android.os.Handler r0 = r3.R
                r1 = 1
                androidx.appcompat.app.AppCompatDialog r3 = r3.f2716b
                android.os.Message r3 = r0.obtainMessage(r1, r3)
                r3.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AnonymousClass1.onClick(android.view.View):void");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Context f2715a;

    /* renamed from: b  reason: collision with root package name */
    final AppCompatDialog f2716b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f2717c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2718d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f2719e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f2720f;

    /* renamed from: g  reason: collision with root package name */
    ListView f2721g;

    /* renamed from: h  reason: collision with root package name */
    private View f2722h;

    /* renamed from: i  reason: collision with root package name */
    private int f2723i;

    /* renamed from: j  reason: collision with root package name */
    private int f2724j;

    /* renamed from: k  reason: collision with root package name */
    private int f2725k;

    /* renamed from: l  reason: collision with root package name */
    private int f2726l;

    /* renamed from: m  reason: collision with root package name */
    private int f2727m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2728n = false;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;

    public static class AlertParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;
        public OnPrepareListViewListener P;
        public boolean Q = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f2735a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f2736b;

        /* renamed from: c  reason: collision with root package name */
        public int f2737c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f2738d;

        /* renamed from: e  reason: collision with root package name */
        public int f2739e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f2740f;

        /* renamed from: g  reason: collision with root package name */
        public View f2741g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f2742h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f2743i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f2744j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f2745k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f2746l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f2747m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f2748n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        public interface OnPrepareListViewListener {
            void a(ListView listView);
        }

        public AlertParams(Context context) {
            this.f2735a = context;
            this.r = true;
            this.f2736b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r8v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r8v3 */
        /* JADX WARNING: type inference failed for: r8v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v25, types: [androidx.appcompat.app.AlertController$AlertParams$2] */
        /* JADX WARNING: type inference failed for: r1v26, types: [androidx.appcompat.app.AlertController$AlertParams$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(final androidx.appcompat.app.AlertController r10) {
            /*
                r9 = this;
                android.view.LayoutInflater r0 = r9.f2736b
                int r1 = r10.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r9.G
                if (r1 == 0) goto L_0x0034
                android.database.Cursor r1 = r9.K
                if (r1 != 0) goto L_0x0025
                androidx.appcompat.app.AlertController$AlertParams$1 r8 = new androidx.appcompat.app.AlertController$AlertParams$1
                android.content.Context r3 = r9.f2735a
                int r4 = r10.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r9.v
                r1 = r8
                r2 = r9
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0069
            L_0x0025:
                androidx.appcompat.app.AlertController$AlertParams$2 r8 = new androidx.appcompat.app.AlertController$AlertParams$2
                android.content.Context r3 = r9.f2735a
                android.database.Cursor r4 = r9.K
                r5 = 0
                r1 = r8
                r2 = r9
                r6 = r0
                r7 = r10
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0069
            L_0x0034:
                boolean r1 = r9.H
                if (r1 == 0) goto L_0x003c
                int r1 = r10.N
            L_0x003a:
                r4 = r1
                goto L_0x003f
            L_0x003c:
                int r1 = r10.O
                goto L_0x003a
            L_0x003f:
                android.database.Cursor r1 = r9.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005b
                android.widget.SimpleCursorAdapter r8 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r9.f2735a
                android.database.Cursor r5 = r9.K
                java.lang.String r1 = r9.L
                java.lang.String[] r6 = new java.lang.String[]{r1}
                int[] r7 = new int[]{r2}
                r2 = r8
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0069
            L_0x005b:
                android.widget.ListAdapter r8 = r9.w
                if (r8 == 0) goto L_0x0060
                goto L_0x0069
            L_0x0060:
                androidx.appcompat.app.AlertController$CheckedItemAdapter r8 = new androidx.appcompat.app.AlertController$CheckedItemAdapter
                android.content.Context r1 = r9.f2735a
                java.lang.CharSequence[] r3 = r9.v
                r8.<init>(r1, r4, r2, r3)
            L_0x0069:
                androidx.appcompat.app.AlertController$AlertParams$OnPrepareListViewListener r1 = r9.P
                if (r1 == 0) goto L_0x0070
                r1.a(r0)
            L_0x0070:
                r10.H = r8
                int r1 = r9.I
                r10.I = r1
                android.content.DialogInterface$OnClickListener r1 = r9.x
                if (r1 == 0) goto L_0x0083
                androidx.appcompat.app.AlertController$AlertParams$3 r1 = new androidx.appcompat.app.AlertController$AlertParams$3
                r1.<init>(r10)
            L_0x007f:
                r0.setOnItemClickListener(r1)
                goto L_0x008d
            L_0x0083:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r9.J
                if (r1 == 0) goto L_0x008d
                androidx.appcompat.app.AlertController$AlertParams$4 r1 = new androidx.appcompat.app.AlertController$AlertParams$4
                r1.<init>(r0, r10)
                goto L_0x007f
            L_0x008d:
                android.widget.AdapterView$OnItemSelectedListener r1 = r9.O
                if (r1 == 0) goto L_0x0094
                r0.setOnItemSelectedListener(r1)
            L_0x0094:
                boolean r1 = r9.H
                if (r1 == 0) goto L_0x009d
                r1 = 1
            L_0x0099:
                r0.setChoiceMode(r1)
                goto L_0x00a3
            L_0x009d:
                boolean r1 = r9.G
                if (r1 == 0) goto L_0x00a3
                r1 = 2
                goto L_0x0099
            L_0x00a3:
                r10.f2721g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AlertParams.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f2741g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f2740f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f2738d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i2 = this.f2737c;
                if (i2 != 0) {
                    alertController.o(i2);
                }
                int i3 = this.f2739e;
                if (i3 != 0) {
                    alertController.o(alertController.d(i3));
                }
            }
            CharSequence charSequence2 = this.f2742h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f2743i;
            if (!(charSequence3 == null && this.f2744j == null)) {
                alertController.l(-1, charSequence3, this.f2745k, (Message) null, this.f2744j);
            }
            CharSequence charSequence4 = this.f2746l;
            if (!(charSequence4 == null && this.f2747m == null)) {
                alertController.l(-2, charSequence4, this.f2748n, (Message) null, this.f2747m);
            }
            CharSequence charSequence5 = this.o;
            if (!(charSequence5 == null && this.p == null)) {
                alertController.l(-3, charSequence5, this.q, (Message) null, this.p);
            }
            if (!(this.v == null && this.K == null && this.w == null)) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 == null) {
                int i4 = this.y;
                if (i4 != 0) {
                    alertController.t(i4);
                }
            } else if (this.E) {
                alertController.v(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.u(view2);
            }
        }
    }

    private static final class ButtonHandler extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private static final int f2749b = 1;

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f2750a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f2750a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2750a.get(), message.what);
            } else if (i2 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {
        private final int X2;
        private final int s;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.s, getPaddingRight(), z2 ? getPaddingBottom() : this.X2);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Y4);
            this.X2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Z4, -1);
            this.s = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.a5, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f2715a = context;
        this.f2716b = appCompatDialog;
        this.f2717c = window;
        this.R = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.T, R.attr.M, 0);
        this.J = obtainStyledAttributes.getResourceId(R.styleable.U, 0);
        this.K = obtainStyledAttributes.getResourceId(R.styleable.W, 0);
        this.L = obtainStyledAttributes.getResourceId(R.styleable.Y, 0);
        this.M = obtainStyledAttributes.getResourceId(R.styleable.Z, 0);
        this.N = obtainStyledAttributes.getResourceId(R.styleable.b0, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.X, 0);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.a0, true);
        this.f2718d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.V, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.o(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if (r1 != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        if (r1 != null) goto L_0x009f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A() {
        /*
            r8 = this;
            android.view.Window r0 = r8.f2717c
            int r1 = androidx.appcompat.R.id.O
            android.view.View r0 = r0.findViewById(r1)
            int r1 = androidx.appcompat.R.id.v0
            android.view.View r2 = r0.findViewById(r1)
            int r3 = androidx.appcompat.R.id.u
            android.view.View r4 = r0.findViewById(r3)
            int r5 = androidx.appcompat.R.id.q
            android.view.View r6 = r0.findViewById(r5)
            int r7 = androidx.appcompat.R.id.w
            android.view.View r0 = r0.findViewById(r7)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r8.y(r0)
            android.view.View r1 = r0.findViewById(r1)
            android.view.View r3 = r0.findViewById(r3)
            android.view.View r5 = r0.findViewById(r5)
            android.view.ViewGroup r1 = r8.j(r1, r2)
            android.view.ViewGroup r2 = r8.j(r3, r4)
            android.view.ViewGroup r3 = r8.j(r5, r6)
            r8.x(r2)
            r8.w(r3)
            r8.z(r1)
            int r0 = r0.getVisibility()
            r4 = 8
            r5 = 1
            r6 = 0
            if (r0 == r4) goto L_0x0052
            r0 = 1
            goto L_0x0053
        L_0x0052:
            r0 = 0
        L_0x0053:
            if (r1 == 0) goto L_0x005d
            int r7 = r1.getVisibility()
            if (r7 == r4) goto L_0x005d
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            if (r3 == 0) goto L_0x0068
            int r3 = r3.getVisibility()
            if (r3 == r4) goto L_0x0068
            r3 = 1
            goto L_0x0069
        L_0x0068:
            r3 = 0
        L_0x0069:
            if (r3 != 0) goto L_0x0078
            if (r2 == 0) goto L_0x0078
            int r4 = androidx.appcompat.R.id.q0
            android.view.View r4 = r2.findViewById(r4)
            if (r4 == 0) goto L_0x0078
            r4.setVisibility(r6)
        L_0x0078:
            if (r7 == 0) goto L_0x0095
            androidx.core.widget.NestedScrollView r4 = r8.A
            if (r4 == 0) goto L_0x0081
            r4.setClipToPadding(r5)
        L_0x0081:
            java.lang.CharSequence r4 = r8.f2720f
            if (r4 != 0) goto L_0x008c
            android.widget.ListView r4 = r8.f2721g
            if (r4 == 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r1 = 0
            goto L_0x0092
        L_0x008c:
            int r4 = androidx.appcompat.R.id.t0
            android.view.View r1 = r1.findViewById(r4)
        L_0x0092:
            if (r1 == 0) goto L_0x00a2
            goto L_0x009f
        L_0x0095:
            if (r2 == 0) goto L_0x00a2
            int r1 = androidx.appcompat.R.id.r0
            android.view.View r1 = r2.findViewById(r1)
            if (r1 == 0) goto L_0x00a2
        L_0x009f:
            r1.setVisibility(r6)
        L_0x00a2:
            android.widget.ListView r1 = r8.f2721g
            boolean r4 = r1 instanceof androidx.appcompat.app.AlertController.RecycleListView
            if (r4 == 0) goto L_0x00ad
            androidx.appcompat.app.AlertController$RecycleListView r1 = (androidx.appcompat.app.AlertController.RecycleListView) r1
            r1.a(r7, r3)
        L_0x00ad:
            if (r0 != 0) goto L_0x00c1
            android.widget.ListView r0 = r8.f2721g
            if (r0 == 0) goto L_0x00b4
            goto L_0x00b6
        L_0x00b4:
            androidx.core.widget.NestedScrollView r0 = r8.A
        L_0x00b6:
            if (r0 == 0) goto L_0x00c1
            if (r3 == 0) goto L_0x00bb
            r6 = 2
        L_0x00bb:
            r1 = r7 | r6
            r3 = 3
            r8.r(r2, r0, r1, r3)
        L_0x00c1:
            android.widget.ListView r0 = r8.f2721g
            if (r0 == 0) goto L_0x00d7
            android.widget.ListAdapter r1 = r8.H
            if (r1 == 0) goto L_0x00d7
            r0.setAdapter(r1)
            int r1 = r8.I
            r2 = -1
            if (r1 <= r2) goto L_0x00d7
            r0.setItemChecked(r1, r5)
            r0.setSelection(r1)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.A():void");
    }

    private static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.L, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        int i2 = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i2 = 0;
            }
            view3.setVisibility(i2);
        }
    }

    @Nullable
    private ViewGroup j(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i2 : this.J;
    }

    private void r(ViewGroup viewGroup, View view, int i2, int i3) {
        View view2;
        Runnable r6;
        final View findViewById = this.f2717c.findViewById(R.id.U);
        final View findViewById2 = this.f2717c.findViewById(R.id.T);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.z2(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 == null) {
                return;
            }
        } else {
            if (findViewById != null && (i2 & 1) == 0) {
                viewGroup.removeView(findViewById);
                findViewById = null;
            }
            if (findViewById2 != null && (i2 & 2) == 0) {
                viewGroup.removeView(findViewById2);
                findViewById2 = null;
            }
            if (findViewById != null || findViewById2 != null) {
                if (this.f2720f != null) {
                    this.A.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                            AlertController.g(nestedScrollView, findViewById, findViewById2);
                        }
                    });
                    view2 = this.A;
                    r6 = new Runnable() {
                        public void run() {
                            AlertController.g(AlertController.this.A, findViewById, findViewById2);
                        }
                    };
                } else {
                    ListView listView = this.f2721g;
                    if (listView != null) {
                        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                                AlertController.g(absListView, findViewById, findViewById2);
                            }

                            public void onScrollStateChanged(AbsListView absListView, int i2) {
                            }
                        });
                        view2 = this.f2721g;
                        r6 = new Runnable() {
                            public void run() {
                                AlertController.g(AlertController.this.f2721g, findViewById, findViewById2);
                            }
                        };
                    } else {
                        if (findViewById != null) {
                            viewGroup.removeView(findViewById);
                        }
                        if (findViewById2 == null) {
                            return;
                        }
                    }
                }
                view2.post(r6);
                return;
            }
            return;
        }
        viewGroup.removeView(findViewById2);
    }

    private void w(ViewGroup viewGroup) {
        boolean z2;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(16908313);
        this.o = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.p) || this.r != null) {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f2718d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.o.setVisibility(0);
            z2 = true;
        } else {
            this.o.setVisibility(8);
            z2 = false;
        }
        Button button3 = (Button) viewGroup.findViewById(16908314);
        this.s = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.t) || this.v != null) {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f2718d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.s.setVisibility(0);
            z2 |= true;
        } else {
            this.s.setVisibility(8);
        }
        Button button4 = (Button) viewGroup.findViewById(16908315);
        this.w = button4;
        button4.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.x) || this.z != null) {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i4 = this.f2718d;
                drawable3.setBounds(0, 0, i4, i4);
                this.w.setCompoundDrawables(this.z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.w.setVisibility(0);
            z2 |= true;
        } else {
            this.w.setVisibility(8);
        }
        if (B(this.f2715a)) {
            if (z2) {
                button = this.o;
            } else if (z2) {
                button = this.s;
            } else if (z2) {
                button = this.w;
            }
            b(button);
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    private void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f2717c.findViewById(R.id.V);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f2720f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f2721g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f2721g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void y(ViewGroup viewGroup) {
        View view = this.f2722h;
        boolean z2 = false;
        if (view == null) {
            view = this.f2723i != 0 ? LayoutInflater.from(this.f2715a).inflate(this.f2723i, viewGroup, false) : null;
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.f2717c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f2717c.findViewById(R.id.v);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f2728n) {
                frameLayout.setPadding(this.f2724j, this.f2725k, this.f2726l, this.f2727m);
            }
            if (this.f2721g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void z(ViewGroup viewGroup) {
        View view;
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            view = this.f2717c.findViewById(R.id.u0);
        } else {
            this.D = (ImageView) this.f2717c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(this.f2719e)) || !this.P) {
                this.f2717c.findViewById(R.id.u0).setVisibility(8);
                this.D.setVisibility(8);
                view = viewGroup;
            } else {
                TextView textView = (TextView) this.f2717c.findViewById(R.id.p);
                this.E = textView;
                textView.setText(this.f2719e);
                int i2 = this.B;
                if (i2 != 0) {
                    this.D.setImageResource(i2);
                    return;
                }
                Drawable drawable = this.C;
                if (drawable != null) {
                    this.D.setImageDrawable(drawable);
                    return;
                }
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        view.setVisibility(8);
    }

    public Button c(int i2) {
        if (i2 == -3) {
            return this.w;
        }
        if (i2 == -2) {
            return this.s;
        }
        if (i2 != -1) {
            return null;
        }
        return this.o;
    }

    public int d(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f2715a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f2721g;
    }

    public void f() {
        this.f2716b.setContentView(k());
        A();
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.x(keyEvent);
    }

    public boolean i(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.x(keyEvent);
    }

    public void l(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m(int i2) {
        this.Q = i2;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void q(CharSequence charSequence) {
        this.f2720f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(CharSequence charSequence) {
        this.f2719e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i2) {
        this.f2722h = null;
        this.f2723i = i2;
        this.f2728n = false;
    }

    public void u(View view) {
        this.f2722h = view;
        this.f2723i = 0;
        this.f2728n = false;
    }

    public void v(View view, int i2, int i3, int i4, int i5) {
        this.f2722h = view;
        this.f2723i = 0;
        this.f2728n = true;
        this.f2724j = i2;
        this.f2725k = i3;
        this.f2726l = i4;
        this.f2727m = i5;
    }
}
