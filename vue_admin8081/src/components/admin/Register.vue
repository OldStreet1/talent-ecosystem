<template>
  <div class="login-container">
    <el-form :model="ruleForm2" :rules="rules2"
             status-icon
             ref="ruleForm2"
             label-position="left"
             label-width="0px"
             class="demo-ruleForm login-page">
      <h3 class="title">后台注册系统</h3>

      <el-form-item prop="name">
        <el-input type="text"
                  v-model="ruleForm.name"
                  auto-complete="off"
                  placeholder="昵称"
        ></el-input>
      </el-form-item>
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
      <el-form-item prop="repassword">
        <el-input type="password"
                  v-model="ruleForm.repassword"
                  auto-complete="off"
                  placeholder="确认密码"
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
        <el-button type="primary" style="width:40%;" @click="sures" :loading="logining">确认</el-button>
        <el-button type="primary" style="width:40%;" @click="returns" :loading="logining">返回</el-button>

      </div>
    </el-form>
  </div>

</template>

<script>
  import Sidentify from './Sidentify'  //**引入验证码组件**
  export default {
    data: function(){
      return {
        ruleForm: {
          name:'',
          username: '',
          password: '',
          repassword:'',
          code: '',
        },
        rules: {
          username: [
            { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ],
          code:[
            {required: true}
          ]
        }
      }

    },
    components: {
      'v-sidentify':Sidentify
    },
    methods:{
      returns:function () {
          this.$router.replace('/admin_login')
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
