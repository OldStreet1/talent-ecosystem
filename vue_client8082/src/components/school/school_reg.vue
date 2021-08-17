<template>
  <div class="login-container">
    <el-form
      :model="form"
      :rules="rules"
      status-icon
      label-position="left"
      label-width="0px"
      class="demo-ruleForm login-page">
      <h3 class="title">高校注册</h3>
      <el-form-item  prop="university_name">
        <el-input type="text"
                  placeholder="学校名称"
                  v-model="form.university_name"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item prop="university_code">
        <el-input type="text"
                  placeholder="校园代码"
                  v-model="form.university_code"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item prop="corporate_ID_number">
        <el-input type="text"
                  placeholder="法人身份证"
                  v-model="form.corporate_ID_number"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item prop="university_password">
        <el-input type="password"
                  auto-complete="off"
                  placeholder="密码"
                  v-model="form.university_password"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item prop="checkPwd">
        <el-input type="password"
                  auto-complete="off"
                  placeholder="确认密码"
                  v-model="form.checkPwd"
                  class="input"
        ></el-input>
      </el-form-item>
      <el-form-item prop="university_profile">
        <el-input type="textarea"
                  placeholder="学校简介"
                  :rows="10"
                  v-model="form.university_profile"
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
//身份证验证
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
    //学校名称
    let schoolName=/[\u4e00-\u9fa5]/;
    let isschool=(rule,value,callback)=>{
      if (!schoolName.test(value)){
        return callback(new Error('请输入合法的学校名字'))
      }else {
        callback()
      }
    };
    //
    let schoolCard=/^[0-9]*$/;
    let isCard=(rule,value,callback)=>{
      if(!schoolCard.test(value)){
        return callback(new Error('请输入合法的学校代码'))
      }else {
        callback()
      }
    }

    return {
      form: {
        university_name: '',
        university_code: '',
        corporate_ID_number: '',
        university_password: '',
        checkPwd: '',
        university_profile: '',
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
        university_code:[{required: true, message: '不能为空', trigger: 'blur'},
          {validator:isCard}],
        university_name:[{required: true, message: '不能为空', trigger: 'blur'},
          {validator:isschool}
        ],
        checkPwd:[{required: true, message: '不能为空', trigger: 'blur'}],
        university_profile:[{required: true, message: '不能为空', trigger: 'blur'}]
      }
    }
  },
  methods: {
    Reg:function (){
      if (this.university_password==this.checkPwd) {
        if (this.university_name != '' && this.university_code != '' && this.corporate_ID_number != '' &&
          this.university_password != ''
          && this.university_profile != '') {
          //
          this.$axios.post("/school/getReg",
            this.$qs.stringify({
              university_name: this.form.university_name,
              university_code: this.form.university_code,
              corporate_ID_number: this.form.corporate_ID_number,
              university_password: this.form.university_password,
              university_profile: this.form.university_profile,
            })
          ).then(response => {
            console.log(response)
            if (response.data == "success") {
              this.$message({
                message: '注册成功',
                type: 'success'
              });
            } else {
              this.$message.error('注册失败');
            }
          }).catch(err => {
            console.log(err)
          })
        }//
      }else {
        alert("两次密码不一致")
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
