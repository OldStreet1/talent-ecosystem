<template>
  <div
    title="充值页面"
    :visible.sync="dialogVisible"
    :close-on-click-modal="false"
    width="800px">
    <div>
      <ul class="msg-box">
        <li>
          <h3>充值中心</h3>
        </li>
        <li>
          <h4 style="margin-bottom: 15px">充值金额</h4>
          <el-radio-group v-model="amountVal" @change="amountChange">
            <el-radio border :label="'' + 30">30</el-radio>
            <el-radio border :label="'' + 50">50</el-radio>
            <el-radio border :label="'' + 100">100</el-radio>
            <el-radio border :label="'' + 200">200</el-radio>
            <el-radio border :label="''">自定义</el-radio>
          </el-radio-group>
        </li>
        <li>
          <h4 style="margin-bottom: 15px">充值金额</h4>
          <el-input
            :disabled="disabled"
            clearable
            v-model="total_amount"
            placeholder="请输入金额"
            style="width: 150px"
          ></el-input>
        </li>
      </ul>
      <div style="text-align: center; margin-top: 30px">
        <el-button type="primary" @click="surePay">确认支付</el-button>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  name: "Recharge",
  data() {
    return {
      dialogVisible: false,
      amountVal: "",
      disabled: false,
      //充值参数
      out_trade_no:'',
      subject:'',
      total_amount:'',//金额
      body:'',
      rechargeParams: {
      },
      code: "",
    };
  },

  methods: {
    init() {
      // this.initData();
      // 展示弹窗
      this.dialogVisible = true;
    },

    //充值金额
    amountChange(val) {
      this.total_amount = val;
      if (val == "") {
        this.disabled = false;
      } else {
        this.disabled = true;
      }
    },

    //确认支付
    surePay() {
      if (this.total_amount == "") {
        this.$message.warning("请输入金额");
        return;
      }else {
        this.$axios.post('alipay?enterprise_acc=mylike',{
          out_trade_no:Math.round(Math.random()*1000000),
          subject:"代币",
          total_amount:this.total_amount,
          body:"充值代币"
        }).then(successResponse=>{
          console.log(successResponse.data)
          document.querySelector('body').innerHTML = successResponse.data;//查找到当前页面的body，将后台返回的form替换掉他的内容
          document.forms[0].submit();  //执行submit表单提交，让页面重定向，跳转到支付宝页面
        }).
        catch();
      }
      // this.$router.push({path: '/code'});


    },



  // },
}

}
</script>

<style scoped>
.msg-box > li {
  list-style: none;
  border-bottom: 1px solid #c5c5c5;
  padding: 20px 10px;
}
</style>
