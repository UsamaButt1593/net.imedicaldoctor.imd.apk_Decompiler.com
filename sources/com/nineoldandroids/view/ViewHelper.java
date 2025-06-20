package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper {

    private static final class Honeycomb {
        private Honeycomb() {
        }

        static void A(View view, float f2) {
            view.setX(f2);
        }

        static void B(View view, float f2) {
            view.setY(f2);
        }

        static float a(View view) {
            return view.getAlpha();
        }

        static float b(View view) {
            return view.getPivotX();
        }

        static float c(View view) {
            return view.getPivotY();
        }

        static float d(View view) {
            return view.getRotation();
        }

        static float e(View view) {
            return view.getRotationX();
        }

        static float f(View view) {
            return view.getRotationY();
        }

        static float g(View view) {
            return view.getScaleX();
        }

        static float h(View view) {
            return view.getScaleY();
        }

        static float i(View view) {
            return (float) view.getScrollX();
        }

        static float j(View view) {
            return (float) view.getScrollY();
        }

        static float k(View view) {
            return view.getTranslationX();
        }

        static float l(View view) {
            return view.getTranslationY();
        }

        static float m(View view) {
            return view.getX();
        }

        static float n(View view) {
            return view.getY();
        }

        static void o(View view, float f2) {
            view.setAlpha(f2);
        }

        static void p(View view, float f2) {
            view.setPivotX(f2);
        }

        static void q(View view, float f2) {
            view.setPivotY(f2);
        }

        static void r(View view, float f2) {
            view.setRotation(f2);
        }

        static void s(View view, float f2) {
            view.setRotationX(f2);
        }

        static void t(View view, float f2) {
            view.setRotationY(f2);
        }

        static void u(View view, float f2) {
            view.setScaleX(f2);
        }

        static void v(View view, float f2) {
            view.setScaleY(f2);
        }

        static void w(View view, int i2) {
            view.setScrollX(i2);
        }

        static void x(View view, int i2) {
            view.setScrollY(i2);
        }

        static void y(View view, float f2) {
            view.setTranslationX(f2);
        }

        static void z(View view, float f2) {
            view.setTranslationY(f2);
        }
    }

    private ViewHelper() {
    }

    public static void A(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).G(f2);
        } else {
            Honeycomb.A(view, f2);
        }
    }

    public static void B(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).J(f2);
        } else {
            Honeycomb.B(view, f2);
        }
    }

    public static float a(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).b() : Honeycomb.a(view);
    }

    public static float b(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).c() : Honeycomb.b(view);
    }

    public static float c(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).d() : Honeycomb.c(view);
    }

    public static float d(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).e() : Honeycomb.d(view);
    }

    public static float e(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).f() : Honeycomb.e(view);
    }

    public static float f(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).g() : Honeycomb.f(view);
    }

    public static float g(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).h() : Honeycomb.g(view);
    }

    public static float h(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).i() : Honeycomb.h(view);
    }

    public static float i(View view) {
        return AnimatorProxy.j3 ? (float) AnimatorProxy.L(view).l() : Honeycomb.i(view);
    }

    public static float j(View view) {
        return AnimatorProxy.j3 ? (float) AnimatorProxy.L(view).m() : Honeycomb.j(view);
    }

    public static float k(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).n() : Honeycomb.k(view);
    }

    public static float l(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).o() : Honeycomb.l(view);
    }

    public static float m(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).p() : Honeycomb.m(view);
    }

    public static float n(View view) {
        return AnimatorProxy.j3 ? AnimatorProxy.L(view).q() : Honeycomb.n(view);
    }

    public static void o(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).t(f2);
        } else {
            Honeycomb.o(view, f2);
        }
    }

    public static void p(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).u(f2);
        } else {
            Honeycomb.p(view, f2);
        }
    }

    public static void q(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).v(f2);
        } else {
            Honeycomb.q(view, f2);
        }
    }

    public static void r(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).w(f2);
        } else {
            Honeycomb.r(view, f2);
        }
    }

    public static void s(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).x(f2);
        } else {
            Honeycomb.s(view, f2);
        }
    }

    public static void t(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).y(f2);
        } else {
            Honeycomb.t(view, f2);
        }
    }

    public static void u(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).z(f2);
        } else {
            Honeycomb.u(view, f2);
        }
    }

    public static void v(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).A(f2);
        } else {
            Honeycomb.v(view, f2);
        }
    }

    public static void w(View view, int i2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).B(i2);
        } else {
            Honeycomb.w(view, i2);
        }
    }

    public static void x(View view, int i2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).D(i2);
        } else {
            Honeycomb.x(view, i2);
        }
    }

    public static void y(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).E(f2);
        } else {
            Honeycomb.y(view, f2);
        }
    }

    public static void z(View view, float f2) {
        if (AnimatorProxy.j3) {
            AnimatorProxy.L(view).F(f2);
        } else {
            Honeycomb.z(view, f2);
        }
    }
}
