chrome.runtime.onMessageExternal.addListener((data, sender, response) => {

	// As it is registered in registy
	var host_name = 'io.rafaelcouto.app';
	
	// Open port (for communication).
	var port = chrome.runtime.connectNative(host_name);
	port.onDisconnect.addListener(function () {
		if (chrome.runtime.lastError) {
			response(chrome.runtime.lastError.message);
		}
	});	

	// Enviando mensagem para aplicação desktop
	port.postMessage(data);

	// Esperando pela resposta
	port.onMessage.addListener(function (data) {
		// Enviando resposta decodificada em base64
		response(atob(data.message));
	});
	
});