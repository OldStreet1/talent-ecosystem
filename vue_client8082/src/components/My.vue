<template>
  <div class="index">
    <a href="#up">
      <div class="toup"></div>
    </a><a name="up"></a>

    <div class="header">
      <router-link class="talent" to="Home">人才生态圈</router-link>
      <router-link class="home" to="Home">首页</router-link>
      <router-link class="post" to="Post">职位</router-link>
      <router-link class="university" to="University">校园</router-link>
      <router-link class="enterprise" to="enterprise_login">企业</router-link>
      <router-link class="resume" to="Resume">简历</router-link>
      <router-link class="applet" to="Applet">小程序</router-link>
<!--      <router-link class="upload-resume" to="UploadResume">上传简历</router-link>-->
      <router-link class="recruit" to="Recruit">我要招聘</router-link>
      <router-link class="register" to="enterprise_register">注册</router-link>
      <router-link class="elogin" to="enterprise_login">登录</router-link>
      <router-link class="elogin" to="school_login">高校入口</router-link>
      <router-link class="elogin" to="AdminUser">后台管理</router-link>
      <router-link class="my" to="My">个人中心</router-link>
    </div>

    <div class="content">
      <div class="centre">
        <h2>个人中心</h2>
        <div class="slideshow">
          <el-carousel height="120px">
            <el-carousel-item v-for="(item, index) in list_img" :key="index">
              <h3 class="small">
                <img :src="item.url" alt/>
              </h3>
            </el-carousel-item>
          </el-carousel>
        </div>
        <div class="main">
          <div class="head">
            <img src="../assets/images/qq.png" class="headimg" alt="">
          </div>
          <div class="menus">
            <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                     :collapse="isCollapse" router :default-active="this.$route.path">
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span slot="title">个人操作</span>
                </template>
                <el-menu-item index="/AInfo">企业信息</el-menu-item>
                <el-menu-item index="/BMap">查找地址</el-menu-item>
                <el-menu-item index="1-4">投递简历</el-menu-item>
                <el-menu-item index="1-5">查看已投简历</el-menu-item>
              </el-submenu>
              <el-menu-item index="/Chat">
                <i class="el-icon-chat-dot-round"></i>
                <span slot="title">即时通讯</span>
              </el-menu-item>
              <el-menu-item index="/ChangePwd">
                <i class="el-icon-edit"></i>
                <span slot="title">修改密码</span>
              </el-menu-item>
              <el-menu-item @click="logout()">
                <i class="el-icon-close"></i>
                <span slot="title">退出登录</span>
              </el-menu-item>
            </el-menu>
          </div>
        </div>
        <div class="place">
          <router-view></router-view>
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
      <router-link to="My">
        <img class="apps" src="../assets/images/apps.png" alt="">
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'My',
  data() {
    return {
      list_img: [
        {url: require('../assets/images/1.jpg')},
        {url: require('../assets/images/2.jpg')},
        {url: require('../assets/images/3.jpg')},
        {url: require('../assets/images/4.jpg')},
      ],
      isCollapse: false
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    logout() {
      this.$confirm('请问是否确定退出登录?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '退出登录成功!',
        });
        this.$router.push({path: "/Home"})
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消退出登录'
        });
      });
    }
  }
}
</script>

<style scoped>
.index {
  width: 100%;
  height: 1000px;
  /*background-color: #40E0D0;*/
  background-image: url("../assets/images/back.jpg");
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

.content {
  width: 100%;
  height: 920px;
}

.centre {
  width: 1000px;
  height: 920px;
  margin: 0 auto;
}

h2 {
  margin: 0;
  padding-top: 20px;
}

.slideshow {
  width: 1000px;
  margin: 0 auto;
}

.main {
  width: 1000px;
  height: 700px;
  background-color: white;
  position: absolute;
  left: 452px;
}

.head {
  margin-left: -800px;
}

.headimg {
  width: 60px;
  height: 60px;
  margin-top: 20px;
}

.menus {
  margin-top: 20px;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.place {
  width: 800px;
  height: 700px;
  background-color: lightcyan;
  position: absolute;
  left: 652px;
  z-index: auto;
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
