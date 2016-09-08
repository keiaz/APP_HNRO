package com.hanyangraon.kei.hnro_libs.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

/**
 * 네트워크 관리
 * Copyright (c) 2013 Richslide. All Rights Reserved.
 *
 * @author sgKim
 * @version 1.0
 * @since 2016.08.
 */
public class NetworkManager {

    // const
//    public static final String RESULT = "result";
//    public static final String SUCCESS = "success";
//    public static final String ERROR = "error";
//    public static final String ERROR_CODE = "errorCode";
//    public static final String ERROR_MESSAGE = "errorMessage";
//    public static final String ERROR_NETWORK_CONNECT = "errorNetworkConnect";
//    public static final String ERROR_SERVER_CONNECT = "errorServerConnect";

    // parameters
//    private final String URL = "http://192.168.0.7:8080"; // local test server url
    //    private final String URL = "http://125.209.198.81:8090"; // naver test server url
//    private final String CONTEXT_PATH = "/superboxservice";

    private static NetworkManager sInstance;

    /**
     * private 생성자
     */
    private NetworkManager() {
        // nothing...
    }


    /**
     * instance 획득
     *
     * @return NetworkManager 인스턴스
     */
    public static NetworkManager getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkManager();
        }
        return sInstance;
    }

    /**
     * 네트워크 접속 확인
     *
     * @param context 컨텍스트
     * @return 접속여부 확인 결과
     */
    public boolean checkConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null;
    }

    /**
     * HttpPost 전송
     *
     * @param context 컨텍스트
     * @param uri     Uniform Resource Identifier
     * @param lists   서버로 전달할 데이터
     * @return response data

    public String sendByHttpPost(Context context, String uri, List<NameValuePair> lists) throws IOException {
    if (checkConnection(context)) {
    HttpPost post = new HttpPost(URL + CONTEXT_PATH + uri);
    post.setEntity(new UrlEncodedFormEntity(lists, HTTP.UTF_8)); // data를 UTF-8로 encoding

    HttpClient client = new DefaultHttpClient();
    return getResponseData(client.execute(post));
    } else {
    return ERROR_NETWORK_CONNECT;
    }
    }
     */


    /**
     * 통신에 성공하여 전달받은 데이터를 문자열로 획득
     *
     * @param response 서버에서 전달받은 데이터
     * @return 문자열로 변환한 데이터
     * @throws IOException

    private String getResponseData(HttpResponse response) throws IOException {
    int statusCode = response.getStatusLine().getStatusCode();

    if (HttpStatus.SC_OK != statusCode) {
    String message = "http status code is not ok: " + statusCode;
    LogManager.getInstance().warning(new Exception(message));

    return null;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), HTTP.UTF_8));
    StringBuilder sb = new StringBuilder();
    while (true) {
    String line = reader.readLine();
    if (line != null) {
    sb.append(line);
    } else {
    break;
    }
    }
    reader.close();

    return sb.toString();
    }
     */
}


/**
 * NameValuePair[]을 List 형태로 변환
 *
 * @param pairs
 * @return private List<NameValuePair> makePairList(NameValuePair... pairs) {
 * List<NameValuePair> lists = new ArrayList<>();
 * for (NameValuePair pair : pairs) {
 * lists.add(pair);
 * }
 * return lists;
 * }
 */

    /*
    private class RemoteDnsCheck extends AsyncTask<List<NameValuePair>, Void, HttpResponse> {

        @Override
        protected HttpResponse doInBackground(List<NameValuePair>... params) {
            HttpResponse response = null;
            try {
                Log.d("RemoteDnsCheck", "starting");
                dnsOkay = false;
                InetAddress addr = InetAddress.getByName(baseHost);
                if (addr != null) {
                    String sendUrl = servletUrl;
                    HttpPost post = new HttpPost(sendUrl);

                    params[0].add(new BasicNameValuePair("dataType", "json"));

                    UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params[0], HTTP.UTF_8);
                    post.setEntity(ent);

					 데이터 보낸 뒤 서버에서 데이터를 받아오는 과정
                    response = client.execute(post);
                    dnsOkay = true;
                }
            } catch (Exception e) {
                Log.d("RemoteDnsCheck", "error");
            }
            return response;
        }

        @Override
        protected void onPostExecute(HttpResponse result) {
            super.onPostExecute(result);
        }

    }




     public String sendByHTTP(String uri, List<NameValuePair> params) {
     servletUrl = uri;
     httpResult = "";
     if (RichslideConst.IS_USB) {
     return httpResult;
     }
     StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
     StrictMode.setThreadPolicy(policy);

     try {
     if (context != null) {
     ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
     NetworkInfo activityNetWork = cm.getActiveNetworkInfo();
     isConnected = activityNetWork != null && activityNetWork.isConnectedOrConnecting();
     }
     if (isConnected) {
     String result = resolveDns(params);
     if (!result.equals("")) {
     httpResult = result;
     } else {
     httpResult = "";
     }
     } else {
     httpResult = "";
     }
     } catch (Exception e) {
     Log.e(this.getClass().getName(), e.getMessage() + "");
     httpResult = "";
     } finally {
     //client.getConnectionManager().shutdown();
     }
     return httpResult;
     }

     /*
     public static HTTPService getInstance(Context context) {
     // context = con;
     if (instance == null) {
     instance = new HTTPService();
     }

     return instance;
     }
     */

//	public static String URL = "http://richslidebsm.com/fx.web2/";
//	public static String baseHost = "richslidebsm.com";
//	public final static String BASE_URL = "http://www.richslidebsm.com/";
//	public final static String TRAFFIC_URL = "layout/trafficMapPreview.jsp";
//	public final static String TRAFFIC_MULTI_URL = "layout/trafficMapMultiPreview.jsp";

//	public final static String BASE_URL = "http://www.richslide.com/richslide_v4/";
//	public final static String TRAFFIC_URL = "layout/trafficMapPreview.jsp";
//	public final static String TRAFFIC_MULTI_URL = "layout/trafficMapMultiPreview.jsp";
//	public static String URL = "http://richslide.com/fx.web3/";
//	public static String baseHost = "richslide.com";

//    public final static String TRAFFIC_URL = "layout/trafficMapPreview.jsp";
//    public final static String TRAFFIC_MULTI_URL = "layout/trafficMapMultiPreview.jsp";
//    public static String URL = "http://192.168.2.3:8080/fx.web/";
//    public static String baseHost = "192.168.2.3";
//
//    private String servletUrl = "";
//    boolean isConnected = true;
//
//    private static Context context;
//
//
//
//    public static final int MAX_TOTAL_CONNECTION = 100;
//    public static final int MAX_CONNECTIONS_PER_ROUTE = 100;
//    public static final int TIMEOUT_CONNECT = 1000 * 20;
//    public static final int TIMEOUT_READ = 1000 * 20;
//    private String httpResult = "";
//    private static HttpClient client = getHttpClient();
/*


    public String sendByHTTP(List<NameValuePair> params) {
        return sendByHTTP(URL + "phone", params);
    }



    public static HttpClient getHttpClient() {
        HttpClient httpClient = null;
        final HttpParams params = new BasicHttpParams();
        try {
            // PARAMS
            ConnManagerParams.setMaxTotalConnections(params, MAX_TOTAL_CONNECTION);
            ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(MAX_CONNECTIONS_PER_ROUTE));

            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
            HttpConnectionParams.setSocketBufferSize(params, 512 * 1024);
            HttpConnectionParams.setStaleCheckingEnabled(params, false);
            HttpConnectionParams.setConnectionTimeout(params, TIMEOUT_CONNECT);
            HttpConnectionParams.setSoTimeout(params, TIMEOUT_READ);


            HttpClientParams.setRedirecting(params, false);
            params.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);

            //SCHEME
            final SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));

            final ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

            httpClient = new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
            HttpConnectionParams.setSocketBufferSize(params, 512 * 1024);
            HttpConnectionParams.setStaleCheckingEnabled(params, false);
            HttpConnectionParams.setConnectionTimeout(params, TIMEOUT_CONNECT);
            HttpConnectionParams.setSoTimeout(params, TIMEOUT_READ);
            httpClient = new DefaultHttpClient(params);
        }

        return httpClient;
    }

    private boolean dnsOkay = false;
    private static final int DNS_SLEEP_WAIT = 250;

    private synchronized String resolveDns(List<NameValuePair> params) {
        HttpResponse response = null;
        String result = "";
        RemoteDnsCheck check = new RemoteDnsCheck();
        try {
            response = check.execute(params).get();
            if (!dnsOkay) {
                Log.d("resolveDns", "cancelling");
                check.cancel(true);
                Log.d("resolveDns", "cancelled");
            } else {
                if (response != null) {
                    BufferedReader bufreader = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent(),
                                    "utf-8"));

                    String line = null;

                    while ((line = bufreader.readLine()) != null) {
                        result += line;
                    }
                    bufreader.close();
                    if (-1 == result.indexOf("callback(")) {
                        cloudeServiceCheck(result);
                    }
                } else {
                    result = "";
                }
            }
        } catch (Exception e) {
            result = "";
        }
        return result;
    }

    private void cloudeServiceCheck(String result) throws Exception {
        try {
            JSONObject obj = new JSONObject(result);
            if (!(context instanceof MainActivity)) {
                if (obj.has(RichslideConst.ERROR_CODE)) {
                    ((BaseActivity) context).finished();
                    PendingIntent i = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_ONE_SHOT);
                    AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                    am.set(AlarmManager.RTC, System.currentTimeMillis(), i);
                    android.os.Process.killProcess(android.os.Process.myPid());
                }

                // session 정보가 바뀌었을때 session 정보 갱신
                if (obj.has("session")) {
                    JSONArray array = obj.getJSONArray("session");
                    SessionApplication sa = (SessionApplication) context.getApplicationContext();
                    sa.setSession(array.getJSONObject(0));

                    SharedPreferences sharedUserInfo = context.getSharedPreferences("userinfo", Activity.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedUserInfo.edit();
                    RichslidePlayerUtil util = new RichslidePlayerUtil();
                    editor.putStringSet("userinfo", util.getJSONStringToSet(array.getJSONObject(0)));
                    editor.commit();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }



    /**
     * 받은 JSON 객체를 파싱하는 메소드
     *
     * @param json
     * @return
    public Map<String, Object> jsonParserObject(JSONObject json) {
        Map<String, Object> jsonParser = new HashMap<String, Object>();
        try {

            @SuppressWarnings("rawtypes")
            Iterator iter = json.keys();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                jsonParser.put(key, json.get(key));
            }
            return jsonParser;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "JSON Parser Error");
            return null;
        }
    }

    /**
     * 받은 JSONList 객체를 파싱하는 메소드
     *
     * @param page
     * @return
    public List<Map<String, Object>> jsonParserArray(JSONArray json) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {

            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObj = json.getJSONObject(i);
                Map<String, Object> map = jsonParserObject(jsonObj);
                if (map != null && !map.isEmpty()) {
                    list.add(map);
                }
            }
            return list;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "JSON Array Parser Error");
            return null;
        }
    }

    public List<Map<String, Object>> getUSBFileMap(String key) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            File xmlFile = new File(RichslideConst.USB_DB_PATH.getAbsoluteFile() + File.separator + "slidecontent.xml");
            FileInputStream xmlFileIs = new FileInputStream(xmlFile);
            // 스트림에서 인코딩을 자동으로 인식합니다.
            parser.setInput(xmlFileIs, null);

            int eventType = parser.getEventType();
            Map<String, Object> dataMap = null;
            int type = 0;
            boolean done = false;

            while (eventType != XmlPullParser.END_DOCUMENT && !done) {
                String name = null;
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        // 스트림의 시작입니다. 리스트를 생성합니다.
                        list = new ArrayList<Map<String, Object>>();
                        break;
                    case XmlPullParser.START_TAG:
                        // 태그를 식별한 뒤 태그에 맞는 작업을 수행합니다.
                        name = parser.getName();
                        if (name.equalsIgnoreCase(key)) {
                            dataMap = new HashMap<String, Object>();
                            type = 0;
                        } else {
                            switch (type) {
                                case 0:
                                    if (dataMap != null) {
                                        dataMap.put(name, parser.nextText());
                                    }
                                    break;
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        // 태그의 마지막을 읽었습니다. ITEM을 처리하는 중이면 리스트에 Message를 추가합니다.
                        name = parser.getName();
                        if (name.equalsIgnoreCase(key) && dataMap != null) {
                            list.add(dataMap);
                        } else if (name.equalsIgnoreCase("root")) {
                            done = true;
                        }
                        break;
                }
                eventType = parser.next();
            }

        } catch (Exception e) {

        }
        return list;
    }

    public static BasicNameValuePair getBasicNameValuePair(String name, String value) {
        return new BasicNameValuePair(name, value);
    }
        */

