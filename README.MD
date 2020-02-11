
Protótipo para demonstrar como fazer a intermediação entre a comunicação entre uma aplicação web e um dispositivo local, utilizando como exemplo um dispositivo SAT. 

# Fluxo

1) A aplicação web envia uma mensagem para extensão do Google Chrome utilizando o protocolo de [Messaging](https://developer.chrome.com/extensions/messaging);
2) A extensão envia uma mensagem para a aplicação desktop utilizando o protocolo de [Native Messaging](https://developer.chrome.com/apps/nativeMessaging);
3) A aplicação desktop se comunica com o dispositivo SAT através da DLL;

# Extensão

1) Abrir o Google Chrome e ir em `chrome://extensions/`
2) Habilitar **modo de desenvolvedor** e carregar a pasta `extension` na opção "Carregar sem compactação"
3) Alterar `dist\install.bat` com o caminho do manifest.json e executar

# Aplicação WEB

A aplicação web foi desenvolvida utilizando Vue.JS. 

``` bash
# instalar dependencias
npm install

# rodar a aplicação para desenvolvimento (localhost:8080)
npm run serve

# build para produção
npm run build
```

# Aplicação desktop

A aplicação desktop foi desenvolvido em JAVA.

``` bash
# rodar a aplicação para desenvolvimento (localhost:8999)
gradlew run

# build para produção
gradlew shadowJar
```

# Emulador SAT

É necessário instalar e rodar o emulador do SAT disponibilizado pela Receita Federal
https://portal.fazenda.sp.gov.br/servicos/sat/Downloads/emulador_off_line_v2_9_4.zip

**Obs: o emulador disponibiliza apenas a DLL para 32 bits, portanto deve estar instalador o JAVA para 32 bits.**