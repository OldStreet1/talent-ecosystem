import Vue from 'vue'
import Router from 'vue-router'
import enterprise_login from "../components/enterprise/enterprise_login";
import enterprise_register from "../components/enterprise/enterprise_register";
import school_login from "../components/school/school_login";
import school_reg from "../components/school/school_reg";
import student_admin from "../components/school/student_admin";
import Home from "../components/Home"
import My from "../components/My"
import AdminUser from "../components/admin/AdminUser";

Vue.use(Router)

export default new Router({
  mode:"history",  //不带#号
  routes: [
    {path: '/', name: 'Home', component: Home,},
    {path: '/Home', name: 'Home', component: Home},
    {path:'/UResume',name:'UResume',component:()=>import ('../components/enterprise/UserResume')},

    {path:'/Recruit',name:'Recruit',component:()=>import ('../components/Recruit')},
    {path:'/Resume',name:'Resume',component:()=>import ('../components/Resume')},
    {path:'/Enterprise',name:'Enterprise',component:()=>import ('../components/Enterprise')},
    {path:'/Applet',name:'Applet',component:()=>import ('../components/Applet')},
    {path:'/enterprise_intro',name:'enterprise_intro',component:()=>import ('../components/enterprise/enterprise_intro')},
    {path: '/My', name: 'My', component: My,
      children:[
        {path:'/AInfo',name:'AInfo',component:()=>import ('../components/enterprise/AInfo')},
        {path:'/Chat',name:'Chat',component:()=>import ('../components/enterprise/Chat')},
        {path:'/BMap',name:'BMap',component:()=>import ('../components/enterprise/BMap')},
        {path:'/Recharge',name:'Recharge',component:()=>import ('../components/enterprise/Recharge')},
        {path:'/look',name:'look',component:()=>import ('../components/enterprise/Resume_look')},
        {path:'/ChangePwd',name:'ChangePwd',component:()=>import ('../components/enterprise/ChangePwd')},
      ]
    },
    {path: '/enterprise_login', name: 'enterprise_login', component: enterprise_login},
    {path: '/enterprise_register', name: 'enterprise_register', component: enterprise_register},
    {path:'/school_login', name: 'school_login', component: school_login},
    {path:'/school_reg', name: 'school_reg', component: school_reg},
    {path:'/student_admin', name: 'student_admin', component: student_admin,
      children:[
        {path:'/sAdmin_Message',name:'sAdmin_Message',component:()=>import ('../components/school/sAdmin_Message')},
        {path:'/sAdmin_Export',name:'sAdmin_Export',component:()=>import ('../components/school/sAdmin_Export')},
      ]
    },
    {path: '/AdminUser', name: 'AdminUser', component: AdminUser,
      children:[
        {path:'/AdminQiye',name:'AdminQiye',component:()=>import ('../components/admin/AdminQiye')},
        {path:'/AdminMoc',name:'AdminMoc',component:()=>import ('../components/admin/AdminMoc')},
        {path:'/AdminAllUser',name:'AdminAllUser',component:()=>import ('../components/admin/AdminAllUser')},
        {path:'/AdminJobWant',name:'AdminJobWant',component:()=>import ('../components/admin/AdminJobWant')},
        {path:'/AdminSta',name:'AdminSta',component:()=>import ('../components/admin/AdminSta')},
      ]
    },
  ]
})
