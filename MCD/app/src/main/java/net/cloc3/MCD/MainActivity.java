package net.cloc3.MCD;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// 1. Layout principale (Contenitore verticale)
	LinearLayout mainLayout = new LinearLayout(this);
	mainLayout.setOrientation(LinearLayout.VERTICAL);
	mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
	mainLayout.setPadding(50, 80, 50, 80);
	mainLayout.setBackgroundColor(0xFFF5F5F5); // Grigio chiarissimo di sfondo

	// Titolo dell'applicazione
	TextView titleView = new TextView(this);
	titleView.setText("Elaboratore Numerico");
	titleView.setTextSize(24);
	titleView.setTextColor(0xFF212121); // Grigio scuro/Nero
	titleView.setPadding(0, 0, 0, 50);
	mainLayout.addView(titleView);

	// Input Primo Numero
	final EditText inputNum1 = new EditText(this);
	inputNum1.setHint("Inserisci il primo numero");
	inputNum1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
	mainLayout.addView(inputNum1);

	// Input Secondo Numero
	final EditText inputNum2 = new EditText(this);
	inputNum2.setHint("Inserisci il secondo numero");
	inputNum2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);
	mainLayout.addView(inputNum2);

	// Bottone di Calcolo
	Button btnCalcola = new Button(this);
	btnCalcola.setText("Elabora");
	btnCalcola.setBackgroundColor(0xFF6200EE); // Viola "Material Design"
	btnCalcola.setTextColor(0xFFFFFFFF);       // Testo bianco
	mainLayout.addView(btnCalcola);

	// Risultato
	final TextView txtRisultato = new TextView(this);
	txtRisultato.setText("Risultato: -");
	txtRisultato.setTextSize(18);
	txtRisultato.setPadding(0, 40, 0, 0);
	mainLayout.addView(txtRisultato);

	// 2. Logica del Bottone (Algoritmo)
	btnCalcola.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			int[] coppia = new int[2];
			try {
			// Estrai i numeri inseriti
			coppia[0] = Math.abs(Integer.parseInt(inputNum1.getText().toString()));
			coppia[1] = Math.abs(Integer.parseInt(inputNum2.getText().toString()));

			// --- IL TUO ALGORITMO (Temporaneo: MCD) ---
			Arrays.sort(coppia);
				
			while (coppia[0]>0) {
				coppia[1]=coppia[1]-coppia[0];
				Arrays.sort(coppia);
			}
				txtRisultato.setText("MCD: " + coppia[1]);
			} catch (NumberFormatException e) {
				txtRisultato.setText("Errore: Inserisci numeri validi!");
			}
		}	
	});

        // Imposta il layout nella schermata
        setContentView(mainLayout);
	}
}
