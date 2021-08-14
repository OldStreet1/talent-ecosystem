<template>
  <div class="login-container">
    <el-form :model="ruleForm2" :rules="rules2"
             status-icon
             ref="ruleForm2"
             label-position="left"
             label-width="0px"
             class="demo-ruleForm login-page">
      <h3 class="title">企业登陆</h3>
      <el-form-item prop="username">
        <el-input type="text"
                  v-model="ruleForm2.username"
                  auto-complete="off"
                  placeholder="用户名"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="ruleForm2.password"
          :type="pwdType"
          prefix-icon="el-icon-lock"
          placeholder="请输入密码"
          autocomplete="new-password"
        >
          <i slot="suffix" class="el-icon-view" @click="showPwd"></i>
        </el-input>
      </el-form-item>
      <el-checkbox
        v-model="checked"
        class="rememberme"
      >记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:40%;" @click="handleSubmit" :loading="logining">登录</el-button>
        <el-button type="primary" style="width:40%;" @click="toregister">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "enterprise_login",
  data(){
    return {
      formData:{
        user:{
          password: '123456',
        }
      },
      pwdType:"password",
      logining: false,
      ruleForm2: {
        username: 'admin',
        password: '123456',
      },
      rules2: {
        username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
        password: [{required: true, message: '请输入密码', trigger: 'blur'}]
      },
      checked: false
    }
  },
  methods: {
    toregister(){
        this.$router.replace("/enterprise_register")
    },
    handleSubmit(){
      if (this.ruleForm2.password === ""){
        this.$message.error('您输入的密码不能为空');
      }
      if (this.ruleForm2.username === ""){
        this.$message.error('您输入的账号不能为空');
      }
      else if(this.ruleForm2.username != "" && this.ruleForm2.password != ""){
        console.log(JSON.stringify(this.form))
        this.$axios.post("/enterprise/login",
          this.$qs.stringify({
            action:"login",
            enterprise_acc:this.ruleForm2.username,
            enterprise_pwd:this.ruleForm2.password,
          })
        ).then(response=>{
          console.log(response)
          if (response.data == "success"){
            this.$message({
              message: '恭喜你，登陆成功',
              type: 'success'
            });
            this.$router.push({path: "/My"})
          }else {
            this.$message.error('登陆失败');
          }
        }).catch(err=> {
          console.log(err)
        })
      }
    },


    showPwd() {
      this.pwdType === "password" ? (this.pwdType = "") : (this.pwdType = "password");
      let e = document.getElementsByClassName("el-icon-view")[0];
      this.pwdType == ""? e.setAttribute("style", "color: #c0c4cc") : e.setAttribute("style", "color: #409EFF");
    },
  }
};
</script>

<style scoped>
.login-container {
  width: 100%;
  height: 100%;
}
.login-page {
  -webkit-border-radius: 5px;
  border-radius: 5px;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
label.el-checkbox.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
}
</style>

