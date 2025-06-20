package net.imedicaldoctor.imd.Data;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.io.File;
import java.util.ArrayList;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.HeaderCellViewHolder;
import net.imedicaldoctor.imd.ViewHolders.MessageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextFullViewHolder;

public class HistoryAdapter extends RecyclerView.Adapter {

    /* renamed from: l  reason: collision with root package name */
    private static final int f29594l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static final int f29595m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f29596n = 2;
    private static final int o = 3;

    /* renamed from: d  reason: collision with root package name */
    public Context f29597d;

    /* renamed from: e  reason: collision with root package name */
    public String f29598e;

    /* renamed from: f  reason: collision with root package name */
    public int f29599f;

    /* renamed from: g  reason: collision with root package name */
    public String f29600g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Bundle> f29601h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<Bundle> f29602i;

    /* renamed from: j  reason: collision with root package name */
    public DrawerLayout f29603j;

    /* renamed from: k  reason: collision with root package name */
    public CompressHelper f29604k;

    public static class DatabaseCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public TextView J;
        public ImageView K;
        public MaterialRippleLayout L;
        public AppCompatButton M;

        public DatabaseCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.f896database_title);
            this.K = (ImageView) view.findViewById(R.id.f893database_image);
            this.L = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.M = (AppCompatButton) view.findViewById(R.id.f862buy_button);
            this.J = (TextView) view.findViewById(R.id.f895database_subtitle);
        }
    }

    public HistoryAdapter(Context context, DrawerLayout drawerLayout) {
        this.f29604k = new CompressHelper(context);
        this.f29597d = context;
        d0();
        CompressHelper compressHelper = this.f29604k;
        this.f29602i = compressHelper.Y(compressHelper.h2(), "SELECT m1.* FROM recent m1 LEFT JOIN recent m2 ON (m1.dbAddress = m2.dbAddress AND m1.dbName = m2.dbName AND m1.id < m2.id) WHERE m2.id IS NULL order by id desc limit 30");
        if (this.f29601h == null) {
            this.f29601h = new ArrayList<>();
        }
        if (this.f29602i == null) {
            this.f29602i = new ArrayList<>();
        }
        this.f29603j = drawerLayout;
        this.f29600g = "No History";
    }

    public int C(int i2) {
        if (this.f29601h.size() == 0 && this.f29602i.size() == 0) {
            return 0;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 < this.f29601h.size() + 1) {
            return 2;
        }
        if (i2 == this.f29601h.size() + 1) {
            return 1;
        }
        return i2 > this.f29601h.size() + 1 ? 3 : -1;
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        MaterialRippleLayout materialRippleLayout;
        View.OnLongClickListener r0;
        TextView textView;
        String str;
        int F = viewHolder.F();
        if (F == 0) {
            textView = ((MessageViewHolder) viewHolder).I;
            str = this.f29600g;
        } else if (F == 1) {
            textView = ((HeaderCellViewHolder) viewHolder).I;
            str = i2 == 0 ? "Recent Databases" : "Recent Documents";
        } else {
            if (F == 2) {
                final Bundle bundle = this.f29601h.get(i2 - 1);
                DatabaseCellViewHolder databaseCellViewHolder = (DatabaseCellViewHolder) viewHolder;
                databaseCellViewHolder.M.setVisibility(8);
                databaseCellViewHolder.J.setVisibility(8);
                if (bundle.containsKey("home")) {
                    databaseCellViewHolder.K.setImageDrawable(ContextCompat.l(this.f29597d, R.drawable.f644home_24px));
                    databaseCellViewHolder.I.setText("Home");
                    databaseCellViewHolder.L.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            HistoryAdapter.this.e0();
                            HistoryAdapter.this.f29603j.h();
                            HistoryAdapter.this.f29604k.Z1(true);
                            HistoryAdapter.this.f29604k.Z1(false);
                        }
                    });
                    return;
                }
                databaseCellViewHolder.I.setText(bundle.getString("dbTitle"));
                String D = CompressHelper.D(bundle);
                if (D.contains("file:///android_asset/") || new File(D).exists()) {
                    Glide.D(this.f29597d).t(D).B2(databaseCellViewHolder.K);
                } else {
                    databaseCellViewHolder.K.setImageDrawable(this.f29597d.getResources().getDrawable(R.drawable.f715placeholder));
                }
                databaseCellViewHolder.L.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        HistoryAdapter.this.e0();
                        HistoryAdapter.this.f29603j.h();
                        Bundle Y0 = HistoryAdapter.this.f29604k.Y0("Name", bundle.getString("dbName"));
                        if (Y0 == null) {
                            CompressHelper.x2(HistoryAdapter.this.f29597d, "This database doesn't exist anymore", 0);
                        } else {
                            HistoryAdapter.this.f29604k.z1(Y0);
                        }
                    }
                });
                materialRippleLayout = databaseCellViewHolder.L;
                r0 = new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        CompressHelper compressHelper = HistoryAdapter.this.f29604k;
                        String h2 = compressHelper.h2();
                        compressHelper.q(h2, "delete from dbrecent where dbName='" + bundle.getString("dbName") + "'");
                        HistoryAdapter.this.d0();
                        HistoryAdapter.this.G();
                        return true;
                    }
                };
            } else if (F == 3) {
                final Bundle bundle2 = this.f29602i.get((i2 - this.f29601h.size()) - 2);
                RippleTextFullViewHolder rippleTextFullViewHolder = (RippleTextFullViewHolder) viewHolder;
                rippleTextFullViewHolder.I.setText(bundle2.getString("dbDocName").trim());
                rippleTextFullViewHolder.J.setText(bundle2.getString("dbTitle").trim());
                rippleTextFullViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        HistoryAdapter.this.e0();
                        HistoryAdapter.this.f29603j.h();
                        Bundle Y0 = HistoryAdapter.this.f29604k.Y0("Name", bundle2.getString("dbName"));
                        if (Y0 == null) {
                            CompressHelper.x2(HistoryAdapter.this.f29597d, "This database doesn't exist anymore", 0);
                        } else {
                            HistoryAdapter.this.f29604k.A1(Y0, bundle2.getString("dbAddress"), (String[]) null, (String) null);
                        }
                    }
                });
                materialRippleLayout = rippleTextFullViewHolder.M;
                r0 = new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        CompressHelper compressHelper = HistoryAdapter.this.f29604k;
                        String h2 = compressHelper.h2();
                        compressHelper.q(h2, "delete from recent where dbName='" + bundle2.getString("dbName") + "' AND dbAddress='" + bundle2.getString("dbAddress") + "'");
                        HistoryAdapter historyAdapter = HistoryAdapter.this;
                        CompressHelper compressHelper2 = historyAdapter.f29604k;
                        historyAdapter.f29602i = compressHelper2.Y(compressHelper2.h2(), "SELECT m1.* FROM recent m1 LEFT JOIN recent m2 ON (m1.dbAddress = m2.dbAddress AND m1.dbName = m2.dbName AND m1.id < m2.id) WHERE m2.id IS NULL order by id desc limit 30");
                        HistoryAdapter.this.G();
                        return true;
                    }
                };
            } else {
                return;
            }
            materialRippleLayout.setOnLongClickListener(r0);
            return;
        }
        textView.setText(str);
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new MessageViewHolder(this.f29597d, LayoutInflater.from(this.f29597d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
        } else if (i2 == 1) {
            return new HeaderCellViewHolder(LayoutInflater.from(this.f29597d).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
        } else {
            if (i2 == 2) {
                return new DatabaseCellViewHolder(LayoutInflater.from(this.f29597d).inflate(R.layout.f1312list_view_item_database_ripple, viewGroup, false));
            }
            if (i2 != 3) {
                return null;
            }
            RippleTextFullViewHolder rippleTextFullViewHolder = new RippleTextFullViewHolder(LayoutInflater.from(this.f29597d).inflate(R.layout.f1341list_view_item_ripple_recent, viewGroup, false));
            rippleTextFullViewHolder.K.setVisibility(8);
            return rippleTextFullViewHolder;
        }
    }

    public int b() {
        try {
            if (this.f29601h.size() == 0 && this.f29602i.size() == 0) {
                return 1;
            }
            return this.f29601h.size() + this.f29602i.size() + 2;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void d0() {
        CompressHelper compressHelper = this.f29604k;
        ArrayList<Bundle> Y = compressHelper.Y(compressHelper.h2(), "SELECT distinct(dbName), dbTitle, dbIcon FROM dbrecent order by id desc limit 2");
        this.f29601h = Y;
        if (Y == null) {
            this.f29601h = new ArrayList<>();
        }
        Bundle bundle = new Bundle();
        bundle.putString("home", "");
        this.f29601h.add(bundle);
    }

    public void e0() {
        try {
            ((InputMethodManager) this.f29597d.getSystemService("input_method")).hideSoftInputFromWindow(((Activity) this.f29597d).getCurrentFocus().getWindowToken(), 0);
            if (((Activity) this.f29597d).getCurrentFocus() != null) {
                ((Activity) this.f29597d).getCurrentFocus().clearFocus();
            }
        } catch (Exception unused) {
        }
    }
}
