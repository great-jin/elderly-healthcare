<template>
  <div id="contain">
    <a-col :span="4" class="side">
      <a-button
        type="dashed"
        @click="quit"
        style="width: 100%; margin-bottom: 30px"
      >
        <a-icon type="arrow-left" />
        返回
      </a-button>
      <a-affix :offset-top="top">
        <a-anchor>
          <a-anchor-link href="#1" title="1. 基本介绍" />
          <a-anchor-link href="#2" title="2. 功能模块">
            <a-anchor-link href="#2-1" title="2.1 公共服务" />
            <a-anchor-link href="#2-2" title="2.2 人力资源" />
            <a-anchor-link href="#2-3" title="2.3 资产中心" />
            <a-anchor-link href="#2-4" title="2.4 仓储管理" />
          </a-anchor-link>
          <a-anchor-link href="#3" title="3. 常见问题">
            <a-anchor-link href="#3-1" title="3.1 登录问题" />
            <a-anchor-link href="#3-2" title="3.2 功能异常" />
          </a-anchor-link>
          <a-anchor-link href="#4" title="4. 关于我们" />
        </a-anchor>
      </a-affix>
    </a-col>

    <a-col :span="20" class="content">
      <div>
        <h2 id="1">一、基本介绍</h2>
        <ol>
          <li><b>平台介绍</b></li>
          <span>疗养与养老一体化治理系统</span>
        </ol>
      </div>
      <br/>
      <br/>
      <div>
        <h2 id="2">二、功能模块</h2>
        <ol>
          <li id="2-1"><b>公共服务</b></li>
          <span>公共服务模块包含系统的信息展示、数据监控，同时包含病人的信息登记管理等功能。</span>
          <br/>
          <li id="2-2"><b>人力资源</b></li>
          <span>人力资源模块包含请假申请等功能。</span>
          <br/>
          <li id="2-3"><b>资产中心</b></li>
          <span>资产中心模块包含请假费用结算与物资申请等功能。</span>
          <br/>
          <li id="2-4"><b>仓储管理</b></li>
          <span>仓储管理模块包含请物资采购申请与药品与货物的基础管理。</span>
        </ol>
      </div>
      <br/>
      <br/>
      <div>
        <h2 id="3">三、常见问题</h2>
        <ol>
          <li id="3-1"><b>登录问题</b></li>
          <span>由于网络波动或引起登录问题，请重试后再行尝试。</span>
        </ol>
      </div>
    </a-col>
  </div>
</template>

<script>
export default {
  name: 'Question',
  data () {
    return {
      form: this.$form.createForm(this),
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 13 }
      },
      top: 10
    }
  },
  methods: {
    quit () {
      this.$router.push('/elderlyHealthcare/home')
    }
  }
}
</script>

<style scoped>
  #contain{
    padding: 20px;
  }
  .side{
    padding: 15px;
    margin: auto 0px;
  }
  .content{
    padding: 15px;
  }
  li{
    font-size: 16px;
    margin-top: 10px;
  }
</style>
