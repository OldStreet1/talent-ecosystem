<template>
  <div style="background-color: #97e6f3;float: left;" >
    <div style="background:url('../../assets/images/newbg1.jpg');width: 100%;height: 500px;position: absolute;"></div>
      <div style="background-color: #ffffff;width: 40%;height: 90%;margin: 5% auto;border-radius: 3% " >

  <el-container style="">
    <el-main >
      <h3>注册企业账号</h3>
      <el-form
        ref="registerForm"
        :model="data"
        style="width:90%;margin: 0 auto"
        label-position="center"
        label-width="80px"
        label-suffix=":"
        :rules="rules"
        status-icon
        hide-required-asterisk

      >

          <el-input clearable v-model="data.employerName"   style="margin: 2% 0" placeholder="企业名称" @blur="validateName"></el-input>
          <el-input clearable v-model="data.employerAddress"  style="margin: 2% 0" placeholder="企业地址" @blur=""></el-input>
          <el-input clearable v-model="data.enterprise_operation_status" style="margin: 2% 0" placeholder="经营状态" @blur=""></el-input>
        <div class="block">
          <el-date-picker
            v-model="value1"
            type="date"
            style="width:100%;float: right;margin: 2% 0"
            placeholder="成立时间">
          </el-date-picker>
        </div>
          <el-input clearable v-model="data.enterprise_legal_person" style="margin: 2% 0" placeholder="企业法人"></el-input>
          <el-input clearable v-model="data.enterprise_code" style="margin: 2% 0" placeholder="企业代码"></el-input>
          <el-select v-model="value" style="width:100%;float: right;margin: 2% 0"  placeholder="企业类型">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
              :disabled="item.disabled">
            </el-option>
          </el-select>
          <el-input clearable v-model="data.phoneNumber"  style="margin: 2% 0" placeholder="手机号" type="text"></el-input>
          <el-input clearable v-model="data.code"   style="width:55%;float: left" placeholder="请输入手机验证码" type="text"></el-input>
          <el-button type="primary" style="width:40%;float: right" @click="sendCode">获取验证码</el-button>
          <el-input clearable v-model="data.password"  style="margin: 2% 0" placeholder="请输入密码" type="password"></el-input>
          <el-input clearable v-model="data.re_password"  style="margin: 2% 0" placeholder="请确认密码" type="password"></el-input>
        请上传法人身份证、公司营业执照
        <el-upload
          class="upload-demo"
          ref="upload"
          action="https://jsonplaceholder.typicode.com/posts/"

          :on-preview="handlePreview"
          :on-remove="handleRemove"
          accept=".jpg,.png"
          :duplicate="false"
          :auto-upload="false">

          <el-button slot="trigger" size="small" type="primary">选择文件</el-button>
          <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
        <el-form-item>
          <el-button type="primary" v-on:click="onSubmit('registerForm')">注册</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
      </div>
  </div>
</template>

<script>
export default {
  name: "EmployerReg",

  data () {

    // 封装一下相似功能的校验器
    const validatorMethod = function (length, message) {
      return (rule, value, callback) => {
        if (value.length < length) {
          callback(new Error(message))
        } else {
          callback()
        }
      }
    }
    //用户名校验器
    const usernameValidator = (rule, value, callback) => {
      if (/^(?![^A-Za-z]+$)(?![^0-9]+$)[0-9A-Za-z_]{4,15}$/.test(value)) {
        callback()
      } else {
        callback(new Error('用户名要求 数字、字母、下划线的组合，其中数字和字母必须同时存在'))
      }
    }
    // 确认密码校验器
    const comfirmPassword = (rule, value, callback) => {
      if (value !== this.data.password) {
        return callback(new Error('两次输入密码不一致'))
      }
      callback()
    }
    // 手机号校验器
    const phoneValidator = (rule, value, callback) => {
      if (/^1[3456789]\d{9}$/.test(value)) { // 利用正则表达式校验手机号
        callback()
      } else {
        callback(new Error('请输入正确手机号'))
      }
    }
    return {
      options: [{
        value: '选项1',
        label: '国有'
      }, {
        value: '选项2',
        label: '私营',
      }, {
        value: '选项3',
        label: '合资'
      }, {
        value: '选项4',
        label: '独资'
      }, {
        value: '选项5',
        label: '全民所有制'
      },{
        value: '选项6',
        label: '集体所有制'
      },{
        value: '选项7',
        label: '股份制'
      },{
        value: '选项8',
        label: '有限责任'
      },{
        value: '选项9',
        label: '其他'
      },
      ],
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      value: '',  //企业类型
      value1: '',
      status: '',
      data: {
        enterprise_code:'',
        enterprise_legal_person:'',
        enterprise_operation_status:'',
        employerAddress:'',
        employerName: '',
        password: '',
        re_password: '',
        phoneNumber: ''
      },
      // 所有校验规则
      rules: {
        employerName: [ // 用户名验证
          { required: true, trigger: 'change', message: '用户名必须填写' },
          // { min: 3, max: 12, trigger: 'change', message: '用户名长度不能小于3'},
          // { validator: usernameValidator, trigger: 'blur' },
          { validator: validatorMethod(3, '用户名长度不能小于3'), trigger: 'change' }
        ],
        password: [ // 密码验证
          { required: true, trigger: 'change', message: '密码不能为空' },
          { validator: validatorMethod(8, '密码长度不能小于8'), trigger: 'change' }
        ],
        re_password: [ // 重复密码验证
          { required: true, trigger: 'change', message: '请再一次输入密码' },
          { validator: comfirmPassword, trigger: 'blur' }
        ],
        phoneNumber: [ // 手机号验证
          { required: true, trigger: 'change', message: '手机号不能为空' },
          { min: 11, max: 11, trigger: 'change', message: '请输入11位手机号码' },
          { validator: phoneValidator, trigger: 'blur' }
        ]
      }
    }
  },
  components: {

  },
  methods: {
    sendCode(){
      this.$axios.post("/sms/smsverification",
        this.$qs.stringify({
          cellPhoneNum:this.data.phoneNumber
        })
      ).then(response=>{
        console.log(response)
        if (response.data == "success"){
          console.log(response.data)
          this.$message({
            message: '发送成功',
            type: 'success'
          });
        }else {
          this.$message.error('发送失败');
        }
      }).catch(err=> {
        console.log(err)
      })
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    validateName (e) {
      if (e.target.value.trim() !== '') { // 输入框为空不校验
        // status的四个值：error(失败)，success(成功)，validating(验证中)，null
        this.status = 'validating'
        setTimeout(() => { // 模拟发送ajax请求，检查用户名是否重复
          if (e.target.value === 'wjg') {
            this.status = 'success'
          } else {
            this.status = 'error'
          }
        }, 1000)
      }
    },
    onSubmit(formName) {
      this.$axios.get("/admin/login",{
        params:{
          // "action":"login",
          "employerName":this.form.employerName,
          "phoneNumber":this.form.phoneNumber,
          "code":this.form.code,
          "password":this.form.password
        }

      }).then(response=>{
        console.log(response);
        // 为表单绑定验证功能
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
            this.$router.push("/backman");
          } else {
            this.dialogVisible = true;
            return false;
          }
        });
      }).catch(error=>{
        console.log(error)
      });
    }
  }
}
</script>

<style scoped>
.block{
  margin-bottom: 4%;
}

</style>
