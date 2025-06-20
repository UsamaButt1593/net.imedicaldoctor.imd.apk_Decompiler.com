package net.imedicaldoctor.imd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.itextpdf.text.Annotation;
import java.io.File;
import net.imedicaldoctor.imd.Data.CompressHelper;

public class GeneralDialogFragment extends DialogFragment {
    public View F4;
    public String G4;
    public Fragment H4;

    public GeneralDialogFragment() {
    }

    @Nullable
    public View onFragmentBind(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.F4 = layoutInflater.inflate(R.layout.f1219fragment_container_dialog, (ViewGroup) null);
        try {
            Q2().getWindow().requestFeature(1);
            Q2().getWindow().requestFeature(11);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        String string = this.H4.y().getString("URL");
        this.G4 = string;
        if (string.equals(Annotation.k3)) {
            try {
                this.G4 = CompressHelper.e2(new File(CompressHelper.g1(this.H4.y().getBundle("DB"), "temp.html")));
            } catch (Exception unused) {
            }
        }
        ((Button) this.F4.findViewById(R.id.f1028open_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GeneralDialogFragment.this.N2();
                new CompressHelper(GeneralDialogFragment.this.r()).A1(GeneralDialogFragment.this.H4.y().getBundle("DB"), GeneralDialogFragment.this.G4, (String[]) null, (String) null);
            }
        });
        ((Button) this.F4.findViewById(R.id.f881close_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GeneralDialogFragment.this.N2();
            }
        });
        this.F4.postDelayed(new Runnable() {
            public void run() {
                GeneralDialogFragment.this.z().u().C(R.id.f947fragment_container, GeneralDialogFragment.this.H4).r();
            }
        }, 50);
        return this.F4;
    }

    public GeneralDialogFragment(Fragment fragment) {
        this.H4 = fragment;
    }
}
