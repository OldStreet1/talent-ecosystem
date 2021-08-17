<template>
  <div>
    <h3>高校简介</h3>
    <el-input
      type="textarea"
      :rows="10"
      v-for="item in sData"
      :key="item.university_profile"
      :label="item.university_profile"
      :value="item.university_profile">
    </el-input>
  </div>
</template>

<script>
export default {
  name: "sAdmin_Introduction",
  data(){
    return{
      sData:[],
      university_profile:''
    }
  },
  mounted() {
    this.$axios.post("/school/queryProfile"
    ).then(response =>{
      console.log(response.data)
      this.sData=response.data
    }).catch(err =>{
      console.log(err)
    })
  }
}
</script>

<style scoped>

</style>
