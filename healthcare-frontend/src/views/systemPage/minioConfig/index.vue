<template>
  <div id="container">
    <a-row :style="{margin: '15px 0 40px 0'}">
      <a-col :span="24">
        <h4>1.&nbsp;新 建 存 储 桶：
          <a-input
            v-model="newBucket"
            placeholder="请输入桶名"
            style="width: 200px;"
          />
          <a-button type="link" @click="clickOption('new')">新增</a-button>
          <a-tooltip>
            <template slot="title">
              存储桶命名必须遵守Amazon S3标准。
            </template>
            <a-icon type="info-circle" />
          </a-tooltip>
        </h4>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '40px'}">
      <a-col :span="24">
        <h4>2.&nbsp;删 除 存 储 桶：
          <a-select
            v-model="deleteBucket"
            :allowClear="true"
            placeholder="请选择存储桶"
            style="width: 200px;"
          >
            <a-select-option
              v-for="option in bucketList"
              :key="option"
              :value="option"
            >{{ option }}</a-select-option>
          </a-select>
          <a-button type="link" @click="clickOption('delete')">删除</a-button>
        </h4>
      </a-col>
    </a-row>

    <a-row :style="{marginBottom: '40px'}">
      <a-col :span="12">
        <h4>
          3.&nbsp;病例文件桶名：
          <a-select
            v-model="buckets.caseBucket"
            :allowClear="true"
            placeholder="请选择存储桶"
            style="width: 200px; padding: 0 5px"
          >
            <a-select-option
              v-for="option in bucketList"
              :key="option"
              :value="option"
            >{{ option }}</a-select-option>
          </a-select>
          <a-button type="link" @click="replaceBucket('case')">替换</a-button>
        </h4>
      </a-col>
      <a-col :span="12">
        <h4>
          4.&nbsp;工资文件桶名：
          <a-select
            v-model="buckets.salaryBucket"
            :allowClear="true"
            placeholder="请选择存储桶"
            style="width: 200px; padding: 0 5px"
          >
            <a-select-option
              v-for="option in bucketList"
              :key="option"
              :value="option"
            >{{ option }}</a-select-option>
          </a-select>
          <a-button type="link" @click="replaceBucket('salary')">替换</a-button>
        </h4>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '30px'}">
      <a-col :span="12">
        <h4>
          5.&nbsp;头像文件桶名：
          <a-select
            v-model="buckets.avatarBucket"
            :allowClear="true"
            placeholder="请选择存储桶"
            style="width: 200px; padding: 0 5px"
          >
            <a-select-option
              v-for="option in bucketList"
              :key="option"
              :value="option"
            >{{ option }}</a-select-option>
          </a-select>
          <a-button type="link" @click="replaceBucket('avatar')">替换</a-button>
        </h4>
      </a-col>
      <a-col :span="12">
        <h4>
          6.&nbsp;仓储文件桶名：
          <a-select
            v-model="buckets.storageBucket"
            :allowClear="true"
            placeholder="请选择存储桶"
            style="width: 200px; padding: 0 5px"
          >
            <a-select-option
              v-for="option in bucketList"
              :key="option"
              :value="option"
            >{{ option }}</a-select-option>
          </a-select>
          <a-button type="link" @click="replaceBucket('storage')">替换</a-button>
        </h4>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import { getBuckets, createBucket, deleteBucket, listMinioConfig } from '@/api/sysFileConfig'

export default {
  name: 'formDemo',
  data () {
    return {
      newBucket: '',
      deleteBucket: undefined,
      bucketList: [],
      buckets: {
        caseBucket: undefined,
        salaryBucket: undefined,
        avatarBucket: undefined,
        storageBucket: undefined
      }
    }
  },
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      getBuckets().then(res => {
        this.bucketList = res.data
      })
      listMinioConfig().then(res => {
        this.buckets = res.data[0]
        console.log('aaaa', res.data[0])
      })
    },
    clickOption (data) {
      switch (data) {
        case 'new':
          if (this.newBucket !== '') {
            createBucket(this.newBucket).then(res => {
              if (res.data) {
                this.$message.success('新增成功')
                this.newBucket = ''
              }
            })
          } else {
            this.$message.error('请先输入存储桶名')
          }
          break
        case 'delete':
          if (this.deleteBucket !== undefined && this.deleteBucket !== '') {
            deleteBucket(this.deleteBucket).then(res => {
              if (res.data) {
                this.$message.success('删除成功')
                this.deleteBucket = undefined
              }
            })
          } else {
            this.$message.error('请先选择存储桶')
          }
          break
      }
      setTimeout(() => {
        this.getData()
      })
    },
    replaceBucket (data) {
      switch (data) {
        case 'case':
          this.$message.success('case')
          break
        case 'salary':
          this.$message.success('salary')
          break
        case 'avatar':
          this.$message.success('avatar')
          break
        case 'storage':
          this.$message.success('store')
          break
      }
    }
  }
}
</script>

<style>
  #container{
    padding: 10px 20px;
    font-size: 15px;
  }
</style>
