<template>
  <div>
    <el-button type="text" @click="dialogTableVisible = true">点击显示 Dialog</el-button>
    <el-dialog title="权限管理" :visible.sync="dialogTableVisible" size="tiny" >
      <el-form :model="form">
        <el-button type="primary" style="margin-left: 300px" plain>增加用户</el-button>
        <el-button type="primary" style="margin-left: 0px" plain>重置密码</el-button>
        <el-form-item>
          <el-table
            :data="dataList"
            border
            height="300"
          >
            <el-table-column prop="adminName" label="用户名" ></el-table-column>
            <el-table-column prop="adminId" hidden v-if="showClose"  ></el-table-column>
            <el-table-column property="menusstate" label="权限操作">
              <template slot-scope="scope">
                <el-button type="primary" plain @click="Enable(scope.row.adminId)" >启用</el-button>
                <el-button type="primary"  @click="Disable(scope.row.adminId)">禁用</el-button>
                <el-button type="primary"  @click="SelectMessage">查看</el-button>
                <el-button type="primary"  @click="DeleteMessage(scope.row.adminId)">删除</el-button>
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
    inject:['reload'],
    data() {
      return {
        dialogTableVisible: false,  //是否显示 Dialog
        dataList:[],
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



      }
    },
    created() {
      this.dialogTableVisi()
    },
    methods: {
      dialogTableVisi: function () {
        debugger
        this.$axios.post("/Admin/AdminSelect",
          this.$qs.stringify({})
        ).then(response => {
          if (response.data.isMessageSuceess == "success") {
            this.dataList = response.data.admins;
            console.log(this.dataList)
          } else {
            this.$message.error('错误');
          }
        }).catch(err => {
          console.log(err)
        })
      },
      Enable(id) {
        console.log(id);
        this.$axios.post("/Admin/AdminEnable",
          this.$qs.stringify({
            admin_id: id
          })
        ).then(response => {
          if (response.data == "c") {
            this.$message('启用成功');
          } else {
            this.$message.error('启用失败');
          }
        })

      },
      Disable(id) {
        console.log(id);
        this.$axios.post("/Admin/AdminDisable",
          this.$qs.stringify({
            admin_id: id
          })
        ).then(response => {
          if (response.data == "success") {
            this.$message('禁用成功');
          } else {
            this.$message.error('禁用失败');
          }
        })
      },
      DeleteMessage(id) {
        // console.log(id);
        this.$axios.post("/Admin/AdminDelete",
          this.$qs.stringify({
            admin_id: id
          })
        ).then(response => {
          if (response.data == "success") {

            this.$message('删除成功');
            this.reload();
            // console.log(row.index)
            // this.linkData.splice(row.index, 1)
          } else {
            this.$message.error('删除失败');
          }
        })
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

