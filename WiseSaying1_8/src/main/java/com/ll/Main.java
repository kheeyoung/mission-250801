package com.ll;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<WiseDTO> wiseSayingList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String insert = "";
        String commend = "";


        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            try {
                insert = br.readLine();
                commend = insert.substring(0, 2);
            } catch (Exception e) {
                System.out.println("입력 오류: " + e.getMessage());
                continue;
            }
            int lastId = wiseSayingList.isEmpty() ? 1 : wiseSayingList.getLast().get_id() + 1;

            switch (commend) {
                case "종료":
                    System.out.println("프로그램을 종료합니다.");
                    return;

                case "등록":
                    System.out.print("명언 : ");
                    String content = br.readLine();
                    System.out.print("작가 : ");
                    String author = br.readLine();
                    wiseSayingList.add(new WiseDTO(lastId, content, author));
                    break;

                case "목록":
                    if (wiseSayingList.isEmpty()) {
                        System.out.println("등록된 명언이 없습니다.");
                    } else {
                        System.out.println("번호 / 작가 / 명언");
                        System.out.println("----------------------");
                        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                            System.out.println(wiseSayingList.get(i).get_id() + " / " +
                                    wiseSayingList.get(i).get_author() + " / " + wiseSayingList.get(i).get_content());
                        }
                    }
                    break;

                case "수정":
                    int updateNum = findId(insert);
                    if (updateNum == -1) {
                        break;
                    }
                    System.out.print("명언(기존) : " + wiseSayingList.get(updateNum).get_content());
                    wiseSayingList.get(updateNum).set_content(br.readLine());
                    System.out.print("작가(기존) : " + wiseSayingList.get(updateNum).get_author());
                    wiseSayingList.get(updateNum).set_author(br.readLine());
                    break;

                case "삭제":
                    int deleteNum = findId(insert);
                    if (deleteNum == -1) {
                        break;
                    }
                    wiseSayingList.remove(deleteNum);
                    break;

                default:
                    System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
            }
        }
    }


    public static int findId(String command) {
        int num = 0;
        try {
            num = Integer.parseInt(command.split("=")[1]);
            for (int i = 0; i < wiseSayingList.size(); i++) {
                if (wiseSayingList.get(i).get_id() == num) {
                    return i; // 해당 ID의 인덱스 반환
                }

            }
            System.out.println(num + "번 명언은 존재하지 않습니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 아닙니다. 명령어?id=숫자 형식으로 입력해주세요!");
        } catch (Exception e) {
            System.out.println("명령어 형식이 잘못되었습니다. 명령어?id=숫자 형식으로 입력해주세요.");
        }
        return -1; // 잘못된 ID 처리
    }
}