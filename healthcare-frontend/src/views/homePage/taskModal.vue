<template>
  <a-modal
    :title="type === 'edit' ? '编辑' : '详情'"
    :visible="visible"
    width="70%"
    @cancel="cancel"
  >
    <template slot="footer">
      <a-button key="back" @click="cancel()">取消</a-button>
      <a-button
        key="submit"
        type="primary"
        v-if="!disabled"
        @click="ok"
      >确定</a-button>
    </template>

    <a-form-model>
    <a-descriptions title="任务详情" bordered>
      <a-descriptions-item label="任务编号" v-if="taskInfo.taskId">
        {{ taskInfo.taskId.substr(0, 8) }}
      </a-descriptions-item>
      <a-descriptions-item label="任务名称">
        {{ taskInfo.taskName }}
      </a-descriptions-item>
      <a-descriptions-item label="负责病人">
        {{ patientInfo.patientName }}
      </a-descriptions-item>
      <a-descriptions-item label="创建时间">
          <a-date-picker
            v-model="taskInfo.createdTime"
            :disabled="true"
          />
      </a-descriptions-item>
      <a-descriptions-item label="更新时间">
          <a-date-picker
            v-model="taskInfo.updateTime"
            :disabled="disabled"
            placeholder="Null"
          />
      </a-descriptions-item>
      <a-descriptions-item label="是否延期">
        <a-tag v-if="taskInfo.isDelay === 1" color="red">已延期</a-tag>
        <a-tag v-if="taskInfo.isDelay === 0" color="blue">未延期</a-tag>
      </a-descriptions-item>
      <a-descriptions-item label="完成时间">
        <a-date-picker
          v-model="taskInfo.finishTime"
          :disabled="disabled"
          placeholder="Null"
        />
      </a-descriptions-item>
      <a-descriptions-item label="是否完成">
        <a-tag v-if="taskInfo.isFinished === 1" color="blue">已完成</a-tag>
        <a-tag v-if="taskInfo.isFinished === 0" color="red">未完成</a-tag>
      </a-descriptions-item>
      <a-descriptions-item>
      </a-descriptions-item>
      <a-descriptions-item label="任务内容" :span="24">
        <a-textarea
          v-model="taskInfo.taskContent"
          type="text"
          :rows="4"
          :disabled="true"
          placeholder="任务内容"
          />
      </a-descriptions-item>
      <a-descriptions-item label="备注" :span="24">
        <a-textarea
          v-model="taskInfo.comment"
          type="text"
          :rows="3"
          :disabled="disabled"
          placeholder="备注"
        />
      </a-descriptions-item>
    </a-descriptions>
    </a-form-model>
  </a-modal>
</template>

<script>
import { getPatientInfo } from '@/api/patientInfo'

export default {
  name: 'TaskModal',
  data () {
    return {
      type: '',
      visible: false,
      disabled: false,
      taskInfo: {},
      patientInfo: {}
    }
  },
  methods: {
    paramReceive (type, data) {
      this.type = type
      this.visible = true
      this.taskInfo = data
      console.log(this.taskInfo)
      if (type === 'more') {
        this.disabled = true
      }
      getPatientInfo(data.patientId).then(res => {
        this.patientInfo = res.data
      })
    },
    ok () {

    },
    cancel () {
      this.visible = false
      this.disabled = false
    }
  }
}
</script>

<style scoped>

</style>
