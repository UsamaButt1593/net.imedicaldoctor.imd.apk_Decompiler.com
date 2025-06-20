package net.imedicaldoctor.imd.Fragments.DRE;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.HeaderCellViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

public class DRETestResultActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public Bundle Z4;
    public ArrayList<String> a5;
    public UWTestResultAdapter b5;
    public ArrayList<Bundle> c5;
    public Bundle d5;
    public int e5 = 0;
    public int f5 = 0;
    public int g5 = 0;
    public final int h5 = 0;
    public final int i5 = 1;
    public final int j5 = 2;
    public final int k5 = 3;
    public boolean l5;

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public TextView K;
        public TextView L;
        public ImageView M;
        public MaterialRippleLayout N;

        public QuestionViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1127text_number);
            this.J = (TextView) view.findViewById(R.id.f1131text_title);
            this.K = (TextView) view.findViewById(R.id.f1122text_correct);
            this.N = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.L = (TextView) view.findViewById(R.id.f1130text_time);
            this.M = (ImageView) view.findViewById(R.id.f980image_view);
        }
    }

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

    public class UWTestResultAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public String f29680d;

        public UWTestResultAdapter() {
        }

        public int C(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 1;
            }
            return i2 == DRETestResultActivityFragment.this.c5.size() + 2 ? 3 : 2;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            TextView textView;
            StringBuilder sb;
            TextView textView2;
            String str;
            ImageView imageView;
            Resources b0;
            int i3;
            String str2;
            int F = viewHolder.F();
            if (F == 3) {
                HeaderCellViewHolder headerCellViewHolder = (HeaderCellViewHolder) viewHolder;
                headerCellViewHolder.I.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                textView = headerCellViewHolder.I;
                sb = new StringBuilder();
                sb.append(DRETestResultActivityFragment.this.e5);
                sb.append(" درست . ");
                sb.append(DRETestResultActivityFragment.this.f5);
                sb.append(" نادرست . ");
                sb.append(DRETestResultActivityFragment.this.g5);
                sb.append(" نزده");
            } else if (F == 1) {
                HeaderCellViewHolder headerCellViewHolder2 = (HeaderCellViewHolder) viewHolder;
                headerCellViewHolder2.I.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                textView = headerCellViewHolder2.I;
                str2 = "سوالات";
                textView.setText(str2);
            } else if (F == 2) {
                final int i4 = i2 - 2;
                Bundle bundle = DRETestResultActivityFragment.this.c5.get(i4);
                QuestionViewHolder questionViewHolder = (QuestionViewHolder) viewHolder;
                questionViewHolder.I.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                questionViewHolder.J.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                questionViewHolder.L.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                questionViewHolder.K.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                questionViewHolder.I.setText(String.valueOf(i2 - 1));
                questionViewHolder.J.setText(bundle.getString("title"));
                if (DRETestResultActivityFragment.this.l5) {
                    textView2 = questionViewHolder.K;
                    str = "-";
                } else {
                    textView2 = questionViewHolder.K;
                    str = bundle.getString("CorrPerc") + CSS.Value.n0;
                }
                textView2.setText(str);
                questionViewHolder.L.setText(bundle.getString(HTML.Tag.P0) + " ثانیه");
                String string = bundle.getString("selectedAnswer");
                String string2 = bundle.getString("corrAnswer");
                if (string.length() == 0) {
                    imageView = questionViewHolder.M;
                    b0 = DRETestResultActivityFragment.this.b0();
                    i3 = R.drawable.f710omitted_icon;
                } else if (string.equals(string2)) {
                    imageView = questionViewHolder.M;
                    b0 = DRETestResultActivityFragment.this.b0();
                    i3 = R.drawable.f626correct_icon;
                } else {
                    imageView = questionViewHolder.M;
                    b0 = DRETestResultActivityFragment.this.b0();
                    i3 = R.drawable.f662incorrect_icon;
                }
                imageView.setImageDrawable(b0.getDrawable(i3));
                questionViewHolder.N.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("gotoQIndex", i4);
                        DRETestResultActivityFragment dRETestResultActivityFragment = DRETestResultActivityFragment.this;
                        CompressHelper compressHelper = dRETestResultActivityFragment.Q4;
                        Bundle bundle2 = dRETestResultActivityFragment.D4;
                        compressHelper.B1(bundle2, "test-" + DRETestResultActivityFragment.this.d5.getString("id"), (String[]) null, (String) null, bundle);
                    }
                });
                return;
            } else if (F == 0) {
                TestScoreViewHolder testScoreViewHolder = (TestScoreViewHolder) viewHolder;
                testScoreViewHolder.I.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.J.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.K.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.N.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                testScoreViewHolder.L.setTypeface(ResourcesCompat.j(DRETestResultActivityFragment.this.r(), R.font.f782iransans));
                TextView textView3 = testScoreViewHolder.I;
                DRETestResultActivityFragment dRETestResultActivityFragment = DRETestResultActivityFragment.this;
                textView3.setText(dRETestResultActivityFragment.J4(dRETestResultActivityFragment.d5.getString("createdDate")));
                String str3 = DRETestResultActivityFragment.this.d5.getString("mode").equals("Testing") ? "امتحان" : "مطالعه";
                testScoreViewHolder.J.setText(DRETestResultActivityFragment.this.c5.size() + " سوال . حالت مطالعه: " + str3);
                DRETestResultActivityFragment dRETestResultActivityFragment2 = DRETestResultActivityFragment.this;
                if (dRETestResultActivityFragment2.l5) {
                    testScoreViewHolder.K.setText(dRETestResultActivityFragment2.d5.getString("subject"));
                } else {
                    testScoreViewHolder.K.setText(DRETestResultActivityFragment.this.d5.getString("subject") + " , " + DRETestResultActivityFragment.this.d5.getString("system"));
                }
                testScoreViewHolder.M.setImageDrawable(DRETestResultActivityFragment.this.b0().getDrawable(R.drawable.f620circle_green));
                testScoreViewHolder.N.setText("نمره");
                testScoreViewHolder.L.setVisibility(0);
                textView = testScoreViewHolder.L;
                sb = new StringBuilder();
                sb.append(DRETestResultActivityFragment.this.d5.getString("score"));
                sb.append(CSS.Value.n0);
            } else {
                return;
            }
            str2 = sb.toString();
            textView.setText(str2);
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 3) {
                return new HeaderCellViewHolder(LayoutInflater.from(DRETestResultActivityFragment.this.r()).inflate(R.layout.f1321list_view_item_footer, viewGroup, false));
            }
            if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(DRETestResultActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 2) {
                return new QuestionViewHolder(LayoutInflater.from(DRETestResultActivityFragment.this.r()).inflate(R.layout.f1316list_view_item_dre_quetion, viewGroup, false));
            } else if (i2 != 0) {
                return null;
            } else {
                return new TestScoreViewHolder(LayoutInflater.from(DRETestResultActivityFragment.this.r()).inflate(R.layout.f1317list_view_item_dre_test, viewGroup, false));
            }
        }

        public int b() {
            return DRETestResultActivityFragment.this.c5.size() + 3;
        }

        public String d0(String str) {
            return str;
        }

        public void e0(RecyclerView.ViewHolder viewHolder, Bundle bundle, int i2) {
        }

        public void f0(Bundle bundle, int i2) {
        }

        public RecyclerView.ViewHolder g0(View view) {
            return new RippleTextViewHolder(view);
        }
    }

    public void I4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.p(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public String J4(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ");
        new SimpleDateFormat("MM dd,yyyy HH:mm:ss");
        try {
            return new PersianDateFormat().b(new PersianDate(Long.valueOf(simpleDateFormat.parse(str).getTime())));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return str;
        }
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CompressHelper compressHelper;
        Bundle bundle2;
        StringBuilder sb;
        String str;
        View view = this.C4;
        if (view != null) {
            return view;
        }
        View inflate = layoutInflater.inflate(R.layout.f1248fragment_new_list_viewer, viewGroup, false);
        this.C4 = inflate;
        r4(inflate, bundle);
        this.X4 = (RecyclerView) this.C4.findViewById(R.id.f1054recycler_view);
        if (y() == null) {
            return this.C4;
        }
        String str2 = this.E4.split("-")[1];
        this.l5 = this.Q4.V(this.D4, "Select CorrPerc from Questions limit 1") == null;
        CompressHelper compressHelper2 = this.Q4;
        this.d5 = compressHelper2.s1(compressHelper2.V(this.D4, "select * from tests where id=" + str2));
        if (this.l5) {
            compressHelper = this.Q4;
            bundle2 = this.D4;
            sb = new StringBuilder();
            str = "Select questions.id,'سوال شماره '|| questions.id as title,selectedAnswer,corrAnswer,time  from Questions left outer join (select * from logs where testId=";
        } else {
            compressHelper = this.Q4;
            bundle2 = this.D4;
            sb = new StringBuilder();
            str = "Select questions.id,CorrPerc,'سوال شماره '|| questions.id as title,selectedAnswer,corrAnswer,time  from Questions left outer join (select * from logs where testId=";
        }
        sb.append(str);
        sb.append(str2);
        sb.append(") as logs2 on questions.id=logs2.qid where questions.id in (");
        sb.append(this.d5.getString("qIds"));
        sb.append(")");
        this.c5 = compressHelper.V(bundle2, sb.toString());
        this.F4 = "نتیجه آزمون";
        Iterator<Bundle> it2 = this.c5.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (next.getString("selectedAnswer").length() == 0) {
                this.g5++;
            } else if (next.getString("selectedAnswer").equals(next.getString("corrAnswer"))) {
                this.e5++;
            } else {
                this.f5++;
            }
        }
        UWTestResultAdapter uWTestResultAdapter = new UWTestResultAdapter();
        this.b5 = uWTestResultAdapter;
        this.X4.setAdapter(uWTestResultAdapter);
        I4();
        f3(R.menu.f1412empty);
        o2(false);
        G3();
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void o4() {
        Bundle v3;
        ArrayList<Bundle> arrayList = this.Y4;
        if (arrayList != null && arrayList.size() != 0 && (v3 = v3(this.Y4)) != null) {
            Glide.G(r()).t("http://www.epocrates.com/pillimages/" + (v3.getString("FILENAME") + ".jpg")).B2(this.M4);
        }
    }
}
