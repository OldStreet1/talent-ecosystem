<template>
  <div class="index">
    <h2>个人中心</h2>
    <div class="slideshow">
      <el-carousel height="120px">
        <el-carousel-item v-for="(item, index) in list_img" :key="index">
          <h3 class="small">
            <img :src="item.url" alt/>
          </h3>
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="main">
      <div class="head">
        <img src="../assets/images/qq.png" class="headimg" alt="">
      </div>
      <div class="menus">
        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">个人操作</span>
            </template>
              <el-menu-item index="1-1">个人信息</el-menu-item>
              <el-menu-item index="1-2">找工作</el-menu-item>
              <el-menu-item index="1-3">查找工作</el-menu-item>
              <el-menu-item index="1-4">投递简历</el-menu-item>
              <el-menu-item index="1-5">查看已投简历</el-menu-item>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-chat-dot-round"></i>
            <span slot="title">即时通讯</span>
          </el-menu-item>
          <el-menu-item index="3">
            <i class="el-icon-chat-line-round"></i>
            <span slot="title">消息提醒</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-edit"></i>
            <span slot="title">修改密码</span>
          </el-menu-item>
          <el-menu-item index="5">
            <i class="el-icon-close"></i>
            <span slot="title">退出登录</span>
          </el-menu-item>
        </el-menu>
      </div>

    </div>
    <div class="place">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'My',
  data () {
    return {
      list_img: [
        {url: require('../assets/images/1.jpg')},
        {url: require('../assets/images/2.jpg')},
        {url: require('../assets/images/3.jpg')},
        {url: require('../assets/images/4.jpg')},
      ],
      isCollapse: false
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.index{
  width: 100%;
  height: 1000px;
  background-color: #40E0D0;
  /*background-image: url("../../assets/back.jpg");*/
}

h2{
  margin: 0;
  padding-top: 20px;
}

.slideshow {
  width: 1000px;
  margin: 0 auto;
}

.main{
  width: 1000px;
  height: 700px;
  margin: 0 auto;
  background-color: white;
  position: absolute;
  left: 452px;
}

.head{
  margin-left: -800px;
}

.headimg{
  width: 60px;
  height: 60px;
  margin-top: 20px;
}

.menus{
  margin-top: 20px;
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.place{
  width: 800px;
  height: 700px;
  background-color: #eaeaea;
  position: absolute;
  left: 652px;
  z-index: auto;
}
</style>
