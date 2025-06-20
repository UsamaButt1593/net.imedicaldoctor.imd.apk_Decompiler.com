package net.imedicaldoctor.imd.Fragments.UWorld;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.CustomItemDecoration;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.HeaderCellViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import org.apache.commons.lang3.StringUtils;

public class UWTestResultActivityFragment extends ViewerHelperFragment {
    public RecyclerView X4;
    public ArrayList<Bundle> Y4;
    public UWTestResultAdapter Z4;
    public ArrayList<Bundle> a5;
    public ArrayList<Bundle> b5;
    public ArrayList<Bundle> c5;
    public Bundle d5;
    public int e5 = 0;
    public int f5 = 0;
    public int g5 = 0;
    public double h5 = 0.0d;
    public int i5 = 0;
    public double j5;
    public int k5;
    public int l5;
    public final int m5 = 0;
    public final int n5 = 4;
    public final int o5 = 1;
    public final int p5 = 10;
    public final int q5 = 100;
    public final int r5 = 2;
    public final int s5 = 3;
    public final int t5 = 40;
    public final int u5 = 5;
    public boolean v5;
    public ArrayList<String> w5;
    public ArrayList<String> x5;
    public ArrayList<String> y5;

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public ProgressBar K;
        public MaterialRippleLayout L;

        public CategoryViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (TextView) view.findViewById(R.id.f1096subtitle);
            this.K = (ProgressBar) view.findViewById(R.id.f1043progress_bar);
            this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public TextView K;
        public TextView L;
        public ImageView M;
        public TextView N;
        public MaterialRippleLayout O;
        public TextView P;

        public QuestionViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1127text_number);
            this.J = (TextView) view.findViewById(R.id.f1131text_title);
            this.K = (TextView) view.findViewById(R.id.f1122text_correct);
            this.O = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.L = (TextView) view.findViewById(R.id.f1130text_time);
            this.M = (ImageView) view.findViewById(R.id.f980image_view);
            this.N = (TextView) view.findViewById(R.id.f890correct_label);
            this.P = (TextView) view.findViewById(R.id.f1133time_label);
        }
    }

    public class ResultScoreViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public RelativeLayout J;
        public TextView K;
        public RelativeLayout L;
        public TextView M;
        public RelativeLayout N;
        public MaterialRippleLayout O;
        public Button P;
        public Button Q;
        public Button R;

        public ResultScoreViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1065score1);
            this.K = (TextView) view.findViewById(R.id.f1066score2);
            this.M = (TextView) view.findViewById(R.id.f1067score3);
            this.P = (Button) view.findViewById(R.id.f854button_all);
            this.Q = (Button) view.findViewById(R.id.f858button_incorrect);
            this.R = (Button) view.findViewById(R.id.f856button_correct);
            this.J = (RelativeLayout) view.findViewById(R.id.f874circle1);
            this.L = (RelativeLayout) view.findViewById(R.id.f875circle2);
            this.N = (RelativeLayout) view.findViewById(R.id.f876circle3);
            this.O = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class ResultTestScoreViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public TextView K;
        public MaterialRippleLayout L;

        public ResultTestScoreViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f1123text_date);
            this.J = (TextView) view.findViewById(R.id.f1125text_info1);
            this.K = (TextView) view.findViewById(R.id.f1126text_info2);
            this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class UWTestResultAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public String f29973d;

        public UWTestResultAdapter() {
        }

        public int C(int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 4;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 >= 3 && i2 <= UWTestResultActivityFragment.this.a5.size() + 2) {
                return 2;
            }
            if (i2 == UWTestResultActivityFragment.this.a5.size() + 3) {
                return 3;
            }
            if (i2 == UWTestResultActivityFragment.this.a5.size() + 4) {
                return 10;
            }
            if (i2 >= UWTestResultActivityFragment.this.a5.size() + 5 && i2 <= UWTestResultActivityFragment.this.a5.size() + 4 + UWTestResultActivityFragment.this.b5.size()) {
                return 40;
            }
            if (i2 == UWTestResultActivityFragment.this.a5.size() + 5 + UWTestResultActivityFragment.this.b5.size()) {
                return 100;
            }
            return (i2 < (UWTestResultActivityFragment.this.a5.size() + 6) + UWTestResultActivityFragment.this.b5.size() || i2 > ((UWTestResultActivityFragment.this.a5.size() + 5) + UWTestResultActivityFragment.this.b5.size()) + UWTestResultActivityFragment.this.c5.size()) ? 0 : 5;
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            Object obj;
            TextView textView;
            String str;
            String str2;
            StringBuilder sb;
            String string;
            ImageView imageView;
            Resources b0;
            int i3;
            int F = viewHolder.F();
            if (F == 3) {
                textView = ((HeaderCellViewHolder) viewHolder).I;
                sb = new StringBuilder();
                sb.append(UWTestResultActivityFragment.this.e5);
                sb.append(" Correct . ");
                sb.append(UWTestResultActivityFragment.this.f5);
                sb.append(" Incorrect . ");
                sb.append(UWTestResultActivityFragment.this.g5);
                string = " Omitted";
            } else if (F == 1) {
                textView = ((HeaderCellViewHolder) viewHolder).I;
                sb = new StringBuilder();
                sb.append(UWTestResultActivityFragment.this.a5.size());
                string = " Questions";
            } else if (F == 10) {
                textView = ((HeaderCellViewHolder) viewHolder).I;
                sb = new StringBuilder();
                sb.append(UWTestResultActivityFragment.this.b5.size());
                string = " Subjects";
            } else if (F == 100) {
                textView = ((HeaderCellViewHolder) viewHolder).I;
                sb = new StringBuilder();
                sb.append(UWTestResultActivityFragment.this.c5.size());
                string = " Systems";
            } else if (F == 2) {
                final int i4 = i2 - 3;
                Bundle bundle = UWTestResultActivityFragment.this.a5.get(i4);
                QuestionViewHolder questionViewHolder = (QuestionViewHolder) viewHolder;
                questionViewHolder.I.setText(String.valueOf(i2 - 2));
                questionViewHolder.J.setText(bundle.getString("title") + " (" + bundle.getString("id") + ")");
                if (!UWTestResultActivityFragment.this.v5) {
                    questionViewHolder.K.setVisibility(8);
                    questionViewHolder.N.setVisibility(8);
                } else {
                    questionViewHolder.K.setText(((int) ((Float.valueOf(bundle.getString("corrTaken")).floatValue() / Float.valueOf(bundle.getString("pplTaken")).floatValue()) * 100.0f)) + CSS.Value.n0);
                }
                if (bundle.getString(HTML.Tag.P0).isEmpty()) {
                    questionViewHolder.L.setVisibility(8);
                    questionViewHolder.P.setVisibility(8);
                } else {
                    questionViewHolder.L.setVisibility(0);
                    questionViewHolder.P.setVisibility(0);
                    questionViewHolder.L.setText(bundle.getString(HTML.Tag.P0) + " sec");
                }
                String string2 = bundle.getString("selectedAnswer");
                String string3 = bundle.getString("corrAnswer");
                if (string2.length() == 0) {
                    imageView = questionViewHolder.M;
                    b0 = UWTestResultActivityFragment.this.b0();
                    i3 = R.drawable.f710omitted_icon;
                } else if (string2.equals(string3)) {
                    imageView = questionViewHolder.M;
                    b0 = UWTestResultActivityFragment.this.b0();
                    i3 = R.drawable.f626correct_icon;
                } else {
                    imageView = questionViewHolder.M;
                    b0 = UWTestResultActivityFragment.this.b0();
                    i3 = R.drawable.f662incorrect_icon;
                }
                imageView.setImageDrawable(b0.getDrawable(i3));
                questionViewHolder.O.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("gotoQIndex", i4);
                        UWTestResultActivityFragment uWTestResultActivityFragment = UWTestResultActivityFragment.this;
                        CompressHelper compressHelper = uWTestResultActivityFragment.Q4;
                        Bundle bundle2 = uWTestResultActivityFragment.D4;
                        compressHelper.B1(bundle2, "test-" + UWTestResultActivityFragment.this.d5.getString("id"), (String[]) null, (String) null, bundle);
                    }
                });
                return;
            } else if (F == 0) {
                ResultTestScoreViewHolder resultTestScoreViewHolder = (ResultTestScoreViewHolder) viewHolder;
                String str3 = "Test #" + UWTestResultActivityFragment.this.d5.getString("id");
                String string4 = UWTestResultActivityFragment.this.d5.getString("createdDate");
                String string5 = UWTestResultActivityFragment.this.d5.getString("qIds");
                String[] split = string4.split("\\|");
                if (split.length > 1) {
                    str2 = split[1];
                    String str4 = split[0];
                } else {
                    str2 = "";
                }
                UWTestResultActivityFragment uWTestResultActivityFragment = UWTestResultActivityFragment.this;
                String N4 = uWTestResultActivityFragment.N4(uWTestResultActivityFragment.d5.getString("createdDate"));
                String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(string5, ",");
                Objects.requireNonNull(splitByWholeSeparator);
                String str5 = splitByWholeSeparator.length + " Qs, " + UWTestResultActivityFragment.this.d5.getString("mode");
                if (!UWTestResultActivityFragment.this.d5.getString("mode").equals("Reading") && !str2.isEmpty()) {
                    str5 = str5 + ", " + str2.replace(":", "':") + "\"";
                }
                resultTestScoreViewHolder.I.setText(str3);
                resultTestScoreViewHolder.J.setText(str5 + "\nCreated: " + N4);
                textView = resultTestScoreViewHolder.K;
                sb = new StringBuilder();
                sb.append(UWTestResultActivityFragment.this.d5.getString("subject"));
                sb.append(" | ");
                string = UWTestResultActivityFragment.this.d5.getString("system");
            } else if (F == 4) {
                ResultScoreViewHolder resultScoreViewHolder = (ResultScoreViewHolder) viewHolder;
                resultScoreViewHolder.I.setText(UWTestResultActivityFragment.this.d5.getString("score") + CSS.Value.n0);
                if (UWTestResultActivityFragment.this.v5) {
                    resultScoreViewHolder.L.setVisibility(0);
                    resultScoreViewHolder.N.setVisibility(0);
                    resultScoreViewHolder.K.setText(String.valueOf(UWTestResultActivityFragment.this.l5 + CSS.Value.n0));
                    resultScoreViewHolder.M.setText(String.valueOf(UWTestResultActivityFragment.this.k5));
                    resultScoreViewHolder.O.requestLayout();
                } else {
                    resultScoreViewHolder.L.setVisibility(8);
                    resultScoreViewHolder.N.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) resultScoreViewHolder.J.getLayoutParams();
                    layoutParams.weight = 3.0f;
                    resultScoreViewHolder.J.setLayoutParams(layoutParams);
                }
                resultScoreViewHolder.P.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        UWTestResultActivityFragment uWTestResultActivityFragment = UWTestResultActivityFragment.this;
                        uWTestResultActivityFragment.M4("QIDs", StringUtils.join((Iterable<?>) uWTestResultActivityFragment.w5, ","));
                    }
                });
                resultScoreViewHolder.R.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        UWTestResultActivityFragment uWTestResultActivityFragment = UWTestResultActivityFragment.this;
                        uWTestResultActivityFragment.M4("QIDs", StringUtils.join((Iterable<?>) uWTestResultActivityFragment.x5, ","));
                    }
                });
                resultScoreViewHolder.Q.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        UWTestResultActivityFragment uWTestResultActivityFragment = UWTestResultActivityFragment.this;
                        uWTestResultActivityFragment.M4("QIDs", StringUtils.join((Iterable<?>) uWTestResultActivityFragment.y5, ","));
                    }
                });
                return;
            } else if (F == 40 || F == 5) {
                if (F == 40) {
                    UWTestResultActivityFragment uWTestResultActivityFragment2 = UWTestResultActivityFragment.this;
                    obj = uWTestResultActivityFragment2.b5.get(i2 - (uWTestResultActivityFragment2.a5.size() + 5));
                } else {
                    UWTestResultActivityFragment uWTestResultActivityFragment3 = UWTestResultActivityFragment.this;
                    obj = uWTestResultActivityFragment3.c5.get(i2 - ((uWTestResultActivityFragment3.a5.size() + 6) + UWTestResultActivityFragment.this.b5.size()));
                }
                Bundle bundle2 = (Bundle) obj;
                CategoryViewHolder categoryViewHolder = (CategoryViewHolder) viewHolder;
                float floatValue = Float.valueOf(bundle2.getString("correct")).floatValue();
                float floatValue2 = Float.valueOf(bundle2.getString("total_questions")).floatValue();
                int i5 = (int) ((floatValue / floatValue2) * 100.0f);
                categoryViewHolder.K.setProgress(i5);
                categoryViewHolder.K.setMax(100);
                categoryViewHolder.I.setText(bundle2.getString("name") + " (" + i5 + "%)");
                textView = categoryViewHolder.J;
                str = "Total: " + ((int) floatValue2) + ", Correct: " + ((int) floatValue) + ", Incorrect: " + bundle2.getString("incorrect");
                textView.setText(str);
            } else {
                return;
            }
            sb.append(string);
            str = sb.toString();
            textView.setText(str);
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 3) {
                return new HeaderCellViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1321list_view_item_footer, viewGroup, false));
            }
            if (i2 == 1 || i2 == 10 || i2 == 100) {
                return new HeaderCellViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 2) {
                return new QuestionViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1382list_view_item_uworld_quetion, viewGroup, false));
            } else if (i2 == 0) {
                return new ResultTestScoreViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1386list_view_item_uworld_result_test, viewGroup, false));
            } else if (i2 == 4) {
                return new ResultScoreViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1385list_view_item_uworld_result_scores, viewGroup, false));
            } else if (i2 == 40) {
                return new CategoryViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1383list_view_item_uworld_result_category, viewGroup, false));
            } else if (i2 != 5) {
                return null;
            } else {
                return new CategoryViewHolder(LayoutInflater.from(UWTestResultActivityFragment.this.r()).inflate(R.layout.f1383list_view_item_uworld_result_category, viewGroup, false));
            }
        }

        public int b() {
            return UWTestResultActivityFragment.this.a5.size() + 5 + UWTestResultActivityFragment.this.b5.size() + 1 + UWTestResultActivityFragment.this.c5.size();
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

    /* access modifiers changed from: private */
    public void M4(String str, String str2) {
        ((ClipboardManager) r().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
        Toast.makeText(r(), "Copied to clipboard", 0).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O4(int i2) {
        super.f3(i2);
    }

    public void K4() {
        this.X4.setItemAnimator(new DefaultItemAnimator());
        this.X4.setItemDecoration(new CustomItemDecoration(r()));
        this.X4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
    }

    public void L4() {
        Toolbar toolbar = (Toolbar) this.C4.findViewById(R.id.f1139toolbar);
        this.L4 = toolbar;
        if (toolbar != null) {
            this.M4 = (ImageView) this.C4.findViewById(R.id.f1140toolbar_image_view);
            TextView textView = (TextView) this.C4.findViewById(R.id.f1142toolbar_text_view);
            this.N4 = textView;
            if (textView != null) {
                this.N4.setTypeface(Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf"));
                this.N4.setText(this.F4);
            }
            if (this.M4 != null) {
                Q4();
            }
            u4();
            this.C4.postDelayed(new Runnable() {
                public void run() {
                    UWTestResultActivityFragment uWTestResultActivityFragment = UWTestResultActivityFragment.this;
                    if (uWTestResultActivityFragment.M4 != null) {
                        uWTestResultActivityFragment.Q4();
                    }
                }
            }, 1000);
        }
    }

    public String N4(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZ");
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(simpleDateFormat.parse(str));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return str;
        }
    }

    public void P4(String str, String str2) {
        String[] split = str2.split(",");
        StringBuilder sb = new StringBuilder("CASE questions.id ");
        for (int i2 = 0; i2 < split.length; i2++) {
            sb.append("WHEN ");
            sb.append(split[i2]);
            sb.append(" THEN ");
            sb.append(i2);
            sb.append(StringUtils.SPACE);
        }
        sb.append("END");
        this.a5 = this.Q4.V(this.D4, "SELECT questions.id, pplTaken, corrTaken, title, selectedAnswer, corrAnswer, time FROM Questions LEFT OUTER JOIN (SELECT * FROM logs WHERE testId=" + str + ") AS logs2 ON questions.id = logs2.qid WHERE questions.id IN (" + str2 + ") ORDER BY " + sb.toString());
    }

    public void Q4() {
        try {
            Glide.F(this).t(CompressHelper.C(this.D4)).a(new RequestOptions().u()).B2(this.M4);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
    }

    public String R2() {
        return CompressHelper.C(this.D4);
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList<String> arrayList;
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
        String str = this.E4.split("-")[1];
        this.v5 = !this.Q4.V(this.D4, "select count(distinct  corrTaken) as c  from questions").get(0).getString("c").equals(IcyHeaders.a3);
        CompressHelper compressHelper = this.Q4;
        Bundle s1 = compressHelper.s1(compressHelper.V(this.D4, "select * from tests where id=" + str));
        this.d5 = s1;
        P4(str, s1.getString("qIds"));
        this.F4 = "Test #" + str + " Result";
        this.i5 = this.a5.size();
        ArrayList arrayList2 = new ArrayList();
        this.w5 = new ArrayList<>();
        this.x5 = new ArrayList<>();
        this.y5 = new ArrayList<>();
        Iterator<Bundle> it2 = this.a5.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            Bundle bundle2 = new Bundle();
            bundle2.putDouble("ppltaken", Double.valueOf(next.getString("pplTaken")).doubleValue());
            bundle2.putDouble("corrTaken", Double.valueOf(next.getString("corrTaken")).doubleValue());
            arrayList2.add(bundle2);
            this.w5.add(next.getString("id"));
            if (next.getString("selectedAnswer").length() == 0) {
                this.g5++;
            } else {
                if (next.getString("selectedAnswer").equals(next.getString("corrAnswer"))) {
                    this.e5++;
                    arrayList = this.x5;
                } else {
                    this.f5++;
                    arrayList = this.y5;
                }
                arrayList.add(next.getString("id"));
            }
        }
        ArrayList arrayList3 = arrayList2;
        this.k5 = (int) USMLECalculator.b(this.e5, this.f5, this.g5, arrayList3, 230.0d, 15.0d);
        this.l5 = (int) USMLECalculator.a(this.e5, this.f5, this.g5, arrayList3, 1.0d, 15.0d);
        if (this.k5 < 0) {
            this.k5 = 0;
        }
        this.b5 = this.Q4.V(this.D4, "SELECT s.name AS name, COUNT(q.id) AS total_questions, SUM(CASE WHEN l.selectedAnswer = q.corrAns THEN 1 ELSE 0 END) AS correct, SUM(CASE WHEN l.selectedAnswer != q.corrAns AND l.selectedAnswer IS NOT NULL THEN 1 ELSE 0 END) AS incorrect, SUM(CASE WHEN l.selectedAnswer IS NULL THEN 1 ELSE 0 END) AS skipped FROM logs l INNER JOIN Questions q ON l.qid = q.id INNER JOIN Subjects s ON q.subId = s.id INNER JOIN Tests t ON l.testId = t.id WHERE l.testId = " + str + " GROUP BY s.name ORDER BY (SUM(CASE WHEN l.selectedAnswer = q.corrAns THEN 1 ELSE 0 END) * 1.0 / COUNT(q.id)) DESC;");
        this.c5 = this.Q4.V(this.D4, "SELECT sys.name AS name, COUNT(q.id) AS total_questions, SUM(CASE WHEN l.selectedAnswer = q.corrAns THEN 1 ELSE 0 END) AS correct, SUM(CASE WHEN l.selectedAnswer != q.corrAns AND l.selectedAnswer IS NOT NULL THEN 1 ELSE 0 END) AS incorrect, SUM(CASE WHEN l.selectedAnswer IS NULL THEN 1 ELSE 0 END) AS skipped FROM logs l INNER JOIN Questions q ON l.qid = q.id INNER JOIN Systems sys ON q.sysId = sys.id INNER JOIN Tests t ON l.testId = t.id WHERE l.testId = " + str + " GROUP BY sys.name ORDER BY (SUM(CASE WHEN l.selectedAnswer = q.corrAns THEN 1 ELSE 0 END) * 1.0 / COUNT(q.id)) DESC;");
        if (this.b5 == null) {
            this.b5 = new ArrayList<>();
        }
        if (this.c5 == null) {
            this.c5 = new ArrayList<>();
        }
        UWTestResultAdapter uWTestResultAdapter = new UWTestResultAdapter();
        this.Z4 = uWTestResultAdapter;
        this.X4.setAdapter(uWTestResultAdapter);
        K4();
        f3(R.menu.f1412empty);
        u4();
        o2(false);
        G3();
        return this.C4;
    }

    public boolean e1(MenuItem menuItem) {
        menuItem.getItemId();
        return super.e1(menuItem);
    }

    public void f3(int i2) {
        new Handler().postDelayed(new i(this, i2), 100);
    }
}
