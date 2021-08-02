<template>
  <div>
    <el-main>
<!--      <el-button @click="epallchaxun">查询</el-button>-->
      <!--            表格弹出-->
      <el-table
          :data="this.tableData"
          border
          style="width: 200%">
        <el-table-column
            fixed
            prop="admin_username"
            label="企业名称"
            width="150">
        </el-table-column>
<!--        <el-table-column-->
<!--            prop="admin_account"-->
<!--            label="企业类型"-->
<!--            width="150">-->
<!--        </el-table-column>-->
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
<!--        <el-table-column-->
<!--            prop="create_time"-->
<!--            label="导入时间"-->
<!--            width="120">-->
<!--        </el-table-column>-->
        <el-table-column
            fixed="right"
            label="操作类型"
            width="350">
          <template slot-scope="scope">
            <el-row>
              <!--              ,@click="open2"-->
              <el-button icon="el-icon-search" circle></el-button>
              <el-button circle icon="el-icon-edit" type="primary" @click="enterchaxun()"></el-button>
              <el-button type="success" icon="el-icon-check" circle></el-button>
              <el-button type="info" icon="el-icon-message" circle></el-button>
              <el-button type="warning" icon="el-icon-star-off" circle></el-button>
              <el-button type="danger" icon="el-icon-delete" circle></el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
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
    </el-main>

  </div>
</template>

<script>
export default {
  name: "Menu",
  methods: {
    enterchaxun() {
      // console.log("已经拿到数据——————————————————————————");
      const h = this.$createElement;
      this.$msgbox({
        title: '消息',
        message: h('p', null, [
          h('span', null, '内容可以是 '),
          h('i', { style: 'color: teal' }, 'VNode')
        ]),
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        beforeClose: (action, instance, done) => {
          if (action === 'confirm') {
            this.$axios.get("enter/enterchaxun",{
              params:{
                actiondata:"1",
              }
            }).then(response => {
              console.log(response);
              this.tableData = response.data
            }).catch(error => {
              console.log(error)
            })
            instance.confirmButtonLoading = true;
            instance.confirmButtonText = '执行中...';
            setTimeout(() => {
              done();
              setTimeout(() => {
                instance.confirmButtonLoading = false;
              }, 300);
            }, 3000);
          } else {
            done();
          }
        }
      }).then(action => {
        this.$message({
          type: 'info',
          message: 'action: ' + action
        });
      });
    }
  },
  data() {
    return {
      // tableData: [{
      // }],
      tableData: [{
        // date: '123',//企业名称名称
        // name: '222',//企业类型
        // province: 'tts',//求职人数
        // city: '111111',//就业人数
        // address: '222',//审核状态
        // zip: '100',//营业执照下载
        // drsj:'300',//导入时间
      },
      ],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 1,
    }
  },
  mounted() {
    // console.log("--------");
    console.log(this.$axios)
    this.$axios.get("admin/adminchaxun").then(response => {
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
