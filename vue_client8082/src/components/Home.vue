<template>
  <div class="index" style="margin: 0">
    <a href="#up">
      <div class="toup"></div>
    </a><a name="up"></a>

    <div class="header">
      <router-link class="talent" to="Home">人才生态圈</router-link>
      <router-link class="home" to="Home">首页</router-link>
      <router-link class="post" to="Recruit">职位</router-link>
      <router-link class="resume" to="Resume">简历</router-link>
      <router-link class="enterprise" to="Enterprise">企业</router-link>
      <router-link class="university" to="school_login">校园</router-link>
      <router-link class="applet" to="Applet">小程序</router-link>
      <!--      <router-link class="upload-resume" to="UploadResume">上传简历</router-link>-->
      <router-link class="recruit" to="enterprise_login">我要招聘</router-link>
      <router-link class="register" to="enterprise_register">注册</router-link>
      <router-link class="elogin" to="enterprise_login">登录</router-link>
      <router-link class="elogin" to="school_login">高校入口</router-link>
      <router-link class="elogin" to="AdminUser">后台管理</router-link>
      <router-link class="my" to="My">个人中心</router-link>
    </div>

    <div class="content">
      <div class="centre">
        <div class="up">
          <span class="demonstration"></span>
          <el-cascader
            class="select"
            v-model="value"
            :options="options"
            :props="{ expandTrigger: 'hover' }"
            @change="handleChange"></el-cascader>
          <el-input v-model="input" class="search" type="text" aria-valuetext="123456"
                    placeholder="搜索职位、简历、企业"></el-input>
          <el-button class="searchbtn" type="primary" icon="el-icon-search" @click="query()">搜索</el-button>
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
          <a href="#">
            <div class="recruits" v-for="(item,i) in hotRecruitData">
              <h2 ref="position" @click="toRecruit()">{{ item.position }}</h2>
              <span>学历要求：{{ item.education }}</span><br>
              <span>工作经验：{{ item.experience }}</span><br>
              <span>参考薪资：<span class="salary">{{ item.salary }}</span></span>
            </div>
          </a>
        </div>

        <div class="hot-enterprise">
          <h2>——热门企业——</h2>
          <router-link to="enterprise_intro">
            <div class="enterprises" v-for="(item,i) in hotEnterpriseData">
              <h2>{{item.enterprise_name}}</h2>
              <span>融资状态：{{item.enterprise_financing_stage}}</span><br>
              <span>经营范围：{{item.enterprise_recruitment_position}}</span><br>
              <span>地址：{{item.enterprise_address}}</span>
            </div>
          </router-link>
        </div>
      </div>
    </div>

    <div class="footer">
      <h1>人才生态圈</h1>
      <span class="call-us">联系电话：2021-8080808</span>
      <span class="come-us">联系地址：厦门市思明区望海路25-2软件园2期</span>
      <router-link to="Home">
        <img class="wechat" src="../assets/images/wechat.png" alt="">
      </router-link>
      <router-link to="Home">
        <img class="weibo" src="../assets/images/weibo.png" alt="">
      </router-link>
      <router-link to="Applet">
        <img class="apps" src="../assets/images/apps.png" alt="">
      </router-link>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Home',
  data() {
    return {
      input: '',
      list_img: [
        {url: require('../assets/images/p1.png')},
        {url: require('../assets/images/p2.png')},
        {url: require('../assets/images/p3.png')},
        {url: require('../assets/images/p4.png')},
      ],
      hotRecruitData: [{}],
      hotEnterpriseData: [],

      isCollapse: true,
      tabPosition: 'left',
      value: [],
      options: [
        {
          value: 'resume', label: '简历',
          children: [
            {
              value: 'education', label: '学历',
              children: [
                {value: 'ben', label: '本科'},
                {value: 'zhuan', label: '专科'}]
            },
            {
              value: 'work-exp', label: '工作经验',
              children: [
                {value: 'one-year', label: '1年'},
                {value: 'three-year', label: '3年'}]
            }]
        },
        {
          value: 'enterprise', label: '企业',
          children: [
            {
              value: 'basic', label: 'Basic',
              children: [
                {value: 'layout', label: 'Layout 布局'},
                {value: 'color', label: 'Color 色彩'},
                {value: 'typography', label: 'Typography 字体'},
                {value: 'icon', label: 'Icon 图标'},
                {value: 'button', label: 'Button 按钮'}]
            },
            {
              value: 'form', label: 'Form',
              children: [
                {value: 'radio', label: 'Radio 单选框'},
                {value: 'checkbox', label: 'Checkbox 多选框'},
                {value: 'input', label: 'Input 输入框'},
                {value: 'input-number', label: 'InputNumber 计数器'},
                {value: 'select', label: 'Select 选择器'},
                {value: 'cascader', label: 'Cascader 级联选择器'},
                {value: 'switch', label: 'Switch 开关'},
                {value: 'slider', label: 'Slider 滑块'},
                {value: 'time-picker', label: 'TimePicker 时间选择器'},
                {value: 'date-picker', label: 'DatePicker 日期选择器'},
                {value: 'datetime-picker', label: 'DateTimePicker 日期时间选择器'},
                {value: 'upload', label: 'Upload 上传'},
                {value: 'rate', label: 'Rate 评分'},
                {value: 'form', label: 'Form 表单'}]
            },
            {
              value: 'data', label: 'Data',
              children: [
                {value: 'table', label: 'Table 表格'},
                {value: 'tag', label: 'Tag 标签'},
                {value: 'progress', label: 'Progress 进度条'},
                {value: 'tree', label: 'Tree 树形控件'},
                {value: 'pagination', label: 'Pagination 分页'},
                {value: 'badge', label: 'Badge 标记'}]
            },
            {
              value: 'notice', label: 'Notice',
              children: [
                {value: 'alert', label: 'Alert 警告'},
                {value: 'loading', label: 'Loading 加载'},
                {value: 'message', label: 'Message 消息提示'},
                {value: 'message-box', label: 'MessageBox 弹框'},
                {value: 'notification', label: 'Notification 通知'}]
            },
            {
              value: 'navigation', label: 'Navigation',
              children: [
                {value: 'menu', label: 'NavMenu 导航菜单'},
                {value: 'tabs', label: 'Tabs 标签页'},
                {value: 'breadcrumb', label: 'Breadcrumb 面包屑'},
                {value: 'dropdown', label: 'Dropdown 下拉菜单'},
                {value: 'steps', label: 'Steps 步骤条'}]
            },
            {
              value: 'others', label: 'Others',
              children: [
                {value: 'dialog', label: 'Dialog 对话框'},
                {value: 'tooltip', label: 'Tooltip 文字提示'},
                {value: 'popover', label: 'Popover 弹出框'},
                {value: 'card', label: 'Card 卡片'},
                {value: 'carousel', label: 'Carousel 走马灯'},
                {value: 'collapse', label: 'Collapse 折叠面板'}]
            }]
        },
        {
          value: 'ziyuan', label: '高校',
          children: [
            {value: 'axure', label: 'Axure Components'},
            {value: 'sketch', label: 'Sketch Templates'},
            {value: 'jiaohu', label: '组件交互文档'}]
        }]
    }
  },
  created() {
    this.getHotRecruit()
    this.getHotEnterprise()
  },
  methods: {
    handleChange(value) {
      console.log(value)
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath)
    },
    query: function () {
      console.log(this.input)
      this.$axios.post("/recruit/queryRecruit",
      this.$qs.stringify({
        action:'query',
        position:this.input
      })
      ).then(response=>{
        console.log(response)
        this.$router.push({path:"/Recruit"})
      }).catch(error=>{
        console.log(error)
      })
    },
    getHotRecruit: function () {
      this.$axios.post("/recruit/hotRecruit"
      ).then(response => {
        console.log(response)
        this.hotRecruitData = response.data
      }).catch(error => {
        console.log(error)
      })
    },
    getHotEnterprise: function () {
      this.$axios.post("/enterprise/hotEnterprise"
      ).then(response => {
        console.log(response)
        this.hotEnterpriseData = response.data
      }).catch(error => {
        console.log(error)
      })
    },
    toRecruit(){
      console.log(this.$refs.position.innerHTML)
    }
  }
}
</script>

<style scoped>
.index {
  width: 100%;
  height: 1800px;
  margin: 0 auto;
  background-image: url("../assets/images/back.jpg");
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
  height: 80px;
  background-color: #2c3e50;
  color: white;
}

.talent {
  color: #40E0D0;
  font-size: 26px;
  font-family: 楷体;
  font-weight: bold;
  line-height: 80px;
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

.centre {
  width: 1200px;
  height: 1565px;
  margin: 0 auto;
  /*background-color: black;*/
}

.up {
  width: 100%;
  height: 100px;
  margin: 0 auto;
  /*background-color: #40E0D0;*/
}

.select {
  width: 160px;
  margin-right: -2px;
}

.search {
  width: 600px;
  height: 40px;
  /*line-height: 80px;*/
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

.hot-recruit .recruits {
  width: 373px;
  height: 250px;
  margin: 0 0 20px 20px;
  background-color: white;
  /*background-color: #40E0D0;*/
  float: left;
}

.hot-recruit .recruits h2{
  color: #40E0D0;
}

.hot-recruit .recruits span{
  color: black;
  line-height: 50px;
}

.hot-recruit .recruits .salary{
  color: red;
}

.hot-enterprise {
  width: 1200px;
  height: 600px;
  /*background-color: black;*/
}

.hot-enterprise h2 {
  line-height: 40px;
}

.hot-enterprise .enterprises {
  width: 373px;
  height: 250px;
  margin: 0 0 20px 20px;
  background-color: white;
  color: #40E0D0;
  /*background-color: #40E0D0;*/
  float: left;
}

.hot-enterprise .enterprises h2{
  color: #40E0D0;
}

.hot-enterprise .enterprises span{
  color: black;
  line-height: 50px;
}

.footer {
  color: white;
  width: 100%;
  height: 165px;
  background-color: #2c3e50;
  position: absolute;
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
  width: 50px;
  height: 50px;
  position: absolute;
  top: 80px;
  left: 1350px;
}

.weibo {
  width: 50px;
  height: 50px;
  position: absolute;
  top: 80px;
  left: 1400px;
}

.apps {
  width: 50px;
  height: 50px;
  position: absolute;
  top: 80px;
  left: 1450px;
}

.toup {
  width: 50px;
  height: 50px;
  position: fixed;
  margin-left: 1800px;
  margin-top: 850px;
  z-index: 99;
  background-image: url("../assets/images/toup.png");
}
</style>
