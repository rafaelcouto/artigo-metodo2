<template>
  <div>
    <p>&nbsp;</p>

    <p>
      <button class="btn btn-primary" type="submit" v-on:click="consultar">Consultar SAT</button>
    </p>

    <div class="card card-body bg-light">
      <strong>Resultado:</strong>
      <span v-text="result"></span>
      <b-spinner label="Spinning" v-if="consultando"></b-spinner>
    </div>
  </div>
</template>

<script>
export default {
  name: "Main",
  data: () => {
    return {
      result: null,
      consultando: false
    };
  },
  methods: {
    consultar: function() {
      this.result = null;
      this.consultando = true;

      let data = {
        module: "sat",
        device: "emulator",
        action: "consultar"
      };

      console.log("Enviando dados para extensão");
      console.log(data);

      chrome.runtime.sendMessage(
        "fpjdmndllckjnbjejoabclbihbhahehe",
        data,
        response => {
          console.log("Recebido resposta da extensão");
          console.log(response);

          this.result = response;
          this.consultando = false;
        }
      );
    }
  }
};
</script>
