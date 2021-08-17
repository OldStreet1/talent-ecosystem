<template>
<el-dialog
  title="招聘信息"
  :visible.sync="dialogVisible"
  :close-on-click-modal="false"
  width="800px">
  <div class="main" style="text-align:left">
    <h2>大数据</h2>
    <hr>
    <p>学历要求：本科</p>
    <p>工作经验要求：2年</p>
    <p>参考薪资：8000-12000</p>
    <hr>
    <h2>职位描述</h2>
    <h3>岗位职责：</h3>
    <p>1、基于大数据平台的应用模块的分析、设计和开发；</p>
    <p>2、负责大数据平台的基础架构、ETL设计、流程优化。</p>
    <h3>任职要求：</h3>
    <p>1、2年及以上大数据相关组件的开发与应用经验，计算机相关专业，本科以上学历，熟悉流式分析；</p>
    <p>2、有Hadoop、Flink、Hive等项目应用及部署操作经验；</p>
    <p>3、对MapReduce编程及Spark编程原理有一定的了解；</p>
    <p>4、熟练Linux常用命令以及shell编程；</p>
    <p>5、能独立了解业务需求，并可以转化成系统设计，并能独立完成代码实现；</p>
    <p>6、对新技术敏感，具备良好的学习能力，分析解决问题和沟通表达能力。</p>
    <h2>公司介绍</h2>
    <hr>
    <h3>众达光电</h3>
    <p style="font-size: 16px">&emsp;&emsp;厦门众达光电信息技术股份有限公司(以下简称“公司”)是系集在线娱乐、社区交友与互动为一体综合互联网运营企业，公司是知名在线应用“达达”的开发和运营商，旗下社交平台拥有超过1.2亿移动设备装机量，超过2500万手机实名注册用户数，专注面向我国各年龄层级互联网用户提供一站式交友、婚恋和泛娱乐服务。公司总部位于厦门软件园，并在深圳、武汉等地设立研发中心。多年来，公司始终坚持以用户为中心深入打造在线社交和婚恋领域新型业务模式，目前已建立了涵盖在线直播、社交、娱乐互动、电商等核心业务的应用矩阵，是中国在线交友和婚恋细分领域的龙头企业。
      公司是厦门市科技小巨人企业、福建省科技小巨人领军企业以及国家高新技术企业，自开办以来，公司先后获得厦门市瞪羚企业、区级纳税明星企业、思明区纳税大户、集美区纳税大户、新势力APP金鸣奖、中国产业互联网峰会-新锐创业企业、清科中国最具投资价值企业50强等称号。</p>
  </div>
</el-dialog>
</template>

<script>
export default {
  name: "RecruitInfo",
  data(){
    return{
      dialogVisible:false
    }
  },
  methods:{
    init(){
      this.dialogVisible = true;
    }
  }
}
</script>

<style scoped>
.main{
  width: 760px;
  height: 1000px;
  background-color: beige;
}
</style>
