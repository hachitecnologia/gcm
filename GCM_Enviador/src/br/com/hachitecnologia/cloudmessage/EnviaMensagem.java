package br.com.hachitecnologia.cloudmessage;

import java.io.IOException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

/**
 * Classe resposável por enviar mensagens para um dispositivo 
 * através do GCM.
 * 
 * @author lucasfreitas
 *
 */
public class EnviaMensagem {
	
	// Variável com o ID do dispositivo registrado no GCM
	private static final String ID_DISPOSITIVO_GCM = "APA91bE8-JNjqbXaKK8x80FN7XAqE_VZAQZcqkTX1jftte1Y_welfM-g6RfK005scSBgOSuXJ_aad0UQg4zrncPpK270R5Ymx6LJAPF7q1AMU0zN5gvrOsozH48BZZb5rv8oLvAPf-jl0I7-1F_idqaqI0usMc1VJg";
	// Variável com a chave obtida em API ACCESS no Google APIs
	private static final String API_KEY = "AIzaSyDP1dDGvuP3g_wPb0XPrtaFCqGz5X9h-2s";
	
	public static void main(String[] args) {
		
		/**
		 * ID do Sender (Enviador)
		 */
		Sender sender = new Sender(API_KEY);
		
		/**
		 * Mensagem a ser enviada
		 */
		Message message = new Message.Builder()
		   .collapseKey("1")
		   .timeToLive(3)
		   .delayWhileIdle(true)
		   .addData("mensagem", // identificador da mensagem
		     "Olá! Este é um teste de envio de mensagem através do GCM!")
		   .build();
		
		Result result = null;
		
		/**
		 * Envia a mensagem para o dispositivo
		 */
		try {
			result = sender.send(message,ID_DISPOSITIVO_GCM, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Imprime o resultado do envio na saída padrão
		if (result != null)
			System.out.println(result.toString());
		
	}

}
