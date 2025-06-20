package it.neokree.materialtabs;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import at.markushi.ui.RevealColorView;

public class tabBuilder<T extends TextView> {

    /* renamed from: a  reason: collision with root package name */
    private Context f28764a;

    /* renamed from: b  reason: collision with root package name */
    private layout f28765b;

    /* renamed from: c  reason: collision with root package name */
    private View f28766c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f28767d;

    /* renamed from: e  reason: collision with root package name */
    private T f28768e;

    /* renamed from: f  reason: collision with root package name */
    private RevealColorView f28769f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f28770g;

    /* renamed from: h  reason: collision with root package name */
    private int f28771h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f28772i;

    /* renamed from: it.neokree.materialtabs.tabBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28773a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                it.neokree.materialtabs.tabBuilder$layout[] r0 = it.neokree.materialtabs.tabBuilder.layout.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28773a = r0
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_CLASSIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28773a     // Catch:{ NoSuchFieldError -> 0x001d }
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_ICON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28773a     // Catch:{ NoSuchFieldError -> 0x0028 }
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_MATERIAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28773a     // Catch:{ NoSuchFieldError -> 0x0033 }
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_MATERIAL_ICON     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f28773a     // Catch:{ NoSuchFieldError -> 0x003e }
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_CUSTOM_TEXT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f28773a     // Catch:{ NoSuchFieldError -> 0x0049 }
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_CUSTOM_ICON     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f28773a     // Catch:{ NoSuchFieldError -> 0x0054 }
                it.neokree.materialtabs.tabBuilder$layout r1 = it.neokree.materialtabs.tabBuilder.layout.TAB_CUSTOM_NO_BUBBLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: it.neokree.materialtabs.tabBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum layout {
        TAB_ICON,
        TAB_CLASSIC,
        TAB_MATERIAL,
        TAB_MATERIAL_ICON,
        TAB_CUSTOM_TEXT,
        TAB_CUSTOM_ICON,
        TAB_CUSTOM_NO_BUBBLE,
        TAB_HORIZONTAL_TEXT_ICON_LTR,
        TAB_HORIZONTAL_TEXT_ICON_RTL
    }

    public tabBuilder(layout layout2) {
        this.f28765b = layout2;
    }

    public RevealColorView a() {
        return this.f28769f;
    }

    public ImageView b() {
        return this.f28767d;
    }

    public ImageView c() {
        return this.f28770g;
    }

    public T d() {
        return this.f28768e;
    }

    public boolean e() {
        return this.f28772i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0064, code lost:
        r0 = r0.inflate(r1, (android.view.ViewGroup) null);
        r4.f28766c = r0;
        r4.f28768e = (android.widget.TextView) r0.findViewById(it.neokree.materialtabs.R.id.j0);
        r4.f28769f = r4.f28766c.findViewById(it.neokree.materialtabs.R.id.P);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ac, code lost:
        r4.f28770g = (android.widget.ImageView) r4.f28766c.findViewById(it.neokree.materialtabs.R.id.b0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00b8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        r0 = r0.inflate(r1, (android.view.ViewGroup) null);
        r4.f28766c = r0;
        r4.f28768e = (android.widget.TextView) r0.findViewById(it.neokree.materialtabs.R.id.j0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0028, code lost:
        r4.f28772i = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r0 = r0.inflate(r2, (android.view.ViewGroup) null);
        r4.f28766c = r0;
        r4.f28767d = (android.widget.ImageView) r0.findViewById(it.neokree.materialtabs.R.id.C);
        r4.f28769f = r4.f28766c.findViewById(it.neokree.materialtabs.R.id.P);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0059, code lost:
        r4.f28772i = true;
     */
    @android.annotation.SuppressLint({"WrongViewCast"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public it.neokree.materialtabs.tabBuilder f() {
        /*
            r4 = this;
            int[] r0 = it.neokree.materialtabs.tabBuilder.AnonymousClass1.f28773a
            it.neokree.materialtabs.tabBuilder$layout r1 = r4.f28765b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 0
            r3 = 0
            switch(r0) {
                case 1: goto L_0x0010;
                case 2: goto L_0x0093;
                case 3: goto L_0x008a;
                case 4: goto L_0x0081;
                case 5: goto L_0x005c;
                case 6: goto L_0x0035;
                case 7: goto L_0x002c;
                default: goto L_0x0010;
            }
        L_0x0010:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = it.neokree.materialtabs.R.layout.A
        L_0x0018:
            android.view.View r0 = r0.inflate(r1, r3)
            r4.f28766c = r0
            int r1 = it.neokree.materialtabs.R.id.j0
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.f28768e = r0
        L_0x0028:
            r4.f28772i = r2
            goto L_0x00ac
        L_0x002c:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r4.f28771h
            goto L_0x0018
        L_0x0035:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = r4.f28771h
        L_0x003d:
            android.view.View r0 = r0.inflate(r2, r3)
            r4.f28766c = r0
            int r2 = it.neokree.materialtabs.R.id.C
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.f28767d = r0
            android.view.View r0 = r4.f28766c
            int r2 = it.neokree.materialtabs.R.id.P
            android.view.View r0 = r0.findViewById(r2)
            at.markushi.ui.RevealColorView r0 = (at.markushi.ui.RevealColorView) r0
            r4.f28769f = r0
        L_0x0059:
            r4.f28772i = r1
            goto L_0x00ac
        L_0x005c:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r4.f28771h
        L_0x0064:
            android.view.View r0 = r0.inflate(r1, r3)
            r4.f28766c = r0
            int r1 = it.neokree.materialtabs.R.id.j0
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.f28768e = r0
            android.view.View r0 = r4.f28766c
            int r1 = it.neokree.materialtabs.R.id.P
            android.view.View r0 = r0.findViewById(r1)
            at.markushi.ui.RevealColorView r0 = (at.markushi.ui.RevealColorView) r0
            r4.f28769f = r0
            goto L_0x0028
        L_0x0081:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = it.neokree.materialtabs.R.layout.x
            goto L_0x003d
        L_0x008a:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = it.neokree.materialtabs.R.layout.w
            goto L_0x0064
        L_0x0093:
            android.content.Context r0 = r4.f28764a
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = it.neokree.materialtabs.R.layout.B
            android.view.View r0 = r0.inflate(r2, r3)
            r4.f28766c = r0
            int r2 = it.neokree.materialtabs.R.id.C
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.f28767d = r0
            goto L_0x0059
        L_0x00ac:
            android.view.View r0 = r4.f28766c
            int r1 = it.neokree.materialtabs.R.id.b0
            android.view.View r0 = r0.findViewById(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.f28770g = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: it.neokree.materialtabs.tabBuilder.f():it.neokree.materialtabs.tabBuilder");
    }

    public tabBuilder g(int i2) {
        this.f28771h = i2;
        return this;
    }

    public View h() {
        return this.f28766c;
    }

    public tabBuilder i(Context context) {
        this.f28764a = context;
        return this;
    }
}
