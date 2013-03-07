package br.com.hachitecnologia.gcm.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import br.com.hachitecnologia.gcm.R;
import br.com.hachitecnologia.gcm.util.GCM;

/**
 * Activity responsável por mostrar na tela uma opção 
 * para o usuário ativar/desativar o serviço GCM.
 * 
 * @author lucasfreitas
 *
 */
public class AtivaGCMActivity extends Activity {
	
	private Button botaoAtivarDesativar;
	private boolean gcmAtivo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ativa_gcm);
		botaoAtivarDesativar = (Button) findViewById(R.id.botao_ativar_desativar);
		/*
		 *  Verifica se o GCM está ativo ou não para definir a Label 
		 *  do botão na tela
		 */
		gcmAtivo = GCM.isAtivo(getApplicationContext());
		// Define a Label do botão
		defineLabelBotao();
	}
	
	/**
	 * Método que irá ativar/desativar o serviço GCM de acordo 
	 * com o seu status atual. Se o GCM estiver desabilitado, este 
	 * método irá ativá-lo, ou vice-versa.
	 * 
	 * @param view
	 */
	public void ativaDesativaGCM(View view) {
		if (GCM.isAtivo(getApplicationContext())) {
			GCM.desativa(getApplicationContext());
			gcmAtivo = false;
			Toast.makeText(getApplicationContext(), "GCM desativado!", Toast.LENGTH_LONG).show();
		} else {
			GCM.ativa(getApplicationContext());
			gcmAtivo = true;
			Toast.makeText(getApplicationContext(), "GCM ativado!", Toast.LENGTH_LONG).show();
		}
		defineLabelBotao();
	}
	
	/**
	 * Método que irá definir a Label do botão da tela, de
	 * acordo com a seguinte regra:
	 * 1. se o GCM estiver ativo, a label será: Desativar
	 * 2. se o GCM NÃO estiver ativo, a label será: Ativar
	 */
	private void defineLabelBotao() {
		if (gcmAtivo) {
			botaoAtivarDesativar.setText("Desativar");
		} else {
			botaoAtivarDesativar.setText("Ativar");
		}
	}

}
