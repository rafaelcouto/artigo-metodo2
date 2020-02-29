chrome.runtime.onMessageExternal.addListener((data, sender, response) => {

	// As it is registered in registy
	var host_name = 'io.rafaelcouto.app';
	
	// Open port (for communication).
	console.log('Iniciando conexão com aplicação nativa');
	var port = chrome.runtime.connectNative(host_name);
	port.onDisconnect.addListener(function () {
		if (chrome.runtime.lastError) {
			response(chrome.runtime.lastError.message);
		}
	});	

	// Enviando mensagem para aplicação desktop
	console.log('Enviando dados para aplicação nativa');
	console.log(data);
	
	port.postMessage(data);

	// Esperando pela resposta
	port.onMessage.addListener(function (data) {

		console.log('Recebido resposta da aplicação nativa');
		console.log(atob(data.message));

		// Enviando resposta decodificada em base64
		response(atob(data.message));
	});
	
});