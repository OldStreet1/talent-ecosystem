<template>
  <div>
    <h3>查看已投简历</h3>
    <hr>
    <el-table
    :data="tableData"
    border
    style="width: 800px">
    <el-table-column
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="100">
    </el-table-column>
    <el-table-column
      prop="sex"
      label="性别"
      width="100">
    </el-table-column>
    <el-table-column
      prop="city"
      label="市区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="220">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="button" size="small">查看简历</el-button>
      </template>
    </el-table-column>

  </el-table>
    <!--添加-->
    <UserResume v-if="addDialogVisible" ref="UserResume"></UserResume>
  </div>
</template>

<script>
import UserResume from "./UserResume"
export default {
  name: "Resume_look",
  components: {UserResume},
  data() {
    return {
      addDialogVisible:false,
      tableData: [{
        date: "2016-05-02",
        name: '张三',
        sex: '男',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        zip: 200333
      },
        {
          date: "2016-05-02",
          name: '张三',
          sex: '男',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        },
        {
          date: "2016-05-02",
          name: '张三',
          sex: '男',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        },
        {
          date: "2016-05-02",
          name: '张三',
          sex: '男',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        },
      ]
    }
  },
  methods: {
    handleClick(row) {
      this.Resume()
      // console.log(row);
    },
    Resume(){
      this.addDialogVisible = true;
      console.log("查看")
      this.$nextTick(() => {
        this.$refs.UserResume.init();
      });

    }
  },
}
</script>

<style scoped>

</style>
