<template>
  <div style="width: 100%">
  <el-row>
    <el-col :span="20"><div class="grid-content bg-purple-dark" >
      <span style="float: left;line-height: 50px;font-size: 30px;margin-left: 30px">高校管理</span>
      <el-button type="primary" round @click="exitLogin" style="float: left;margin:10px 0px 0px 1000px">退出登录</el-button>
    </div></el-col>
<!--    左侧菜单-->
    <el-col :span="6"><div class="grid-content bg-purple-dark" style="margin-top:20px ">
      <el-menu
        router :default-active="this.$route.path"
        default-active="2"
        class="el-menu-vertical-demo"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item-group>
          <el-menu-item index="/sAdmin_Message" @click="chaxun">导入人才信息</el-menu-item>
        <el-menu-item index="/sAdmin_Export" @click="chaxun">导出人才信息</el-menu-item>
        <el-menu-item index="/sAdmin_Introduction" @click="chaxun">高校简介</el-menu-item>
        </el-menu-item-group>
      </el-menu>
    </div></el-col>
<!--    右边显示内容-->
    <el-col :span="17"><div class="grid-content bg-purple-dark" style="margin-top:20px">
      <router-view></router-view>
    </div></el-col>
  </el-row>
  </div>
</template>

<script>


export default {
  name: 'student_admin',
  data () {
    return {
      data:{
        filename:''
      }
    }
  },
  methods: {
    chaxun:function (){
      this.$axios.post("/school/schoolname"
      ).then(response => {
        console.log(response.data)
      }).catch(err => {
        console.log(err)
      })
    },
    exitLogin:function (){
      this.$router.replace('/school_login')
    }
  }
}
</script>

<style scoped>
.bg-purple-dark {
  background: white;

}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>
