<template>
  <div>
    <!--头部-->
    <top />
    <!--导航-->
    <navs />

    <!--核心内容start-->
    <section class="heading-page header-text" id="top" >
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h6>获取所有详细信息</h6>
            <h2>在线教学工具</h2>
          </div>
        </div>
      </div>
    </section>

    <!--核心内容-->

    <section id="meetings" class="meetings-page">
      <div class="container">
        <div class="row">

          <div class="col-lg-12">
            <div class="row">
              <div class="col-lg-12">
                <div class="row grid">

                  <div  class="col-lg-4 templatemo-item-col all soon" v-for="team in teamList">
                    <div class="meeting-item">
                      <div class="thumb">
                        <!--                        <a href="#/teaminfo"><img :src="team.images" alt=""></a>-->
                        <router-link :to="{path:'/teaminfo',query:{teamId:team.id}}">
                          <img :src="team.images" width="200px" height="200px" alt="">
                        </router-link>
                      </div>
                      <div class="down-content">
                        <div class="date">
                          <h6>Nov</h6>
                        </div>
                        <a><h4>{{ team.name }}</h4></a>
                        <p>社长：{{ team.userInfo.username }}</p>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <br>
    <br>
    <br>
    <!--底部-->
    <foot />
  </div>
</template>

<script>
import top from '../../qdutils/top/index.vue'
import navs from '../../qdutils/navs/index'
import foot from '../../qdutils/footer/index'
import request from '@/utils/request'

export default {
  name: 'Index',
  components: { top, navs, foot },

  // 初始数据
  data() {
    return {
      teamList: []
    }
  },
  // 获取数据信息
  created() {
    this.getList()
  },
  // 方法列表
  methods: {
    // 获取方法
    getList() {
      request({
        url: 'team/queryMyTeamList',
        method: 'get',
        params: ''
      }).then(res => {

        this.teamList = res.data
      })
    }
  }
}
</script>

<style scoped>
@import url("../../../vendor/bootstrap/css/bootstrap.min.css");
@import url("../../../assets/css/templatemo-edu-meeting.css");
</style>
