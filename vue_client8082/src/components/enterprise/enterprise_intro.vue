<template>
  <div style="position: relative;">
    <div class="banner" style=";background-color: #444c5f;
    background-position: center 0;
    background-repeat: no-repeat;
    background-size: auto 100%;
    color: #fff;
    padding: 29px 0;">
      <div class="inner home-inner" style="position: relative;width: 1184px;max-width: 1184px;margin: 0 auto;">
        <div>
          <div class="info-primary" style="overflow: visible;color: #fff;max-width: 800px;">
            <div class="info" style="margin-left: 25px;display: inline-block;vertical-align: middle;font-size: 14px;">
              <h1 style="font-size: 32px;line-height: 48px;padding: 0 0 3px 0;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
                {{ name }}
              </h1>
              <p style=" font-size: 18px;line-height: 20px;padding: 0;color: rgba(255,255,255,.7);margin-bottom: 13px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
                {{ stage }}
                <em style="display: inline-block;vertical-align: middle;width: 2px;height: 2px;margin: 0 7px;border-radius: 50%;background-color: rgba(255,255,255,.7);font-style: normal;"></em>
                {{ scale }}
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="job-box" style="margin-top: 30px">
      <div class="home-inner" style="max-width: 1184px;max-width: 1184px;margin: 0 auto;">
        <div class="job-detail" style="float: left;width: 836px;margin-right: 0;">
          <div class="detail-content">
            <div class="job-sec" style="position: relative;">
              <h3 style="font-weight: 700;font-size: 20px;color: #424a5e;">公司名称简介</h3>
              <div class="text fold-text" style="word-break: break-all; word-wrap: break-word;max-height: 500px; overflow: hidden;position: relative;">
              {{ intro }}
              </div>
            </div>
          </div>
        </div>
        <div class="job-detail" style="float: left;width: 836px;margin-right: 0;">
          <div class="detail-content">
            <div class="job-sec" style="position: relative;">
              <h3 style="font-weight: 700;font-size: 20px;color: #424a5e;">工商信息</h3>
              <div class="business-detail show-business-all" style="height: auto!important;border: 1px #d9dadf solid;padding: 15px 25px;padding-right: 12px;">
                <ul style="font-size: 0;list-style: none;">
                  <li style="display: inline-block;vertical-align: top;width: 220px;font-size: 18px;padding: 10px 0;list-style: none;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">企业法人:</span>
                    {{ person }}
                  </li>
                  <li style="display: inline-block;vertical-align: top;width: 220px;font-size: 18px;padding: 10px 0;list-style: none;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">成立时间:</span>
                    {{ establishment }}
                  </li>
                  <li class="col-auto" style="width: auto;display: block;vertical-align: top;font-size: 18px;padding: 10px 0;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">企业类型:</span>
                    {{ type }}
                  </li>
                  <li class="col-auto" style="width: auto;display: block;vertical-align: top;font-size: 18px;padding: 10px 0;">
                    <span class="t" style="color: #9fa3b0;padding-right: 0; ">经营状况:</span>
                    {{ status }}
                  </li>
                  <li class="col-auto" style="width: auto;display: block;vertical-align: top;font-size: 18px;padding: 10px 0;">
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
              <div class="job-location" style="-webkit-box-shadow: 0 0 10px rgb(0 0 0 / 10%);margin-top: 20px;font-size: 13px;position: relative;box-shadow: 0 0 10px rgb(0 0 0 / 10%);margin-top: 15px;">
                <div class="location-item show-map" style="position: relative;">
                  <div class="location-address" style="cursor: default;background-position: 15px -1965px;background-position: 15px -420px;padding-left: 25px;color: #62687a;padding: 13px 15px 11px 35px;font-size: 20px;border-bottom: 1px #ecedef solid;">
                    {{ address }}
                  </div>
                  <div class="map-container js-open-detail" style="height: 400px;cursor: pointer;">
                    <baidu-map :scroll-wheel-zoom="true" :center="center" :zoom="zoom" @ready="handler" class="map">
                      <bm-marker :position="center"  @click="infoWindowOpen">
                        <bm-info-window :show="show" @close="infoWindowClose" @open="infoWindowOpen" >{{ address }}</bm-info-window>
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
  </div>
</template>

<script>
let lng;let lat;
export default {
  name: "enterprise_intro",
  data () {
    return {
      center: {lng: 0, lat: 0},
      zoom: 16,
      show: false,
      address: "",//企业地址
      name:"",//企业名称
      person:"",//企业法人
      code:"",//企业代码
      type:"",//企业类型
      status:"",//经营情况
      stage:"",//融资阶段
      scale:"",//企业规模
      establishment:"",//成立时间
      intro:""//企业简介
    }
  },
  mounted() {
    this.initIntro();
  },
  methods: {
    initIntro(){
      this.$axios.post("/enterprise/intro",
        this.$qs.stringify({
          enterprise_name:"美柚"
        })
      ).then(response=>{
        console.log(response.data)
        // this.form=response.data;
        console.log(response.data[0].enterprise_id)
        let msg = response.data[0];
        let center = msg.enterprise_coordinate.split(",")
        lng = center[0]
        lat = center[1]
        this.address =msg.enterprise_address
        this.name =msg.enterprise_name
        this.person=msg.enterprise_legal_person
        this.code=msg.enterprise_code
        this.type=msg.enterprise_type
        this.status=msg.enterprise_operation_status
        this.stage=msg.enterprise_financing_stage
        this.scale=msg.enterprise_scale
        this.establishment=msg.enterprise_time_establishment
        this.intro = msg.enterprise_intro
        // this.center.lng = lng
        // this.center.lat = lat
      }).catch(err=> {
        console.log(err)
      })
    },
    handler () {
      this.center.lng = lng
      this.center.lat = lat
      this.zoom = 16
    },
    infoWindowClose () {
      this.show = false
    },
    infoWindowOpen () {
      this.show = true
    }
  }
}
</script>

<style scoped>
.map {
  width: 836px;
  height: 400px;
}
</style>
