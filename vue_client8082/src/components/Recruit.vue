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
      <div class="up">
        <el-input v-model="input" class="search" type="text" aria-valuetext="123456"
                  placeholder="搜索职位"></el-input>
        <el-button class="searchbtn" type="primary" icon="el-icon-search" @click="query()">搜索</el-button>
      </div>

      <div class="main">
          <div class="recruits" v-for="(item,i) in recruitsData" @click="showInfo">
            <h2 ref="position" @click="toRecruit()">{{ item.position }}</h2>
            <span>学历要求：{{ item.education }}</span><br>
            <span>工作经验：{{ item.experience }}</span><br>
            <span>参考薪资：<span class="salary">{{ item.salary }}</span></span>
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

    <RecruitInfo v-if="dialogVisible" ref="RecruitInfo"></RecruitInfo>
  </div>
</template>

<script>
import RecruitInfo from "./RecruitInfo";
export default {
  name: "Recruit",
  components:{
    RecruitInfo
  },
  data() {
    return {
      dialogVisible:false,
      input: '',
      recruitsData: [],
    }
  },
  created() {
    this.getRecruits()
  },
  methods: {
    getRecruits: function () {
      this.$axios.post("/recruit/recruits"
      ).then(response => {
        console.log(response)
        this.recruitsData = response.data
      }).catch(error => {
        console.log(error)
      })
    },
    showInfo() {
      this.dialogVisible = true;
      this.$nextTick(() => {
        this.$refs.RecruitInfo.init();
      });
    },
    query: function () {
      console.log(this.input)
      this.$axios.post("/recruit/queryRecruit",
        this.$qs.stringify({
          action: 'query',
          position: this.input
        })
      ).then(response=>{
        console.log(response)
        this.recruitsData = response.data
        this.$router.push({path:"/Recruit"})
      }).catch(error=>{
        console.log(error)
      })
    },
  }
}
</script>

<style scoped>
.index {
  width: 100%;
  height: 2000px;
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
  height: 1800px;
}

.up {
  width: 100%;
  height: 60px;
  margin: 0 auto;
  /*background-color: #40E0D0;*/
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

.main{
  width: 1200px;
  height: 1500px;
  margin: 0 auto;
}

.recruits {
  width: 373px;
  height: 250px;
  margin: 20px 0 20px 20px;
  background-color: white;
  /*background-color: #40E0D0;*/
  float: left;
}

.recruits h2{
  color: #40E0D0;
  line-height: 40px;
}

.recruits span{
  color: black;
  line-height: 50px;
}

.recruits .salary{
  color: red;
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
