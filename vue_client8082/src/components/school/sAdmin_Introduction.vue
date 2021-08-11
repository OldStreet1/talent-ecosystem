<template>
  <div>

  </div>
</template>

<script>
export default {
  name: "sAdmin_Introduction",
  data(){
    return{
      sData:[],
    }
  },
  mounted() {
    this.$axios.post("/school/queryProfile"
    ).then(response =>{
      console.log(response.data)
    }).catch(err =>{
      console.log(err)
    })
  }
}
</script>

<style scoped>

</style>
