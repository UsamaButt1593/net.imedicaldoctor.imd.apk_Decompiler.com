package net.imedicaldoctor.imd.Fragments.Uptodate;

import android.app.Dialog;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import net.imedicaldoctor.imd.Fragments.Uptodate.UTDViewerActivity;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.iMDLogger;
import org.json.JSONArray;
import org.json.JSONObject;

public class UTDRelatedGraphicsFragment extends DialogFragment {
    public Dialog U2(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(r());
        View inflate = r().getLayoutInflater().inflate(R.layout.f1274fragment_utdrelated_graphics, (ViewGroup) null);
        ExpandableListView expandableListView = (ExpandableListView) inflate.findViewById(R.id.f996list_view);
        try {
            final JSONArray jSONArray = new JSONArray(y().getString("RELATED"));
            expandableListView.setAdapter(new ExpandableListAdapter() {
                public boolean areAllItemsEnabled() {
                    return true;
                }

                public Object getChild(int i2, int i3) {
                    try {
                        return jSONArray.getJSONObject(i2).getJSONArray("graphics").getJSONObject(i3);
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in getChild : " + e2);
                        return null;
                    }
                }

                public long getChildId(int i2, int i3) {
                    return (((long) i2) * 1000) + ((long) i3);
                }

                public View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
                    View inflate = LayoutInflater.from(UTDRelatedGraphicsFragment.this.r()).inflate(R.layout.f1336list_view_item_related_graphic, viewGroup, false);
                    try {
                        ((TextView) inflate.findViewById(R.id.f1136title_text)).setText(((JSONObject) getChild(i2, i3)).getJSONObject("graphicInfo").getString("displayName"));
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in getChildView Title : " + e2);
                    }
                    return inflate;
                }

                public int getChildrenCount(int i2) {
                    try {
                        return jSONArray.getJSONObject(i2).getJSONArray("graphics").length();
                    } catch (Exception e2) {
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in getting ChildrenCount from json : " + e2);
                        return 0;
                    }
                }

                public long getCombinedChildId(long j2, long j3) {
                    return 0;
                }

                public long getCombinedGroupId(long j2) {
                    return 0;
                }

                public Object getGroup(int i2) {
                    try {
                        return jSONArray.getJSONObject(i2);
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in getGroup : " + e2);
                        return null;
                    }
                }

                public int getGroupCount() {
                    return jSONArray.length();
                }

                public long getGroupId(int i2) {
                    return (long) i2;
                }

                public View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
                    View inflate = LayoutInflater.from(UTDRelatedGraphicsFragment.this.r()).inflate(R.layout.f1337list_view_item_related_graphic_header, viewGroup, false);
                    try {
                        ((TextView) inflate.findViewById(R.id.f1136title_text)).setText(((JSONObject) getGroup(i2)).getString("headingTitle"));
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        String cls = getClass().toString();
                        iMDLogger.f(cls, "Error in getGroupView Title : " + e2);
                    }
                    return inflate;
                }

                public boolean hasStableIds() {
                    return true;
                }

                public boolean isChildSelectable(int i2, int i3) {
                    return true;
                }

                public boolean isEmpty() {
                    return false;
                }

                public void onGroupCollapsed(int i2) {
                }

                public void onGroupExpanded(int i2) {
                }

                public void registerDataSetObserver(DataSetObserver dataSetObserver) {
                }

                public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
                }
            });
            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                    try {
                        JSONObject jSONObject = (JSONObject) expandableListView.getExpandableListAdapter().getChild(i2, i3);
                        String cls = getClass().toString();
                        iMDLogger.j(cls, "graph clicked " + jSONObject);
                        ((UTDViewerActivity.UTDViewerFragment) UTDRelatedGraphicsFragment.this.l0()).R4(jSONObject.getJSONObject("graphicInfo").getString("id"));
                    } catch (Exception e2) {
                        FirebaseCrashlytics.d().g(e2);
                        String cls2 = getClass().toString();
                        iMDLogger.f(cls2, "Error in onChildClick : " + e2);
                    }
                    UTDRelatedGraphicsFragment.this.M2();
                    return true;
                }
            });
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            iMDLogger.f(getClass().toString(), "Error in parsing related Graphics " + e2);
        }
        for (int groupCount = expandableListView.getExpandableListAdapter().getGroupCount(); groupCount >= 0; groupCount--) {
            expandableListView.expandGroup(groupCount, true);
        }
        builder.setView(inflate);
        return builder.create();
    }
}
