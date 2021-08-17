<template>
  <div class="main_down">
    <div class="left">
      <div class="left_up">
        <div class="label_title">
          已建立会话
        </div>
      </div>
      <div class="left_down">
        <div class="label_title">
          可建立会话
        </div>
      </div>
    </div>
    <div class="right">
      <div class="up" ref="element" id="msg_end">
<!--        <p v-for="item in list">{{item.chat_sender}}:{{item.chat_record}}</p>-->
<!--        <p v-for="item in newlist">{{item.chat_sender}}:{{item.chat_record}}</p>-->
        <div v-for="item in list"  :class="item.chat_sender === chat_receiver ? 'msg_right' : 'msg_left'">
          <div class="msg_right_up">
            {{item.chat_sender}}:
          </div>
          <div :class="item.chat_sender === chat_receiver ? 'msg_right_down' : 'msg_left_down'">
            {{item.chat_record}}
          </div>
        </div>
      </div>
      <div class="down">
        <el-input type="textarea" :rows="9" placeholder="请输入内容，回车发送！" @keyup.enter.native = "sendMsg" v-model="textarea">
        </el-input>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
	name: 'Chat',
  data () {
    return {
      socket:"",
      list: [],
      textarea: "",
      chat_sender:"",
      chat_receiver:"",
    }
  },
  mounted () {
    // 初始化
    this.init();
  },
  beforeDestroy() {
    this.closeWebsocket()
  },
  methods: {
    init: function () {
      if (typeof (WebSocket) === "undefined") {
        console.log("您的浏览器不支持socket")
      } else {
        // 实例化socket
        this.socket = new WebSocket("ws://localhost:9091/Websocket/12")
        // 监听socket连接
        this.socket.onopen = this.open
        // 监听socket错误信息
        this.socket.onerror = this.error
        // 监听socket消息
        this.socket.onmessage = this.getMessage
      }
    },
    open: function () {
      console.log("socket连接成功")
        this.msgList();
    },
    error: function () {
      console.log("连接错误")
    },
    getMessage: function (msg) {
      console.log(msg.data)
      let msglist=msg.data.split("&&");
      let data = {
        chat_sender: msglist[0],
        chat_receiver: msglist[1],
        chat_record: msglist[2],
      }
      this.list.push(data)
    },
    send: function () {
      this.socket.send(params)
    },
    close: function () {
      console.log("socket已经关闭")
    },
    // 消息发送
    sendMsg(){
      let data = {
        chat_sender: 12,
        chat_receiver: 156,
        chat_record: this.textarea,
      }
      this.list.push(data)
      // console.log(this.list)
      this.sendmsg();
      this.textarea = ''
    },

    sendmsg(){
      let message ="12&&156&&"+this.textarea
      this.socket.send(message)
      this.$axios.post("http://localhost:9091/enter/addchat",
        this.$qs.stringify({
          message: message,
        })
      ).then(response => {
        console.log(response.data)
      }).catch(err => {
        console.log(err)
      })

    },
    // 获取消息数据
    msgList() {
      this.$axios.post("http://localhost:9091/enter/getchat",
        this.$qs.stringify({
            "sender": "12",
            "receiver": "156"
        })
      ).then(response => {
        console.log(response.data)
        this.list=response.data;
      }).catch(err => {
        console.log(err)
      })
    },
//关闭websocket
    closeWebsocket(){
      if(this.ws){
        this.ws.close();
        let _this=this
        this.ws.onclose = function(evt) {
          console.log("websocket已关闭");
        };
      }
    },

    destroyed() {
      // 销毁监听
      this.socket.onclose = this.close
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.main_down{
		width: 800px;
		height: 700px;
		border: 1px #1890ff solid;
		display: flex;
		justify-self: space-between;
	}
	.left{
		width: 220px;
		height: 700px;
		border-right: 1px #1890ff solid;
	}
	.left_up{
		width: 220px;
		height: 400px;
		overflow-y: auto;
		/* border: 1px red solid; */
	}
	.label_title{
		width: 222px;
		height: 25px;
		background-color: #f8f8f8;
		font-weight: 600;
		padding: 8px;
	}
	.left_down{
		width: 220px;
		height: 275px;
		overflow-y: auto;
		/* border: 1px green solid; */
	}
	.right{
		width: 580px;
		height: 700px;
		/* border-right: 1px #1890ff solid; */
	}
	.up{
		width: 580px;
		height: 500px;
		overflow-y: scroll;
		overflow-x: hidden;
		/* padding-bottom: 40px; */
		border-bottom: 1px #1890ff solid;
	}
	.down{
		width: 580px;
		height: 200px;
		/* border: 1px red solid; */
	}
  .msg_left{
    width: 580px;
    /* padding-left: 5px; */
    margin-top: 5px;
    /* border: 1px #1890ff solid; */
    text-align: left;
  }
  .msg_left_up{
    height: 25px;
    margin-top: 5px;
  }
  .msg_left_down{
    height: 25px;
    /* border: 1px #1890ff solid; */
    padding-left: 10px;
  }
  .msg_right{
    width: 580px;
    /* padding-right: 20px; */
    margin-top: 5px;
    /* border: 1px #1890ff solid; */
    text-align: right;
  }
  .msg_right_up{
    height: 25px;

  }
  .msg_right_down{
    height: 25px;
    /* border: 1px #1890ff solid; */
    padding-right: 10px;
  }
</style>
