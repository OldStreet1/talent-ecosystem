<template>
  <div class="login-container">
    <el-form
      status-icon
      label-position="left"
      label-width="0px"
      class="demo-ruleForm login-page">
      <h3 class="title">高校注册</h3>
      <el-form-item  >
        <el-input type="text"
                  placeholder="学校名称"
                  v-model="university_name"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="text"
                  placeholder="校园代码"
                  v-model="university_code"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="text"
                  placeholder="法人身份证"
                  v-model="corporate_ID_number"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password"
                  auto-complete="off"
                  placeholder="密码"
                  v-model="university_password"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password"
                  auto-complete="off"
                  placeholder="确认密码"
                  v-model="checkPwd"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="textarea"
                  placeholder="学校简介"
                  :rows="10"
                  v-model="university_profile"
                  class="input_area"
        ></el-input>
      </el-form-item>
      <el-form-item style="width:100%;">
        <el-button type="primary" @click.prevent="Reg"  class="btn">注册</el-button>
        <el-button type="primary" @click.prevent="returnLogin"  class="btn">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'school_reg',
  data  () {
    return {
      university_name: '',
      university_code: '',
      corporate_ID_number: '',
      university_password: '',
      checkPwd: '',
      university_profile: '',
    }
  },
  methods: {
    Reg:function (){
      if (this.university_name != '' && this.university_code != ''&& this.corporate_ID_number != ''&&
        this.university_password != ''
        && this.university_profile != '') {
        //
        this.$axios.post("/school/getReg",
          this.$qs.stringify({
            university_name: this.university_name,
            university_code: this.university_code,
            corporate_ID_number: this.corporate_ID_number,
            university_password: this.university_password,
            university_profile: this.university_profile,
          })
        ).then(response=>{
          console.log(response)
          if (response.data == "success"){
            this.$message({
              message: '注册成功',
              type: 'success'
            });
          }else {
            this.$message.error('注册失败');
          }
        }).catch(err=> {
          console.log(err)
        })
      }
    },
    returnLogin: function () {
      this.$router.replace('/school_login')
    }
  }
}
</script>

<style scoped>
.login-container {
  width: 100%;
  height: 100%;
  /*background-image:url('/static/img/schoolLogin.jpg');*/
  background-size: cover;
}
.login-page {
  -webkit-border-radius: 5px;
  border-radius: 5px;
  margin: 10px auto;
  width: 400px;
  padding: 35px 35px 15px;
  background:rgba(255,255,255,0);
}
label.el-checkbox.rememberme {
  margin: 0px 0px 15px;
  text-align: left;
}
.input{
  margin-top: 50px;
}
.input_area{
  margin-top: 50px;
}
.btn{
  width: 150px;
  height: 50px;
  margin: 50px 20px 0px 20px;
  background: cornflowerblue;
}
</style>
