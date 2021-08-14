<template>
  <div>
    <el-button type="primary" @click="show=!show" style="float: left;height: 55px;width: 100px">上传文件</el-button>
    <div class="divUp" v-if="show">
    <el-upload
      style="float: left"
      class="upload-demo"
      ref="upload"
      action
      :on-preview="handlePreview"
      :auto-upload="false"
      accept=".xlsx,.xls"
      :http-request="UploadSubmit"
    >
      <el-button slot="trigger" size="small" type="primary" @click="chaxun">选取文件</el-button>
      <el-button
        style="margin-left: 10px"
        size="small"
        type="success"
        @click="submitUpload"
      >上传到服务器</el-button>
    </el-upload>
    </div>
    <el-button type="primary"  @click="daoru" style="float: left;margin-left: 50px;height: 55px;width: 80px">导入</el-button>
    <el-button type="primary"  style="height: 55px;width: 80px;margin-left: 400px" @click="query">刷新</el-button>
  <el-button type="primary" @click="dialogTableVisible = true" style="float: right;height: 55px;width: 100px">下载模板</el-button>

    <el-table
      v-if="showTable"
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
    </el-table>
    <div class="block" style="margin-top:15px;"v-if="showTable">
      <el-pagination align='center' @size-change="handleSizeChange" @current-change="handleCurrentChange"
                     :current-page="currentPage"
                     :page-sizes="[5]"
                     :page-size="pageSize"
                     layout="total, sizes, prev, pager, next, jumper"
                     :total="tableData.length">
      </el-pagination>
    </div>
<!--    //模板-->
    <el-dialog title="模板" :visible.sync="dialogTableVisible">
      <el-table :data="gridData" id="table">
        <el-table-column prop="user_id" label="序号"></el-table-column>
        <el-table-column prop="user_name" label="用户名"></el-table-column>
        <el-table-column prop="user_pwd" label="密码"></el-table-column>
        <el-table-column prop="user_id_card" label="身份证号"></el-table-column>
        <el-table-column prop="user_nation" label="民族"></el-table-column>
        <el-table-column prop="user_sex" label="性别"></el-table-column>
        <el-table-column prop="userage" label="年龄"></el-table-column>
        <el-table-column prop="user_date_birth" label="出生年月"></el-table-column>
        <el-table-column prop="user_telephone" label="联系电话"></el-table-column>
        <el-table-column prop="user_email" label="邮箱"></el-table-column>
        <el-table-column prop="user_school_name" label="学校名称"></el-table-column>
        <el-table-column prop="user_major" label="专业"></el-table-column>
        <el-table-column prop="user_education" label="学历"></el-table-column>
        <el-table-column prop="user_residence" label="居住地"></el-table-column>
        <el-table-column prop="user_graduation_time" label="毕业时间"></el-table-column>

        <el-table-column prop="work_exp" label="工作经历"></el-table-column>
        <el-table-column prop="job_intention" label="求职意向"></el-table-column>
        <el-table-column prop="exp_salary" label="期望薪资"></el-table-column>
        <el-table-column prop="edu_back" label="教育背景"></el-table-column>
        <el-table-column prop="honor_certify" label="荣誉证书"></el-table-column>
        <el-table-column prop="self-appraisal" label="自我评价"></el-table-column>
        <el-table-column prop="hobbies" label="兴趣爱好"></el-table-column>
        <el-table-column prop="family_ties" label="家庭关系"></el-table-column>
      </el-table>
      <el-button @click="downExcel">下载</el-button>
    </el-dialog>
  </div>
</template>

<script>
import FileSaver from 'file-saver'
import XLSX from 'xlsx'

export default {
  name: "sAdmin_Message",
  data() {
    return {
      show:false,
      showTable:false,
      tableData: [],
      currentPage: 1, // 当前页码
      pageSize: 5 ,// 每页的数据条数

      //模板
      dialogTableVisible: false,
      gridData:[],
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
  methods: {
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
    //上传
    UploadSubmit(param) {
      var file = param.file;
      console.log(param.file);
      var file_form = new FormData(); //获取上传表单（文件）
      file_form.append("file", file);
      console.log(file_form);
      this.$axios({
        url: "/school/upload",
        method: "POST",
        data: file_form,
      })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    submitUpload() {
      this.$refs.upload.submit();
        alert("上传成功")
      this.show=false;
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleClick(row) {
      console.log(row);
    },
    //下载模板
    downExcel() {
      this.tableData=[]
      let et = XLSX.utils.table_to_book(document.getElementById("table"));//此处传入table的DOM节点
      let etout = XLSX.write(et, {
        bookType:"xls",
        bookSST:true,
        type:"array"
      });
      try {
        FileSaver.saveAs(
          new Blob([etout], {
            type:"application/octet-stream"
          }),
          `人才信息模板.xls`
        );//导出的文件名
      }catch (e) {
        console.log(e, etout);
        this.dialogTableVisible=false
      }
      return etout;
    },
    //查询学校名字
    chaxun:function (){
      this.$axios.post("/school/schoolname"
      ).then(response => {
        console.log(response.config)
      }).catch(err => {
        console.log(err)
      })
    },
    //导入数据库
    daoru:function (){
      this.$axios.post("/school/jiex"
      ).then(response =>{
        console.log(response)
        if (response.data!==''){
          alert("成功导入")
        }
      }).catch(err =>{
        console.log(err)
      })
    },
    query:function (){
      this.$axios.post("/school/queryUser"
      ).then(response =>{
        console.log(response)
        this.showTable=true
        this.tableData=response.data
      }).catch(err =>{
        console.log(err)
      })
    }
  }
}
</script>

<style scoped>
.divUp{
  position: absolute;
  top: 150px;
  left: 650px;
  z-index: 2;
}
</style>
