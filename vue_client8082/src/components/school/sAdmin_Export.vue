<template>
  <div>

<el-select v-model="majors.user_major" @change="getMajor(majors.user_major)" placeholder="请选择专业">
  <el-option  value="全部"></el-option>
  <el-option
    v-for="item in majors"
    :key="item.user_major"
    :label="item.user_major"
    :value="item.user_major" ></el-option>
</el-select>

<el-button @click="screen">查询</el-button>
    <el-button @click="downloadExcel">导出</el-button>
  <el-table
    id="example"
    :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
    style="width: 100%;z-index: 0">
    <el-table-column
      prop="user_id"
      label="序号">
    </el-table-column>
    <el-table-column
      prop="user_name"
      label="用户名">
    </el-table-column>
    <el-table-column
      prop="user_pwd"
      label="密码">
    </el-table-column>
    <el-table-column
      prop="user_id_card"
      label="身份证号">
    </el-table-column>
    <el-table-column
      prop="user_nation"
      label="民族">
    </el-table-column>
    <el-table-column
      prop="user_sex"
      label="性别">
    </el-table-column>
    <el-table-column
      prop="userage"
      label="年龄">
    </el-table-column>
    <el-table-column
      prop="user_date_birth"
      label="出生年月">
    </el-table-column>
    <el-table-column
      prop="user_telephone"
      label="联系电话">
    </el-table-column>
    <el-table-column
      prop="user_email"
      label="邮箱">
    </el-table-column>
    <el-table-column
      prop="user_school_name"
      label="学校名称">
    </el-table-column>
    <el-table-column
      prop="user_major"
      label="专业">
    </el-table-column>
    <el-table-column
      prop="user_education"
      label="学历">
    </el-table-column>
    <el-table-column
      prop="user_residence"
      label="居住地">
    </el-table-column>
    <el-table-column
      prop="user_graduation_time"
      label="毕业时间">
    </el-table-column>
    <el-table-column
      prop="create_time"
      label="导入时间">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
      </template>
    </el-table-column>
  </el-table>
  <div class="block" style="margin-top:15px;">
    <el-pagination align='center' @size-change="handleSizeChange" @current-change="handleCurrentChange"
                   :current-page="currentPage"
                   :page-sizes="[5]"
                   :page-size="pageSize"
                   layout="total, sizes, prev, pager, next, jumper"
                   :total="tableData.length">
    </el-pagination>
  </div>
    <el-dialog title="学生个人简历" :visible.sync="resumeTableVisible">
      <el-table :data="resumeData" id="resume">

      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import FileSaver from 'file-saver'
import XLSX from 'xlsx'
export default {
  name: "sAdmin_Export",
  data(){
    return{
      luj:'',
      majors:[],//装下拉框请求的值
      user_major:'',
      user_id:'',
      tableData:[],//存学生信息
      currentPage: 1, // 当前页码
      pageSize: 5 ,// 每页的数据条数

      //简历
      resumeTableVisible:false,
      resumeData:[],
    }
  },
  methods: {
    handleClick(row) {
      console.log(row);
      this.resumeTableVisible=true
    },
    //每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.currentPage = 1;
      this.pageSize = val;
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;
    },
    //获得下拉框选中的value
    getMajor(value) {
      if (value != '') {
        this.user_major = value
        console.log("选择了" + this.user_major)
      } else {
        this.user_major = ''
      }
    },
    //根据下拉框值筛选
    screen: function () {
      if (this.user_major != '全部') {
        this.$axios.post("/school/screenUser",
          this.$qs.stringify({
            user_major: this.user_major
          })
        ).then(response => {
          console.log(response.data)
          this.tableData = response.data
        }).catch(err => {
          console.log(err)
        })
      } else if (this.user_major = "全部") {
        this.$axios.post("/school/queryUser",
        ).then(response => {
          console.log(response.data)
          this.tableData = response.data
        }).catch(err => {
          console.log(err)
        })
      }
    },
    //导出
    downloadExcel:function (){
      this.$axios.post("/school/downloadExcel",
      this.$qs.stringify({
        user_major: this.user_major
      })
      ).then(response => {
        console.log(response)
      }).catch(err =>{
        console.log(err)
      })
    }
  },
  //下拉框的值
  mounted () {
    this.$axios.post("/school/queryMajor"
    ).then(response =>{
      console.log(response)
      this.majors=response.data
    }).catch(err =>{
      console.log(err)
    })
  },
}
</script>

<style scoped>

</style>
