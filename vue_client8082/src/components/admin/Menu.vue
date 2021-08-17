<template>
  <el-main>
    <!--            表格弹出-->
<!--    .slice((currentPage4-1)*pageSize,currentPage4*pageSize)-->
    <el-table
        :data="this.tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="post_name"
          label="岗位名称"
          width="120">
      </el-table-column>

      <el-table-column
          prop="post_type"
          label="岗位类型"
          width="120">
      </el-table-column>

      <el-table-column
          prop="post_salary"
          label="岗位薪资"
          width="120">
      </el-table-column>

      <el-table-column
          prop="post_education_requirements"
          label="学历要求"
          width="120">
      </el-table-column>

      <el-table-column
          prop="post_work_place"
          label="工作地址"
          width="250">
      </el-table-column>

      <el-table-column
          prop="post_hands_on_background"
          label="工作经验"
          width="120">
      </el-table-column>

      <el-table-column
          prop="create_time"
          label="导入时间"
          width="120">
      </el-table-column>

      <el-table-column
          prop="update_time"
          label="更新内容"
          width="120">
      </el-table-column>

      <el-table-column
          fixed="right"
          label="操作类型"
          width="350">
        <template slot-scope="scope">
          <el-row>
            <!--              ,@click="open2"-->
            <el-button icon="el-icon-search" circle></el-button>
            <el-button type="primary" icon="el-icon-edit" circle></el-button>
            <el-button type="success" icon="el-icon-check" circle></el-button>
            <el-button type="info" icon="el-icon-message" circle></el-button>
            <el-button type="warning" icon="el-icon-star-off" circle></el-button>
            <el-button icon="el-icon-delete" type="danger" @click="deleteEnter(scope.row)"></el-button>
          </el-row>
        </template>
      </el-table-column>
    </el-table>
<!--    <div class="block">-->
<!--      <span class="demonstration"></span>-->
<!--      <el-pagination-->
<!--          align="center"-->
<!--          @size-change="handleSizeChange"-->
<!--          @current-change="handleCurrentChange"-->
<!--          :current-page="currentPage4"-->
<!--          :page-sizes="5"-->
<!--          :page-size="pageSize"-->
<!--          layout="total, sizes, prev, pager, next, jumper"-->
<!--          :total="tableDate.length">-->
<!--      </el-pagination>-->
<!--    </div>-->
  </el-main>
</template>

<script>
export default {
  name: "Menu",
  methods: {
    deleteEnter(row) {
      const id=row.id || this.id
      console.log(row.post_name)
      var check = confirm("是否确定删除？");
      if (check) {
        this.$axios.post("post/postshanchu",
            this.$qs.stringify({
              post_name: row.post_name
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
    //每页条码改变时触发，选择一页显示多少行
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.currentPage = 1;
      this.pageSize = val;
    },
    //当当前页改变触发时，跳转至其他页
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;
    }
  },
  data() {
    return {
      tableData: [{
        // date: '',//岗位名称
        // name: '',//岗位类型
        // province: '',//岗位薪资
        // city: '',//最高学历
        // address: '',//工作地址
        // zip: '',//工作经验
      },
      ],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 1,
    }
  },
  mounted() {
    console.log(this.$axios)
    this.$axios.get("post/postchaxun").then(response => {
      console.log(response);
      this.tableData = response.data
    }).catch(error => {
      console.log(error)
    })
  },
}


</script>

<style scoped>


</style>
