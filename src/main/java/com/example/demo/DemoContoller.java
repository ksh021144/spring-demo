package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class DemoContoller {

	@PostMapping("/member")
	@ApiOperation("멤버 등록")
	private ResponseEntity<Map<String, Object>> registerMember(@RequestBody MemberDTO dto) {
		Map<String, Object> map = new HashMap<>();
		int ret = MemberMap.addMember(dto);
		if (ret == 1) {
			map.put("resvalue", "1");
			map.put("message", "등록 성공");
		} else {
			map.put("resvalue", "0");
			map.put("message", "등록 실패");
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@GetMapping("/member/{id}")
	@ApiOperation("멤버 조회")
	private ResponseEntity<Map<String, Object>> getMember(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<>();
		MemberDTO info = MemberMap.getMember(id);
		if (info != null) {
			map.put("message", "정보 조회 성공");
			map.put("info", info);
		} else {
			map.put("message", "정보 조회 실패");
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@GetMapping("/member")
	@ApiOperation("전체 멤버 조회")
	private ResponseEntity<Map<String, Object>> getAllMember() {
		Map<String, Object> map = new HashMap<>();
		ArrayList<MemberDTO> ret = MemberMap.getMemberList();
		map.put("message", "전체 멤버 조회 성공");
		map.put("members", ret);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@PutMapping("/member/{id}")
	@ApiOperation("멤버 수정")
	private ResponseEntity<Map<String, Object>> editMember(@RequestBody MemberDTO newMember) {
		Map<String, Object> map = new HashMap<>();
		int ret = MemberMap.editMember(newMember);
		if (ret == 1) {
			map.put("message", "수정 성공");
		} else {
			map.put("message", "수정 실패");
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@DeleteMapping("/member/{id}")
	@ApiOperation("멤버 탈퇴")
	private ResponseEntity<Map<String, Object>> deleteMember(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<>();
		int ret = MemberMap.deleteMember(id);
		if (ret == 1) {
			map.put("message", "탈퇴 완료");
		} else {
			map.put("message", "탈퇴 실패");
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}
