// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import qs from 'qs';
import VueResource from 'vue-resource'
Vue.use(VueResource)
// 导入 ElementUI
import ElementUI from 'element-ui'
// // 导入CSS
import 'element-ui/lib/theme-chalk/index.css'
import VueCookies from 'vue-cookies'

// 安装 ElementUI
Vue.use(ElementUI);
//导入百度地图
import BaiduMap from 'vue-baidu-map'
Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: '9ygaVfsdOPiLV3aK1KQ0WOh5NPRMaIM1'
})
Vue.use(VueCookies)
import AdminUser from "./components/admin/AdminUser";
// 程序主路口
Vue.config.productionTip = false
Vue.prototype.$qs = qs;
Vue.prototype.$axios = axios;
axios.defaults.baseURL='api';

/* eslint-disable no-new */
new Vue({
  el: '#adminUser',
  router:router,
  // 渲染到
  render: h => h(App)
}).$mount("#adminUser")
