import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BMap from "../components/enterprise/BMap";
import AInfo from "../components/enterprise/AInfo";
import Recharge from "../components/enterprise/Recharge";
import enterprise_login from "../components/enterprise/enterprise_login";
import enterprise_register from "../components/enterprise/enterprise_register";
import school_login from "../components/school/school_login";
import school_reg from "../components/school/school_reg";
import student_admin from "../components/school/student_admin";
import Home from "../components/Home"
import My from "../components/My"
import AdminUser from "../components/admin/AdminUser";
import Chat from "../components/enterprise/Chat";
import enterprise_intro from "../components/enterprise/enterprise_intro";

Vue.use(Router)

export default new Router({
  mode:"history",  //不带#号
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {//地图组件
      path: '/BMap',
      name: 'BMap',
      component: BMap
    },
    {
      path: '/enterprise_login',
      name: 'enterprise_login',
      component: enterprise_login
    },
    {//账户信息
      path: '/AInfo',
      name: 'AInfo',
      component: AInfo
    },
    {
      path:'/school_login',
      name: 'school_login',
      component: school_login
    },
    {
      path: '/enterprise_register',
      name: 'enterprise_register',
      component: enterprise_register
    },
    {path:'/school_reg',
      name: 'school_reg',
      component: school_reg
    },
    {path:'/student_admin',
      name: 'student_admin',
      component: student_admin,
      children:[
        {path:'/sAdmin_Message',name:'sAdmin_Message',component:()=>import ('../components/school/sAdmin_Message')},
        {path:'/sAdmin_Export',name:'sAdmin_Export',component:()=>import ('../components/school/sAdmin_Export')},
      ]
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
    //支付页面
    {
      path: '/Recharge',
      name: 'Recharge',
      component: Recharge
    },
    //聊天页面
    {
      path: '/Chat',
      name: 'Chat',
      component: Chat
    },
    //聊天页面
    {
      path: '/intro',
      name: 'intro',
      component: enterprise_intro
    },
  ]
})
