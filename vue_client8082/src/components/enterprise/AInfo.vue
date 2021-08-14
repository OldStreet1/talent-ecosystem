<template>
  <div style="width: 800px;height: 700px;">
    <h3>个人信息</h3>
    <hr>
    <el-form :model="form" status-icon :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-form-item label="企业名称" prop="eName" style="width: 550px">
        <label >{{ form.eName }}</label>
      </el-form-item>
      <el-form-item label="企业账户" prop="eAcc" style="width: 550px">
        <label >{{ form.eAcc }}</label>
      </el-form-item>
      <el-form-item label="企业地址" prop="eAddress" style="width: 550px">
        <label >{{ form.eAddress }}</label>
      </el-form-item>
      <el-form-item label="企业简介" prop="eIntro">
        <el-input type="textarea" :rows="5" placeholder="企业简介" v-model="form.eIntro" h></el-input>
      </el-form-item>

      <el-form-item label="融资阶段" prop="eStage" style="width: 350px">
        <el-select v-model="form.eStage" placeholder="请选择融资阶段">
          <el-option label="未融资" value="未融资"></el-option>
          <el-option label="天使轮" value="天使轮"></el-option>
          <el-option label="A轮" value="A轮"></el-option>
          <el-option label="B轮" value="B轮"></el-option>
          <el-option label="C轮" value="C轮"></el-option>
          <el-option label="D轮及以上" value="D轮及以上"></el-option>
          <el-option label="已上市" value="已上市"></el-option>
          <el-option label="不需要融资" value="不需要融资"></el-option>
        </el-select>
<!--        <el-input type="text" placeholder="融资阶段" v-model="form.eStage"></el-input>-->
      </el-form-item>
      <el-form-item label="账户余额" prop="aBalance" style="width: 350px">
        <label  >{{ form.aBalance }}<i class="el-icon-coin"></i></label>
        <el-button style="margin-left: 20px"  icon="el-icon-sell" @click="Recharge" circle></el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="keep">保存</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
export default {
  name: "AInfo",
  data(){
    return{
      form: {
        eName: '某某企业某',
        eAcc: '123132543453543543',
        eAddress: '福建省厦门福建省厦门',
        eIntro:'某某公司，搞科技的',
        eStage:'',
        aBalance:'500',
      },

      // 表单验证，需要在 el-form-item 元素中增加 prop 属性
      rules: {
        eIntro: [
          {required: true, message: '企业简介不可为空', trigger: 'blur'}
        ],
        eStage: [
          {required: true, message: '请选择融资阶段', trigger: 'blur'}
        ]
      },
    }
  },
  methods:{
    keep(){
      this.$alert('已经成功更新你的资料', '提示', {
        confirmButtonText: '确定',
        callback: action => {
          this.$message({
            type: 'info',
            message: `更新成功`
          });
        }
      });
    },
    Recharge(){
      this.$confirm('<ul>\n' +
        '            <li jiaobi=\'1\'>1角币</li>\n' +
        '            <li jiaobi=\'2\'>2角币</li>\n' +
        '            <li jiaobi=\'3\'>3角币</li>\n' +
        '            <li jiaobi=\'4\'>4角币</li>\n' +
        '        </ul>\n' +
        '        <input type="text" id="inputVal" placeholder="请输入金额" />    \n' +
        '        <br/><br/>\n' +
        '        您充值的金额为:<span id="showVal">000</span>元' +
        '', '充值代币', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    }
  }

}
</script>

<style scoped>

</style>
