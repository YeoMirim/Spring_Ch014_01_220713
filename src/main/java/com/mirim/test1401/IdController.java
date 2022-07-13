package com.mirim.test1401;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IdController {

	@RequestMapping(value="/", produces="text/plain;charset=UTF-8")  // controller���� root�� �ɾ�ξ��� ������ �ٷ� ȭ���� ��
	public String index() {
		
		return "index";
	}
	
/*
	@RequestMapping("/idoutput")
	public String idoutput(@RequestParam("id") String id, Model model) {
		
		model.addAttribute("id", id);
		
		return "idoutput";
	}
*/	
	
	@RequestMapping(value="/idoutput", method = RequestMethod.GET)	// index.jsp���� ������ GET������� ����
	public String idoutput(@RequestParam("id") String id, Model model) {
		
		System.out.println("GET ��� ����");
		model.addAttribute("id", id);
		
		return "idoutput";
	}
	
	@RequestMapping(value="/idoutput", method = RequestMethod.POST)	// index.jsp���� ������ POST������� ����
	public String idoutput(HttpServletRequest request, Model model) {  // �����ε���
		
		System.out.println("POST ��� ����");
		String id = request.getParameter("id");
		model.addAttribute("id", id);
		
		return "idoutput";
	}	// index.jsp ���Ͽ��� post ������� ���´µ� controller�� post����� RequestMapping�� ���ٸ� 405������ �߻���
	
	@RequestMapping("/join")
	public String join() {
		
		
		return "join";
	}
	
	@RequestMapping("/joinOk")
	public String joinOk(@ModelAttribute("sInfo") StudentInformationThird studentInformationThird) { // �ҷ�����  class���� ��� ������
		
		return "joinOk";
	}

}
