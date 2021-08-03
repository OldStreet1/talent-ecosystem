<template>
  <div style="background-color: #72ffe5;float: left;width: 100%;height: 100%" >

      <div style="background-color: #ffffff;width: 40%;height: 90%;margin: 2% auto;border-radius: 3% " >

  <el-container style="">
    <el-main >
      <h3>注册企业账号</h3>
      <el-form
        ref="registerForm"
        :model="data"
        style="width:90%;margin: 0 auto"
        label-position="center"
        label-suffix=":"
        :rules="rules"
        status-icon
        hide-required-asterisk

      >
        <el-form-item prop="employerName" :validate-status="status">
          <el-input clearable v-model="data.employerName" placeholder="企业名称" @blur="validateName"></el-input>
        </el-form-item>
          <el-input clearable v-model="data.employerAddress"  placeholder="企业地址" @blur=""></el-input>
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
        <el-form-item prop="">
          <el-select v-model="value" style="width:100%;"  placeholder="企业类型">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
              :disabled="item.disabled">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="phoneNumber">
          <el-input clearable v-model="data.phoneNumber"  placeholder="手机号" type="text"></el-input>
        </el-form-item>
        <el-form-item prop="code">
          <el-input clearable v-model="data.code"   style="width:55%;float: left" placeholder="请输入手机验证码" type="text"></el-input>
          <el-button type="primary" style="width:40%;float: right" :disabled="disabled" @click="sendCode">{{valiBtn}}</el-button>
        </el-form-item>
        <el-form-item prop="password">
          <el-input clearable v-model="data.password"   placeholder="请输入密码" type="password"></el-input>
        </el-form-item>
        <el-form-item prop="re_password">
          <el-input clearable v-model="data.re_password"  placeholder="请确认密码" type="password"></el-input>
        </el-form-item>
        请上传法人身份证、公司营业执照
        <div>

          <el-upload
            class="upload-demo"
            ref="upload"
            action
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :file-list="fileList"
            :auto-upload="false"
            accept=".jpg,.png"
            :http-request="UploadSubmit"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
            <el-button
              style="margin-left: 10px"
              size="small"
              type="success"
              @click="submitUpload"
            >上传到服务器</el-button
            >
            <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件，且不超过500kb
            </div>
          </el-upload>
        </div>
        <el-form-item>
          <el-button type="primary" v-on:click="register">注册</el-button>
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
      fileList: [],
      options: [{
        value: '国有',
        label: '国有'
      }, {
        value: '私营',
        label: '私营',
      }, {
        value: '合资',
        label: '合资'
      }, {
        value: '独资',
        label: '独资'
      }, {
        value: '全民所有制',
        label: '全民所有制'
      },{
        value: '集体所有制',
        label: '集体所有制'
      },{
        value: '股份制',
        label: '股份制'
      },{
        value: '有限责任',
        label: '有限责任'
      },{
        value: '其他',
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
      data1:'15759212580',
      data: {
        enterprise_code:'',
        enterprise_legal_person:'',
        enterprise_operation_status:'',
        employerAddress:'',
        employerName: '',
        password: '12345678',
        re_password: '12345678',
        phoneNumber: '15759212580'
      },
      // 所有校验规则
      rules: {
        employerName: [ // 用户名验证
          { required: true, trigger: 'change', message: '用户名必须填写' },
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
      },
      valiBtn:'获取验证码',
      disabled:false,
    }
  },
  computed: {
    // 上传是带的参数

  },
  methods: {
    UploadSubmit(param) {
      var file = param.file;
      console.log(param.file);
      var file_form = new FormData(); //获取上传表单（文件）
      file_form.append("file", file);
      console.log(file_form);
      this.$axios({
        url: "/img/upload/"+this.data.phoneNumber,
        method: "POST",
        data: file_form,
      })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
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



    register(){
      if (this.fileList === null){
        this.$message.error('您还未上传营业执照以及法人身份证，无法注册');
      }else if (this.data.employerName === "" || this.data.phoneNumber === "" || this.data.password === "" || this.data.re_password === "" || this.data.employerAddress === "" || this.data.enterprise_operation_status === "" || this.data.value1 === "" || this.data.enterprise_legal_person === "" || this.data.code === "" || this.data.value === ""){
        this.$message.error('您输入的信息有未填写，无法注册');
      }else {
        this.onSubmit();
      }
    },
    onSubmit(){
      this.$axios.post("/enterprise/register",
        this.$qs.stringify({
          enterprise_name:this.data.employerName,
          enterprise_acc:this.data.phoneNumber,
          enterprise_pwd:this.data.password,
          enterpriseConfirm_pwd:this.data.re_password,
          enterprise_address:this.data.employerAddress,
          enterprise_operation_status:this.data.enterprise_operation_status,
          enterprise_time_establishment:this.value1,
          enterprise_legal_person:this.data.enterprise_legal_person,
          enterprise_code:this.data.code,
          enterprise_type:this.value,
        })
      ).then(response=>{
        console.log(response)
        if (response.data === "success"){
          this.$message({
            message: '恭喜你，注册成功，请等等审核通知',
            type: 'success'
          });
        }else if(response.data === "existence"){
          this.$message.error('注册的账号已存在');
        }

        else{
          this.$message.error('注册失败');
        }
      }).catch(err=> {
        console.log(err)
      })



      console.log("123")
    },
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
          this.tackBtn();
        }else {
          this.$message.error('发送失败，请'+response.data+"再进行发送");
        }
      }).catch(err=> {
        console.log(err)
      })
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
    // 验证码倒数60秒
    tackBtn(){
      let time = 60;
      let timer = setInterval(() => {
        window.sessionStorage.setItem("X_no_time",this.time);//存入本地
        if(window.sessionStorage.getItem("X_no_time")<="0"){//等于0时清空
          window.sessionStorage.removeItem('X_no_time');
        }
        if(time == 0){
          clearInterval(timer);
          this.valiBtn = '获取验证码';
          this.disabled = false;
        }else{
          this.disabled = true;
          this.valiBtn = time + '秒后重试';
          time--;
        }
      }, 1000);

    }
  }
}
</script>

<style scoped>
.block{
  margin-bottom: 4%;
}

</style>
