package net.imedicaldoctor.imd.Utils;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.NestedScrollWebView;
import net.imedicaldoctor.imd.iMDLogger;

public class iMDWebView extends NestedScrollWebView {
    public int c3;
    public int d3;
    public ScaleGestureDetector e3;
    public GestureDetector f3;
    public ActionModeResponse g3;
    final int h3 = 15;
    public Context i3;
    public String j3;
    private ActionMode k3;
    private ActionMode.Callback l3;
    private ActionMode.Callback m3;

    public iMDWebView(Context context) {
        super(context);
    }

    public void g(String str) {
        evaluateJavascript(str, (ValueCallback) null);
    }

    public void i() {
        int i2;
        Context context;
        String str;
        iMDLogger.d("UTDWebView", "Zoom in : " + (getSettings().getTextZoom() + 15));
        if (getSettings().getTextZoom() >= 300) {
            context = this.i3;
            str = "Can't Zoom In Anymore";
            i2 = 1;
        } else {
            m();
            getSettings().setTextZoom(getSettings().getTextZoom() + 15);
            l();
            i2 = 0;
            this.i3.getSharedPreferences("default_preferences", 0).edit().putInt(this.j3 + "zoom", getSettings().getTextZoom()).commit();
            context = this.i3;
            str = getSettings().getTextZoom() + CSS.Value.n0;
        }
        CompressHelper.x2(context, str, i2);
    }

    public void invokeZoomPicker() {
        iMDLogger.d("UTDWebView", "Invoke zoom picker");
        super.invokeZoomPicker();
    }

    public void j() {
        int i2;
        Context context;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Zoom Out : ");
        sb.append(getSettings().getTextZoom() - 15);
        iMDLogger.d("UTDWebView", sb.toString());
        if (getSettings().getTextZoom() <= 25) {
            context = this.i3;
            str = "Can't Zoom Out Anymore";
            i2 = 1;
        } else {
            m();
            getSettings().setTextZoom(getSettings().getTextZoom() - 15);
            l();
            i2 = 0;
            this.i3.getSharedPreferences("default_preferences", 0).edit().putInt(this.j3 + "zoom", getSettings().getTextZoom()).commit();
            context = this.i3;
            str = getSettings().getTextZoom() + CSS.Value.n0;
        }
        CompressHelper.x2(context, str, i2);
    }

    public void k() {
        ActionMode actionMode = this.k3;
        if (actionMode != null) {
            actionMode.finish();
        }
    }

    public void l() {
        g("document.getElementById('orientation').scrollIntoView(true);");
        g("element=document.getElementById('orientation');element.parentNode.removeChild(element);");
    }

    public void m() {
        g("e = document.createElement('span'); e.setAttribute('id','orientation');document.caretRangeFromPoint(0, 0).insertNode(e);");
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i4, int i5, int i6) {
        super.onScrollChanged(i2, i4, i5, i6);
        this.c3 = i2;
        this.d3 = i4;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.f3.onTouchEvent(motionEvent);
            this.e3.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return true;
        }
    }

    public WebBackForwardList saveState(Bundle bundle) {
        iMDLogger.d("UTDWebView", "SaveState");
        return super.saveState(bundle);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        AnonymousClass3 r2 = new ActionMode() {
            public void finish() {
                ActionModeResponse actionModeResponse = iMDWebView.this.g3;
                if (actionModeResponse != null) {
                    actionModeResponse.a();
                    iMDWebView.this.clearFocus();
                }
            }

            public View getCustomView() {
                return null;
            }

            public Menu getMenu() {
                return null;
            }

            public MenuInflater getMenuInflater() {
                return null;
            }

            public CharSequence getSubtitle() {
                return null;
            }

            public CharSequence getTitle() {
                return null;
            }

            public void invalidate() {
            }

            public void setCustomView(View view) {
            }

            public void setSubtitle(int i2) {
            }

            public void setTitle(int i2) {
            }

            public void setSubtitle(CharSequence charSequence) {
            }

            public void setTitle(CharSequence charSequence) {
            }
        };
        ActionModeResponse actionModeResponse = this.g3;
        if (actionModeResponse != null) {
            actionModeResponse.b();
        }
        this.k3 = r2;
        return r2;
    }

    public boolean zoomIn() {
        iMDLogger.d("UTDWebView", "ZoomIn");
        return super.zoomIn();
    }

    public iMDWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i3 = context;
        this.f3 = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }
        });
        this.e3 = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                iMDLogger.f("iMDScale", scaleGestureDetector.getScaleFactor() + "");
                if (((double) scaleGestureDetector.getScaleFactor()) > 1.2d) {
                    iMDWebView.this.i();
                } else if (((double) scaleGestureDetector.getScaleFactor()) < 0.8d) {
                    iMDWebView.this.j();
                }
            }
        });
    }

    public iMDWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
