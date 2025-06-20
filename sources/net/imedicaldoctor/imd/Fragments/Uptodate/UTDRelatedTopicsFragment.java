package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.app.Dialog;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.json.JSONArray;
import org.json.JSONObject;

public class UTDRelatedTopicsFragment extends DialogFragment {
    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1275fragment_utdrelated_topics, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(R.id.f996list_view);
        r().setFinishOnTouchOutside(true);
        try {
            final JSONArray jSONArray = new JSONArray(y().getString("RELATED"));
            listView.setAdapter(new ListAdapter() {
                public boolean areAllItemsEnabled() {
                    return true;
                }

                public int getCount() {
                    return jSONArray.length();
                }

                public Object getItem(int i2) {
                    try {
                        return jSONArray.getJSONObject(i2);
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        return null;
                    }
                }

                public long getItemId(int i2) {
                    return (long) i2;
                }

                public int getItemViewType(int i2) {
                    return 1;
                }

                public View getView(int i2, View view, ViewGroup viewGroup) {
                    UTDRelatedTopicsFragment.this.r().getLayoutInflater();
                    View inflate = LayoutInflater.from(UTDRelatedTopicsFragment.this.r()).inflate(R.layout.f1338list_view_item_related_topics, viewGroup, false);
                    try {
                        ((TextView) inflate.findViewById(R.id.f1136title_text)).setText((UTDRelatedTopicsFragment.this.y().containsKey("CALC") ? ((JSONObject) getItem(i2)).getJSONObject("topicInfo") : (JSONObject) getItem(i2)).getString("title"));
                    } catch (Exception unused) {
                    }
                    return inflate;
                }

                public int getViewTypeCount() {
                    return 1;
                }

                public boolean hasStableIds() {
                    return true;
                }

                public boolean isEmpty() {
                    return false;
                }

                public boolean isEnabled(int i2) {
                    return true;
                }

                public void registerDataSetObserver(DataSetObserver dataSetObserver) {
                }

                public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        org.json.JSONObject r1 = (org.json.JSONObject) r1
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "clicked : "
                        r2.append(r3)
                        java.lang.String r3 = r1.toString()
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        java.lang.String r3 = "relatedTopicsFragment"
                        net.imedicaldoctor.imd.iMDLogger.j(r3, r2)
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment.this     // Catch:{ Exception -> 0x004a }
                        android.os.Bundle r2 = r2.y()     // Catch:{ Exception -> 0x004a }
                        java.lang.String r3 = "CALC"
                        boolean r2 = r2.containsKey(r3)     // Catch:{ Exception -> 0x004a }
                        java.lang.String r3 = "id"
                        if (r2 == 0) goto L_0x004c
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment.this     // Catch:{ Exception -> 0x004a }
                        androidx.fragment.app.Fragment r2 = r2.l0()     // Catch:{ Exception -> 0x004a }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment r2 = (net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity.UTDViewerFragment) r2     // Catch:{ Exception -> 0x004a }
                        java.lang.String r4 = "topicInfo"
                        org.json.JSONObject r1 = r1.getJSONObject(r4)     // Catch:{ Exception -> 0x004a }
                        java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x004a }
                    L_0x0046:
                        r2.S4(r1)     // Catch:{ Exception -> 0x004a }
                        goto L_0x007c
                    L_0x004a:
                        r1 = move-exception
                        goto L_0x0059
                    L_0x004c:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment r2 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment.this     // Catch:{ Exception -> 0x004a }
                        androidx.fragment.app.Fragment r2 = r2.l0()     // Catch:{ Exception -> 0x004a }
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity$UTDViewerFragment r2 = (net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity.UTDViewerFragment) r2     // Catch:{ Exception -> 0x004a }
                        java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x004a }
                        goto L_0x0046
                    L_0x0059:
                        com.google.firebase.crashlytics.FirebaseCrashlytics r2 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
                        r2.g(r1)
                        java.lang.Class r2 = r0.getClass()
                        java.lang.String r2 = r2.toString()
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r4 = "Error in getting id of topic "
                        r3.append(r4)
                        r3.append(r1)
                        java.lang.String r1 = r3.toString()
                        net.imedicaldoctor.imd.iMDLogger.f(r2, r1)
                    L_0x007c:
                        net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment r1 = net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment.this
                        r1.M2()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.Uptodate.UTDRelatedTopicsFragment.AnonymousClass2.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            String cls = getClass().toString();
            iMDLogger.f(cls, "Error in parsing related Topics " + e2);
        }
        builder.setView(inflate);
        return builder.create();
    }
}
