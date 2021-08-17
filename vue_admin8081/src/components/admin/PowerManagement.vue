<template>
  <div>
    <el-button type="text" @click="dialogTableVisible = true">点击显示 Dialog</el-button>
    <el-dialog title="权限管理" :visible.sync="dialogTableVisible" size="tiny" >
      <el-form :model="form">
        <el-button type="primary" style="margin-left: 300px" plain>增加用户</el-button>
        <el-button type="primary" style="margin-left: 0px" plain>重置密码</el-button>
        <el-form-item>
          <el-table
            :data="userName"
            border
            height="300"
          >

            <el-table-column property="name" label="用户名" ></el-table-column>
            <el-table-column property="menusstate" label="权限操作">
              <template scope="scope">
                <el-button type="primary" plain>启用</el-button>
                <el-button type="primary" plain>禁用</el-button>
                <el-button type="primary" plain>设置</el-button>
                <el-button type="primary" plain>删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-form-item>




      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        dialogTableVisible: false,  //是否显示 Dialog
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        userName:[
          {
            name:"郑克文",
            menusstate:false,
          },
          {
            name:"张宇",
            menusstate:false,
          },
          {
            name:"郑乃胜",
            menusstate:false,
          },
          {
            name:"林至秦",
            menusstate:false,
          },
          {
            name:"冯魏杰",
            menusstate:false,
          }],



      }
    },
    methods:{
      change:function(index,row){
        console.log(index,row);
      }
    }
  }
</script>
<style>
  .menusStateTrue{
    background: #5B7BFA;
    color:white;
  }
  .menusStateTrue:hover{
    background: #5B7BFA;
    color:white;
  }

</style>
