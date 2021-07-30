// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// 导入elemntUI
import ElementUI from 'element-ui'
// // 导入CSS
import 'element-ui/lib/theme-chalk/index.css'
// 导入路由
import router from './router'
// 导入axios
import Axios from 'axios'
import AdminUser from "./components/admin/AdminUser";
// 程序主路口
Vue.config.productionTip = true
// 使用elementsui
Vue.use(ElementUI)
// 全局变量属性设置
Vue.prototype.$axios = Axios
// 定义基本路径
Axios.defaults.baseURI='api'

/* eslint-disable no-new */
// new Vue({
//   el: '#app',
//   router,
//   components: { App },
//   template: '<App/>'
// })
//
// new Vue({
//   el: '#adminUser',
//   render: h => h(AdminUser)
// });

new Vue({
  el: '#adminUser',
  router:router,
  // 渲染到
  render: h => h(App)
}).$mount("#adminUser")
