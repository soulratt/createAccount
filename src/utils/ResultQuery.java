package utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author APVJX
 */
public class ResultQuery {
    private final StringProperty operation;
    private final StringProperty inputType;
    private final StringProperty status;
    private final StringProperty outPutType;
    private final StringProperty startTime;
    private final StringProperty endTime;
    private final StringProperty elapsedSec;
    private final StringProperty inputBytesDisplay;
    
    public ResultQuery() {
        this.operation = new SimpleStringProperty("");
        this.inputType = new SimpleStringProperty("");
        this.status = new SimpleStringProperty("");
        this.outPutType = new SimpleStringProperty("");
        this.startTime = new SimpleStringProperty("");
        this.endTime = new SimpleStringProperty("");
        this.elapsedSec = new SimpleStringProperty("");
        this.inputBytesDisplay = new SimpleStringProperty("");
    }

    public ResultQuery(String operation, String inputType, String status, String outPutType, String startTime, String endTime, String elapsedSec, String inputBytesDisplay) {
        this.operation = new SimpleStringProperty(operation);
        this.inputType = new SimpleStringProperty(inputType);
        this.status = new SimpleStringProperty(status);
        this.outPutType = new SimpleStringProperty(outPutType);
        this.startTime = new SimpleStringProperty(startTime);
        this.endTime = new SimpleStringProperty(endTime);
        this.elapsedSec = new SimpleStringProperty(elapsedSec);
        this.inputBytesDisplay = new SimpleStringProperty(inputBytesDisplay);
    }
    
    public String getOperation() {
        return operation.get();
    }
            
    public void setOperation(String operation) {
        this.operation.set(operation);
    }
    
    public String getInputType() {
        return inputType.get();
    }
            
    public void setInputType(String inputType) {
        this.inputType.set(inputType);
    }
    
    public String getStatus() {
        return status.get();
    }
            
    public void setStatus(String status) {
        this.status.set(status);
    }
    
    public String getOutPutType() {
        return outPutType.get();
    }
            
    public void setOutPutType(String outPutType) {
        this.outPutType.set(outPutType);
    }
    
    public String getStartTime() {
        return startTime.get();
    }
            
    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }
    
    public String getEndTime() {
        return endTime.get();
    }
            
    public void setEndTime(String endTime) {
        this.endTime.set(endTime);
    }
    
    public String getElapsedSec() {
        return elapsedSec.get();
    }
            
    public void setElapsedSec(String elapsedSec) {
        this.elapsedSec.set(elapsedSec);
    }
    
    public String getInputBytesDisplay() {
        return inputBytesDisplay.get();
    }
            
    public void setInputBytesDisplay(String inputBytesDisplay) {
        this.inputBytesDisplay.set(inputBytesDisplay);
    }
}
