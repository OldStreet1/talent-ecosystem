<template>
  <div class="index">
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
export default {
  name: "Applet"
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
  height: 900px
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
