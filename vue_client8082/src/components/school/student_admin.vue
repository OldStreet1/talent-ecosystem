<template>
  <el-row router >
    <el-col :span="24"><div style="float: left;margin-top: 40px">
      <el-row>
        <el-button type="primary" plain>查看</el-button>
        <el-button type="success" plain>查询</el-button>
        <el-button type="info" icon="el-icon-upload"  plain>导入</el-button>
        <el-button type="warning" icon="el-icon-down"  plain>导出</el-button>
      </el-row>
    </div></el-col>

    <el-col :span="24"><div class="grid-content bg-purple-dark">
      <div><router-view></router-view></div>
      <el-table
        :data="tableData"
        border
        style="width: 100%">
        <el-table-column
          fixed
          prop="user_id"
          label="序号"
          width="50">
        </el-table-column>
        <el-table-column
          prop="user_name"
          label="用户名"
          width="100">
        </el-table-column>
        <el-table-column
          prop="user_pwd"
          label="密码"
          width="100">
        </el-table-column>
        <el-table-column
          prop="user_id_card"
          label="身份证号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="user_nation"
          label="民族"
          width="50">
        </el-table-column>
        <el-table-column
          prop="user_sex"
          label="性别"
          width="50">
        </el-table-column>
        <el-table-column
          prop="user_age"
          label="年龄"
          width="50">
        </el-table-column>
        <el-table-column
          prop="user_date_birth"
          label="出生年月"
          width="100">
        </el-table-column>
        <el-table-column
          prop="user_telephone"
          label="联系电话"
          width="120">
        </el-table-column>
        <el-table-column
          prop="user_email"
          label="邮箱"
          width="120">
        </el-table-column>
        <el-table-column
          prop="user_school_name"
          label="学校"
          width="120">
        </el-table-column>
        <el-table-column
          prop="user_major"
          label="专业"
          width="120">
        </el-table-column>
        <el-table-column
          prop="user_education"
          label="学历"
          width="80">
        </el-table-column>
        <el-table-column
          prop="user_residence"
          label="居住地"
          width="120">
        </el-table-column>
        <el-table-column
          prop="user_graduation_time"
          label="毕业时间"
          width="120">
        </el-table-column>
        <el-table-column
          prop="update_time"
          label="更新时间"
          width="120">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="30px">查看</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'studentTable',
  data () {
    return {
      tableData: [{

      }]
    }
  },
  methods: {
    handleClick (row) {
      console.log(row)
    },
  }
}
</script>

<style scoped>
.bg-purple-dark {
  background: #99a9bf;
  margin-top: 40px;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>
