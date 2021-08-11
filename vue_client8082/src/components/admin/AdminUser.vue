<template>
  <div>
    <el-container style="height: 900px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <!--      获取路由路劲代码：router :default-active="this.$route.path-->
        <el-menu :default-openeds="['1', '3']" router :default-active="this.$route.path">

          <el-submenu index="1">
            <template slot="title">岗位管理</template>
            <el-menu-item index="/adminGwgl">岗位类型管理</el-menu-item>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">企业管理</template>
            <el-menu-item index="/AdminQiye">企业相关管理</el-menu-item>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">高校管理</template>
            <el-menu-item index="/AdminMoc">高校管理认证</el-menu-item>
          </el-submenu>

          <el-submenu index="4">
            <template slot="title">后台统计</template>
            <el-menu-item-group>
              <el-menu-item index="/AdminSta">用户上线人数</el-menu-item>
              <el-menu-item index="/AdminAllUser">总用户人数</el-menu-item>
              <el-menu-item index="/AdminJobWant">求职人数总数</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="5">
            <template slot="title">咨询管理</template>
            <el-menu-item-group>
              <el-menu-item index="5-1">高校咨询</el-menu-item>
              <el-menu-item index="5-2">企业咨询</el-menu-item>
            </el-menu-item-group>
            <el-menu-item index="5-3">社会咨询</el-menu-item>
          </el-submenu>

          <el-submenu index="6">
            <template slot="title">区域管理</template>
            <el-menu-item-group>
              <el-menu-item index="6-1">区级</el-menu-item>
              <el-menu-item index="6-2">市级</el-menu-item>
            </el-menu-item-group>
            <el-menu-item index="6-3">省份</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 20px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>岗位管理</el-dropdown-item>
              <el-dropdown-item>岗位类型管理</el-dropdown-item>
              <el-dropdown-item>企业管理</el-dropdown-item>
              <el-dropdown-item>高校管理</el-dropdown-item>
              <el-dropdown-item>后台统计</el-dropdown-item>
              <el-dropdown-item>查询管理</el-dropdown-item>
              <el-dropdown-item>咨询管理</el-dropdown-item>
              <el-dropdown-item>区域管理</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>admin</span>
        </el-header>

        <el-main>
          <router-view></router-view>
          <!--            表格弹出 Menu.vue-->
          <!--        弹出企业管理 adminQiye.vue-->
          <!--        弹出moc 高校管理认证界面-->
          <!--        弹出sta 后台统计列表-->
          <!--          弹出咨询-->
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Menu from './Menu'

export default {
  methods: {
    adminchaxun() {
    }
  },

  name: "AdminUser",
  components: {
    Menu
  },
  data() {
    return {};
  },
}
</script>

<style scoped>

</style>
