package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        // use try-catch block to prevent app crashes due to exceptions
        try {
            JSONObject allInfo = new JSONObject(json);
            // get names and add them into arrayList
            JSONObject name = allInfo.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            // loop through alsoKnownAs
            for(int i=0; i<alsoKnownAs.length(); i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            // get and set all other attributes
            String placeOfOrigin = allInfo.getString("placeOfOrigin");
            String description = allInfo.getString("description");
            String image = allInfo.getString("image");
            JSONArray ingredients = allInfo.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            // loop through ingredients and add them into ArrayList
            for(int i=0; i<ingredients.length(); i++){
                ingredientsList.add(ingredients.getString(i));
            }

            // call Sandwich constructor to set all information for specific sandwich
            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
