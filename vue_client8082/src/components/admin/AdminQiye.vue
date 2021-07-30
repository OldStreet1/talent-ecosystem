<template>
  <div>
    <el-main>
      <!--            表格弹出-->
      <el-table
          :data="tableData"
          border
          style="width: 200%">
        <el-table-column
            fixed
            prop="date"
            label="企业名称"
            width="150">
        </el-table-column>
        <el-table-column
            prop="name"
            label="企业类型"
            width="150">
        </el-table-column>
        <el-table-column
            prop="province"
            label="求职人员总数"
            width="120">
        </el-table-column>
        <el-table-column
            prop="city"
            label="就业人数"
            width="120">
        </el-table-column>
        <el-table-column
            prop="address"
            label="审核状态"
            width="120">
        </el-table-column>
        <el-table-column
            prop="zip"
            label="营业执照下载"
            width="120">
        </el-table-column>
        <el-table-column
            prop="zip"
            label="审核状态"
            width="120">
        </el-table-column>
        <el-table-column
            prop="zip"
            label="导入时间"
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
              <el-button type="danger" icon="el-icon-delete" circle></el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
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
    </el-main>

  </div>
</template>

<script>
export default {
  name: "Menu",
  data() {
    return {
      tableData: [{
        date: '',//岗位名称
        name: '',//岗位类型
        province: '',//岗位薪资
        city: '',//最高学历
        address: '',//工作地址
        zip: '',//工作经验
      },
        {
          date: '',//岗位名称
          name: '',//岗位类型
          province: '',//岗位薪资
          city: '',//最高学历
          address: '',//工作地址
          zip: '',//工作经验
        },
        {
          date: '',//岗位名称
          name: '',//岗位类型
          province: '',//岗位薪资
          city: '',//最高学历
          address: '',//工作地址
          zip: '',//工作经验
        },
        {
          date: '',//岗位名称
          name: '',//岗位类型
          province: '',//岗位薪资
          city: '',//最高学历
          address: '',//工作地址
          zip: '',//工作经验
        },
        {
          date: '',//岗位名称
          name: '',//岗位类型
          province: '',//岗位薪资
          city: '',//最高学历
          address: '',//工作地址
          zip: '',//工作经验
        },
        {
          date: '',//岗位名称
          name: '',//岗位类型
          province: '',//岗位薪资
          city: '',//最高学历
          address: '',//工作地址
          zip: '',//工作经验
        },
        {
          date: '',//岗位名称
          name: '',//岗位类型
          province: '',//岗位薪资
          city: '',//最高学历
          address: '',//工作地址
          zip: '',//工作经验
        },
      ],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 1,
    }

  }
}

</script>

<style scoped>

</style>
