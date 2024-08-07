package org.zerock.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@GetMapping("basic")
	public void basicGet() {
		log.info("basic");
	}

	@GetMapping("ex01")
	public String ex01(SampleDTO dto) {
		log.info("ex01::");
		log.info("dto: " + dto);
		return "ex01";
	}

	@GetMapping("ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("이름: " + name);
		log.info("나이: " + age);
		return "ex02";

	}

	@GetMapping("ex03")
	public String ex03(RedirectAttributes rttr) {
		rttr.addAttribute("name", "bbb");
		rttr.addAttribute("age", "30");
		rttr.addAttribute("page",100);
		return "redirect:/sample/ex04";
	}

	@GetMapping("ex04")
	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("ex04----------------");
		log.info("dto: " + dto);
		log.info("dto: " + page);
		return "ex04";
	}
	
	@GetMapping("ex05")
	public void ex05() {
		log.info("ex05-------------");
	}
	
	@GetMapping("ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setName("길동 홍");
		dto.setAge(20);
		
		return dto; //json
	}
	
	@GetMapping("ex07")
	public ResponseEntity<List<SampleDTO>> ex07(){
		log.info("ex07-------------------");
//		String msg = "{\"name\":\"홍길동\"}";
		List<SampleDTO> listDTO = new ArrayList<SampleDTO>();
		
		SampleDTO dto = new SampleDTO();
		dto.setName("길동 홍");
		dto.setAge(20);
		
		SampleDTO dto1 = new SampleDTO();
		dto1.setName("길동 홍1");
		dto1.setAge(21);
		
		listDTO.add(dto);
		listDTO.add(dto1);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type","application/json;charset=UTF-8");
		return new ResponseEntity<>(listDTO,header,HttpStatus.OK);
		
	}
}
