package com.wny2023.tp01parkappv2;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


public class ParkInfo1Fragment  extends Fragment {
    ArrayList<ItemRecycler> items=new ArrayList<>();
    ParkFragAdapter adapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_park_info1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_park);
        adapter=new ParkFragAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //테스트용 대량의 아이템
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));
//        items.add(new ItemRecycler("문정근린공원", "서울특별시 송파구 문정동 18-4", "조경시설 : 바닥분수 초가정자 사각정자 휴게벤치 등 기반시설 : 경화토포장로 마사토산책로 등", "수 목 : 소나무 메타세콰이아 은행나무 등 38종 30966주", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1699", "http://parks.seoul.go.kr/file/info/view.do?fIdx=1537"));

        xmlParsing();
    }

    void xmlParsing(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), "xmlparsing중", Toast.LENGTH_SHORT).show();
            }
        });
        new Thread(){
            @Override
            public void run() {
                // 인증키값
                String apiKey = "4f7154514f7769623938644f646678";
                // REST방식의 url주소
                String address = "http://openAPI.seoul.go.kr:8088/" + apiKey + "/xml/SearchParkInfoService/1/135";

                try {
                    //Stream을 열음
                    URL url = new URL(address);
                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                    XmlPullParser xpp = factory.newPullParser();
                    xpp.setInput(isr);

                    int eventType = xpp.getEventType(); //공원정보 아이템1개 참조변수
                    ItemRecycler item = null;
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        switch (eventType) {
                            case XmlPullParser.START_DOCUMENT:
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), "정보를 가져옵니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;
                            case XmlPullParser.START_TAG:
                                String tagName = xpp.getName();
                                if (tagName.equals("row")) item = new ItemRecycler();
                                else if (tagName.equals("P_PARK")) {
                                    xpp.next();
                                    item.parkName = xpp.getText();
                                } else if (tagName.equals("MAIN_EQUIP")) {
                                    xpp.next();
                                    String equip = xpp.getText();
                                    if (equip == null) item.parkEquip = "시설 정보 없음";
                                    else item.parkEquip = xpp.getText();
                                } else if (tagName.equals("MAIN_PLANTS")) {
                                    xpp.next();
                                    String plant = xpp.getText();
                                    if (plant == null) item.parkPlant = "수목 정보 없음";
                                    else item.parkPlant = xpp.getText();
                                } else if (tagName.equals("P_IMG")) {
                                    xpp.next();
//                                    String pImg = xpp.getText();
//                                    if(pImg==null) item.imgPark="https://data.seoul.go.kr/resources/img/common/logo.png";
//                                    else item.imgPark=pImg;
                                    item.imgPark = xpp.getText();
                                } else if (tagName.equals("P_ADDR")) {
                                    xpp.next();
                                    item.addrPark = xpp.getText();
                                } else if (tagName.equals("TEMPLATE_URL")) {
                                    xpp.next();
                                    String tUrl = xpp.getText();
                                    if (tUrl == null)
                                        item.urlSite = "http://data.seoul.go.kr/dataList/OA-394/S/1/datasetView.do";
                                    else item.urlSite = tUrl;
                                }
                                break;
                            case XmlPullParser.END_TAG:
                                String tagName2 = xpp.getName();
                                if (tagName2.equals("row")) {
                                    items.add(item);
                                }
                                break;
                            case XmlPullParser.TEXT:
                                break;
                        }//switch-case
                        eventType = xpp.next();
                    }//while()

                    getActivity().runOnUiThread(new Runnable() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "parsing종료", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                        }
                    });

                } catch (IOException | XmlPullParserException e) {
                    throw new RuntimeException(e);
                } //try-catch
            }
            }.start();//Thread
    }
}