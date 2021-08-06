import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import enterprise_login from "../components/enterprise/enterprise_login";
import enterprise_register from "../components/enterprise/enterprise_register";
import Home from "../components/Home"
import My from "../components/My"

Vue.use(Router)

export default new Router({
  mode:"history",  //不带#号
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/enterprise_login',
      name: 'enterprise_login',
      component: enterprise_login
    },
    {
      path: '/enterprise_register',
      name: 'enterprise_register',
      component: enterprise_register
    },
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home
    },
    {
      path: '/My',
      name: 'My',
      component: My
    },
  ]
})
