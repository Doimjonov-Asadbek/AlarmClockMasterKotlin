package app.calc.alarmclockmaster.models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Interface {

    @POST("register")
    Call<SignUp> signUp(@Body SignUp sign);

}
