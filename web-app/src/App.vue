<template>
  <div id="app" class="container">
    <Main />
  </div>
</template>

<script>
import Vue from 'vue'
import Main from './components/Main.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

export default {
  name: 'app',
  components: {
    Main
  }
}
</script>

<style>
  h4.separator {
    border-bottom: 1px dashed #666;
  }
</style>
