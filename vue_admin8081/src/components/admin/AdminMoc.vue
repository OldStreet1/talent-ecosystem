<template>
<!--  <el-table-->
<!--      :data="tableData"-->
<!--      style="width: 100%"-->
<!--      :default-sort = "{prop: 'date', order: 'descending'}">-->
    <el-table
        :data="this.tableData"
        border
        style="width: 200%">

    <el-table-column
        prop="date"
        label="日期"
        sortable
        width="180">
    </el-table-column>

    <el-table-column
        prop="university_name"
        label="学校名称"
        sortable
        width="180">
    </el-table-column>

    <el-table-column
        prop="university_code"
        label="校园代码"
        sortable
        width="180">
    </el-table-column>

<!--    <el-table-column-->
<!--        prop="address"-->
<!--        label="学校代码"-->
<!--        sortable-->
<!--        :formatter="formatter"-->
<!--    >-->
<!--    </el-table-column>-->

    <el-table-column
        prop="name"
        label="附件上传状态"
        sortable
        width="180">
    </el-table-column>

    <el-table-column
        prop="create_time"
        label="导入时间"
        sortable
        width="180">
    </el-table-column>

    <el-table-column
        prop="update_time"
        label="更新时间"
        sortable
        width="180">
    </el-table-column>

<!--      分页-->
<!--      <div class="block">-->
<!--        <span class="demonstration"></span>-->
<!--        <el-pagination-->
<!--            @size-change="handleSizeChange"-->
<!--            @current-change="handleCurrentChange"-->
<!--            :current-page="currentPage4"-->
<!--            :page-sizes="[100, 200, 300, 400]"-->
<!--            :page-size="10"-->
<!--            layout="total, sizes, prev, pager, next, jumper"-->
<!--            :total="10">-->
<!--        </el-pagination>-->
<!--      </div>-->

  </el-table>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
      ],
      // 分页
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 1
    }
  },
  methods: {
    formatter(row, column) {
      return row.address;
    }
  },
  mounted() {
    console.log(this.$axios)
    this.$axios.get("university/unitychauxn").then(response => {
      console.log(response);
      this.tableData = response.data
    }).catch(error => {
      console.log(error)
    })
  },

}
</script>
