package maua.etec.appimc;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    EditText txtPeso;
    EditText txtAltura;
    TextView txtIMC;
    Button btCalcular;
    ImageView imgIMC;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtIMC = (TextView) findViewById(R.id.txtIMC);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        imgIMC = (ImageView) findViewById(R.id.imgIMC);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double imc;
                double peso;
                double altura;

                peso = Double.valueOf( txtPeso.getText().toString());
                altura = Double.valueOf(txtAltura.getText().toString());

                imc = peso/Math.pow(altura,2);

                if (imc >= 30){
                    txtResultado.setText("Acima do Peso !");
                    Drawable img = getResources().getDrawable(R.drawable.acima);
                    imgIMC.setImageDrawable(img);
                }

                else if (imc <= 20){
                    txtResultado.setText("Peso Normal !");
                    Drawable img = getResources().getDrawable(R.drawable.normal);
                    imgIMC.setImageDrawable(img);
                }

                else {
                    txtResultado.setText("Abaixo do Peso !");
                    Drawable img = getResources().getDrawable(R.drawable.abaixo);
                    imgIMC.setImageDrawable(img);
            }

                txtIMC.setText(String.valueOf(imc));

            }
        });

    }
}
