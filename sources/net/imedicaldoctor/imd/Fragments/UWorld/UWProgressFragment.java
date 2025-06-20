package net.imedicaldoctor.imd.Fragments.UWorld;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.itextpdf.tool.xml.css.CSS;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Views.ButtonSmall;

public class UWProgressFragment extends ViewerHelperFragment {
    private ProgressBar X4;
    private TextView Y4;
    private TextView Z4;
    private TextView a5;
    private TextView b5;
    private TextView c5;
    private PieChart d5;
    private BarChart e5;
    private BarChart f5;
    private BarChart g5;
    private BarChart h5;
    public ButtonSmall i5;

    private static class EventDecorator implements DayViewDecorator {

        /* renamed from: a  reason: collision with root package name */
        private final int f29971a;

        /* renamed from: b  reason: collision with root package name */
        private final HashSet<CalendarDay> f29972b;

        public EventDecorator(int i2, Collection<CalendarDay> collection) {
            this.f29971a = i2;
            this.f29972b = new HashSet<>(collection);
        }

        public void a(DayViewFacade dayViewFacade) {
            dayViewFacade.a(new DotSpan(5.0f, this.f29971a));
        }

        public boolean b(CalendarDay calendarDay) {
            return this.f29972b.contains(calendarDay);
        }
    }

    private int[] I4(int i2) {
        int[] iArr = new int[i2];
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
        return iArr;
    }

    private void J4() {
        try {
            int intValue = Integer.valueOf(this.Q4.V(this.D4, "select count(*) c from questions").get(0).getString("c")).intValue();
            int intValue2 = Integer.valueOf(this.Q4.V(this.D4, "select count(distinct(qid)) c from logs").get(0).getString("c")).intValue();
            int intValue3 = Integer.valueOf(this.Q4.V(this.D4, "SELECT COUNT(*)  AS c FROM (SELECT l1.* FROM logs l1 JOIN (SELECT qid, MAX(id) AS latestId FROM logs GROUP BY qid) l2 ON l1.qid = l2.qid AND l1.id = l2.latestId) subquery WHERE selectedAnswer = corrAnswer;").get(0).getString("c")).intValue();
            int intValue4 = Integer.valueOf(this.Q4.V(this.D4, "SELECT COUNT(*)  AS c FROM (SELECT l1.* FROM logs l1 JOIN (SELECT qid, MAX(id) AS latestId FROM logs GROUP BY qid) l2 ON l1.qid = l2.qid AND l1.id = l2.latestId) subquery WHERE selectedAnswer <> corrAnswer;").get(0).getString("c")).intValue();
            int i2 = intValue - intValue2;
            this.X4.setProgress((int) ((((double) intValue2) / ((double) intValue)) * 100.0d));
            TextView textView = this.Y4;
            textView.setText("Overall Progress: " + this.X4.getProgress() + CSS.Value.n0);
            this.Z4.setText(String.valueOf(intValue));
            this.a5.setText(String.valueOf(intValue2));
            this.b5.setText(String.valueOf(intValue3));
            this.c5.setText(String.valueOf(intValue4));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PieEntry((float) intValue3, "Correct"));
            arrayList.add(new PieEntry((float) intValue4, "Incorrect"));
            arrayList.add(new PieEntry((float) i2, "Unused"));
            PieDataSet pieDataSet = new PieDataSet(arrayList, "");
            pieDataSet.D1(new int[]{R.color.f158correct, R.color.f178incorrect, R.color.f451omitted, R.color.f468unused}, B());
            PieData pieData = new PieData(pieDataSet);
            pieData.J(false);
            this.d5.setData(pieData);
            Description description = new Description();
            description.q("");
            this.d5.setDescription(description);
            this.d5.invalidate();
        } catch (Exception unused) {
            CompressHelper.x2(r(), "Error in Overall Progress Calculations", 0);
        }
    }

    private void K4() {
        ArrayList<Bundle> V = this.Q4.V(this.D4, "SELECT s.subjectName, s.ids, CAST((COUNT(DISTINCT l.qid) * 100.0 / COUNT(DISTINCT q.id)) AS INTEGER) AS percentage FROM (SELECT CASE WHEN instr(name, '(') > 0 THEN substr(name, 1, instr(name, '(') - 1) ELSE name END AS subjectName, GROUP_CONCAT(id) AS ids FROM Subjects GROUP BY subjectName) s JOIN Questions q ON ',' || s.ids || ',' LIKE '%,' || q.subId || ',%' LEFT JOIN logs l ON q.id = l.qid GROUP BY s.subjectName, s.ids ORDER BY percentage DESC;");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (V == null || V.size() == 0) {
            this.e5.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < V.size(); i2++) {
            arrayList.add(new BarEntry((float) i2, (float) Integer.valueOf(V.get(i2).getString("percentage")).intValue()));
            arrayList2.add(V.get(i2).getString("subjectName") + "(" + V.get(i2).getString("percentage") + "%)");
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "Subjects Progress");
        barDataSet.B1(I4(arrayList.size()));
        this.e5.setData(new BarData(barDataSet));
        Description description = new Description();
        description.q("");
        this.e5.setDescription(description);
        Legend legend = this.e5.getLegend();
        legend.T(Legend.LegendForm.SQUARE);
        legend.i(12.0f);
        legend.e0(10.0f);
        legend.f0(5.0f);
        legend.c0(Legend.LegendVerticalAlignment.BOTTOM);
        legend.Y(Legend.LegendHorizontalAlignment.CENTER);
        legend.a0(Legend.LegendOrientation.HORIZONTAL);
        legend.d0(true);
        legend.O(false);
        LegendEntry[] legendEntryArr = new LegendEntry[arrayList2.size()];
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.f18952a = (String) arrayList2.get(i3);
            legendEntry.f18957f = barDataSet.d0(i3);
            legendEntryArr[i3] = legendEntry;
        }
        legend.M(legendEntryArr);
        int size = arrayList2.size();
        ViewGroup.LayoutParams layoutParams = this.e5.getLayoutParams();
        layoutParams.height = ((int) (b0().getDisplayMetrics().density * 300.0f)) + (size * ((int) (b0().getDisplayMetrics().density * 20.0f)));
        this.e5.setLayoutParams(layoutParams);
        this.e5.invalidate();
    }

    private void L4() {
        ArrayList<Bundle> V = this.Q4.V(this.D4, "SELECT s.subjectName, s.ids, COUNT(DISTINCT l.qid) AS answeredQuestions, COUNT(DISTINCT CASE WHEN l.selectedAnswer = l.corrAnswer THEN l.qid END) AS correctAnswers, COUNT(DISTINCT CASE WHEN l.selectedAnswer != l.corrAnswer THEN l.qid END) AS incorrectAnswers, CAST((COUNT(DISTINCT CASE WHEN l.selectedAnswer = l.corrAnswer THEN l.qid END) * 100.0 / COUNT(DISTINCT l.qid)) AS INTEGER) AS correctPercentage FROM (SELECT CASE WHEN instr(name, '(') > 0 THEN substr(name, 1, instr(name, '(') - 1) ELSE name END AS subjectName, GROUP_CONCAT(id) AS ids FROM Subjects GROUP BY subjectName) s JOIN Questions q ON ',' || s.ids || ',' LIKE '%,' || q.subId || ',%' LEFT JOIN logs l ON q.id = l.qid GROUP BY s.subjectName, s.ids HAVING correctPercentage IS NOT NULL ORDER BY correctPercentage DESC;");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (V == null || V.size() == 0) {
            this.f5.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < V.size(); i2++) {
            arrayList.add(new BarEntry((float) i2, (float) Integer.valueOf(V.get(i2).getString("correctPercentage")).intValue()));
            arrayList2.add(V.get(i2).getString("subjectName") + "(" + V.get(i2).getString("correctPercentage") + "%)");
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "Subjects Correct Percentage");
        barDataSet.B1(I4(arrayList.size()));
        this.f5.setData(new BarData(barDataSet));
        Description description = new Description();
        description.q("");
        this.f5.setDescription(description);
        Legend legend = this.f5.getLegend();
        legend.T(Legend.LegendForm.SQUARE);
        legend.i(12.0f);
        legend.e0(10.0f);
        legend.f0(5.0f);
        legend.c0(Legend.LegendVerticalAlignment.BOTTOM);
        legend.Y(Legend.LegendHorizontalAlignment.CENTER);
        legend.a0(Legend.LegendOrientation.HORIZONTAL);
        legend.d0(true);
        legend.O(false);
        LegendEntry[] legendEntryArr = new LegendEntry[arrayList2.size()];
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.f18952a = (String) arrayList2.get(i3);
            legendEntry.f18957f = barDataSet.d0(i3);
            legendEntryArr[i3] = legendEntry;
        }
        legend.M(legendEntryArr);
        int size = arrayList2.size();
        ViewGroup.LayoutParams layoutParams = this.f5.getLayoutParams();
        layoutParams.height = ((int) (b0().getDisplayMetrics().density * 300.0f)) + (size * ((int) (b0().getDisplayMetrics().density * 20.0f)));
        this.f5.setLayoutParams(layoutParams);
        this.f5.invalidate();
    }

    private void M4() {
        ArrayList<Bundle> V = this.Q4.V(this.D4, "SELECT s.subjectName, s.ids, CAST((COUNT(DISTINCT l.qid) * 100.0 / COUNT(DISTINCT q.id)) AS INTEGER) AS percentage FROM (SELECT CASE WHEN instr(name, '(') > 0 THEN substr(name, 1, instr(name, '(') - 1) ELSE name END AS subjectName, GROUP_CONCAT(id) AS ids FROM Systems GROUP BY subjectName) s JOIN Questions q ON ',' || s.ids || ',' LIKE '%,' || q.sysId || ',%' LEFT JOIN logs l ON q.id = l.qid GROUP BY s.subjectName, s.ids ORDER BY percentage DESC;");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (V == null || V.size() == 0) {
            this.g5.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < V.size(); i2++) {
            arrayList.add(new BarEntry((float) i2, (float) Integer.valueOf(V.get(i2).getString("percentage")).intValue()));
            arrayList2.add(V.get(i2).getString("subjectName") + "(" + V.get(i2).getString("percentage") + "%)");
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "Systems Progress");
        barDataSet.B1(I4(arrayList.size()));
        this.g5.setData(new BarData(barDataSet));
        Description description = new Description();
        description.q("");
        this.g5.setDescription(description);
        Legend legend = this.g5.getLegend();
        legend.T(Legend.LegendForm.SQUARE);
        legend.i(12.0f);
        legend.e0(10.0f);
        legend.f0(5.0f);
        legend.c0(Legend.LegendVerticalAlignment.BOTTOM);
        legend.Y(Legend.LegendHorizontalAlignment.CENTER);
        legend.a0(Legend.LegendOrientation.HORIZONTAL);
        legend.d0(true);
        legend.O(false);
        LegendEntry[] legendEntryArr = new LegendEntry[arrayList2.size()];
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.f18952a = (String) arrayList2.get(i3);
            legendEntry.f18957f = barDataSet.d0(i3);
            legendEntryArr[i3] = legendEntry;
        }
        legend.M(legendEntryArr);
        int size = arrayList2.size();
        ViewGroup.LayoutParams layoutParams = this.g5.getLayoutParams();
        layoutParams.height = ((int) (b0().getDisplayMetrics().density * 300.0f)) + (size * ((int) (b0().getDisplayMetrics().density * 20.0f)));
        this.g5.setLayoutParams(layoutParams);
        this.g5.invalidate();
    }

    private void N4() {
        ArrayList<Bundle> V = this.Q4.V(this.D4, "SELECT s.subjectName, s.ids, COUNT(DISTINCT l.qid) AS answeredQuestions, COUNT(DISTINCT CASE WHEN l.selectedAnswer = l.corrAnswer THEN l.qid END) AS correctAnswers, COUNT(DISTINCT CASE WHEN l.selectedAnswer != l.corrAnswer THEN l.qid END) AS incorrectAnswers, CAST((COUNT(DISTINCT CASE WHEN l.selectedAnswer = l.corrAnswer THEN l.qid END) * 100.0 / COUNT(DISTINCT l.qid)) AS INTEGER) AS correctPercentage FROM (SELECT CASE WHEN instr(name, '(') > 0 THEN substr(name, 1, instr(name, '(') - 1) ELSE name END AS subjectName, GROUP_CONCAT(id) AS ids FROM Systems GROUP BY subjectName) s JOIN Questions q ON ',' || s.ids || ',' LIKE '%,' || q.sysId || ',%' LEFT JOIN logs l ON q.id = l.qid WHERE l.qid IS NOT NULL GROUP BY s.subjectName, s.ids HAVING correctPercentage IS NOT NULL ORDER BY correctPercentage DESC;");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (V == null || V.size() == 0) {
            this.h5.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < V.size(); i2++) {
            arrayList.add(new BarEntry((float) i2, (float) Integer.valueOf(V.get(i2).getString("correctPercentage")).intValue()));
            arrayList2.add(V.get(i2).getString("subjectName") + "(" + V.get(i2).getString("correctPercentage") + "%)");
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "Systems Correct Percentage");
        barDataSet.B1(I4(arrayList.size()));
        this.h5.setData(new BarData(barDataSet));
        Description description = new Description();
        description.q("");
        this.h5.setDescription(description);
        Legend legend = this.h5.getLegend();
        legend.T(Legend.LegendForm.SQUARE);
        legend.i(12.0f);
        legend.e0(10.0f);
        legend.f0(5.0f);
        legend.c0(Legend.LegendVerticalAlignment.BOTTOM);
        legend.Y(Legend.LegendHorizontalAlignment.CENTER);
        legend.a0(Legend.LegendOrientation.HORIZONTAL);
        legend.d0(true);
        legend.O(false);
        LegendEntry[] legendEntryArr = new LegendEntry[arrayList2.size()];
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.f18952a = (String) arrayList2.get(i3);
            legendEntry.f18957f = barDataSet.d0(i3);
            legendEntryArr[i3] = legendEntry;
        }
        legend.M(legendEntryArr);
        int size = arrayList2.size();
        ViewGroup.LayoutParams layoutParams = this.h5.getLayoutParams();
        layoutParams.height = ((int) (b0().getDisplayMetrics().density * 300.0f)) + (size * ((int) (b0().getDisplayMetrics().density * 20.0f)));
        this.h5.setLayoutParams(layoutParams);
        this.h5.invalidate();
    }

    @Nullable
    public View onFragmentBind(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f1263fragment_progress, viewGroup, false);
        this.C4 = inflate;
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.f1139toolbar);
        this.L4 = toolbar;
        AppCompatActivity appCompatActivity = (AppCompatActivity) r();
        if (appCompatActivity != null) {
            appCompatActivity.P0(toolbar);
            appCompatActivity.F0().Y(true);
            appCompatActivity.F0().c0(true);
        }
        this.D4 = (y() == null || !y().containsKey("DB")) ? null : y().getBundle("DB");
        this.i5 = (ButtonSmall) this.C4.findViewById(R.id.f829back_button);
        this.L4.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UWProgressFragment.this.Q4.W1(false);
            }
        });
        if (this.i5 != null) {
            this.i5.setDrawableIcon(r().getResources().getDrawable(R.drawable.f540back_icon_white));
            this.i5.setRippleColor(r().getResources().getColor(R.color.f466toolbar_item_ripple_color));
            this.i5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UWProgressFragment.this.Q4.W1(true);
                }
            });
            this.i5.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    UWProgressFragment.this.Q4.Z1(true);
                    return true;
                }
            });
        }
        this.X4 = (ProgressBar) inflate.findViewById(R.id.f1031overall_progress_bar);
        this.Y4 = (TextView) inflate.findViewById(R.id.f1032overall_progress_text);
        this.Z4 = (TextView) inflate.findViewById(R.id.f1148total_questions_value);
        this.a5 = (TextView) inflate.findViewById(R.id.f1154used_questions_value);
        this.b5 = (TextView) inflate.findViewById(R.id.f892correct_questions_value);
        this.c5 = (TextView) inflate.findViewById(R.id.f985incorrect_questions_value);
        this.d5 = (PieChart) inflate.findViewById(R.id.f1048question_distribution_pie_chart);
        this.e5 = (BarChart) inflate.findViewById(R.id.f1090subjects_bar_chart);
        this.f5 = (BarChart) inflate.findViewById(R.id.f1092subjects_correct_chart);
        this.g5 = (BarChart) inflate.findViewById(R.id.f1103systems_bar_chart);
        this.h5 = (BarChart) inflate.findViewById(R.id.f1105systems_correct_chart);
        J4();
        K4();
        L4();
        M4();
        N4();
        return inflate;
    }
}
