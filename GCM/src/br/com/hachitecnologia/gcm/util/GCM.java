package br.com.hachitecnologia.gcm.util;

import android.content.Context;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

/**
 * Classe utilitária responsável por ativar/desativar o 
 * aplicativo nos servidores GCM do Google.
 * 
 * @author lucasfreitas
 *
 */
public class GCM {
	
	/**
	 * Método responsável por ativar o uso do GCM.
	 * @param context
	 */
	public static void ativa(Context context) {
		GCMRegistrar.checkDevice(context);
		GCMRegistrar.checkManifest(context);
		final String regId = GCMRegistrar
				.getRegistrationId(context);
		if (regId.equals("")) {
			GCMRegistrar.register(context, Constantes.SENDER_ID);
			Log.i(Constantes.TAG, "Serviço GCM ativado.");
		} else {
			Log.i(Constantes.TAG, "O serviço GCM já está ativo. ID: " + regId);
		}
	}
	
	/**
	 * Método responsável por desativar o uso do GCM.
	 * @param context
	 */
	public static void desativa(Context context) {
			GCMRegistrar.unregister(context);
			Log.i(Constantes.TAG, "Serviço GCM desativado.");
	}
	
	/**
	 * Método responsável por verificar se o aplicativo 
	 * está ou não registrado para uso do GCM.
	 * @param context
	 * @return
	 */
	public static boolean isAtivo(Context context) {
		return GCMRegistrar.isRegistered(context);
	}

}
