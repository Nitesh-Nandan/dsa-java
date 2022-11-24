package javageneric;

import java.util.ArrayList;
import java.util.List;

class GenericResponse<T> {
    private T data;
    List<String> errors = new ArrayList<>();

    public GenericResponse(T data) {
        this.data = data;
    }

    public GenericResponse(T data, List<String> errors) {
        this.data = data;
        this.errors.addAll(errors);
    }

    public GenericResponse(List<String> errors) {
        this.errors.addAll(errors);
    }
}

class Data {
    String name;
    String city;
    public Data(String name, String city) {
        this.name = name;
        this.city = city;
    }
}



public class GenericDemo {
}