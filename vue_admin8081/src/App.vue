<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
  import admin_login from "./components/admin/admin_login"
  import Register from "./components/admin/Register"
  import AdminUser from "./components/admin/AdminUser"
export default {
  name: 'App',
  components:{admin_login:admin_login,Register:Register,AdminUser:AdminUser}
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
