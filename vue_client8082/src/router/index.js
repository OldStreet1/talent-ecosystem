import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import enterprise_login from "../../../vue_admin8081/src/components/enterprise/enterprise_login";

Vue.use(Router)

export default new Router({
  mode:"history",  //不带#号
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/enterprise_login',
      name: 'enterprise_login',
      component: enterprise_login
    },

  ]
})
