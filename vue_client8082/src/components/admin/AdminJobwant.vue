<template>
  <el-table
      :data="tableData"
      border
      show-summary
      style="width: 100%">
    <el-table-column
        prop="name"
        label="统计类型">
    </el-table-column>
    <el-table-column
        prop="amount1"
        sortable
        label="在线人数">
    </el-table-column>
    <div class="block">
      <span class="demonstration"></span>
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="10">
      </el-pagination>
    </div>
  </el-table>
</template>

<script>
export default {
  name: "AdminJobwant",
  data() {
    return {
      tableData: [{
        name: '求职总数',//统计类型
        amount1: '',//在线人数
      },
        {
          name: '',//统计类型
          amount1: '',//在线人数
        },
        {
          name: '',//统计类型
          amount1: '',//在线人数
        },{
          name: '',//统计类型
          amount1: '',//在线人数
        },
      ],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 1,
    };
  },
  methods: {
    getSummaries(param) {
      const {columns, data} = param;
      const sums = [];
      columns.forEach((column, index) => {
        if (index === 0) {
          sums[index] = '总价';
          return;
        }
        const values = data.map(item => Number(item[column.property]));
        if (!values.every(value => isNaN(value))) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr);
            if (!isNaN(value)) {
              return prev + curr;
            } else {
              return prev;
            }
          }, 0);
          sums[index] += '/人';
        } else {
          sums[index] = 'N/A';
        }
      });
      return sums;
    }
  }
}
</script>

<style scoped>

</style>
