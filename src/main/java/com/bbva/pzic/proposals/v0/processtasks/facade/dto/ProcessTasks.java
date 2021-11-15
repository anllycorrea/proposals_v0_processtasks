package com.bbva.pzic.proposals.v0.processtasks.facade.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


@XmlRootElement(name = "processTasks", namespace = "urn:com:bbva:pzic:proposals:v0:processtasks:facade:dto")
@XmlType(name = "processTasks", namespace = "urn:com:bbva:pzic:proposals:v0:processtasks:facade:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcessTasks implements Serializable {

    private static final long serialVersionUID = 1L;
    private String businessProcessId;
    private String taskId;
    private Status status;

    public String getBusinessProcessId() {
        return businessProcessId;
    }

    public void setBusinessProcessId(String businessProcessId) {
        this.businessProcessId = businessProcessId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
