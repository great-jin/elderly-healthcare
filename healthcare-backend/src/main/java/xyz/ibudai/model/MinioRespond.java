package xyz.ibudai.model;

import io.minio.ObjectWriteResponse;

public class MinioRespond {

    String originName;

    String fileName;

    ObjectWriteResponse objectWriteResponse;

    public MinioRespond() {

    }

    public MinioRespond(String originName, String fileName, ObjectWriteResponse objectWriteResponse) {
        this.originName = originName;
        this.fileName = fileName;
        this.objectWriteResponse = objectWriteResponse;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ObjectWriteResponse getObjectWriteResponse() {
        return objectWriteResponse;
    }

    public void setObjectWriteResponse(ObjectWriteResponse objectWriteResponse) {
        this.objectWriteResponse = objectWriteResponse;
    }
}
