package net.imedicaldoctor.imd.Fragments.Micromedex;

import android.os.Bundle;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.R;

public class MMViewerActivity extends ViewerHelperActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new MMViewerActivityFragment(), bundle);
    }
}
