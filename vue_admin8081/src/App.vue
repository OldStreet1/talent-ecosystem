<template>
  <div id="app">
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
  import admin_login from "./components/admin/admin_login"
  import Register from "./components/admin/Register"
  import AdminUser from "./components/admin/AdminUser"
  import PowerManagement from "./components/admin/PowerManagement"
export default {
  name: 'App',
  components:{admin_login:admin_login,Register:Register,AdminUser:AdminUser,PowerManagement:PowerManagement},
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive= false
      this.$nextTick(function () {
        this.isRouterAlive= true
      })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
