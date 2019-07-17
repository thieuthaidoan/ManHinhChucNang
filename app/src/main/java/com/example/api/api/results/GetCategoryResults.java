package com.example.api.api.results;

import com.example.api.api.response.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


    public class GetCategoryResults extends BaseResponse {
        @SerializedName("results")
        @Expose
        public List<com.example.model.Category> Category;

        public List<com.example.model.Category> getCategory() {
            if (Category == null){
                Category = new ArrayList<>();
            }
            return Category;
        }
    }
