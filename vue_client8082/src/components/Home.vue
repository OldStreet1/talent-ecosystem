<template>
  <div class="index" style="margin: 0">
    <a href="#up"><div class="toup"></div></a>
    <a name="up"></a>

    <div class="header">
      <router-link class="talent" to="Home">人才生态圈</router-link>
      <router-link class="home" to="Home">首页</router-link>
      <router-link class="post" to="Post">岗位</router-link>
      <router-link class="university" to="University">校园</router-link>
      <router-link class="enterprise" to="enterprise_login">企业</router-link>
      <router-link class="resume" to="Resume">简历</router-link>
      <router-link class="applet" to="Applet">小程序</router-link>
      <router-link class="upload-resume" to="UploadResume">上传简历</router-link>
      <router-link class="recruit" to="Recruit">我要招聘</router-link>
      <router-link class="register" to="enterprise_register">注册</router-link>
      <router-link class="elogin" to="enterprise_login">登录</router-link>
      <router-link class="elogin" to="school_login">高校入口</router-link>
      <router-link class="elogin" to="AdminUser">后台管理</router-link>
      <router-link class="my" to="My">个人中心</router-link>
    </div>

    <div class="main">
      <div class="up">
        <span class="demonstration"></span>
        <el-cascader
          class="select"
          v-model="value"
          :options="options"
          :props="{ expandTrigger: 'hover' }"
          @change="handleChange"></el-cascader>
        <input class="search" type="text" aria-valuetext="123456" placeholder="搜索职位、简历、企业、高校"></input>
        <el-button class="searchbtn" type="primary" icon="el-icon-search">搜索</el-button>
        <div class="hotdiv">
          <span class="hot">*热门职位：</span>
          <span class="hots">
          HTML5&emsp;
          C#&emsp;
          Web前端&emsp;
          Web前端培训讲师&emsp;
          Java&emsp;
          IOS&emsp;
          JavaScript&emsp;
          Node.js&emsp;
          Android</span>
        </div>
      </div>

      <div class="navigation">
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                 :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">导航一</span>
            </template>
            <el-menu-item-group>
              <span slot="title">分组一</span>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <span slot="title">选项4</span>
              <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
        </el-menu>
      </div>

      <div class="slideshow">
        <el-carousel height="224px">
          <el-carousel-item v-for="(item, index) in list_img" :key="index">
            <h3 class="small">
              <img :src="item.url" alt/>
            </h3>
          </el-carousel-item>
        </el-carousel>
      </div>

      <div class="hot-recruit">
        <h2>——热招职位——</h2>
        <div class="recruit"></div>
        <div class="recruit"></div>
        <div class="recruit"></div>
        <div class="recruit"></div>
        <div class="recruit"></div>
        <div class="recruit"></div>
      </div>

      <div class="hot-enterprise">
        <h2>——热门企业——</h2>
        <div class="enterprise"></div>
        <div class="enterprise"></div>
        <div class="enterprise"></div>
        <div class="enterprise"></div>
        <div class="enterprise"></div>
        <div class="enterprise"></div>
      </div>
    </div>

    <div class="footer">
      <h1>人才生态圈</h1>
      <span class="call-us">联系电话：2021-8080808</span>
      <span class="come-us">联系地址：厦门市思明区望海路25-2软件园2期</span>
      <a href="#"><div class="wechat"></div></a>
      <a href="#"><div class="weibo"></div></a>
      <a href="#"><div class="apps"></div></a>
    </div>
  </div>

</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      list_img: [
        {url: require('../assets/images/1.jpg')},
        {url: require('../assets/images/2.jpg')},
        {url: require('../assets/images/3.jpg')},
        {url: require('../assets/images/4.jpg')},
      ],

      isCollapse: true,

      tabPosition: 'left',
      value: [],
      options: [{
        value: 'zhinan',
        label: '简历',
        children: [{
          value: 'shejiyuanze',
          label: '设计原则',
          children: [{
            value: 'yizhi',
            label: '一致'
          }, {
            value: 'fankui',
            label: '反馈'
          }, {
            value: 'xiaolv',
            label: '效率'
          }, {
            value: 'kekong',
            label: '可控'
          }]
        }, {
          value: 'daohang',
          label: '导航',
          children: [{
            value: 'cexiangdaohang',
            label: '侧向导航'
          }, {
            value: 'dingbudaohang',
            label: '顶部导航'
          }]
        }]
      }, {
        value: 'zujian',
        label: '企业',
        children: [{
          value: 'basic',
          label: 'Basic',
          children: [{
            value: 'layout',
            label: 'Layout 布局'
          }, {
            value: 'color',
            label: 'Color 色彩'
          }, {
            value: 'typography',
            label: 'Typography 字体'
          }, {
            value: 'icon',
            label: 'Icon 图标'
          }, {
            value: 'button',
            label: 'Button 按钮'
          }]
        }, {
          value: 'form',
          label: 'Form',
          children: [{
            value: 'radio',
            label: 'Radio 单选框'
          }, {
            value: 'checkbox',
            label: 'Checkbox 多选框'
          }, {
            value: 'input',
            label: 'Input 输入框'
          }, {
            value: 'input-number',
            label: 'InputNumber 计数器'
          }, {
            value: 'select',
            label: 'Select 选择器'
          }, {
            value: 'cascader',
            label: 'Cascader 级联选择器'
          }, {
            value: 'switch',
            label: 'Switch 开关'
          }, {
            value: 'slider',
            label: 'Slider 滑块'
          }, {
            value: 'time-picker',
            label: 'TimePicker 时间选择器'
          }, {
            value: 'date-picker',
            label: 'DatePicker 日期选择器'
          }, {
            value: 'datetime-picker',
            label: 'DateTimePicker 日期时间选择器'
          }, {
            value: 'upload',
            label: 'Upload 上传'
          }, {
            value: 'rate',
            label: 'Rate 评分'
          }, {
            value: 'form',
            label: 'Form 表单'
          }]
        }, {
          value: 'data',
          label: 'Data',
          children: [{
            value: 'table',
            label: 'Table 表格'
          }, {
            value: 'tag',
            label: 'Tag 标签'
          }, {
            value: 'progress',
            label: 'Progress 进度条'
          }, {
            value: 'tree',
            label: 'Tree 树形控件'
          }, {
            value: 'pagination',
            label: 'Pagination 分页'
          }, {
            value: 'badge',
            label: 'Badge 标记'
          }]
        }, {
          value: 'notice',
          label: 'Notice',
          children: [{
            value: 'alert',
            label: 'Alert 警告'
          }, {
            value: 'loading',
            label: 'Loading 加载'
          }, {
            value: 'message',
            label: 'Message 消息提示'
          }, {
            value: 'message-box',
            label: 'MessageBox 弹框'
          }, {
            value: 'notification',
            label: 'Notification 通知'
          }]
        }, {
          value: 'navigation',
          label: 'Navigation',
          children: [{
            value: 'menu',
            label: 'NavMenu 导航菜单'
          }, {
            value: 'tabs',
            label: 'Tabs 标签页'
          }, {
            value: 'breadcrumb',
            label: 'Breadcrumb 面包屑'
          }, {
            value: 'dropdown',
            label: 'Dropdown 下拉菜单'
          }, {
            value: 'steps',
            label: 'Steps 步骤条'
          }]
        }, {
          value: 'others',
          label: 'Others',
          children: [{
            value: 'dialog',
            label: 'Dialog 对话框'
          }, {
            value: 'tooltip',
            label: 'Tooltip 文字提示'
          }, {
            value: 'popover',
            label: 'Popover 弹出框'
          }, {
            value: 'card',
            label: 'Card 卡片'
          }, {
            value: 'carousel',
            label: 'Carousel 走马灯'
          }, {
            value: 'collapse',
            label: 'Collapse 折叠面板'
          }]
        }]
      }, {
        value: 'ziyuan',
        label: '高校',
        children: [{
          value: 'axure',
          label: 'Axure Components'
        }, {
          value: 'sketch',
          label: 'Sketch Templates'
        }, {
          value: 'jiaohu',
          label: '组件交互文档'
        }]
      }]
    }
  },
  methods: {
    handleChange (value) {
      console.log(value)
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
.index {
  width: 100%;
  height: 1800px;
  background-color: #40E0D0;
  margin: 0 auto;
  /*background-image: url("../assets/back.jpg");*/
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 0px;
  margin: 0;
}

el-carousel__container {
  height: 100px;
}

.header {
  width: 100%;
  height: 50px;
  background-color: black;
  color: white;
}

.main {
  width: 1200px;
  height: 1565px;
  margin: 0 auto;
  /*background-color: black;*/
}

.talent {
  color: #40E0D0;
  font-size: 26px;
  font-family: 楷体;
  font-weight: bold;
  line-height: 50px;
  text-decoration: none;
}

.home, .post, .university, .enterprise, .resume, .applet {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 20px;
  line-height: 50px;
  text-decoration: none;
}

.home:hover, .post:hover, .university:hover, .enterprise:hover, .resume:hover, .applet:hover, .upload-resume:hover, .recruit:hover, .elogin:hover, .register:hover, .my:hover {
  color: #40E0D0;
}

.upload-resume {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 100px;
  line-height: 50px;
  text-decoration: none;
}

.recruit {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 20px;
  line-height: 50px;
  text-decoration: none;
}

.register {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 100px;
  line-height: 50px;
  text-decoration: none;
}

.elogin {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 30px;
  line-height: 50px;
  text-decoration: none;
}

.my {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 160px;
  line-height: 50px;
  text-decoration: none;
}

.up {
  width: 100%;
  height: 100px;
  margin: 0 auto;
  /*background-color: #40E0D0;*/
}

.select {
  width: 120px;
  margin-right: -2px;
}

.search {
  width: 600px;
  height: 40px;
  line-height: 80px;
  font-size: 16px;
  margin-top: 20px;
  border: none;
}

.searchbtn {
  font-size: 16px;
  margin-left: -4px;
}

.hotdiv {
  margin-top: 10px;
}

.hot {
  color: red;
}

.hots {
  color: yellow;
}

.navigation {
  float: left;
}

.slideshow {
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.hot-recruit {
  width: 1200px;
  height: 600px;
  /*background-color: black;*/
}

.hot-recruit h2 {
  line-height: 40px;
}

.hot-recruit .recruit {
  width: 373px;
  height: 250px;
  margin: 0 0 20px 20px;
  background-color: white;
  float: left;
}

.hot-enterprise {
  width: 1200px;
  height: 600px;
  /*background-color: black;*/
}

.hot-enterprise h2 {
  line-height: 40px;
}

.hot-enterprise .enterprise {
  width: 373px;
  height: 250px;
  margin: 0 0 20px 20px;
  background-color: white;
  float: left;
}

.footer {
  color: white;
  width: 100%;
  height: 165px;
  background-color: black;
}

.footer h1 {
  color: #40E0D0;
  font-family: 楷体;
  font-weight: bold;
  line-height: 50px;
}

.call-us {
  margin-right: 50px;
}

.wechat {
  margin-left: 1350px;
  margin-top: -35px;
  width: 50px;
  height: 50px;
  background-image: url("../assets/images/wechat.png");
}

.weibo {
  margin-left: 1400px;
  margin-top: -50px;
  width: 50px;
  height: 50px;
  background-image: url("../assets/images/weibo.png");
}

.apps {
  margin-left: 1450px;
  margin-top: -50px;
  width: 50px;
  height: 50px;
  background-image: url("../assets/images/apps.png");
}

.toup{
  width: 50px;
  height: 50px;
  position: fixed;
  margin-left: 1800px;
  margin-top: 850px;
  background-image: url("../assets/images/toup.png");
}
</style>
