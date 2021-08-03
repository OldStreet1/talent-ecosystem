<template>
  <div class="login-container">
    <div class="login">
      <el-form
        status-icon
        label-position="left"
        label-width="0px"
        class="demo-ruleForm login-page">
        <h3 class="title">高校登录</h3>
        <el-form-item>
          <el-input type="text"
                    placeholder="请输入法人代表身份证"
                    v-model="corporate_ID_number"
                    class="name"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password"
                    auto-complete="off"
                    placeholder="请输入密码"
                    v-model="university_password"
                    class="pwd"
          ></el-input>
        </el-form-item>
        <el-form-item style="width:100%;">
          <el-button type="primary" class="btn"
                     @click.prevent="handleLogin" >登录</el-button>
          <el-button type="primary" @click.prevent="handleReg"   class="btn">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import student_admin from "./student_admin";
import school_reg from "./school_reg";

export default {
  name: 'school_login',
  data() {
    return {
      corporate_ID_number: '',
      university_password: ''
    }
  },
  methods: {
    handleReg: function () {
      this.$router.replace(school_reg)
    },
    handleLogin: function () {
      // eslint-disable-next-line eqeqeq
      if (this.corporate_ID_number != '' && this.university_password != '') {
        this.$axios.post("/school/getLogin",
          this.$qs.stringify({
            corporate_ID_number: this.corporate_ID_number,
            university_password: this.university_password,
          })
        ).then(response => {
          console.log(response.data)
          if (response.data == "success") {
            this.$message({
              message: '登录成功',
              type: 'success',
            });
            this.$router.replace(student_admin)
          } else {
            this.$message.error('登陆失败');
          }
        }).catch(err => {
          console.log(err)
        })
      } else {
        alert("请输入信息")
      }
    },
  },
}
</script>

<style scoped>
.login-container {
  width: 100%;
  height: 100%;
  position: relative;z-index: 1
}
.login-page {
  -webkit-border-radius: 5px;
  border-radius: 5px;
  margin: 200px 0px 0px 500px;
  width: 350px;
  padding: 35px 35px 15px;
  background:rgba(255,255,255,0.6);
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
label.el-checkbox.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
}
.login{
  width: 100%;
  height: 730px;
  position: absolute;
  z-index: 2;
  /*background-image:url('../../../static/img/schoolLogin.jpg');*/
  background-size: cover;
}
.name{
  margin: 0px 0px 60px 0px;
}
.pwd{
  margin: 0px 0px 30px 0px;
}
.btn{
  margin-top: 40px;
  width: 40%;
  height: 50px;
  margin-left: 20px;
  background: cornflowerblue;
}
</style>
