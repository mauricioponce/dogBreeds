package com.eme.dogbreed.remote.pojo;

import java.util.HashMap;
import java.util.List;

public class ResponseWrapper {

    private HashMap<String, List<String>> message;

    private String status;

    public HashMap<String, List<String>> getMessage() {
        return message;
    }

    public void setMessage(HashMap<String, List<String>> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }

    public class ResponseWrapperList {
        private List<String> message;

        private String status;

        public List<String> getMessage() {
            return message;
        }

        public void setMessage(List<String> message) {
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "ResponseWrapperList{" +
                    "message=" + message +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
