import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Amap from "../components/enterprise/Amap";
import BMap from "../components/enterprise/BMap";
import AInfo from "../components/enterprise/AInfo";
import Recharge from "../components/enterprise/Recharge";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {//地图组件
      path: '/Amap',
      name: 'Amap',
      component: Amap
    },
    {//地图组件
      path: '/BMap',
      name: 'BMap',
      component: BMap
    },
    {//账户信息
      path: '/AInfo',
      name: 'AInfo',
      component: AInfo
    },
    {//支付页面
      path: '/Recharge',
      name: 'Recharge',
      component: Recharge
    },
  ]
})
