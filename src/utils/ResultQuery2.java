package utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author APVJX
 */
public class ResultQuery2 {
    private final StringProperty tablespace;
    private final StringProperty totalAlloc;
    private final StringProperty totalAllocPhys;
    private final StringProperty usedMb;
    private final StringProperty usedPerc;
    
    public ResultQuery2() {
        this.tablespace = new SimpleStringProperty("");
        this.totalAlloc = new SimpleStringProperty("");
        this.totalAllocPhys = new SimpleStringProperty("");
        this.usedMb = new SimpleStringProperty("");
        this.usedPerc = new SimpleStringProperty("");
    }

    public ResultQuery2(String tablespace, String totalAlloc, String totalAllocPhys, String usedMb, String usedPerc) {
        this.tablespace = new SimpleStringProperty(tablespace);
        this.totalAlloc = new SimpleStringProperty(totalAlloc);
        this.totalAllocPhys = new SimpleStringProperty(totalAllocPhys);
        this.usedMb = new SimpleStringProperty(usedMb);
        this.usedPerc = new SimpleStringProperty(usedPerc);
    }
    
    public String getTablespace() {
        return tablespace.get();
    }
            
    public void setTablespace(String tablespace) {
        this.tablespace.set(tablespace);
    }
    
    public String getTotalAlloc() {
        return totalAlloc.get();
    }
            
    public void setTotalAlloc(String totalAlloc) {
        this.totalAlloc.set(totalAlloc);
    }
    
    public String getTotalAllocPhys() {
        return totalAllocPhys.get();
    }
            
    public void setTotalAllocPhys(String totalAllocPhys) {
        this.totalAllocPhys.set(totalAllocPhys);
    }
    
    public String getUsedMb() {
        return usedMb.get();
    }
            
    public void setUsedMb(String usedMb) {
        this.usedMb.set(usedMb);
    }
    
    public String getUsedPerc() {
        return usedPerc.get();
    }
            
    public void setUsedPerc(String usedPerc) {
        this.usedPerc.set(usedPerc);
    }
}
