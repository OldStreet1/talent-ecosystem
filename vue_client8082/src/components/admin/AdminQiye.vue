<template>
  <div>
    <el-main>
      <!--            表格弹出-->
      <el-table
          :data="this.tableData"
          border style="width: 200%">
        <el-table-column
            fixed
            prop="enterprise_name"
            label="企业名称"
            width="150">
        </el-table-column>

        <el-table-column
            label="企业类型"
            prop="enterprise_type"
            width="150">
        </el-table-column>

        <!--        <el-table-column-->
        <!--            prop="admin_password"-->
        <!--            label="求职人员总数"-->
        <!--            width="120">-->
        <!--        </el-table-column>-->

        <!--        <el-table-column-->
        <!--            prop="city"-->
        <!--            label="就业人数"-->
        <!--            width="120">-->
        <!--        </el-table-column>-->

        <el-table-column
            prop="enterprise_status"
            label="审核状态"
            width="120">
        </el-table-column>

        <!--        <el-table-column-->
        <!--            prop="zip"-->
        <!--            label="营业执照下载"-->
        <!--            width="120">-->
        <!--        </el-table-column>-->

        <el-table-column
            label="导入时间"
            prop="create_time"
            width="120">
        </el-table-column>

        <el-table-column
            label="更新时间"
            prop="update_time"
            width="120">
        </el-table-column>

        <el-select
            v-model="value"
            :loading="loading"
            filterable
            remote
            :remote-method="remoteMethod"
            multiple
            placeholder="请输入关键词"
            reserve-keyword>
          <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
          </el-option>
        </el-select>

        <el-table-column
            fixed="right"
            label="操作类型"
            width="450">
          <template slot-scope="scope">
            <el-row>
              <!--              ,@click="open2"-->
              <!--              搜索-->
              <el-select v-model="value" circle filterable placeholder="请输入搜索内容">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :value="item.value">
                </el-option>
              </el-select>

              <el-button circle circleicon="el-icon-edit" @click="seleceEnter(scope.row)"></el-button>
              <el-button circle icon="el-icon-check" type="success" @click="entershenhe()"></el-button>
              <!--              <el-button type="info" icon="el-icon-message" circle></el-button>-->
              <!--              <el-button type="warning" icon="el-icon-star-off" circle></el-button>-->
              <el-button circle icon="el-icon-delete" type="danger" @click="deleteEnter(scope.row)"></el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
      <div class="block">
        <span class="demonstration"></span>
        <!--        <el-pagination-->
        <!--            @size-change="handleSizeChange"-->
        <!--            @current-change="handleCurrentChange"-->
        <!--            :current-page="currentPage4"-->
        <!--            :page-sizes="[100, 200, 300, 400]"-->
        <!--            :page-size="10"-->
        <!--            layout="total, sizes, prev, pager, next, jumper"-->
        <!--            :total="10">-->
        <!--        </el-pagination>-->
      </div>
    </el-main>

  </div>
</template>

<script>
export default {
  name: "Menu",
  methods: {
    // 企业绑定删除效果
    deleteEnter(row) {
      const id=row.id || this.id
      console.log(row.enterprise_name)
      var check = confirm("是否确定删除？");
      if (check) {
        this.$axios.post("enter/entershanchu",
            this.$qs.stringify({
              enterprise_name: row.enterprise_name
            })
        ).then(response=>{
          console.log(response)
          if(response.data === 'success'){
            this.$message({
              type:'success',
              message:'删除成功'
            });
          }
        })
      } else {
        this.$message({
          type:'info',
          message:'已取消删除'
        })
      }
    },
    // 企业绑定审核通过效果
    entershenhe() {

    },
  }, // 大括号
  data() {
    return{
      tableData:[]
    }
  },
  mounted() {
    // controller跳转
    console.log(this.$axios)
    this.$axios.get("enter/enterchaxun").then(response => {
      console.log(response);
      this.tableData = response.data
    }).catch(error => {
      console.log(error)
    });

  },

}

</script>

<style scoped>

</style>
