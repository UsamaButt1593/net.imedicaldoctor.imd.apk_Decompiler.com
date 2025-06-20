package net.imedicaldoctor.imd.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.iMDWebView;
import net.imedicaldoctor.imd.iMDActivity;

public class ViewerHelperActivity extends iMDActivity {
    private ActionMode y3 = null;

    private void b1() {
        try {
            getCurrentFocus().clearFocus();
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public int Z0() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void onActionModeFinished(ActionMode actionMode) {
        if (actionMode == null) {
            actionMode = this.y3;
        }
        if (Build.VERSION.SDK_INT <= 22) {
            if (!new File(new CompressHelper(this).M1() + "/action.txt").exists()) {
                return;
            }
        }
        actionMode.getMenu().clear();
        iMDWebView imdwebview = (iMDWebView) findViewById(R.id.f1159webView);
        if (imdwebview != null) {
            imdwebview.g("console.log('finisham,,,,,');");
        }
        super.onActionModeFinished(actionMode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        if (new java.io.File(new net.imedicaldoctor.imd.Data.CompressHelper(r6).M1() + "/action.txt").exists() != false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActionModeStarted(android.view.ActionMode r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ACtionMode"
            java.lang.String r1 = "onActionModeStarted"
            net.imedicaldoctor.imd.iMDLogger.j(r0, r1)
            r0 = 2131362737(0x7f0a03b1, float:1.8345263E38)
            android.view.View r1 = r6.findViewById(r0)
            android.webkit.WebView r1 = (android.webkit.WebView) r1
            if (r1 != 0) goto L_0x0013
            return
        L_0x0013:
            r6.y3 = r7
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 22
            if (r2 > r3) goto L_0x0040
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            net.imedicaldoctor.imd.Data.CompressHelper r5 = new net.imedicaldoctor.imd.Data.CompressHelper
            r5.<init>(r6)
            java.lang.String r5 = r5.M1()
            r4.append(r5)
            java.lang.String r5 = "/action.txt"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            boolean r3 = r3.exists()
            if (r3 == 0) goto L_0x008b
        L_0x0040:
            boolean r1 = r1.isFocused()
            if (r1 != 0) goto L_0x0047
            return
        L_0x0047:
            android.view.Menu r1 = r7.getMenu()
            r1.clear()
            r1 = 30
            if (r2 <= r1) goto L_0x005a
            r1 = 100
            r7.hide(r1)
            r7.finish()
        L_0x005a:
            android.view.View r0 = r6.findViewById(r0)
            net.imedicaldoctor.imd.Utils.iMDWebView r0 = (net.imedicaldoctor.imd.Utils.iMDWebView) r0
            if (r0 == 0) goto L_0x008b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getRect("
            r1.append(r2)
            int r2 = r0.getWidth()
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            int r2 = r0.getHeight()
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.g(r1)
        L_0x008b:
            super.onActionModeStarted(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.ViewerHelperActivity.onActionModeStarted(android.view.ActionMode):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getSharedPreferences("default_preferences", 0).getBoolean("wakelock", true)) {
            getWindow().addFlags(128);
        }
    }
}
