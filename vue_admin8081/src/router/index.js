import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import enterprise_login from "../components/enterprise/enterprise_login";
import AdminUser from "../../../vue_client8082/src/components/admin/AdminUser";
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
    {path:'/',name:'adminUser',component:() => import('../components/admin/AdminUser')},
    {path:"/adminUser",name:'AdminUser',component: AdminUser,children:[
        {path:"/adminGwgl",name:'adminGwgl',component:() => import('../components/admin/Menu') },
        {path:"/adminqiyegl",name:'adminqiyegl',component:() => import('../components/admin/AdminQiye')},
        {path:"/adminmoc",name:'adminmoc',component:() => import('../components/admin/AdminMoc')},
        {path:"/adminsta",name:'adminsta',component:() => import('../components/admin/AdmimSta')},
        {path:"/adminalluser",name:'adminalluser',component:() => import('../components/admin/AdminAlluser')},
        {path:"/adminjobw",name:'adminjobw',component:() => import('../components/admin/AdminJobwant')},
      ]},
  ]
})
