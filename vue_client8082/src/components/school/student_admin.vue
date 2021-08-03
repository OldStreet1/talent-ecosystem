<template>
  <div style="width: 100%">
  <el-row>
    <el-col :span="20"><div class="grid-content bg-purple-dark" >
    </div></el-col>
<!--    左侧菜单-->
    <el-col :span="6"><div class="grid-content bg-purple-dark">
      <el-menu
        router :default-active="this.$route.path"
        default-active="2"
        class="el-menu-vertical-demo"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item-group>
          <el-menu-item index="/sAdmin_Message">用户列表</el-menu-item>
        </el-menu-item-group>
      </el-menu>
    </div></el-col>
<!--    右边显示内容-->
    <el-col :span="14"><div class="grid-content bg-purple-dark">
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
  }
}
</script>

<style scoped>
.bg-purple-dark {
  background: #99a9bf;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>
