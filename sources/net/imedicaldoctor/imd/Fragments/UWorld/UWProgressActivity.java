package net.imedicaldoctor.imd.Fragments.UWorld;

import android.os.Bundle;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDActivity;

public class UWProgressActivity extends iMDActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new UWProgressFragment(), bundle);
    }
}
