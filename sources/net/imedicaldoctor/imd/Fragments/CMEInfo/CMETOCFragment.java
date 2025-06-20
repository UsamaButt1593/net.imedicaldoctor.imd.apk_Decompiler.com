package net.imedicaldoctor.imd.Fragments.CMEInfo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import at.grabner.circleprogress.CircleProgressView;
import com.dd.CircularProgressButton;
import com.google.android.material.appbar.AppBarLayout;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.tool.xml.css.CSS;
import java.io.File;
import java.io.FilenameFilter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.Fragments.downloadFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.TitleComparator;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMD;
import org.apache.commons.lang3.StringUtils;

public class CMETOCFragment extends SearchHelperFragment {
    public static final String J4 = "bytesDownloaded";
    public static final String K4 = "bytesTotal";
    public static final String L4 = "avgSpeed";
    public static final String M4 = "remaining";
    public static final String N4 = "Progress";
    public static final String O4 = "Title";
    public static final String P4 = "URL";
    public static final String Q4 = "FileName";
    public static final String R4 = "MD5";
    public static final String S4 = "PartFileSize";
    public static final String T4 = "price";
    public static final String U4 = "Buy";
    public static final String V4 = "downloader";
    public static final String W4 = "retry";
    public static final String X4 = "completed";
    public static final String Y4 = "error";
    public static final String Z4 = "fileSize";
    public static final String a5 = "Icon";
    public static final String b5 = "name";
    public static final String c5 = "type";
    public static final String d5 = "version";
    public static final String e5 = "Delta";
    public static final String f5 = "Update";
    public static final String g5 = "Rebuilding";
    public static final String h5 = "Parts";
    public static final String i5 = "folderSizeKey";
    public static final String j5 = "videoIdKey";
    public static final String k5 = "savePathKey";
    public static final String l5 = "LatestKey";
    public DownloadsAdapter A4;
    public ArrayList<Bundle> B4;
    public String C4;
    public ArrayList<Bundle> D4;
    public Typeface E4;
    private Activity F4;
    private Timer G4;
    public downloadFragment H4;
    public int I4;

    public class DownloadCellViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final TextView J;
        /* access modifiers changed from: private */
        public final TextView K;
        /* access modifiers changed from: private */
        public final Button L;
        /* access modifiers changed from: private */
        public final CircleProgressView M;

        public DownloadCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (TextView) view.findViewById(R.id.f1096subtitle);
            this.K = (TextView) view.findViewById(R.id.f1097subtitle2);
            Button button = (Button) view.findViewById(R.id.f919download_button);
            this.L = button;
            button.setTypeface(CMETOCFragment.this.E4);
            this.M = (CircleProgressView) view.findViewById(R.id.f877circleView);
        }
    }

    public class DownloadsAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Bundle> f29638d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<Bundle> f29639e;

        public DownloadsAdapter(ArrayList<Bundle> arrayList, ArrayList<Bundle> arrayList2) {
            this.f29638d = arrayList;
            this.f29639e = arrayList2;
        }

        private void d0(final CircularProgressButton circularProgressButton) {
            circularProgressButton.setProgress(1);
            circularProgressButton.postDelayed(new Runnable() {
                public void run() {
                    circularProgressButton.setProgress(0);
                    circularProgressButton.postDelayed(new Runnable() {
                        public void run() {
                            circularProgressButton.setProgress(1);
                        }
                    }, 100);
                }
            }, 100);
        }

        private double e0(Bundle bundle, String str) {
            try {
                if (bundle.containsKey(str)) {
                    return bundle.getDouble(str);
                }
                return 0.0d;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                return 0.0d;
            }
        }

        private long g0(Bundle bundle, String str) {
            try {
                if (bundle.containsKey(str)) {
                    return bundle.getLong(str);
                }
                return 0;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                return 0;
            }
        }

        private String h0(int i2) {
            return k0(i2 / 3600) + " : " + k0((i2 % 3600) / 60) + " : " + k0(i2 % 60);
        }

        private String k0(int i2) {
            if (i2 == 0) {
                return "00";
            }
            if (i2 / 10 != 0) {
                return String.valueOf(i2);
            }
            return "0" + i2;
        }

        public int C(int i2) {
            if (j0() == 0) {
                return 0;
            }
            ArrayList<Bundle> arrayList = this.f29638d;
            if (arrayList == null || arrayList.size() <= 0) {
                return CMETOCFragment.this.t3(this.f29639e.get(i2)) ? 1 : 2;
            } else if (i2 < this.f29638d.size()) {
                return 3;
            } else {
                return CMETOCFragment.this.t3(this.f29639e.get(i2 - this.f29638d.size())) ? 1 : 2;
            }
        }

        public void R(RecyclerView.ViewHolder viewHolder, int i2) {
            TextView k0;
            int color;
            final int i3 = i2;
            if (viewHolder.F() == 3) {
                RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                rippleTextViewHolder.I.setText(this.f29638d.get(i3).getString("name"));
                rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment.this.V2();
                        Bundle bundle = new Bundle();
                        bundle.putBundle("DB", CMETOCFragment.this.h4);
                        bundle.putString("ParentId", DownloadsAdapter.this.f29638d.get(i3).getString("id"));
                        CMETOCFragment.this.k4.N(CMETOC.class, CMETOCFragment.class, bundle);
                    }
                });
                return;
            }
            final Bundle bundle = this.f29639e.get(i3 - this.f29638d.size());
            if (CMETOCFragment.this.t3(bundle)) {
                VideoCellViewHolder videoCellViewHolder = (VideoCellViewHolder) viewHolder;
                videoCellViewHolder.I.setText(CMETOCFragment.this.q3(bundle));
                String string = bundle.getString(CSS.Property.m0);
                if (string == "") {
                    videoCellViewHolder.J.setProgress(0);
                } else {
                    long longValue = Long.valueOf(string).longValue();
                    Long valueOf = Long.valueOf(bundle.getString("dur"));
                    Log.e("Progress bar", "Duration " + bundle.getString("dur") + ", position : " + bundle.getString(CSS.Property.m0));
                    videoCellViewHolder.J.setMax(10000);
                    videoCellViewHolder.J.setProgress((int) (((double) (((float) longValue) / ((float) valueOf.longValue()))) * 10000.0d));
                }
                if (bundle.containsKey("subText")) {
                    videoCellViewHolder.L.setVisibility(0);
                    videoCellViewHolder.L.setText(bundle.getString("subText"));
                } else {
                    videoCellViewHolder.L.setVisibility(8);
                }
                videoCellViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment cMETOCFragment = CMETOCFragment.this;
                        cMETOCFragment.I4 = i3;
                        String h1 = CompressHelper.h1(cMETOCFragment.h4, bundle.getString("name"), "temp");
                        if (bundle.containsKey("dbname")) {
                            Bundle bundle = CMETOCFragment.this.h4;
                            h1 = CompressHelper.h1(bundle, bundle.getString("dbname") + "-" + bundle.getString("name"), "temp");
                        }
                        if (!CMETOCFragment.this.h4.getString("Type").equals("cme")) {
                            h1 = CompressHelper.h1(CMETOCFragment.this.h4, bundle.getString("name"), "videos");
                        }
                        Intent intent = new Intent(CMETOCFragment.this.p3(), Player.class);
                        intent.putExtra("Address", h1);
                        intent.putExtra("DB", CMETOCFragment.this.h4);
                        String string = bundle.getString(CSS.Property.m0);
                        if (string == "") {
                            string = "0";
                        }
                        intent.putExtra(HttpHeaders.t0, Long.valueOf(string));
                        intent.putExtra("VideoID", bundle.getString("id"));
                        CMETOCFragment.this.p3().startActivity(intent);
                    }
                });
                return;
            }
            DownloadCellViewHolder downloadCellViewHolder = (DownloadCellViewHolder) viewHolder;
            downloadCellViewHolder.I.setText(CMETOCFragment.this.q3(bundle));
            if (bundle.containsKey("subText")) {
                downloadCellViewHolder.K.setVisibility(0);
                downloadCellViewHolder.K.setText(bundle.getString("subText"));
            } else {
                downloadCellViewHolder.K.setVisibility(8);
            }
            Bundle o3 = CMETOCFragment.this.o3(bundle);
            if (o3 == null) {
                o3 = new Bundle();
                o3.putString("fileSize", bundle.getString("fileSize"));
            }
            if (o3.containsKey("completed")) {
                downloadCellViewHolder.J.setText("Download Completed");
                downloadCellViewHolder.J.setTextColor(CMETOCFragment.this.b0().getColor(R.color.f169green_real));
                if (o3.containsKey("Rebuilding")) {
                    downloadCellViewHolder.J.setText("Rebuilding ...");
                }
                downloadCellViewHolder.L.setVisibility(8);
                downloadCellViewHolder.M.setVisibility(8);
            } else if (!o3.containsKey("downloader")) {
                downloadCellViewHolder.L.setVisibility(0);
                downloadCellViewHolder.M.setVisibility(8);
                try {
                    if (o3.containsKey("error")) {
                        downloadCellViewHolder.J.setText(o3.getString("error"));
                        k0 = downloadCellViewHolder.J;
                        color = CMETOCFragment.this.b0().getColor(R.color.f453red);
                    } else {
                        downloadCellViewHolder.J.setText(CMETOCFragment.this.s3(Long.valueOf(o3.getString("fileSize")).longValue()));
                        k0 = downloadCellViewHolder.J;
                        color = CMETOCFragment.this.b0().getColor(R.color.f159darkGrey);
                    }
                    k0.setTextColor(color);
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    downloadCellViewHolder.J.setText("Error occured, try again");
                    e2.printStackTrace();
                }
                downloadCellViewHolder.L.setText("Download");
                downloadCellViewHolder.L.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment.this.l3(bundle);
                        CMETOCFragment.this.i3();
                    }
                });
                downloadCellViewHolder.L.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        String y = CMETOCFragment.this.k4.y();
                        ArrayList arrayList = new ArrayList();
                        String str = y + "/" + bundle.getString("name");
                        arrayList.add(str);
                        for (int i2 = 1; i2 < 11; i2++) {
                            arrayList.add(str + "." + i2);
                            arrayList.add(str + "." + i2 + ".download");
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            String str2 = (String) it2.next();
                            if (new File(str2).exists()) {
                                new File(str2).delete();
                            }
                        }
                        CompressHelper.x2(CMETOCFragment.this.p3(), "All Temp Files Deleted", 1);
                        return true;
                    }
                });
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
                downloadCellViewHolder.L.setVisibility(8);
                downloadCellViewHolder.M.setVisibility(0);
                double e0 = e0(o3, "bytesDownloaded");
                double e02 = e0(o3, "bytesTotal");
                long g0 = g0(o3, "avgSpeed");
                long g02 = g0(o3, "remaining");
                int f0 = f0(o3, "Progress");
                String str = decimalFormat.format((e0 / 1024.0d) / 1024.0d) + " of " + decimalFormat.format((e02 / 1024.0d) / 1024.0d) + " MB(" + CMETOCFragment.this.s3(g0) + "/s), " + h0((int) g02) + " remaining";
                downloadCellViewHolder.J.setTextColor(CMETOCFragment.this.b0().getColor(R.color.f159darkGrey));
                if (e0 == 0.0d) {
                    downloadCellViewHolder.M.u();
                    str = "Preparing Download";
                } else {
                    downloadCellViewHolder.M.v();
                }
                downloadCellViewHolder.J.setText(str);
                if (f0 == 0) {
                    downloadCellViewHolder.M.setValue(1.0f);
                } else {
                    downloadCellViewHolder.M.setValue((float) f0);
                }
                downloadCellViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment.this.j3(bundle);
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                View inflate = LayoutInflater.from(CMETOCFragment.this.p3()).inflate(R.layout.f1389list_view_item_video, viewGroup, false);
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment.this.V2();
                    }
                });
                return new VideoCellViewHolder(inflate);
            } else if (i2 == 2) {
                View inflate2 = LayoutInflater.from(CMETOCFragment.this.p3()).inflate(R.layout.f1305list_view_item_cme_download, viewGroup, false);
                inflate2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment.this.V2();
                    }
                });
                return new DownloadCellViewHolder(inflate2);
            } else if (i2 != 3) {
                return null;
            } else {
                View inflate3 = LayoutInflater.from(CMETOCFragment.this.p3()).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false);
                inflate3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CMETOCFragment.this.V2();
                    }
                });
                return new RippleTextViewHolder(inflate3);
            }
        }

        public int b() {
            return j0();
        }

        public int f0(Bundle bundle, String str) {
            if (bundle.containsKey(str)) {
                return bundle.getInt(str);
            }
            return 0;
        }

        public Bundle i0(int i2) {
            return this.f29639e.get(i2 - this.f29638d.size());
        }

        public int j0() {
            ArrayList<Bundle> arrayList = this.f29638d;
            int size = arrayList != null ? arrayList.size() : 0;
            ArrayList<Bundle> arrayList2 = this.f29639e;
            return arrayList2 != null ? size + arrayList2.size() : size;
        }
    }

    public abstract class UIActionClass extends ItemTouchHelper.Callback {

        /* renamed from: i  reason: collision with root package name */
        Context f29641i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f29642j;

        /* renamed from: k  reason: collision with root package name */
        private final ColorDrawable f29643k = new ColorDrawable();

        /* renamed from: l  reason: collision with root package name */
        private final int f29644l = Color.parseColor("#b80f0a");

        /* renamed from: m  reason: collision with root package name */
        private final Drawable f29645m;

        /* renamed from: n  reason: collision with root package name */
        private final int f29646n;
        private final int o;

        UIActionClass(Context context) {
            this.f29641i = context;
            Paint paint = new Paint();
            this.f29642j = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable l2 = ContextCompat.l(this.f29641i, 17301564);
            this.f29645m = l2;
            this.f29646n = l2.getIntrinsicWidth();
            this.o = l2.getIntrinsicHeight();
        }

        private void E(Canvas canvas, Float f2, Float f3, Float f4, Float f5) {
            canvas.drawRect(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), this.f29642j);
        }

        public boolean A(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return false;
        }

        public int l(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return viewHolder.F() == 1 ? ItemTouchHelper.Callback.v(0, 4) : ItemTouchHelper.Callback.v(0, 0);
        }

        public float n(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.7f;
        }

        public void w(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            super.w(canvas, recyclerView, viewHolder, f2, f3, i2, z);
            View view = viewHolder.f15587a;
            int height = view.getHeight();
            if (viewHolder.F() == 1 && (f2 != 0.0f || z)) {
                this.f29643k.setColor(this.f29644l);
                this.f29643k.setBounds(view.getRight() + ((int) f2), view.getTop(), view.getRight(), view.getBottom());
                this.f29643k.draw(canvas);
                int top = view.getTop();
                int i3 = this.o;
                int i4 = top + ((height - i3) / 2);
                int i5 = (height - i3) / 2;
                this.f29645m.setBounds((view.getRight() - i5) - this.f29646n, i4, view.getRight() - i5, this.o + i4);
                this.f29645m.draw(canvas);
            } else {
                E(canvas, Float.valueOf(((float) view.getRight()) + f2), Float.valueOf((float) view.getTop()), Float.valueOf((float) view.getRight()), Float.valueOf((float) view.getBottom()));
            }
            super.w(canvas, recyclerView, viewHolder, f2, f3, i2, z);
        }
    }

    public class VideoCellViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final ProgressBar J;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout K;
        /* access modifiers changed from: private */
        public final TextView L;

        public VideoCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.title);
            this.J = (ProgressBar) view.findViewById(R.id.f1043progress_bar);
            this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.L = (TextView) view.findViewById(R.id.f1096subtitle);
        }
    }

    private void n3() {
        new ItemTouchHelper(new UIActionClass(r()) {
            public void D(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
                try {
                    final int B = viewHolder.B();
                    new AlertDialog.Builder(CMETOCFragment.this.r(), R.style.f2185alertDialogTheme).l("Are you really want to delete this video ?").y("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Bundle i0 = ((DownloadsAdapter) CMETOCFragment.this.w4.getAdapter()).i0(B);
                            String h1 = CompressHelper.h1(CMETOCFragment.this.h4, i0.getString("name"), "temp");
                            if (i0.containsKey("dbname")) {
                                Bundle bundle = CMETOCFragment.this.h4;
                                h1 = CompressHelper.h1(bundle, i0.getString("dbname") + "-" + i0.getString("name"), "temp");
                            }
                            if (!CMETOCFragment.this.h4.getString("Type").equals("cme")) {
                                h1 = CompressHelper.h1(CMETOCFragment.this.h4, i0.getString("name"), "videos");
                            }
                            new File(h1).delete();
                            CMETOCFragment.this.w4.getAdapter().H(B);
                        }
                    }).p("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            CMETOCFragment.this.w4.getAdapter().H(B);
                        }
                    }).I();
                } catch (Exception unused) {
                }
            }
        }).m(this.w4);
    }

    private void r3() {
    }

    public void M0(Activity activity) {
        super.M0(activity);
        this.F4 = activity;
    }

    public void Q2() {
        if (this.h4.containsKey("Demo")) {
            K2();
            return;
        }
        SearchView searchView = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        this.s4.setIconifiedByDefault(false);
        this.s4.setQueryHint("Search");
        this.i4 = true;
        ((ImageView) this.s4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CMETOCFragment.this.s4.k0("", false);
                CMETOCFragment.this.s4.clearFocus();
                CMETOCFragment cMETOCFragment = CMETOCFragment.this;
                cMETOCFragment.w4.setAdapter(cMETOCFragment.l4);
                CMETOCFragment.this.V2();
                CMETOCFragment.this.Z2();
            }
        });
        this.s4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                CMETOCFragment cMETOCFragment = CMETOCFragment.this;
                if (!cMETOCFragment.i4) {
                    return true;
                }
                cMETOCFragment.f4 = str;
                if (str.length() > 1) {
                    new AsyncTask() {
                        /* access modifiers changed from: protected */
                        public Object doInBackground(Object[] objArr) {
                            CMETOCFragment cMETOCFragment = CMETOCFragment.this;
                            CompressHelper compressHelper = cMETOCFragment.k4;
                            Bundle bundle = cMETOCFragment.h4;
                            cMETOCFragment.B4 = compressHelper.V(bundle, "select * from toc where name like '%" + CMETOCFragment.this.s4.getQuery().toString() + "%' AND NOT (id=999) COLLATE utf8_general_ci");
                            CMETOCFragment cMETOCFragment2 = CMETOCFragment.this;
                            cMETOCFragment2.o4 = cMETOCFragment2.a3(str);
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Object obj) {
                            CMETOCFragment.this.X2();
                        }

                        /* access modifiers changed from: protected */
                        public void onPreExecute() {
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                    return true;
                }
                CMETOCFragment cMETOCFragment2 = CMETOCFragment.this;
                cMETOCFragment2.w4.setAdapter(cMETOCFragment2.l4);
                return false;
            }

            public boolean b(String str) {
                return false;
            }
        });
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CompressHelper compressHelper;
        Bundle bundle2;
        StringBuilder sb;
        String str;
        ArrayList<Bundle> V;
        this.q4 = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
        this.E4 = Typeface.createFromAsset(r().getAssets(), "fonts/HelveticaNeue-Light.otf");
        this.H4 = ((iMD) r().getApplicationContext()).c3;
        W2(bundle);
        S2();
        this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
        Q2();
        this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
        final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
        if (y() == null || !y().containsKey("ParentId")) {
            appBarLayout.D(true, false);
            relativeLayout.setVisibility(0);
            this.C4 = null;
        } else {
            if (y().getString("ParentId").equals("0")) {
                appBarLayout.D(true, false);
                relativeLayout.setVisibility(0);
            } else {
                appBarLayout.D(false, false);
                appBarLayout.postDelayed(new Runnable() {
                    public void run() {
                        relativeLayout.setVisibility(0);
                    }
                }, 800);
            }
            this.C4 = y().getString("ParentId");
        }
        if (this.C4 == null) {
            this.C4 = "0";
        }
        if (this.C4.equals("11111")) {
            String[] list = new File(CompressHelper.g1(this.h4, "temp")).list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.toLowerCase().endsWith("mp4");
                }
            });
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add("'" + str2 + "'");
            }
            V = this.k4.V(this.h4, "select *,medias.id as id ,logs.duration as dur from medias left outer join logs on medias.id=logs.id where dbname || '-' || name in (" + StringUtils.join((Iterable<?>) arrayList, ",") + ") ");
        } else {
            this.n4 = this.k4.V(this.h4, "Select * from toc where parentId = " + this.C4);
            if (this.h4.getString("Type").equals("cme")) {
                compressHelper = this.k4;
                bundle2 = this.h4;
                sb = new StringBuilder();
                str = "Select medias.*, logs.position, logs.vDate ,logs.duration as dur from medias left outer join logs  on medias.id=logs.id where tocId = ";
            } else {
                compressHelper = this.k4;
                bundle2 = this.h4;
                sb = new StringBuilder();
                str = "Select videos.id, videos.title, videos.path, videos.name, videos.tocId, videos.purpose, videos.fileSize, logs.position, logs.vDate ,logs.duration as dur from videos left outer join logs  on videos.id=logs.id where tocId =";
            }
            sb.append(str);
            sb.append(this.C4);
            V = compressHelper.V(bundle2, sb.toString());
        }
        this.D4 = V;
        if (this.n4 == null) {
            this.n4 = new ArrayList<>();
        }
        if (this.D4 == null) {
            this.D4 = new ArrayList<>();
        }
        if (this.h4.getString("Name").equals("imdvideos.db") && this.C4.equals("0")) {
            String[] list2 = new File(CompressHelper.g1(this.h4, "temp")).list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.toLowerCase().endsWith("mp4");
                }
            });
            Bundle bundle3 = new Bundle();
            bundle3.putString("id", "11111");
            bundle3.putString("name", "Downloaded");
            bundle3.putString("videoCount", list2.length + "");
            this.n4.add(0, bundle3);
        }
        Collections.sort(this.D4, new TitleComparator("title"));
        Collections.sort(this.n4, new TitleComparator("name"));
        this.l4 = new DownloadsAdapter(this.n4, this.D4);
        m3();
        this.A4 = new DownloadsAdapter(this.B4, this.o4);
        this.w4.setAdapter(this.l4);
        N2();
        this.w4.setItemAnimator((RecyclerView.ItemAnimator) null);
        o2(false);
        n3();
        return this.q4;
    }

    public void X2() {
        if (this.o4 == null) {
            this.o4 = new ArrayList<>();
        }
        if (this.B4 == null) {
            this.B4 = new ArrayList<>();
        }
        DownloadsAdapter downloadsAdapter = new DownloadsAdapter(this.B4, this.o4);
        this.A4 = downloadsAdapter;
        this.w4.setAdapter(downloadsAdapter);
    }

    public ArrayList<Bundle> a3(String str) {
        ArrayList<Bundle> arrayList;
        String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, StringUtils.SPACE);
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : splitByWholeSeparator) {
            arrayList2.add("title like '%" + str2 + "%'");
        }
        if (this.h4.getString("Type").equals("cme")) {
            arrayList = this.k4.V(this.h4, "SELECT medias.*, logs.position, logs.vDate, logs.duration AS dur, REPLACE(REPLACE(COALESCE(toc5.name || ' / ', '') || COALESCE(toc4.name || ' / ', '') || COALESCE(toc3.name || ' / ', '') || COALESCE(toc2.name || ' / ', '') || toc1.name, 'Videos / ', ''), 'Audios / ', '') AS subText FROM medias LEFT OUTER JOIN logs ON medias.id = logs.id LEFT OUTER JOIN TOC toc1 ON medias.tocId = toc1.id LEFT OUTER JOIN TOC toc2 ON toc1.parentId = toc2.id LEFT OUTER JOIN TOC toc3 ON toc2.parentId = toc3.id LEFT OUTER JOIN TOC toc4 ON toc3.parentId = toc4.id LEFT OUTER JOIN TOC toc5 ON toc4.parentId = toc5.id WHERE " + StringUtils.join((Iterable<?>) arrayList2, " AND "));
        } else {
            arrayList = this.k4.V(this.h4, "Select videos.id, videos.title, videos.path, videos.name, videos.tocId, videos.purpose, videos.fileSize, logs.position, logs.vDate ,logs.duration as dur from videos left outer join logs  on videos.id=logs.id where title like '%" + str + "%'");
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Collections.sort(arrayList, new TitleComparator("title"));
        return arrayList;
    }

    public ArrayList<Bundle> g3(String str) {
        return null;
    }

    public void i3() {
    }

    public void j3(Bundle bundle) {
        String str = this.h4.getString("Name") + " - " + bundle.getString("name");
        Log.e("StopDownload", str);
        if (this.H4.x3(str) != null) {
            this.H4.a4(str);
        }
    }

    public void k3(String str) {
        int i2 = 0;
        if (this.w4.getAdapter() == this.l4) {
            ArrayList<Bundle> arrayList = this.n4;
            int size = arrayList != null ? arrayList.size() : 0;
            while (i2 < this.D4.size()) {
                if (str.equals(this.h4.getString("Name") + " - " + this.D4.get(i2).getString("name"))) {
                    this.w4.getAdapter().H(size + i2);
                }
                i2++;
            }
            return;
        }
        ArrayList<Bundle> arrayList2 = this.B4;
        int size2 = arrayList2 != null ? arrayList2.size() : 0;
        while (i2 < this.o4.size()) {
            if (str.equals(this.h4.getString("Name") + " - " + this.o4.get(i2).getString("name"))) {
                this.w4.getAdapter().H(size2 + i2);
            }
            i2++;
        }
    }

    public void l1() {
        CompressHelper compressHelper;
        Bundle bundle;
        StringBuilder sb;
        String str;
        ArrayList<Bundle> V;
        super.l1();
        this.H4 = ((iMD) r().getApplicationContext()).c3;
        if (this.C4.equals("11111")) {
            String[] list = new File(CompressHelper.g1(this.h4, "temp")).list(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.toLowerCase().endsWith("mp4");
                }
            });
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                arrayList.add("'" + str2 + "'");
            }
            V = this.k4.V(this.h4, "select *,medias.id as id ,logs.duration as dur from medias left outer join logs on medias.id=logs.id where dbname || '-' || name in (" + StringUtils.join((Iterable<?>) arrayList, ",") + ") ");
        } else {
            if (this.h4.getString("Type").equals("cme")) {
                compressHelper = this.k4;
                bundle = this.h4;
                sb = new StringBuilder();
                str = "Select medias.*, logs.position, logs.vDate ,logs.duration as dur from medias left outer join logs  on medias.id=logs.id where tocId = ";
            } else {
                compressHelper = this.k4;
                bundle = this.h4;
                sb = new StringBuilder();
                str = "Select videos.id, videos.title, videos.path, videos.name, videos.tocId, videos.purpose, videos.fileSize, logs.position, logs.vDate ,logs.duration as dur from videos left outer join logs  on videos.id=logs.id where tocId =";
            }
            sb.append(str);
            sb.append(this.C4);
            V = compressHelper.V(bundle, sb.toString());
        }
        this.D4 = V;
        if (this.D4 == null) {
            this.D4 = new ArrayList<>();
        }
        Collections.sort(this.D4, new TitleComparator("title"));
        RecyclerView.Adapter adapter = this.w4.getAdapter();
        RecyclerView.Adapter adapter2 = this.l4;
        if (adapter == adapter2) {
            ((DownloadsAdapter) adapter2).f29639e = this.D4;
        } else {
            ArrayList<Bundle> a3 = a3(this.s4.getQuery().toString());
            this.o4 = a3;
            if (a3 == null) {
                this.o4 = new ArrayList<>();
            }
            Collections.sort(this.o4, new TitleComparator("name"));
            ArrayList<Bundle> V2 = this.k4.V(this.h4, "select * from toc where name like '%" + this.s4.getQuery().toString() + "%' AND NOT (id=999) COLLATE utf8_general_ci");
            this.B4 = V2;
            if (V2 == null) {
                this.B4 = new ArrayList<>();
            }
            DownloadsAdapter downloadsAdapter = this.A4;
            downloadsAdapter.f29638d = this.B4;
            downloadsAdapter.f29639e = this.o4;
        }
        this.w4.getAdapter().G();
    }

    public void l3(Bundle bundle) {
        Bundle bundle2 = bundle;
        try {
            String replace = this.h4.getString("Name").replace(".db", "");
            if (bundle2.containsKey("dbname")) {
                replace = bundle2.getString("dbname").replace(".db", "");
            }
            String T1 = this.k4.T1("http://" + (V1().getSharedPreferences("default_preferences", 0).getString("DownloadServer", "dl").equals("idl") ? "ivideos" : "videos") + ".imedicaldoctor.net/cmeinfo/" + replace + "/" + bundle2.getString("name"));
            String h1 = CompressHelper.h1(this.h4, bundle2.getString("name"), "temp");
            if (bundle2.containsKey("dbname")) {
                h1 = CompressHelper.h1(this.h4, bundle2.getString("dbname") + "-" + bundle2.getString("name"), "temp");
            }
            if (!this.h4.getString("Type").equals("cme")) {
                T1 = this.k4.T1(this.k4.J() + "/dbs/usmle/" + this.h4.getString("Name").replace(".db", "") + "/videos/" + bundle2.getString("name") + ".mp4");
                h1 = CompressHelper.h1(this.h4, bundle2.getString("name"), "videos");
            }
            String str = T1;
            String str2 = h1;
            String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str2, "/");
            String str3 = splitByWholeSeparator[splitByWholeSeparator.length - 1];
            final String str4 = this.h4.getString("Name") + " - " + bundle2.getString("name");
            Log.e("AddDownloadForVideo", "Downloading " + str4 + " , " + str + " To " + str2);
            Bundle x3 = this.H4.x3(str4);
            if (x3 == null || !x3.containsKey("downloader")) {
                this.H4.u3(bundle2.getString("title"), str, str2, bundle2.getString("fileSize"), str3, str4, "");
                this.H4.T3(str4, new Runnable() {
                    public void run() {
                        CMETOCFragment.this.k3(str4);
                    }
                });
                this.H4.Z3(str4);
                return;
            }
            this.H4.Z3(str4);
        } catch (Exception unused) {
        }
    }

    public void m3() {
        try {
            Iterator<Bundle> it2 = this.D4.iterator();
            while (it2.hasNext()) {
                final String str = this.h4.getString("Name") + " - " + it2.next().getString("name");
                Log.e("Find Resource VideoID", str);
                Bundle x3 = this.H4.x3(str);
                if (x3 != null && x3.containsKey("downloader")) {
                    this.H4.T3(str, new Runnable() {
                        public void run() {
                            CMETOCFragment.this.k3(str);
                        }
                    });
                }
            }
        } catch (Exception unused) {
        }
    }

    public Bundle o3(Bundle bundle) {
        String str = this.h4.getString("Name") + " - " + bundle.getString("name");
        downloadFragment downloadfragment = this.H4;
        if (downloadfragment == null) {
            return null;
        }
        return downloadfragment.x3(str);
    }

    public Activity p3() {
        return this.F4;
    }

    public Spanned q3(Bundle bundle) {
        String str;
        if (!bundle.containsKey("dbtitle") || (this.s4.getQuery().toString().length() <= 0 && this.C4 != "11111")) {
            str = bundle.getString("title");
        } else {
            str = bundle.getString("title") + "<br/><font color=\"Gray\"><small>" + bundle.getString("dbtitle") + "</small></font>";
        }
        return Html.fromHtml(str);
    }

    public String s3(long j2) {
        if (j2 <= 0) {
            return "0";
        }
        double d2 = (double) j2;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d2 / Math.pow(1024.0d, (double) log10)) + StringUtils.SPACE + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public boolean t3(Bundle bundle) {
        String h1 = CompressHelper.h1(this.h4, bundle.getString("name"), "temp");
        if (bundle.containsKey("dbname")) {
            Bundle bundle2 = this.h4;
            h1 = CompressHelper.h1(bundle2, bundle.getString("dbname") + "-" + bundle.getString("name"), "temp");
        }
        if (!this.h4.getString("Type").equals("cme")) {
            h1 = CompressHelper.h1(this.h4, bundle.getString("name"), "videos");
        }
        return new File(h1).exists();
    }
}
