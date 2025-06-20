package net.imedicaldoctor.imd.Fragments.UWorld;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import org.apache.commons.lang3.StringUtils;

public class UWTestsListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;

    public class TestScoreViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public TextView K;
        public TextView L;
        public ImageView M;
        public TextView N;
        public MaterialRippleLayout O;
        public Button P;
        public Button Q;

        public TestScoreViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1123text_date);
            this.J = (TextView) view.findViewById(R.id.f1125text_info1);
            this.K = (TextView) view.findViewById(R.id.f1126text_info2);
            this.O = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.L = (TextView) view.findViewById(R.id.f1129text_score);
            this.M = (ImageView) view.findViewById(R.id.f980image_view);
            this.N = (TextView) view.findViewById(R.id.f1128text_resume);
            this.P = (Button) view.findViewById(R.id.f855button_copy_qids);
            this.Q = (Button) view.findViewById(R.id.f857button_delete);
        }
    }

    /* access modifiers changed from: private */
    public void k3(String str, String str2) {
        ((ClipboardManager) r().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
        Toast.makeText(r(), "Copied to clipboard", 0).show();
    }

    /* access modifiers changed from: private */
    public void l3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        compressHelper.m(bundle, "DELETE FROM tests WHERE id = " + str);
        CompressHelper compressHelper2 = this.k4;
        Bundle bundle2 = this.h4;
        compressHelper2.m(bundle2, "DELETE FROM logs WHERE testId = " + str);
        ArrayList<Bundle> V = this.k4.V(this.h4, "Select * from tests order by id desc");
        this.n4 = V;
        ((ChaptersAdapter) this.l4).g0(V);
        this.l4.G();
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        J2();
        this.n4 = this.k4.V(this.h4, "Select * from tests order by id desc");
        AnonymousClass1 r2 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1388list_view_item_uworld_test_button) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                String str;
                MaterialRippleLayout materialRippleLayout;
                View.OnClickListener r0;
                TestScoreViewHolder testScoreViewHolder = (TestScoreViewHolder) viewHolder;
                String str2 = "Test #" + bundle.getString("id");
                String string = bundle.getString("createdDate");
                String string2 = bundle.getString("qIds");
                String[] split = string.split("\\|");
                if (split.length > 1) {
                    str = split[1];
                    String str3 = split[0];
                } else {
                    str = "";
                }
                String m3 = UWTestsListActivityFragment.this.m3(bundle.getString("createdDate"));
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(string2, ",");
                Objects.requireNonNull(splitByWholeSeparator);
                String str4 = splitByWholeSeparator.length + " Qs, " + bundle.getString("mode");
                if (!bundle.getString("mode").equals("Reading") && !str.isEmpty()) {
                    str4 = str4 + ", " + str.replace(":", "':") + "\"";
                }
                testScoreViewHolder.I.setText(str2);
                testScoreViewHolder.J.setText(str4 + "\nCreated: " + m3);
                testScoreViewHolder.K.setText(CompressHelper.O1(bundle.getString("subject") + " | " + bundle.getString("system"), 300));
                if (bundle.getString("done").equals(IcyHeaders.a3)) {
                    testScoreViewHolder.M.setImageDrawable(UWTestsListActivityFragment.this.b0().getDrawable(R.drawable.f620circle_green));
                    testScoreViewHolder.N.setText("Score");
                    testScoreViewHolder.L.setVisibility(0);
                    testScoreViewHolder.L.setText(bundle.getString("score") + CSS.Value.n0);
                    materialRippleLayout = testScoreViewHolder.O;
                    r0 = new View.OnClickListener() {
                        public void onClick(View view) {
                            UWTestsListActivityFragment uWTestsListActivityFragment = UWTestsListActivityFragment.this;
                            CompressHelper compressHelper = uWTestsListActivityFragment.k4;
                            Bundle bundle = uWTestsListActivityFragment.h4;
                            compressHelper.A1(bundle, "testresult-" + bundle.getString("id"), (String[]) null, (String) null);
                        }
                    };
                } else {
                    testScoreViewHolder.M.setImageDrawable(UWTestsListActivityFragment.this.b0().getDrawable(R.drawable.f619circle_blue));
                    testScoreViewHolder.N.setText("Resume");
                    testScoreViewHolder.L.setVisibility(8);
                    materialRippleLayout = testScoreViewHolder.O;
                    r0 = new View.OnClickListener() {
                        public void onClick(View view) {
                            UWTestsListActivityFragment uWTestsListActivityFragment = UWTestsListActivityFragment.this;
                            CompressHelper compressHelper = uWTestsListActivityFragment.k4;
                            Bundle bundle = uWTestsListActivityFragment.h4;
                            compressHelper.A1(bundle, "test-" + bundle.getString("id"), (String[]) null, (String) null);
                        }
                    };
                }
                materialRippleLayout.setOnClickListener(r0);
                testScoreViewHolder.P.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        UWTestsListActivityFragment.this.k3("QIDs", bundle.getString("qIds"));
                    }
                });
                testScoreViewHolder.Q.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        new AlertDialog.Builder(UWTestsListActivityFragment.this.r()).setTitle("Delete Test").l("Are you sure you want to delete this test?").setPositiveButton(17039379, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                AnonymousClass4 r2 = AnonymousClass4.this;
                                UWTestsListActivityFragment.this.l3(bundle.getString("id"));
                            }
                        }).setNegativeButton(17039369, (DialogInterface.OnClickListener) null).e(17301543).I();
                    }
                });
            }

            public RecyclerView.ViewHolder h0(View view) {
                return new TestScoreViewHolder(view);
            }
        };
        this.l4 = r2;
        r2.f30463h = "No Test Available";
        this.w4.setAdapter(r2);
        N2();
        o2(false);
        this.s4.setVisibility(8);
        this.r4.setTitle((CharSequence) "Previous Tests");
        return this.q4;
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public String h3() {
        return "";
    }

    public String m3(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ");
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(simpleDateFormat.parse(str));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return str;
        }
    }
}
