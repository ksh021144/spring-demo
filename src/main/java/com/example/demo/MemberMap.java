package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MemberMap {
	private static Map<String, MemberDTO> memMap = new LinkedHashMap<>();

	private MemberMap() {
	}

	public static MemberDTO getMember(String id) {
		return memMap.get(id);
	}

	public static int addMember(MemberDTO newMember) {
		if (memMap.containsKey(newMember.getId())) {
			return 0;
		}
		memMap.put(newMember.getId(), newMember);
		return 1;
	}

	public static int deleteMember(String id) {
		if (memMap.remove(id) == null) {
			return 0;
		}
		return 1;
	}

	public static int editMember(MemberDTO newMember) {
		if (!memMap.containsKey(newMember.getId())) {
			return 0;
		}
		memMap.put(newMember.getId(), newMember);
		return 1;
	}

	public static ArrayList<MemberDTO> getMemberList() {
		return new ArrayList<>(memMap.values());
	}
}
