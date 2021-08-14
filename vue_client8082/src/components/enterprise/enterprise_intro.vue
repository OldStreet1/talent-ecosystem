<template>
  <div class="body" style="position: relative;">
    <a href="#up">
      <div class="toup"></div>
    </a><a name="up"></a>

    <div class="header">
      <router-link class="talent" to="Home">人才生态圈</router-link>
      <router-link class="home" to="Home">首页</router-link>
      <router-link class="post" to="Post">职位</router-link>
      <router-link class="university" to="University">校园</router-link>
      <router-link class="enterprise" to="enterprise_login">企业</router-link>
      <router-link class="resume" to="Resume">简历</router-link>
      <router-link class="applet" to="Applet">小程序</router-link>
<!--      <router-link class="upload-resume" to="UploadResume">上传简历</router-link>-->
      <router-link class="recruit" to="Recruit">我要招聘</router-link>
      <router-link class="register" to="enterprise_register">注册</router-link>
      <router-link class="elogin" to="enterprise_login">登录</router-link>
      <router-link class="elogin" to="school_login">高校入口</router-link>
      <router-link class="elogin" to="AdminUser">后台管理</router-link>
      <router-link class="my" to="My">个人中心</router-link>
    </div>
    <div class="job-box" style="margin-top: 30px">
      <div class="home-inner" style="max-width: 1184px;max-width: 1184px;margin: 0 auto;">
        <div class="job-detail" style="float: left;width: 836px;margin-right: 0;">
          <div class="detail-content">
            <div class="job-sec" style="position: relative;">
              <h2>公司名称简介</h2>
              <div class="text fold-text"
                   style="word-break: break-all; word-wrap: break-word;max-height: 500px; overflow: hidden;position: relative;">
                {{ intro }}
              </div>
            </div>
          </div>
        </div>
        <div class="job-detail" style="float: left;width: 836px;margin-right: 0;">
          <div class="detail-content">
            <div class="job-sec" style="position: relative;">
              <h3 style="font-weight: 700;font-size: 20px;color: #424a5e;">工商信息</h3>
              <div class="business-detail show-business-all"
                   style="height: auto!important;border: 1px #d9dadf solid;padding: 15px 25px;padding-right: 12px;background-color: white">
                <ul style="font-size: 0;list-style: none;">
                  <li style="display: inline-block;vertical-align: top;width: 220px;font-size: 18px;padding: 10px 0;list-style: none;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">企业法人:</span>
                    {{ person }}
                  </li>
                  <li style="display: inline-block;vertical-align: top;width: 220px;font-size: 18px;padding: 10px 0;list-style: none;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">成立时间:</span>
                    {{ establishment }}
                  </li>
                  <li class="col-auto"
                      style="width: auto;display: block;vertical-align: top;font-size: 18px;padding: 10px 0;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">企业类型:</span>
                    {{ type }}
                  </li>
                  <li class="col-auto"
                      style="width: auto;display: block;vertical-align: top;font-size: 18px;padding: 10px 0;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">经营状况:</span>
                    {{ status }}
                  </li>
                  <li class="col-auto"
                      style="width: auto;display: block;vertical-align: top;font-size: 18px;padding: 10px 0;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">企业代码:</span>
                    {{ code }}
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="job-detail" style="float: left;width: 836px;margin-right: 0;">
          <div class="detail-content">
            <div class="job-sec" style="position: relative;">
              <h3 style="font-weight: 700;font-size: 20px;color: #424a5e;">公司地址</h3>
              <div class="job-location"
                   style="-webkit-box-shadow: 0 0 10px rgb(0 0 0 / 10%);margin-top: 20px;font-size: 13px;position: relative;box-shadow: 0 0 10px rgb(0 0 0 / 10%);margin-top: 15px;background-color: white">
                <div class="location-item show-map" style="position: relative;">
                  <div class="location-address"
                       style="cursor: default;background-position: 15px -1965px;background-position: 15px -420px;padding-left: 25px;color: #62687a;padding: 13px 15px 11px 35px;font-size: 20px;border-bottom: 1px #ecedef solid;">
                    {{ address }}
                  </div>
                  <div class="map-container js-open-detail" style="height: 400px;cursor: pointer;">
                    <baidu-map :scroll-wheel-zoom="true" :center="center" :zoom="zoom" @ready="handler" class="map">
                      <bm-marker :position="center" @click="infoWindowOpen">
                        <bm-info-window :show="show" @close="infoWindowClose" @open="infoWindowOpen">{{
                            address
                          }}
                        </bm-info-window>
                      </bm-marker>
                      <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
                      <bm-scale anchor="BMAP_ANCHOR_DOWN_LEFT"></bm-scale>
                    </baidu-map>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <h1>人才生态圈</h1>
      <span class="call-us">联系电话：2021-8080808</span>
      <span class="come-us">联系地址：厦门市思明区望海路25-2软件园2期</span>
      <router-link to="Home">
        <img class="wechat" src="../../assets/images/wechat.png" alt="">
      </router-link>
      <router-link to="Home">
        <img class="weibo" src="../../assets/images/weibo.png" alt="">
      </router-link>
      <router-link to="My">
        <img class="apps" src="../../assets/images/apps.png" alt="">
      </router-link>
    </div>
  </div>
</template>

<script>
let lng;
let lat;
export default {
  name: "enterprise_intro",
  data() {
    return {
      center: {lng: 0, lat: 0},
      zoom: 16,
      show: false,
      address: "",//企业地址
      name: "",//企业名称
      person: "",//企业法人
      code: "",//企业代码
      type: "",//企业类型
      status: "",//经营情况
      stage: "",//融资阶段
      scale: "",//企业规模
      establishment: "",//成立时间
      intro: ""//企业简介
    }
  },
  mounted() {
    this.initIntro();
  },
  methods: {
    initIntro() {
      this.$axios.post("/enterprise/intro",
          this.$qs.stringify({
            enterprise_name: "美柚"
          })
      ).then(response => {
        console.log(response.data)
        // this.form=response.data;
        console.log(response.data[0].enterprise_id)
        let msg = response.data[0];
        let center = msg.enterprise_coordinate.split(",")
        lng = center[0]
        lat = center[1]
        this.address = msg.enterprise_address
        this.name = msg.enterprise_name
        this.person = msg.enterprise_legal_person
        this.code = msg.enterprise_code
        this.type = msg.enterprise_type
        this.status = msg.enterprise_operation_status
        this.stage = msg.enterprise_financing_stage
        this.scale = msg.enterprise_scale
        this.establishment = msg.enterprise_time_establishment
        this.intro = msg.enterprise_intro
        // this.center.lng = lng
        // this.center.lat = lat
      }).catch(err => {
        console.log(err)
      })
    },
    handler() {
      this.center.lng = lng
      this.center.lat = lat
      this.zoom = 16
    },
    infoWindowClose() {
      this.show = false
    },
    infoWindowOpen() {
      this.show = true
    }
  }
}
</script>

<style scoped>
.body {
  width: 100%;
  height: 1000px;
  background-image: url("../../assets/images/back.jpg");
}

.header {
  width: 100%;
  height: 80px;
  background-color: #2c3e50;
  color: white;
}

.talent {
  color: #40E0D0;
  font-size: 26px;
  font-family: 楷体;
  font-weight: bold;
  line-height: 80px;
  text-decoration: none;
}

.home, .post, .university, .enterprise, .resume, .applet {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 20px;
  line-height: 50px;
  text-decoration: none;
}

.home:hover, .post:hover, .university:hover, .enterprise:hover, .resume:hover, .applet:hover, .upload-resume:hover, .recruit:hover, .elogin:hover, .register:hover, .my:hover {
  color: #40E0D0;
}

.upload-resume {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 100px;
  line-height: 50px;
  text-decoration: none;
}

.recruit {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 20px;
  line-height: 50px;
  text-decoration: none;
}

.register {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 100px;
  line-height: 50px;
  text-decoration: none;
}

.elogin {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 30px;
  line-height: 50px;
  text-decoration: none;
}

.my {
  color: white;
  font-size: 16px;
  font-family: 微软雅黑;
  margin-left: 160px;
  line-height: 50px;
  text-decoration: none;
}

.job-box {
  width: 1200px;
  height: 880px;
  margin-left: 500px;
}

.map {
  width: 836px;
  height: 400px;
}

.footer {
  color: white;
  width: 100%;
  height: 165px;
  background-color: #2c3e50;
  position: absolute;
}

.footer h1 {
  color: #40E0D0;
  font-family: 楷体;
  font-weight: bold;
  line-height: 50px;
}

.call-us {
  margin-right: 50px;
}

.wechat {
  width: 50px;
  height: 50px;
  position: absolute;
  top: 80px;
  left: 1350px;
}

.weibo {
  width: 50px;
  height: 50px;
  position: absolute;
  top: 80px;
  left: 1400px;
}

.apps {
  width: 50px;
  height: 50px;
  position: absolute;
  top: 80px;
  left: 1450px;
}

.toup {
  width: 50px;
  height: 50px;
  position: fixed;
  margin-left: 1800px;
  margin-top: 850px;
  z-index: 99;
  background-image: url("../../assets/images/toup.png");
}
</style>
