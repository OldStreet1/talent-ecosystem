<template>
  <div class="login-container">
    <el-form :model="ruleForm2" :rules="rules2"
             status-icon
             ref="ruleForm2"
             label-position="left"
             label-width="0px"
             class="demo-ruleForm login-page">
      <h3 class="title">后台登录系统</h3>
      <el-form-item prop="username">
        <el-input type="text"
                  v-model="ruleForm.username"
                  auto-complete="off"
                  placeholder="账号"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password"
                  v-model="ruleForm.password"
                  auto-complete="off"
                  placeholder="密码"
        ></el-input>
      </el-form-item>


      <el-form-item prop="sidentify">
        <el-col :span="14">
          <el-input placeholder="验证码" v-model="ruleForm.code" @keyup.enter.native="submitForm('ruleForm')">
          </el-input>
        </el-col>
        <el-col :span="8">
          <v-sidentify></v-sidentify>
        </el-col>
      </el-form-item>
      <div class="login-btn">
        <el-button type="primary" style="width:40%;" @click="logins" :loading="logining">登录</el-button>
        <el-button type="primary" style="width:40%;" @click="registers" :loading="logining">注册</el-button>

      </div>
    </el-form>
  </div>

</template>

<script>
  import Sidentify from '../admin/Sidentify'  //**引入验证码组件**
  export default {
    data: function () {
      return {
        ruleForm: {
          username: '',
          password: '',
          code: '',
        },
        rules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ],
          code: [
            {required: true}
          ]
        }
      }

    },
    components: {
      'v-sidentify': Sidentify
    },
    methods: {
      logins: function () {
        debugger
        if (this.ruleForm.password === "") {
          this.$message.error('您输入的密码不能为空');
        }
        if (this.ruleForm.username === "") {
          this.$message.error('您输入的账号不能为空');
        } else if (this.ruleForm.username != "" && this.ruleForm.password != "") {
          // console.log(JSON.stringify(this.form))
          console.log()
          this.$axios.post("/Admin/AdminLogin",
            this.$qs.stringify({
              // action: "AdminLogin",
              admin_account: this.ruleForm.username,
              admin_password: this.ruleForm.password,
            })
          ).then(response => {
            console.log(response)

            if (response.data == "success") {
              this.$message({
                message: '恭喜你，登陆成功',
                type: 'success'
              });
              this.$router.push({path: "/AdminUser"})
            } else {
              this.$message.error('登陆失败');
            }
          }).catch(err => {
            console.log(err)
          })
        }
      },
      registers:function () {
        this.$router.replace('/Register')

      }
    }
  }
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

