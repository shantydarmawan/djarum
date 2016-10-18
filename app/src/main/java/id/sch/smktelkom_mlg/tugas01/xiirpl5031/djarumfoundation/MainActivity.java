package id.sch.smktelkom_mlg.tugas01.xiirpl5031.djarumfoundation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAlamat;
    Button bOK;
    RadioButton rbL, rbP;
    TextView tvhasil;
    Spinner sp;
    CheckBox cbA, cbTA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);


        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        sp = (Spinner) findViewById(R.id.spinner);
        cbA = (CheckBox) findViewById(R.id.checkBoxA);
        cbTA = (CheckBox) findViewById(R.id.checkBoxTA);


        bOK = (Button) findViewById(R.id.buttonOK);
        tvhasil = (TextView) findViewById(R.id.textViewhasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPocess();
            }

            public void doPocess() {
                String hasil = "\n Cedera : \n";
                String hasil2 = "\n Cedera : \n";

                if (rbL.isChecked()) {
                    hasil = rbL.getText().toString();
                } else if (rbP.isChecked()) {
                    hasil = rbP.getText().toString();
                }
                int startlen = hasil2.length();
                if (cbA.isChecked()) hasil2 += "- " + cbA.getText() + "\n";
                if (cbTA.isChecked()) hasil2 += "- " + cbTA.getText() + "\n";

                if (hasil2.length() == startlen) hasil2 += "Tidak Ada Pilihan";

                if (isValid()) {

                    String nama = etNama.getText().toString();
                    String alamat = etAlamat.getText().toString();
                    tvhasil.setText(
                            "Nama : " + nama + "\nAlamat : " + alamat + "\nspesifikasi : " + sp.getSelectedItem().toString() + "\n Jenis Kelamin : " + hasil + hasil2);


                }
            }

            private boolean isValid() {
                boolean valid = true;


                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();
                if (nama.isEmpty()) {
                    etNama.setError("nama belum diisi");
                    valid = false;

                } else if (nama.length() < 4) {
                    etNama.setError("Nama tidak boleh kurang dari 4 karakter");
                    valid = false;
                } else if (alamat.length() < 5) {
                    etAlamat.setError("Alamat tidak boleh kurang dari 5 karakter");
                    valid = false;
                } else {
                    etNama.setError(null);
                }
                if (nama.isEmpty()) {
                    etNama.setError("nama belum diisi");
                    valid = false;
                } else {
                    etNama.setError(null);
                }

                return valid;


            }
        });
    }

}
