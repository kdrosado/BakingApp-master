package kdrosado.bakingapp.api;

import java.util.List;

import kdrosado.bakingapp.models.Recipe;
import retrofit2.Call;
import retrofit2.http.GET;

interface RecipesApiService {

    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getRecipes();

}