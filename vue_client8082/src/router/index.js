import Vue from 'vue'
import Router from 'vue-router'
import AdminUser from "../components/admin/AdminUser";
Vue.use(Router)
const routers=[
// 主界面
  {path:'/',name:'adminUser',component:AdminUser},
  {path:"/adminUser",name:'AdminUser',component: AdminUser,children:[
      {path:"/adminGwgl",name:'adminGwgl',component:() => import('../components/admin/Menu') },
      {path:"/adminqiyegl",name:'adminqiyegl',component:() => import('../components/admin/AdminQiye')},
      {path:"/adminmoc",name:'adminmoc',component:() => import('../components/admin/AdminMoc')},
      {path:"/adminsta",name:'adminsta',component:() => import('../components/admin/AdmimSta')},
      {path:"/adminalluser",name:'adminalluser',component:() => import('../components/admin/AdminAlluser')},
      {path:"/adminjobw",name:'adminjobw',component:() => import('../components/admin/AdminJobwant')},
    ]},

]
// 添加路由，访问根路径时就是首页
export default new Router({
  mode:'history',
  routes:routers
})
