package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.itextpdf.text.html.HtmlTags;

public class ConstraintProperties {

    /* renamed from: c  reason: collision with root package name */
    public static final int f4682c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f4683d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f4684e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f4685f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f4686g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4687h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static final int f4688i = 7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f4689j = -1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f4690k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final int f4691l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f4692m = -2;

    /* renamed from: n  reason: collision with root package name */
    public static final int f4693n = 1;
    public static final int o = 0;

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout.LayoutParams f4694a;

    /* renamed from: b  reason: collision with root package name */
    View f4695b;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f4694a = (ConstraintLayout.LayoutParams) layoutParams;
            this.f4695b = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String K(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return HtmlTags.i0;
            case 6:
                return "start";
            case 7:
                return TtmlNode.p0;
            default:
                return "undefined";
        }
    }

    public ConstraintProperties A(float f2) {
        this.f4694a.L = f2;
        return this;
    }

    public ConstraintProperties B(int i2, int i3) {
        switch (i2) {
            case 1:
                this.f4694a.leftMargin = i3;
                break;
            case 2:
                this.f4694a.rightMargin = i3;
                break;
            case 3:
                this.f4694a.topMargin = i3;
                break;
            case 4:
                this.f4694a.bottomMargin = i3;
                break;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f4694a.setMarginStart(i3);
                break;
            case 7:
                this.f4694a.setMarginEnd(i3);
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties C(int i2) {
        switch (i2) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.f4694a;
                layoutParams.f4631f = -1;
                layoutParams.f4630e = -1;
                layoutParams.leftMargin = -1;
                layoutParams.w = Integer.MIN_VALUE;
                break;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.f4694a;
                layoutParams2.f4633h = -1;
                layoutParams2.f4632g = -1;
                layoutParams2.rightMargin = -1;
                layoutParams2.y = Integer.MIN_VALUE;
                break;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.f4694a;
                layoutParams3.f4635j = -1;
                layoutParams3.f4634i = -1;
                layoutParams3.topMargin = -1;
                layoutParams3.x = Integer.MIN_VALUE;
                break;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.f4694a;
                layoutParams4.f4636k = -1;
                layoutParams4.f4637l = -1;
                layoutParams4.bottomMargin = -1;
                layoutParams4.z = Integer.MIN_VALUE;
                break;
            case 5:
                this.f4694a.f4638m = -1;
                break;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.f4694a;
                layoutParams5.s = -1;
                layoutParams5.t = -1;
                layoutParams5.setMarginStart(-1);
                this.f4694a.A = Integer.MIN_VALUE;
                break;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.f4694a;
                layoutParams6.u = -1;
                layoutParams6.v = -1;
                layoutParams6.setMarginEnd(-1);
                this.f4694a.B = Integer.MIN_VALUE;
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties D() {
        ConstraintLayout.LayoutParams layoutParams = this.f4694a;
        int i2 = layoutParams.f4631f;
        int i3 = layoutParams.f4632g;
        if (i2 == -1 && i3 == -1) {
            int i4 = layoutParams.s;
            int i5 = layoutParams.u;
            if (!(i4 == -1 && i5 == -1)) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i4));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i5));
                ConstraintLayout.LayoutParams layoutParams2 = this.f4694a;
                if (i4 != -1 && i5 != -1) {
                    constraintProperties.m(7, i5, 6, 0);
                    constraintProperties2.m(6, i2, 7, 0);
                } else if (!(i2 == -1 && i5 == -1)) {
                    int i6 = layoutParams2.f4633h;
                    if (i6 != -1) {
                        constraintProperties.m(7, i6, 7, 0);
                    } else {
                        int i7 = layoutParams2.f4630e;
                        if (i7 != -1) {
                            constraintProperties2.m(6, i7, 6, 0);
                        }
                    }
                }
            }
            C(6);
            C(7);
        } else {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i2));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i3));
            ConstraintLayout.LayoutParams layoutParams3 = this.f4694a;
            if (i2 != -1 && i3 != -1) {
                constraintProperties3.m(2, i3, 1, 0);
                constraintProperties4.m(1, i2, 2, 0);
            } else if (!(i2 == -1 && i3 == -1)) {
                int i8 = layoutParams3.f4633h;
                if (i8 != -1) {
                    constraintProperties3.m(2, i8, 2, 0);
                } else {
                    int i9 = layoutParams3.f4630e;
                    if (i9 != -1) {
                        constraintProperties4.m(1, i9, 1, 0);
                    }
                }
            }
            C(1);
            C(2);
        }
        return this;
    }

    public ConstraintProperties E() {
        ConstraintLayout.LayoutParams layoutParams = this.f4694a;
        int i2 = layoutParams.f4635j;
        int i3 = layoutParams.f4636k;
        if (!(i2 == -1 && i3 == -1)) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i2));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i3));
            ConstraintLayout.LayoutParams layoutParams2 = this.f4694a;
            if (i2 != -1 && i3 != -1) {
                constraintProperties.m(4, i3, 3, 0);
                constraintProperties2.m(3, i2, 4, 0);
            } else if (!(i2 == -1 && i3 == -1)) {
                int i4 = layoutParams2.f4637l;
                if (i4 != -1) {
                    constraintProperties.m(4, i4, 4, 0);
                } else {
                    int i5 = layoutParams2.f4634i;
                    if (i5 != -1) {
                        constraintProperties2.m(3, i5, 3, 0);
                    }
                }
            }
        }
        C(3);
        C(4);
        return this;
    }

    public ConstraintProperties F(float f2) {
        this.f4695b.setRotation(f2);
        return this;
    }

    public ConstraintProperties G(float f2) {
        this.f4695b.setRotationX(f2);
        return this;
    }

    public ConstraintProperties H(float f2) {
        this.f4695b.setRotationY(f2);
        return this;
    }

    public ConstraintProperties I(float f2) {
        this.f4695b.setScaleY(f2);
        return this;
    }

    public ConstraintProperties J(float f2) {
        return this;
    }

    public ConstraintProperties L(float f2, float f3) {
        this.f4695b.setPivotX(f2);
        this.f4695b.setPivotY(f3);
        return this;
    }

    public ConstraintProperties M(float f2) {
        this.f4695b.setPivotX(f2);
        return this;
    }

    public ConstraintProperties N(float f2) {
        this.f4695b.setPivotY(f2);
        return this;
    }

    public ConstraintProperties O(float f2, float f3) {
        this.f4695b.setTranslationX(f2);
        this.f4695b.setTranslationY(f3);
        return this;
    }

    public ConstraintProperties P(float f2) {
        this.f4695b.setTranslationX(f2);
        return this;
    }

    public ConstraintProperties Q(float f2) {
        this.f4695b.setTranslationY(f2);
        return this;
    }

    public ConstraintProperties R(float f2) {
        this.f4695b.setTranslationZ(f2);
        return this;
    }

    public ConstraintProperties S(float f2) {
        this.f4694a.H = f2;
        return this;
    }

    public ConstraintProperties T(int i2) {
        this.f4694a.O = i2;
        return this;
    }

    public ConstraintProperties U(float f2) {
        this.f4694a.M = f2;
        return this;
    }

    public ConstraintProperties V(int i2) {
        this.f4695b.setVisibility(i2);
        return this;
    }

    public ConstraintProperties a(int i2, int i3) {
        m(1, i2, i2 == 0 ? 1 : 2, 0);
        m(2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i2)).m(2, this.f4695b.getId(), 1, 0);
        }
        if (i3 != 0) {
            new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i3)).m(1, this.f4695b.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties b(int i2, int i3) {
        m(6, i2, i2 == 0 ? 6 : 7, 0);
        m(7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i2)).m(7, this.f4695b.getId(), 6, 0);
        }
        if (i3 != 0) {
            new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i3)).m(6, this.f4695b.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties c(int i2, int i3) {
        m(3, i2, i2 == 0 ? 3 : 4, 0);
        m(4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i2)).m(4, this.f4695b.getId(), 3, 0);
        }
        if (i3 != 0) {
            new ConstraintProperties(((ViewGroup) this.f4695b.getParent()).findViewById(i3)).m(3, this.f4695b.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties d(float f2) {
        this.f4695b.setAlpha(f2);
        return this;
    }

    public void e() {
    }

    public ConstraintProperties f(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        if (i4 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f2 <= 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else {
            int i8 = 2;
            int i9 = 1;
            if (!(i3 == 1 || i3 == 2)) {
                i8 = 7;
                i9 = 6;
                if (!(i3 == 6 || i3 == 7)) {
                    m(3, i2, i3, i4);
                    m(4, i5, i6, i7);
                    this.f4694a.H = f2;
                    return this;
                }
            }
            m(i9, i2, i3, i4);
            m(i8, i5, i6, i7);
            this.f4694a.G = f2;
            return this;
        }
    }

    public ConstraintProperties g(int i2) {
        int i3;
        int i4;
        int i5;
        ConstraintProperties constraintProperties;
        int i6;
        int i7;
        if (i2 == 0) {
            i6 = 0;
            i3 = 1;
            i4 = 0;
            i7 = 0;
            i5 = 2;
            constraintProperties = this;
        } else {
            i3 = 2;
            i4 = 0;
            i5 = 1;
            constraintProperties = this;
            i6 = i2;
            i7 = i2;
        }
        constraintProperties.f(i6, i3, i4, i7, i5, 0, 0.5f);
        return this;
    }

    public ConstraintProperties h(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        m(1, i2, i3, i4);
        m(2, i5, i6, i7);
        this.f4694a.G = f2;
        return this;
    }

    public ConstraintProperties i(int i2) {
        int i3;
        int i4;
        int i5;
        ConstraintProperties constraintProperties;
        int i6;
        int i7;
        if (i2 == 0) {
            i6 = 0;
            i3 = 6;
            i4 = 0;
            i7 = 0;
            i5 = 7;
            constraintProperties = this;
        } else {
            i3 = 7;
            i4 = 0;
            i5 = 6;
            constraintProperties = this;
            i6 = i2;
            i7 = i2;
        }
        constraintProperties.f(i6, i3, i4, i7, i5, 0, 0.5f);
        return this;
    }

    public ConstraintProperties j(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        m(6, i2, i3, i4);
        m(7, i5, i6, i7);
        this.f4694a.G = f2;
        return this;
    }

    public ConstraintProperties k(int i2) {
        int i3;
        int i4;
        int i5;
        ConstraintProperties constraintProperties;
        int i6;
        int i7;
        if (i2 == 0) {
            i6 = 0;
            i3 = 3;
            i4 = 0;
            i7 = 0;
            i5 = 4;
            constraintProperties = this;
        } else {
            i3 = 4;
            i4 = 0;
            i5 = 3;
            constraintProperties = this;
            i6 = i2;
            i7 = i2;
        }
        constraintProperties.f(i6, i3, i4, i7, i5, 0, 0.5f);
        return this;
    }

    public ConstraintProperties l(int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        m(3, i2, i3, i4);
        m(4, i5, i6, i7);
        this.f4694a.H = f2;
        return this;
    }

    public ConstraintProperties m(int i2, int i3, int i4, int i5) {
        ConstraintLayout.LayoutParams layoutParams;
        ConstraintLayout.LayoutParams layoutParams2;
        ConstraintLayout.LayoutParams layoutParams3;
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.f4694a;
                    layoutParams4.f4630e = i3;
                    layoutParams4.f4631f = -1;
                } else if (i4 == 2) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.f4694a;
                    layoutParams5.f4631f = i3;
                    layoutParams5.f4630e = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + K(i4) + " undefined");
                }
                this.f4694a.leftMargin = i5;
                break;
            case 2:
                if (i4 == 1) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.f4694a;
                    layoutParams6.f4632g = i3;
                    layoutParams6.f4633h = -1;
                } else if (i4 == 2) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.f4694a;
                    layoutParams7.f4633h = i3;
                    layoutParams7.f4632g = -1;
                } else {
                    throw new IllegalArgumentException("right to " + K(i4) + " undefined");
                }
                this.f4694a.rightMargin = i5;
                break;
            case 3:
                if (i4 == 3) {
                    layoutParams = this.f4694a;
                    layoutParams.f4634i = i3;
                    layoutParams.f4635j = -1;
                } else if (i4 == 4) {
                    layoutParams = this.f4694a;
                    layoutParams.f4635j = i3;
                    layoutParams.f4634i = -1;
                } else {
                    throw new IllegalArgumentException("right to " + K(i4) + " undefined");
                }
                layoutParams.f4638m = -1;
                layoutParams.f4639n = -1;
                layoutParams.o = -1;
                this.f4694a.topMargin = i5;
                break;
            case 4:
                if (i4 == 4) {
                    layoutParams2 = this.f4694a;
                    layoutParams2.f4637l = i3;
                    layoutParams2.f4636k = -1;
                } else if (i4 == 3) {
                    layoutParams2 = this.f4694a;
                    layoutParams2.f4636k = i3;
                    layoutParams2.f4637l = -1;
                } else {
                    throw new IllegalArgumentException("right to " + K(i4) + " undefined");
                }
                layoutParams2.f4638m = -1;
                layoutParams2.f4639n = -1;
                layoutParams2.o = -1;
                this.f4694a.bottomMargin = i5;
                break;
            case 5:
                if (i4 == 5) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.f4694a;
                    layoutParams8.f4638m = i3;
                    layoutParams8.f4637l = -1;
                    layoutParams8.f4636k = -1;
                    layoutParams8.f4634i = -1;
                    layoutParams8.f4635j = -1;
                }
                if (i4 == 3) {
                    layoutParams3 = this.f4694a;
                    layoutParams3.f4639n = i3;
                } else if (i4 == 4) {
                    layoutParams3 = this.f4694a;
                    layoutParams3.o = i3;
                } else {
                    throw new IllegalArgumentException("right to " + K(i4) + " undefined");
                }
                layoutParams3.f4637l = -1;
                layoutParams3.f4636k = -1;
                layoutParams3.f4634i = -1;
                layoutParams3.f4635j = -1;
                this.f4694a.D = i5;
                break;
            case 6:
                if (i4 == 6) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.f4694a;
                    layoutParams9.t = i3;
                    layoutParams9.s = -1;
                } else if (i4 == 7) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.f4694a;
                    layoutParams10.s = i3;
                    layoutParams10.t = -1;
                } else {
                    throw new IllegalArgumentException("right to " + K(i4) + " undefined");
                }
                this.f4694a.setMarginStart(i5);
                break;
            case 7:
                if (i4 == 7) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.f4694a;
                    layoutParams11.v = i3;
                    layoutParams11.u = -1;
                } else if (i4 == 6) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.f4694a;
                    layoutParams12.u = i3;
                    layoutParams12.v = -1;
                } else {
                    throw new IllegalArgumentException("right to " + K(i4) + " undefined");
                }
                this.f4694a.setMarginEnd(i5);
                break;
            default:
                throw new IllegalArgumentException(K(i2) + " to " + K(i4) + " unknown");
        }
        return this;
    }

    public ConstraintProperties n(int i2) {
        this.f4694a.Q = i2;
        return this;
    }

    public ConstraintProperties o(int i2) {
        this.f4694a.P = i2;
        return this;
    }

    public ConstraintProperties p(int i2) {
        this.f4694a.height = i2;
        return this;
    }

    public ConstraintProperties q(int i2) {
        this.f4694a.U = i2;
        return this;
    }

    public ConstraintProperties r(int i2) {
        this.f4694a.T = i2;
        return this;
    }

    public ConstraintProperties s(int i2) {
        this.f4694a.S = i2;
        return this;
    }

    public ConstraintProperties t(int i2) {
        this.f4694a.R = i2;
        return this;
    }

    public ConstraintProperties u(int i2) {
        this.f4694a.width = i2;
        return this;
    }

    public ConstraintProperties v(String str) {
        this.f4694a.I = str;
        return this;
    }

    public ConstraintProperties w(float f2) {
        this.f4695b.setElevation(f2);
        return this;
    }

    public ConstraintProperties x(int i2, int i3) {
        switch (i2) {
            case 1:
                this.f4694a.w = i3;
                break;
            case 2:
                this.f4694a.y = i3;
                break;
            case 3:
                this.f4694a.x = i3;
                break;
            case 4:
                this.f4694a.z = i3;
                break;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f4694a.A = i3;
                break;
            case 7:
                this.f4694a.B = i3;
                break;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
        return this;
    }

    public ConstraintProperties y(float f2) {
        this.f4694a.G = f2;
        return this;
    }

    public ConstraintProperties z(int i2) {
        this.f4694a.N = i2;
        return this;
    }
}
