package com.example.personmanagement.exceptions;

public class CustomWebApplicationException extends RuntimeException{

        private int statusCode;

        public CustomWebApplicationException(String message, int statusCode) {
            super(message);
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }

}
