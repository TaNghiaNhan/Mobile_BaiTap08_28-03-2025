package vn.hcmute.viewflipper_circleindicator.network.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import vn.hcmute.viewflipper_circleindicator.data.model.MessageModel;

public interface ClientApi {
    @FormUrlEncoded
    @POST("newimagesmanager.php")
    Call<MessageModel> LoadImageSlider(@Field("position") int position);
}
