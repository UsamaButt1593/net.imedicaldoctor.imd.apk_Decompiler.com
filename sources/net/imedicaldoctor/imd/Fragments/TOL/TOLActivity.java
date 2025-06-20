package net.imedicaldoctor.imd.Fragments.TOL;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import net.imedicaldoctor.imd.R;

public class TOLActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1403tol_activity);
        if (bundle == null) {
            k0().u().C(R.id.container, TolFragment.P2()).s();
        }
    }
}
