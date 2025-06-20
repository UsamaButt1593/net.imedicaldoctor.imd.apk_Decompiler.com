package net.imedicaldoctor.imd.Fragments.TOL;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import net.imedicaldoctor.imd.R;

public class IGTActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1291igt_activity);
        if (bundle == null) {
            k0().u().C(R.id.container, IGTFragment.J2()).s();
        }
    }
}
