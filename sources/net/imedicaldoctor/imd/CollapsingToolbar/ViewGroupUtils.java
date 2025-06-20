package net.imedicaldoctor.imd.CollapsingToolbar;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewGroupUtilsImpl f29528a = new ViewGroupUtilsImplHoneycomb();

    private interface ViewGroupUtilsImpl {
        void a(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class ViewGroupUtilsImplBase implements ViewGroupUtilsImpl {
        ViewGroupUtilsImplBase() {
        }

        public void a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    private static class ViewGroupUtilsImplHoneycomb implements ViewGroupUtilsImpl {
        ViewGroupUtilsImplHoneycomb() {
        }

        public void a(ViewGroup viewGroup, View view, Rect rect) {
            ViewGroupUtilsHoneycomb.b(viewGroup, view, rect);
        }
    }

    ViewGroupUtils() {
    }

    static void a(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        b(viewGroup, view, rect);
    }

    static void b(ViewGroup viewGroup, View view, Rect rect) {
        f29528a.a(viewGroup, view, rect);
    }
}
