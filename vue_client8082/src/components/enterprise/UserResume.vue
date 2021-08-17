<template>
  <el-dialog
    title="简历页面"
    :visible.sync="dialogVisible"
    :close-on-click-modal="false"
    width="850px">
    <!--    <div >-->
    <div class="resume_box">
      <div class="basic_info_box"
           style="padding:29px 30px 0;position: relative;min-height: 150px;box-sizing: border-box;border: none;display: block;">
        <dl class="basic_info"
            style="padding-right: 130px;min-width: 300px;box-sizing: border-box;padding: 0;border: none;display: block;margin-block-start: 1em;margin-block-end: 1em;margin-inline-start: 0px;margin-inline-end: 0px;">
          <dt id="myname"
              style="font-size: 22px;color: #222;letter-spacing: 2px;padding-bottom: 2px;box-sizing: border-box;padding: 0;border: none;display: block;">
            张三
          </dt>
          <dd
            style="font-size:14px;line-height:16px;margin-left: -10px;box-sizing: border-box;padding: 0;border: none;    display: block;margin-inline-start: 40px;">
            <span style="">求职岗位：行政专员</span>
          </dd>
          <dd
            style="font-size:14px;line-height:16px;margin-left: -10px;box-sizing: border-box;padding: 0;border: none;    display: block;margin-inline-start: 40px;">
            <span style="">30岁</span>
            <span style="">男</span>
            <span style="">上海</span>
            <span style="">6年经验</span>
          </dd>
          <dd
            style="font-size:14px;line-height:16px;margin-left: -10px;box-sizing: border-box;padding: 0;border: none;    display: block;margin-inline-start: 40px;">
            <span style="">15888888888</span>
            <span style="">qmjianli@qq.com</span>
          </dd>
        </dl>
      </div>
      <div class="resume_content_all" style="padding-top: 2px;position: relative;box-sizing: border-box;padding: 0;border: none;display: block;">
        <div class="jiaoyu"
             style="margin-top: 26px;position: relative;top: -10px;font-size: 14px;box-sizing: border-box;padding: 0;border: none;display: block;">
          <div style="box-sizing: border-box;padding: 0;display: block;border: none;">
            <div
              style="font-size:16px;color:#1575bf;border-color:#1575bf;line-height: 20px;height: 25px;font-weight: 400;overflow: hidden;">
              <span>教育背景</span>
            </div>
            <div
              style="font-size:13px;margin-top:14px;line-height:1.9;padding: 0;color: #555;box-sizing: border-box;border: none;display: block;">
              <p>
                2012-09 ~ 2016-07
                全民简历师范大学
                工商管理(本科)
                专业成绩:GPA 3.66/4(专业前5%)
                主修课程:基础会计学、货币银行学、统计学、经济法概论、财务会计学、管理学原理、组织行为学、市场营销学、国际贸易理论、国际贸易实务、人力资源开发与管理、财务管理学、企业经营战略概论、质量管理学、西方经济学等等。
              </p>
            </div>
            <div
              style="font-size:16px;color:#1575bf;border-color:#1575bf;line-height: 20px;height: 25px;font-weight: 400;overflow: hidden;border-bottom: 1px solid #666;white-space: nowrap;box-sizing: border-box;padding: 0;border: none;display: block;">
              <span>工作经验</span>
            </div>
            <div
              style="font-size:13px;margin-top:14px;line-height:1.9;padding: 0;color: #555;box-sizing: border-box;border: none;display: block;">
              <p>
                2018-09~至今
                全民简历科技有限公司
                行政专员
                。拥负责本部的行政人事管理和日常事务，协助总监搞好各部门之间的综合协调，落实公司规章制度，沟通内外联系，保证上情下达和下情上报，负责对会议文件决定的事项进行催办、查办和落实，负责全公司组织系统研讨和修订。
                。编制公司人事管理制度，规避各项人事风险。
                2016-09~ 2018-08
                上海斧掌网络科技有限公司
                行政助理
                。负责中心简单财务管理，资产管控;
                。负责公司总部的来访客户接待工作，负责引导和介绍公司的分布情况;。负责中心的行政事务，公司班车管理、负责建立员工归属感及前台管理;。负责招聘工作，确保人才梯队发展和人才储备及培养。
                。督导公司各项行政、人事制度、员工福利、生日以及公司各种宴会活动的执行。
                。负责招聘工作，制定公司的人力资源发展计划，确保人才梯队发展和人才储备及培养
              </p>
            </div>
            <div
              style="font-size:16px;color:#1575bf;border-color:#1575bf;line-height: 20px;height: 25px;font-weight: 400;overflow: hidden;border-bottom: 1px solid #666;white-space: nowrap;box-sizing: border-box;padding: 0;border: none;display: block;">
              <span>技能特长</span>
            </div>
            <div
              style="font-size:13px;margin-top:14px;line-height:1.9;padding: 0;color: #555;box-sizing: border-box;border: none;display: block;">
              <p>
                语言能力:大学英语6级证书，荣获全国大学生英语竞赛一等奖，能够熟练的进行交流、读写。计算机:计算机二级证书，熟练操作windows平台上的各类应用软件，如Word、Excel。
                团队能力:具有丰富的团队组建与扩充经验和项目管理与协调经验，能够独挡一面。
              </p>
            </div>
            <div
              style="font-size:16px;color:#1575bf;border-color:#1575bf;line-height: 20px;height: 25px;font-weight: 400;overflow: hidden;border-bottom: 1px solid #666;white-space: nowrap;box-sizing: border-box;padding: 0;border: none;display: block;">
              <span>荣誉证书</span>
            </div>
            <div
              style="font-size:13px;margin-top:14px;line-height:1.9;padding: 0;color: #555;box-sizing: border-box;border: none;display: block;">
              <p>
                英语四级，听说读写能力良好，能流利的用英语讲行日常交流，能快速浏览茧文立档和书销
                通过全国计算机二级考试，熟练运用office等常用的办公软件。
              </p>
            </div>
            <div
              style="font-size:16px;color:#1575bf;border-color:#1575bf;line-height: 20px;height: 25px;font-weight: 400;overflow: hidden;border-bottom: 1px solid #666;white-space: nowrap;box-sizing: border-box;padding: 0;border: none;display: block;">
              <span>自我评价</span>
            </div>
            <div
              style="font-size:13px;margin-top:14px;line-height:1.9;padding: 0;color: #555;box-sizing: border-box;border: none;display: block;">
              <p>
                工作积极认真，细心负责，熟练运用办公自动化软件，善于在工作中提出问题、发现问题、解决问题，有较强的分析能力;勤奋好学，踏实肯干，动手能力强，认真负责，有很强的社会责任感;坚毅不拔，吃苦耐劳，喜欢迎接新挑战。
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
      <div style="width: 800px">
        <el-button type="primary" @click="download">下载简历</el-button>
      </div>
    <!--    </div>-->
  </el-dialog>
</template>

<script>
import generateResume from "../../assets/js/pdfMethod";

export default {
  name: "UserResume",
  data() {
    return {
      dialogVisible: false,
    }
  },
  methods: {
    download() {
      this.$confirm('是否确认下载此简历?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        generateResume(
          document.getElementsByClassName('resume_box')[0],
          '简历'
        )
        this.$message({
          type: 'success',
          message: '下载成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消下载'
        });
      });
      console.log("下载")

    },
    init() {
      // this.initData();
      // 展示弹窗
      this.dialogVisible = true;
      console.log(this.dialogVisible)
    },
  }
}
</script>


<style scoped>
.resume_box{
  /*box-shadow: 0 0 10px #909399;*/
  width: 800px;
  position: relative;
  padding-bottom: 2px;
  min-height: 800px;
  color: #333;
  background-color: #fff;
  box-sizing: border-box;
  padding: 0;
  border: none;
  display: block;
  text-align: left;
}
</style>
