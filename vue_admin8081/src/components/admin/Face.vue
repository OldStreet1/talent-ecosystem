<!--import tracking from '@/assets/js/tracking-min.js'-->
<!--import '@/assets/js/face-min.js'-->
<!--<template>-->

<!--</template>-->

<!--<script>-->
<!--  export default {-->
<!--    name: 'login',-->
<!--    data() {-->
<!--      return {-->
<!--        trackerTask: null,-->
<!--        trackering: null,-->
<!--        mediaStreamTrack: null-->
<!--      }-->
<!--    },-->
<!--    mounted() {-->
<!--      this.getCompetence()-->
<!--    },-->
<!--    methods: {-->
<!--      getCompetence() {-->
<!--        let flag = true;-->
<!--        const _this = this;-->
<!--        const video = this.mediaStreamTrack = document.getElementById('videoCamera-face');-->
<!--        const canvas = document.getElementById('canvas-face');-->
<!--        const context = canvas.getContext('2d');-->

<!--        const tracker = new window.tracking.ObjectTracker('face');-->
<!--        tracker.setInitialScale(4);-->
<!--        tracker.setStepSize(2);-->
<!--        tracker.setEdgesDensity(0.1);-->
<!--        // 启动摄像头初始化-->
<!--        this.trackerTask = window.tracking.track('#videoCamera-face', tracker, {-->
<!--          camera: true-->
<!--        });-->
<!--        tracker.on('track', function(event) {-->
<!--          context.clearRect(0, 0, canvas.width, canvas.height);-->
<!--          event.data.forEach(function(rect) {-->
<!--            context.strokeStyle = '#ff0000';-->
<!--            context.strokeRect(rect.x, rect.y, rect.width, rect.height);-->
<!--          });-->
<!--          if (event.data.length) {-->
<!--            // 会不停的去检测人脸，所以这里需要做个锁-->
<!--            if (flag) {-->
<!--              // 裁剪出人脸并绘制下来-->
<!--              const canvasUpload = document.getElementById('canvas-face-upload')-->
<!--              const contextUpload = canvasUpload.getContext('2d')-->
<!--              contextUpload.drawImage(video, 0, 0, 105, 105)-->
<!--              flag = false-->
<!--              // 人脸的basa64-->
<!--              const dataURL = canvasUpload.toDataURL('image/jpeg');-->
<!--              // ajax请求-->
<!--              _this.$store.dispatch('LoginByFaceID', {-->
<!--                face_img: dataURL.slice(23) // 我们后台需要的basa64不要前缀-->
<!--              }).then(res => {-->
<!--                let type = 'success'-->
<!--                // 登录成功跳转到首页-->
<!--                if (res.data.code === 200) {-->
<!--                  _this.$router.push({-->
<!--                    path: '/'-->
<!--                  });-->
<!--                }-->
<!--                // 登录失败重新进行人脸检测-->
<!--                else {-->
<!--                  type = 'error'-->
<!--                  setTimeout(() => {-->
<!--                    flag = true-->
<!--                  }, 1500)-->
<!--                }-->
<!--                _this.$message({-->
<!--                  message: res.data.message,-->
<!--                  type,-->
<!--                  center: true-->
<!--                });-->
<!--              }).catch(error => {-->
<!--                console.log(error)-->
<!--              })-->
<!--            }-->
<!--          }-->
<!--        });-->
<!--      }-->
<!--    },-->
<!--    destroyed() {-->
<!--      if(!this.mediaStreamTrack){-->
<!--      return-->
<!--      }-->
<!--      // 关闭摄像头和侦测-->
<!--      this.mediaStreamTrack.srcObject.getTracks()[0].stop();-->
<!--      this.trackerTask.stop()-->
<!--    }-->
<!--  }-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->
