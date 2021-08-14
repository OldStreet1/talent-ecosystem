<template>
  <baidu-map :scroll-wheel-zoom="true" :center="center" :zoom="zoom" @ready="handler" class="map">
    <bm-marker :position="center"  @click="infoWindowOpen">
      <bm-info-window :show="show" @close="infoWindowClose" @open="infoWindowOpen" >{{ address }}</bm-info-window>
    </bm-marker>
    <bm-navigation anchor="BMAP_ANCHOR_TOP_LEFT"></bm-navigation>
    <bm-scale anchor="BMAP_ANCHOR_DOWN_LEFT"></bm-scale>
  </baidu-map>
</template>

<script>
export default {
  name: "testMap",
  data () {
    return {
      center: {lng: 0, lat: 0},
      zoom: 16,
      show: false,
      address: "厦门市湖里区安岭二路86号A栋203室"
    }
  },
  methods: {
    handler () {
      this.center.lng = 118.08923
      this.center.lat = 25.479406
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
  width: 660px;
  height: 450px;
}
</style>
