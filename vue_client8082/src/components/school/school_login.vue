<template>
  <div class="login-container">
    <div class="login">
      <el-form
        :model="form"
        :rules="rules"
        status-icon
        label-position="left"
        label-width="0px"
        class="demo-ruleForm login-page">
        <h3 class="title">高校登录</h3>
        <el-form-item prop="corporate_ID_number">
          <el-input type="text"
                    placeholder="请输入法人代表身份证"
                    v-model="form.corporate_ID_number"
                    class="name"
          ></el-input>
        </el-form-item>
        <el-form-item prop="university_password">
          <el-input type="password"
                    auto-complete="off"
                    placeholder="请输入密码"
                    v-model="form.university_password"
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

    let num = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    let isNum = (rule, value, callback) => {
      if (!num.test(value)) {
        return callback(new Error('请输入合法的身份证'))
      } else {
        callback()
      }
    };
    // 密码正则
    let patter = /((^[1-9]\d*)|^0)(\.\d{0,2}){0,1}$/;
    let isNumber = (rule, value, callback) => {
      if (!patter.test(value)) {
        return callback(new Error('不能为空'))
      } else {
        callback()
      }
    };

    return {
      form:{
        corporate_ID_number: '',
        university_password: ''
      },
      rules: {
        corporate_ID_number: [
          { required: true, message: '不能为空', trigger: 'blur' },
          { validator:isNum}
        ],
        university_password: [
          { required: true, message: '密码不能为空',trigger: 'blur' },
          { min: 1, max: 8, message: '长度在 1 到 8 个字符', trigger: 'blur' },
          { validator:isNumber}
        ],
      },
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
            corporate_ID_number: this.form.corporate_ID_number,
            university_password: this.form.university_password,
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
  margin: 200px auto 0;
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
