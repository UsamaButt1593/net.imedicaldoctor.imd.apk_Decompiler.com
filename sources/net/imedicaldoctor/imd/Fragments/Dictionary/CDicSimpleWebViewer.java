package net.imedicaldoctor.imd.Fragments.Dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import org.apache.commons.lang3.StringUtils;

public class CDicSimpleWebViewer extends ViewerHelperActivity {

    public static class CDicSimpleWebViewerFragment extends ViewerHelperFragment {
        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View view = this.C4;
            if (view != null) {
                return view;
            }
            View inflate = layoutInflater.inflate(R.layout.f1234fragment_general_viewer, viewGroup, false);
            r4(inflate, bundle);
            if (y() == null) {
                return inflate;
            }
            this.G4.loadUrl(this.E4.split("-")[1]);
            s4();
            o2(false);
            r().setTitle("");
            return inflate;
        }

        public boolean y4(WebView webView, String str, String str2, String str3) {
            if (!str2.equals("ldoce")) {
                return false;
            }
            CompressHelper compressHelper = new CompressHelper(r());
            String substring = StringUtils.splitByWholeSeparator(str3, "?")[0].substring(2);
            Bundle bundle = this.D4;
            Bundle z = compressHelper.z(compressHelper.W(bundle, "select * from LongMean where word='" + substring + "'", "LongMean.db"));
            if (z == null) {
                return true;
            }
            Bundle bundle2 = this.D4;
            compressHelper.A1(bundle2, "EE-5,,,,," + z.getString("id") + ",,,,," + z.getString("word"), (String[]) null, (String) null);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new CDicSimpleWebViewerFragment());
    }
}
