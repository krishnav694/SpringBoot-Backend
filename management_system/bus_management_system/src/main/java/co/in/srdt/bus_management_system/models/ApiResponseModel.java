package co.in.srdt.bus_management_system.models;

public class ApiResponseModel {

    private String message;

    private String status;

    private String dataFromResponse;

    public ApiResponseModel() {    }

    public ApiResponseModel(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public ApiResponseModel(String message, String status, String dataFromResponse) {
        this.message = message;
        this.status = status;
        this.dataFromResponse = dataFromResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataFromResponse() {
        return dataFromResponse;
    }

    public void setDataFromResponse(String dataFromResponse) {
        this.dataFromResponse = dataFromResponse;
    }
}
