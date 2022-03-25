<template>
  <div id="contain">
    <a-col :span="4" class="side">
      <a-button
        type="dashed"
        @click="backHome"
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
            <a-anchor-link href="#2-4" title="2.4 仓储服务" />
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
    backHome () {
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
</style>
