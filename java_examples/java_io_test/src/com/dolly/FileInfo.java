package com.dolly;

import java.io.File;
import java.util.Date;

/* 파일 정보 : File */
public class FileInfo {

	public static void main(String[] args) {
		String fname = "C:/filetest";
		
		// 1.  정보를 얻기 위한 File 객체 생성
		File f = new File(fname);
		System.out.println(f.getName()); // ReadFlies.java
		System.out.println(f.getPath()); // src\com\dolly\ReadFiles.java 상대경로
		System.err.println(f.getAbsolutePath()); // 절대경로 : 드라이브명:\~~~
		// C:\eclipse\java_io_test\src\com\dolly\ReadFiles.java 
		
		System.out.println("쓰기 " + f.canWrite()); // 파일의 속성이 쓰기 활성화 여부
		// 읽기 전용인 파일은 쓸 수 없음
		System.out.println("읽기 " + f.canRead()); // 파일의 속성이 읽기 활성화 여부
		System.out.println(f.getParent()); // 부모 폴더를 알려줌
		System.out.println("파일 " + f.isFile()); // 지정한 내용이 파일이면 true
		System.out.println("폴더 " + f.isDirectory()); // 지정한 내용이 폴더면 true
		Date date = new Date(f.lastModified()); // 실제 날짜 파악
		System.out.println(f.lastModified()); // 파일의 마지막 수정 날짜 및 시간 (정수로 반환)
		System.out.println(f.length()); // 파일의 크기 (byte)
		
		// 해당 파일 직계만 건드릴 수 있음
		String[] fileList = f.list(); // 지정된 폴더 내의 파일명 리스트 변환
		for (String n: fileList) {
			System.out.println(n + " is Directory: " + (new File(fname + "/" + n).isDirectory()));
		}
		System.out.println(fileList.length);
	} // main() END

} // FileInfo END


//출력 결과
//filetest
//C:\filetest
//C:\filetest
//쓰기 true
//읽기 true
//C:\
//파일 false
//폴더 true
//1710376614530
//0
//animals is Directory: true
//book.txt is Directory: false
//can.txt is Directory: false
//3
