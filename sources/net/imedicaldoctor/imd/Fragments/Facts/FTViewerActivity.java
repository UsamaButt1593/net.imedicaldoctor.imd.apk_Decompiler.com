package net.imedicaldoctor.imd.Fragments.Facts;

import android.os.Bundle;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.R;

public class FTViewerActivity extends ViewerHelperActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new FTViewerActivityFragment(), bundle);
    }
}
