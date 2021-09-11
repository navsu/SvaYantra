package com.memandis.svayantra.remoterepo.svayantra

class SvaYantraRemoteRepoImpl(
    private val svayantraAPIServce: SvaYantraAPIService
) : SvaYantraRemoteRepo {
    override suspend fun fetchSvaYantraControllersFor(
        url: String,
        cpass: String
    ): List<SvaYantraControllerModel> =
        svayantraAPIServce.fetchSvaYantraControllersFor(url = url, cpass = cpass)
}

// private static final String FRAGMENT_TAG = "Control";
// public static final String GET_JSON_DATA_HTTP_URL_BASE       = "http://";
// public static final String GET_JSON_DATA_HTTP_URL_HOME       = "/";
// public static final String GET_JSON_DATA_HTTP_URL_JC         = "jc";
// public static final String GET_JSON_DATA_HTTP_URL_JS         = "js";
// public static final String GET_JSON_DATA_HTTP_URL_JN         = "jn";
// public static final String GET_JSON_DATA_HTTP_URL_JP         = "jp";
// public static final String GET_JSON_DATA_HTTP_URL_JO         = "jo";
// public static final String JSON_DEVICE_TIME                  = "dt";
// public static final String JSON_DEVICE_LOCATION              = "loc";
// public static final String JSON_DEVICE_CONTROL_BITS          = "sbits";
// public static final String JSON_DEVICE_CONTROL_DIMMER_BITS   = "d";
// public static final String JSON_DEVICE_CONTROL_PROGRAM_BITS  = "ps";
// public static final String JSON_DEVICE_CONTROL_STATION_BITS  = "sn";
// public static final String JSON_DEVICE_CONTROL_NUM_STATION   = "nstations";
// public static final String JSON_DEVICE_RESPONSE              = "result";

// ##############POST REQUEST############################

// server change password
// x.x.x.x/sp?pw=xxx&npw=x&cpw=x

// server change control station names and attributes
// x.x.x.x/cs?pw=xxx&s?=x

// server change controller variables
// x.x.x.x/cv?pw=xxx&rsn=x&rbt=x&en=x&rd=x

// server change control station variales(ON/OFF/DIM/Timer)
// x.x.x.x/cm?pw=xxx&sid=x&en=x&&ed=x&dim=x&t=x

// server change options
// x.x.x.x/co?pw=xxx&o?=x&loc=x&ttt=x

// server change script url
// x.x.x.x/cu?pw=xxx&jsp=x

// server delete program
// x.x.x.x/dp?pw=xxx&pid=xxx

// server change program
// x.x.x.x/cp?pw=xxx&pid=x&v=[
// 	flag,
// 	days0,
// 	days1,
// 	[start1, start2, star3, start4],
// 	[dur0, dur1,...,durn],
// 	[dim0, dim1,...,dimn]
// ]
// 	&name=x

// ##################GET REQUEST#########################################

// 	server station names output                 - jn
// 	{
// 	    "snames"    : ["S01","S02","S03","S04","S05","S06","S07","S08"],
// 	    "maxlen"    : 12
//  }

// 	server station control value(ON/OFF) output - js
// 	{
// 	    "sn"        : ["0","0","0","0","0","0", "0","0"],
// 	    "nstations" : 8
//  }

// 	server controller status output             - jc
// 	{
// 	    "devt"      : 1521116622,
// 	    "nbrd"      : 8,
//      "en"        : 1,
//      "loc"       : "New Delhi, IN",
//      "sbits"     : [0],
//      "dbits"     : [0,0,0,0],
//      "ps"        : [[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0]],
//      "lrun"      : [0,0,0,0],
//  }

// 	server options output                       - jo
// 	{
//
// 		"fwv"       :143,
// 		"ip1"       :192,
// 		"ip2"       :168,
// 		"ip3"       :0,
// 		"ip4"       :24,
// 		"gw1"       :192,
// 		"gw2"       :168,
// 	    "gw3"       :0,
// 	    "gw4"       :1,
// 	    "hp0"       :80,
// 	    "hp1"       :0,
// 	    "sdt"       :5,
// 	    "sot"       :0,
// 	    "tz"        :70,
// 	    "ipas"      :1,
// 	    "reset"     :0,
// 	    "mexp"      :0
//
// 	}

//  server program data output                  - jp
// 	{
// 	    "nprogs"    :0,
// 	    "nboards"   :1,
// 	    "mnp"       :12,
// 	    "mnst"      :4,
// 	    "pnsize"    :12,
// 	    "pd"        :[]
// 	}
//
//
//
// //    VolleyResultCallback mResultCallback = null;
// Context context;
//
// SvaYantrService(/*VolleyResultCallback resultCallback,*/Context context) {
// //        this.mResultCallback = resultCallback;
//    this.context = context;
// }
//
// public void postControlStringData(String requestType, String sendObj) {
//
//    Log.d("POSTCALL", "Volley send " + sendObj);
//    StringRequest mStringRequest = new StringRequest(Request.Method.POST, sendObj,
//        new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
// //                        if(mResultCallback!=null) {
// //                            mResultCallback.onSuccess(requestType, response);
// //                        }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
// //                if(mResultCallback!=null) {
// //                    mResultCallback.onFailure(requestType, error);
// //                }
//            }
//        });
// //        {
// //            @Override
// //            public String getBodyContentType() {
// //                return "application/json; charset=utf-8";
// //            }
// //
// //            @Override
// //            public byte[] getBody() throws AuthFailureError {
// //                try {
// //                    return sendObj == null ? null : sendObj.getBytes("utf-8");
// //                } catch (UnsupportedEncodingException uee) {
// //                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", sendObj, "utf-8");
// //                    return null;
// //                }
// //            }
// //
// //            @Override
// //            protected Response<String> parseNetworkResponse(NetworkResponse response) {
// //                String responseString = "";
// //                if (response != null) {
// //                    responseString = String.valueOf(response.statusCode);
// //                    // can get more details such as response.headers
// //                }
// //                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
// //            }
// //        };
//
//    VolleySingleton.getInstance(context).addToRequestQueue(mStringRequest);
// }
//
// public void postControlJsonData(final String requestType, String url, JSONObject sendObj) {
// //        JSONObject jsonBody = new JSONObject();
// //        jsonBody.put("Title", "Android Volley Demo");
// //        jsonBody.put("Author", "BNK");
// //        final String requestBody = jsonBody.toString();
//    JsonObjectRequest mJSONRequest = new JsonObjectRequest(url, sendObj,
//        new Response.Listener<JSONObject>(){
//            @Override
//            public void onResponse(JSONObject response) {
// //                        if(mResultCallback!=null) {
// //                            mResultCallback.onSuccess(requestType, response.toString());
// //                        }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
// //                if(mResultCallback!=null) {
// //                    mResultCallback.onFailure(requestType, error);
// //                }
//            }
//        });
//
//    VolleySingleton.getInstance(context).addToRequestQueue(mJSONRequest);
//
// }
//
// public LiveData<List<Control>> getJSONControlList(final String requestType, String url) {
//    MutableLiveData<List<Control>> controlListData = new MutableLiveData<>();
//    JsonObjectRequest mJsonObj = new JsonObjectRequest(Request.Method.GET, url, null,
//        new Response.Listener<JSONObject>(){
//            @Override
//            public void onResponse(JSONObject response) {
//                if(response!=null) {
//                    controlListData.setValue(getControllerStatus(response.toString()));
//                }
// //                if(mResultCallback!=null) {
// //                    mResultCallback.onSuccess(requestType, getControllerStatus(response.toString()));
// //                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                controlListData.setValue(getDefaultControlList());
// //                if(mResultCallback!=null) {
// //                    mResultCallback.onFailure(requestType, error);
// //                }
//            }
//        });
//
//    VolleySingleton.getInstance(this.context).addToRequestQueue(mJsonObj );
//
//    return controlListData;
//
// }
//
// public LiveData<Control> getJSONControl(final String requestType, String url, final int controlId) {
//    MutableLiveData<Control> controlData = new MutableLiveData<>();
//    JsonObjectRequest mJsonObj = new JsonObjectRequest(Request.Method.GET, url, null,
//        new Response.Listener<JSONObject>(){
//            @Override
//            public void onResponse(JSONObject response) {
//                if(response!=null) {
//                    controlData.setValue(getControlDetails(response.toString(), controlId));
//                }
// //                        if(mResultCallback!=null) {
// //                            mResultCallback.onSuccess(requestType, getControlDetails(response.toString(), controlId));
// //                        }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
// //                if(mResultCallback!=null) {
// //                    mResultCallback.onFailure(requestType, error);
// //                }
//            }
//        });
//
//    VolleySingleton.getInstance(this.context).addToRequestQueue(mJsonObj );
//
//    return controlData;
//
// }
//
// public LiveData<Control> getStringDataUVolley(String requestType, String url, final int controlId) {
//    MutableLiveData<Control> controlData = new MutableLiveData<>();
// //        RequestQueue mRequestQueue = VolleySingleton.getInstance(this.context).getRequestQueue();
//    StringRequest mStringObj = new StringRequest(Request.Method.GET, url,
//        new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                if(response!=null) {
// //                            if(Integer.parseInt(getServerResponseValue(response))==1) {
// //                                controlData.setValue(getJSONControl("GETCALL", " http://192.168.0.18/js", controlId).getValue());
// //                                controlData.getValue().setResponse(getServerResponseValue(response));
// //                                Log.d(" controlData", " Respponse " +  controlData.getValue().getResponse());
// //                            }
// //                            controlData.setValue(getControlDetails(response.toString(), controlId));
// //                            controlData.getValue().setResponse(response);
//                }
//
// //                        if(mResultCallback!=null) {
// //                            mResultCallback.onSuccess(requestType, getServerResponseValue(response));
// //                        }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
// //                if(mResultCallback!=null) {
// //                    mResultCallback.onFailure(requestType, error);
// //                }
//            }
//        });
//    VolleySingleton.getInstance(context).addToRequestQueue(mStringObj);
//
//    return controlData;
// }
//
// public Control getDefaultControl(int controlId) {
//    List<Integer> imageList = getImageDataList();
//    return new Control(controlId                      ,
//    "Control D" + (controlId+1),
//    ""         + controlId     ,
//    ""    + 0             ,
//    ""    + 0             ,
//    ""    + 0             ,
//    ""        + 0             ,
//    imageList.get(controlId)         ,
//    imageList.get(controlId+8));
// }
//
// private String getServerResponseValue(String result) {
//
// //	      server response value
// //        {
// //            "result":1
// //        }
//
//    if(result == null || result.length() == 0){
//        return "0";
//    }
//
//    String str = "";
//
//    try {
//
//        JSONObject json = new JSONObject(result);
//
//        str = json.getString(SvaYantrService.JSON_DEVICE_RESPONSE);
//
//        Log.i("check ", "server response "+str);
//
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
//
//    return str;
//
// }
//
// private Control getControlDetails(String result, int controlId) {
//
//    //	server station control value(ON/OFF) output - js
//    //	{
//    //	    "sn"        : ["0","0","0","0","0","0", "0","0"],
//    //	    "nstations" : 8
//    //  }
//
//    Control control = getDefaultControl(controlId);
//
//    if(result == null || result.length() == 0){
//        return control;
//    }
//
//    String str = "";
//
//    try {
//
//        JSONObject json = new JSONObject(result);
//
//        JSONArray control_sbits = json.getJSONArray(SvaYantrService.JSON_DEVICE_CONTROL_STATION_BITS);
//
//        str += "nstation: "+json.getString(SvaYantrService.JSON_DEVICE_CONTROL_NUM_STATION);
//
//        str += "\n--------\n";
//
//        for(int i=0; i<control_sbits.length(); i++){
//            byte val  = Byte.parseByte(control_sbits.get(i).toString());
//            str += "sbits: "+val;
//            if(i==controlId) {
//                control.setControlState(""+val);
//                control.setImageId(control.getImageOnId());
//            }
//        }
//
//        Log.i("check ", "control" + controlId +" control "+str);
//
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
//
//    return control;
//
// }
//
// private List<Integer> getImageDataList() {
//
//    List<Integer> imageList = new ArrayList<>();
//    imageList.add(R.drawable.control_fan);
//    imageList.add(R.drawable.control_fan);
//    imageList.add(R.drawable.control_tv);
//    imageList.add(R.drawable.control_light);
//    imageList.add(R.drawable.control_fridge);
//    imageList.add(R.drawable.control_ac);
//    imageList.add(R.drawable.control_hifi);
//    imageList.add(R.drawable.control_motor);
//    imageList.add(R.drawable.control_fan_on);
//    imageList.add(R.drawable.control_fan_on);
//    imageList.add(R.drawable.control_tv_on);
//    imageList.add(R.drawable.control_light_on);
//    imageList.add(R.drawable.control_fridge_on);
//    imageList.add(R.drawable.control_ac_on);
//    imageList.add(R.drawable.control_hifi_on);
//    imageList.add(R.drawable.control_motor_on);
//
//    return imageList;
//
// }
//
// public List<Control> getDefaultControlList() {
//    List<Control> cList = new ArrayList<>();
//    List<Integer> imageList = getImageDataList();
//
//    for(int j=0; j<8; j++){
//        Control control = new Control(j,
//            "Control " + (j+1),
//            ""         + j,
//            ""    + 0,
//            ""    + 0,
//            ""    + 0,
//            ""        + 0,
//            imageList.get(j),
//            imageList.get(j+8));
//        cList.add(control);
//    }
//
//    return cList;
// }
//
// private List<Control> getControllerStatus(String result) {
// /*
// 	    "dt"        : 1521116622,
//      "loc"       : "New Delhi, IN",
//      "sbits"     : [0],
//      "d"         : [0,0,0,0],
//                    program index(pi), stop time(s1), start time(s2),
//                    pi, s1, s2
//      "ps"        : [[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0,0],[0,0]]
// */
//    List<Control> cList = getDefaultControlList();
//
//    if(result == null || result.length() == 0){
//        return cList;
//    }
//
// //        String str = "";
//
//    try {
//
//        JSONObject json = new JSONObject(result);
//
//        JSONArray control_sbits = json.getJSONArray(SvaYantrService.JSON_DEVICE_CONTROL_BITS);
//        JSONArray control_dbits = json.getJSONArray(SvaYantrService.JSON_DEVICE_CONTROL_DIMMER_BITS);
//        JSONArray programs = json.getJSONArray(SvaYantrService.JSON_DEVICE_CONTROL_PROGRAM_BITS);
//
// //            str += "devt: "+json.getString(SvaYantrService.JSON_DEVICE_TIME );
// //
// //            str += "\n--------\n";
// //
// //            str += "Device location: "+json.getString(SvaYantrService.JSON_DEVICE_LOCATION);
// //
// //            str += "\n--------\n";
//
//        for(int i=0; i<control_sbits.length(); i++){
//            byte val  = (byte) Integer.parseInt(control_sbits.get(i).toString());
// //                str += "sbits: "+val;
//            for(int j=0; j<8; j++){
//            int bitVal = ((val >> j) & 1);
// //                    str += " : "+bitVal;
//            cList.get(j).setControlState(""+bitVal);
// //                    Log.i("check ", "MyClass.getView() — get item number " + j+" control "+str);
//            cList.get(j).setImageId(cList.get(j).getImageOnId());
//        }
//        }
//
// //            str += "\n--------\n";
//
//        for(int i=0; i<control_dbits.length(); i++){
//            byte val  = (byte) Integer.parseInt(control_dbits.get(i).toString());
// //                str += "dbits"+(i+1)+" : " +val;
//            if(control_dbits.length()==3) {
//                if(i<2) {
//                    cList.get(i).setDimmerState(""+val);
//                } else {
//                    cList.get(2).setDimmerState(""+val);
//                }
//            }
//        }
//
// //            str += "\n--------\n";
//
//        for(int i=0; i<programs.length(); i++){
//            JSONArray prog = programs.getJSONArray(i);
//            for(int j=0; j<prog.length(); j++){
// //                    str += " p"+(j+1)+" :" +prog.get(j).toString();
//        }
// //                str += "\n--------\n";
//        }
//
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
//
//
//    return cList;
//
// }
//
// }
