<template>
  <div class="index">
    <div class="header">
      <router-link class="talent" to="Home">人才生态圈</router-link>
      <router-link class="home" to="Home">首页</router-link>
      <router-link class="post" to="Post">岗位</router-link>
      <router-link class="university" to="University">校园</router-link>
      <router-link class="enterprise" to="Enterprise">企业</router-link>
      <router-link class="resume" to="Resume">简历</router-link>
      <router-link class="applet" to="Applet">小程序</router-link>
      <router-link class="upload-resume" to="UploadResume">上传简历</router-link>
      <router-link class="recruit" to="Recruit">我要招聘</router-link>
      <router-link class="register" to="Register">注册</router-link>
      <router-link class="elogin" to="ELogin">登录</router-link>
    </div>
    <div class="up">
      <el-dropdown>
        <span class="el-dropdown-link">
          请选择<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>求职</el-dropdown-item>
          <el-dropdown-item>招聘</el-dropdown-item>
          <el-dropdown-item>简历</el-dropdown-item>
          <el-dropdown-item disabled>企业</el-dropdown-item>
          <el-dropdown-item divided>高校</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <input class="search" type="text" aria-valuetext="123456"></input>
      <el-button class="searchbtn" type="primary" icon="el-icon-search">搜索</el-button>
    </div>
    <div class="slideshow">
<!--        <el-radio-group v-model="tabPosition" style="margin-bottom: 30px;">-->
<!--          <el-radio-button label="top">top</el-radio-button>-->
<!--          <el-radio-button label="right">right</el-radio-button>-->
<!--          <el-radio-button label="bottom">bottom</el-radio-button>-->
<!--          <el-radio-button label="left">left</el-radio-button>-->
<!--        </el-radio-group>-->

        <el-tabs :tab-position="tabPosition" style="height: 200px;">
          <el-tab-pane label="用户管理">用户管理</el-tab-pane>
          <el-tab-pane label="配置管理">配置管理</el-tab-pane>
          <el-tab-pane label="角色管理">角色管理</el-tab-pane>
          <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
        </el-tabs>
      <el-carousel height="400px">
        <el-carousel-item v-for="(item, index) in list_img" :key="index">
          <h3 class="small">
            <img :src="item.url" alt/>
          </h3>
        </el-carousel-item>
      </el-carousel>
    </div>

  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      list_img: [
        {url: require('../../assets/1.jpg')},
        {url: require('../../assets/2.jpg')},
        {url: require('../../assets/3.jpg')},
        {url: require('../../assets/4.jpg')},
      ],
      tabPosition: 'left'
    }
  },
}
</script>

<style scoped>
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

.talent {
  color: #40E0D0;
  font-size: 26px;
  font-family: 楷体;
  font-weight: bold;
  margin-left: 20px;
  line-height: 50px;
  text-decoration: none;
}

.header .home, .post, .university, .enterprise, .resume, .applet {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 20px;
  line-height: 50px;
  text-decoration: none;
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

.up {
  width: 100%;
  height: 80px;
  margin: 0 auto;
  background-color: #40E0D0;
}

.el-dropdown-link {
  line-height: 50px;
  font-size: 16px;
  cursor: pointer;
  color: black;
}

.el-icon-arrow-down {
  font-size: 16px;
}

.search {
  width: 300px;
  height: 40px;
  line-height: 80px;
  font-size: 16px;
  margin-top: 20px;
  border: none;
}

.searchbtn {
  font-size: 16px;
}

.slideshow {
  width: 600px;
  margin-left: 800px;
  margin-top: 20px;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}


</style>
