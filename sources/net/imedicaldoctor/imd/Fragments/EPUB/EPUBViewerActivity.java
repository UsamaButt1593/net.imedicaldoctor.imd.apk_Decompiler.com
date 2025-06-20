package net.imedicaldoctor.imd.Fragments.EPUB;

import android.os.Bundle;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.R;

public class EPUBViewerActivity extends ViewerHelperActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new EPUBViewerActivityFragment(), bundle);
    }
}
