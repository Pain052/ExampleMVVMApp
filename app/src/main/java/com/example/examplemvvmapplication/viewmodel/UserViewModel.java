package com.example.examplemvvmapplication.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.examplemvvmapplication.BR;
import com.example.examplemvvmapplication.model.UserModel;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserViewModel extends BaseObservable {
    private String fullName;
    private String city;
    private String phone;

    Context context;

    public UserViewModel(Context context) {
        this.context = context;
    }

    private RequestQueue requestQueue;

    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> userCity = new ObservableField<>();
    public ObservableField<String> userPhone = new ObservableField<>();
    public ObservableField<Boolean> loadData = new ObservableField<>();

    @Bindable
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    public void onClickCallApi(){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());

        String url = "https://api.randomuser.me/?results=3&nat=en";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray array = response.getJSONArray("results");
                    JSONObject object = array.getJSONObject(0);

                    JSONObject name = object.getJSONObject("name");
                    String title = name.getString("title");
                    String first = name.getString("first");
                    String last = name.getString("last");

                    JSONObject location = object.getJSONObject("location");
                    String city = location.getString("city");

                    String phone = object.getString("phone");

                    //append string to have fullName
                    String userFullName = title + " " + first + " " + last;
                    Log.e("DATA_U", userFullName);

                    UserModel model = new UserModel(userFullName, city, phone);
                    if (model != null){
                        username.set(model.getFullName());
                        userCity.set(model.getCity());
                        userPhone.set(model.getPhone());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
