package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<Bundle> {
    HashMap<String, Integer> X = new HashMap<>();
    final int s = -1;

    public StableArrayAdapter(Context context, int i2, List<Bundle> list) {
        super(context, i2, list);
        int i3 = 0;
        for (Bundle next : list) {
            HashMap<String, Integer> hashMap = this.X;
            hashMap.put("Section" + next.getString("title"), Integer.valueOf(i3));
            i3++;
            for (int i4 = 0; i4 < next.getParcelableArrayList("items").size(); i4++) {
                HashMap<String, Integer> hashMap2 = this.X;
                hashMap2.put("Database" + ((Bundle) next.getParcelableArrayList("items").get(i4)).getString("Name"), Integer.valueOf(i3));
                i3++;
            }
        }
    }

    public long getItemId(int i2) {
        StringBuilder sb;
        String str;
        if (i2 < 0 || i2 >= this.X.size()) {
            return -1;
        }
        Bundle bundle = (Bundle) getItem(i2);
        if (bundle.containsKey("Item")) {
            bundle = bundle.getBundle("Item");
            sb = new StringBuilder();
            sb.append("Database");
            str = "Name";
        } else {
            sb = new StringBuilder();
            sb.append("Section");
            str = "Title";
        }
        sb.append(bundle.getString(str));
        return (long) this.X.get(sb.toString()).intValue();
    }

    public boolean hasStableIds() {
        return true;
    }
}
