<template>
  <div class="body">
    <h3>修改密码</h3>
    <hr>
    <form action="changePwd">
      <el-input v-model="oldPwd" type="password" class="pwd" placeholder="请输入原密码:"></el-input>
      <br>
      <el-input v-model="newPwd" type="password" class="pwd" placeholder="请输入新密码:"></el-input>
      <br>
      <el-input v-model="confirmPwd" type="password" class="pwd" placeholder="请输入确认密码:"></el-input>
      <br>
      <el-button class="button" @click="change()">确认</el-button>
      <el-button class="button" @click="clear()">清空</el-button>
    </form>
  </div>
</template>

<script>
export default {
  name: "ChangePwd",
  data() {
    return {
      oldPwd: '',
      newPwd: '',
      confirmPwd: '',
    }
  },
  methods: {
    change() {
      if (this.oldPwd === "") {
        this.$message.error('原密码不能为空');
      } else if (this.newPwd === "") {
        this.$message.error('新密码不能为空');
      } else if (this.confirmPwd === "") {
        this.$message.error('确认密码不能为空');
      } else if (this.confirmPwd !== this.newPwd) {
        this.$message.error('新密码和确认密码不同');
      }
      this.$axios.post("/enterprise/changePwd",
        this.$qs.stringify({
          action: 'changePwd',
          oldPwd: this.oldPwd,
          enterprise_pwd: this.newPwd,
        })
      ).then(response => {
        console.log(response)
        if (response.data == "success") {
          this.$message({
            message: "密码修改成功",
            type: "success"
          })
        } else {
          this.$message.error('密码修改失败')
        }
      }).catch(error => {
        console.log(error)
      })
    },
    clear() {
      this.oldPwd = ""
      this.newPwd = ""
      this.confirmPwd = ""
    }
  }
}
</script>

<style scoped>
.body {
  width: 800px;
  height: 700px;
}

.pwd {
  width: 300px;
  height: 50px;
  margin-top: 20px;
}

.button {
  width: 80px;
  height: 50px;
  margin-top: 20px;
}
</style>
