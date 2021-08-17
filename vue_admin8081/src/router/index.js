import Vue from 'vue'
import Router from 'vue-router'

import enterprise_login from "../components/enterprise/enterprise_login";
import admin_login from "../components/admin/admin_login";
import Sidentify from "../components/admin/Sidentify";
import Register from "../components/admin/Register";
import AdminUser from "../components/admin/AdminUser";
Vue.use(Router)

export default new Router({
  mode:"history",  //不带#号
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    // {
    //   path: '/enterprise_login',
    //   name: 'enterprise_login',
    //   component: enterprise_login
    // },
    {path:'/adminUser',name:'adminUser',component:() => import('../components/admin/AdminUser')},
    {path:"/adminUser",name:'AdminUser',component: AdminUser,children:[
        {path:"/adminGwgl",name:'adminGwgl',component:() => import('../components/admin/Menu') },
        {path:"/adminqiyegl",name:'adminqiyegl',component:() => import('../components/admin/AdminQiye')},
        {path:"/adminmoc",name:'adminmoc',component:() => import('../components/admin/AdminMoc')},
        {path:"/adminsta",name:'adminsta',component:() => import('../components/admin/AdmimSta')},
        {path:"/adminalluser",name:'adminalluser',component:() => import('../components/admin/AdminAlluser')},
        {path:"/adminjobw",name:'adminjobw',component:() => import('../components/admin/AdminJobwant')},
      ]},
    {
      path: '/',
      name: 'admin_login',
      component: admin_login
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
  ]
})
