package FileClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class FileClass {
    //  깊이만큼 공백추가
    static String depthLevel(int level) {
        String space = "";
        for (int k = 0; k < level; k++) {
            space += "  ";
        }
        return space;
    }

    // 폴더및 파일 목록 리스트, 최상위폴더 깊이 = 1
    static List<String> folderList(String dirPath, int depthLevel) {
//        저장할 문자열
        List<String> outputList = new ArrayList<>();

        File dir = new File(dirPath);
        File[] contents = dir.listFiles();

        for (File content : contents) {
            if (content.isDirectory() == true) {
                outputList.add(depthLevel(depthLevel) + "📁" + content.getName());
                outputList.addAll(folderList(content.getPath(), depthLevel + 1));
            } else {
                outputList.add(depthLevel(depthLevel) + "📄" + content.getName());
            }
        }
        return outputList;
    }

    //    파일목록 리스트의 .txt파일 생성
    //    매개변수 : 탐색할 폴더경로, 목록을 저장할 파일명, 저장 경로
    static void createFileList(String searchDirPath, String fileName, String saveDirPath) {
        File searchDir = new File(searchDirPath);
        File saveDir = new File(saveDirPath);
        File saveFile = new File(saveDirPath + fileName + ".txt");
        List<String> contents = new ArrayList<>();

        if (saveFile.exists() == true) {
            saveFile.delete();
        }
        try {
            saveFile.createNewFile();
            Writer writer = new FileWriter(saveFile.getPath());
            BufferedWriter bw = new BufferedWriter(writer);
            contents.add("📁" + searchDir.getName());
            contents.addAll(folderList(searchDirPath, 1));
            for (String content : contents) {
                bw.write(content + "\n");
            }
            bw.flush();
            bw.close();
            writer.close();
            System.out.println("파일 생성이 완료되었습니다.");
        } catch (Exception e) {
            System.out.println("파일 생성에 실패하였습니다.");
        }
    }

    public static void main(String[] args) throws Exception {
        String searchDirPath = "C:/python39";
        String fileName = "폴더 목록";
        String saveDirPath = "C:/Users/Chanu/Desktop/Temp/";

        createFileList(searchDirPath, fileName, saveDirPath);

    }
}
