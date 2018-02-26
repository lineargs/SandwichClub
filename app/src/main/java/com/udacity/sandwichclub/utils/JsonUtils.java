package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        JSONObject mainObject = null;
        try {
            mainObject = new JSONObject(json);
            sandwich.setImage(mainObject.getString("image"));
            JSONObject nameObject = mainObject.getJSONObject("name");
            sandwich.setMainName(nameObject.getString("mainName"));
            ArrayList<String> alsoKnown = new ArrayList<>();
            JSONArray alsoKnownArray = nameObject.getJSONArray("alsoKnownAs");
            if (alsoKnownArray != null) {
                for (int i = 0; i < alsoKnownArray.length(); i++) {
                    alsoKnown.add(alsoKnownArray.getString(i));
                }
                sandwich.setAlsoKnownAs(alsoKnown);
            }
            ArrayList<String> ingredients = new ArrayList<>();
            JSONArray ingredientsArray = mainObject.getJSONArray("ingredients");
            if (ingredientsArray != null) {
                for (int i = 0; i < ingredientsArray.length(); i++) {
                    ingredients.add(ingredientsArray.getString(i));
                }
                sandwich.setIngredients(ingredients);
            }
            sandwich.setPlaceOfOrigin(mainObject.getString("placeOfOrigin"));
            sandwich.setDescription(mainObject.getString("description"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
