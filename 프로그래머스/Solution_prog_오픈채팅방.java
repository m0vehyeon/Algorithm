package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_오픈채팅방 {
	List<String> result;
    HashMap<String,String> map;
    public String[] solution(String[] record) {
        String[] answer = {};
        result = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] sp = record[i].split(" ");
            StringBuilder sb = new StringBuilder();
            if (sp[0].equals("Enter")) {
                map.put(sp[1],sp[2]);
                sb.append(sp[1]).append("님이 들어왔습니다.");
                result.add(sb.toString());
            } else if (sp[0].equals("Leave")) {
                sb.append(sp[1]).append("님이 나갔습니다.");
                result.add(sb.toString());
            } else if (sp[0].equals("Change")) {
                map.put(sp[1],sp[2]);
            }
        }
        int rLen = result.size();
        answer = result.toArray(new String[0]);
        for (int i = 0; i < rLen; i++) {
            String tmp = result.get(i);
            int idx = tmp.indexOf("님");
            String id = tmp.substring(0,idx);
            answer[i] = answer[i].replace(id,map.get(id));
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
