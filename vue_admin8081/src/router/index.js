import Vue from 'vue'
import Router from 'vue-router'

import enterprise_login from "../components/enterprise/enterprise_login";
import admin_login from "../components/admin/admin_login";
import Sidentify from "../components/admin/Sidentify";
import Register from "../components/admin/Register";
import AdminUser from "../components/admin/AdminUser";
import PowerManagement from "../components/admin/PowerManagement";
Vue.use(Router)

export default new Router({
  mode:"history",  //不带#号
  routes: [
    {
      path: '/',
      name: 'PowerManagement',
      component: PowerManagement
    },
    {
      path: '/enterprise_login',
      name: 'enterprise_login',
      component: enterprise_login
    },
    {
      path: '/admin_login',
      name: 'admin_login',
      component: admin_login
    },
    {path:"/Sidentify", name: 'Sidentify', component :Sidentify} ,
    {path:"/Register", name: 'Register', component :Register} ,
    {path:"/AdminUser", name: 'Register', component :AdminUser} ,
    {path:"/PowerManagement", name: 'PowerManagement', component :PowerManagement} ,
  ]
})
