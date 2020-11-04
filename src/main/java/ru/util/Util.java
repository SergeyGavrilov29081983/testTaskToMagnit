package ru.util;

import ru.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Model> createModels(int n) {
        List<Model> models = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            Model model = new Model();
            model.setField(i);
            models.add(model);
        }
        return models;
    }
}
