<template>
  <a-drawer
    title="登记详情"
    width="60%"
    placement="right"
    :closable="true"
    :visible="visible"
    @close="cancel"
  >
    <h2>基本信息</h2>
    <br/>
    <div style="color: white; font-size: 16px; padding-left: 20px">
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>姓名</b> : AA
        </a-col>
        <a-col :span="12">
          <b>性别</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>年龄</b> : AA
        </a-col>
        <a-col :span="12">
          <b>身高</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>体重</b> : AA
        </a-col>
        <a-col :span="12">
          <b>BBBB</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>登记时间</b> : AA
        </a-col>
        <a-col :span="12">
          <b>联系电话</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="24">
          <b>家庭住址</b> : AA
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="24">
          <b>备注</b> : AA
        </a-col>
      </a-row>
    </div>

    <br/>
    <br/>
    <h2>身体状况</h2>
    <br/>
    <div style="color: white; font-size: 16px; padding-left: 20px">
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>体温</b> : AA
        </a-col>
        <a-col :span="12">
          <b>心率</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>血压</b> : AA
        </a-col>
        <a-col :span="12">
          <b>血糖</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>血脂</b> : AA
        </a-col>
        <a-col :span="12">
          <b>左眼视力</b> : BB
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="12">
          <b>右眼视力</b> : AA
        </a-col>
      </a-row>
      <a-row :gutter="16" style="margin-bottom: 15px">
        <a-col :span="24">
          <b>详情描述</b> : AA
        </a-col>
      </a-row>
    </div>
  </a-drawer>
</template>

<script>
export default {
  name: 'UserModal',
  data () {
    return {
      visible: false
    }
  },
  methods: {
    paramReceive (type, data) {
      this.visible = true
      console.log('data', data)
    },
    cancel () {
      this.visible = false
    }
  }
}
</script>

<style scoped>
</style>
