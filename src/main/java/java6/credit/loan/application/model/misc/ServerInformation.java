package java6.credit.loan.application.model.misc;

import java.util.Date;

public class ServerInformation {
    private String author;
    private Date currentDate;
    private Date serverStartDate;
    private String myValue;

    public ServerInformation(String author,
                             Date currentDate,
                             Date serverStartDate,
                             String myValue) {
        this.author = author;
        this.currentDate = currentDate;
        this.serverStartDate = serverStartDate;
        this.myValue = myValue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getServerStartDate() {
        return serverStartDate;
    }

    public void setServerStartDate(Date serverStartDate) {
        this.serverStartDate = serverStartDate;
    }

    public String getMyValue() {
        return myValue;
    }

    public void setMyValue(String myValue) {
        this.myValue = myValue;
    }
}
