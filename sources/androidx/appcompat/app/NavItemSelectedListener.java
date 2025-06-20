package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener s;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.s = onNavigationListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ActionBar.OnNavigationListener onNavigationListener = this.s;
        if (onNavigationListener != null) {
            onNavigationListener.a(i2, j2);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
