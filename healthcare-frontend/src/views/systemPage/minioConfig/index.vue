<template>
  <div id="container">
    <a-row :style="{marginBottom: '15px'}">
      <a-col :span="24">
        <h4>1.&nbsp; &nbsp;新 建 存 储 桶：
          <a-input
            v-model="newBucket"
            placeholder="请输入桶名"
            style="width: 200px; margin-right: 20px"
          />
          <a-tooltip>
            <template slot="title">
              存储桶命名必须遵守Amazon S3标准。
            </template>
            <a-icon type="info-circle" />
          </a-tooltip>
          <a-button type="link" @click="clickOption('new')">新增</a-button>
        </h4>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '30px'}">
      <a-col :span="24">
        <h4>2.&nbsp; &nbsp;删 除 存 储 桶：
          <a-select
            v-model="deleteBucket"
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
          <a-button type="link" @click="clickOption('delete')">删除</a-button>
        </h4>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '30px'}">
      <a-col :span="3">
        <h4>3.&nbsp; &nbsp;病例文件：</h4>
      </a-col>
      <a-col :span="20">
        <a-row>
          <h4>当前桶名: &nbsp; &nbsp; {{used.caseBucket}}</h4>
        </a-row>
        <a-row style="margin-top: 10px">
          <h4>
            病例文件桶名：
            <a-select
              v-model="selected.caseBucket"
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
            <a-button type="link" @click="clickOption('salary')">替换</a-button>
          </h4>
        </a-row>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '30px'}">
      <a-col :span="3">
        <h4>4.&nbsp; &nbsp;工资文件：</h4>
      </a-col>
      <a-col :span="20">
        <a-row>
          <h4>当前桶名: &nbsp; &nbsp; {{used.salaryBucket}}</h4>
        </a-row>
        <a-row style="margin-top: 10px">
          <h4>
            工资文件桶名：
            <a-select
              v-model="selected.salaryBucket"
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
            <a-button type="link" @click="clickOption('salary')">替换</a-button>
          </h4>
        </a-row>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '30px'}">
      <a-col :span="3">
        <h4>5.&nbsp; &nbsp;头像文件：</h4>
      </a-col>
      <a-col :span="20">
        <a-row>
          <h4>当前桶名: &nbsp; &nbsp; {{used.avatarBucket}}</h4>
        </a-row>
        <a-row style="margin-top: 10px">
          <h4>
            头像文件桶名：
            <a-select
            v-model="selected.avatarBucket"
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
            <a-button type="link" @click="clickOption('salary')">替换</a-button>
          </h4>
        </a-row>
      </a-col>
    </a-row>
    <a-row :style="{marginBottom: '30px'}">
      <a-col :span="3">
        <h4>6.&nbsp; &nbsp;仓库文件：</h4>
      </a-col>
      <a-col :span="20">
        <a-row>
          <h4>当前桶名: &nbsp; &nbsp; {{used.storageBucket}}</h4>
        </a-row>
        <a-row style="margin-top: 10px">
          <h4>
            仓库文件桶名：
            <a-select
              v-model="selected.storageBucket"
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
            <a-button type="link" @click="clickOption('salary')">替换</a-button>
          </h4>
        </a-row>
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
      used: {
        caseBucket: '',
        salaryBucket: '',
        avatarBucket: '',
        storageBucket: ''
      },
      bucketList: [],
      selected: {
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
        this.used = res.data[0]
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
      setTimeout(() => {
        this.getData()
      })
    }
  }
}
</script>

<style>
  #container{
    padding: 10px 15px;
    font-size: 15px;
  }
</style>
