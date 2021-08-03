<template>
  <div>
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
    <el-button type="primary"  @click="daoru">导入</el-button>
  <el-button type="primary" @click="downExcel" >下载模板</el-button>

    <el-table
      id="example"
      :data="tableData"
      style="width: 100%">
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
  </div>
</template>

<script>
import FileSaver from 'file-saver'
import XLSX from 'xlsx'

export default {
  name: "sAdmin_Message",
  data() {
    return {
      tableData: [
      ],
    }
  },
  methods: {
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
    },
    // handleRemove(file, fileList) {
    //   console.log(file, fileList);
    // },
    handlePreview(file) {
      console.log(file);
    },
    handleClick(row) {
      console.log(row);
    },
    //下载模板
    downExcel() {
      let et = XLSX.utils.table_to_book(document.getElementById("example"));//此处传入table的DOM节点
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
      }
      return etout;
    },
    chaxun:function (){
      this.$axios.post("/school/schoolname"
      ).then(response => {
        console.log(response.config)
      }).catch(err => {
        console.log(err)
      })
    },
    daoru:function (){
      this.$axios.post("/school/jiex"
      ).then(response =>{
        console.log(response)
      }).catch(err =>{
        console.log(err)
      })
    }
  }
}
</script>

<style scoped>

</style>
