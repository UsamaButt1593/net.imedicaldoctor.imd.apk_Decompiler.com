package net.imedicaldoctor.imd.Fragments.DRE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import java.text.SimpleDateFormat;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.ChaptersAdapter;
import net.imedicaldoctor.imd.ViewHolders.SpellSearchAdapter;
import org.apache.commons.lang3.StringUtils;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

public class DRETestsListActivityFragment extends SearchHelperFragment {
    public SpellSearchAdapter A4;
    public String B4;
    public boolean C4;

    public class TestScoreViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public TextView K;
        public TextView L;
        public ImageView M;
        public TextView N;
        public MaterialRippleLayout O;

        public TestScoreViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1123text_date);
            this.J = (TextView) view.findViewById(R.id.f1125text_info1);
            this.K = (TextView) view.findViewById(R.id.f1126text_info2);
            this.O = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.L = (TextView) view.findViewById(R.id.f1129text_score);
            this.M = (ImageView) view.findViewById(R.id.f980image_view);
            this.N = (TextView) view.findViewById(R.id.f1128text_resume);
        }
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        appBarLayout.D(false, false);
        appBarLayout.postDelayed(new Runnable() {
            public void run() {
                relativeLayout.setVisibility(0);
            }
        }, 800);
        this.C4 = this.k4.V(this.h4, "Select CorrPerc from Questions limit 1") == null;
        this.n4 = this.k4.V(this.h4, "Select * from tests order by id desc");
        AnonymousClass2 r2 = new ChaptersAdapter(r(), this.n4, "title", R.layout.f1317list_view_item_dre_test) {
            public void e0(RecyclerView.ViewHolder viewHolder, final Bundle bundle, int i2) {
                TextView textView;
                String str;
                MaterialRippleLayout materialRippleLayout;
                View.OnClickListener r6;
                TestScoreViewHolder testScoreViewHolder = (TestScoreViewHolder) viewHolder;
                testScoreViewHolder.I.setTypeface(ResourcesCompat.j(DRETestsListActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.J.setTypeface(ResourcesCompat.j(DRETestsListActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.K.setTypeface(ResourcesCompat.j(DRETestsListActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.N.setTypeface(ResourcesCompat.j(DRETestsListActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.L.setTypeface(ResourcesCompat.j(DRETestsListActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.I.setText(DRETestsListActivityFragment.this.i3(bundle.getString("createdDate")));
                int length = StringUtils.splitByWholeSeparator(bundle.getString("qIds"), ",").length;
                String str2 = bundle.getString("mode").equals("Testing") ? "امتحان" : "مطالعه";
                testScoreViewHolder.J.setText(length + " سوال. حالت مطالعه: " + str2);
                if (DRETestsListActivityFragment.this.C4) {
                    textView = testScoreViewHolder.K;
                    str = bundle.getString("subject");
                } else {
                    textView = testScoreViewHolder.K;
                    str = bundle.getString("subject") + " , " + bundle.getString("system");
                }
                textView.setText(str);
                if (bundle.getString("done").equals(IcyHeaders.a3)) {
                    testScoreViewHolder.M.setImageDrawable(DRETestsListActivityFragment.this.b0().getDrawable(R.drawable.f620circle_green));
                    testScoreViewHolder.N.setText("نمره");
                    testScoreViewHolder.L.setVisibility(0);
                    testScoreViewHolder.L.setText(bundle.getString("score") + CSS.Value.n0);
                    materialRippleLayout = testScoreViewHolder.O;
                    r6 = new View.OnClickListener() {
                        public void onClick(View view) {
                            DRETestsListActivityFragment dRETestsListActivityFragment = DRETestsListActivityFragment.this;
                            CompressHelper compressHelper = dRETestsListActivityFragment.k4;
                            Bundle bundle = dRETestsListActivityFragment.h4;
                            compressHelper.A1(bundle, "testresult-" + bundle.getString("id"), (String[]) null, (String) null);
                        }
                    };
                } else {
                    testScoreViewHolder.M.setImageDrawable(DRETestsListActivityFragment.this.b0().getDrawable(R.drawable.f619circle_blue));
                    testScoreViewHolder.N.setText("ادامه");
                    testScoreViewHolder.L.setVisibility(8);
                    materialRippleLayout = testScoreViewHolder.O;
                    r6 = new View.OnClickListener() {
                        public void onClick(View view) {
                            DRETestsListActivityFragment dRETestsListActivityFragment = DRETestsListActivityFragment.this;
                            CompressHelper compressHelper = dRETestsListActivityFragment.k4;
                            Bundle bundle = dRETestsListActivityFragment.h4;
                            compressHelper.A1(bundle, "test-" + bundle.getString("id"), (String[]) null, (String) null);
                        }
                    };
                }
                materialRippleLayout.setOnClickListener(r6);
            }

            public RecyclerView.ViewHolder h0(View view) {
                return new TestScoreViewHolder(view);
            }
        };
        this.l4 = r2;
        r2.f30463h = "آزمونی وجود ندارد";
        this.w4.setAdapter(r2);
        N2();
        o2(false);
        this.s4.setVisibility(8);
        this.r4.setTitle((CharSequence) "آزمون های پیشین");
        return this.q4;
    }

    public void X2() {
        this.A4.i0(this.o4, this.p4);
        this.w4.setAdapter(this.A4);
    }

    public String h3() {
        return "";
    }

    public String i3(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ");
        new SimpleDateFormat("MM dd,yyyy HH:mm:ss");
        try {
            return new PersianDateFormat().b(new PersianDate(Long.valueOf(simpleDateFormat.parse(str).getTime())));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return str;
        }
    }
}
