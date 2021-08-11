import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import enterprise_login from "../components/enterprise/enterprise_login";
import enterprise_register from "../components/enterprise/enterprise_register";
import school_login from "../components/school/school_login";
import school_reg from "../components/school/school_reg";
import student_admin from "../components/school/student_admin";
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
    {
      path: '/enterprise_register',
      name: 'enterprise_register',
      component: enterprise_register
    },
    // {path:'/',
    //   name: 'school_login',
    //   component: school_login
    // },
    {path:'/school_login',
      name: 'school_login',
      component: school_login
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
        {path:'/sAdmin_Introduction',name:'sAdmin_Introduction',component:()=>import ('../components/school/sAdmin_Introduction')},
      ]
    },
  ]
})
